public class NodoCancion {
    private transient NodoCancion anterior; 
    private transient NodoCancion posterior; 
    private String titulo;

    //constructor
    public NodoCancion( String titulo){
        this.titulo = titulo;
        this.anterior = null;
        this.posterior = null;

    }
    //gets y sets 

    public NodoCancion getanterior(){
        return this.anterior;
    }

    public void setanterior( NodoCancion newAnterior){
        this.anterior = newAnterior;

    }

    public NodoCancion getposterior(){
        return this.posterior;
    }

    public void setposterior( NodoCancion newPosterior){
        this.anterior = newPosterior;

    }
}
