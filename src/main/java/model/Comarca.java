package model;


import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;


import java.util.List;

@XmlRootElement(name="comarca")
@XmlType(propOrder = {"nombre", "provincia", "ciudad"}) //Para definir el orden
public class Comarca {

    private String nombre;
    private String provincia;
    private List<Ciudad> ciudad;

    public Comarca(String nombre, String provincia, List<Ciudad> ciudad) {
        this.nombre = nombre;
        this.provincia = provincia;
        this.ciudad = ciudad;
    }

    public Comarca() {
    }

    @XmlElement(name = "nombre")
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    @XmlElement(name = "provincia")
    public String getProvincia() {
        return provincia;
    }
    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    @XmlElementWrapper(name="ciudades") //Envoltorio
    @XmlElement(name="ciudad") //Elementos de dentro del envoltorio
    public List<Ciudad> getCiudad() {
        return ciudad;
    }
    public void setCiudad(List<Ciudad> ciudad) {
        this.ciudad = ciudad;
    }
    public void addCiudad (Ciudad c){
        ciudad.add(c);
    }
    private List<Ciudad> getCiudades (){
        return ciudad;
    }
}

