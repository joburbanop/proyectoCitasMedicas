import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.Font;

import java.awt.Color;

public class Loguin extends JFrame {
    /*----------------------------------
     * Atributos
     *------------------------------*/
    private JPanel panelLoguin;
    private JLabel etiquetaLoguin, etiquetaCandado, etiqueraIconLoguin, etiquetaInstrucion;
    private ImageIcon imagenLoguin, iconLoguin, candado;
    private JPasswordField clave;
    private JTextField input;
    private JButton botonIngreso, nuevoRegistro;
    private Font estiloTexto;
    private BaseDeDatos autenticar;
    private static Pasiente pasieteLogeado;
    private static Doctor doctorLogueado;
    private int noReguistrado = 0;
    private MenuPasiente pasiente;
    private MenuDoctor doctor;
    private static boolean registrar = true;

    /*-----------------------------
     * Metodos
     *---------------------------*/
    public static Pasiente getPasieteLogeado() {
        return pasieteLogeado;
    }

    public static Doctor getDoctorLogueado() {
        return doctorLogueado;
    }

    public static boolean getRegistrar() {
        return registrar;
    }

    public Loguin() {

        /*-----------------
         * Configuracion basica
         *----------------*/
        if (Menu.getControlMenu() == 1) {
            super.setTitle("Doctor");
        }
        if (Menu.getControlMenu() == 2) {
            super.setTitle("Pasiente");
        }
        super.setResizable(false);// no se pueda maximizar
        super.setSize(400, 600);
        super.setLocationRelativeTo(null);// posicion en el centro de la pantalla
        super.setVisible(true);

        JPanelLoguin();
        etiquetaLoguin();
        ingresoDatos();
        botonIngreso();
        botonNuevoRegistro();
        autenticaion();
        registrar();
    }

    private void JPanelLoguin() {
        panelLoguin = new JPanel();
        panelLoguin.setLayout(null);
        this.getContentPane().add(panelLoguin);
        // panelLoguin.setBackground(Color.BLACK);

    }

    private void etiquetaLoguin() {
        estiloTexto = new Font("cooper black", 0, 18);
        // icono de loguin
        etiquetaLoguin = new JLabel();
        imagenLoguin = new ImageIcon("carga.png");
        etiquetaLoguin.setBounds(120, 30, 150, 180);

        etiquetaLoguin.setIcon(new ImageIcon(imagenLoguin.getImage().getScaledInstance(etiquetaLoguin.getWidth(),
                etiquetaLoguin.getHeight(), Image.SCALE_SMOOTH)));

        panelLoguin.add(etiquetaLoguin);

        // estiqueta de descripcion
        if (Menu.getControlMenu() == 1) {
            etiquetaInstrucion = new JLabel("Ingresa nombres y contraseña");
            etiquetaInstrucion.setBounds(60, 240, 280, 30);
        }
        if (Menu.getControlMenu() == 2) {
            etiquetaInstrucion = new JLabel("Ingresa nombres y cedula");
            etiquetaInstrucion.setBounds(72, 240, 280, 30);
        }
        etiquetaInstrucion.setFont(estiloTexto);
        panelLoguin.add(etiquetaInstrucion);

    }

    private void ingresoDatos() {

        estiloTexto = new Font("cooper black", 0, 10);
        input = new JTextField("nombres completos...");
        input.setBounds(110, 300, 200, 30);
        input.setFont(estiloTexto);
        panelLoguin.add(input);

        clave = new JPasswordField();
        clave.setBounds(110, 350, 200, 30);
        panelLoguin.add(clave);

        // etiqueta he imagen de input
        iconLoguin = new ImageIcon("iconLogin.jpg");
        etiqueraIconLoguin = new JLabel();
        etiqueraIconLoguin.setBounds(75, 300, 30, 30);

        etiqueraIconLoguin.setIcon(new ImageIcon(iconLoguin.getImage().getScaledInstance(etiqueraIconLoguin.getWidth(),
                etiqueraIconLoguin.getHeight(), Image.SCALE_SMOOTH)));
        panelLoguin.add(etiqueraIconLoguin);

        // etiqueta he imagen contraseña
        candado = new ImageIcon("candado.png");
        etiquetaCandado = new JLabel();
        etiquetaCandado.setBounds(75, 350, 30, 30);

        etiquetaCandado.setIcon(new ImageIcon(candado.getImage().getScaledInstance(etiquetaCandado.getWidth(),
                etiquetaCandado.getHeight(), Image.SCALE_SMOOTH)));
        panelLoguin.add(etiquetaCandado);
    }

    private void botonIngreso() {
        estiloTexto = new Font("cooper black", 0, 15);
        Color color = new Color(39, 59, 122);

        botonIngreso = new JButton("Ingresar");
        botonIngreso.setBounds(125, 400, 150, 40);
        botonIngreso.setLayout(null);
        botonIngreso.setBackground(color);
        botonIngreso.setFont(estiloTexto);
        botonIngreso.setForeground(Color.WHITE);
        panelLoguin.add(botonIngreso);

    }

    private void botonNuevoRegistro() {
        estiloTexto = new Font("cooper black", 0, 10);
        Color colorFondo = new Color(238, 238, 238);
        Color color = new Color(39, 59, 122);

        nuevoRegistro = new JButton("Registrarme");
        nuevoRegistro.setBounds(150, 450, 100, 30);
        nuevoRegistro.setForeground(color);
        nuevoRegistro.setBackground(colorFondo);
        nuevoRegistro.setBorderPainted(false);
        nuevoRegistro.setFont(estiloTexto);
        panelLoguin.add(nuevoRegistro);
    }

    /**
     * verifica si el usuario se a registrado
     */
    public void autenticaion() {
        autenticar = new BaseDeDatos();

        ActionListener oyenteBotonIngreso = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == botonIngreso && Menu.getControlMenu() == 1) {
                    for (Doctor doctor : autenticar.baseDoctores()) {

                        if (doctor.getClave().equals(clave.getText())) {
                            noReguistrado = 1;
                            doctorLogueado = doctor;
                            ocultarLoguin();
                            mostrarMenuDoctor();
                            break;

                        }
                    }
                    if (noReguistrado == 0) {
                        JOptionPane.showMessageDialog(null, "Doctor no registrado");
                    }
                }
                if (e.getSource() == botonIngreso && Menu.getControlMenu() == 2) {
                    for (Pasiente pasiente : autenticar.basePasientes()) {

                        if (pasiente.getCedula().equals(clave.getText())) {
                            noReguistrado = 1;
                            pasieteLogeado = pasiente;
                            ocultarLoguin();
                            mostrarMenuPasiente();
                            break;
                        }
                    }
                    if (noReguistrado == 0) {
                        JOptionPane.showMessageDialog(null, "Pasiente no registrado");
                    }
                }
            }
        };
        botonIngreso.addActionListener(oyenteBotonIngreso);
    }

    /**
     * Reguistrar usuario
     */
    public void registrar() {

        ActionListener oyenteBotonRegistro = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == nuevoRegistro && Menu.getControlMenu() == 1) {
                    ocultarLoguin();
                    regusitarMenuDoctor();
                } else if (e.getSource() == nuevoRegistro && Menu.getControlMenu() == 2) {
                    ocultarLoguin();
                    regitrarMenuPasiente();
                }
            }

        };
        nuevoRegistro.addActionListener(oyenteBotonRegistro);
    }

    private void ocultarLoguin() {
        super.setVisible(false);
    }

    private void mostrarLoguin() {
        super.setVisible(true);
    }

    private void mostrarMenuDoctor() {
        doctor = new MenuDoctor();
        doctor.addWindowListener(new WindowListener() {
            @Override
            public void windowClosing(WindowEvent e) {
                mostrarLoguin();
                noReguistrado = 0;
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

    private void mostrarMenuPasiente() {
        pasiente = new MenuPasiente();
        pasiente.addWindowListener(new WindowListener() {
            @Override
            public void windowClosing(WindowEvent e) {
                mostrarLoguin();
                noReguistrado = 0;
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

    private void regusitarMenuDoctor() {
        registrar = false;
        doctor = new MenuDoctor();

        doctor.addWindowListener(new WindowListener() {
            @Override
            public void windowClosing(WindowEvent e) {
                mostrarLoguin();
                registrar = true;
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

    private void regitrarMenuPasiente() {
        registrar = false;
        pasiente = new MenuPasiente();

        pasiente.addWindowListener(new WindowListener() {
            @Override
            public void windowClosing(WindowEvent e) {
                mostrarLoguin();
                registrar = true;

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

}