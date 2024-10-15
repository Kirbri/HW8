package ru.kirbri.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class QaGuruTest extends TestBase{
    @BeforeEach
    void beforeEach() {
        open("https://qa.guru/");
    }

    static Stream<Arguments> qaGuruSiteShouldCorrectCourseTest() {
        return Stream.of(
                Arguments.of("java", "Курс по автоматизации тестирования на Java"),
                Arguments.of("python", "Курс по автоматизации тестирования на Python"),
                Arguments.of("java_advanced", "Продвинутый курс по автоматизации тестирования Java Advanced 2.0"),
                Arguments.of("python_advanced", "Продвинутый курс по автоматизации тестирования Python Advanced"),
                Arguments.of("chatgpt", "Курс-интенсив\nАвтоматизация тестов с ChatGPT")
        );
    }

    @Tags({
            @Tag("WEB"),
            @Tag("SMOKE")
    })
    @MethodSource
    @DisplayName("Проверка курсов на сайте qa.guru")
    @ParameterizedTest
    void qaGuruSiteShouldCorrectCourseTest(String expectedUrl, String expectedText) {
        $$(".t-menu__link-item.t-menusub__target-link").get(1).hover();
        $("[href=\"https://qa.guru/" + expectedUrl + "\"]").click();
        $(".t995__inner-wrapper").shouldHave(text(expectedText));
    }
}
