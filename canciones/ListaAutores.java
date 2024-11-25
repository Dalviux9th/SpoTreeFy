public class ListaAutores {
    //Lista de autores, que debe estar ordenada por nombre de autor. Cada nodo apunta a una lista circular en el árbol de canciones.
    
    private NodoAutor primero;

    // Constructor
    public ListaAutores(){
        this.primero = null;
    }

    // Métodos de la lista  -----------

    public boolean autorExiste(String autor) {
        boolean existe = false;
        // Devuelve true si el autor ya existe en la lista.
        return existe;
    }

    public void insertarAutor(NodoAutor nuevoNodo) {
        if (this.primero == null) {            // CASO lista vacia
            this.primero = nuevoNodo;
        } else {                               // Si no está vacia ---

            NodoAutor actual = primero.getSiguiente();
            NodoAutor anterior = primero.getSiguiente();
            if ()
        }
    }
}
