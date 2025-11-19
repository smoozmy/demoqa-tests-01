package demoqa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTest {
    @BeforeAll
    static void beforeAll() {
        Configur  ation.browserSize = "1920x1080";
    }


    @Test
    void fillFormTest() {


        open("https://demoqa.com/text-box");
        $(".text-center").shouldHave(text("Text Box"));

        $("#userName").setValue("Test Username");
        $("#userEmail").setValue("TestEmail@email.ru");
        $("#currentAddress").setValue("Test Current Address");
        $("#permanentAddress").setValue("Test Permanent Address");
        $("#submit").click();

        $("#output").shouldBe(visible);
    }
}
