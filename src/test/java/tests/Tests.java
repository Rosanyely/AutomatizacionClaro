package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.*;
import utilidades.DataDriven;
import utilidades.PropertiesDriven;

import java.io.IOException;
import java.util.List;

public class Tests {


    //atributos

    private WebDriver driver;
    private DataDriven data;
    private List<String> datosCP;

    private PropertiesDriven properties;



    //atributos (pages)
    private HomePage homePage;
    private IniciarSesionEmail iniciarSesionEmail;
    private IniciarSesionPassword iniciarSesionPassword;
    private Registrarse registrarse;
    private RecuperarPassword recuperarPassword;

    private TiendaOnline tiendaOnline;

    private ProductoMotoG productoMotoG;

    private CatalogoDeProductos catalogoDeProductos;

    private MarcaLenovo marcaLenovo;

    private Recarga recarga;

    @BeforeSuite
    public void inicioSuiteDePruebas(){

        properties = new PropertiesDriven();
        System.out.println("Inicio de suite de pruebas automatizadas");

    }

    @BeforeClass
    public void preparacionClase(){

        data = new DataDriven();

        homePage = new HomePage(driver);
        homePage.conexionDriver(properties.obtenerProperties("rutaDriver"),properties.obtenerProperties("browserProperty"),properties.obtenerProperties("browser"));
        iniciarSesionEmail = new IniciarSesionEmail(homePage.getDriver());
        iniciarSesionPassword = new IniciarSesionPassword(homePage.getDriver());
        registrarse = new Registrarse(homePage.getDriver());
        recuperarPassword = new RecuperarPassword(homePage.getDriver());
        tiendaOnline = new TiendaOnline(homePage.getDriver());
        productoMotoG = new ProductoMotoG(homePage.getDriver());
        catalogoDeProductos = new CatalogoDeProductos(homePage.getDriver());
        marcaLenovo = new MarcaLenovo(homePage.getDriver());
        recarga = new Recarga(homePage.getDriver());

    }


    @BeforeMethod
    public void preparacionTest(){

       String url = properties.obtenerProperties("url");
       homePage.cargarPagina(url);
       homePage.maximizarVentana();
    }

    @AfterTest
    public void after (){
        homePage.cerrarBrowser();

    }

    @Test
    public void CP001_Recarga () throws IOException {
        datosCP = data.obtenerDatosDePrueba("CP001_Recarga");
        homePage.irAComprarPack();
        recarga.recargaTuLinea();
        Assert.assertEquals(datosCP.get(1),recarga.recargaTuLinea());
    }
   @Test
   public void CP002_RecargaConLineaInvalida() throws IOException {
        datosCP = data.obtenerDatosDePrueba("CP002_RecargaConLineaInvalida");
        homePage.irAComprarPack();
        recarga.nroDeLinea();
        recarga.lineaInvalida();
        Assert.assertEquals(datosCP.get(1),recarga.lineaInvalida());

    }


    @Test
    public void CP003_RecuperarPassword () throws IOException {
        datosCP = data.obtenerDatosDePrueba("CP003_RecuperarPassword");
        homePage.irAMiclaro();
        homePage.irAEntrarAhora();
        iniciarSesionEmail.irAIniciarSesionEmail();
        recuperarPassword.irARecuperarPassword();
        Assert.assertEquals(datosCP.get(2),recuperarPassword.obtenerMensajeRecuperarPassword());
    }

    @Test
    public void CP004_RecuperarEmail() throws IOException {
        datosCP = data.obtenerDatosDePrueba("CP004_RecuperarEmail");
        homePage.irAMiclaro();
        homePage.irAEntrarAhora();
        iniciarSesionEmail.irAOlvideEmail();
        Assert.assertEquals(datosCP.get(1),iniciarSesionEmail.recordarEmail());
    }

    @Test
    public void CP005_IniciarSesionCorreoNoRegistrado() throws IOException {
        datosCP = data.obtenerDatosDePrueba("CP005_IniciarSesionCorreoNoRegistrado");
        homePage.irAMiclaro();
        homePage.irAEntrarAhora();
        iniciarSesionEmail.irAIniciarSesionEmailInvalido();
        Assert.assertEquals(datosCP.get(2),iniciarSesionEmail.emailInvalido());

    }


    @Test
    public void CP006_TiendaOnlineSeleccionDeProducto()
            throws IOException
    {
        datosCP = data.obtenerDatosDePrueba("CP006_TiendaOnlineSeleccionDeProducto");
        homePage.irATiendaOnline();
        tiendaOnline.productos();
        productoMotoG.informacionDelProducto();
        Assert.assertEquals(datosCP.get(1),productoMotoG.informacionDelProducto());
    }

    @Test
    public void CP007_TiendaOnlineSeleccionMediosDePago()
            throws IOException
    {
        datosCP = data.obtenerDatosDePrueba("CP007_TiendaOnlineSeleccionMediosDePago");
        homePage.irATiendaOnline();
        tiendaOnline.productos();
        productoMotoG.seleccionarMediosDePago();
        productoMotoG.seleccionVisa();
        productoMotoG.tarjetaVisa();
        Assert.assertEquals(datosCP.get(1),productoMotoG.tarjetaVisa());
    }

    @Test
    public void CP008_TiendaOnlineSeleccionEspecificaciones()
            throws IOException
    {
        datosCP = data.obtenerDatosDePrueba("CP008_TiendaOnlineSeleccionEspecificaciones");
        homePage.irATiendaOnline();
        tiendaOnline.productos();
        productoMotoG.seleccionarEspecificaciones();
        productoMotoG.camara();
        Assert.assertEquals(datosCP.get(1),productoMotoG.camara());
    }

    @Test
    public void CP009_TiendaOnlineFiltroPrecio ()
            throws IOException
    {
        datosCP = data.obtenerDatosDePrueba("CP009_TiendaOnlineFiltroPrecio");
        homePage.irATiendaOnline();
        tiendaOnline.verCatalogoCompleto();
        catalogoDeProductos.mayorA90Mil();
        catalogoDeProductos.filtroPrecio();
        Assert.assertEquals(datosCP.get(1),catalogoDeProductos.filtroPrecio());
    }

    @Test
    public void CP010_BotonVolverATiendaOnline()
            throws IOException
    {
        datosCP = data.obtenerDatosDePrueba("CP010_BotonVolverATiendaOnline");
        homePage.irATiendaOnline();
        tiendaOnline.productos();
        productoMotoG.seleccionarVolver();
        tiendaOnline.volverAtiendaOnline();
        Assert.assertEquals(datosCP.get(1),tiendaOnline.volverAtiendaOnline());
    }

    @Test
    public void CP011_TiendaOnlineCatalogoCompleto()
            throws IOException
    {
        datosCP = data.obtenerDatosDePrueba("CP011_TiendaOnlineCatalogoCompleto");
        homePage.irATiendaOnline();
        tiendaOnline.verCatalogoCompleto();
        catalogoDeProductos.productos();
        Assert.assertEquals(datosCP.get(1),catalogoDeProductos.productos());
    }

    @Test
    public void CP012_TiendaOnlineFiltroPorMarca ()
            throws IOException
    {
        datosCP = data.obtenerDatosDePrueba("CP012_TiendaOnlineFiltroPorMarca");
        homePage.irATiendaOnline();
        tiendaOnline.verCatalogoCompleto();
        catalogoDeProductos.filtrarPorMarca();
        marcaLenovo.filtroLenovo();
        Assert.assertEquals(datosCP.get(1),marcaLenovo.filtroLenovo());

    }

}
