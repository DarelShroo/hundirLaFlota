public class Submarino implements Barco {
    private final int cantidad = 3;
    private final int tamanio = 1;
    private final char letra = 's';
    private int posiciones[][] = new int[2][10];
    private boolean hundido = false;
    private int tocado = 0;

    public Submarino() {
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
        tocado = tocado + 1;
    }

    @Override
    public int getTocado() {
        return tocado;
    }
}
