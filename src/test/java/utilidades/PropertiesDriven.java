package utilidades;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesDriven {

    private Properties prop;
    public String obtenerProperties(String key){

        //instanciar un objeto de tipo properties

        prop  = new Properties();

        try {
            InputStream input = new FileInputStream("C:\\Users\\rosanyely.viloria\\Downloads\\Practica\\PageObjetModel\\src\\test\\resources\\Setup.properties");
            prop.load(input);

        }catch(Exception e){
            System.out.println("No fue posible llamar al archivo properties");
            e.printStackTrace();
        }

        return prop.getProperty(key);
    }
}
