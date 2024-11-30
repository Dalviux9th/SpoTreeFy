import java.io.IOException;
// Archivo central de guardado de estructuras. Para modificar las rutas, ver constructor de esta clase.

public class Escritura {
    /*
     1- [ArchUsuarios]: info de Usuario. Dde ArbUsuarios, recorriéndolo en PreOrder.
     2- [ArchCanciones]: info Canción: Título y Nombre del Autor. A partir de ListaAutores y ArbCanciones.
     3- [ArchListasPropias]: Nombre de Usuario(string8), Nombre de Lista(string8) y título de canción(string30).
     4- [ArchListasSeguidas]: Nombre Usuario(string8), nombre de Usuario seguido[string8] y nombre de lista[string8].
     */

    private final String RUTA_USUARIOS;
    private final String RUTA_CANCIONES;
    private final String RUTA_L_PROPIAS;
    private final String RUTA_L_SEGUIDAS;

    public Escritura(String RUTA_GUARDADO) {
        this.RUTA_USUARIOS = RUTA_GUARDADO + "-ArchUsuarios.save";
        this.RUTA_CANCIONES = RUTA_GUARDADO + "-ArchCanciones.save";
        this.RUTA_L_PROPIAS = RUTA_GUARDADO + "-ArchListasPropias.save";
        this.RUTA_L_SEGUIDAS = RUTA_GUARDADO + "-ArchListasSeguidas.save";
    }

    public boolean guardarTodo(ArbolUsers usuarios, ListaAutores autores) {
        boolean exito = false;
        int intentos = 0;

        while (!exito && intentos <= 3) {

            try {

                usuarios.Serializar(RUTA_USUARIOS);
                autores.Serializar(RUTA_CANCIONES);
                // savePropias();
                // saveSeguidas();
                
                exito = true;   // Si todos los procesos terminan sin error, considero estado de exito.

            } catch (IOException e) {

                intentos++;
                System.out.println("Hubo un error al guardar; Reintentando...");
                e.printStackTrace();

            }

        }

        return exito;
    }

    public boolean leerTodo(ArbolUsers usuarios, ArbolCanciones canciones) {
        return true;
    }
}
