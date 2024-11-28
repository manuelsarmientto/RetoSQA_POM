package com.co.homecenter.pageObject;

import org.openqa.selenium.By;

public class ResultadoBusquedaPageObjects {
    private static By itemMarca = By.xpath("//div[@id='tooltip-accordion-Marca-toggle-button']");
    public static By getBtnMarca(String textoMarca){
        return By.xpath("//a[contains(text(),'"+textoMarca+"')]");
    }
    public static By getProducto(String textoProducto){
        return By.xpath("//h2[contains(text(),'"+textoProducto+"')]");
    }
    public static By getItemMarca() {
        return itemMarca;
    }
}
