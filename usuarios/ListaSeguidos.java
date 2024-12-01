import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class ListaSeguidos {
    private NodoSeguidos primero;

    public ListaSeguidos(){
        this.primero = null;
    }

    public void Serializar(String user, ObjectOutputStream out) throws IOException {
        String[] serial = new String[3];
        serial[0] = user;
        NodoSeguidos actual = primero;

        while (actual != null) {
            serial[1] = actual.getNombreUsuario();
            serial[2] = actual.getNombreLista();

            out.writeObject(serial);
            actual = actual.getSiguiente();
        }
    }
}
