public class NodoPropias {
    //clase NodoPropias

    private String Nombre;
    private transient NodoPropias Siguiente;
    //puntero hacia la primera cancion de la lista ( Sub ListaCanciones )
    private transient NodoPropias canciones;

    //constructor
    public NodoPropias(String Nombre){
        this.Nombre = Nombre;
        
    }

}
