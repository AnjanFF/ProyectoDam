package Vista;

import Controlador.HiloCliente;
import Modelo.Autor;
import Modelo.Coleccion;
import Modelo.Comic;
import Modelo.Tabla.TablaComics;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javax.swing.JOptionPane;

/**
 *
 * @author Angel Flores
 * 
 */
public class BuscadorPanel extends javax.swing.JPanel {

    HiloCliente h;

    /**
     * Creates new form BuscadorPanel
     *
     * @param h
     */
    public BuscadorPanel(HiloCliente h) {
        this.h = h;

        initComponents();

        ArrayList<Autor> listaAutores = (ArrayList<Autor>) h.solicitarListaAutores();

        for (Autor autor : listaAutores) {
            cmbAutores.addItem(autor);
        }

        ArrayList<Coleccion> listaColecciones = (ArrayList<Coleccion>) h.solicitarListaColecciones();

        for (Coleccion coleccion : listaColecciones) {
            cmbColeccion.addItem(coleccion);
        }

    }
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        panelColecciones = new javax.swing.JPanel();
        cmbColeccion = new javax.swing.JComboBox<>();
        lblColeccion = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablaComicsColeccion = new javax.swing.JTable();
        jSeparator2 = new javax.swing.JSeparator();
        panelAutores = new javax.swing.JPanel();
        lblAutor = new javax.swing.JLabel();
        cmbAutores = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaComicsAutor = new javax.swing.JTable();
        jSeparator3 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        lblNombre = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        lblFoto = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaComics = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));
        setToolTipText("");
        setPreferredSize(new java.awt.Dimension(700, 635));

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));

        panelColecciones.setBackground(new java.awt.Color(255, 255, 255));

        cmbColeccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbColeccionActionPerformed(evt);
            }
        });

        lblColeccion.setText("Colección");

        tablaComicsColeccion.setModel(new javax.swing.table.DefaultTableModel(
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
        tablaComicsColeccion.setFillsViewportHeight(true);
        tablaComicsColeccion.setRowHeight(75);
        jScrollPane3.setViewportView(tablaComicsColeccion);

        javax.swing.GroupLayout panelColeccionesLayout = new javax.swing.GroupLayout(panelColecciones);
        panelColecciones.setLayout(panelColeccionesLayout);
        panelColeccionesLayout.setHorizontalGroup(
            panelColeccionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelColeccionesLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(panelColeccionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 543, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelColeccionesLayout.createSequentialGroup()
                        .addComponent(lblColeccion, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cmbColeccion, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 587, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(103, Short.MAX_VALUE))
        );
        panelColeccionesLayout.setVerticalGroup(
            panelColeccionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelColeccionesLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(panelColeccionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbColeccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblColeccion))
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(125, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Colecciones", panelColecciones);

        panelAutores.setBackground(new java.awt.Color(255, 255, 255));

        lblAutor.setText("Autor");

        cmbAutores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbAutoresActionPerformed(evt);
            }
        });

        tablaComicsAutor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Portada", "Nombre", "Tapa", "Fecha adquisición", "Estado"
            }
        ));
        tablaComicsAutor.setRowHeight(45);
        jScrollPane1.setViewportView(tablaComicsAutor);

        javax.swing.GroupLayout panelAutoresLayout = new javax.swing.GroupLayout(panelAutores);
        panelAutores.setLayout(panelAutoresLayout);
        panelAutoresLayout.setHorizontalGroup(
            panelAutoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAutoresLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(panelAutoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelAutoresLayout.createSequentialGroup()
                        .addComponent(lblAutor, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(cmbAutores, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 556, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(134, Short.MAX_VALUE))
        );
        panelAutoresLayout.setVerticalGroup(
            panelAutoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAutoresLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(panelAutoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbAutores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblAutor))
                .addGap(21, 21, 21)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(145, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Autores", panelAutores);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        lblNombre.setText("Nombre");

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(this::btnBuscarActionPerformed);

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
        tablaComics.setRowHeight(75);
        jScrollPane2.setViewportView(tablaComics);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(lblNombre)
                        .addGap(18, 18, 18)
                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(btnBuscar))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 543, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 593, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombre)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(116, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Cómics", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 503, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {

        ArrayList<Comic> listaComicsBusqueda = new ArrayList<>();

        ArrayList<Comic> listaComics = (ArrayList<Comic>) h.solicitarListaComic();

        for (Comic comic : listaComics) {
            if (comic.getNombreComic().contains(txtNombre.getText())) {
                listaComicsBusqueda.add(comic);
            }
        }

        TablaComics modeloTabla = new TablaComics(listaComicsBusqueda, h);
        tablaComics.setModel(modeloTabla);


    }

    private void cmbAutoresActionPerformed(java.awt.event.ActionEvent evt) {

        Autor autor = (Autor) cmbAutores.getSelectedItem();

        ArrayList<Comic> listaComics = (ArrayList<Comic>) h.solicitarListaComicAutor(autor.getIdAutor());

        TablaComics modeloTabla = new TablaComics(listaComics, h);
        tablaComicsAutor.setModel(modeloTabla);
    }

    private void cmbColeccionActionPerformed(java.awt.event.ActionEvent evt) {
        Coleccion coleccion = (Coleccion) cmbColeccion.getSelectedItem();

        ArrayList<Comic> listaComics = (ArrayList<Comic>) h.solicitarListaComicColeccion(coleccion.getIdColeccion());

        TablaComics modeloTabla = new TablaComics(listaComics, h);
        tablaComicsColeccion.setModel(modeloTabla);
    }

    private javax.swing.JButton btnBuscar;
    private javax.swing.JComboBox<Autor> cmbAutores;
    private javax.swing.JComboBox<Coleccion> cmbColeccion;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblAutor;
    private javax.swing.JLabel lblColeccion;
    private javax.swing.JLabel lblFoto;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JPanel panelAutores;
    private javax.swing.JPanel panelColecciones;
    private javax.swing.JTable tablaComics;
    private javax.swing.JTable tablaComicsAutor;
    private javax.swing.JTable tablaComicsColeccion;
    private javax.swing.JTextField txtNombre;


    public static boolean validarFecha(String fechaIntroducida) {

        try {

            LocalDate fecha = LocalDate.parse(fechaIntroducida, DateTimeFormatter.ISO_LOCAL_DATE);
            return true;

        } catch (DateTimeParseException ex) {
            return false;
        }
    }

    private byte[] toByteArray(File file) {

        try ( FileInputStream fis = new FileInputStream(file)) {

            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            for (int dataLength; (dataLength = fis.read(buffer)) != -1;) {
                baos.write(buffer, 0, dataLength);
            }

            byte[] imageBytes = baos.toByteArray();

            return imageBytes;

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Hubo un problema con el archivo seleccionado.");

        }

        return null;

    }
}