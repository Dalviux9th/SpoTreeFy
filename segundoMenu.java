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
            case 1:
                String[] datos = datosNewcancion();
                
                canciones.insertarOrdenado(datos[1]);
                if (autores.autorExiste(datos[0])) {
                    // ...ss
                }else{
                    
                    usuarios.buscarTitulo(datos[1],);
                }
                
                // Insertar la cancion al arbol
                // Verificar si el autor existe
                // SI NO existe ->
                //  buscar la cancion en el arbol
                //  insertar nuevo autor(autor y nodoCancion)
                // SI existe ->
                // agregar la cancion a la lista circular
                break;
        
            case 2:
                String NuevaLista;
                System.out.println("ingrese nombre de la lista nueva");
                    NuevaLista = entrada.nextLine();
                if(usuarios.existelista( NuevaLista, user)){
                    System.out.println("La lista ya existe");

                }else{
                    agregarListapropia();
                }
                break;

            case 3:
                
                break;

            case 4:
                
                break;

            case 5:
                
                break;

            case 6:
                
                break;

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