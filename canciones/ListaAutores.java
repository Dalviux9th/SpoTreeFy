public class ListaAutores {
    //Lista de autores, que debe estar ordenada por nombre de autor. Cada nodo apunta a una lista circular en el árbol de canciones.
    
    private NodoAutor primero;

    // Constructor
    public ListaAutores(){
        this.primero = null;
    }

    // Métodos de la lista  -----------

    public boolean autorExiste(String autor) {
    // Busca un nodo por nombre de autor. Si existe devuelve TRUE, si no FALSE.
        boolean existe = false;
        NodoAutor actual = primero;

        while ( actual != null && !existe ) {
            if (autor.equals(actual.getNombreAutor())) {
                existe = true;
            } else {
                actual = actual.getSiguiente();
            }
        }

        return existe;
    }

    public void insertarAutor(String nombreAutor, NodoCancion cancion) {
    // Toma un nombre de autor y un titulo de cancion. Inserta el autor y le asigna su primera cancion
        NodoAutor nuevoNodo = new NodoAutor(nombreAutor, cancion);
        cancion.setSigAutor(cancion);           // Esta solo por lo cual apunta a si mismo (lista circular)

        if (this.primero == null) {            // CASO lista vacia
            this.primero = nuevoNodo;

        } else {                               // Si no está vacia ---
            if (nombreAutor.compareTo(primero.getNombreAutor()) < 0) {  // Si es alfabeticamente anterior al primero.
                
                nuevoNodo.setSiguiente(primero);
                this.primero = nuevoNodo;
            
            } else {

                NodoAutor actual = primero.getSiguiente();
                NodoAutor anterior = primero;

                while (actual != null && actual.getNombreAutor().compareTo(nombreAutor) < 0) {
                    anterior = actual;
                    actual = actual.getSiguiente();
                }

                if (!nombreAutor.equals(actual.getNombreAutor())) {     // Si no existe el autor lo añade
                    nuevoNodo.setSiguiente(actual);
                    anterior.setSiguiente(nuevoNodo);
                }
            }
        }
    }
}