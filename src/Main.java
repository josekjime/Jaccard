import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        //String archivo1 = args[0];
        //String archivo2 = args[1];

        String archivo1 = "texto1.txt";
        String archivo2 = "texto2.txt";

        // Lee archivos
        Lector lector1 = new Lector(archivo1);
        Lector lector2 = new Lector(archivo2);

        // Crea conjuntos a partir de texto en archivos
        lector1.crearConjunto();
        lector2.crearConjunto();

        // Conjunto de union entre texto de archivos
        Set<String> union = new HashSet<>();
        union.addAll(lector1.getConjunto());
        union.addAll(lector2.getConjunto());

        // Cardinalidad de intersección
        Integer interseccion = lector1.getCardinalidad() + lector2.getCardinalidad() - union.size();

        // Jaccard
        double jaccardCoefficient = 1.0 * interseccion / union.size();
        double jaccardDistance = 1 - jaccardCoefficient;

        System.out.println("\nCardinalidad texto 1: " + lector1.getCardinalidad());
        System.out.println("Cardinalidad texto 2: " + lector2.getCardinalidad());
        System.out.println("Cardinalidad intersección: " + interseccion);
        System.out.println("Cardinalidad unión: " + union.size());
        System.out.println("\nSimilitud Jaccard: " + jaccardCoefficient + " %");
        System.out.println("Disimilitud Jaccard: " + jaccardDistance + " %");

        // /System.out.println("Hello World!");
    }
}
