package main.java.model;

public class EdicionFisica extends Edicion {
    private double alto; // Altura de la edición física
    private double ancho; // Ancho de la edición física
    private double peso; // Peso de la edición física

    public EdicionFisica(int id, Titulo titulo, int numeroEdicion, String fechaLanzamiento, String isbn, String portada, Integer formato, double alto, double ancho, double peso) {
        super(id, titulo, numeroEdicion, fechaLanzamiento, isbn, portada, formato);
        this.alto = alto;
        this.ancho = ancho;
        this.peso = peso;
    }

    /**
     * Obtiene la altura de la edición física.
     * @return Altura de la edición física.
     */
    public double getAlto() {
        return alto;
    }

    /**
     * Establece la altura de la edición física.
     * @param alto Altura de la edición física a establecer.
     */
    public void setAlto(double alto) {
        this.alto = alto;
    }

    /**
     * Obtiene el ancho de la edición física.
     * @return Ancho de la edición física.
     */
    public double getAncho() {
        return ancho;
    }

    /**
     * Establece el ancho de la edición física.
     * @param ancho Ancho de la edición física a establecer.
     */
    public void setAncho(double ancho) {
        this.ancho = ancho;
    }

    /**
     * Obtiene el peso de la edición física.
     * @return Peso de la edición física.
     */
    public double getPeso() {
        return peso;
    }

    /**
     * Establece el peso de la edición física.
     * @param peso Peso de la edición física a establecer.
     */
    public void setPeso(double peso) {
        this.peso = peso;
    }

    @Override
    public String toString() {
        return super.toString() + " EdicionFisica{" +
                "alto=" + alto +
                ", ancho=" + ancho +
                ", peso=" + peso +
                "} ";
    }
}
