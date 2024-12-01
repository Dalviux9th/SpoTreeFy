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

        public void borrarL_propia(String Playlist){
            if(primero.getPlaylist().compareTo(Playlist) == 0){
                primero = primero.getSiguiente();
            }else{

                NodoPropias Actual, Anterior;
                Actual = primero.getSiguiente();
                Anterior = primero;
                while( Actual.getPlaylist().compareTo(Playlist) != 0){
                    Anterior = Actual;
                    Actual = Actual.getSiguiente();
                } 
                    if(Actual.getPlaylist().compareTo(Playlist) == 0){
                        //revisar posible error por Actual == null;
                        Anterior.setSiguiente(Actual.getSiguiente());
                        System.out.println("lista eliminada");
                    }else{
                        System.out.println("la lista a eliminar no existe");
                    }
            }
            

        }
    
}

