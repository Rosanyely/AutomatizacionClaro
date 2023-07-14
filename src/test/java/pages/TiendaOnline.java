package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilidades.ClaseBase;

public class TiendaOnline extends ClaseBase {

    public TiendaOnline (WebDriver driver){
        super(driver);
    }

//localizadores

    By locatorTiendaOnline = By.xpath("//h2[contains(text(),'Productos destacados')]");

    By locatorMotoG = By.xpath(" //p[contains(text(),'Moto E22 32GB')]");


    By locatorIrAVerCatalogoCompleto = By.xpath("//span[contains(text(),'Ver catálogo completo')]");



    public void productos (){
       click(esperarPorElementoACliclear(locatorTiendaOnline));
       click(esperarPorElementoACliclear(locatorMotoG));
    }


    public String volverAtiendaOnline (){
        return obtenerTexto(esperarPorPresenciaElemento(locatorTiendaOnline));
    }


    public void verCatalogoCompleto (){
        click(esperarPorElementoACliclear(locatorIrAVerCatalogoCompleto));
    }





}
