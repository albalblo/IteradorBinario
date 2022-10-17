package modChar;

public class SpecialChars {
	
	public static int speChar(String[] palabra){
        int cantidad = 0;
        for(String letra:palabra){
            if(esEspecial(letra)){
                cantidad++;
            }
        }
        return cantidad;
    }
	
	// La lista de caracteres especiales se puede expander: por ahora se reconocen las letras del castellano y del valenciano como caracteres normales. Así, ö es un carácter especial,
    // mientras que ü es un carácter normal.
    public static boolean esEspecial(String caracter) {
        return caracter.matches("[^a-zA-ZçÇñÑáéíóúÁÉÍÓÚàèòÀÈÒüÜ]");
    }
}
