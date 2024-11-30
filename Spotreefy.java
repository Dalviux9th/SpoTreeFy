import java.util.Scanner;

public class Spotreefy {
// Clase principal. Aqui se desarrolla la ejecucion del programa.
    public static void main(String[]args) {
        boolean valido = false;
        boolean salir = false;
        int numero = 0;

        Scanner entrada = new Scanner(System.in);

        final String RUTA_GUARDADO = "/work/ArioniDenicolay";

        ArbolUsers usuarios = null;
        ArbolCanciones canciones = null;
        ListaAutores autores = new ListaAutores();
        segundoMenu menuSecundario = null;

        System.out.println( "¡Bienvenido a Spotreefy!");
        while(!salir){

            System.out.println( "menu principal");
            
            System.out.print("Seleccione una opcion segun su numero ");
            
            
            while (!valido){
                try {
                    System.out.print("Ingrese un entero entre 1 y 4 inclusive: ");
                    numero = entrada.nextInt();
                    valido = true;
                } catch(Exception exc) {
                    System.out.println(exc);  
                    entrada.next();
                }
                
                switch(numero) {

                    // Iniciar sesión
                    case 1:
                        String Nombre, Password;
                        System.out.println(" ingrese nombre del usuario");
                        Nombre = entrada.nextLine();
                        System.out.println("ingrese password");
                        Password = entrada.nextLine();

                        if (usuarios.Firewall(Nombre, Password)){
                            menuSecundario = new segundoMenu(usuarios, canciones, Nombre, autores);
                            menuSecundario.ejecutar();
                            menuSecundario = null;      // CIERRA SESION
                        }

                        break;

                    // Crear usuario nuevo (registro)
                    case 2:
                        String newNombre, newPassword;
                        System.out.println( "ingrese nombre de nuevo usuario");
                        newNombre = entrada.nextLine();
                        System.out.println("ingrese password de nuevo usario");
                        newPassword = entrada.nextLine();
                        if(!usuarios.Firewall(newNombre, newPassword)){
                            usuarios.nuevoUsuario(newNombre, newPassword);
                        }

                        break;
                
                    // Ver usuarios existentes
                    case 3:
                        usuarios.mostrarlistaCompleta();
                        break;
                    
                    // Salir
                    case 4:
                        salir = true;
                        Escritura.guardarTodo(RUTA_GUARDADO);
                        break;
                    
                }
            }

            entrada.close();
        }
    }
            
}