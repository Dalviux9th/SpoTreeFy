import java.util.Scanner;

public class segundoMenu{

    private ArbolUsers usuarios;
    private ArbolCanciones canciones;
    private NodoUser user;
    private ListaAutores autores;
    private Scanner entrada;

    public segundoMenu(ArbolUsers usuarios, ArbolCanciones canciones, String user) {
        this.canciones = canciones;
        this.usuarios = usuarios;
        this.user = usuarios.buscarUser(user);
        this.entrada = new Scanner(System.in);
    }
    


    public void ejecutar(){
        int Numero;
        boolean volver = false;
       
        entrada.next(); // limpio buffer
        while(volver){
            System.out.println(" ingrese el numero segun corresponda");
            Numero  = entrada.nextInt();
            switch (Numero) {

                // Agregar una canción nueva    -----------------------------------------
                case 1:
                    String[] datos = datosNewcancion();
                    
                    canciones.insertarOrdenado(datos[1]);                           // Insertar la cancion al arbol
                    NodoCancion TemaNuevo = canciones.buscarPorTitulo(datos[1]);    // buscar la cancion en el arbol
                    // Verificar si el autor existe
                    if (autores.autorExiste(datos[0])) {                            // SI existe ->
                        autores.buscarAutor(datos[0]).insertarCircular(TemaNuevo);  // agregar la cancion a la lista circular
                    } else {                                                        // SI NO existe ->
                    autores.insertarAutor(datos[0], TemaNuevo);                     // insertar nuevo autor(autor y nodoCancion)
                    }
                    
                    break;
                
                // Crear una nueva playlist vacía   -------------------------------------
                case 2:
                    String NuevaLista;
                    System.out.println("ingrese nombre de la lista nueva");
                        NuevaLista = entrada.nextLine();
                    if(user.getL_propias().existeLista( NuevaLista)){
                        System.out.println("La lista ya existe");

                    }else{
                        agregarListapropia();
                    }
                    break;
                
                // Agregar cancion (a playlist) por título  -----------------------------
                case 3:
                    
                    break;

                // Agregar cancion (a playlist) por autor   -----------------------------
                case 4:
                    
                    break;

                // Eliminar playlist propia
                case 5:
                    
                    break;

                // Seguir playlist de otro usuario
                case 6:
                    
                    break;

                // Salir al menú de primer nivel
                case 7:
                    volver = true;

                    break;
            }
        }
    }

    public String[] datosNewcancion(){
        String Autor, Titulo;
        System.out.println("ingese autor de la cancion");
        Autor = entrada.nextLine();
        System.out.println("ingese titulo de la cancion");
        Titulo = entrada.nextLine();

        String[] datos = {Autor, Titulo};

        return datos;
    }
}