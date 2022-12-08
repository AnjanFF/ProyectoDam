package Vista;

import Controlador.DBConnector;
import Controlador.HiloServidor;

import java.awt.*;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.help.HelpBroker;
import javax.help.HelpSet;
import javax.help.HelpSetException;
import javax.swing.*;

/**
 *
 * @author Angel Flores
 *
 */
public class ServerFile extends JFrame {

    ServerSocket skServidor;
    HiloServidor hs = null;
    

    /**
     *
     * Creates new form ServerFile
     *
     */
    public ServerFile() {
        initComponents();
        
        DBConnector.conectar();
        
        SelectorLenguaje selectorLenguaje = new SelectorLenguaje();
        selectorLenguaje.setVisible(true);
        
        
    }


    private void initComponents() {

        JPanel jPanel1 = new JPanel();
        jPanel2 = new JPanel();
        lblEstadoServidor = new JLabel();
        JLabel lblServer = new JLabel();
        btnConectar = new JButton();
        btnDesconectar = new JButton();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new Color(255, 255, 255));

        jPanel2.setBackground(new Color(66, 66, 66));

        lblEstadoServidor.setFont(new Font("Tahoma", Font.BOLD, 12)); // NOI18N
        lblEstadoServidor.setForeground(new Color(204, 0, 51));
        lblEstadoServidor.setText("APAGADO");

        lblServer.setFont(new Font("Tahoma", Font.BOLD, 14)); // NOI18N
        lblServer.setForeground(new Color(255, 255, 255));
        lblServer.setText("SERVER");

        GroupLayout gl_jPanel2 = new GroupLayout(jPanel2);
        jPanel2.setLayout(gl_jPanel2);
        gl_jPanel2.setHorizontalGroup(
            gl_jPanel2.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(gl_jPanel2.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(gl_jPanel2.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(lblServer)
                    .addComponent(lblEstadoServidor))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        gl_jPanel2.setVerticalGroup(
            gl_jPanel2.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(gl_jPanel2.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblEstadoServidor)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblServer)
                .addContainerGap())
        );

        btnConectar.setBackground(new Color(66, 66, 66));
        btnConectar.setForeground(new Color(255, 255, 255));
        btnConectar.setText("Conectar");
        btnConectar.setBorderPainted(false);
        btnConectar.addActionListener(evt -> btnConectarActionPerformed(evt));

        btnDesconectar.setBackground(new Color(66, 66, 66));
        btnDesconectar.setForeground(new Color(255, 255, 255));
        btnDesconectar.setText("Desconectar");
        btnDesconectar.setBorderPainted(false);
        btnDesconectar.addActionListener(evt -> btnDesconectarActionPerformed(evt));

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(btnDesconectar, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnConectar, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(39, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDesconectar)
                    .addComponent(btnConectar))
                .addGap(37, 37, 37))
            .addComponent(jPanel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }

    private void btnDesconectarActionPerformed(java.awt.event.ActionEvent ignoredEvt) {
        try {
            if (!skServidor.isClosed() && skServidor != null) {

                skServidor.close();
                hs.apagarServidor();

                lblEstadoServidor.setText("APAGADO");
                lblEstadoServidor.setForeground(Color.RED);
                jPanel2.setBackground(new Color(66,66,66));

            }

        } catch (java.net.SocketException s) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error con el servidor.");
        } catch (IOException ex) {
            Logger.getLogger(ServerFile.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void btnConectarActionPerformed(java.awt.event.ActionEvent ignoredEvt) {
        try {

            skServidor = new ServerSocket(2000);

            System.out.println("Escuchando en el puerto " + 2000);
            lblEstadoServidor.setText("ENCENDIDO");
            lblEstadoServidor.setForeground(Color.BLACK);
            jPanel2.setBackground(Color.GREEN);

            hs = new HiloServidor(skServidor);

            hs.start();

        } catch (IOException ex) {
            Logger.getLogger(ServerFile.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | UnsupportedLookAndFeelException | IllegalAccessException |
                 InstantiationException ex) {
            Logger.getLogger(ServerFile.class.getName()).log(Level.SEVERE, null, ex);
        }
        EventQueue.invokeLater(() -> new ServerFile().setVisible(true));
    }

    private JButton btnConectar;
    private JButton btnDesconectar;
    private JLabel lblEstadoServidor;
    private JPanel jPanel2;


     private void activarAyuda() {

        try {
            URL url = this.getClass().getResource("/ayuda/esp/help.hs");

            //HelpSet
            HelpSet helpset = new HelpSet(null, url);
            HelpBroker hb = helpset.createHelpBroker();

            hb.enableHelpKey(btnConectar, "servidor", helpset);
            hb.enableHelpKey(btnDesconectar, "servidor", helpset);
            
        } catch (HelpSetException ex) {
            Logger.getLogger(PaginaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
