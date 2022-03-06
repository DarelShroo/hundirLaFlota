public class Comprueba {
    public static boolean compruebaArriba(int col, int fil, String[][] tableroTemporal, int tamanio, String direccion) {
        boolean me_puedo_colocar = false;
        if (fil - 1 >= 0) {
            if (tableroTemporal[col][fil - 1].equals(" ")) {
                me_puedo_colocar = true;
            } else if (direccion.equals("vertical_abajo") && tamanio > 0) {
                me_puedo_colocar = true;
            }
        } else {
            if (fil == 0 && tableroTemporal[col][fil].equals(" ")) {
                me_puedo_colocar = true;
            }
        }
        return me_puedo_colocar;
    }


    public static boolean compruebaAbajo(int col, int fil, String[][] tableroTemporal,int tamanio, String direccion) {
        boolean me_puedo_colocar = false;
        if (fil + 1 <= tableroTemporal.length - 1) {
            if (tableroTemporal[col][fil + 1].equals(" ")) {
                me_puedo_colocar = true;
            } else if (direccion.equals("vertical_arriba") && tamanio > 0) {
                me_puedo_colocar = true;
            }
        } else {
            if (fil == tableroTemporal.length - 1 && tableroTemporal[col][fil].equals(" ")) {
                me_puedo_colocar = true;
            }
        }
        return me_puedo_colocar;
    }


    public static boolean compruebaIzquierda(int col, int fil, String[][] tableroTemporal, int tamanio, String direccion) {
        boolean me_puedo_colocar = false;
        if (col - 1 >= 0) {
            if (tableroTemporal[col - 1][fil].equals(" ")) {
                me_puedo_colocar = true;
            } else if (direccion.equals("horizontal_derecha") && tamanio > 0) {
                me_puedo_colocar = true;
            }
        } else {
            if (col == 0 && tableroTemporal[0][fil].equals(" ")) {
                me_puedo_colocar = true;
            }
        }
        return me_puedo_colocar;
    }


    public static boolean compruebaDerecha(int col, int fil, String[][] tableroTemporal,  int tamanio, String direccion) {
        boolean me_puedo_colocar = false;
        if (col + 1 <= tableroTemporal.length - 1) {
            if (tableroTemporal[col + 1][fil].equals(" ")) {
                me_puedo_colocar = true;
            } else if (direccion.equals("horizontal_izquierda") && tamanio > 0) {
                me_puedo_colocar = true;
            }
        } else {
            if (col == tableroTemporal.length - 1 && tableroTemporal[col][fil].equals(" ")) {
                me_puedo_colocar = true;
            }
        }
        return me_puedo_colocar;
    }


    public static boolean compruebaDiagonaAbajoDerecha(int col, int fil, String[][] tableroTemporal,  int tamanio, String direccion) {
        boolean me_puedo_colocar = false;
        if (col + 1 <= tableroTemporal.length - 1 && fil + 1 <= tableroTemporal.length - 1) {
            if (tableroTemporal[col + 1][fil + 1].equals(" ")) {
                me_puedo_colocar = true;
            } else if (direccion.equals("diagonal_arriba_izquierda") && tamanio > 0) {
                me_puedo_colocar = true;
            }
        } else {
            if ((col == tableroTemporal.length - 1 || fil == tableroTemporal.length - 1) && tableroTemporal[col][fil].equals(" ")) {
                me_puedo_colocar = true;
            }
        }
        return me_puedo_colocar;
    }


    public static boolean compruebaDiagonaAbajoIzquierda(int col, int fil, String[][] tableroTemporal, int tamanio, String direccion) {
        boolean me_puedo_colocar = false;
        if (col - 1 >= 0 && fil + 1 <= tableroTemporal.length - 1) {
            if (tableroTemporal[col - 1][fil + 1].equals(" ")) {
                me_puedo_colocar = true;
            } else if (direccion.equals("diagonal_arriba_derecha") && tamanio > 0) {
                me_puedo_colocar = true;
            }
        } else {
            if ((col >= 0 || fil == tableroTemporal.length - 1) && tableroTemporal[col][fil].equals(" ")) {
                me_puedo_colocar = true;
            }
        }
        return me_puedo_colocar;
    }


    public static boolean compruebaDiagonaArribaIzquierda(int col, int fil, String[][] tableroTemporal, int tamanio, String direccion) {
        boolean me_puedo_colocar = false;
        if (col - 1 >= 0 && fil - 1 >= 0) {
            if (tableroTemporal[col - 1][fil - 1].equals(" ")) {
                me_puedo_colocar = true;
            } else if (direccion.equals("diagonal_abajo_derecha") && tamanio > 0) {
                me_puedo_colocar = true;
            }
        } else {
            if ((col == 0 || fil == 0) && tableroTemporal[col][fil].equals(" ")) {
                me_puedo_colocar = true;
            }
        }
        return me_puedo_colocar;
    }

    public static boolean compruebaDiagonaArribaDerecha(int col, int fil, String[][] tableroTemporal, int tamanio, String direccion) {
        boolean me_puedo_colocar = false;
        if (col + 1 <= tableroTemporal.length - 1 && fil - 1 >= 0) {
            if (tableroTemporal[col + 1][fil - 1].equals(" ")) {
                me_puedo_colocar = true;
            } else if (direccion.equals("diagonal_abajo_izquierda") && tamanio > 0) {
                me_puedo_colocar = true;
            }
        } else {
            if ((col == tableroTemporal.length - 1 || fil == 0) && tableroTemporal[col][fil].equals(" ")) {
                me_puedo_colocar = true;
            }
        }
        return me_puedo_colocar;
    }

}
