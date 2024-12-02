// nodo de arbol de usuarios

import java.io.Serializable;

public class NodoUser implements Serializable{

    private static final long serialVersionUID = 1L;

    private transient ListaPropias L_propias;
    private transient ListaSeguidos L_seguidos;
    private transient NodoUser mayores;
    private transient NodoUser menores;
    private String nombreUsuario;
    private String password;
 // constructor
    public NodoUser( String nombreUsuario, String password){
        this.nombreUsuario = nombreUsuario;
        this.password = password;
        this.mayores = null;
        this.mayores = null;
        this.L_propias = new ListaPropias();
        this.L_seguidos = new ListaSeguidos();
        
    }
    //gets y sets

    public NodoUser getmayores(){
        return this.mayores;

        }
    public void setmayores(NodoUser newMayores){
        this.mayores = newMayores;
    }

    public NodoUser getmenores(){
        return this.menores;
    
    }
    public void setmenores(NodoUser newMenores){
        this.menores = newMenores;
    }
    
    public String getNombreUsu(){
        return this.nombreUsuario;
    }

    public void setNombreUsu( String nombreUsuario){
        this.nombreUsuario = nombreUsuario;
    }

    public String getPassword(){
        return this.password;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public ListaPropias getL_propias(){
        return this.L_propias;
    }

    public ListaSeguidos getL_seguidos(){
        return this.L_seguidos;
    }

    @Override
    public String toString() {
        return "NodoUser{nombreUsuario = '" + nombreUsuario + "', password = '" + password + "'}";
    }
    
}
    