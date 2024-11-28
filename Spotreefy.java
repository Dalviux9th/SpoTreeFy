import java.util.Scanner;

public class Spotreefy {
// Clase principal. Aqui se desarrolla la ejecucion del programa.
    public static void main(String[]args) {
        boolean valido = false;
        boolean salir = false;
        int numero = 0;
        Scanner entrada = new Scanner(System.in);
        ArbolUsers usuarios;
        ArbolCanciones canciones;

            System.out.println( "¡Bienvenido a Spotreefy!");
            while( !salir){

                System.out.println( "menu principal");
                
                System.out.print("Seleccione una opcion segun su numero ");
                
                
            while (!valido){
                    try{
                    
                        System.out.print("Ingrese un entero entre 1 y 4 inclusive: ");
                        numero = entrada.nextInt();
                        valido = true;
                    }
                    catch(Exception exc)
                    {
                        System.out.println(exc);  
                        entrada.next();
                    }
                
        
                switch( numero) {
                    case 1:
                        String Nombre, Password;
                        System.out.println(" ingrese nombre del usuario");
                        Nombre = entrada.nextLine();
                        System.out.println("ingrese password");
                        Password = entrada.nextLine();
                        if (usuarios.Firewall(Nombre, Password)){
                            menuSecundario();
                        }
                        break;

                    case 2:
                        String newNombre, newPassword;
                        System.out.println( "ingrese nombre de nuevo usuario");
                        newNombre = entrada.nextLine();
                        System.out.println("ingrese password de nuevo usario");
                        newPassword = entrada.nextLine();
                        if(!usuarios.Firewall(newNombre, newPassword)){
                            usuarios.nuevoUsuario(newNombre, newPassword);
                        }
                    
                    // nuevo usuario

                        break;
                
                    case 3:
                    // ver usuarios existentes
                        usuarios.mostrarlistaCompleta();
                        break;
                    
                    case 4:
                        // salir
                        salir = true;
                        usuarios.guardarDatos();
                        break;
                    
                    }
            }

                entrada.close();
            }
    }
            
}