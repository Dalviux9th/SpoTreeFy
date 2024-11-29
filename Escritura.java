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
        this.RUTA_USUARIOS = RUTA_GUARDADO + "-ArchUsuarios";
        this.RUTA_CANCIONES = RUTA_GUARDADO + "-ArchCanciones";
        this.RUTA_L_PROPIAS = RUTA_GUARDADO + "-ArchListasPropias";
        this.RUTA_L_SEGUIDAS = RUTA_GUARDADO + "-ArchListasSeguidas";
    }

    public boolean guardarTodo(ArbolUsers usuarios, ArbolCanciones canciones) {
        boolean exito = false;
        int intentos = 0;

        while (!exito && intentos <= 3) {

            try {

                if (usuarios.Serializar(RUTA_USUARIOS) /*&& saveCanciones() && savePropias() && saveSeguidas()*/) {
                    exito = true;
                } else {
                    intentos ++;
                }

            } catch (IOException e) {
                intentos++;
                e.printStackTrace();
                System.out.println("Hubo un error al guardar; Reintentando...");
            }

        }

        return exito;
    }
}
