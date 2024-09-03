package ru.netology.page;

import com.codeborne.selenide.SelenideElement;
import ru.netology.data.DataHelper;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    private SelenideElement loginField = $("[data-test-id=login] input"); //поле для заведения логина
    private SelenideElement passwordField = $("[data-test-id=password] input"); //поле для заведения пароля
    private SelenideElement loginButton = $("[data-test-id=action-login]"); //кнопка входа

    //метод перехода на следующую страницу (VerificationPage) для зарегистрированного пользователя,
    //в котором передаем объект, содержащий информацию для входа в систему (логин и пароль)

    public VerificationPage validLogin(DataHelper.AuthInfo info) {
        loginField.setValue(info.getLogin());
        passwordField.setValue(info.getPassword());
        loginButton.click();
        return new VerificationPage();
    }

}
