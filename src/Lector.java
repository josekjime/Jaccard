import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
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
            int error = 0;

            while (this.lineaActual != null) {
                if(!this.conjunto.add(this.lineaActual)) {
                    error++;
                    if(error == 1)
                        System.out.println("No se pudo agregar las siguientes lineas de " + this.nombreArchivo + " :");
                    System.out.println(this.lineaActual);
                }
                this.lineaActual = this.texto.readLine();
            }

            this.texto.close();
        }
        catch (Exception e){
            System.out.println("Error al leer de " + this.nombreArchivo + ".");
        }
    }

    public String getNombreArchivo(){ return this.nombreArchivo; }

    public Set<String> getConjunto(){
        return this.conjunto;
    }

    public Integer getCardinalidad(){
        return this.conjunto.size();
    }
}
