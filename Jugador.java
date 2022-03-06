import java.util.InputMismatchException;
import java.util.Scanner;

public class Jugador {
    Mundo mundo;

    int cantidad_submarino = 0;
    int cantidad_yate = 0;
    int cantidad_transatlantico = 0;

    public Jugador(Mundo mundo) {
        this.mundo = mundo;
    }

    public void colocar_barcos() {
        while (cantidad_submarino < mundo.getSubmarinos().length) {
            if (this.mundo.isColocado(aleatorio(), aleatorio(), mundo.getSubmarinos()[cantidad_submarino] = new Submarino(), aleatorio())) {
                cantidad_submarino++;
            }
        }

        while (cantidad_yate < mundo.getYates().length) {
            if (this.mundo.isColocado(aleatorio(), aleatorio(), mundo.getYates()[cantidad_yate] = new Yate(), aleatorio())) {
                cantidad_yate++;
            }
        }

        while (cantidad_transatlantico < mundo.getTransatlanticos().length) {
            if (this.mundo.isColocado(aleatorio(), aleatorio(), mundo.getTransatlanticos()[cantidad_transatlantico] = new Transatlantico(), aleatorio())) {
                cantidad_transatlantico++;
            }
        }
    }

    public void colocar_barcos_manual() {
        //TODO colocar_barcos_manual
        int[][] pos;
        String[][] tablero = this.mundo.getTablero();
        while (cantidad_submarino < new Submarino().getCantidad()) {
            System.out.println("Vamos a colocar el submarino " + cantidad_submarino);
            pos = pedir_posicion();
            int col = pos[0][0];
            int fil = pos[0][1];
            if (tablero[col][fil].equals(" ") && this.mundo.isColocado(col, fil, mundo.getSubmarinos()[cantidad_submarino] = new Submarino(), 0)) {
                System.out.println("Colocado!");
                this.mundo.visualizar();
                cantidad_submarino++;
            } else {
                System.out.println("No puedes colocarlo aquí");
            }
        }

        cantidad_submarino = 0;

        while (cantidad_yate < new Yate().getCantidad()) {
            System.out.println("Vamos a colocar el yate " + cantidad_yate);
            pos = pedir_posicion();
            int col = pos[0][0];
            int fil = pos[0][1];

            if (tablero[col][fil].equals(" ") && this.mundo.isColocado(col, fil, mundo.getYates()[cantidad_yate] = new Yate(), pedir_opcion())) {
                System.out.println("Colocado!");
                this.mundo.visualizar();
                cantidad_yate++;

            } else {
                System.out.println("No puedes colocarlo aquí");
            }
        }

        cantidad_yate = 0;

        while (cantidad_transatlantico < new Transatlantico().getCantidad()) {
            System.out.println("Vamos a colocar el transatlántico " + cantidad_transatlantico);
            pos = pedir_posicion();
            int col = pos[0][0];
            int fil = pos[0][1];

            if (tablero[col][fil].equals(" ") && this.mundo.isColocado(col, fil, mundo.getTransatlanticos()[cantidad_transatlantico] = new Transatlantico(), pedir_opcion())) {
                System.out.println("Colocado!");
                this.mundo.visualizar();
                cantidad_transatlantico++;
            } else {
                System.out.println("No puedes colocarlo aquí");
            }
        }

        cantidad_transatlantico = 0;

    }


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


        while (continua) {
            System.out.print("\nPosición: ");
            try {
                string_pos = sc.nextLine();
                x = eje_x(string_pos.charAt(0));
                y = Integer.parseInt(String.valueOf(string_pos.charAt(1)));
                continua = false;
            } catch (StringIndexOutOfBoundsException e) {
                System.out.println("opción no válida, vuelve a intentarlo");
            }
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

    public int pedir_opcion() {
        Scanner in = new Scanner(System.in);
        boolean continua = true;
        int opcion;
        System.out.println("En que posición deseas que se mueva el barco");
        System.out.println("0.- Vertical abajo");
        System.out.println("1.- Vertical arriba");
        System.out.println("2.- horizontal izquierda");
        System.out.println("3.- horizontal derecha");
        System.out.println("4.- diagonal arriba izquierda");
        System.out.println("5.- diagonal abajo izquierda");
        System.out.println("6.- diagonal arriba derecha");
        System.out.println("7.- diagonal abajo derecha");

        System.out.print("\nOpcion: ");
        opcion = in.nextInt();

        while (continua) {
            try {
                if (!(opcion <= 7) || !(opcion >= 0)) {
                    System.out.println("Esta opción no es válida, escribe otra opcion");
                    System.out.print("\n opcion: ");
                    opcion = in.nextInt();
                } else {
                    continua = false;
                }
            } catch (NumberFormatException | InputMismatchException e) {
                System.out.println("No es un numero válido");
            }
        }
        return opcion;
    }

    public int aleatorio() {
        return (int) Math.floor(Math.random() * (9 + 1) + (0));
    }
}
