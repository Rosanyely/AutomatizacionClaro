package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilidades.ClaseBase;

public class IniciarSesionPassword extends ClaseBase {

    public IniciarSesionPassword(WebDriver driver) {
        super(driver);
    }

    //Identificar Localizadores
    By locatorPassword= By.xpath("//input[@id='password']");

    By locatorIngresar = By.xpath("//button[text()='Ingresar']");


    //localizador mensaje Inicio Sesion
    By locatorInicioDeSesion = By.xpath("//p[contains(text(),'Sólo falta que vincules a tu usuario la línea que ')]");

    //localizador contraseña incorrecta
    By locatorPasswordInvalido = By.xpath("//p[@id='input-error-password']");


    //Acciones del page

    public void irAIniciarSesionPassword(){
    click(esperarPorElementoACliclear(locatorPassword));
    agregarTexto(esperarPorPresenciaElemento(locatorPassword),"Sofia4321");
    click(esperarPorPresenciaElemento(locatorIngresar));

    }

    public String obtenerMensajeDeIngreso () {
        return obtenerTexto(esperarPorPresenciaElemento(locatorInicioDeSesion));
    }


    public void irAPasswordInvalido(){
        click(esperarPorElementoACliclear(locatorPassword));

        agregarTexto(esperarPorPresenciaElemento(locatorPassword),"123");
        click(esperarPorPresenciaElemento(locatorIngresar));


    }
    public String obtenerMensajePasswordInvalido(){
        return  obtenerTexto(esperarPorPresenciaElemento(locatorPasswordInvalido));


   }
}
