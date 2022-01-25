public interface Barco {
    int getTamanio();
    int getCantidad();
    char getLetra();
    int[][] getPosiciones();
    void setPosiciones(int[][] posiciones);
    void setHundido(boolean hundido);
    boolean getHundido();
    void tocado();
    int getTocado();

}
