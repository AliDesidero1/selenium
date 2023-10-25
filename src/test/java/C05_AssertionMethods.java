import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.assertSame;

public class C05_AssertionMethods {
    @Test
    public void assertEqualsTest(){
        //2 parametre alirsa parametreler karsilastirilir ve esitlerse test PASSED olur,
        // esit degilse AssertionError firlatir

        Assert.assertEquals(10,10); //passed
    }
    @Test
    public void assertTrueTest(){
        //1 parametre alir ve gonderilen parametrenin true olmasi durumunda testimiz PASSED,
        // false olmasi durumunda da FAILED olur

        Assert.assertTrue(5==5);
    }

    @Test
    public void assertFalseTest(){
        //1 parametre alir ve gonderilen parametrenin false olmasi durumunda testimiz PASSED,
        // true olmasi durumunda da FAILED olur

        Assert.assertFalse(5==4);
    }

    @Test
    public void assertNullTest(){
        //1 parametre alir, Parametre null ise test PASSED,
        // null degil ise test FAILED olur

        Assert.assertNull(null);
    }

    @Test
    public void assertNotNullTest(){
        //1 parametre alir, Parametre null degil ise test PASSED,
        // null ise test FAILED olur
        Assert.assertNotNull(4);
    }

    @Test
    public void assertSameTest(){
        //bu method iki nesnenin esit olup olmadigini dogrulamak icin dahili olarak == operatorunu kullanir
        //assertSame referans degerlerini de karsilastirir..
        //obje kontrolunde deger ve referanslar ayni olmalidir...

        assertSame("Elly","Elly"); //passed
        //Assert.assertSame(new String("Hi"), new String("Hi")); //failed
    }

    @Test
    public void assertNotSameTest(){
        //obje kontrolunde deger ve referanslar ayni olmayanlar icin gecerlidir

        Assert.assertNotSame(new String("Hi"), new String("Hi")); //passed
    }

    @Test
    public void assertArrayEquals(){
        //2 parametre alir ve verilen arraylerin uzunluklari ve ayni indexdeki elemanlari ayni olmalidir

        int [] arr1 = {0,1,2,3,4}, arr2= {0,1,2,3,4};

        Assert.assertArrayEquals(arr1,arr2);


        char[] actualArr = {'h','o', 'm', 'e'};
        char[] expectedArr = {'H','O', 'M', 'E'};

        //Assert.assertArrayEquals("iki array esit degilse fail olacak",expectedArr,actualArr); //failed
    }
    @Test
    public void assertEqulasWithMessage(){
        Assert.assertEquals("değerler aynı çıkmadı, 74-105.satırlar arasını kontrol et",5,10);

    }
}
 /*
    import static org. junit. Assert. *;
    assertSame

     import org. junit. Assert;
     Assert.assertSame

     Assert sınıfı için statik içe aktarmanın avantajı şudur:

        Assert sınıf adının gereksiz kullanımını Assert yöntemleriyle ortadan kaldırmak için.
        Zaman kazandırır.
        Yazmayı daha iyi hale getirir ve
        Kodun okunabilirliğini artırır.
     */
