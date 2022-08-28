import java.util.ArrayList;

public class BaseDeDatos {
    /*----------------------------------
    * Atributos
    *------------------------------*/
    // arreglos dinamicos
    private ArrayList<Doctor> doctores = new ArrayList<>();

    private ArrayList<Pasiente> pasientes = new ArrayList<>();

    /*-----------------------------
     * Metodos
     *---------------------------*/
    public ArrayList<Doctor> baseDoctores() {
        doctores.add(new Doctor("jonathan Burbano ", null, "12345678"));
        doctores.add(new Doctor("keren  ", null, "87654321"));
        doctores.add(new Doctor("rocio ", null, "19733791"));
        return doctores;
    }

    public ArrayList<Pasiente> basePasientes() {
        pasientes.add(new Pasiente("David Santiago ", "santi@gamil.com", "O+", "1086363979"));
        pasientes.add(new Pasiente("ernesto  ", "ernesto@gamil.com", "O-", "1086363777"));
        pasientes.add(new Pasiente("Jonathan Camilo", "joburbanop589@gmail.com", "A+", "12345678"));
        return pasientes;
    }

    public void agregarDoctore(ArrayList<Doctor> doctor) {
        this.doctores = doctor;
    }

    public void agrgarPasiente(ArrayList<Pasiente> pasientes) {
        this.pasientes = pasientes;
    }
}
