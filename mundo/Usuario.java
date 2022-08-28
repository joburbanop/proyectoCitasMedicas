
/*
 * es la abstraccion tanto de pasientes como de doctores 
*/
public abstract class Usuario {
    /*---------------------------
     * Atributos
     *-------------------------*/
    private static int id;

    private String nombre;

    private String email;

    private String direccion;

    private String numeroDeCelular;

    private String clave;

    private String cedula;

    private String apellido;

    /*------------------------------
     * Metodos
     *---------------------------*/

    public Usuario(String nombre, String clave) {
        this.nombre = nombre;
        this.clave = clave;

    }

    public Usuario(String nombre, String email, String cedula) {
        this.cedula = cedula;
        this.email = email;
        this.nombre = nombre;
        this.apellido = null;
    }

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        Usuario.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setAddress(String direccion) {
        this.direccion = direccion;
    }

    public String getNumeroDeCelular() {
        return numeroDeCelular;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setNumeroDeCelular(String numeroDeCelular) {
        this.numeroDeCelular = numeroDeCelular;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

}
