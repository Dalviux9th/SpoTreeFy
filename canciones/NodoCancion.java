public class NodoCancion {
    // Clase Nodo del ArbolCanciones. Tiene dos punteros (del arbol) y un tercero que apunta a la siguiente del autor (circular).
    
    private String titulo;
    private transient NodoCancion anterior;
    private transient NodoCancion posterior;
    private transient NodoCancion sigAutor;

    //Constructor
    public NodoCancion(String titulo){
        if (titulo.length() <= 30 && titulo.length() > 0)
        this.titulo = titulo;
        this.anterior = null;
        this.posterior = null;
        this.sigAutor = null;

    }

    //Getters y Setters     -----------

    public NodoCancion getAnterior(){
        return this.anterior;
    }

    public void setAnterior( NodoCancion nuevoNodo){
        this.anterior = nuevoNodo;

    }

    public NodoCancion getPosterior(){
        return this.posterior;
    }

    public void setPosterior( NodoCancion nuevoNodo){
        this.posterior = nuevoNodo;
    }

    public NodoCancion getSigAutor() {
        return this.sigAutor;
    }
}
