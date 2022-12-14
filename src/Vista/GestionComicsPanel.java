package Vista;

import Controlador.HiloCliente;
import Modelo.Autor;
import Modelo.Coleccion;
import Modelo.Comic;
import Modelo.Estado;
import Modelo.Tabla.TablaComics;
import java.awt.Image;
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
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.FlowLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Color;

/**
 *
 *
 * @author Angel Flores
 * 
 */

public class GestionComicsPanel extends javax.swing.JPanel {

    HiloCliente h;
    byte[] image = null;
    private String noImagen;
    private String huboProblema;
    private String camposObligatorios;
    private String errorCreadoComic;
    private String comicCreado;
    private String existeComic;
    private String errorBorradoComic;
    private String comicEliminado;
    private String noExisteComic;

    /**
     * Creates new form GestionComicsPanel
     *
     * @param h Class HiloCliente
     */
    public GestionComicsPanel(HiloCliente h) {
        initComponents();

        this.h = h;
        setLayout(new GridLayout(0, 1, 0, 0));
        add(jPanel1);
        jPanel1.setLayout(new GridLayout(0, 1, 0, 0));
        jPanel1.add(jScrollPane1);
        cargarCmb();
        refrescarTabla();
        traduccion();

    }


    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel2.setForeground(Color.WHITE);
        jPanel3 = new javax.swing.JPanel();
        lblGestionComics = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablaComics = new javax.swing.JTable();
        lblAnhadir = new javax.swing.JLabel();
        lblT??tulo = new javax.swing.JLabel();
        txtTitulo = new javax.swing.JTextField();
        dateChooserCombo = new datechooser.beans.DateChooserCombo();
        lblFechaAdquisicion = new javax.swing.JLabel();
        txtTapa = new javax.swing.JTextField();
        lblTapa = new javax.swing.JLabel();
        lblEstado = new javax.swing.JLabel();
        txtAutor = new javax.swing.JLabel();
        cmbEstado = new javax.swing.JComboBox<>();
        cmbAutor = new javax.swing.JComboBox<>();
        lblPortada = new javax.swing.JLabel();
        btnPortada = new javax.swing.JButton();
        btnAnhadirComic = new javax.swing.JButton();
        txtRutaImagen = new javax.swing.JTextField();
        btnBorrarComic = new javax.swing.JButton();
        btnModificarComic = new javax.swing.JButton();
        lblFoto = new javax.swing.JLabel();
        lblColeccion =new javax.swing.JLabel();
        cmbColeccion = new javax.swing.JComboBox<>();

        setBackground(new java.awt.Color(255, 255, 255));
        setToolTipText("");
        setPreferredSize(new Dimension(824, 845));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(Color.WHITE);
        jPanel2.setToolTipText("");
        jPanel2.setPreferredSize(new java.awt.Dimension(700, 635));

        jPanel3.setBackground(Color.WHITE);

        lblGestionComics.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblGestionComics.setText("Gesti??n de c??mics");

        tablaComics.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tablaComics.setFillsViewportHeight(true);
        tablaComics.setRowHeight(80);
        jScrollPane3.setViewportView(tablaComics);

        lblAnhadir.setText("A??adir un c??mic");

        lblT??tulo.setText("T??tulo");

        dateChooserCombo.setCurrentView(new datechooser.view.appearance.AppearancesList("Light",
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
    dateChooserCombo.setCalendarPreferredSize(new java.awt.Dimension(300, 180));

    lblFechaAdquisicion.setText("Fecha de adquisici??n");

    lblTapa.setText("Tapa");

    lblEstado.setText("Estado");

    txtAutor.setText("Autor");

    lblPortada.setText("Portada");

    btnPortada.setText(". . .");
    btnPortada.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnPortadaActionPerformed(evt);
        }
    });

    btnAnhadirComic.setText("A??adir");
    btnAnhadirComic.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnAnhadirComicActionPerformed(evt);
        }
    });

    txtRutaImagen.setEditable(false);

    btnBorrarComic.setText("Borrar");
    btnBorrarComic.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnBorrarComicActionPerformed(evt);
        }
    });

    btnModificarComic.setText("Modificar");
    btnModificarComic.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnModificarComicActionPerformed(evt);
        }
    });

    lblColeccion.setText("Coleccion");

    javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
    jPanel3Layout.setHorizontalGroup(
    	jPanel3Layout.createParallelGroup(Alignment.TRAILING)
    		.addGroup(jPanel3Layout.createSequentialGroup()
    			.addContainerGap()
    			.addGroup(jPanel3Layout.createParallelGroup(Alignment.LEADING)
    				.addGroup(jPanel3Layout.createSequentialGroup()
    					.addGroup(jPanel3Layout.createParallelGroup(Alignment.LEADING)
    						.addGroup(jPanel3Layout.createSequentialGroup()
    							.addGap(71)
    							.addGroup(jPanel3Layout.createParallelGroup(Alignment.TRAILING)
    								.addGroup(jPanel3Layout.createSequentialGroup()
    									.addComponent(lblColeccion, GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
    									.addGap(18)
    									.addComponent(cmbColeccion, GroupLayout.PREFERRED_SIZE, 229, GroupLayout.PREFERRED_SIZE))
    								.addGroup(jPanel3Layout.createSequentialGroup()
    									.addGroup(jPanel3Layout.createParallelGroup(Alignment.LEADING)
    										.addGroup(jPanel3Layout.createSequentialGroup()
    											.addComponent(lblT??tulo, GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
    											.addGap(29))
    										.addComponent(lblFechaAdquisicion, GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
    										.addGroup(jPanel3Layout.createSequentialGroup()
    											.addComponent(lblTapa, GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
    											.addGap(31))
    										.addGroup(jPanel3Layout.createSequentialGroup()
    											.addComponent(lblEstado, GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
    											.addGap(22))
    										.addGroup(jPanel3Layout.createSequentialGroup()
    											.addComponent(txtAutor, GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
    											.addGap(28))
    										.addGroup(jPanel3Layout.createSequentialGroup()
    											.addComponent(lblPortada, GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
    											.addGap(17)))
    									.addGap(18)
    									.addGroup(jPanel3Layout.createParallelGroup(Alignment.LEADING, false)
    										.addComponent(txtTapa, GroupLayout.PREFERRED_SIZE, 230, GroupLayout.PREFERRED_SIZE)
    										.addComponent(dateChooserCombo, GroupLayout.PREFERRED_SIZE, 230, GroupLayout.PREFERRED_SIZE)
    										.addComponent(txtTitulo, GroupLayout.PREFERRED_SIZE, 230, GroupLayout.PREFERRED_SIZE)
    										.addComponent(cmbEstado, GroupLayout.PREFERRED_SIZE, 230, GroupLayout.PREFERRED_SIZE)
    										.addComponent(cmbAutor, GroupLayout.PREFERRED_SIZE, 230, GroupLayout.PREFERRED_SIZE)
    										.addComponent(txtRutaImagen, GroupLayout.PREFERRED_SIZE, 230, GroupLayout.PREFERRED_SIZE)
    										.addComponent(btnModificarComic, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)))))
    						.addGroup(jPanel3Layout.createSequentialGroup()
    							.addComponent(lblAnhadir)
    							.addPreferredGap(ComponentPlacement.RELATED, 383, Short.MAX_VALUE)))
    					.addGroup(jPanel3Layout.createParallelGroup(Alignment.TRAILING)
    						.addGroup(jPanel3Layout.createSequentialGroup()
    							.addGap(0)
    							.addComponent(btnPortada, GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE))
    						.addGroup(jPanel3Layout.createSequentialGroup()
    							.addPreferredGap(ComponentPlacement.RELATED)
    							.addComponent(btnBorrarComic, GroupLayout.PREFERRED_SIZE, 119, Short.MAX_VALUE)))
    					.addGap(29)
    					.addComponent(lblFoto, GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE))
    				.addGroup(jPanel3Layout.createSequentialGroup()
    					.addGap(253)
    					.addComponent(btnAnhadirComic)
    					.addPreferredGap(ComponentPlacement.RELATED, 374, GroupLayout.PREFERRED_SIZE))
    				.addComponent(jScrollPane3, GroupLayout.PREFERRED_SIZE, 595, GroupLayout.PREFERRED_SIZE)
    				.addGroup(jPanel3Layout.createSequentialGroup()
    					.addComponent(lblGestionComics, GroupLayout.DEFAULT_SIZE, 328, Short.MAX_VALUE)
    					.addGap(386)))
    			.addGap(98))
    );
    jPanel3Layout.setVerticalGroup(
    	jPanel3Layout.createParallelGroup(Alignment.TRAILING)
    		.addGroup(jPanel3Layout.createSequentialGroup()
    			.addContainerGap()
    			.addComponent(lblGestionComics, GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
    			.addPreferredGap(ComponentPlacement.RELATED)
    			.addComponent(jScrollPane3, GroupLayout.PREFERRED_SIZE, 231, GroupLayout.PREFERRED_SIZE)
    			.addGap(34)
    			.addGroup(jPanel3Layout.createParallelGroup(Alignment.BASELINE)
    				.addComponent(lblAnhadir)
    				.addComponent(btnModificarComic)
    				.addComponent(btnBorrarComic))
    			.addGap(18)
    			.addGroup(jPanel3Layout.createParallelGroup(Alignment.TRAILING)
    				.addGroup(jPanel3Layout.createSequentialGroup()
    					.addGroup(jPanel3Layout.createParallelGroup(Alignment.BASELINE)
    						.addComponent(lblT??tulo)
    						.addComponent(txtTitulo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
    					.addPreferredGap(ComponentPlacement.UNRELATED)
    					.addGroup(jPanel3Layout.createParallelGroup(Alignment.TRAILING)
    						.addComponent(dateChooserCombo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
    						.addComponent(lblFechaAdquisicion))
    					.addPreferredGap(ComponentPlacement.UNRELATED)
    					.addGroup(jPanel3Layout.createParallelGroup(Alignment.BASELINE)
    						.addComponent(txtTapa, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
    						.addComponent(lblTapa))
    					.addPreferredGap(ComponentPlacement.UNRELATED)
    					.addGroup(jPanel3Layout.createParallelGroup(Alignment.BASELINE)
    						.addComponent(lblEstado)
    						.addComponent(cmbEstado, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
    					.addPreferredGap(ComponentPlacement.UNRELATED)
    					.addGroup(jPanel3Layout.createParallelGroup(Alignment.BASELINE)
    						.addComponent(txtAutor)
    						.addComponent(cmbAutor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
    					.addPreferredGap(ComponentPlacement.UNRELATED)
    					.addGroup(jPanel3Layout.createParallelGroup(Alignment.BASELINE)
    						.addComponent(lblPortada)
    						.addComponent(txtRutaImagen, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
    						.addComponent(btnPortada, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
    				.addGroup(jPanel3Layout.createSequentialGroup()
    					.addGap(9)
    					.addComponent(lblFoto, GroupLayout.DEFAULT_SIZE, 263, Short.MAX_VALUE)))
    			.addPreferredGap(ComponentPlacement.UNRELATED)
    			.addGroup(jPanel3Layout.createParallelGroup(Alignment.BASELINE)
    				.addComponent(cmbColeccion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
    				.addComponent(lblColeccion))
    			.addPreferredGap(ComponentPlacement.UNRELATED)
    			.addComponent(btnAnhadirComic)
    			.addGap(75))
    );
    jPanel3.setLayout(jPanel3Layout);

    jScrollPane1.setViewportView(jPanel2);
    jPanel2.setLayout(new GridLayout(0, 1, 0, 0));
    jPanel2.add(jPanel3);
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

        this.image = imageBytes;
        lblFoto.setIcon(new ImageIcon(new ImageIcon(this.image).getImage().getScaledInstance(lblFoto.getSize().width,
                lblFoto.getSize().height, Image.SCALE_DEFAULT)));
    }

    private void btnAnhadirComicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnhadirComicActionPerformed

        Autor autor = (Autor) cmbAutor.getSelectedItem();
        Estado estado = (Estado) cmbEstado.getSelectedItem();
        Coleccion coleccion = (Coleccion) cmbColeccion.getSelectedItem();

        if (txtTitulo.getText().isEmpty() || txtTapa.getText().isEmpty() || txtAutor.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, camposObligatorios);
        } else {

            Comic c = new Comic(txtTitulo.getText(), dateChooserCombo.getSelectedDate().getTime(), txtTapa.getText(), estado.getIdEstado(), autor.getIdAutor(), image, lblPortada.getText(), coleccion.getIdColeccion());

            if (h.solicitarGetComic(c.getNombreComic()) != null) {
                JOptionPane.showMessageDialog(null, existeComic);
            } else {

                int result = h.solicitarAnhadirComic(c);

                if (result == 1) {
                    JOptionPane.showMessageDialog(null, comicCreado);

                    txtTitulo.setText("");
                    txtTapa.setText("");
                    txtRutaImagen.setText("");
                    lblFoto.setText("");

                    image = null;

                    refrescarTabla();

                } else {
                    JOptionPane.showMessageDialog(null, errorCreadoComic);
                }

            }

        }
    }

    private void btnBorrarComicActionPerformed(java.awt.event.ActionEvent evt) {

        String nomComic = (String) tablaComics.getModel().getValueAt(tablaComics.getSelectedRow(), 1);

        if (nomComic == null) {
            JOptionPane.showMessageDialog(null, "No hay un c??mic seleccionado.");
        } else {
            int opt = JOptionPane.showConfirmDialog(null, "??Est?? seguro que desea eliminar el "
                    + "c??mic con t??tulo: " + nomComic + " ? Los cambios realizados son permanentes", "Eliminar un c??mic", JOptionPane.YES_NO_OPTION);

            if (opt == JOptionPane.YES_OPTION) {
                int result = h.solicitarEliminarComic(nomComic);

                if (result > 0) {
                    JOptionPane.showMessageDialog(null, comicEliminado);

                    refrescarTabla();

                } else {
                    JOptionPane.showMessageDialog(null, errorBorradoComic);
                }

            }
        }

    }

    private void btnModificarComicActionPerformed(java.awt.event.ActionEvent evt) {
        String nomComic = (String) tablaComics.getModel().getValueAt(tablaComics.getSelectedRow(), 1);

        Comic comic = h.solicitarGetComic(nomComic);

        if (comic != null) {

            ModificarComicDialog modComic = new ModificarComicDialog(null, true, comic, h);
            modComic.setVisible(true);

            refrescarTabla();

        } else {

            JOptionPane.showMessageDialog(null, noExisteComic);

        }
    }
    private javax.swing.JButton btnAnhadirComic;
    private javax.swing.JButton btnBorrarComic;
    private javax.swing.JButton btnModificarComic;
    private javax.swing.JButton btnPortada;
    private javax.swing.JComboBox<Autor> cmbAutor;
    private javax.swing.JComboBox<Coleccion> cmbColeccion;
    private javax.swing.JComboBox<Estado> cmbEstado;
    private datechooser.beans.DateChooserCombo dateChooserCombo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblAnhadir;
    private javax.swing.JLabel lblColeccion;
    private javax.swing.JLabel lblEstado;
    private javax.swing.JLabel lblFechaAdquisicion;
    private javax.swing.JLabel lblFoto;
    private javax.swing.JLabel lblGestionComics;
    private javax.swing.JLabel lblPortada;
    private javax.swing.JLabel lblTapa;
    private javax.swing.JLabel lblT??tulo;
    private javax.swing.JTable tablaComics;
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

        ArrayList<Coleccion> listaColecciones = (ArrayList<Coleccion>) h.solicitarListaColecciones();

        for (Coleccion coleccion : listaColecciones) {
            cmbColeccion.addItem(coleccion);
        }

    }

    private void refrescarTabla() {

        ArrayList<Comic> listaComics = (ArrayList<Comic>) h.solicitarListaComic();

        TablaComics modeloTabla = new TablaComics(listaComics, h);
        tablaComics.setModel(modeloTabla);

    }

    private void activarAyuda() {

        try {

            URL url;

            if (Locale.getDefault().getLanguage().equalsIgnoreCase("gl")) {
                url = this.getClass().getResource("/ayuda/gal/help.hs");
            } else {
                url = this.getClass().getResource("/ayuda/esp/help.hs");

            }

            // Crea el HelpSet y el HelpBroker
            HelpSet helpset = new HelpSet(null, url);
            HelpBroker hb = helpset.createHelpBroker();

            hb.enableHelpKey(txtTitulo, "panelcomics", helpset);
        } catch (HelpSetException ex) {
            Logger.getLogger(PaginaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void traduccion() {

        ResourceBundle rb = ResourceBundle.getBundle("Idiomas.idioma");

        activarTraduccion(rb);

    }

    private void activarTraduccion(ResourceBundle rb) {

        lblGestionComics.setText(rb.getString("lblGestionComics"));
        lblAnhadir.setText(rb.getString("lblAnhadirComic"));
        lblFechaAdquisicion.setText(rb.getString("lblFechaAdquisicion"));
        btnAnhadirComic.setText(rb.getString("btnA??adir"));

        noImagen = rb.getString("noImagen");
        huboProblema = rb.getString("huboProblema");
        camposObligatorios = rb.getString("camposObligatorios");

        errorCreadoComic = rb.getString("errorCreadoComic");
        comicCreado = rb.getString("comicCreado");
        existeComic = rb.getString("existeComic");
        errorBorradoComic = rb.getString("errorBorradoComic");
        comicEliminado = rb.getString("comicEliminado");
        noExisteComic = rb.getString("noExisteComic");

    }

}
