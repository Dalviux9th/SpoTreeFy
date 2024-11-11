package practica;

public class Nodo {
    private int edad;
    private Nodo siguiente;
    private Nodo siglista;

    public Nodo(int edad){
        this.siguiente = null;
        this.edad = edad;
        this.siglista = siglista; //ountero al primer Nodo de la lista de listas//

    }

    public int getedad(){
        return this.edad;
    }

    public void setedad( int newedad){
        this.edad = newedad;
    }

    public Nodo getsiguiente(){
        return this.siguiente;
    }
    public void setsiguiente(Nodo personas){
        this.siguiente = personas;
    }
    public Nodo getsiglista(){
        return this.siglista;
    }
    public void setsiglista(listadelistas reggeton){
        this.siglista = reggeton;
    }

    
}

    

