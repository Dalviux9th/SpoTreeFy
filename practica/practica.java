package practica;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;



public class practica {

    public static void main (String[]args){
        String rutaArchivo = "/work/NB0208_archivo.txt" ;


        boolean archivoExiste = Files.exists(Paths.get(rutaArchivo));

        if(!archivoExiste) {
            System.out.println( "el archivo" + rutaArchivo + "existe");
            try ( BufferedReader br = new BufferedReader(new FileReader( rutaArchivo))) {
                String linea;
                while((linea = br.readLine()) != null) {
                    System.out.println(linea);
                }

            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
        else {
           System.out.println(rutaArchivo + " no existe !!!");
        }
    }
}


