public class Transatlantico implements Barco {
    private final int cantidad = 1;
    private final int tamanio = 3;
    private final char letra = 't';
    private int posiciones[][] = new int[2][cantidad];
    private boolean hundido = false;
    private int tocado = 0;
    public Transatlantico() {
    }

    @Override
    public int getTamanio() {
        return tamanio;
    }

    @Override
    public int getCantidad() {
        return cantidad;
    }

    @Override
    public char getLetra() {
        return letra;
    }

    @Override
    public int[][] getPosiciones() {
        return posiciones;
    }

    @Override
    public void setPosiciones(int[][] posiciones) {
        this.posiciones = posiciones;
    }


    @Override
    public void setHundido(boolean hundido) {
        this.hundido = hundido;
    }

    @Override
    public boolean getHundido() {
        return this.hundido;
    }

    @Override
    public void tocado() {
        tocado = tocado +1;
    }

    @Override
    public int getTocado() {
        return tocado;
    }
}
