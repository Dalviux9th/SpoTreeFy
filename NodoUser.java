// nodo de arbol de usuarios
public class NodoUser {
    private transient NodoUser mayores;
    private transient NodoUser menores;
    private String nombreUsuario;
    private String apellido;
    private  String password;
 // constructor
    public NodoUser( String nombreUsuario, String apellido, String password){
        this.nombreUsuario = nombreUsuario;
        this. apellido = apellido;
        this.password = password;
        this.mayores = null;
        this.mayores = null;
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
}
    