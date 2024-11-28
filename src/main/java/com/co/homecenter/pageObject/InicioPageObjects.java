package com.co.homecenter.pageObject;

import org.openqa.selenium.By;

public class InicioPageObjects {
    private static By campoBusqueda = By.xpath("//input[@class='DesktopSearchBar-module__searchbox-input___1C9jN']");
    private static By botonCuenta = By .xpath( "//div[@class='s-d-lg-inline Account-module__account-name___Hd_HK']");
    private static By campoCorreo = By.xpath("//input[@id='testId-input-email']");
    private static By campoContrasena = By.xpath ("//input[@id='testId-input-password']");
    private static By botonIniciarSesion = By.xpath ("//button[@id='testId-btn-login-button']");

    public static By getCampoBusqueda() {
        return campoBusqueda;
    }

    public static By getBotonCuenta() {
        return botonCuenta;
    }

    public static By getCampoCorreo() {
        return campoCorreo;
    }

    public static By getCampoContrasena() {
        return campoContrasena;
    }

    public static By getBotonIniciarSesion() {
        return botonIniciarSesion;
    }
}
