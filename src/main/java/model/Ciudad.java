package model;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlRootElement(name="ciudad")
@XmlType(propOrder = {"nombre", "cp", "habitantes", "extension"}) //Para que pueda definir el orden
public class Ciudad {

    private String nombre;
    private int cp;
    private int habitantes;
    private float extension;

    public Ciudad(String nombre, int cp, int habitantes, float extension) {
        this.nombre = nombre;
        this.cp = cp;
        this.habitantes = habitantes;
        this.extension = extension;
    }

    public Ciudad() {
    }

    @XmlAttribute(name="nombre") //Para indicar que es un atributo
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlElement(name = "cp")
    public int getCp() {
        return cp;
    }

    public void setCp(int cp) {
        this.cp = cp;
    }


    @XmlElement(name = "habitantes")
    public int getHabitantes() {
        return habitantes;
    }

    public void setHabitantes(int habitantes) {
        this.habitantes = habitantes;
    }

    @XmlElement(name = "extension")
    public float getExtension() {
        return extension;
    }

    public void setExtension(float extension) {
        this.extension = extension;
    }

    @Override
    public String toString() {
        return "Ciudad{" +
                "nombre='" + nombre + '\'' +
                ", cp=" + cp +
                ", habitantes=" + habitantes +
                ", extension=" + extension +
                '}';
    }
}
