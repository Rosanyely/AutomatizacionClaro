package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilidades.ClaseBase;

public class RecuperarPassword extends ClaseBase {

    public RecuperarPassword(WebDriver driver) {
        super(driver);
    }

    //identificar Localizadores

    //localizador olvide mi contraseña

    By locatorRecuperarPassword = By.xpath("//a[contains(text(),'Olvidé mi contraseña')]");

    By locatorBotonRecuperarPassword = By.xpath("//button[@id='submit-reset']");

    By locatorObtenerMensajeRecuperarPassword =By.xpath(
            "//span[contains(text(),'Existe un pedido de recupero de contraseña en curs')]");
           //"//span[contains(text(),'Te enviamos un E-mail con un link para que generes')]");

    //Acciones del page
    public void irARecuperarPassword(){
        click(esperarPorElementoACliclear(locatorRecuperarPassword));
        click(esperarPorElementoACliclear(locatorBotonRecuperarPassword));
    }
    public String obtenerMensajeRecuperarPassword() {
        return obtenerTexto(esperarPorPresenciaElemento(locatorObtenerMensajeRecuperarPassword));
    }

}
