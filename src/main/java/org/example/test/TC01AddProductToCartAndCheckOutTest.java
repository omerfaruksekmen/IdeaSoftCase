package org.example.test;

import org.example.base.BaseTest;
import org.example.page.TC_01_AddProductToCartAndCheckOut;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

//Testleri koştuğumuz class
public class TC01AddProductToCartAndCheckOutTest extends BaseTest {

    TC_01_AddProductToCartAndCheckOut tc_01_AddProductToCartAndCheckOut;

    @Before
    public void before(){
        tc_01_AddProductToCartAndCheckOut = new TC_01_AddProductToCartAndCheckOut(getWebDriver());
    }

    @Test
    public void test(){
        tc_01_AddProductToCartAndCheckOut.clickSearchBox().sendKeysSearchBox("ürün").clickSearchButton()
                .selectProductAndGoToDetailPage().clickNumberOfProduct().sendKeysNumberOfProduct("5")
                .clickAddToCartButton().informationMessageAssertion().clickCartButton().assertProductPiece();
    }

    @After
    public void after(){

    }
}
