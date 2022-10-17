package main;

import modMath.Transpos;
import modMath.PowerIt;
import modChar.SpecialChars;
import javax.swing.JOptionPane;

public class IteradorBinario {

	public static String[] iteradorBinario(String[] args) {
        String[][] body;
        String[][] bodyTransposed;
        String[] finalNombreIterado;
        String[] nombre;
        String nombreString;
        int[] header;
        int longitudNombre;
        int potenciaMaxima;
        int contadorLetra;
        int contadorFila;
        int contadorRestos;
        int cantidadSpeChar;
        int i;
        int j;
        boolean esMayus;

        // Utilizar el escáner para leer directamente de consola a veces me ha dado problemas, sobre todo al final de las Strings con posibles saltos de línea o falsos negativos en la lectura
        // Mantendré el uso de ventanas porque es más directo y ofrece la String desnuda
        nombreString = JOptionPane.showInputDialog("Nombre:").toLowerCase();
        nombre = nombreString.split("");
        longitudNombre = nombreString.length();

        // Cualquier carácter que no sea una letra se tratará aparte, ya que no puede ponerse en mayúscula o minúscula y, por ende, no entaría dentro de la iteración final.
        //Si lo hiciera, añadiría líneas redundantes: a-a y a-a, donde el segundo guión está "en mayúscula"
        // He añadido ñ-Ñ y ç-Ç por el castellano y valenciano, ya que el regex no los incluye por defecto en a-zA-Z. Además, están los acentos á-ú y los abiertos catalanes, à, è, ò
        cantidadSpeChar = SpecialChars.speChar(nombre);
        

        // Los carácteres especiales no cuentan para la cantidad de iteraciones hechas: ana y a-n-a ambas deben hacer 2**3
        potenciaMaxima = PowerIt.powerIterator(longitudNombre, cantidadSpeChar);

        /* La tabla final tiene dos partes: un header compuesto por la cantidad de iteraciones que tiene cada ciclo de mayúsculas-minúsculas, y un body donde cada letra es iterada
         * Un ejemplo con "ana" sería:
         * Tabla inicial:
         * [0, 1, 2]
         * [a, null, null, null, null, null, null, null]
         * [n, null, null, null, null, null, null, null]
         * [a, null, null, null, null, null, null, null]
         * 
         * Tabla final:
         * [0, 1, 2]
         * [a, A, a, A, a, A, a, A] (itera mayusculas-minúsculas cada 2**0 entradas)
         * [n, n, N, N, n, n, N, N] (itera mayusculas-minúsculas cada 2**1 entradas)
         * [a, a, a, a, A, A, A, A] (itera mayusculas-minúsculas cada 2**2 entradas)
         * 
         * Las matriz final son para más adelante e innecesaria para la lógica
        */
        
        header = new int[longitudNombre];
        body = new String[longitudNombre][potenciaMaxima];
        finalNombreIterado = new String[potenciaMaxima];

        i = j = 0;
        while(i < longitudNombre) {
            if(SpecialChars.esEspecial(nombre[i])){
                header[i] = -1; // Los carácteres especiales no iteran
                body[i][0] = nombre[i];
            } else {
                header[i] = (int) Math.pow(2, j); // Solo los caracteres [a-zA-ZçÇñÑ] iteran, así que necesitan un contador aparte
                body[i][0] = nombre[i];
                j++;
            }
            i++;
        }

        contadorLetra = 0;
        while(contadorLetra < longitudNombre){
            esMayus = false;
            contadorFila = 0;
            contadorRestos = 0;
            while(contadorFila < potenciaMaxima) {
                if(esMayus){
                    body[contadorLetra][contadorFila] = nombre[contadorLetra].toUpperCase();
                    contadorRestos++;
                } else {
                    body[contadorLetra][contadorFila] = nombre[contadorLetra];
                    contadorRestos++;
                } 
                // Esta es la lógica que determina que se salte entre mayúsculas y minúsculas cada 2**n pasos, para hacer una iteración binaria
                if(contadorRestos == header[contadorLetra]){
                    esMayus = !esMayus;
                    contadorRestos = 0;
                }
                contadorFila++;
            }
            contadorLetra++;
        }

        // Tal y como está hecho el programa esto es innecesario, pero para posibles usos conviene guardar tanto la matriz transpuesta como una tabla con las Strings directas
        bodyTransposed = Transpos.transponerMatriz(body);

        for(i = 0; i < potenciaMaxima; i++){
            finalNombreIterado[i] = String.join("", bodyTransposed[i]);
        }
        
        return finalNombreIterado;
    }   
}