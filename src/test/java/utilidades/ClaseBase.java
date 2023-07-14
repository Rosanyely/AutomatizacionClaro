package utilidades;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.util.List;

public class ClaseBase {

    //Atributos
    private WebDriver driver;
    private WebDriverWait wait;


    //Contructor
    public ClaseBase(WebDriver driver) {
        this.driver = driver;
    }
     //Metodos
    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    //Creamos nuestro metodo para buscar un elemento web por su localizador

    public WebElement buscarElementoWeb(By localizador){
        return driver.findElement(localizador);

    }
    public List<WebElement> buscarElementosWeb(By localizador){
        return driver.findElements(localizador);
    }
    //click

    public void click (By localizador) {

        this.driver.findElement(localizador).click();
    }

    public void  click (WebElement elemento){
        elemento.click();
    }

    public void agregarTexto (WebElement elemento, String texto){
        elemento.sendKeys(texto);
    }

    public void agregarTexto (By localizador, String texto){
        this.driver.findElement(localizador).sendKeys(texto);
    }


    public void agregarConbinacionTeclas(By localizador, Keys key){
        this.driver.findElement(localizador).sendKeys(key);
    }

    public String obtenerTexto(By localizador){
        return  this.driver.findElement(localizador).getText();

    }

    public String obtenerTexto(WebElement elemento){
        return  elemento.getText();
    }

    public void cargarPagina(String url){

        this.driver.get(url);
    }

    //Espera fija
    //la funcion sleep crea un stop del proceso pero java entiende que la espera es un error, al agregar este codigo adicional estamos atrapando el error , el try catch me permite capturar una excepcion y controlarlo, esto permite continuar usando la aplicacion y que no se caiga el codigo

    public void esperarxsegundos (int miliSegundos) {
        try {
            Thread.sleep(miliSegundos);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //Espera explicita
    //esperar por la presencia de un elemento o que el elemento sea clicleable
    public WebElement esperarPorPresenciaElemento(By localizador) {
        wait = new WebDriverWait(this.driver, 30);

        return wait.until(ExpectedConditions.presenceOfElementLocated(localizador));
    }
    public WebElement esperarPorElementoACliclear(By localizador) {
        wait = new WebDriverWait(this.driver, 40);

        return wait.until(ExpectedConditions.elementToBeClickable(localizador));
    }

    //Metodo para conectar con el driver
    public WebDriver conexionDriver (String ruta, String property, String browser){

        switch (browser) {
            case "chrome":
                System.setProperty(property,ruta);
                this.driver = new ChromeDriver();
                return driver;
            case "firefox":
                System.setProperty(property,ruta);
                this.driver = new FirefoxDriver();
                return driver;

            case "iexplorer":
                System.setProperty(property,ruta);
                this.driver = new InternetExplorerDriver();
                return driver;
            default:
                return driver;
        }

    }
    public void maximizarVentana(){
        this.driver.manage().window().maximize();
    }

    public void cerrarBrowser(){
        this.driver.close();
    }

    public int contarIframes(By localizador){
        List<WebElement> frames = this.driver.findElements(localizador);
        return frames.size();
    }

    //movernos por un frame por el id o por su nombre
    public void irAframeByIndex(int index) {
        this.driver.switchTo().frame(index);
    }

    public void irAframeByIDorName(String NameOrID){
        this.driver.switchTo().frame(NameOrID);
    }


}
