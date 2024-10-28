import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;

import model.Ciudad;
import model.Comarca;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class EscrituraJaxb {
    public static void main(String[] args) {
        JAXBContext context;
        try {
            //Paso la clase al contexto
            context = JAXBContext.newInstance(Comarca.class);

            //Convierto el obj. a XML
            Marshaller marshaller = context.createMarshaller();

            //Creo una nueva comarca y le paso los atributos
            Comarca comarca = new Comarca();
            comarca.setNombre("Comarca1");
            comarca.setProvincia("Valencia");

            ArrayList<Ciudad> ciudades = new ArrayList<>();
            Ciudad ciudad = new Ciudad();
            ciudad.setNombre("Valencia Centro");
            ciudad.setCp(45482);
            ciudad.setHabitantes(98115);
            ciudad.setExtension(789563);
            ciudades.add(ciudad);

            ciudad = new Ciudad();
            ciudad.setNombre("Carlet");
            ciudad.setCp(45482);
            ciudad.setHabitantes(8946);
            ciudad.setExtension(789563);
            ciudades.add(ciudad);

            ciudad = new Ciudad();
            ciudad.setNombre("Madrid");
            ciudad.setCp(45482);
            ciudad.setHabitantes(8946);
            ciudad.setExtension(47896525);
            ciudades.add(ciudad);

            comarca.setCiudad(ciudades);

            //Doy formato a la salida del XML
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            //Paso de OBJ a XML
            marshaller.marshal(comarca, new FileWriter("comarca1.xml"));
            System.out.println("Datos escritos en el fichero comarca1.xml");

        } catch (JAXBException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
