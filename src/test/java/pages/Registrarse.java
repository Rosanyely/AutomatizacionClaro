package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilidades.ClaseBase;

public class Registrarse extends ClaseBase {

    public Registrarse (WebDriver driver){
        super(driver);
    }

    //localizadores

    By locatorEmail = By.xpath("//input[@id='email']");
    By locatorPassword = By.xpath("//input[@id='password']");
    By locatorConfirmarPassword = By.xpath("//input[@id='password-confirm']");
    By locatorRegistrarte = By.xpath("//button[contains(text(),'Registrate')]");

    By locatorConfirmarRegistro = By.xpath("//h1[contains(text(),'¡Hola! ¿nos confirmás que tu E-mail es pruebaregistro2@yopmail.com?')]");

    public void registrarse (){
        click(esperarPorElementoACliclear(locatorEmail));
        agregarTexto(esperarPorPresenciaElemento(locatorEmail),"pruebaregistro2@yopmail.com");
        click(esperarPorElementoACliclear(locatorPassword));
        agregarTexto(esperarPorPresenciaElemento(locatorPassword),"Ab1232342343");
        agregarTexto(esperarPorPresenciaElemento(locatorConfirmarPassword),"Ab1232342343");
        click(esperarPorElementoACliclear(locatorRegistrarte));
    }

    public String ConfirmacionRegistro(){
        return obtenerTexto(esperarPorPresenciaElemento(locatorConfirmarRegistro));
    }

}
