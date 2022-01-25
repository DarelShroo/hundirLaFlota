public class Yate implements Barco {
    private final int cantidad = 2;
    private final int tamanio = 2;
    private final char letra = 'y';
    private int posiciones[][] = new int[2][cantidad];
    private boolean hundido = false;
    private int tocado = 0;
    public Yate() {
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

    public int getTocado() {
        return tocado;
    }
}
