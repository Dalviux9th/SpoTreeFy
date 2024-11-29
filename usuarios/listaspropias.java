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
            while( Actual != null && Actual.getPlaylist() != NuevaLista){
                Actual = Actual.getSiguiente();
            }
            if( Actual.getPlaylist() == NuevaLista){
                devolver = true;
            }else{
                devolver = false;
            }
                
            return devolver;
            
        }
}
