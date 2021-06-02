import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import pages.HomePage;



@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestCases extends BaseTest{
    private static final Logger logger = LogManager.getLogger(TestCases.class);
    @Test

    //Anasayfaya giriş.
    public void test_1_1_HomePage(){
        HomePage homePage=new HomePage(driver);
        driver.get(homePage.site());
        driver.manage().window().maximize();
        try {
            Assert.assertEquals("GittiGidiyor - Türkiye'nin Öncü Alışveriş Sitesi",driver.getTitle());
        } catch (Exception e){
            logger.error("Hatalı başlık.");
        }

        logger.info("Anasayfaya giriş yapıldı.");

    }

    //Login sayfasına giriş.
    private By login=By.cssSelector("div[class='gekhq4-3 icMLoL']:nth-child(1)");
    private By log=By.cssSelector("a[data-cy='header-login-button']");
    @Test
    public void test_1_2_LoginPage() throws InterruptedException {
        element(login).click();
        Thread.sleep(3000);
        element(log).click();
        logger.info("Login sayfasına girildi.");
    }

    //Username ve password giriş.
    private By username=By.id("L-UserNameField");
    private By password=By.id("L-PasswordField");
    private By giris=By.id("gg-login-enter");
    @Test
    public void test_1_3_Logged_in() throws InterruptedException {
        element(username).sendKeys("gizemkalay");
        element(password).sendKeys("gizem1602");
        Thread.sleep(3000);
        element(giris).click();
        logger.info("Üye girişi yapıldı.");
    }

    //Arama yapma
    private By search=By.name("k");
    private By searchbtn=By.cssSelector("button[data-cy='search-find-button']");

    @Test
    public void test_1_4_search() throws InterruptedException {
        element(search).sendKeys("bilgisayar");
        element(searchbtn).click();
        Thread.sleep(3000);
        logger.info("Arama yapıldı.");
    }

    //2. arama sayfasına giriş.
    private By second=By.className("next-link");
    private By policy=By.cssSelector("a[class='policy-alert-close btn-alert-close']");
    private By banner=By.cssSelector("div[class='wis-clsbtn-70774']");
    @Test
    public void test_1_5_secondPage() throws InterruptedException {
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("scroll(0, 250)"); // Sayfa sonuna gelen fonksiyon.
        //element(banner).click(); Çalışmam sırasında 28-29 ocak  indirimleri hakkında banner vardı.
        //Banner cumartesi günü kalktığından bu fonskiyonu yorum satırına aldım.
        //banner gözükülürse açılıp koşturulabilir.
        Thread.sleep(2000);
        element(policy).click();
        Thread.sleep(2000);
        element(second).click();
        Thread.sleep(2000);
        logger.info("2. arama sayfasına gidildi.");
    }

    //2. sayfa kontrolü.
    @Test
    public void test_1_6_controlSecondPage(){
        Assert.assertEquals("Bilgisayar - GittiGidiyor - 2/100",driver.getTitle());
        logger.info("2. sayfanın açıldığı kontrol edildi. ");
    }

    //Çıkan ürünlerden rastgele birini seçme
    private By product=By.id("product_id_616003585");
    @Test
    public void test_1_7_selectProduct(){
        element(product).click();
        logger.info("Çıkan 2. ürün seçildi.");
    }

    //Sepete ekleme
    private By basket=By.id("add-to-basket");
    @Test
    public void test_1_8_addToBasket() throws InterruptedException {
        Thread.sleep(2000);
        element(basket).click();
        logger.info("Sepete eklendi.");
    }

    //Fiyat karşılaştırması
    private By sepet=By.cssSelector("a[class='gg-ui-btn-default padding-none']");
    @Test
    public void test_1_9_comparison() throws InterruptedException {
       String price=driver.findElement(By.cssSelector("span[id='sp-price-highPrice']")).getText();
       Thread.sleep(2000);
       element(sepet).click();
       Thread.sleep(2000);
       String sepetprice=driver.findElement(By.cssSelector("div[class='total-price']")).getText();
       Assert.assertEquals(price,sepetprice);
       logger.info("Ürün sayfasındaki fiyat ile sepette yer alan ürün fiyatının doğruluğu karşılaştırıldı.");
    }

    //Ürün sayısını artırma
    private By plus=By.cssSelector("span[class='plus icon-plus gg-icon gg-icon-plus']");
    @Test
    public void test_2_1_productPlus() throws InterruptedException {
        Thread.sleep(2000);
    element(plus).click();
    Thread.sleep(2000);
    String value=driver.findElement(By.cssSelector("div[class='gg-d-16 detail-text']")).getText();
    Assert.assertEquals("Ürün Toplamı (2 Adet)",value);
    logger.info("ürün sayısı artırıldı ve 2 adet olduğu kontrol edildi.");
    }


    //Sepeti boşaltma.
    private By deleteProduct=By.cssSelector("span[class='hidden-m']");
    @Test
    public void test_2_2_deletingProduct() throws InterruptedException {
        element(deleteProduct).click();
        Thread.sleep(2000);
        String check=driver.findElement(By.cssSelector("div[class='gg-w-22 gg-d-22 gg-t-21 gg-m-18']")).getText();
        Assert.assertEquals("Sepetinizde ürün bulunmamaktadır." + "\n"+
                                    "Alışverişe devam etmek için anasayfaya gidebilir veya Günün Fırsatı ürünlerine göz atabilirsiniz.",check);
        logger.info("Sepet boşaltıldı ve test tamamlandı.");
        driver.quit();
    }
}
