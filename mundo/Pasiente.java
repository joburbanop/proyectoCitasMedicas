
public class Pasiente extends Usuario {

    /*----------------------------------------
     * Atributos
     *--------------------------------------*/
    private double peso;

    private double alto;

    private String tipoDeSangre;

    /*------------------------------------------
     * Metodos
    *--------------------------------------------*/

    public Pasiente(String nombre, String email, String tipoDeSangre, String cedula) {
        super(nombre, email, cedula);
        this.tipoDeSangre = tipoDeSangre;
        this.peso = 0;
        this.alto = 0;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getAlto() {
        return alto;
    }

    public void setAlto(double alto) {
        this.alto = alto;
    }

    public String getTipoDeSangre() {
        return tipoDeSangre;
    }

    public void setTipoDeSangre(String tipoDeSangre) {
        this.tipoDeSangre = tipoDeSangre;
    }

}
