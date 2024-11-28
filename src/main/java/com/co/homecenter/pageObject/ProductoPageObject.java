package com.co.homecenter.pageObject;

import org.openqa.selenium.By;

public class ProductoPageObject {
    private static By botonAumentarCantidad = By.xpath("//div[@class='jsx-3508317538 product-info']//button[@class='jsx-3051388068 jsx-139374854 qty-button up']");
    private static By botonAgregarAlCarro = By.xpath("//div[@class='jsx-3508317538 product-info']//button[@class='jsx-1539199139 button button-primary    jsx-441486922']");
    private static By textoProducto = By.xpath("//h1[@class='jsx-3508317538 product-title']");
    private static By textoPrecio = By.xpath("//span[@class='jsx-2816876583']");
    private static By botonIrAlCarroDeCompras = By.xpath("//button[@id='testId-btn-goto-cart-button']");

    public static By getBotonAgregarAlCarro() {
        return botonAgregarAlCarro;
    }

    public static By getBotonAumentarCantidad() {
        return botonAumentarCantidad;
    }

    public static By getTextoProducto() {
        return textoProducto;
    }

    public static By getTextoPrecio() {
        return textoPrecio;
    }

    public static By getBotonIrAlCarroDeCompras() {
        return botonIrAlCarroDeCompras;
    }
}
