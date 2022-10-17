package modMath;

public class Transpos {
 
    public static String[][] transponerMatriz(String[][] matriz){
    	
    	int x = matriz[0].length;
    	int y = matriz.length;
        String[][] nuevaMatriz = new String[y][x];

        for(int i = 0; i < x; i++){
            for(int j = 0; j < y; j++){
                nuevaMatriz[j][i] = matriz[i][j];
            }
        }
        return nuevaMatriz;
    }

}
