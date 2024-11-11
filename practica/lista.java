package practica;
import java.util.Scanner;

public class lista {
private Nodo primero;

    public lista(){
        this.primero = null;
        
    }
    
    Scanner Entrada = new Scanner(System.in);

    public void insertarAlInicio(int newedad){
        System.out.println("ingrese edad de la persona");
        newedad = Entrada.nextInt();
        Nodo Nuevonodo = new Nodo(newedad);
        Nuevonodo.setsiguiente(primero);
        this.primero = Nuevonodo;

    }

    public void imprimirListanodos(){
        Nodo Actual = primero;
        while(Actual != null){
        System.out.println(" persona");
            System.out.println( " edad :" + Actual.getedad() + " ");
            Actual = Actual.getsiguiente();
        }
    }

    public void insertarlista(listadelistas reggeton){
        int numNodo;
        System.out.println("elija en numero de nodo de la lista principal");
        numNodo = Entrada.nextInt();
        int numactual = 1;
        Nodo actual = primero;
        while(numactual != numNodo){
            actual = actual.getsiguiente();
            numactual ++;
        } if( numactual == numNodo){
            actual.setsiglista(reggeton);
        }
    }
}