package Vista;

import Controlador.HiloCliente;
import Modelo.Autor;
import Modelo.Tabla.TablaAutores;
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
import java.awt.GridLayout;
import java.awt.Dimension;

/**
 *
 * @author Angel Flores
 * 
 */
public class GestionAutoresPanel extends javax.swing.JPanel {

    HiloCliente h;
    byte[] image = null;
    private String huboProblema;
    private String noImagen;
    private String noExisteAutor;
    private String errorBorradoAutor;
    private String autorEliminado;
    private String errorCreadoAutor;
    private String autorCreado;
    private String existeAutor;
    private String camposObligatorios;

    /**
     * Creates new form GestionAutoresPanel
     *
     * @param h
     * 
     */
    public GestionAutoresPanel(HiloCliente h) {
        initComponents();

        this.h = h;
        setLayout(new GridLayout(0, 1, 0, 0));
        add(jScrollPane2);
        refrescarTabla();
        traduccion();
    }
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        lblGestionAutores = new javax.swing.JLabel();
        lblNombreAutor = new javax.swing.JLabel();
        txtNombreAutor = new javax.swing.JTextField();
        lblFechaNac = new javax.swing.JLabel();
        lblFoto = new javax.swing.JLabel();
        btnSeleccionFotoActor = new javax.swing.JButton();
        btnAnadir = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablaAutores = new javax.swing.JTable();
        btnModificar = new javax.swing.JButton();
        txtFotoAutor = new javax.swing.JTextField();
        dateChooserFechaNac = new datechooser.beans.DateChooserCombo();
        lblImagen = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setToolTipText("");
        setPreferredSize(new Dimension(711, 657));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setToolTipText("");
        jPanel1.setPreferredSize(new java.awt.Dimension(700, 635));

        lblGestionAutores.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblGestionAutores.setText("Gestión de autores");

        lblNombreAutor.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblNombreAutor.setText("Nombre y apellidos");

        lblFechaNac.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblFechaNac.setText("Fecha de nacimiento");

        lblFoto.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblFoto.setText("Foto");

        btnSeleccionFotoActor.setText(". . .");
        btnSeleccionFotoActor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionFotoActorActionPerformed(evt);
            }
        });

        btnAnadir.setText("Añadir");
        btnAnadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnadirActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        tablaAutores.setModel(new javax.swing.table.DefaultTableModel(
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
        tablaAutores.setRowHeight(140);
        jScrollPane3.setViewportView(tablaAutores);

        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        txtFotoAutor.setEditable(false);

        dateChooserFechaNac.setCurrentView(new datechooser.view.appearance.AppearancesList("Light",
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
    dateChooserFechaNac.setCalendarPreferredSize(new java.awt.Dimension(400, 200));

    javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(
        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel1Layout.createSequentialGroup()
            .addGap(35, 35, 35)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblFechaNac, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblNombreAutor, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtNombreAutor)
                                .addComponent(txtFotoAutor)
                                .addComponent(dateChooserFechaNac, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addComponent(btnAnadir))
                    .addGap(18, 18, 18)
                    .addComponent(btnSeleccionFotoActor)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(lblImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(0, 334, Short.MAX_VALUE)
                            .addComponent(btnModificar)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(btnEliminar))
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblGestionAutores, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(119, 119, 119)))
            .addContainerGap(52, Short.MAX_VALUE))
    );
    jPanel1Layout.setVerticalGroup(
        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel1Layout.createSequentialGroup()
            .addGap(28, 28, 28)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                .addComponent(lblImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addComponent(lblGestionAutores, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnEliminar)
                        .addComponent(btnModificar))
                    .addGap(32, 32, 32)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblNombreAutor)
                                .addComponent(txtNombreAutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(28, 28, 28)
                            .addComponent(lblFechaNac))
                        .addComponent(dateChooserFechaNac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblFoto)
                        .addComponent(btnSeleccionFotoActor)
                        .addComponent(txtFotoAutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addComponent(btnAnadir)))
            .addContainerGap(191, Short.MAX_VALUE))
    );

    jScrollPane2.setViewportView(jPanel1);
    }

    private void btnSeleccionFotoActorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionFotoActorActionPerformed

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("Imágenes", "jpeg", "jpg", "png"));
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

        txtFotoAutor.setText(image.getAbsolutePath());

        this.image = imageBytes;
        lblImagen.setIcon(new ImageIcon(new ImageIcon(this.image).getImage().getScaledInstance(lblImagen.getSize().width,
                lblImagen.getSize().height, Image.SCALE_DEFAULT)));
    }
    
    private void btnAnadirActionPerformed(java.awt.event.ActionEvent evt) {

        if (txtNombreAutor.getText().isEmpty()|| txtFotoAutor.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, camposObligatorios);
        } else {

            Autor autor = new Autor(txtNombreAutor.getText(), dateChooserFechaNac.getSelectedDate().getTime(), image, txtFotoAutor.getText());

            if (h.solicitarGetAutor(txtNombreAutor.getText()) != null) {
                JOptionPane.showMessageDialog(null, existeAutor);
            } else {

                int result = h.solicitarAnhadirAutor(autor);

                if (result == 1) {
                    JOptionPane.showMessageDialog(null, autorCreado);

                    txtNombreAutor.setText("");
                    txtFotoAutor.setText("");
                    lblImagen.setText("");

                    image = null;

                    refrescarTabla();

                } else {
                    JOptionPane.showMessageDialog(null, errorCreadoAutor);
                }

            }

        }

    }

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {

        String nomAutor = (String) tablaAutores.getModel().getValueAt(tablaAutores.getSelectedRow(), 0);

        if (nomAutor == null) {
            JOptionPane.showMessageDialog(null, "No hay un autor seleccionado.");
        } else {
            int opt = JOptionPane.showConfirmDialog(null, "¿Está seguro que desea eliminar el "
                    + "autor con nombre: " + nomAutor + " ? Los cambios realizados son permanentes", "Eliminar un cómic", JOptionPane.YES_NO_OPTION);

            if (opt == JOptionPane.YES_OPTION) {
                int result = h.solicitarEliminarAutor(nomAutor);

                switch (result) {
                    case 1:
                        JOptionPane.showMessageDialog(null, autorEliminado);
                        refrescarTabla();
                        break;
                    case -1:
                        JOptionPane.showMessageDialog(null, "No es posible borrar el autor seleccionado."
                                + "Por seguridad debes borrar antes los cómics en los que participa.");
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, errorBorradoAutor);
                        break;
                }

            }
        }


    }

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {
        String nomAutor = (String) tablaAutores.getModel().getValueAt(tablaAutores.getSelectedRow(), 0);

        Autor autor = h.solicitarGetAutor(nomAutor);

        if (autor != null) {

            ModificarAutorDialog modAutor = new ModificarAutorDialog(null, true, autor, h);
            modAutor.setVisible(true);

            refrescarTabla();

        } else {

            JOptionPane.showMessageDialog(null, noExisteAutor);

        }
    }
    
    private javax.swing.JButton btnAnadir;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnSeleccionFotoActor;
    private datechooser.beans.DateChooserCombo dateChooserFechaNac;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblFechaNac;
    private javax.swing.JLabel lblFoto;
    private javax.swing.JLabel lblGestionAutores;
    private javax.swing.JLabel lblImagen;
    private javax.swing.JLabel lblNombreAutor;
    private javax.swing.JTable tablaAutores;
    private javax.swing.JTextField txtFotoAutor;
    private javax.swing.JTextField txtNombreAutor;
    

    private void refrescarTabla() {

        ArrayList<Autor> listaAutores = (ArrayList<Autor>) h.solicitarListaAutores();

        TablaAutores modeloTabla = new TablaAutores(listaAutores);
        tablaAutores.setModel(modeloTabla);

    }

    private void traduccion() {

        ResourceBundle rb = ResourceBundle.getBundle("Idiomas.idioma");

        activarTraduccion(rb);

    }

    private void activarTraduccion(ResourceBundle rb) {

        lblGestionAutores.setText(rb.getString("lblGestionAutores"));
        lblNombreAutor.setText(rb.getString("lblNombreAutor"));
        lblFechaNac.setText(rb.getString("lblFechaNac"));
        btnAnadir.setText(rb.getString("btnAñadir"));
        huboProblema = rb.getString("huboProblema");
        noImagen = rb.getString("noImagen");
        noExisteAutor = rb.getString("noExisteAutor");
        errorBorradoAutor = rb.getString("errorBorradoAutor");
        autorEliminado = rb.getString("autorEliminado");
        errorCreadoAutor = rb.getString("errorCreadoAutor");
        autorCreado = rb.getString("autorCreado");
        existeAutor = rb.getString("existeAutor");
        camposObligatorios = rb.getString("camposObligatorios");

    }
}
