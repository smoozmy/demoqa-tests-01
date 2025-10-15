package demoqa;

import com.codeborne.selenide.Configuration;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTest {
    @BeforeAll
    static void beforeAll() {
        WebDriverManager.chromedriver().setup();

        Configuration.baseUrl = "https://demoqa.com";

        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";

        // Главное ↓↓↓
        Configuration.pageLoadStrategy = "none";
        Configuration.pageLoadTimeout = 60000;

        // Чтобы Chrome не зависал на рекламе
        Configuration.browserCapabilities
                .setCapability("goog:chromeOptions", Map.of(
                        "args", List.of(
                                "--remote-allow-origins=*",
                                "--disable-gpu",
                                "--disable-features=NetworkService",
                                "--ignore-certificate-errors",
                                "--disable-extensions",
                                "--disable-popup-blocking",
                                "--disable-notifications",
                                "--disable-dev-shm-usage",
                                "--disable-blink-features=AutomationControlled"
                        )
                ));
    }


    @Test
    void fillFormTest() {


        open("/text-box");

        $("#userName").setValue("Test Username");
        $("#userEmail").setValue("TestEmail@email.ru");
        $("#currentAddress").setValue("Test Current Address");
        $("#permanentAddress").setValue("Test Permanent Address");
        $("#submit").click();

        $("#output").shouldBe(visible);
    }
}
