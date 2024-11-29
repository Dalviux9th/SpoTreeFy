public class NodoPropias {
    //clase NodoPropias

    private String Playlist;
    private transient NodoPropias Siguiente;
    //puntero hacia la primera cancion de la lista ( Sub ListaCanciones )
    private transient NodoPropias Canciones;

    //constructor
    public NodoPropias(String Playlist){
        this.Playlist = Playlist;
        this.Siguiente = null;
        this.Canciones = null;
    }

    public String getCanciones(){
        return this.Canciones;
    }

    public void setCanciones( ){
        this.Playlist = Playlist;
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
}
