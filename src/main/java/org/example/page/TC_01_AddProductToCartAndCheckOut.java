package org.example.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;

import static org.example.base.BaseTest.getWebDriver;
import static org.example.constants.Constants.*;

// senaryo adımlarının gerçekleştirildiği class
public class TC_01_AddProductToCartAndCheckOut extends BasePage {

    private static final Logger log = LogManager.getLogger(TC_01_AddProductToCartAndCheckOut.class);

    public TC_01_AddProductToCartAndCheckOut(WebDriver driver){
        super(driver);
    }

    public TC_01_AddProductToCartAndCheckOut clickSearchBox(){
        click(SEARCH_BOX);
        return this;
    }

    public TC_01_AddProductToCartAndCheckOut sendKeysSearchBox(String searchText){
        sendKeys(SEARCH_BOX, searchText);
        return this;
    }

    public TC_01_AddProductToCartAndCheckOut clickSearchButton(){
        click(SEARCH_BUTTON);
        return this;
    }

    public TC_01_AddProductToCartAndCheckOut selectProductAndGoToDetailPage(){
        // Ürünlerin listesinin alınması
        List<WebElement> products = getWebDriver().findElements(PRODUCT_LIST);

        // Eğer ürün listesi boşsa hata fırlat
        if (products.isEmpty()) {
            throw new NoSuchElementException("Ürün listesi boş. .col-6.col-lg-4.col-xl-3 ile eşleşen öğe bulunamadı.");
        }

        // Rastgele bir ürün seçmek için Random sınıfının kullanılması
        Random random = new Random();
        int randomIndex = random.nextInt(products.size()); // Ürünler arasından rastgele bir indeks seçilmesi
        WebElement selectedProduct = products.get(randomIndex);

        selectedProduct.click();
        return this;
    }

    public TC_01_AddProductToCartAndCheckOut clickNumberOfProduct(){
        click(NUMBER_OF_PRODUCTS);
        return this;
    }

    public TC_01_AddProductToCartAndCheckOut sendKeysNumberOfProduct(String searchText){
        sendKeys(NUMBER_OF_PRODUCTS, searchText);
        return this;
    }

    public TC_01_AddProductToCartAndCheckOut clickAddToCartButton(){
        click(ADD_TO_CART_BUTTON);
        return this;
    }

    public TC_01_AddProductToCartAndCheckOut informationMessageAssertion(){
        assertTextEquals(SHOPPING_INFORMATION_CART, "SEPETİNİZE EKLENMİŞTİR");
        return this;
    }

    public TC_01_AddProductToCartAndCheckOut clickCartButton(){
        waitUntilElementInvisibleAndClick(SHOPPING_INFORMATION_CART, CART_BUTTON);
        return this;
    }

    public TC_01_AddProductToCartAndCheckOut assertProductPiece(){
        assertWithAttribute(PRODUCT_PIECE, "value", "5");
        return this;
    }

}
