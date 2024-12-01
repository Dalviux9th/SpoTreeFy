import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class ArbolUsers {
    //clase para el arbol de usuarios
    NodoUser raiz;

    // constructor arbol de usuarios
    public ArbolUsers() {
        this.raiz = null;
    }

    //metodos del arbol de usuario
    public boolean Firewall(String Nombre, String Password){
        NodoUser Actual = raiz;
       if(correcto(Actual, Nombre, Password ) == 0){
        return true;
       }else{
        return false;
       }
    }

    public int correcto(NodoUser Actual, String Nombre, String Password){
        if(Actual.getNombreUsu().compareTo(Nombre) != 0 || Actual.getPassword().compareTo(Password) != 0){
           
            return correcto(Actual.getmayores(), Nombre, Password) + correcto(Actual.getmenores(), Nombre, Password);
        }else{
            return 0;
        }
        
    }

    public void nuevoUsuario(String Nombre, String Password){
       NodoUser Actual = raiz;
        agregarUsuario(Actual, Nombre, Password);
    }

    public void agregarUsuario(NodoUser Actual, String Nombre, String Password){
        if(Actual != null){

            if(Nombre.compareTo(Actual.getNombreUsu()) < 0){
                agregarUsuario(Actual.getmenores(), Nombre, Password);
            }else if(Nombre.compareTo(Actual.getNombreUsu()) > 0){
                agregarUsuario(Actual.getmayores(), Nombre, Password);
            }else{
                NodoUser Usuario = new NodoUser(Nombre, Password);
                Actual = Usuario;
                System.out.println(" Nuevo usuario cargado");
            }
        }
    }

    public void mostrarlistaCompleta(){
        NodoUser Actual = raiz;
        imprimirLista(Actual);
    }

    public void imprimirLista( NodoUser Actual){
        if( Actual != null){
            imprimirLista(Actual.getmenores());
            System.out.println( " usuario:" + Actual.getNombreUsu());
            imprimirLista(Actual.getmayores());
        }
        
    }

    
    public NodoUser buscarUser(String user){
        return buscarUsuario( user, raiz);
    }

    public NodoUser buscarUsuario(String User, NodoUser actual){
        NodoUser resultado = null;
          if (actual == null || User.equals(actual.getNombreUsu())) {
               resultado = actual;
          } else {
               if ( actual.getNombreUsu().compareTo(User) > 0)
               actual = buscarUsuario(User, actual);
          }

          return resultado;
     }

    public void Serializar(String RUTA_GUARDADO) throws IOException {
        // Serializa todos los nodos de un arbol y los guarda en el archivo dado. Recorre en PRE-ORDER
        FileOutputStream fileOut = new FileOutputStream(RUTA_GUARDADO);
        ObjectOutputStream out = new ObjectOutputStream(fileOut);
        
        serializar(raiz, out);

        out.close();

    }

    private void serializar(NodoUser user, ObjectOutputStream out) throws IOException {

        if (user != null) {
            out.writeObject(user);
            serializar(user.getmenores(), out);
            serializar(user.getmayores(), out);
        }

    }

    public void SerializarListas(String RUTA_PROPIAS, String RUTA_SEGUIDAS) throws IOException {
        FileOutputStream fileOutProps = new FileOutputStream(RUTA_PROPIAS);
        ObjectOutputStream outProps = new ObjectOutputStream(fileOutProps);
        
        FileOutputStream fileOutSegs = new FileOutputStream(RUTA_SEGUIDAS);
        ObjectOutputStream outSegs = new ObjectOutputStream(fileOutSegs);
        
        
        serializarListas(raiz, outProps, outSegs);

        outProps.close();
        outSegs.close();
    }

    public void serializarListas(NodoUser user, ObjectOutputStream outProps, ObjectOutputStream outSegs) throws IOException {

        if (user != null) {
            user.getL_propias().Serializar(user.getNombreUsu(), outProps);
            user.getL_seguidos().Serializar(user.getNombreUsu(), outSegs);

            serializarListas(user.getmenores(), outProps, outSegs);
            serializarListas(user.getmayores(), outProps, outSegs);
        }
    }
}
