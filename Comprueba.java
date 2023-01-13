public class Comprueba {

    public static boolean compruebaArriba(int col, int fil, String[][] tableroTemporal, int tamanio, String direccion) {
        return (fil - 1 >= 0 && tableroTemporal[col][fil - 1].equals(" ")) ||
               (fil == 0 && tableroTemporal[col][fil].equals(" ")) ||
               (direccion.equals("vertical_abajo") && tamanio > 0);
    }

    public static boolean compruebaAbajo(int col, int fil, String[][] tableroTemporal,int tamanio, String direccion) {
        return (fil + 1 <= tableroTemporal.length - 1 && tableroTemporal[col][fil + 1].equals(" ")) ||
               (fil == tableroTemporal.length - 1 && tableroTemporal[col][fil].equals(" ")) ||
               (direccion.equals("vertical_arriba") && tamanio > 0);
    }

    public static boolean compruebaIzquierda(int col, int fil, String[][] tableroTemporal, int tamanio, String direccion) {
        return (col - 1 >= 0 && tableroTemporal[col - 1][fil].equals(" ")) ||
               (col == 0 && tableroTemporal[0][fil].equals(" ")) ||
               (direccion.equals("horizontal_derecha") && tamanio > 0);
    }

    public static boolean compruebaDerecha(int col, int fil, String[][] tableroTemporal,  int tamanio, String direccion) {
        return (col + 1 <= tableroTemporal.length - 1 && tableroTemporal[col + 1][fil].equals(" ")) ||
               (col == tableroTemporal.length - 1 && tableroTemporal[col][fil].equals(" ")) ||
               (direccion.equals("horizontal_izquierda") && tamanio > 0);
    }

    public static boolean compruebaDiagonaAbajoDerecha(int col, int fil, String[][] tableroTemporal,  int tamanio, String direccion) {
        return (col + 1 <= tableroTemporal.length - 1 && fil + 1 <= tableroTemporal.length - 1 && tableroTemporal[col + 1][fil + 1].equals(" ")) ||
               (col == tableroTemporal.length - 1 && fil == tableroTemporal.length - 1 && tableroTemporal[col][fil].equals(" ")) ||
               (direccion.equals("diagonal_arriba_izquierda") && tamanio > 0);
    }
    
}
