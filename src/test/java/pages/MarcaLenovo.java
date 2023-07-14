package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilidades.ClaseBase;

public class MarcaLenovo extends ClaseBase {

    public MarcaLenovo(WebDriver driver) {
        super(driver);
    }

    By locatorLenovo = By.xpath("//p[contains(text(),'Marca: Lenovo')]");


    public String filtroLenovo (){
        return obtenerTexto(esperarPorPresenciaElemento(locatorLenovo));
    }

}
