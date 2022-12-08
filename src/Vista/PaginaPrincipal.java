/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.HiloCliente;

import java.awt.*;
import java.io.IOException;
import java.net.Socket;
import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.help.HelpBroker;
import javax.help.HelpSet;
import javax.help.HelpSetException;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.JPanel;
import javax.swing.BoxLayout;

/**
 *
 * @author Angel Flores
 * 
 */
public class PaginaPrincipal extends javax.swing.JFrame {

    final String HOST = "localhost";
    Socket skCliente;
    HiloCliente h;

    String errorConexion;

    /**
     * 
     * Creates new PaginaPrincipal
     *
     */
    public PaginaPrincipal() {

        initComponents();

        traduccion();
        activarAyuda();

        if (skCliente == null || skCliente.isClosed() || !skCliente.isConnected()) {
            try {
                skCliente = new Socket(HOST, 2000);

                h = new HiloCliente(skCliente, null);

            } catch (java.net.ConnectException ex) {
                JOptionPane.showMessageDialog(null, errorConexion);

                this.dispose();

            } catch (IOException ex) {
                Logger.getLogger(PaginaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        ComicsManager = new javax.swing.JLabel();
        ComicsManager.setHorizontalAlignment(SwingConstants.CENTER);
        jPanel3 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        btnAutores = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        btnInformeAutores = new javax.swing.JButton();
        btnBuscador = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        lblPanelControl = new javax.swing.JLabel();
        content = new javax.swing.JPanel();
        lblBienvenida = new javax.swing.JLabel();
        lblSubtitulo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Quenda gestor cómics");
        setIconImages(null);
        setMinimumSize(new Dimension(1100, 800));
        setPreferredSize(new Dimension(450, 350));

        jPanel4.setBackground(new Color(255, 255, 255));
        jPanel4.setForeground(new Color(255, 255, 255));
        jPanel4.setLayout(new BorderLayout());

        jPanel1.setBackground(new Color(66, 66, 66));
        jPanel1.setPreferredSize(new Dimension(190, 50));
        jPanel1.setLayout(new BoxLayout(jPanel1, BoxLayout.X_AXIS));

        jPanel2.setBackground(new Color(66, 66, 66));
        jPanel2.setBackground(new Color(66, 66, 66));

        ComicsManager.setFont(new Font("Tahoma", 1, 18));
        ComicsManager.setForeground(new Color(255, 255, 255));

        jPanel1.add(jPanel2);
        jPanel2.setLayout(new BoxLayout(jPanel2, BoxLayout.X_AXIS));
        jPanel2.add(ComicsManager);

        jPanel3.setBackground(new Color(66, 66, 66));

        jPanel5.setBackground(new Color(66, 66, 66));
        jPanel5.setForeground(new Color(0, 102, 255));

        btnAutores.setBackground(new Color(66, 66, 66));
        btnAutores.setFont(new Font("Tahoma", 1, 14));
        btnAutores.setForeground(new Color(255, 255, 255));
        btnAutores.setText("Autores");
        btnAutores.setBorderPainted(false);
        btnAutores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAutoresActionPerformed(evt);
            }
        });
        jPanel5.setLayout(new BoxLayout(jPanel5, BoxLayout.X_AXIS));
        btnComics = new javax.swing.JButton();
        jPanel5.add(btnComics);
        
                btnComics.setBackground(new Color(66, 66, 66));
                btnComics.setFont(new Font("Tahoma", 1, 14));
                btnComics.setForeground(new Color(255, 255, 255));
                btnComics.setText("Cómics");
                btnComics.setBorderPainted(false);
                btnComics.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        btnComicsActionPerformed(evt);
                    }
                });
        btnColecciones = new javax.swing.JButton();
        jPanel5.add(btnColecciones);
        
                btnColecciones.setBackground(new Color(66, 66, 66));
                btnColecciones.setFont(new Font("Tahoma", 1, 14)); // NOI18N
                btnColecciones.setForeground(new Color(255, 255, 255));
                btnColecciones.setText("Colecciones");
                btnColecciones.setBorderPainted(false);
                btnColecciones.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        btnColeccionesActionPerformed(evt);
                    }
                });
        jPanel5.add(btnAutores);

        jPanel6.setBackground(new Color(66, 66, 66));

        jPanel9.setBackground(new Color(66, 66, 66));

        jPanel10.setBackground(new Color(66, 66, 66));

        jPanel11.setBackground(new Color(66, 66, 66));

        btnInformeAutores.setBackground(new Color(66, 66, 66));
        btnInformeAutores.setFont(new Font("Tahoma", 1, 14));
        btnInformeAutores.setForeground(new Color(255, 255, 255));
        btnInformeAutores.setText("Informes de autores");
        btnInformeAutores.setBorderPainted(false);
        btnInformeAutores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInformeAutoresActionPerformed(evt);
            }
        });
        jPanel11.setLayout(new BoxLayout(jPanel11, BoxLayout.X_AXIS));
        btnInformeComics = new javax.swing.JButton();
        jPanel11.add(btnInformeComics);
        
                btnInformeComics.setBackground(new Color(66, 66, 66));
                btnInformeComics.setFont(new Font("Tahoma", 1, 14)); 
                btnInformeComics.setForeground(new Color(255, 255, 255));
                btnInformeComics.setText("Informes de cómics");
                btnInformeComics.setBorderPainted(false);
                btnInformeComics.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        btnInformeComicsActionPerformed(evt);
                    }
                });
        jPanel11.add(btnInformeAutores);
        jPanel10.setLayout(new BoxLayout(jPanel10, BoxLayout.X_AXIS));

        jPanel10.add(jPanel11);
        jPanel9.setLayout(new BoxLayout(jPanel9, BoxLayout.X_AXIS));

        jPanel9.add(jPanel10);

        btnBuscador.setBackground(new Color(66, 66, 66));
        btnBuscador.setFont(new Font("Tahoma", 1, 14)); 
        btnBuscador.setForeground(new Color(255, 255, 255));
        btnBuscador.setText("Buscador");
        btnBuscador.setBorderPainted(false);
        btnBuscador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscadorActionPerformed(evt);
            }
        });
        jPanel6.setLayout(new BoxLayout(jPanel6, BoxLayout.X_AXIS));
        jPanel9.add(btnBuscador);

        jPanel6.add(jPanel9);
        jPanel3.setLayout(new BoxLayout(jPanel3, BoxLayout.X_AXIS));

        jPanel5.add(jPanel6);

        jPanel3.add(jPanel5);

        jPanel1.add(jPanel3);
        btnAyuda = new javax.swing.JButton();
        jPanel3.add(btnAyuda);
        
                btnAyuda.setBackground(new Color(66, 66, 66));
                btnAyuda.setFont(new Font("Tahoma", 1, 14));
                btnAyuda.setForeground(new Color(255, 255, 255));
                btnAyuda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Ayuda/imagenes/ayuda1 (3).png"))); 
                btnAyuda.setBorderPainted(false);
                btnAyuda.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        btnAyudaActionPerformed(evt);
                    }
                });

        jPanel4.add(jPanel1, BorderLayout.NORTH);

        jPanel7.setBackground(new Color(255, 255, 255));
        jPanel7.setLayout(new BorderLayout());

        jPanel8.setBackground(new Color(255, 255, 255));
        jPanel8.setLayout(new BorderLayout());

        lblPanelControl.setBackground(new Color(255, 255, 255));
        lblPanelControl.setFont(new Font("Tahoma", 1, 18));
        lblPanelControl.setText("Panel de control");
        lblPanelControl.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jPanel8.add(lblPanelControl, BorderLayout.CENTER);

        jPanel7.add(jPanel8, BorderLayout.PAGE_START);

        content.setBackground(new Color(255, 255, 255));

        lblBienvenida.setFont(new Font("Tahoma", 1, 18)); 
        lblBienvenida.setText("Bienvenido a Quenda Gestión Cómics");

        lblSubtitulo.setText("Pulsa sobre una de las opciones del menú superior para empezar a gestionar");

        jPanel7.add(content, BorderLayout.CENTER);
        content.setLayout(new GridLayout(0, 1, 0, 0));
        content.add(lblBienvenida);
        content.add(lblSubtitulo);

        jPanel4.add(jPanel7, BorderLayout.CENTER);

        getContentPane().add(jPanel4, BorderLayout.CENTER);
        
        panel = new JPanel();
        getContentPane().add(panel, BorderLayout.NORTH);

        pack();
        setLocationRelativeTo(null);
    }
    private void btnAyudaActionPerformed(java.awt.event.ActionEvent evt) {

    }

    private void btnAutoresActionPerformed(java.awt.event.ActionEvent evt) {
        GestionAutoresPanel boardPanel = new GestionAutoresPanel(h);
        boardPanel.setSize(800, 600);
        boardPanel.setLocation(0, 0);

        content.removeAll();
        content.add(boardPanel, BorderLayout.CENTER);
        content.revalidate();
        content.repaint();
    }

    private void btnColeccionesActionPerformed(java.awt.event.ActionEvent evt) {
        GestionColeccionesPanel actorsMoviesPanel = new GestionColeccionesPanel(h);
        actorsMoviesPanel.setSize(600, 491);
        actorsMoviesPanel.setLocation(0, 0);

        content.removeAll();
        content.add(actorsMoviesPanel, BorderLayout.CENTER);
        content.revalidate();
        content.repaint();
    }

    private void btnBuscadorActionPerformed(java.awt.event.ActionEvent evt) {
        BuscadorPanel buscadorPanel = new BuscadorPanel(h);
        buscadorPanel.setSize(600, 491);
        buscadorPanel.setLocation(0, 0);

        content.removeAll();
        content.add(buscadorPanel, BorderLayout.CENTER);
        content.revalidate();
        content.repaint();
    }

    private void btnInformeComicsActionPerformed(java.awt.event.ActionEvent evt) {
        InformesComicsPanel verPeliculasPanel = new InformesComicsPanel(h);
        verPeliculasPanel.setSize(600, 491);
        verPeliculasPanel.setLocation(0, 0);

        content.removeAll();
        content.add(verPeliculasPanel, BorderLayout.CENTER);
        content.revalidate();
        content.repaint();
    }

    private void btnInformeAutoresActionPerformed(java.awt.event.ActionEvent evt) {
        InformesAutoresPanel verActores = new InformesAutoresPanel(h);
        verActores.setSize(600, 491);
        verActores.setLocation(0, 0);

        content.removeAll();
        content.add(verActores, BorderLayout.CENTER);
        content.revalidate();
        content.repaint();
    }

    private void btnComicsActionPerformed(java.awt.event.ActionEvent evt) {
        GestionComicsPanel moviesBoard = new GestionComicsPanel(h);
        moviesBoard.setSize(700, 655);
        moviesBoard.setLocation(0, 0);

        content.removeAll();
        content.add(moviesBoard, BorderLayout.CENTER);
        content.revalidate();
        content.repaint();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PaginaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(PaginaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(PaginaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            Logger.getLogger(PaginaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PaginaPrincipal().setVisible(true);
            }
        });
    }

    private javax.swing.JLabel ComicsManager;
    private javax.swing.JButton btnAutores;
    private javax.swing.JButton btnAyuda;
    private javax.swing.JButton btnBuscador;
    private javax.swing.JButton btnColecciones;
    private javax.swing.JButton btnComics;
    private javax.swing.JButton btnInformeAutores;
    private javax.swing.JButton btnInformeComics;
    private javax.swing.JPanel content;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JLabel lblBienvenida;
    private javax.swing.JLabel lblPanelControl;
    private javax.swing.JLabel lblSubtitulo;
    private JPanel panel;

    private void activarAyuda() {

        try {
            URL url;
            if (Locale.getDefault().getLanguage().equalsIgnoreCase("gl")) {
                url = this.getClass().getResource("/Ayuda/gal/help.hs");
            } else {
                url = this.getClass().getResource("/Ayuda/esp/help.hs");
            }

            // Crea el HelpSet
            HelpSet helpset = new HelpSet(null, url);
            HelpBroker hb = helpset.createHelpBroker();

            hb.enableHelpOnButton(btnAyuda, "paginaprincipal", helpset);
        } catch (Exception ex) {
        	System.out.println(ex.getMessage());
        }

    }

    private void traduccion() {

        ResourceBundle rb = ResourceBundle.getBundle("Idiomas.idioma");

        activarTraduccion(rb);

    }

    private void activarTraduccion(ResourceBundle rb) {
    	
    	ComicsManager.setText(rb.getString("comicManager"));
        lblBienvenida.setText(rb.getString("lblBienvenida"));
        lblSubtitulo.setText(rb.getString("lblSubtitulo"));
        btnInformeComics.setText(rb.getString("btnInformeComics"));
        btnColecciones.setText(rb.getString("btnColecciones"));
        btnComics.setText(rb.getString("btnComics"));
        errorConexion = rb.getString("dialogErrorConexion");

    }

}
