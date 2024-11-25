// IMPORTANTE! al generar el método serializador, agregar el titulo de la cancion (para despues revincular al deserializar)
public class NodoAutor {
    //Clase Nodo de la lista de autores.
    
    private String nombreAutor;
    private transient NodoAutor siguiente;
    private transient NodoCancion primeraCancion;

    // Constructor
    public NodoAutor(String nombreAutor, NodoCancion cancion) {
        this.nombreAutor = nombreAutor;
        this.siguiente = null;
        this.primeraCancion = cancion;
    }

    // Getters y setters    -----------

    public NodoAutor getSiguiente() {
        return this.siguiente;
    }

    public NodoCancion getCancion() {
        return this.primeraCancion;
    }

    public String getNombreAutor() {
        return this.nombreAutor;
    }

    public void setSiguiente(NodoAutor nodo) {
        this.siguiente = nodo;
    }

}
