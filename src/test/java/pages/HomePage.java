package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilidades.ClaseBase;

public class HomePage extends ClaseBase {



    public HomePage(WebDriver driver) {
        super(driver);
    }

    //Identificar localizadores

    By locatormiclaro = (By.xpath("//body/div[@id='__next']/div[1]/main[1]/div[2]/li[1]/a[1]"));

    By locatorEntrarAhora = (By.linkText("Entrar Ahora"));

    By locatorRegistro = (By.xpath("//a[contains(text(),'Registrarme')]"));

    By locatorCrearTuUsuario = (By.linkText("Crear tu usuario"));

    By locatorIngresarATiendaOnline = (By.linkText("Ingresá a tienda online"));

    By locatorCompratuPack = (By.xpath("//h2[contains(text(),'Comprá tu pack o recargá')]"));

    //acciones del page

    public void irAMiclaro(){

        //click con espera
        click(esperarPorPresenciaElemento(locatormiclaro));

    }

    public void irAEntrarAhora(){

        click((esperarPorPresenciaElemento(locatorEntrarAhora)));
    }

    public void irARegistrarme (){
        click(esperarPorPresenciaElemento(locatorRegistro));
    }


    public void irACrearTuUsuario(){
        click(esperarPorElementoACliclear(locatorCrearTuUsuario));

    }

    public void irATiendaOnline (){
        click(esperarPorElementoACliclear(locatorIngresarATiendaOnline));
    }


    public void irAComprarPack (){
        click(esperarPorElementoACliclear(locatorCompratuPack));
    }


}
