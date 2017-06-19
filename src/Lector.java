import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.*;

/**
 * Created by Josek on 19/6/2017.
 */
public class Lector {

    private BufferedReader texto;
    private String nombreArchivo;
    private String lineaActual;
    private Set<String> conjunto;

    /**
     * Constructor del Lector con el nombre del archivo a leer.
     */
    Lector(String rutaArchivo){
        this.nombreArchivo = rutaArchivo;
        this.lineaActual = "";
        this.conjunto = new HashSet<>();

        try {
            this.texto = new BufferedReader(new InputStreamReader(new FileInputStream(this.nombreArchivo), "utf-8"));
        }
        catch (Exception e) {
            System.out.println("Error al abrir " + this.nombreArchivo + ".");
        }
    }

    public void crearConjunto(){
        try {
            this.lineaActual = this.texto.readLine();
            //Charset.forName("UTF-8").encode(this.lineaActual);

            while (this.lineaActual != null) {
                if(!this.conjunto.add(this.lineaActual))
                    //System.out.println(this.nombreArchivo + " -> " + this.lineaActual);
                this.lineaActual = this.texto.readLine();
            }

            this.texto.close();
        }
        catch (Exception e){
            System.out.println("Error al leer de " + this.nombreArchivo + ".");
        }
    }

    public Set<String> getConjunto(){
        return this.conjunto;
    }

    public Integer getCardinalidad(){
        return this.conjunto.size();
    }
}
