package practica;

public class Nodolistas {
private Nodolistas siguiente;
private int numero;
private String nombreCancion;

    public Nodolistas(int Numero, String nombreCancion){
        this.siguiente = null;
        this.numero = numero;
        this.nombreCancion = nombreCancion;
    }

    public Nodolistas getsiguiente(){
        return this.siguiente;
    }
    public void setsiguiente(Nodolistas siguiente){
         this.siguiente =  siguiente;
    }
    public int getnumero(){
        return this.numero;
    }
    public void setnumero( int numero){
        this.numero = numero;
    }
    public String getnombrecancion(){
        return this.nombreCancion;
    }
    public void setnombrecancion(String nombreCancion){
        this.nombreCancion = nombreCancion;
    }
}

