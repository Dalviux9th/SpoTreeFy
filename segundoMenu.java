import java.util.Scanner;

public class segundoMenu{
    private ArbolUsers usuarios;
    private ArbolCanciones canciones;
    private NodoUser user;
    private ListaAutores autores;
    private Scanner entrada;

    public segundoMenu(ArbolCanciones canciones, ArbolUsers usuarios, NodoUser user, ListaAutores autores) {
        this.canciones = canciones;
        this.user = user;
        this.autores = autores;
        this.entrada = new Scanner(System.in);
    }
    


    public void ejecutar(){
        int Numero;
        boolean volver = false;
       
        entrada.next(); // limpio buffer
        while(!volver){
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
                
                // Crear una nueva playlist propia (vacía)   -------------------------------------
                case 2:
                    String NuevaLista;
                    System.out.println("ingrese nombre de la lista nueva");
                        NuevaLista = entrada.nextLine();
                    if(user.getL_propias().existeLista(NuevaLista)){
                        System.out.println("La lista ya existe");

                    }else{
                        user.getL_propias().agregarListaPropia(NuevaLista);
                    }
                    break;
                
                // Agregar cancion (a playlist) por título  -----------------------------
                case 3:
                    String NombrePlaylist, Cancion;
                    System.out.println("ingrese nombre de la nueva PLaylist");
                    NombrePlaylist = entrada.nextLine();
                    System.out.println("ingrese nombre de la cancion");
                    Cancion = entrada.nextLine();

                    // verifica que la lista exista, que la cancion exista en el árbol y que la cancion no esté en esa lista
                    if(user.getL_propias().existeLista(NombrePlaylist) ) {

                        SubListaCanciones Playlist = user.getL_propias().verNodopropias(NombrePlaylist).getSubLista();
                        if ( canciones.buscarPorTitulo(Cancion) != null && !Playlist.existeCancion(Cancion)){
                            
                            // Solo en entonces, la agrega
                            Playlist.agregarCan(canciones.buscarPorTitulo(Cancion));
                            System.out.println("cancion agregada a la Playlist");
                            
                        } else {
                            System.out.println("la cancion no existe o ya está en la Playlist");
                        }
                    } else {
                        System.out.println("no existe la Playlist");
                    }
                    //  SI --> la agrega.

                    break;

                // Agregar cancion (a playlist) por autor   -----------------------------
                case 4:
                    String Tema, Autor, titulo;
                    System.out.println("ingrese  nombre de la Playlist");
                    Tema = entrada.nextLine();
                    System.out.println("ingrese  nombre del autor");
                    Autor = entrada.nextLine();
                    if(autores.autorExiste(Autor)){
                        NodoAutor AutorNodo = autores.buscarAutor(Autor);
                        if( AutorNodo != null){

                            AutorNodo.printCancionesDelAutor();
                            System.out.println("ingrese nombre de la cancion");
                            titulo = entrada.nextLine();
                            NodoCancion NombreCancion = AutorNodo.ReturnCancion(AutorNodo,titulo);
                            agregarListaPropia( NombreCancion.getTitulo());
                        }
                    }

                        
                        break;
                    

                // Eliminar playlist propia
                case 5:
                    String Playlist;
                    System.out.println("ingrese en nombre de la Playlist propia que desea eliminar");
                    Playlist = entrada.nextLine();
                    user.getL_propias().borrarL_propia(Playlist);
                    break;

                // Seguir playlist de otro usuario
                case 6:
                    String UsuarioDes, NombreList;
                    NodoPropias NamePlaylist;
                    //revisar mejoras con variable Nombrelist
                    System.out.println("ingrese nmbre del usuario de interes");
                    UsuarioDes = entrada.nextLine();

                    NodoUser UsuarioSeguir = usuarios.buscarUser(UsuarioDes);

                    if(UsuarioDes != null){
                        UsuarioSeguir.getL_propias().imprimirLista();

                        System.out.println("ingrese en numero de la playlist que desea seguir");
                        NombreList = entrada.nextLine();
                        NamePlaylist =  UsuarioSeguir.getL_propias().verNodopropias(NombreList);

                        if(NamePlaylist != null){

                            user.getL_seguidos().NuevoSeguido(UsuarioDes, NamePlaylist.getPlaylist());
                        }
                    }
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