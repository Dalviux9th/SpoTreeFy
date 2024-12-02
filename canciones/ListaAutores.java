import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ListaAutores {
    //Lista de autores, que debe estar ordenada por nombre de autor. Cada nodo apunta a una lista circular en el árbol de canciones.
    
    private NodoAutor primero;

    // Constructor
    public ListaAutores(){
        this.primero = null;
    }

    // Métodos de la lista  -----------

    public NodoAutor getPrimero() {
        return this.primero;
    }

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

    public NodoAutor buscarAutor(String nombreAutor) {
    // Devuelve un nodo de autor si lo encuentra o NULL si no existe en la lista.
        NodoAutor actual = this.primero;

        while ( actual != null && !nombreAutor.equals(actual.getNombreAutor()) ) {
            actual = actual.getSiguiente();
        }

        return actual;
    }

    public void Serializar(String RUTA_GUARDADO) throws IOException {
        //Recorre la lista de autores archivando cada autor y sus canciones.

        FileOutputStream fileOut = new FileOutputStream(RUTA_GUARDADO);
        ObjectOutputStream out = new ObjectOutputStream(fileOut);

        NodoAutor actual = this.primero;
        
        while (actual != null) {
            out.writeObject(actual);
            actual = actual.getSiguiente();
        }

        out.close();

    }

    public void Deserializar(String RUTA_CANCIONES) throws IOException{
        
        try {
            
            FileInputStream fileIn = new FileInputStream(RUTA_CANCIONES);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            
            this.primero = (NodoAutor) in.readObject();
            
            NodoAutor actual = primero;
            
            do {
                actual.setSiguiente((NodoAutor) in.readObject());
            } while (actual.getSiguiente() != null);
            
            in.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (EOFException n) {
            n.printStackTrace();
        }
    }
}