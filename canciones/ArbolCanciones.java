public class ArbolCanciones{
//Clase para arbol de canciones - Siempre se considera que cada cancion tiene un único autor
     private NodoCancion raiz;

     // contructor arbol de canciones
     public ArbolCanciones() {
          this.raiz = null;
     }

     // Métodos PUBLICOS del árbol  --------------

     public void insertarOrdenado(String nuevoTitulo, String autor) {
     // Inserta un nuevo nodo (recibiendo parametro titulo) ordenado alfabéticamente por título.
     // NO SE ENCARGA de colocar en lista circular de autor
          this.raiz = insertOrder(nuevoTitulo, raiz);
     }
     
     public NodoCancion buscarPorTitulo(String titulo) {
     // Busca una cancion por titulo y devuelve su nodo
          return buscarTitulo(titulo, raiz);
     }

     // Métodos PRIVADOS (uso interno)

     private NodoCancion insertOrder(String nuevoTitulo, NodoCancion actual) {
     // Busca la hoja donde colocar. Crea e inserta el nodo. Además actualiza lista circular por autor.

          if (actual == null) {

               actual = new NodoCancion(nuevoTitulo);       // llegué a una HOJA -> Inserto el nodo.
          
          } else {

               if ( actual.getTitulo().compareTo(nuevoTitulo) > 0 ) {     // Busco por la izquierda

                    actual.setAnterior( insertOrder(nuevoTitulo, actual.getAnterior()) );

               } else {

                    if (!actual.getTitulo().equals(nuevoTitulo)) {     // Si no es cancion DUPLICADA -> Busco por la derecha
                         actual.setPosterior( insertOrder(nuevoTitulo, actual.getPosterior()) );
                    }

               }

          }
          
          return actual;
     }

     private NodoCancion buscarTitulo(String titulo, NodoCancion actual) {
     // Busca en el arbol el nodo que coincida con el titulo dado.
          NodoCancion resultado = null;
          if (actual == null || titulo.equals(actual.getTitulo())) {
               resultado = actual;
          } else {
               if ( actual.getTitulo().compareTo(titulo) > 0)
               actual = buscarTitulo(titulo, actual);
          }

          return resultado;
     }
}