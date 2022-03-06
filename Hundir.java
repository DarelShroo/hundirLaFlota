public class Hundir {
    public static void main(String[] args) {
        Mundo mundoJugador1 = new Mundo();
        Mundo mundoJugador2 = new Mundo();

        Jugador j1 = new Jugador(mundoJugador1);
        Jugador j2 = new Jugador(mundoJugador2);

        j1.mundo.rellenar_tablero();
        j2.mundo.rellenar_tablero();
        j1.mundo.visualizar();
        j1.colocar_barcos_manual();
        j2.colocar_barcos();
        System.out.print(" Todos los barcos en posición...\n");
        j2.mundo.desvelar();
        j1.mundo.visualizar();
        System.out.println("   Preparados para realizar el disparo.");
        while (!j1.mundo.todos_hundido() && !j2.mundo.todos_hundido()){
            j1.disparar(j2.mundo, "humano");
            j2.disparar(j1.mundo, "maquina");
            System.out.print(" Todos los barcos en posición...\n");
            j2.mundo.desvelar();
            j1.mundo.visualizar();
            System.out.println("   Preparados para realizar el disparo.");
        }

        if(j1.mundo.todos_hundido()){
            System.out.println("Gana el jugador 2");
        }else {
            System.out.println("Gana el jugador 1");
        }
    }
}
