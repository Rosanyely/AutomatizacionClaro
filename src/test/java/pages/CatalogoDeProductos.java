package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilidades.ClaseBase;

public class CatalogoDeProductos extends ClaseBase {

    public CatalogoDeProductos(WebDriver driver) {
        super(driver);
    }

    By locatorCatalogo = By.xpath("//h1[contains(text(),'Catálogo de productos')]");

    By locatorMarcaLenovo = By.xpath("//body/div[@id='__next']/main[@id='content']/div[3]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]/div[8]/p[1]");

    By locatorFiltroPrecio = By.xpath("//p[contains(text(),'Precio: Más de $90.000')]");

    By locatorMayorA90M = By.xpath("/html[1]/body[1]/div[1]/main[1]/div[3]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[6]/p[1]");

    public String productos (){
        return obtenerTexto(esperarPorPresenciaElemento(locatorCatalogo));
    }


    public void filtrarPorMarca (){
        click(esperarPorElementoACliclear(locatorMarcaLenovo));
    }


    public void mayorA90Mil (){click(esperarPorElementoACliclear(locatorMayorA90M));}


    public String filtroPrecio (){return obtenerTexto(esperarPorPresenciaElemento(locatorFiltroPrecio));
    }

}
