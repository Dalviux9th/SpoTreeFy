import java.io.IOException;
import java.io.ObjectOutputStream;

public class SubListaCanciones {
    // Sub-lista de canciones: Lista simple sin orden. Sus nodos poseen: puntero al siguiente y puntero a la Canción (ArbCanciones).

    private NodoSubCan primero;

    public SubListaCanciones() {
        this.primero = null;
    }

    // Metodos...

    public boolean existeCancion(String Cancion){
        NodoSubCan Actual = primero;
        while(Actual != null && !Cancion.equals(Actual.getCancion().getTitulo())){
            Actual = Actual.getSiguiente();
        }

        if (Actual != null) {
            return true;
        } else {
            return false;
        }
    }

    public void agregarCan(NodoCancion Cancion) {
        NodoSubCan nuevoNodo = new NodoSubCan(Cancion);
        if (primero == null) {
            primero = nuevoNodo;
        } else {
            nuevoNodo.setSiguiente(primero.getSiguiente());
            primero.setSiguiente(nuevoNodo);
        }
    }

    public void Serializar(String user, String playlist, ObjectOutputStream out) throws IOException {
        NodoSubCan actual = primero;
        String[] serial = new String[3];
        serial[0] = user;
        serial[1] = playlist;

        while (actual != null) {
            serial[2] = actual.getCancion().getTitulo();

            out.writeObject(serial);
        }
    }

}