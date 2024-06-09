package main.java.model;

public class EdicionDigital extends Edicion {
    private String formato; // Formato digital de la edición
    private boolean drm; // Indica si la edición tiene DRM (Digital Rights Management)
    private Integer tamañoBytes; // Tamaño en bytes de la edición digital

    public EdicionDigital(int id, Titulo titulo, Integer numeroEdicion, String fechaLanzamiento, String isbn, String portada, Integer formato, String formatoDigital, boolean drm, Integer tamañoBytes) {
        super(id, titulo, numeroEdicion, fechaLanzamiento, isbn, portada, formato);
        this.formato = formatoDigital;
        this.drm = drm;
        this.tamañoBytes = tamañoBytes;
    }

    /**
     * Obtiene el formato digital de la edición.
     * @return Formato digital de la edición.
     */
    public String getFormatoDigital() {
        return formato;
    }

    /**
     * Establece el formato digital de la edición.
     * @param formato Formato digital de la edición a establecer.
     */
    public void setFormato(String formato) {
        this.formato = formato;
    }

    /**
     * Verifica si la edición tiene DRM.
     * @return true si la edición tiene DRM, false si no.
     */
    public boolean isDrm() {
        return drm;
    }

    /**
     * Establece si la edición tiene DRM.
     * @param drm true si la edición tiene DRM, false si no.
     */
    public void setDrm(boolean drm) {
        this.drm = drm;
    }

    /**
     * Obtiene el tamaño en bytes de la edición digital.
     * @return Tamaño en bytes de la edición digital.
     */
    public Integer getTamañoBytes() {
        return tamañoBytes;
    }

    /**
     * Establece el tamaño en bytes de la edición digital.
     * @param tamañoBytes Tamaño en bytes de la edición digital a establecer.
     */
    public void setTamañoBytes(Integer tamañoBytes) {
        this.tamañoBytes = tamañoBytes;
    }

    @Override
    public String toString() {
        return  super.toString() + " EdicionDigital{" +
                "formato='" + formato + '\'' +
                ", drm=" + drm +
                ", tamañoBytes=" + tamañoBytes +
                "} ";
    }
}