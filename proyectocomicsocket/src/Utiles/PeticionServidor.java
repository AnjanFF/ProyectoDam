package Utiles;

import java.io.Serializable;

/**
 *
 * @author Angel Flores
 * 
 */
public class PeticionServidor implements Serializable{
    private String peticion;
    private Object objeto;

    public PeticionServidor() {
    }

    public PeticionServidor(String peticion, Object objeto) {
        this.peticion = peticion;
        this.objeto = objeto;
    }

    public String getPeticion() {
        return peticion;
    }

    public void setPeticion(String peticion) {
        this.peticion = peticion;
    }

    public Object getObjeto() {
        return objeto;
    }

    public void setObjeto(Object objeto) {
        this.objeto = objeto;
    }

    @Override
    public String toString() {
        return "PeticionServidor{" + "peticion=" + peticion + ", objeto=" + objeto + '}';
    }
    
}
