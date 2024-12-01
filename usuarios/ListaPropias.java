import java.io.IOException;
import java.io.ObjectOutputStream;

public class ListaPropias {
    // clase listas propias
    private NodoPropias primero;
    
    //constructor
        public ListaPropias(){
           this.primero = null;
        }

        public boolean existeLista(String NuevaLista){
            NodoPropias Actual = primero;
            boolean devolver = false;
            while( Actual != null && !Actual.getPlaylist().equals(NuevaLista)){
                Actual = Actual.getSiguiente();
            }
            if( Actual.getPlaylist() == NuevaLista){
                devolver = true;
            }else{
                devolver = false;
            }
                
            return devolver;
            
        }

        public NodoPropias verNodopropias(String Playlist){
            // Devuelve un nodo de listas propias dado el titulo de la Playlist.
            NodoPropias Actual = primero;
            while(Actual != null && !Playlist.equals(Actual.getPlaylist())){
                Actual = Actual.getSiguiente();
            }
            return Actual;
        }

        public void agregarListaPropia(String NuevaLista){
            NodoPropias NuevaPlaylist = new NodoPropias(NuevaLista);
            NodoPropias Actual, Anterior;
            Anterior = primero;
            if(Anterior == null || Anterior.getPlaylist().compareTo(NuevaLista) > 0){
                NuevaPlaylist.setSiguiente(Anterior);
                primero = NuevaPlaylist;
            }else{
                Actual = Anterior.getSiguiente();
                while(Actual.getPlaylist().compareTo(NuevaLista) < 0 && Actual != null){
                    Actual = Actual.getSiguiente();
                    Anterior = Anterior.getSiguiente();
                }
                Anterior.setSiguiente(NuevaPlaylist);
                NuevaPlaylist.setSiguiente(Actual);
            }


        }

        public void Serializar(String nombreUsu, ObjectOutputStream out) throws IOException {
            NodoPropias actual = primero;
            while (actual != null) {
                actual.getSubLista().Serializar(nombreUsu, actual.getPlaylist(), out);

                actual = actual.getSiguiente();
            }
        }
}
