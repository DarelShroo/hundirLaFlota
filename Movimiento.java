public class Movimiento {
    public Object[] posicion_barco(int opcion, Barco barco, String[][] miTableroVisible, int col, int fil) {
        Object[] arrayObjetos = new Object[3];

        switch (opcion) {
            case 0 -> arrayObjetos = vertical_abajo(miTableroVisible, barco, col, fil);
            case 1 -> arrayObjetos = vertical_arriba(miTableroVisible, barco, col, fil);
            case 2 -> arrayObjetos = horizontal_izquierda(miTableroVisible, barco, col, fil);
            case 3 -> arrayObjetos = horizontal_derecha(miTableroVisible, barco, col, fil);
            case 4 -> arrayObjetos = diagonal_arriba_izquierda(miTableroVisible, barco, col, fil);
            case 5 -> arrayObjetos = diagonal_abajo_izquierda(miTableroVisible, barco, col, fil);
            case 6 -> arrayObjetos = diagonal_arriba_derecha(miTableroVisible, barco, col, fil);
            case 7 -> arrayObjetos = diagonal_abajo_derecha(miTableroVisible, barco, col, fil);
        }

        return arrayObjetos;
    }

    public Object[] vertical_abajo(String[][] miTableroVisible, Barco barco, int col, int fil) {
        int tamanio = 0;
        String[][] tableroTemporal = generar_tablero_temporal(miTableroVisible);
        int[][] posiciones = new int[2][barco.getTamanio()];
        int i = 1;

        while (i <= barco.getTamanio() && fil <= miTableroVisible.length - 1) {
            if (tableroTemporal[col][fil].equals(" ")) {
                if (compruebaAlrededor(col, fil, tableroTemporal, tamanio, "vertical_abajo")) {
                    tableroTemporal[col][fil] = String.valueOf(barco.getLetra());
                    posiciones[1][tamanio] = col;
                    posiciones[0][tamanio] = fil;
                    tamanio++;
                }
            }
            fil++;
            i++;
        }
        return getObjects(miTableroVisible, tableroTemporal, barco.getTamanio(), tamanio, posiciones);
    }

    public Object[] vertical_arriba(String[][] miTableroVisible, Barco barco, int col, int fil) {
        int tamanio = 0;
        String[][] tableroTemporal = generar_tablero_temporal(miTableroVisible);
        int i = 1;
        int[][] posiciones = new int[2][barco.getTamanio()];


        while (i <= barco.getTamanio() && fil >= 0) {
            if (tableroTemporal[col][fil].equals(" ")) {
                if (compruebaAlrededor(col, fil, tableroTemporal, tamanio, "vertical_arriba")) {
                    tableroTemporal[col][fil] = String.valueOf(barco.getLetra());
                    posiciones[0][tamanio] = col;
                    posiciones[1][tamanio] = fil;
                    tamanio++;
                }
            }
            fil--;
            i++;
        }
        return getObjects(miTableroVisible, tableroTemporal, barco.getTamanio(), tamanio, posiciones);
    }

    public Object[] horizontal_izquierda(String[][] miTableroVisible, Barco barco, int col, int fil) {
        int tamanio = 0;
        String[][] tableroTemporal = generar_tablero_temporal(miTableroVisible);
        int i = 1;
        int[][] posiciones = new int[2][barco.getTamanio()];

        while (i <= barco.getTamanio() && col >= 0) {
            if (tableroTemporal[col][fil].equals(" ")) {
                if (compruebaAlrededor(col, fil, tableroTemporal, tamanio, "horizontal_izquierda")) {
                    tableroTemporal[col][fil] = String.valueOf(barco.getLetra());
                    posiciones[0][tamanio] = col;
                    posiciones[1][tamanio] = fil;
                    tamanio++;
                }
            }
            col--;
            i++;
        }
        return getObjects(miTableroVisible, tableroTemporal, barco.getTamanio(), tamanio, posiciones);
    }


    public Object[] horizontal_derecha(String[][] miTableroVisible, Barco barco, int col, int fil) {
        int tamanio = 0;
        String[][] tableroTemporal = generar_tablero_temporal(miTableroVisible);
        int i = 1;

        int[][] posiciones = new int[2][barco.getTamanio()];

        while (i <= barco.getTamanio() && col < tableroTemporal.length) {
            if (tableroTemporal[col][fil].equals(" ")) {
                if (compruebaAlrededor(col, fil, tableroTemporal, tamanio, "horizontal_derecha")) {
                    tableroTemporal[col][fil] = String.valueOf(barco.getLetra());
                    posiciones[0][tamanio] = col;
                    posiciones[1][tamanio] = fil;
                    tamanio++;
                }
            }
            col++;
            i++;
        }
        return getObjects(miTableroVisible, tableroTemporal, barco.getTamanio(), tamanio, posiciones);
    }

    public Object[] diagonal_arriba_izquierda(String[][] miTableroVisible, Barco barco, int col, int fil) {
        int tamanio = 0;
        String[][] tableroTemporal = generar_tablero_temporal(miTableroVisible);
        int i = 1;
        int[][] posiciones = new int[2][barco.getTamanio()];

        while (i <= barco.getTamanio() && fil >= 0 && col <= miTableroVisible.length - 1) {
            if (tableroTemporal[col][fil].equals(" ")) {
                if (compruebaAlrededor(col, fil, tableroTemporal, tamanio, "diagonal_arriba_izquierda")) {
                    tableroTemporal[col][fil] = String.valueOf(barco.getLetra());
                    posiciones[0][tamanio] = col;
                    posiciones[1][tamanio] = fil;
                    tamanio++;
                }
            }
            fil--;
            col++;
            i++;
        }
        return getObjects(miTableroVisible, tableroTemporal, barco.getTamanio(), tamanio, posiciones);
    }

    public Object[] diagonal_abajo_derecha(String[][] miTableroVisible, Barco barco, int col, int fil) {
        int tamanio = 0;
        String[][] tableroTemporal = generar_tablero_temporal(miTableroVisible);
        int i = 1;
        int[][] posiciones = new int[2][barco.getTamanio()];
        int x = 0;

        while (i <= barco.getTamanio() && fil <= miTableroVisible.length - 1 && col <= miTableroVisible.length - 1) {
            if (tableroTemporal[col][fil].equals(" ")) {
                if (compruebaAlrededor(col, fil, tableroTemporal, tamanio, "diagonal_abajo_derecha")) {
                    tableroTemporal[col][fil] = String.valueOf(barco.getLetra());
                    posiciones[0][tamanio] = col;
                    posiciones[1][tamanio] = fil;
                    tamanio++;
                }
            }
            fil++;
            col++;
            i++;
        }
        return getObjects(miTableroVisible, tableroTemporal, barco.getTamanio(), tamanio, posiciones);
    }

    public Object[] diagonal_arriba_derecha(String[][] miTableroVisible, Barco barco, int col, int fil) {
        int tamanio = 0;
        String[][] tableroTemporal = generar_tablero_temporal(miTableroVisible);
        int i = 1;
        int[][] posiciones = new int[2][barco.getTamanio()];

        while (i <= barco.getTamanio() && fil >= 0 && col <= miTableroVisible.length - 1) {
            if (tableroTemporal[col][fil].equals(" ")) {
                if (compruebaAlrededor(col, fil, tableroTemporal, tamanio, "diagonal_arriba_derecha")) {
                    tableroTemporal[col][fil] = String.valueOf(barco.getLetra());
                    posiciones[0][tamanio] = col;
                    posiciones[1][tamanio] = fil;
                    tamanio++;
                }
            }
            fil--;
            col++;
            i++;
        }
        return getObjects(miTableroVisible, tableroTemporal, barco.getTamanio(), tamanio, posiciones);
    }

    public Object[] diagonal_abajo_izquierda(String[][] miTableroVisible, Barco barco, int col, int fil) {
        int tamanio = 0;
        String[][] tableroTemporal = generar_tablero_temporal(miTableroVisible);
        int i = 1;
        int[][] posiciones = new int[2][barco.getTamanio()];

        while (i <= barco.getTamanio() && fil <= miTableroVisible.length - 1 && col >= 0) {
            if (tableroTemporal[col][fil].equals(" ")) {
                if (compruebaAlrededor(col, fil, tableroTemporal, tamanio, "diagonal_abajo_izquierda")) {
                    tableroTemporal[col][fil] = String.valueOf(barco.getLetra());
                    posiciones[0][tamanio] = col;
                    posiciones[1][tamanio] = fil;
                    tamanio++;
                }
            }
            fil++;
            col--;
            i++;
        }
        return getObjects(miTableroVisible, tableroTemporal, barco.getTamanio(), tamanio, posiciones);
    }

    private Object[] getObjects(String[][] miTableroVisible, String[][] tableroTemporal, int tamanioBarco, int tamanio, int[][] posiciones) {
        Object[] arrayObjetos = new Object[4];
        if (tamanio == tamanioBarco) {
            arrayObjetos[0] = tableroTemporal;
            arrayObjetos[1] = tamanio;
            arrayObjetos[2] = posiciones;

        } else {
            arrayObjetos[0] = miTableroVisible;
            arrayObjetos[1] = tamanio;
            arrayObjetos[2] = posiciones;
        }
        return arrayObjetos;
    }

    public boolean compruebaAlrededor(int col, int fil, String[][] tableroTemporal, int tamanio, String direccion) {
        return Comprueba.compruebaIzquierda(col, fil, tableroTemporal, tamanio, direccion) &&
                Comprueba.compruebaDerecha(col, fil, tableroTemporal, tamanio, direccion) &&
                Comprueba.compruebaArriba(col, fil, tableroTemporal, tamanio, direccion) &&
                Comprueba.compruebaAbajo(col, fil, tableroTemporal, tamanio, direccion) &&
                Comprueba.compruebaDiagonaArribaDerecha(col, fil, tableroTemporal, tamanio, direccion) &&
                Comprueba.compruebaDiagonaArribaIzquierda(col, fil, tableroTemporal, tamanio, direccion) &&
                Comprueba.compruebaDiagonaAbajoDerecha(col, fil, tableroTemporal, tamanio, direccion) &&
                Comprueba.compruebaDiagonaAbajoIzquierda(col, fil, tableroTemporal, tamanio, direccion);
    }

    public String[][] generar_tablero_temporal(String[][] tablero) {
        String[][] tableroTemporal = new String[10][10];
        for (int i = 0; i < tablero.length; i++) {
            System.arraycopy(tablero[i], 0, tableroTemporal[i], 0, tablero[0].length);
        }
        return tableroTemporal;
    }

}
