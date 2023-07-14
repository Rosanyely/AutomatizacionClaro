package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilidades.ClaseBase;

public class IngresaAClaro extends ClaseBase {

    public IngresaAClaro(WebDriver driver) {
        super(driver);
    }

    By locatorEntrarAhora = (By.linkText("Entrar Ahora"));

    public void irAEntrarAhora(){

        click((esperarPorPresenciaElemento(locatorEntrarAhora)));
    }

}
