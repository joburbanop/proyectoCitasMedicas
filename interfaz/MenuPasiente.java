
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.Font;
import java.awt.Image;

public class MenuPasiente extends JFrame {
    /*----------------------------------
    * Atributos
    *------------------------------*/
    private JLabel saludo, explicacion, vectorDatosIngreso[], elimnarJLabel, guradarJLabel;
    private ImageIcon imagenEliminar, imagenGuardar;
    private JPanel panel;
    private Font estiloTexto;
    private JTextField datosJTextField;
    private JButton botonEliminar, botonGuardar;
    public final static String[] VECTORMENDAJES = { "Nombres * ", "Apellidos * ", "Email * ", "Tipo de sangre *",
            "Cedula * ", "Peso ", "Altura ", "Telefono" };

    /*-----------------------------
     * Metodos
     *---------------------------*/
    public MenuPasiente() {
        /*-----------------
         * Configuracion basica
         *----------------*/
        // super.setResizable(false);// no se pueda maximizar
        super.setSize(600, 600);
        super.setLocationRelativeTo(null);// posicion en el centro de la pantalla
        super.setVisible(true);
        /*
         * creacion de objetos necesarios
         */
        saludo = new JLabel();
        explicacion = new JLabel();
        vectorDatosIngreso = new JLabel[8];
        imagenEliminar = new ImageIcon("supprimer.png");
        imagenGuardar = new ImageIcon("5673974.png");
        elimnarJLabel = new JLabel();
        guradarJLabel = new JLabel();
        botonEliminar = new JButton("Borrar");
        botonGuardar = new JButton("Guardar");

        estiloTexto = new Font("cooper black", 0, 24);
        crearPanel();
        tituloVentana();
        JLabelSaludar();
        JLabeliDeDatos();
        imagenDatos();
        botonesAcciones();
    }

    private void crearPanel() {
        panel = new JPanel();
        panel.setLayout(null);
        // panel.setBackground(Color.BLACK);
        this.getContentPane().add(panel);

    }

    private void tituloVentana() {
        if (Loguin.getRegistrar()) {
            super.setTitle("Menu pasiente");
        } else {
            super.setTitle("Menu Registrar pasiente");
        }

    }

    private void JLabelSaludar() {
        saludo.setFont(estiloTexto);
        saludo.setBounds(150, 20, 300, 40);
        if (Loguin.getRegistrar()) {
            saludo.setText("Bienvenido " + Loguin.getPasieteLogeado().getNombre());
            panel.add(saludo);
        } else {
            saludo.setLocation(200, 20);
            saludo.setText("Regístrate aquí");
            explicacion.setText("espacios obligatorios  * ");
            explicacion.setFont(new Font("cooper black", 0, 18));
            explicacion.setBounds(50, 55, 300, 40);
            panel.add(explicacion);
            panel.add(saludo);
        }

    }

    private void JLabeliDeDatos() {
        if (Loguin.getRegistrar()) {

        } else {
            for (int i = 0; i < VECTORMENDAJES.length; i++) {
                this.vectorDatosIngreso[i] = new JLabel(VECTORMENDAJES[i]);
                this.vectorDatosIngreso[i].setFont(new Font("cooper black", 0, 15));
                this.vectorDatosIngreso[i].setBounds(50, 100 + (i * 40), 200, 40);
                panel.add(this.vectorDatosIngreso[i]);
                datosJTextField = new JTextField("ingresar datos ...");
                datosJTextField.setBounds(200, 108 + (i * 40), 250, 30);
                panel.add(datosJTextField);

            }

        }

    }

    private void imagenDatos() {
        if (Loguin.getRegistrar()) {

        } else {
            elimnarJLabel.setBounds(120, 450, 60, 60);
            elimnarJLabel.setIcon(new ImageIcon(imagenEliminar.getImage().getScaledInstance(elimnarJLabel.getWidth(),
                    elimnarJLabel.getHeight(), Image.SCALE_SMOOTH)));
            panel.add(elimnarJLabel);

            guradarJLabel.setBounds(320, 450, 60, 60);
            guradarJLabel.setIcon((new ImageIcon(imagenGuardar.getImage().getScaledInstance(guradarJLabel.getWidth(),
                    guradarJLabel.getHeight(), Image.SCALE_SMOOTH))));
            panel.add(guradarJLabel);

        }
    }

    private void botonesAcciones() {
        if (Loguin.getRegistrar()) {

        } else {
            botonEliminar.setBounds(190, 450, 100, 60);
            panel.add(botonEliminar);
        }
    }
}
