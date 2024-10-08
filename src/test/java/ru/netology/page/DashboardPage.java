package ru.netology.page;

import com.codeborne.selenide.SelenideElement;
import lombok.val;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class DashboardPage {
    public DashboardPage() {
        SelenideElement heading = $("[data-test-id=dashboard]");
        heading.shouldBe(visible);
    }

    private SelenideElement firstCardButton = $("[data-test-id='92df3f1c-a033-48e6-8390-206f6b1f56c0'] .button");
    private SelenideElement secondCardButton = $("[data-test-id='0f3f5c2a-249e-4c3d-8287-09f7a039391d'] .button");


    public TransferPage transferToFirstCard() {
        firstCardButton.click();
        return new TransferPage();
    }

    public TransferPage transferToSecondCard() {
        secondCardButton.click();
        return new TransferPage();
    }

    //метод получения баланса по первой карте
    public int getCurrentBalanceOfFirstCard() {
        val text = $(".list__item [data-test-id='92df3f1c-a033-48e6-8390-206f6b1f56c0']").getText();
        return extractBalance(text);
    }

    //метод получения баланса по второй карте
    public int getCurrentBalanceOfSecondCard() {
        val text = $(".list__item [data-test-id='0f3f5c2a-249e-4c3d-8287-09f7a039391d']").getText();
        return extractBalance(text);
    }

    public int extractBalance(String text) {
        val substring = text.split(",");
        val getArraysLength = substring[substring.length - 1];
        val value = getArraysLength.replaceAll("\\D+", "");
        return Integer.parseInt(value);
    }
}
