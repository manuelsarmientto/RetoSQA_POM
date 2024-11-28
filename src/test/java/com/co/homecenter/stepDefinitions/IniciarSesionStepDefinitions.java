package com.co.homecenter.stepDefinitions;


import com.co.homecenter.driver.SeleniumWebDriver;
import com.co.homecenter.steps.IniciarSesionSteps;
import com.co.homecenter.steps.ValidarInicioSesionSteps;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;

public class IniciarSesionStepDefinitions {

    IniciarSesionSteps iniciarSesion = new IniciarSesionSteps();
    ValidarInicioSesionSteps validarLogin = new ValidarInicioSesionSteps();

    @Dado("que estoy en la pagina de inicio de HomeCenter")
    public void queEstoyEnLaPaginaDeInicioDeHomeCenter() {
        SeleniumWebDriver.chromeDrive("https://homecenter.com.co/");
    }
    @Cuando("hago clic en el boton de mi cuenta")
    public void hagoClicEnElBotonDeMiCuenta() {
        iniciarSesion.clicBotonMicuenta();
    }
    @Cuando("ingreso  mis credenciales validas")
    public void ingresoMisCredencialesValidas() {
        iniciarSesion.IngresarCredenciales();
    }
    @Entonces("deberia ver que he accedido correctamente a mi cuenta")
    public void deberiaVerQueHeAccedidoCorrectamenteAMiCuenta() {
        validarLogin.validarUsuario();
        SeleniumWebDriver.driver.close();
    }

}
