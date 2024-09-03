package ru.netology.page;

import com.codeborne.selenide.SelenideElement;
import ru.netology.data.DataHelper;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class VerificationPage {
    private SelenideElement codeField = $("[data-test-id=code] input"); //поле для ввода кода подтверждения
    private SelenideElement verifyButton = $("[data-test-id=action-verify]"); //кнопка входа

    public VerificationPage() {
        codeField.shouldBe(visible);
    }

    //метод перехода на следующую страницу (DashboardPage),
    //в котором передаем объект, содержащий информацию для входа в систему (код подтверждения)

    public DashboardPage validVerify(DataHelper.VerificationCode verificationCode) {
        codeField.setValue(verificationCode.getCode());
        verifyButton.click();
        return new DashboardPage();
    }

}
