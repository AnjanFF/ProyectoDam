package Modelo;

import java.io.Serializable;
import java.util.Date;

public class InformeComic implements Serializable {
	private String nombreComic;
	private Date fechaAdquisicion;
	private String tapa;
	private byte[] portada;
	private String nombreAutor;
	private String nombreCol;
	private String estadoDes;
	
	public InformeComic() {
		
	}
	public InformeComic(String nombreComic, Date fechaAdquisicion, String tapa, byte[] portada, String nombreAutor,
			String nombreCol, String estadoDes) {
		super();
		this.nombreComic = nombreComic;
		this.fechaAdquisicion = fechaAdquisicion;
		this.tapa = tapa;
		this.portada = portada;
		this.nombreAutor = nombreAutor;
		this.nombreCol = nombreCol;
		this.estadoDes = estadoDes;
	}
	
	public String getNombreComic() {
		return nombreComic;
	}
	public void setNombreComic(String nombreComic) {
		this.nombreComic = nombreComic;
	}
	public Date getFechaAdquisicion() {
		return fechaAdquisicion;
	}
	public void setFechaAdquisicion(Date fechaAdquisicion) {
		this.fechaAdquisicion = fechaAdquisicion;
	}
	public String getTapa() {
		return tapa;
	}
	public void setTapa(String tapa) {
		this.tapa = tapa;
	}
	public byte[] getPortada() {
		return portada;
	}
	public void setPortada(byte[] portada) {
		this.portada = portada;
	}
	public String getNombreAutor() {
		return nombreAutor;
	}
	public void setNombreAutor(String nombreAutor) {
		this.nombreAutor = nombreAutor;
	}
	public String getNombreCol() {
		return nombreCol;
	}
	public void setNombreCol(String nombreCol) {
		this.nombreCol = nombreCol;
	}
	public String getEstadoDes() {
		return estadoDes;
	}
	public void setEstadoDes(String estadoDes) {
		this.estadoDes = estadoDes;
	}
	
	
	

}
