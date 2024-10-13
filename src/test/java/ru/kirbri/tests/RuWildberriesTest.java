package ru.kirbri.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Selenide.*;

public class RuWildberriesTest extends TestBase{
    @BeforeEach
    void beforeEach() {
        open("https://www.wildberries.ru/");
    }

    @ValueSource(strings = {
            "java", "git", "python", "C#"
    })
    @Tags({
            @Tag("WEB"),
            @Tag("SMOKE")
    })
    @ParameterizedTest (name = "Поиск на wildberries.ru товара по ключевому слову {0}")
    void successfulWildberriesSearchTest(String expectedValue) {
        $("#searchInput").setValue(expectedValue).pressEnter();
        $$(".product-card__wrapper").shouldHave(sizeGreaterThan(10));
    }


    @ValueSource(strings = {
            "test_data\\image\\computerMouse.png",
            "test_data\\image\\keyboard.jpg",
            "test_data\\image\\router.jpg"
    })
    @ParameterizedTest (name = "Поиск на wildberries.ru товара по фотографии {0}")
    void successfulWildberriesSearchImageTest(String imgPath) {
//        File img = new File(imgPath);
//        $("[name=\"photo\"]", 0).uploadFile(img);

        $("[name=\"photo\"]", 0).uploadFromClasspath(imgPath);
        $$(".product-card__wrapper").shouldHave(sizeGreaterThan(0));
    }
}
