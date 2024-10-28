import model.Ciudad;
import model.Comarca;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import java.io.File;
import java.util.ArrayList;

public class LecturaJaxb {

    public static void main(String[] args) throws JAXBException {

        //Construyo el contexto
        JAXBContext context = JAXBContext.newInstance(Comarca.class);
        //Convierto el XML a un Objeto pasandole el contexto en ese caso la clase comarca
        Unmarshaller unmarshaller = context.createUnmarshaller();
        Comarca comarca = (Comarca) unmarshaller.unmarshal(new File("comarca1.xml"));

        System.out.println("Nombre: " + comarca.getNombre());
        System.out.println("Provincia: " + comarca.getProvincia());
        ArrayList<Ciudad> ciudad = (ArrayList<Ciudad>) comarca.getCiudad();

        for(Ciudad c: ciudad){
            System.out.println(c.getNombre() +" "+  c.getCp() +" "+  c.getHabitantes() +" "+  c.getExtension());
        }
    }
}
