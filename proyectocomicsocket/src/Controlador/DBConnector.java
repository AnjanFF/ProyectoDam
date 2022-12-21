package Controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 * Clase para establecer conexión con la base de datos
 * @author Angel Flores
 */
public class DBConnector {
    private static Connection Con;
    
    private static String DBNAME = "comics";
    private static String PORT = "3306";
    private static String IP = "localhost";
    
    private static String USER = "root";
    private static String PASSWD = "";

    /**
     * Metodo que conecta a la base de datos con los datos establecidos
     * @return Connection Nos devuelve un objeto de la clase Connection que nos sirve para ejercer diferentes acciones sobre esta conexion 
     */
    public static Connection conectar() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String urlCon = "jdbc:mysql://" + IP + ":" + PORT + "/"+DBNAME;
            Con = DriverManager.getConnection(urlCon, USER, PASSWD);
            Con.setAutoCommit(true);

            return Con;
            
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "No se ha encontrado la librería JDBC");
            System.out.println(ex.getException());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en la conexión. "
                    + "Los datos introducidos no coinciden con ninguna base de datos activa.");
        }
        return null;
    }

    /**
     * 
     * @return Connection Nos devuelve un objeto de la clase Connection que nos sirve para ejercer diferentes acciones sobre esta conexion
     */
    public static Connection getConexion() {
        return Con;
    }

    public static String getDBNAME() {
        return DBNAME;
    }

    public static void setDBNAME(String DBNAME) {
        DBConnector.DBNAME = DBNAME;
    }

    public static String getPORT() {
        return PORT;
    }

    public static void setPORT(String PORT) {
        DBConnector.PORT = PORT;
    }

    public static String getIP() {
        return IP;
    }

    public static void setIP(String IP) {
        DBConnector.IP = IP;
    }

    public static String getUSER() {
        return USER;
    }

    public static void setUSER(String USER) {
        DBConnector.USER = USER;
    }

    public static String getPASSWD() {
        return PASSWD;
    }

    public static void setPASSWD(String PASSWD) {
        DBConnector.PASSWD = PASSWD;
    }
    
    
}
