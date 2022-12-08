/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;


import Controlador.DBConnector;
import Controlador.HiloCliente;
import Modelo.Autor;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;
import javax.swing.JOptionPane;
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
public class InformesAutoresPanel extends javax.swing.JPanel {

    /**
     *
     * Creates new Panel Informes Autores
     *
     */
    public InformesAutoresPanel(HiloCliente h) {
        initComponents();

        ArrayList<Autor> listaAutores = (ArrayList<Autor>) h.solicitarListaAutores();
        
        for (Autor autor : listaAutores) {
            cmbAutor.addItem(autor);
        }
        
        traduccion();

    }

    private void initComponents() {

        VerInformeAutores = new javax.swing.JButton();
        VerInformeComicsAutor = new javax.swing.JButton();
        lblAutor = new javax.swing.JLabel();
        lblGeneracionInformesAutores = new javax.swing.JLabel();
        cmbAutor = new javax.swing.JComboBox<>();

        setBackground(new java.awt.Color(255, 255, 255));
        setToolTipText("");
        setPreferredSize(new java.awt.Dimension(518, 491));

        VerInformeAutores.setBackground(new java.awt.Color(66, 66, 66));
        VerInformeAutores.setForeground(new java.awt.Color(255, 255, 255));
        VerInformeAutores.setText("Ver informe de autores");
        VerInformeAutores.setBorderPainted(false);
        VerInformeAutores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VerInformeAutoresActionPerformed(evt);
            }
        });

        VerInformeComicsAutor.setBackground(new java.awt.Color(66, 66, 66));
        VerInformeComicsAutor.setForeground(new java.awt.Color(255, 255, 255));
        VerInformeComicsAutor.setText("Ver informe de cómics por autor");
        VerInformeComicsAutor.setBorderPainted(false);
        VerInformeComicsAutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VerInformeComicsAutorActionPerformed(evt);
            }
        });

        lblAutor.setText("Autor:");

        lblGeneracionInformesAutores.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblGeneracionInformesAutores.setText("Generación de informes: Autores");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(VerInformeAutores, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(VerInformeComicsAutor, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblAutor)
                        .addGap(18, 18, 18)
                        .addComponent(cmbAutor, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblGeneracionInformesAutores))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(lblGeneracionInformesAutores)
                .addGap(32, 32, 32)
                .addComponent(VerInformeAutores)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(VerInformeComicsAutor)
                    .addComponent(lblAutor)
                    .addComponent(cmbAutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(336, Short.MAX_VALUE))
        );
    }

    private void VerInformeAutoresActionPerformed(java.awt.event.ActionEvent evt) {
     String informe = "./src/Informes/InformeAutores.jrxml";

        try {

            Statement st = DBConnector.getConexion().createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM comics.autor");

            JRResultSetDataSource dataSource = new JRResultSetDataSource(rs);

            JasperReport report = JasperCompileManager.compileReport(informe);

            JasperPrint visor = JasperFillManager.fillReport(report, null, dataSource);

            JasperViewer.viewReport(visor, false);

        } catch (SQLException | JRException e) {
            System.out.println(e.getMessage());
        }

    }

    private void VerInformeComicsAutorActionPerformed(java.awt.event.ActionEvent evt) {
        String informe = "./src/Informes/InformeComicsAutor.jrxml";

        try {
            Autor autor = (Autor) cmbAutor.getSelectedItem();

            PreparedStatement st = DBConnector.getConexion().prepareStatement("SELECT comic.nombre, comic.fechaAdquisicion, comic.tapa, comic.portada, autor.nombre AS \"nombreAutor\", coleccion.nombre AS \"nombreColeccion\", estado.descripcion AS \"estado\" FROM comic\n" +
                "INNER JOIN autor ON comic.idAutor = autor.idAutor\n" +
                "INNER JOIN coleccion ON comic.idColeccion = coleccion.idColeccion\n" +
                "INNER JOIN estado ON comic.idEstado = estado.idEstado\n" +
                    "	WHERE comic.idAutor =  ? ");
            st.setInt(1, autor.getIdAutor());

            ResultSet rs = st.executeQuery();

            JRResultSetDataSource dataSource = new JRResultSetDataSource(rs);

            HashMap<String, Object> parametros = new HashMap<>();
            parametros.put("idAutor", autor.getIdAutor());

            JasperReport report = JasperCompileManager.compileReport(informe);

            JasperPrint visor = JasperFillManager.fillReport(report, parametros, dataSource);

            JasperViewer.viewReport(visor, false);

        } catch (SQLException | JRException e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error en la generación del informe.");
        }

    }
    private javax.swing.JButton VerInformeAutores;
    private javax.swing.JButton VerInformeComicsAutor;
    private javax.swing.JComboBox<Autor> cmbAutor;
    private javax.swing.JLabel lblAutor;
    private javax.swing.JLabel lblGeneracionInformesAutores;

    private void traduccion() {

        ResourceBundle rb = ResourceBundle.getBundle("Idiomas.idioma");

        activarTraduccion(rb);

    }

    private void activarTraduccion(ResourceBundle rb) {

        lblGeneracionInformesAutores.setText(rb.getString("lblGeneracionInformesAutores"));

    }
}
