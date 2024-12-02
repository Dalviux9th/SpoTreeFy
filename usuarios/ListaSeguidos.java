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

    public void NuevoSeguido(String NombreUsuario, String Nombreplaylist){
        NodoSeguidos Actual = primero;

        while( (Actual.getNombreUsuario().compareTo(NombreUsuario) != 0 || Actual.getNombreLista().compareTo(Nombreplaylist) != 0) && Actual != null){
            Actual = Actual.getSiguiente();
        }
            if( Actual == null){
                agregarListaSeguidos(NombreUsuario,Nombreplaylist);
            }else{
                System.out.println("la lista ya existe en Listas seguidas");
            }
    }

    public void agregarListaSeguidos( String NombreUsuario, String NuevaLista){
        NodoSeguidos NuevaPlaylist = new NodoSeguidos(NuevaLista, NombreUsuario);
        NodoSeguidos Actual, Anterior;
        Anterior = primero;
        if(Anterior == null || Anterior.getNombreUsuario().compareTo(NombreUsuario) > 0){
            NuevaPlaylist.setSiguiente(Anterior);
            primero = NuevaPlaylist;
        }else{
            Actual = Anterior.getSiguiente();
            while(Anterior.getNombreUsuario().compareTo(NombreUsuario) < 0 && Actual != null){
                Actual = Actual.getSiguiente();
                Anterior = Anterior.getSiguiente();
            }
            if(Actual.getNombreUsuario().compareTo(NombreUsuario) == 0){

                while(Actual.getNombreLista().compareTo(NuevaLista) < 0 && Actual != null){
                    Actual = Actual.getSiguiente();
                }   Anterior = Anterior.getSiguiente();
            }
            Anterior.setSiguiente(NuevaPlaylist);
            NuevaPlaylist.setSiguiente(Actual);
        }


    }
}
