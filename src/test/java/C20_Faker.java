import com.github.javafaker.Faker;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C20_Faker {

    public void test(){
        Faker faker = new Faker();
        System.out.println("faker.internet().emailAddress() = " + faker.internet().emailAddress());
        System.out.println("faker.internet().password() = " + faker.internet().password());
        System.out.println("faker.name().firstName() = " + faker.name().firstName());
        System.out.println("faker.name().fullName() = " + faker.name().fullName());
        //System.out.println("faker.phoneNumber() = " + faker.phoneNumber());//referans verir
        System.out.println("faker.phoneNumber().cellPhone() = " + faker.phoneNumber().cellPhone());
        System.out.println("faker.address().fullAddress() = " + faker.address().fullAddress());
        System.out.println("faker.address().city() = " + faker.address().city());
        System.out.println("faker.date().birthday() = " + faker.date().birthday());
    }
}