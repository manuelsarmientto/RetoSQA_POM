package com.co.homecenter.steps;

import com.co.homecenter.pageObject.CarroComprasPageObjects;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;

import static com.co.homecenter.driver.SeleniumWebDriver.driver;

public class ValidarCarritoSteps {
    @Step
    public void obtenerInfoProducto(){
        ArrayList infoProducto = CarritoSteps.retornaInfoProducto();
        esperarElementoVisible(CarroComprasPageObjects.getNombreProducto(),Duration.ofSeconds(15));
        WebElement productoElement =  driver.findElement(CarroComprasPageObjects.getNombreProducto());
        String textoProducto = productoElement.getText();
        WebElement precioElement =  driver.findElement(CarroComprasPageObjects.getPrecioProducto());
        String textoPrecio = precioElement.getText();
        Assert.assertTrue(textoProducto.contains((CharSequence) infoProducto.get(0)));
        Assert.assertTrue(textoPrecio.contains((CharSequence) infoProducto.get(1)));
    }

    public void esperarElementoVisible(By elemento, Duration tiempoEsperaSegundos) {
        WebDriverWait wait = new WebDriverWait(driver, tiempoEsperaSegundos);
        wait.until(ExpectedConditions.visibilityOfElementLocated(elemento));
    }

}
