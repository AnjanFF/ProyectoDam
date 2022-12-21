package Controlador;

import Modelo.Autor;
import Modelo.Coleccion;
import Modelo.Comic;
import Modelo.DataSource;
import Modelo.Estado;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import javax.swing.JOptionPane;

/**
 *
 * @author Angel Flores
 * 
 */
public class GestionComics {

    /**
     * *
     * Método para obtener todos los cómics añadidos en la BD
     *
     * @return List(Comic) Devuelve una lista cargada a través de una consulta a
     * la BD con objetos de la clase cómic
     */
    public static List<Comic> getListaComics() {

        Connection con;
        ResultSet rs = null;

        List<Comic> listaComics = new ArrayList();
        try {

            con = DBConnector.getConexion();

            String consulta = "Select * from comic";
            PreparedStatement sentencia = con.prepareStatement(consulta);

            rs = sentencia.executeQuery();

            while (rs.next()) {

                Comic comic = new Comic(rs.getInt(1), rs.getString(2), rs.getDate(3), rs.getString(4), rs.getInt(5), rs.getInt(6), rs.getBytes(7), rs.getString(8), rs.getInt(9));
                listaComics.add(comic);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Obtener listado de cómics", JOptionPane.OK_OPTION);
        } finally {
            try {
                rs.close();
            } catch (SQLException ex) {

            }
        }
        return listaComics;
    }

    public static List<Comic> getListaComicsAutor(int idAutor) {

        Connection con;
        ResultSet rs = null;

        List<Comic> listaComics = new ArrayList();
        try {

            con = DBConnector.getConexion();

            String consulta = "Select * from comic WHERE idAutor = ?";
            PreparedStatement sentencia = con.prepareStatement(consulta);

            sentencia.setInt(1, idAutor);

            rs = sentencia.executeQuery();

            while (rs.next()) {

                Comic comic = new Comic(rs.getInt(1), rs.getString(2), rs.getDate(3), rs.getString(4), rs.getInt(5), rs.getInt(6), rs.getBytes(7), rs.getString(8), rs.getInt(9));
                listaComics.add(comic);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Obtener listado de cómics", JOptionPane.OK_OPTION);
        } finally {
            try {
                rs.close();
            } catch (SQLException ex) {

            }
        }
        return listaComics;
    }

    public static List<Comic> getListaComicsColeccion(int idColeccion) {

        Connection con;
        ResultSet rs = null;

        List<Comic> listaComics = new ArrayList();
        try {

            con = DBConnector.getConexion();

            String consulta = "Select * from comic WHERE idColeccion = ?";
            PreparedStatement sentencia = con.prepareStatement(consulta);

            sentencia.setInt(1, idColeccion);

            rs = sentencia.executeQuery();

            while (rs.next()) {

                Comic comic = new Comic(rs.getInt(1), rs.getString(2), rs.getDate(3), rs.getString(4), rs.getInt(5), rs.getInt(6), rs.getBytes(7), rs.getString(8), rs.getInt(9));
                listaComics.add(comic);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Obtener listado de cómics", JOptionPane.OK_OPTION);
        } finally {
            try {
                rs.close();
            } catch (SQLException ex) {

            }
        }
        return listaComics;
    }

    /**
     * Método para obtener todos las colecciones añadidas en la BD
     *
     * @return List(Coleccion) Devuelve una lista cargada a través de una
     * consulta a la BD con objetos de la clase colección
     */
    public static List<Coleccion> getListaColecciones() {

        Connection con;
        ResultSet rs = null;

        List<Coleccion> listaColecciones = new ArrayList();
        try {

            con = DBConnector.getConexion();

            String consulta = "Select * from coleccion";
            PreparedStatement sentencia = con.prepareStatement(consulta);

            rs = sentencia.executeQuery();

            while (rs.next()) {
                listaColecciones.add(new Coleccion(rs.getInt(1), rs.getString(2), rs.getString(3)));
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Obtener listado de colecciones", JOptionPane.OK_OPTION);
        } finally {
            try {
                rs.close();
            } catch (SQLException ex) {

            }
        }
        return listaColecciones;
    }

    public static List<Autor> getListaAutores() {

        Connection con;
        ResultSet rs = null;

        List<Autor> listaAutores = new ArrayList();
        try {

            con = DBConnector.getConexion();

            String consulta = "Select * from autor";
            PreparedStatement sentencia = con.prepareStatement(consulta);

            rs = sentencia.executeQuery();

            while (rs.next()) {
                listaAutores.add(new Autor(rs.getInt(1), rs.getString(2), rs.getDate(3), rs.getBytes(4), rs.getString(5)));
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Obtener listado de autores", JOptionPane.OK_OPTION);
        } finally {
            try {
                rs.close();
            } catch (SQLException ex) {

            }
        }
        return listaAutores;
    }

    public static List<Estado> getListaEstado() {

        Connection con;
        ResultSet rs = null;

        List<Estado> listaEstado = new ArrayList();
        try {

            con = DBConnector.getConexion();

            String consulta = "SELECT * FROM estado";
            PreparedStatement sentencia = con.prepareStatement(consulta);

            rs = sentencia.executeQuery();

            while (rs.next()) {
                listaEstado.add(new Estado(rs.getInt(1), rs.getString(2)));
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Obtener listado de autores", JOptionPane.OK_OPTION);
        } finally {
            try {
                rs.close();
            } catch (SQLException ex) {

            }
        }
        return listaEstado;
    }

    public static Comic getComic(String nomComic) {

        Connection con;
        ResultSet rs = null;

        try {

            con = DBConnector.getConexion();

            String consulta = "SELECT * FROM comic WHERE nombre = ?";
            PreparedStatement sentencia = con.prepareStatement(consulta);

            sentencia.setString(1, nomComic);

            rs = sentencia.executeQuery();

            if (rs.next()) {

                return new Comic(rs.getInt(1), rs.getString(2), rs.getDate(3), rs.getString(4), rs.getInt(5), rs.getInt(6), rs.getBytes(7), rs.getString(8), rs.getInt(9));
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Buscar un cómic", JOptionPane.OK_OPTION);
        } finally {
            try {
                rs.close();
            } catch (SQLException ex) {

            }
        }
        return null;
    }

    public static Autor getAutor(String nomAutor) {

        Connection con;
        ResultSet rs = null;

        try {

            con = DBConnector.getConexion();

            String consulta = "SELECT * FROM autor WHERE nombre = ?";
            PreparedStatement sentencia = con.prepareStatement(consulta);

            sentencia.setString(1, nomAutor);

            rs = sentencia.executeQuery();

            if (rs.next()) {
                return new Autor(rs.getInt(1), rs.getString(2), rs.getDate(3), rs.getBytes(4), rs.getString(5));
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Buscar un autor", JOptionPane.OK_OPTION);
        } finally {
            try {
                rs.close();
            } catch (SQLException ex) {

            }
        }
        return null;
    }

    public static Coleccion getColeccion(String nomColeccion) {

        Connection con;
        ResultSet rs = null;

        try {

            con = DBConnector.getConexion();

            String consulta = "SELECT * FROM coleccion WHERE nombre = ?";
            PreparedStatement sentencia = con.prepareStatement(consulta);

            sentencia.setString(1, nomColeccion);

            rs = sentencia.executeQuery();

            if (rs.next()) {
                return new Coleccion(rs.getInt(1), rs.getString(2), rs.getString(3));
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Buscar una coleccion", JOptionPane.OK_OPTION);
        } finally {
            try {
                rs.close();
            } catch (SQLException ex) {

            }
        }
        return null;
    }

    public static Estado getEstado(int idEstado) {

        Connection con;
        ResultSet rs = null;

        try {

            con = DBConnector.getConexion();

            String consulta = "SELECT * FROM estado WHERE idEstado = ?";
            PreparedStatement sentencia = con.prepareStatement(consulta);

            sentencia.setInt(1, idEstado);

            rs = sentencia.executeQuery();

            if (rs.next()) {
                return new Estado(rs.getInt(1), rs.getString(2));
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Buscar un estado", JOptionPane.OK_OPTION);
        } finally {
            try {
                rs.close();
            } catch (SQLException ex) {

            }
        }
        return null;
    }

    public static int anhadirComic(Comic comic) {

        Connection con;

        try {

            con = DBConnector.getConexion();

            String consulta = "INSERT INTO comic (nombre, fechaAdquisicion, tapa, idEstado, idAutor, portada, urlPortada, idColeccion)"
                    + "VALUES (?,?,?,?,?,?,?,?)";

            PreparedStatement sentencia = con.prepareStatement(consulta);

            sentencia.setString(1, comic.getNombreComic());
            sentencia.setDate(2, new java.sql.Date(comic.getFechaAdquisicion().getTime()));
            sentencia.setString(3, comic.getTapa());
            sentencia.setInt(4, comic.getIdEstado());
            sentencia.setInt(5, comic.getIdAutor());
            sentencia.setBytes(6, comic.getPortada());

            sentencia.setString(7, comic.getUrlPortada());
            sentencia.setInt(8, comic.getIdColeccion());

            return sentencia.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, e.getMessage(), "Añadir comic", JOptionPane.OK_OPTION);
        }

        return -1;
    }

    public static int anhadirColeccion(Coleccion coleccion) {

        Connection con;

        try {

            con = DBConnector.getConexion();

            String consulta = "INSERT INTO coleccion (nombre, edicion)"
                    + "VALUES (?,?)";

            PreparedStatement sentencia = con.prepareStatement(consulta);

            sentencia.setString(1, coleccion.getNombre());
            sentencia.setString(2, coleccion.getEdicion());

            return sentencia.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, e.getMessage(), "Añadir comic", JOptionPane.OK_OPTION);
        }

        return -1;
    }

    public static int anhadirAutor(Autor autor) {

        Connection con;

        try {

            con = DBConnector.getConexion();

            String consulta = "INSERT INTO autor (nombre, fechaNac, foto, urlFoto)"
                    + "VALUES (?, ?, ?, ?)";

            PreparedStatement sentencia = con.prepareStatement(consulta);

            sentencia.setString(1, autor.getNombre());
            sentencia.setDate(2, new java.sql.Date(autor.getFechaNac().getTime()));
            sentencia.setBytes(3, autor.getFoto());
            sentencia.setString(4, autor.getUrlFoto());

            return sentencia.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, e.getMessage(), "Añadir autor", JOptionPane.OK_OPTION);
        }

        return 0;
    }

    public static int updateAutor(Autor autor) {

        Connection con;

        try {

            con = DBConnector.getConexion();

            String consulta = "UPDATE autor SET nombre = ?, fechaNac = ?, foto = ?, urlFoto = ? "
                    + "WHERE idAutor = ?";

            PreparedStatement sentencia = con.prepareStatement(consulta);

            sentencia.setString(1, autor.getNombre());
            sentencia.setDate(2, new java.sql.Date(autor.getFechaNac().getTime()));

            sentencia.setBytes(3, autor.getFoto());
            sentencia.setString(4, autor.getUrlFoto());

            sentencia.setInt(5, autor.getIdAutor());

            return sentencia.executeUpdate();

        } catch (SQLException e) {
            return -1;
        }

    }

    public static int updateComic(Comic comic) {

        Connection con;

        try {

            con = DBConnector.getConexion();

            String consulta = "UPDATE comic SET nombre = ?, fechaAdquisicion = ?,"
                    + "tapa = ?, idEstado = ?, idAutor = ?, portada = ?, urlPortada = ?"
                    + "WHERE idComic = ?";

            PreparedStatement sentencia = con.prepareStatement(consulta);

            sentencia.setString(1, comic.getNombreComic());
            sentencia.setDate(2, new java.sql.Date(comic.getFechaAdquisicion().getTime()));
            sentencia.setString(3, comic.getTapa());
            sentencia.setInt(4, comic.getIdEstado());
            sentencia.setInt(5, comic.getIdAutor());

            sentencia.setBytes(6, comic.getPortada());
            sentencia.setString(7, comic.getUrlPortada());
           
            sentencia.setInt(8, comic.getIdComic());

            return sentencia.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return -1;
        }

    }

    public static int eliminarComic(String nomComic) {

        Connection con;

        try {

            con = DBConnector.getConexion();

            String consulta = "DELETE FROM comic WHERE nombre = ?";

            PreparedStatement sentencia = con.prepareStatement(consulta);

            sentencia.setString(1, nomComic);

            return sentencia.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, e.getMessage(), "Eliminar comic", JOptionPane.OK_OPTION);
        }

        return 0;
    }

    public static int eliminarColeccion(String nomColeccion) {

        Connection con;

        try {

            con = DBConnector.getConexion();

            String consulta = "DELETE FROM coleccion WHERE nombre = ?";

            PreparedStatement sentencia = con.prepareStatement(consulta);

            sentencia.setString(1, nomColeccion);

            return sentencia.executeUpdate();

        } catch (SQLException e) {
            return -1;
        }

    }

    public static int eliminarAutor(String nomAutor) {

        Connection con;

        try {

            con = DBConnector.getConexion();

            String consulta = "DELETE FROM autor WHERE nombre = ?";

            PreparedStatement sentencia = con.prepareStatement(consulta);

            sentencia.setString(1, nomAutor);

            return sentencia.executeUpdate();

        } catch (SQLException e) {
            return -1;
        }

    }

    public static BufferedImage getImage(byte[] bytes) {

        ByteArrayInputStream bis = new ByteArrayInputStream(bytes);

        try {
            BufferedImage newImage = ImageIO.read(bis);
            return newImage;

        } catch (IOException ex) {
            Logger.getLogger(GestionComics.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;

    }

    public static Image getImage(byte[] bytes, boolean isThumbnail) throws IOException {

        ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
        Iterator readers = ImageIO.getImageReadersByFormatName("png");
        ImageReader reader = (ImageReader) readers.next();
        Object source = bis; // File or InputStream
        ImageInputStream iis = ImageIO.createImageInputStream(source);
        reader.setInput(iis, true);
        ImageReadParam param = reader.getDefaultReadParam();
        if (isThumbnail) {

            param.setSourceSubsampling(4, 4, 0, 0);

        }
        return reader.read(0, param);

    }

	public static JasperPrint getInformeComic() {

        Connection con;
        JasperPrint visor=null;
        ResultSet rs = null;
        try {

            con = DBConnector.getConexion();

            Statement st =con.createStatement();
            rs = st.executeQuery("SELECT comic.nombre, comic.fechaAdquisicion, comic.tapa, comic.portada, autor.nombre AS \"nombreAutor\", coleccion.nombre AS \"nombreColeccion\", estado.descripcion AS \"estado\" FROM comic\n"
                    + "	INNER JOIN autor ON comic.idAutor = autor.idAutor\n"
                    + "	INNER JOIN coleccion ON comic.idColeccion = coleccion.idColeccion\n"
                    + "	INNER JOIN estado ON comic.idEstado = estado.idEstado");

            JRResultSetDataSource dataSource = new JRResultSetDataSource(rs);

            JasperReport report = JasperCompileManager.compileReport("./Informes/InformeComics.jrxml");

            visor = JasperFillManager.fillReport(report, null, dataSource);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Obtener listado de informeComics", JOptionPane.OK_OPTION);
        } catch (JRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
            try {
                rs.close();
            } catch (SQLException ex) {

            }
        }
		return visor;
    }
	
	public static JasperPrint getInformeComicColeccion(Coleccion coleccion) {
		Connection con;
		JasperPrint visor=null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
		con = DBConnector.getConexion();
        st = con.prepareStatement("SELECT comic.nombre, comic.fechaAdquisicion, comic.tapa, comic.portada, \n" +
                                    "autor.nombre AS \"nombreAutor\",\n" +
                                    "coleccion.nombre AS \"nombreColeccion\",\n" +
                                    "estado.descripcion AS \"estado\"\n" +
                                    " 	FROM comic INNER JOIN autor ON comic.idAutor = autor.idAutor\n" +
                                    "						INNER JOIN coleccion ON comic.idColeccion = coleccion.idColeccion\n" +
                                    "						INNER JOIN estado ON comic.idEstado = estado.idEstado \n" +
                                    "                    	WHERE comic.idColeccion =  ? ");
        st.setInt(1, coleccion.getIdColeccion());

        rs = st.executeQuery();

        JRResultSetDataSource dataSource = new JRResultSetDataSource(rs);

        HashMap<String, Object> parametros = new HashMap<>();
        parametros.put("idColeccion", coleccion.getIdColeccion());

        JasperReport report = JasperCompileManager.compileReport("./src/Informes/InformeComicsColeccion.jrxml");

        visor = JasperFillManager.fillReport(report, parametros, dataSource);
		} catch (SQLException e) {
	            JOptionPane.showMessageDialog(null, e.getMessage(), "Obtener listado de informeComics", JOptionPane.OK_OPTION);
        } catch (JRException e) {
				// TODO Auto-generated catch block
		e.printStackTrace();
		} finally {
            try {
                rs.close();
            } catch (SQLException ex) {

            }
        }
			return visor;
	    }
	
	public static JasperPrint getInformeAutor() {

        Connection con;
        JasperPrint visor=null;
        ResultSet rs = null;
        try {

            con = DBConnector.getConexion();

            Statement st =con.createStatement();
            
            rs = st.executeQuery("SELECT * FROM comics.autor");

            JRResultSetDataSource dataSource = new JRResultSetDataSource(rs);

            JasperReport report = JasperCompileManager.compileReport("./Informes/InformeAutores.jrxml");

            visor = JasperFillManager.fillReport(report, null, dataSource);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Obtener listado de informeAutor", JOptionPane.OK_OPTION);
        } catch (JRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
            try {
                rs.close();
            } catch (SQLException ex) {

            }
        }
		return visor;
    }

	public static JasperPrint getInformeAutorComic(Autor autor) {
		
		Connection con;
		JasperPrint visor=null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
		con = DBConnector.getConexion();
        st = con.prepareStatement("SELECT comic.nombre, comic.fechaAdquisicion, comic.tapa, comic.portada, autor.nombre AS \"nombreAutor\", coleccion.nombre AS \"nombreColeccion\", estado.descripcion AS \"estado\" FROM comic\n" +
                "INNER JOIN autor ON comic.idAutor = autor.idAutor\n" +
                "INNER JOIN coleccion ON comic.idColeccion = coleccion.idColeccion\n" +
                "INNER JOIN estado ON comic.idEstado = estado.idEstado\n" +
                    "	WHERE comic.idAutor =  ? ");
        st.setInt(1, autor.getIdAutor());

        rs = st.executeQuery();

        JRResultSetDataSource dataSource = new JRResultSetDataSource(rs);

        HashMap<String, Object> parametros = new HashMap<>();
        parametros.put("idAutor", autor.getIdAutor());

        JasperReport report = JasperCompileManager.compileReport("./src/Informes/InformeComicsAutor.jrxml");

        visor = JasperFillManager.fillReport(report, parametros, dataSource);
		} catch (SQLException e) {
	            JOptionPane.showMessageDialog(null, e.getMessage(), "Obtener listado de informeComics", JOptionPane.OK_OPTION);
        } catch (JRException e) {
				// TODO Auto-generated catch block
		e.printStackTrace();
		} finally {
            try {
                rs.close();
            } catch (SQLException ex) {

            }
        }
			return visor;
	    }
}
