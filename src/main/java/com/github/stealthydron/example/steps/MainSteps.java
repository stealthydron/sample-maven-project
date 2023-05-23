package com.github.stealthydron.example.steps;

import com.github.stealthydron.example.dto.AddressDto;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.Objects;

import static org.testng.Assert.assertEquals;

public class MainSteps {

    private final SubSteps subSteps;

    public MainSteps() {
        this.subSteps = new SubSteps();
    }

    @Step("Выполнить Шаг 1")
    public void mainStep1() {
        System.out.println("Шаг 1");
    }

    @Step("Шаг 2 с дополнительными шагами")
    public void mainStep2() {
        System.out.println("Шаг 2 с дополнительными шагами");
        subSteps.subStep1();
        subSteps.subStep2();
    }

    @Step("Шаг 3 с параметром {param}")
    public void mainStep3(String param) {
        System.out.println("Шаг 3 с параметром" + param);
    }

    @Step("Упавшая проверка с аттачментом")
    public void assertThatSomethingFail() {
        byte[] image;
        try (ByteArrayOutputStream bos = new ByteArrayOutputStream()) {
            File file = new File("src/test/resources/image-small.png");
            BufferedImage bufferedImage = ImageIO.read(file);
            ImageIO.write(bufferedImage, "png", bos);
            image = bos.toByteArray();
        } catch (Exception e) {
            throw new IllegalStateException("Ошибка при создании аттачмента");
        }

        Allure.addAttachment("image", "image/png",
                new ByteArrayInputStream(image), "png");

        assertEquals(1, 2);
    }

    @Step("Проверка какого-нибудь условия")
    public void assertThatSomethingPass() {
        assertEquals(1, 1);
    }

    @Step("Действия с объектом {addressDto}")
    public void fillSomething(AddressDto addressDto) {
        Objects.requireNonNull(addressDto.getStreet());
        System.out.println(addressDto.getStreet());
        assertEquals(addressDto.getStreet(), "test");
    }
}
