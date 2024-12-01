public class NodoPropias {
    //clase NodoPropias

    private String Playlist;
    private transient NodoPropias Siguiente;
    //puntero hacia la primera cancion de la lista ( Sub ListaCanciones )
    private transient SubListaCanciones Canciones;

    //constructor
    public NodoPropias(String Playlist){
        this.Playlist = Playlist;
        this.Siguiente = null;
        this.Canciones = new SubListaCanciones();
    }

    public SubListaCanciones getCanciones(){
        return this.Canciones;
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



    public void AccesoSubLista(String Cancion){
        if(getCanciones().existeCancion(Cancion)){
            System.out.println("la cancion ya existe en la Playlist");

        }else{
            getCanciones().agregarCan(Cancion);
            System.out.println("cancion agregada a la Playlist");

        }

        }
    }
}
