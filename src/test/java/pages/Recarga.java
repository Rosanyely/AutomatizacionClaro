package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilidades.ClaseBase;

public class Recarga extends ClaseBase {

    public Recarga (WebDriver driver) {
        super(driver);
    }

    By locatorNrodeLinea = (By.xpath("//span[contains(text(),'Código de área + tu número sin el 15')]"));

    By locatorCampoNumero = (By.xpath("//input[@id='number']"));

    By locatorNroDeLineaInvalida = (By.xpath("//span[contains(text(),'La línea no es válida.')]"));

    By locatorContinuar = (By.xpath("//button[@id='pin__submit']"));


    public void nroDeLinea(){
        click(esperarPorElementoACliclear(locatorCampoNumero));
        agregarTexto(esperarPorPresenciaElemento(locatorCampoNumero), "1234");
        click((esperarPorElementoACliclear(locatorContinuar)));
    }

    public String recargaTuLinea ()
    {return obtenerTexto(esperarPorPresenciaElemento(locatorNrodeLinea));}


    public String lineaInvalida (){
        return obtenerTexto(esperarPorPresenciaElemento(locatorNroDeLineaInvalida));
    }


}
