import java.util.Scanner;

public class Jugador {
    Mundo mundo;

    int cantidad_submarinos = 0;
    int cantidad_yates = 0;
    int cantidad_transatlanticos = 0;

    public Jugador(Mundo mundo) {
        this.mundo = mundo;
    }
    public void colocar_barcos() {
        while (cantidad_submarinos < mundo.getSubmarinos().length) {
            if (this.mundo.colocar_submarino(aleatorio(), aleatorio(), mundo.getSubmarinos()[cantidad_submarinos] = new Submarino())) {
                cantidad_submarinos++;
            }
        }

        while (cantidad_yates < mundo.getYates().length) {
            if (this.mundo.colocar_yate(aleatorio(), aleatorio(), mundo.getYates()[cantidad_yates] = new Yate())) {
                cantidad_yates++;
            }
        }

        while (cantidad_transatlanticos < mundo.getTransatlanticos().length) {
            if (this.mundo.colocar_transatlantico(aleatorio(), aleatorio(), mundo.getTransatlanticos()[cantidad_transatlanticos]  = new Transatlantico())) {
                cantidad_transatlanticos++;
            }
        }
    }

   /* public void colocar_barcos_manual() {
        //TODO colocar_barcos_manual
        int[][] pos;
        boolean continua;
        String[][] tablero = this.mundo.getTablero();
        System.out.println("Vamos a colocar el submarino 1");

        continua = true;
        while (continua) {
            pos = pedir_posicion();
            int col = pos[0][0];
            int fil = pos[0][1];

            if (tablero[col][fil].equals(" ")) {
                this.mundo.colocar_submarino(col, fil, submarinos[0]);
                continua = false;
            } else {
                System.out.println("No puedes colocarlo aquí");
            }
        }


        System.out.println("Vamos a colocar el submarino 2");
        continua = true;
        while (continua) {
            pos = pedir_posicion();
            int col = pos[0][0];
            int fil = pos[0][1];

            if (tablero[col][fil].equals(" ")) {
                this.mundo.colocar_submarino(col, fil, submarinos[1]);
                continua = false;
            } else {
                System.out.println("No puedes colocarlo aquí");
            }
        }

        System.out.println("Vamos a colocar el submarino 3");
        continua = true;
        while (continua) {
            pos = pedir_posicion();
            int col = pos[0][0];
            int fil = pos[0][1];

            if (tablero[col][fil].equals(" ")) {
                this.mundo.colocar_submarino(col, fil, submarinos[2]);
                continua = false;
            } else {
                System.out.println("No puedes colocarlo aquí");
            }
        }

        System.out.println("Vamos a colocar el yate 1");
        continua = true;
        while (continua) {
            pos = pedir_posicion();
            int col = pos[0][0];
            int fil = pos[0][1];

            if (tablero[col][fil].equals(" ")) {
                this.mundo.colocar_yate(col, fil, yates[0]);
                continua = false;
            } else {
                System.out.println("No puedes colocarlo aquí");
            }
        }

        System.out.println("Vamos a colocar el yate 2");
        continua = true;
        while (continua) {
            pos = pedir_posicion();
            int col = pos[0][0];
            int fil = pos[0][1];

            if (tablero[col][fil].equals(" ")) {
                this.mundo.colocar_yate(col, fil, yates[1]);
                continua = false;
            } else {
                System.out.println("No puedes colocarlo aquí");
            }
        }


        System.out.println("Vamos a colocar el transatlántico");
        continua = true;
        while (continua) {
            pos = pedir_posicion();
            int col = pos[0][0];
            int fil = pos[0][1];

            if (tablero[col][fil].equals(" ")) {
                this.mundo.colocar_transatlantico(col, fil, transatlantico);
                continua = false;
            } else {
                System.out.println("No puedes colocarlo aquí");
            }
        }

    }*/


    public void disparar(Mundo mundo, String jugador) {
        boolean continua = true;
        int[][] pos = new int[1][2];
        while (continua) {
            if (jugador.equals("humano")) {
                pos = pedir_posicion();
            } else {
                pos[0][0] = aleatorio();
                pos[0][1] = aleatorio();
            }
            if (mundo.disparo(pos[0][0], pos[0][1])) {
                continua = false;
            }
        }
    }

    private int[][] pedir_posicion() {
        Scanner sc = new Scanner(System.in);
        int[][] pos = new int[1][2];
        String string_pos = "";
        int y = 0;
        int x = 0;
        boolean continua = true;

        System.out.print("Posición: ");

        while (continua) {
            string_pos = sc.nextLine();
            x = eje_x(string_pos.charAt(0));
            y = Integer.parseInt(String.valueOf(string_pos.charAt(1)));
            continua = false;
        }

        pos[0][0] = y;
        pos[0][1] = x;

        return pos;
    }

    private int eje_x(char letra) {
        int x = 100;

        switch (letra) {
            case 'a':
                x = 0;
                break;
            case 'b':
                x = 1;
                break;
            case 'c':
                x = 2;
                break;
            case 'd':
                x = 3;
                break;
            case 'e':
                x = 4;
                break;
            case 'f':
                x = 5;
                break;
            case 'g':
                x = 6;
                break;
            case 'h':
                x = 7;
                break;
            case 'i':
                x = 8;
                break;
            case 'j':
                x = 9;
                break;
        }
        return x;
    }

    public int aleatorio() {
        return (int) Math.floor(Math.random() * (9 + 1) + (0));
    }
}
