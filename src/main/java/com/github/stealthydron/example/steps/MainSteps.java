package com.github.stealthydron.example.steps;

import io.qameta.allure.Allure;
import io.qameta.allure.Step;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;

import static org.testng.Assert.assertEquals;

public class MainSteps {

    private final SubSteps subSteps;

    public MainSteps() {
        this.subSteps = new SubSteps();
    }

    @Step("Main Step 1")
    public void mainStep1() {
        System.out.println("main step");
    }

    @Step("Main Step 2 with sub steps")
    public void mainStep2() {
        System.out.println("Main Step 2 with sub steps");
        subSteps.subStep1();
        subSteps.subStep2();
    }

    @Step("Main Step 3 assert 1")
    public void assertThatSomethingFail() {
        byte[] image = null;
        try (ByteArrayOutputStream bos = new ByteArrayOutputStream()) {
            File file = new File("src/test/resources/image-small.png");
            BufferedImage bufferedImage = ImageIO.read(file);
            ImageIO.write(bufferedImage, "png", bos);
            image = bos.toByteArray();
        } catch (Exception e) { }

        Allure.addAttachment("image", "image/png",
                new ByteArrayInputStream(image), "png");


        assertEquals(1, 2);
    }
    @Step("Main Step 3 assert 2")
    public void assertThatSomethingPass() {
        assertEquals(1, 1);
    }
}
