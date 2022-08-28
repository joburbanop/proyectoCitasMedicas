
public class Doctor extends Usuario {

    /*------------------------------------
     * Atributos
     *----------------------------------*/
    private String especialidad;

    /*----------------------------------------
     * Metodos
     *---------------------------------------*/

    public Doctor(String nombre, String especialidad, String clave) {
        super(nombre, clave);
        this.especialidad = especialidad;

    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

}
