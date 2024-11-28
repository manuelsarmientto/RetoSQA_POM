package com.co.homecenter.pageObject;

import org.openqa.selenium.By;

public class CarroComprasPageObjects {
    private static By nombreProducto = By.xpath("//h2[@class='jsx-3878867855 description']");
    private static By precioProducto = By.xpath("//div[@class='jsx-1728857345 price-amount-unit-container']/span[@class='jsx-1728857345']");
    private static By botonContinuar = By.xpath("//section[@class='jsx-2312483786']//div[@class='ins-dummy-button-3231']");

    public static By getNombreProducto() {
        return nombreProducto;
    }

    public static By getPrecioProducto() {
        return precioProducto;
    }

    public static By getBotonContinuar() {
        return botonContinuar;
    }
}
