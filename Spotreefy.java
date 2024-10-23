import java.util.Scanner;

public class Spotreefy {
// Clase principal. Aqui se desarrolla la ejecucion del programa.
    public static void main(String[]args) {
        boolean valido= false;
        boolean salir= false;
        int numero = 0;
        Scanner entrada = new Scanner(System.in);
        ArbolUsers usuarios;

            System.out.println( "¡Bienvenido a Spotreefy!");
            while( !salir){

                System.out.println( "menu principal");
                
                System.out.print("Seleccione una opcion segun su numero ");
                
                
                while (!valido){
                    try
                    {
                        System.out.print("Ingrese un entero: ");
                        numero = entrada.nextInt();
                        valido = true;
                    }
                    catch(Exception exc)
                    {
                        System.out.println(exc);  
                        entrada.next();
                    }
                }

            switch( numero) {
                case 1:
                // login
                    // en caso de logn exitoso trasladamos a menu secundario//
                    menuSecundario();
                    break;

                case 2:
                    // nuevo usuario

                    break;
                
                case 3:
                    // ver usuarios existentes
                    usuarios.mostrarlistaCompleta();
                    break;
                    
                case 4:
                    // salir
                    salir = true;
                    guardarDatos();
                    break;
                    
                }
            }

            entrada.close();
        }
            
}