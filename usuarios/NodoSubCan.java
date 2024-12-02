public class NodoSubCan{
    private NodoCancion cancion; //puntero a la cancion (arbol canciones)
    private NodoSubCan siguiente; // sin orden definido

    public NodoSubCan(NodoCancion cancion){
        this.cancion = cancion;
        this.siguiente = null;
    }

    public NodoCancion getCancion() {
        return cancion;
    }

    public NodoSubCan getSiguiente() {
        return siguiente;
    }

    public void setCancion(NodoCancion cancion) {
        this.cancion = cancion;
    }

    public void setSiguiente(NodoSubCan siguiente) {
        this.siguiente = siguiente;
    }
}