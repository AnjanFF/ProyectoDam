/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.HiloCliente;
import Modelo.Autor;
import Modelo.Comic;
import Modelo.Estado;
import Utiles.UtilMethods;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.help.HelpBroker;
import javax.help.HelpSet;
import javax.help.HelpSetException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Angel Flores
 * 
 */
public class ModificarComicDialog extends javax.swing.JDialog {

    HiloCliente h;
    byte[] imagen;
    Comic comicModificar;
    
    private String noImagen;
    private String huboProblema;
    private String comicModificado;
    private String camposObligatorios;
    private String errorModificacion;

    /**
     * Creates new form ModificarComicDialog
     *
     * @param parent
     * @param modal
     * @param comic
     * @param h
     */
    public ModificarComicDialog(java.awt.Frame parent, boolean modal, Comic comic, HiloCliente h) {
        super(parent, modal);
        try {
            initComponents();
            this.h = h;
            this.comicModificar = comic;

            traduccion();
            
            cargarCmb();
            
            activarAyuda();
            
            txtTitulo.setText(comic.getNombreComic());
            txtTapa.setText(comic.getTapa());
            txtRutaImagen.setText(comic.getUrlPortada());
            dateChooserCombo.setSelectedDate(UtilMethods.toCalendar(comic.getFechaAdquisicion()));

            if (comic.getPortada() != null) {
                BufferedImage img = ImageIO.read(new ByteArrayInputStream(comic.getPortada()));

                lblFoto.setIcon(new ImageIcon(new ImageIcon(img).getImage().getScaledInstance(160,160, Image.SCALE_SMOOTH)));
            }

        } catch (IOException ex) {
            Logger.getLogger(ModificarComicDialog.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblModificarComic = new javax.swing.JLabel();
        lblT??tulo = new javax.swing.JLabel();
        txtTitulo = new javax.swing.JTextField();
        lblFechaAdquisicion = new javax.swing.JLabel();
        dateChooserCombo = new datechooser.beans.DateChooserCombo();
        lblTapa = new javax.swing.JLabel();
        txtTapa = new javax.swing.JTextField();
        lblEstado = new javax.swing.JLabel();
        cmbEstado = new javax.swing.JComboBox<>();
        txtAutor = new javax.swing.JLabel();
        cmbAutor = new javax.swing.JComboBox<>();
        lblPortada = new javax.swing.JLabel();
        txtRutaImagen = new javax.swing.JTextField();
        btnPortada = new javax.swing.JButton();
        btnModificarComic = new javax.swing.JButton();
        lblFoto = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        lblModificarComic.setText("Modificar un c??mic");

        lblT??tulo.setText("T??tulo");

        txtTitulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTituloActionPerformed(evt);
            }
        });

        lblFechaAdquisicion.setText("Fecha de adquisici??n");

        dateChooserCombo.setCurrentView(new datechooser.view.appearance.AppearancesList("Swing",
            new datechooser.view.appearance.ViewAppearance("custom",
                new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 11),
                    new java.awt.Color(0, 0, 0),
                    new java.awt.Color(0, 0, 255),
                    false,
                    true,
                    new datechooser.view.appearance.swing.ButtonPainter()),
                new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 11),
                    new java.awt.Color(0, 0, 0),
                    new java.awt.Color(0, 0, 255),
                    true,
                    true,
                    new datechooser.view.appearance.swing.ButtonPainter()),
                new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 11),
                    new java.awt.Color(0, 0, 255),
                    new java.awt.Color(0, 0, 255),
                    false,
                    true,
                    new datechooser.view.appearance.swing.ButtonPainter()),
                new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 11),
                    new java.awt.Color(128, 128, 128),
                    new java.awt.Color(0, 0, 255),
                    false,
                    true,
                    new datechooser.view.appearance.swing.LabelPainter()),
                new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 11),
                    new java.awt.Color(0, 0, 0),
                    new java.awt.Color(0, 0, 255),
                    false,
                    true,
                    new datechooser.view.appearance.swing.LabelPainter()),
                new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 11),
                    new java.awt.Color(0, 0, 0),
                    new java.awt.Color(255, 0, 0),
                    false,
                    false,
                    new datechooser.view.appearance.swing.ButtonPainter()),
                (datechooser.view.BackRenderer)null,
                false,
                true)));

    lblTapa.setText("Tapa");

    lblEstado.setText("Estado");

    txtAutor.setText("Autor");

    lblPortada.setText("Portada");

    txtRutaImagen.setEditable(false);
    txtRutaImagen.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            txtRutaImagenActionPerformed(evt);
        }
    });

    btnPortada.setText(". . .");
    btnPortada.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnPortadaActionPerformed(evt);
        }
    });

    btnModificarComic.setText("Modificar");
    btnModificarComic.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnModificarComicActionPerformed(evt);
        }
    });

    javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(
        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel1Layout.createSequentialGroup()
            .addGap(23, 23, 23)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(10, 10, 10)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lblFechaAdquisicion)
                        .addComponent(lblT??tulo)
                        .addComponent(lblTapa)
                        .addComponent(lblEstado)
                        .addComponent(txtAutor)
                        .addComponent(lblPortada))
                    .addGap(18, 18, 18)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(btnModificarComic)
                                .addComponent(txtRutaImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addComponent(btnPortada)
                            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(cmbAutor, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(dateChooserCombo, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                                    .addComponent(txtTitulo))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(cmbEstado, javax.swing.GroupLayout.Alignment.LEADING, 0, 187, Short.MAX_VALUE)
                                    .addComponent(txtTapa, javax.swing.GroupLayout.Alignment.LEADING)))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                            .addComponent(lblFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(26, 26, 26))))
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addComponent(lblModificarComic, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap())))
    );
    jPanel1Layout.setVerticalGroup(
        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel1Layout.createSequentialGroup()
            .addGap(18, 18, 18)
            .addComponent(lblModificarComic)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(lblFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblT??tulo)
                        .addComponent(txtTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(24, 24, 24)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lblFechaAdquisicion)
                        .addComponent(dateChooserCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtTapa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblTapa))
                    .addGap(18, 18, 18)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblEstado)
                        .addComponent(cmbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtAutor)
                        .addComponent(cmbAutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addGap(18, 18, 18)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(lblPortada)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtRutaImagen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPortada)))
            .addGap(18, 18, 18)
            .addComponent(btnModificarComic)
            .addContainerGap(22, Short.MAX_VALUE))
    );

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );

    pack();
    }
    private void btnPortadaActionPerformed(java.awt.event.ActionEvent evt) {

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("Im??genes", "jpeg", "jpg", "png"));
        fileChooser.setAcceptAllFileFilterUsed(false);
        int result = fileChooser.showOpenDialog(null);

        if (result != JFileChooser.APPROVE_OPTION) {
            return;
        }

        File image = fileChooser.getSelectedFile();
        try {
            if (ImageIO.read(image) == null) {
                JOptionPane.showMessageDialog(null, noImagen);
                return;
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, huboProblema);
            return;
        }
        byte[] imageBytes;
        try ( FileInputStream fis = new FileInputStream(image)) {

            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            for (int dataLength; (dataLength = fis.read(buffer)) != -1;) {
                baos.write(buffer, 0, dataLength);
            }
            imageBytes = baos.toByteArray();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, huboProblema);
            return;
        }

        txtRutaImagen.setText(image.getAbsolutePath());

        this.imagen = imageBytes;

        comicModificar.setPortada(imagen);

        lblFoto.setIcon(new ImageIcon(new ImageIcon(this.imagen).getImage().getScaledInstance(lblFoto.getSize().width,
                lblFoto.getSize().height, Image.SCALE_DEFAULT)));
    }

    private void btnModificarComicActionPerformed(java.awt.event.ActionEvent evt) {

        Autor autor = (Autor) cmbAutor.getSelectedItem();
        Estado estado = (Estado) cmbEstado.getSelectedItem();

        if (txtTitulo.getText().isEmpty() || txtTapa.getText().isEmpty() || txtAutor.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, camposObligatorios );
        } else {

            Comic c = new Comic(comicModificar.getIdComic(), txtTitulo.getText(), dateChooserCombo.getSelectedDate().getTime(), txtTapa.getText(), estado.getIdEstado(), autor.getIdAutor(), comicModificar.getPortada(), lblPortada.getText(), comicModificar.getIdColeccion());

            int result = h.solicitarUpdateComic(c);

            switch (result) {
                case 1:
                    JOptionPane.showMessageDialog(null, comicModificado);
                    imagen = null;
                    this.dispose();
                    break;
                case -1:
                    imagen = null;
                    JOptionPane.showMessageDialog(null, "La imagen seleccionada es demasiado pesada. Intentalo de nuevo con otra imagen.");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, errorModificacion);
                    break;
            }

        }

    }

    private void txtRutaImagenActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void txtTituloActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
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
            Logger.getLogger(ModificarComicDialog.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(ModificarComicDialog.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(ModificarComicDialog.class.getName()).log(Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            Logger.getLogger(ModificarComicDialog.class.getName()).log(Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ModificarComicDialog dialog = new ModificarComicDialog(new javax.swing.JFrame(), true, null, null);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    private javax.swing.JButton btnModificarComic;
    private javax.swing.JButton btnPortada;
    private javax.swing.JComboBox<Autor> cmbAutor;
    private javax.swing.JComboBox<Estado> cmbEstado;
    private datechooser.beans.DateChooserCombo dateChooserCombo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblEstado;
    private javax.swing.JLabel lblFechaAdquisicion;
    private javax.swing.JLabel lblFoto;
    private javax.swing.JLabel lblModificarComic;
    private javax.swing.JLabel lblPortada;
    private javax.swing.JLabel lblTapa;
    private javax.swing.JLabel lblT??tulo;
    private javax.swing.JLabel txtAutor;
    private javax.swing.JTextField txtRutaImagen;
    private javax.swing.JTextField txtTapa;
    private javax.swing.JTextField txtTitulo;


    private void cargarCmb() {

        ArrayList<Autor> listaAutores = (ArrayList<Autor>) h.solicitarListaAutores();

        for (Autor autor : listaAutores) {
            cmbAutor.addItem(autor);
        }

        ArrayList<Estado> listaEstados = (ArrayList<Estado>) h.solicitarListaEstado();

        for (Estado estado : listaEstados) {
            cmbEstado.addItem(estado);
        }

    }
    
    private void traduccion() {

        ResourceBundle rb = ResourceBundle.getBundle("Idiomas.idioma");

        activarTraduccion(rb);

    }

    private void activarTraduccion(ResourceBundle rb) {
 
        noImagen = rb.getString("noImagen");
        huboProblema = rb.getString("huboProblema");
        comicModificado = rb.getString("comicModificado");
        camposObligatorios = rb.getString("camposObligatorios");
        errorModificacion = rb.getString("errorModificacionComic");

        lblFechaAdquisicion.setText(rb.getString("lblFechaAdquisicion"));


    }
    
    private void activarAyuda() {

        try {

            URL url;

            if (Locale.getDefault().getLanguage().equalsIgnoreCase("gl")) {
                url = this.getClass().getResource("/ayuda/gal/help.hs");
            } else {
                url = this.getClass().getResource("/ayuda/esp/help.hs");

            }

            // Crea el HelpSet
            HelpSet helpset = new HelpSet(null, url);
            HelpBroker hb = helpset.createHelpBroker();

            hb.enableHelpKey(txtTitulo, "panelcomics", helpset);
        } catch (HelpSetException ex) {
            Logger.getLogger(PaginaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
