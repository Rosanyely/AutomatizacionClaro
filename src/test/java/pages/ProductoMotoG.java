package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilidades.ClaseBase;

public class ProductoMotoG extends ClaseBase {

    public ProductoMotoG(WebDriver driver) {
        super(driver);
    }

    //localizadores

    By locatorElegirComoComprar = By.xpath("//div[contains(text(),'Elegí cómo comprarlo')]");

    By locatorMediosDePago = By.xpath("//p[contains(text(),'Medios de pago')]");

    By locatorVisa = By.xpath("//body[1]/div[1]/main[1]/div[2]/div[1]/div[1]/div[3]/div[4]/div[1]/div[1]/div[1]/div[1]/div[5]/div[1]");

    By locatorEnvioADomicilio = By.xpath("//p[contains(text(),'Envío a domicilio')]");

    By locatorFormasDeEntrega = By.xpath("//h1[contains(text(),'Formas de entrega')]");

    By locatorRetiroEnSucursal = By.xpath("//p[contains(text(),'Retiro en sucursal')]");

    By locatorUbicaTuCentroClaro = By.xpath("//p[contains(text(),'Actualmente no hay stock de este producto para ret')]");

    By locatorVolver = By.xpath("//body/div[@id='__next']/main[@id='content']/ol[1]/div[2]/a[1]/*[1]");

    By locatorInformacionDelProducto = By.xpath(("//h2[contains(text(),'También te recomendamos estos productos')]"));

    By locatorTarjetaVisa = By.xpath("//div[contains(text(),'Tarjeta de crédito Visa')]");

    By locatorEspecificaciones = By.xpath("//header/div[1]/div[3]/div[2]/div[1]/button[2]");

    By locatorCamara = By.xpath("//div[contains(text(),'Cámara trasera')]");



    public String seleccionDeProducto() {
        return obtenerTexto(esperarPorPresenciaElemento(locatorElegirComoComprar));
    }

    public void seleccionarMediosDePago() {
        click(esperarPorElementoACliclear(locatorMediosDePago));
    }

    public void seleccionVisa() {
        click(esperarPorElementoACliclear(locatorVisa));}

    public String tarjetaVisa() {
        return obtenerTexto(esperarPorPresenciaElemento(locatorTarjetaVisa));
    }

    public void seleccionarEnvioADomicilio() {
        click(esperarPorElementoACliclear(locatorEnvioADomicilio));
    }

    public String formasDeEntrega() {
        return obtenerTexto(esperarPorPresenciaElemento(locatorFormasDeEntrega));
    }

    public void seleccionarRetiroEnSucursal() {
        click(esperarPorElementoACliclear(locatorRetiroEnSucursal));

    }

    public String ubicaTuCentroClaro() {
        return obtenerTexto(esperarPorPresenciaElemento(locatorUbicaTuCentroClaro));
    }

    public void seleccionarVolver (){
        click(esperarPorElementoACliclear(locatorVolver));
    }

    public String informacionDelProducto () {return obtenerTexto(esperarPorPresenciaElemento(locatorInformacionDelProducto));
    }


    public void seleccionarEspecificaciones(){
        click(esperarPorElementoACliclear(locatorEspecificaciones));
    }

    public String camara(){
        return obtenerTexto(esperarPorPresenciaElemento(locatorCamara));
    }


}