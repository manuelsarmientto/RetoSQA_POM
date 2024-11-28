package com.co.homecenter.steps;

import com.co.homecenter.pageObject.InicioPageObjects;
import com.co.homecenter.pageObject.ProductoPageObject;
import com.co.homecenter.pageObject.ResultadoBusquedaPageObjects;
import com.co.homecenter.utils.DatosExcel;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Map;

import static com.co.homecenter.driver.SeleniumWebDriver.driver;

public class CarritoSteps {
    static ArrayList<String> infoProducto = new ArrayList<>();
    @Step
    public void BusquedaProducto(){
        ArrayList<Map<String, String>> dataExcel;
        try {
            dataExcel = DatosExcel.leerDatosDeHojaDeExcel("parametros/Datos.xlsx", "Producto");
            darClick(InicioPageObjects.getCampoBusqueda());
            digitarTexto(InicioPageObjects.getCampoBusqueda(), dataExcel.get(0).get("Producto"));
            oprimoEnter();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Step
    public void SeleccionarProducto(){
        ArrayList<Map<String, String>> dataExcel;
        try {
            dataExcel = DatosExcel.leerDatosDeHojaDeExcel("parametros/Datos.xlsx", "Producto");
            moverMouse(ResultadoBusquedaPageObjects.getItemMarca());
            moverMouse(ResultadoBusquedaPageObjects.getBtnMarca(dataExcel.get(0).get("Marca")));
            darClick(ResultadoBusquedaPageObjects.getBtnMarca(dataExcel.get(0).get("Marca")));
            esperarElementoVisible(ResultadoBusquedaPageObjects.getProducto(dataExcel.get(0).get("Producto")),Duration.ofSeconds(15));
            darClick(ResultadoBusquedaPageObjects.getProducto(dataExcel.get(0).get("Producto")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Step
    public void AgregarProductoAlCarrito(){
        ArrayList<Map<String, String>> dataExcel;
        try {
            dataExcel = DatosExcel.leerDatosDeHojaDeExcel("parametros/Datos.xlsx", "Producto");
            int cantidad = Integer.parseInt(dataExcel.get(0).get("Cantidad"));
            for(int i= 1;i<cantidad;i++){
                darClick(ProductoPageObject.getBotonAumentarCantidad());
            }
            WebElement productoElement =  driver.findElement(ProductoPageObject.getTextoProducto());
            String textoProducto = productoElement.getText();
            WebElement precioElement =  driver.findElement(ProductoPageObject.getTextoPrecio());
            String textoPrecio = precioElement.getText();
            infoProducto.add(textoProducto);
            infoProducto.add(textoPrecio);
            darClick(ProductoPageObject.getBotonAgregarAlCarro());
            esperarElementoVisible(ProductoPageObject.getBotonIrAlCarroDeCompras(),Duration.ofSeconds(15));
            darClick(ProductoPageObject.getBotonIrAlCarroDeCompras());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList retornaInfoProducto(){
        return infoProducto;
    }

    //acciones
    public void darClick(By elemento) {
        driver.findElement(elemento).click();
    }

    public void digitarTexto(By elemento, String texto) {
        driver.findElement(elemento).sendKeys(texto);
    }

    public void oprimoEnter() {
        new Actions(driver)
                .keyDown(Keys.ENTER)
                .keyUp(Keys.ENTER)
                .perform();
    }

    public void moverMouse(By elemento){
        WebElement objeto = driver.findElement(elemento);
        new Actions(driver)
                .moveToElement(objeto)
                .perform();
    }
    public void esperarElementoVisible(By elemento, Duration tiempoEsperaSegundos) {
        WebDriverWait wait = new WebDriverWait(driver, tiempoEsperaSegundos);
        wait.until(ExpectedConditions.visibilityOfElementLocated(elemento));
    }
}
