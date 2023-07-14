package utilidades;

//Librerias de apache poi
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

//JDK
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataDriven {

    public List<String> obtenerDatosDePrueba(String tituloCP) throws IOException {

        ArrayList<String> datos = new ArrayList<String>();

        PropertiesDriven properties = new PropertiesDriven();

        FileInputStream file;

        //Crear un objeto de tipo file
        file = new FileInputStream(properties.obtenerProperties("rutaExcel"));


        XSSFWorkbook excel;
        //Crear un objeto de tipo excel

        excel = new XSSFWorkbook(file);


        int cantidadHojasExcel = excel.getNumberOfSheets();

        System.out.println("cantidad de hojas: " + cantidadHojasExcel);

        for (int i = 0; i < cantidadHojasExcel; i++) {
            if (excel.getSheetName(i).equalsIgnoreCase(properties.obtenerProperties("nombreHojaExcel"))) {
                //Encontre la hoja
                //obtener la hoja en base al indice
                XSSFSheet hojaExcel = excel.getSheetAt(i);

                Iterator<Row> filas = hojaExcel.iterator();

                //se instancia una fila en base a la primera fila de la hoja en excel con los datos
                Row primeraFila = filas.next();

                Iterator<Cell> celda = primeraFila.cellIterator();

                int k = 0;
                int columna = 0;

                while (celda.hasNext()) {
                    Cell celdaSeleccionada = celda.next();

                    if (celdaSeleccionada.getStringCellValue().equalsIgnoreCase(properties.obtenerProperties("tituloCPs"))) {
                        //identificamos la columna con la que queremos trabajar
                        columna = k;
                    }
                    k++;
                }

                while (filas.hasNext()) {
                    Row r = filas.next();

                    if (r.getCell(columna).getStringCellValue().equalsIgnoreCase(tituloCP)) {
                        //Encontrar el titulo del CP

                        Iterator<Cell> cv = r.cellIterator();

                        while (cv.hasNext()) {
                            // System.out.println(cv.next().getStringCellValue());
                            Cell c = cv.next();

                            if (c.getCellType() == CellType.STRING) {
                                // System.out.println(c.getStringCellValue());
                                datos.add(c.getStringCellValue());
                            } else if (c.getCellType() == CellType.NUMERIC) {
                                //System.out.println(NumberToTextConverter.toText(c.getNumericCellValue()));
                                datos.add(NumberToTextConverter.toText(c.getNumericCellValue()));

                            }

                        }

                    }

                }
            }
        }
        return datos;

    }

}
