/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.DBConnector;
import Controlador.HiloCliente;
import Modelo.Coleccion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Angel Flores
 * 
 */
public class InformesComicsPanel extends javax.swing.JPanel {

    /**
     *
     * Creates Panel Informes Comics
     *
     */
    public InformesComicsPanel(HiloCliente h) {
        initComponents();

        ArrayList<Coleccion> listaColecciones = (ArrayList<Coleccion>) h.solicitarListaColecciones();

        for (Coleccion coleccion : listaColecciones) {
            cmbColeccion.addItem(coleccion);
        }

        traduccion();

    }

    private void initComponents() {

        VerInformeComics = new javax.swing.JButton();
        VerInformeComicsColeccion = new javax.swing.JButton();
        lblGeneracionInformesComics = new javax.swing.JLabel();
        cmbColeccion = new javax.swing.JComboBox<>();
        lblColeccion = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setToolTipText("");
        setPreferredSize(new java.awt.Dimension(518, 491));

        VerInformeComics.setBackground(new java.awt.Color(66, 66, 66));
        VerInformeComics.setForeground(new java.awt.Color(255, 255, 255));
        VerInformeComics.setText("Ver informe de c??mics");
        VerInformeComics.setBorderPainted(false);
        VerInformeComics.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VerInformeComicsActionPerformed(evt);
            }
        });

        VerInformeComicsColeccion.setBackground(new java.awt.Color(66, 66, 66));
        VerInformeComicsColeccion.setForeground(new java.awt.Color(255, 255, 255));
        VerInformeComicsColeccion.setText("Ver informe de c??mics por colecci??n");
        VerInformeComicsColeccion.setBorderPainted(false);
        VerInformeComicsColeccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VerInformeComicsColeccionActionPerformed(evt);
            }
        });

        lblGeneracionInformesComics.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblGeneracionInformesComics.setText("Generaci??n de informes: C??mics");

        lblColeccion.setText("Colecci??n:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(VerInformeComics, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblGeneracionInformesComics))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(VerInformeComicsColeccion, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblColeccion)
                        .addGap(18, 18, 18)
                        .addComponent(cmbColeccion, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(lblGeneracionInformesComics)
                .addGap(18, 18, 18)
                .addComponent(VerInformeComics)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblColeccion)
                        .addComponent(cmbColeccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(VerInformeComicsColeccion))
                .addContainerGap(365, Short.MAX_VALUE))
        );
    }

    private void VerInformeComicsActionPerformed(java.awt.event.ActionEvent evt) {
        try {

            Statement st = DBConnector.getConexion().createStatement();
            ResultSet rs = st.executeQuery("SELECT comic.nombre, comic.fechaAdquisicion, comic.tapa, comic.portada, autor.nombre AS \"nombreAutor\", coleccion.nombre AS \"nombreColeccion\", estado.descripcion AS \"estado\" FROM comic\n"
                    + "	INNER JOIN autor ON comic.idAutor = autor.idAutor\n"
                    + "	INNER JOIN coleccion ON comic.idColeccion = coleccion.idColeccion\n"
                    + "	INNER JOIN estado ON comic.idEstado = estado.idEstado");

            JRResultSetDataSource dataSource = new JRResultSetDataSource(rs);

            JasperReport report = JasperCompileManager.compileReport("./Informes/InformeComics.jrxml");

            JasperPrint visor = JasperFillManager.fillReport(report, null, dataSource);

            JasperViewer.viewReport(visor, false);

        } catch (SQLException | JRException e) {
            e.printStackTrace();
        }

    }

    private void VerInformeComicsColeccionActionPerformed(java.awt.event.ActionEvent evt) {
        try {

            Coleccion coleccion = (Coleccion) cmbColeccion.getSelectedItem();

            PreparedStatement st = DBConnector.getConexion().prepareStatement("SELECT comic.nombre, comic.fechaAdquisicion, comic.tapa, comic.portada, \n" +
                                        "autor.nombre AS \"nombreAutor\",\n" +
                                        "coleccion.nombre AS \"nombreColeccion\",\n" +
                                        "estado.descripcion AS \"estado\"\n" +
                                        " 	FROM comic INNER JOIN autor ON comic.idAutor = autor.idAutor\n" +
                                        "						INNER JOIN coleccion ON comic.idColeccion = coleccion.idColeccion\n" +
                                        "						INNER JOIN estado ON comic.idEstado = estado.idEstado \n" +
                                        "                    	WHERE comic.idColeccion =  ? ");
            st.setInt(1, coleccion.getIdColeccion());

            ResultSet rs = st.executeQuery();

            JRResultSetDataSource dataSource = new JRResultSetDataSource(rs);

            HashMap<String, Object> parametros = new HashMap<>();
            parametros.put("idColeccion", coleccion.getIdColeccion());

            JasperReport report = JasperCompileManager.compileReport("./src/Informes/InformeComicsColeccion.jrxml");

            JasperPrint visor = JasperFillManager.fillReport(report, parametros, dataSource);

            JasperViewer.viewReport(visor, false);

        } catch (SQLException | JRException e) {
            System.out.println(e.getMessage());
        }

    }
    private javax.swing.JButton VerInformeComics;
    private javax.swing.JButton VerInformeComicsColeccion;
    private javax.swing.JComboBox<Coleccion> cmbColeccion;
    private javax.swing.JLabel lblColeccion;
    private javax.swing.JLabel lblGeneracionInformesComics;

    private void traduccion() {

        ResourceBundle rb = ResourceBundle.getBundle("Idiomas.idioma");

        activarTraduccion(rb);

    }

    private void activarTraduccion(ResourceBundle rb) {

        lblGeneracionInformesComics.setText(rb.getString("lblGeneracionInformesComics"));

    }
}
