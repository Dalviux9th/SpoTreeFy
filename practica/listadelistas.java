package practica;
import java.util.Scanner;

public class listadelistas {
private Nodolistas primero;

public listadelistas(){
    this.primero = null;
}
    public void insertarNodoprincipio(){
        Scanner Entrada = new Scanner(System.in);
        int numero;
        String nombreCancion;
        System.out.print(" ingrese el año de la cancion de de lista");
        numero = Entrada.nextInt();
        System.out.print("ingrese nombre de la cancion de la lista");
        nombreCancion = Entrada.nextLine(); 
        Nodolistas datos = new Nodolistas( numero, nombreCancion);
        datos.setsiguiente(primero);
        this.primero = datos;

    }
    

}
