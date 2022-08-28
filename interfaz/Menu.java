import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class Menu extends JFrame {
    /*---------------
     * Atributos, Relaciones
     *--------------------*/
    private JPanel panelDerecho;
    private JLabel etiqueta, etiquetaMensaje, rolPasiente, rolDoctor;
    private ImageIcon imagenIcono, imgenBotonDoctor, imagenBotonPasiente;
    private JButton botonPasiente, botonDoctor;
    private Font estiloTexto;
    private static int controlMenu = 0;

    /*----------------------------------------
     * Metodos
     *-----------------------------------------*/
    public Menu() {
        // Basico
        super.setTitle("Agendar Citas"); // titulo
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// se cierre con la x
        super.setResizable(false);// no se pueda maximizar
        super.setSize(400, 600);// tamaño ventana
        super.setLocationRelativeTo(null);// posicion en el centro de la pantalla

        JPanelEdicion();
        imagenesYJLable();
        botonEvento();
        escuchaBotones();

        super.setVisible(true);
    }

    private void JPanelEdicion() {
        panelDerecho = new JPanel();
        panelDerecho.setLayout(null);// se desactiva el diseño del panel
        // panelDerecho.setBackground(Color.WHITE);
        this.getContentPane().add(panelDerecho);// se trae todo lo de la ventana y se adiciona el panel
        panelDerecho.setSize(250, 300);

    }

    private void imagenesYJLable() {
        // adicion de imagen a el panel
        etiqueta = new JLabel();
        imagenIcono = new ImageIcon("iconoN.png");
        etiqueta.setBounds(68, 10, 250, 280);// dimencionando JLabel

        // se escala el ibjeto imagenIcono a un tamaño adecuado de la etiqueta que lo
        // contiene
        etiqueta.setIcon(new ImageIcon(imagenIcono.getImage().getScaledInstance(etiqueta.getWidth(),
                etiqueta.getHeight(), Image.SCALE_SMOOTH)));
        panelDerecho.add(etiqueta);

        // estilo del texto
        estiloTexto = new Font("cooper black", 0, 20);
        // mensaje de selecion
        etiquetaMensaje = new JLabel("¿Cuál es tu rol?");
        etiquetaMensaje.setBounds(120, 300, 180, 30);
        etiquetaMensaje.setHorizontalAlignment(SwingConstants.CENTER);// centrar el texto en el JLabel
        etiquetaMensaje.setForeground(Color.BLACK);
        etiquetaMensaje.setFont(estiloTexto);
        panelDerecho.add(etiquetaMensaje);

        // mensaje doctor
        rolDoctor = new JLabel("Doctor");
        rolDoctor.setBounds(50, 345, 100, 30);
        rolDoctor.setHorizontalAlignment(SwingConstants.CENTER);
        rolDoctor.setForeground(Color.BLACK);
        estiloTexto = new Font("cooper black", 0, 15);
        rolDoctor.setFont(estiloTexto);
        panelDerecho.add(rolDoctor);

        // mensaje pasiente
        rolPasiente = new JLabel("Pasiente");
        rolPasiente.setBounds(250, 345, 100, 30);
        rolPasiente.setHorizontalAlignment(SwingConstants.CENTER);
        rolPasiente.setForeground(Color.BLACK);
        rolPasiente.setFont(estiloTexto);
        panelDerecho.add(rolPasiente);
    }

    private void botonEvento() {
        // boton doctor he imagen
        imgenBotonDoctor = new ImageIcon("doctor.png");
        botonDoctor = new JButton();
        botonDoctor.setBounds(50, 380, 100, 100);
        botonDoctor.setIcon(new ImageIcon(imgenBotonDoctor.getImage().getScaledInstance(botonDoctor.getWidth(),
                botonDoctor.getHeight(), Image.SCALE_SMOOTH)));
        panelDerecho.add(botonDoctor);
        // setEnabled(true); se establece como encendido o apagado el boton

        // boton pasiente he imagen
        imagenBotonPasiente = new ImageIcon("pasiente.png");
        botonPasiente = new JButton();
        botonPasiente.setBounds(250, 380, botonDoctor.getWidth(), botonDoctor.getHeight());
        botonPasiente.setIcon(new ImageIcon(imagenBotonPasiente.getImage().getScaledInstance(botonDoctor.getWidth(),
                botonDoctor.getHeight(), Image.SCALE_SMOOTH)));
        panelDerecho.add(botonPasiente);

    }

    private void escuchaBotones() {
        // se crea un objeto de tipo ActionListener, pero como no es una clase si no una
        // interface
        // s intancia dicho objeto en una clase anonima
        ActionListener oyenteBotones = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == botonDoctor) {
                    controlMenu = 1;
                    ocultarVentanaPrincipal();
                    mostrarLoguin();

                }
                if (e.getSource() == botonPasiente) {
                    controlMenu = 2;
                    ocultarVentanaPrincipal();
                    mostrarLoguin();
                }

            }

        };

        botonDoctor.addActionListener(oyenteBotones);
        botonPasiente.addActionListener(oyenteBotones);

    }

    public void mostrarVentanaPrincipal() {
        controlMenu = 0;
        super.setVisible(true);

    }

    public void ocultarVentanaPrincipal() {
        super.setVisible(false);
    }

    public void mostrarLoguin() {
        /*
         * addWindowListener es un metodo de la clase windows a el parecer todas las
         * clases lo tiene
         * addWindowListener recibe como parametro un objeto de tipo WindowListener la
         * cual es un interface
         * en ese objetos sobre escribitmos todos los metodos qur tiene WindowListener
         * windowClosing es el metodo que bucamos el cual Se invoca cuando el usuario
         * intenta cerrar la ventana desde el menú del sistema de la ventana.
         */
        Loguin loguin = new Loguin();
        loguin.addWindowListener(new WindowListener() {
            @Override
            public void windowClosing(WindowEvent e) {
                mostrarVentanaPrincipal();
            }

            @Override
            public void windowOpened(WindowEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void windowClosed(WindowEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void windowIconified(WindowEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void windowDeiconified(WindowEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void windowActivated(WindowEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void windowDeactivated(WindowEvent e) {
                // TODO Auto-generated method stub

            }
        });
    }

    public static int getControlMenu() {
        return controlMenu;
    }

}