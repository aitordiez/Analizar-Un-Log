import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
/**
 * Write a description of class AnalizadorAccesosAServidor here.
 *
 * @author (Aitor Diez)
 * @version (Version 1.0)
 */
public class AnalizadorAccesosAServidor
{
    // instance variables - replace the example below with your own
    private ArrayList<Acceso> listaAccesosARegistros;
    /**
     * Constructor for objects of class Tienda
     */
    public AnalizadorAccesosAServidor()
    {
        // initialise instance variables
        listaAccesosARegistros = new ArrayList<Acceso>();

    }

    /**
     * Informe del nombre del Este método debe leer el archivo de log y analizarlo para que luego podamos invocar el siguiente método.
     */
    public void analizarArchivoDeLog(String log){
        try {
            File archivo = new File(log);
            Scanner sc = new Scanner(archivo);
            while (sc.hasNextLine()) {
                String[] arrayString= sc.nextLine().split(" ");
                listaAccesosARegistros.add(new Acceso(Integer.parseInt(arrayString[0]),Integer.parseInt(arrayString[1]),Integer.parseInt(arrayString[2]),Integer.parseInt(arrayString[3]),Integer.parseInt(arrayString[4])));
            }
            sc.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * A partir de los procesos hechos por el método anterior, encuentra la hora (solo la hora, sin tener en cuenta los minutos) a la
     * que se producen más accesos al servidor.
     * En caso de que se invoque este método sin haberse invocado el anterior el método informa por pantalla de que no tiene datos,
     * devuelve -1 y no hace nada más.
     * @return Devuelve horaAccesos, el método muestra por pantalla dicha hora y la devuelve. Si hay empate, devuelve la hora más alta.
     */
    public int obtenerHoraMasAccesos(){
        int horaAccesos= -1;
        int coincidenciasDeAccesos=0;
        if(!listaAccesosARegistros.isEmpty()){    
            for(int i=0; i < 24; i++){
                int horaActualAlmacenada=i;
                int horaActualConMasAccesos=0;
                for(Acceso listaDatosLog : listaAccesosARegistros){
                    if(listaDatosLog.getHora()==horaActualAlmacenada){
                        horaActualConMasAccesos++;
                    }
                }

                if(horaActualConMasAccesos > coincidenciasDeAccesos){
                    coincidenciasDeAccesos=horaActualConMasAccesos;
                    horaAccesos=horaActualAlmacenada;

                }else if(horaActualConMasAccesos==coincidenciasDeAccesos && horaAccesos<horaActualAlmacenada){
                    horaAccesos=horaActualAlmacenada;
                } 
            }
            listaAccesosARegistros.clear();
        }
        return horaAccesos;
    }
}    
