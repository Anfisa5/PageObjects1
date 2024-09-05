package ru.netology.data;

import lombok.Value;

public class DataHelper {

    private DataHelper() {
    }



    //метод входа в систему для зарегистрированного пользователя (login: 'vasya' и password: 'qwerty123')
    public static AuthInfo getAuthInfo() {

        return new AuthInfo("vasya", "qwerty123");
    }

    //метод для дальнейшего входа в систему по коду подтверждения verification code (hardcoded): '12345'
    public static VerificationCode getVerificationCodeFor(AuthInfo authInfo) {

        return new VerificationCode("12345");
    }


    public static CardInfo getFirstCard() {

        return new CardInfo("5559 0000 0000 0001");
    }

    public static CardInfo getSecondCard() {

        return new CardInfo("5559 0000 0000 0002");
    }

    public static int getBalanceIfIncrease(int balance, int amount) {

        return balance + amount;
    }

    public static int getBalanceIfDecrease(int balance, int amount) {

        return balance - amount;
    }

    public static CardInfo getEmptyCardNumber() {

        return new CardInfo("");
    }

    public static CardInfo getIncorrectCardNumber() {

        return new CardInfo("5559000000005782");
    }

    @Value
    public static class CardInfo {
        String card;
    }

    @Value
    public static class AuthInfo {
        //переменные для входа в систему
        private String login;
        private String password;
    }

    @Value
    public static class VerificationCode {
        //переменная для кода подтверждения
        private String code;
    }





}