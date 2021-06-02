# gittigidiyor.com

www.gittigidiyor.com için yapılan otomasyon test yazılımıdır.

Testin başarılı çalışması için kullanıcının kendi tarayıcısı ve driver konumu kullanılmalıdır. BaseTest.class 'ında bu kısım ayrıca not alınmıştır. Browser sürümüm chrome version 88 ve ona uygun olan driverdır. (https://chromedriver.chromium.org/downloads).

Loglama için ayrıca log4j yapısı kullanılmıştır. Daha önceki başarılı ve başarısız koşturmalar logingng.log kısmından okunabilir.


Test Caseler:

test_1_1_HomePage: Anasayfaya giriş ve site title kontrolü.
test_1_2_LoginPage: Login sayfasına giriş.
test_1_3_Logged_in: Username ve password giriş.
test_1_4_search: Arama bölgesine bilgisayar yazıp aratılması.
test_1_5_secondPage: Arama sonuçlarının 2. sayfasına giriş.
test_1_6_controlSecondPage: 2. sayfaya gidildiğine dair kontrol.
test_1_7_selectProduct: Çıkan ürünlerden rastgele seçme(2. ürün seçildi).
test_1_8_addToBasket: Sepete Ekleme.
test_1_9_comparison: Ürün sayfasındaki fiyatla sepetteki fiyatın karşılaştırılması.
test_2_1_productPlus: Ürün sayısını arttırma.
test_2_2_deletingProduct: Sepeti boşaltma ve sepetin boş olduğunu kontrol etme.
