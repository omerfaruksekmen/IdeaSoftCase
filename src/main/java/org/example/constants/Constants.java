package org.example.constants;

import org.openqa.selenium.By;

// Site içerisindeki web elementlerin konumlarını tuttuğumuz class
public class Constants {

    // sabitler olarak konumları tutup, istediğimiz yerde keyword ile çağırabiliyoruz.
    // böylece tekrar tekrar locator ile yol tanımı gerekmiyor.
    public static final By SEARCH_BOX = By.xpath("//input[@aria-label='Search']");
    public static final By SEARCH_BUTTON = By.xpath("//form[@data-selector='search-form']/button");
    public static final By PRODUCT_LIST = By.cssSelector(".col-6.col-lg-4.col-xl-3");
    public static final By PRODUCT_TITLE = By.xpath("//div[@class='product-title']/h1");
    public static final By NUMBER_OF_PRODUCTS = By.id("qty-input");
    public static final By ADD_TO_CART_BUTTON = By.xpath("//a[@class='add-to-cart-button']");
    public static final By SHOPPING_INFORMATION_CART = By.xpath("//div[text()='SEPETİNİZE EKLENMİŞTİR']");
    public static final By CART_BUTTON = By.xpath("//a[@title='Sepet']");
    public static final By PRODUCT_PIECE = By.xpath("//input[@data-stocktype='Piece']");
}