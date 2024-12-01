public class NodoSeguidos {
    private String nombreUsuario;
    private String nombreLista;
    private NodoSeguidos Siguiente;

    public NodoSeguidos( String nombreLista, String nombreUsuario){
        this.nombreLista = nombreLista;
        this.nombreUsuario = nombreUsuario;
        this.Siguiente = null;
    }

    public NodoSeguidos getSiguiente(){
        return this.Siguiente;
    }

    public void setSiguiente( NodoSeguidos Siguiente){
        this.Siguiente = Siguiente;
    }
    
    public String getNombreUsuario(){
        return this.nombreUsuario;
    }

    public void setNombreUsuario( String nombreUsuario){
        this.nombreUsuario = nombreUsuario;
    }

    public String getNombreLista(){
        return this.nombreLista;
    }

    public void setNombreLista( String nombreLista){
        this.nombreLista = nombreLista;
    }

    //simple ordenada por nombre de usuario
    //nombreUsuario8, Nombrelista8.

}