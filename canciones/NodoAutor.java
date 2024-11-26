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
    
    public void setSiguiente(NodoAutor nodo) {
        this.siguiente = nodo;
    }

    public NodoCancion getCancion() {
        return this.primeraCancion;
    }

    public void setCancion(NodoCancion primeraCancion) {
        this.primeraCancion = primeraCancion;
    }

    public String getNombreAutor() {
        return this.nombreAutor;
    }

    public boolean setNombreAutor(String nombreAutor) {
    // SI el nombre cumple los requerimientos, se añade y se devuelve TRUE. Si NO, devuelve FALSE.
        boolean resultado = false;

        if (nombreAutor.length() > 0 && nombreAutor.length() <= 8) {
            this.nombreAutor = nombreAutor;
            resultado = true;
        }
        
        return resultado;
    }

}
