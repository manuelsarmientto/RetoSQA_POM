package com.co.homecenter.steps;

import com.co.homecenter.pageObject.CarroComprasPageObjects;
import com.co.homecenter.pageObject.SesionPageObjects;
import com.co.homecenter.utils.DatosExcel;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Map;

import static com.co.homecenter.driver.SeleniumWebDriver.driver;

public class ValidarInicioSesionSteps {
    @Step
    public void validarUsuario(){
        ArrayList<Map<String, String>> dataExcel = null;
        try {
            dataExcel = DatosExcel.leerDatosDeHojaDeExcel("parametros/Datos.xlsx", "IniciarSesion");
        } catch (IOException e) {
            e.printStackTrace();
        }
        esperarElementoVisible(SesionPageObjects.getCampoUsuario(), Duration.ofSeconds(15));
        WebElement usuarioElement =  driver.findElement(SesionPageObjects.getCampoUsuario());
        String textoUsuario = usuarioElement.getText();
        Assert.assertEquals(dataExcel.get(0).get("Usuario"),textoUsuario);
    }

    public void esperarElementoVisible(By elemento, Duration tiempoEsperaSegundos) {
        WebDriverWait wait = new WebDriverWait(driver, tiempoEsperaSegundos);
        wait.until(ExpectedConditions.visibilityOfElementLocated(elemento));
    }
}
