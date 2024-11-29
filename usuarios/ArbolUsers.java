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

     
}
