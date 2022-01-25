public class Mundo {
    private final int MAXIMO_BARCOS_A_HUNDIR = 6;
    private int barcos_hundidos = 0;
    public String[][] miTableroVisible = new String[10][10];
    public String[][] miTableroDisparos = new String[10][10];
    private boolean todos_hundidos = false;

    Movimiento movimiento = new Movimiento();

    private Transatlantico[] transatlanticos = new Transatlantico[1];
    private Yate yates[] = new Yate[2];
    private Submarino submarinos[] = new Submarino[3];

    public Transatlantico[] getTransatlanticos() {
        return transatlanticos;
    }

    public Yate[] getYates() {
        return yates;
    }

    public Submarino[] getSubmarinos() {
        return submarinos;
    }

    public boolean colocar_submarino(int x, int y, Submarino submarino) {
        return isColocado(x, y, submarino, generaNumeroAleatorio());
    }
    public boolean colocar_transatlantico(int x, int y, Transatlantico transatlantico) {
        return isColocado(x, y, transatlantico, generaNumeroAleatorio());
    }
    public boolean colocar_yate(int x, int y, Yate yate) {
        return isColocado(x, y, yate, generaNumeroAleatorio());
    }

    public boolean isColocado(int col, int fil, Barco barco, int opcion) {
        Object[] arrayObjetos = movimiento.posicionBarco(opcion, barco, miTableroVisible, col, fil);
        int tamanio = (int) arrayObjetos[1];
        boolean colocado = false;
        if (tamanio == barco.getTamanio()) {
            miTableroVisible = (String[][]) arrayObjetos[0];
            barco.setPosiciones((int[][]) arrayObjetos[2]);
            colocado = true;
        }

        return colocado;
    }

    public boolean disparo(int x, int y) {
        boolean disparo = true;
        if (this.miTableroVisible[x][y].equals(" ")) {
            this.miTableroVisible[x][y] = "x";
            this.miTableroDisparos[x][y] = "x";
        }
        if ((!this.miTableroVisible[x][y].equals(" ") && !this.miTableroVisible[x][y].equals("x"))) {
            this.miTableroDisparos[x][y] = this.miTableroVisible[x][y];
            System.out.println("Tocado");

            compruebaYate(x, y);
            compruebaSubmarino(x, y);
            compruebaTransatlantico(x, y);
        }


        return disparo;
    }

    public void compruebaTransatlantico(int x, int y) {
        for (Transatlantico transatlantico : transatlanticos) {
            for (int i = 0; i <= transatlantico.getPosiciones().length; i++) {
                if ((x + "" + y).equals(transatlantico.getPosiciones()[0][i] + ""+transatlantico.getPosiciones()[1][i]) && !transatlantico.getHundido()) {
                    transatlantico.getPosiciones()[0][0] = -1;
                    transatlantico.getPosiciones()[1][0] = -1;
                    transatlantico.tocado();
                }
            }
            if (transatlantico.getTocado() == transatlantico.getTamanio() && !transatlantico.getHundido()) {
                System.out.println("Barco hundido");
                transatlantico.setHundido(true);
                barcos_hundidos++;
            }
        }
    }

    public boolean todos_hundido() {
        if (barcos_hundidos == MAXIMO_BARCOS_A_HUNDIR) {
            todos_hundidos = true;
            System.out.println("Todos los barcos hundidos");
        }
        return todos_hundidos;
    }

    public void compruebaYate(int x, int y) {
        for (Yate yate : yates) {
            for (int i = 0; i < yate.getPosiciones().length; i++) {
                if ((x + "" + y).equals(yate.getPosiciones()[0][i] + ""+yate.getPosiciones()[1][i]) && !yate.getHundido()) {
                    yate.getPosiciones()[0][0] = -1;
                    yate.getPosiciones()[1][0] = -1;
                    yate.tocado();
                }
            }
            if (yate.getTocado() == yate.getTamanio() && !yate.getHundido()) {
                System.out.println("Barco hundido");
                yate.setHundido(true);
                barcos_hundidos++;
            }
        }
    }

    public void compruebaSubmarino(int x, int y) {
        for (Submarino submarino : submarinos) {
            for (int i = 0; i < submarino.getPosiciones().length; i++) {
                if ((x + "" + y).equals(submarino.getPosiciones()[0][0] + ""+submarino.getPosiciones()[1][0]) && !submarino.getHundido()) {
                    submarino.getPosiciones()[0][0] = -1;
                    submarino.getPosiciones()[1][0] = -1;
                    submarino.tocado();
                }

            }
            if (submarino.getTocado() == submarino.getTamanio() && !submarino.getHundido()) {
                System.out.println("Barco hundido");
                submarino.setHundido(true);
                barcos_hundidos++;
            }
        }
    }


    public void visualizar() {
        String letrasPos = "abcdefghij";

        System.out.println("  0123456789");
        System.out.print(" ------------\n");

        for (int i = 0; i < this.miTableroDisparos.length; i++) {
            System.out.print(letrasPos.charAt(i) + "|");
            for (int j = 0; j < this.miTableroDisparos[0].length; j++) {
                System.out.print(this.miTableroDisparos[j][i]);
            }
            System.out.print("|");
            System.out.println();
        }
        System.out.print(" ------------\n");

    }

    public void desvelar() {
        String letrasPos = "abcdefghij";
        System.out.print(" ------------\n");
        for (int i = 0; i < this.miTableroVisible.length; i++) {
            System.out.print(letrasPos.charAt(i) + "|");
            for (int j = 0; j < this.miTableroVisible[0].length; j++) {
                System.out.print(this.miTableroVisible[j][i]);
            }
            System.out.print("|");
            System.out.println();
        }
        System.out.print(" ------------\n");
    }

    public void rellenar_tablero() {
        for (int i = 0; i < this.miTableroVisible.length; i++) {
            for (int j = 0; j < this.miTableroVisible[0].length; j++) {
                this.miTableroVisible[i][j] = " ";
                this.miTableroDisparos[i][j] = " ";
            }
        }
    }

    public int generaNumeroAleatorio() {
        return (int) Math.floor(Math.random() * (7 + 1) + (0));
    }
}
