public class NodoPropias {
    //clase NodoPropias

    private String Playlist;
    private transient NodoPropias Siguiente;
    //puntero hacia la primera cancion ( Sub ListaCanciones )
    private SubListaCanciones subLista;

    //constructor
    public NodoPropias(String Playlist){
        this.Playlist = Playlist;
        this.Siguiente = null;
        this.subLista = new SubListaCanciones();
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

    public SubListaCanciones getSubLista() {
        return subLista;
    }

}
