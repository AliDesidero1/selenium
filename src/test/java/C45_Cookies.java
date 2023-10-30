import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import utilities.TestBase;

import java.util.List;
import java.util.Set;

public class C45_Cookies extends TestBase {
    //***Cookie cookie  = driver.manage().cookie-methods

    //Go to URL: https://kitchen.applitools.com/ingredients/cookie
    //Print all the cookies.
    //Get Cookie.
    //Find the total number of cookies.
    //Add Cookie.
    //Edit Cookie.
    //Delete Cookie.
    //Delete All Cookies.
    @Test
    public void test1() {
        driver.get("https://kitchen.applitools.com/ingredients/cookie");

        //Print all the cookies.
        Set<Cookie> allCookies = driver.manage().getCookies();

        for (Cookie c : allCookies) {
            System.out.println(c);
        }
        System.out.println("******************************************************************");

        //Get Cookie.
        System.out.println(driver.manage().getCookieNamed("protein"));
        Assert.assertEquals("chicken", driver.manage().getCookieNamed("protein").getValue());
        System.out.println("******************************************************************");

        //Find the total number of cookies.
        System.out.println("allCookies.size() = " + allCookies.size());
        System.out.println("******************************************************************");

        //Add Cookie.
        Cookie cookie1 = new Cookie("kalsiyum","süt");
        driver.manage().addCookie(cookie1);

        //Print all the cookies.
        allCookies = driver.manage().getCookies();

        for (Cookie c : allCookies) {
            System.out.println(c);
        }
        System.out.println("******************************************************************");

        //Add Cookie.
        Cookie cookie2 = new Cookie("vegetable","cucumber");
        driver.manage().addCookie(cookie2);

        //Print all the cookies.
        allCookies = driver.manage().getCookies();

        for (Cookie c : allCookies) {
            System.out.println(c);
        }
        System.out.println("******************************************************************");

        //Delete Cookie.
        driver.manage().deleteCookie(cookie2);
        //Print all the cookies.
        allCookies = driver.manage().getCookies();

        for (Cookie c : allCookies) {
            System.out.println(c);
        }
        System.out.println("******************************************************************");

        //Delete All Cookies.
        driver.manage().deleteAllCookies();
        //Print all the cookies.
        allCookies = driver.manage().getCookies();

        for (Cookie c : allCookies) {
            System.out.println(c);
        }
        System.out.println("******************************************************************");

        driver.quit();
    }
}