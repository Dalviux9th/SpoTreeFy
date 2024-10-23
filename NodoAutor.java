public class NodoAutor {
    //clase Nodo Autores
    private String Autores;
    private transient  NodoAutor siguiente;
    private transient NodoAutor puntArbolcancion;
// constructor
    public NodoAutor( String Autores){
        this.Autores = Autores;
        this.siguiente = null;
        this.puntArbolcancion = null;

    }

}
