
import javax.swing.JFrame;

public class MenuDoctor extends JFrame {
    /*----------------------------------
     * Atributos
     *------------------------------*/

    /*-----------------------------
     * Metodos
     *---------------------------*/
    public MenuDoctor() {

        /*-----------------
         * Configuracion basica
         *----------------*/
        super.setTitle("Menu doctor");
        super.setResizable(false);// no se pueda maximizar
        super.setSize(400, 600);
        super.setLocationRelativeTo(null);// posicion en el centro de la pantalla
        super.setVisible(true);

    }

    public void registrar() {
        super.setTitle("Menu registro doctor");
    }

}
