package com.co.homecenter.pageObject;

import org.openqa.selenium.By;

public class SesionPageObjects {

    private static By campoUsuario= By.xpath("//span[@class='Account-module__welcome-name___1-86E']");

    public static By getCampoUsuario() {
        return campoUsuario;
    }
}
