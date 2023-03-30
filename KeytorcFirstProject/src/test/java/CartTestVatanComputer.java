import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

public class CartTestVatanComputer extends BaseTest{
    HomePage homePage;
    ProductsPage productsPage;
    LoginPage loginPage;
    ProductDetailsPage productDetailsPage;
    PaymentPage paymentPage;
    LogOutPage logOutPage;
    BasePage basePage;

    @Order(1)
    @Test
    public void homePageDisplayTest(){
        homePage = new HomePage(driver);
        Assertions.assertTrue(homePage.isHomePageOpened(),
                "Homepage could not opened properly!");
    }

    @Order(2)
    @Test
    public void loginOperationTest(){
        homePage= new HomePage(driver);
        loginPage = new LoginPage(driver);
        homePage.clickForLogin();
        loginPage.loginOperation("tabirbugra@gmail.com","123456");
        Assertions.assertEquals("HESABIM",loginPage.isLoginOperationSuccess(),
                "Login operation is not successful! Please check your email and password");
    }

    @Order(3)
    @Test
    public void searchProductTest(){
        homePage = new HomePage(driver);
        productsPage = new ProductsPage(driver);
        homePage.searchProduct("MSI KATANA LAPTOP");
        Assertions.assertTrue(productsPage.isOnProductsPage(),
                "Product is not on product page!");
    }


    @Order(4)
    @Test
    public void selectProductTest(){
        productsPage = new ProductsPage(driver);
        productDetailsPage = new ProductDetailsPage(driver);
        productsPage.sortProducts();
        productsPage.cheapestProduct();
        productsPage.selectProduct(0);
        productDetailsPage.selectedProductPrice();
        //Burada urunlerin listesinin oldugu sayfa ve sectigimiz urunun fiyatinin gorundugu sayfa farkli oldugu icin ve ikisinin
        //birbiri ile baglantili olmasi gerektigi icin @beforeeach @aftereach anotasyonlarini kullanmamayi tercih ettim
        Assertions.assertEquals(productDetailsPage.selectedProductPrice(),productsPage.cheapestProduct(),
                "Prices are not equal!");
    }

    @Order(5)
    @Test
    public void productDetailsDisplayTest(){
        productDetailsPage = new ProductDetailsPage(driver);
        Assertions.assertTrue(productDetailsPage.isOnProductDetailsPage(),
                "You are not at the product details page!");
    }

    @Order(6)
    @Test
    public void addProductToCartTest(){
        productDetailsPage = new ProductDetailsPage(driver);
        productDetailsPage.addToCart();
        Assertions.assertTrue(productDetailsPage.isCartCountUp(),
                "Product not added the cart at the right top!");
    }


    @Order(7)
    @Test
    public void paymentPageDisplayTest(){
        paymentPage = new PaymentPage(driver);
        productDetailsPage = new ProductDetailsPage(driver);
        productDetailsPage.goToCart();
        Assertions.assertTrue(paymentPage.isOnPaymentPage(),
                "You are not at payment page!");
    }

    @Order(8)
    @Test
    public void comparePricesTest(){
        paymentPage = new PaymentPage(driver);
        paymentPage.closePop();
        Assertions.assertEquals(paymentPage.paymentPagePrice(),paymentPage.realPrice(),
                "Prices are not equal!");
    }

    @Order(9)
    @Test
    public void goBackTest(){
        productDetailsPage = new ProductDetailsPage(driver);
        basePage = new BasePage(driver);
        basePage.goBack();
        Assertions.assertTrue(productDetailsPage.isOnProductDetailsPage(),
                "You could not go to the previous page!");
    }
    @Order(10)
    @Test
    public void logoutOperationTest(){
        logOutPage = new LogOutPage(driver);
        logOutPage.logOut();
        Assertions.assertEquals("GİRİŞ YAP",logOutPage.isLogoutOperationSuccess(),
                "Logout operation is not successful!");
    }
}
