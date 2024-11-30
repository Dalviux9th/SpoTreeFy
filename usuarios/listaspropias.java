public class ListasPropias {
    // clase listas propias
    private NodoPropias primero;
    
    //constructor
        public ListasPropias(){
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
            NodoPropias Actual = primero;
            while(Actual.getPlaylist() != Playlist && Actual != null){
                Actual = Actual.getSiguiente();
            }
            return Actual;
        }

        public void Sublista(NodoPropias grupo, String cancion){
            grupo.AccesoSubLista(cancion);
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
}
