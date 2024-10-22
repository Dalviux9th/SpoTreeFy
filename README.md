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

Las opciones a las que se tiene acceso en este nivel son:
- Agregar una canción: Pide el Título y el Autor, verifica que el título no exista (si existe no hace nada), agrega la canción al árbol y a la lista del Autor (que si no existía también lo agrega).
- Crear una lista de reproducción propia: Solicita el nombre de la playlist, verifica que no exista para este usuario y si es así la crea vacía (sin canciones).
- Agregar una canción por título a una lista de reproducción propia: Solicita el nombre de la playlist y el título de la canción, verifica que ambas existan (en la lista y en el árbol, además que la canción ya no esté en esa lista) y si esto se cumple la agrega.
- Agregar una canción por autor a una lista de reproducción propia: Solicita el nombre de la playlist y el nombre del autor. Lista todas las canciones de ese autor, luego solicita el título de la canción y la agrega a la lista si aún no existe.
- Eliminar una lista de reproducción propia: Solicita el nombre de la playlist, la elimina con todas las suscripciones a canciones que tenga.
- Incluir la lista de otro usuario (seguirlo): Solicita el nombre del usuario a seguir, verifica que exista y muestra todas sus listas ordenadas alfabéticamente a modo de ayuda. Luego el usuario ingresa el nombre de la PlayList a seguir y se agrega si aún no la tiene. 
- Salir al menú de primer nivel.

