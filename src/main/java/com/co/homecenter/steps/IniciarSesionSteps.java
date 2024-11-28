package com.co.homecenter.steps;

import com.co.homecenter.pageObject.InicioPageObjects;
import com.co.homecenter.utils.DatosExcel;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Map;

import static com.co.homecenter.driver.SeleniumWebDriver.driver;

public class IniciarSesionSteps {

    @Step
    public void clicBotonMicuenta(){
        darClick(InicioPageObjects.getBotonCuenta());
        esperarElementoVisible(InicioPageObjects.getCampoCorreo(),Duration.ofSeconds(15));
    }

    @Step
    public void IngresarCredenciales(){
        ArrayList<Map<String, String>> dataExcel;
        try {
            dataExcel = DatosExcel.leerDatosDeHojaDeExcel("parametros/Datos.xlsx", "IniciarSesion");
            digitarTexto(InicioPageObjects.getCampoCorreo(),dataExcel.get(0).get("Correo"));
            digitarTexto(InicioPageObjects.getCampoContrasena(),dataExcel.get(0).get("Contrasena"));
            darClick(InicioPageObjects.getBotonIniciarSesion());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //acciones
    public void darClick(By elemento) {
        driver.findElement(elemento).click();
    }

    public void digitarTexto(By elemento, String texto) {
        driver.findElement(elemento).sendKeys(texto);
    }

    public void esperarElementoVisible(By elemento, Duration tiempoEsperaSegundos) {
        WebDriverWait wait = new WebDriverWait(driver, tiempoEsperaSegundos);
        wait.until(ExpectedConditions.visibilityOfElementLocated(elemento));
    }

}
