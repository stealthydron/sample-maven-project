package com.github.stealthydron.examples.test;

import com.github.avpyanov.tools.annotations.AutotestId;
import com.github.stealthydron.examples.app.Application;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;

public class CreateAutotestAndWorkItemDemoTest {

    Application application = new Application();

    @Epic("Create Work Item Demo Epic")
    @Feature("Create Work Item Demo Epic Feature")
    @Story("Create Work Item Demo Story")
    @TmsLink("24")
    @AutotestId("23")
    @Test(description = "Демо. Создание тест-кейса из кода автотеста")
    public void createAutotestAndWorkItemDemo() {
        application.openParcelsPage()
                .fillSenderAddress("обл Самарская, г Самара, ул Венцека, д. 81, кв. 27")
                .fillRecipientAddress("обл Омская, г Омск, ул Вавилова, д. 45/3")
                .fillWeight("1 кг")
                .selectFirstClass()
                .checkOut()
                .fillSender("Иванов Иван Иванович", "+7(921) 123-12-48")
                .fillRecipient("Петров Петр Петрович", "+7(921) 123-12-48")
                .assertThatSomething("Условие для проверки");
    }
}
