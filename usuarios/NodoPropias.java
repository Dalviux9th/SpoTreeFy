public class NodoPropias {
    //clase NodoPropias

    private String Playlist;
    private transient NodoPropias Siguiente;
    //puntero hacia la primera cancion ( Sub ListaCanciones )
    private NodoSubCan primeraCan;

    //constructor
    public NodoPropias(String Playlist){
        this.Playlist = Playlist;
        this.Siguiente = null;
    }


    public NodoPropias getSiguiente(){
        return this.Siguiente;
    }

    public void setSiguiente( NodoPropias Siguiente){
        this.Siguiente = Siguiente;
    }

    public String getPlaylist(){
        return this.Playlist;
    }

    public void setPlaylist( String Playlist){
        this.Playlist = Playlist;
    }

    // Métodos de la playlist
    public boolean existeCancion(String Cancion){
        NodoSubCan Actual = primeraCan;
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
        if (primeraCan == null) {
            primeraCan = nuevoNodo;
        } else {
            nuevoNodo.setSiguiente(primeraCan.getSiguiente());
            primeraCan.setSiguiente(nuevoNodo);
        }
    }
}
