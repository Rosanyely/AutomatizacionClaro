package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilidades.ClaseBase;

public class IniciarSesionEmail extends ClaseBase {

    public IniciarSesionEmail(WebDriver driver) {
        super(driver);
    }

    //Identificar Localizadores
    By locatorAunNoTeRegistraste = By.xpath("//p[contains(text(),'¿Aún no te registraste?')]");

    By locatorEmail = (By.xpath("//input[@id='username']"));

    By locatorContinuar = By.xpath("//button[contains(text(),'Continuar')]");

    By locatorPassword = By.xpath("//input[@id='password']");

    By locatorIngresar = By.xpath("//button[text()='Ingresar']");

    By locatorOlvideEmail = By.xpath("//p[contains(text(),'Olvidé mi e-mail')]");

    By locatorRecordarEmail = By.xpath("//h3[contains(text(),'Para recordarte tu e-mail, ingresá:')]");

    By locatorEmailInvalido = By.xpath("//span[contains(text(),'El usuario o E-mail ingresado no está registrado.')]");
    //Acciones del page

    public void irAIniciarSesionEmail() {

        click(esperarPorElementoACliclear(locatorEmail));

        agregarTexto(esperarPorPresenciaElemento(locatorEmail), "prueba2@yopmail.com");

        click(esperarPorPresenciaElemento(locatorContinuar));

    }

    public void irAOlvideEmail() {
        click(esperarPorElementoACliclear(locatorOlvideEmail));
    }

    public String recordarEmail() {
        return obtenerTexto(esperarPorPresenciaElemento(locatorRecordarEmail));
    }


    public void irAIniciarSesionEmailInvalido(){
        click(esperarPorElementoACliclear(locatorEmail));
        agregarTexto(esperarPorPresenciaElemento(locatorEmail),"emailInvalido");
        click(esperarPorPresenciaElemento(locatorContinuar));

    }

    public String emailInvalido (){
        return obtenerTexto(esperarPorPresenciaElemento(locatorEmailInvalido));
    }

}
