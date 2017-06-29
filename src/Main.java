import java.io.*;
import java.util.*;

import static java.lang.Math.sqrt;

public class Main {

    public static void main(String[] args) {

        String archivo1 = args[0];
        String archivo2 = args[1];

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
        double cosineDistance = interseccion / sqrt(lector1.getCardinalidad() * lector2.getCardinalidad());
        double cosineDistanceD = 1 - cosineDistance;

        System.out.println("\nSimilitud Jaccard: " + jaccardCoefficient*100 + " %");
        System.out.println("Disimilitud Jaccard: " + jaccardDistance*100 + " %");
        System.out.println("\nSimilitud Distancia Cosenos: " + cosineDistance*100 + " %");
        System.out.println("Disimilitud Distancia Cosenos: " + cosineDistanceD*100 + " %");
    }
}
