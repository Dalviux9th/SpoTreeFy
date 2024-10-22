# SpoTreeFy
Tu reproductor amigo! Sumate al movimiento SpoTreeFy!!

Spotreefy es un sistema que permite gestionar la información de música y canciones para múltiples usuarios incluyendo listas de reproducción (playlist) y seguidores.
El sistema, al comenzar su ejecución levanta toda la información que posee en archivos a estructuras de memoria y luego tiene un menú de 2 niveles.

### Menú Principal
- Login: inicio de sesión con Nombre de usuario y su password. Lleva al segundo nivel de menú para ese usuario.
- Nuevo Usuario: Pide Nombre, un password y crea un nuevo usuario en **ArbUsuarios**. Deberá comprobarse que el Nombre ingresado no exista previamente en el sistema y que la password tenga *al menos seis caracteres*.
- Ver Usuarios existentes: esta opción muestra el listado completo en orden alfabético de los usuarios existentes.
- Salir: esta opción termina la ejecución del programa, volcando previamente toda la información a sus archivos.

Al segundo nivel de menú, se accede luego de ejecutar exitosamente la opción de Login.
Esta pantalla muestra información de la cuenta del usuario y le da las opciones de comandos que puede ejecutar. 
La información que se muestra es: Nombre del usuario logueado, listas de reproducción propias (ordenadas alfabéticamente) y listas seguidas, ordenadas alfabéticamente por nombre de usuario y de lista.

### Menu de usuario
Las opciones a las que se tiene acceso en este nivel son:
- Agregar una canción: Pide el Título y el Autor, verifica que el título no exista (si existe no hace nada), agrega la canción al árbol y a la lista del Autor (que si no existía también lo agrega).
- Crear una lista de reproducción propia: Solicita el nombre de la playlist, verifica que no exista para este usuario y si es así la crea vacía (sin canciones).
- Agregar una canción por título a una lista de reproducción propia: Solicita el nombre de la playlist y el título de la canción, verifica que ambas existan (en la lista y en el árbol, además que la canción ya no esté en esa lista) y si esto se cumple la agrega.
- Agregar una canción por autor a una lista de reproducción propia: Solicita el nombre de la playlist y el nombre del autor. Lista todas las canciones de ese autor, luego solicita el título de la canción y la agrega a la lista si aún no existe.
- Eliminar una lista de reproducción propia: Solicita el nombre de la playlist, la elimina con todas las suscripciones a canciones que tenga.
- Incluir la lista de otro usuario: Solicita el nombre del usuario a seguir, verifica que exista y muestra todas sus listas ordenadas alfabéticamente a modo de ayuda. Luego el usuario ingresa el nombre de la PlayList a seguir y se agrega si aún no la tiene. 
- Salir al menú de primer nivel.

## Estructuras
El sistema está implementado utilizando las siguientes estructuras:
- [ArbUsuarios]: Es un árbol binario de usuarios que contiene en cada nodo: Nombre de Usuario (string8), password (string8). Este árbol está ordenado alfabéticamente por el Nombre. Además cada nodo posee: ListasPropias(puntero ListasPropias) y ListasSeguidos[puntero ListasSeguidos].
- [ArbCanciones]: Es un árbol binario de canciones que contiene en cada nodo: Título de la canción (string30) ordenados por Titulo. Además de los dos punteros requeridos por el árbol, cada nodo posee un puntero más a otro nodo del mismo árbol que forma una lista circular de todas las canciones del mismo autor.
- [ListaAutores]: Es una lista simple de autores de canciones en la que cada nodo posee: Nombre del autor(string8), puntero al siguiente autor y puntero a Canción(ArbCanciones). La lista está ordenada por el nombre del autor. Se considera que una canción sólo posee un *único autor*.
- [ListasPropias]: Lista simple ordenada alfabéticamente cuyos nodos poseen el Nombre de la Lista(string8) y además del puntero para armar la lista, sólo poseen un puntero a la lista de canciones correspondiente (SubListaCanciones).
- [SubListaCanciones]: Lista simple sin orden en la que cada nodo posee además del puntero necesario al siguiente nodo, un puntero a la Canción (ArbCanciones).
- [ListasSeguidos]: Lista simple, ordenada alfabéticamente por nombre del Usuario y para el mismo usuario por nombre de la lista. Cada nodo de la lista posee NombreUsuario(string8) y NombreLista(string8).

## Archivos de persistencia
- [ArchUsuarios]: cada registro de este archivo contiene la información de un Usuario, Nombre y Password. Este archivo se genera a partir de ArbUsuarios, recorriéndolo en PreOrder.
- [ArchCanciones]: cada registro de este archivo contiene la información de una Canción: Título y Nombre del Autor.  Este archivo se genera a partir de la lista ListaAutores y el árbol ArbCanciones
- [ArchListasPropias]: Cada registro contiene nombre de Usuario(string8), Nombre de Lista(string8) y título de canción(string30).
- [ArchListasSeguidas]: Cada registro posee nombre de Usuario(string8), nombre de Usuario seguido[string8] y nombre de lista[string8].

## FIN
