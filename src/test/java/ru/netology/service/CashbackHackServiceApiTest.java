package ru.netology.service;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;

public class CashbackHackServiceApiTest {
    CashbackHackService service = new CashbackHackService();

    // Нет товаров в корзине
    @org.junit.jupiter.api.Test
    public void shouldWithoutPurchases() {

        Assertions.assertEquals(1000, service.remain(0));
    }

    // Минимальная покупка
    @org.junit.jupiter.api.Test
    public void shouldMinimumPurchase() {

        Assertions.assertEquals(999, service.remain(1));
    }

    // Покупка в пределах границ
    @org.junit.jupiter.api.Test
    public void shouldPurchaseWithinBorders() {

        Assertions.assertEquals(1, service.remain(999));
    }

    // Покупка по верхней минимальной границе для начисления кешбека
    @org.junit.jupiter.api.Test
    public void shouldPurchaseUpperLimit() {

        Assertions.assertEquals(0, service.remain(1000));
    }

    // Покупка выше верхней границы минимальной покупки для начисления кешбека
    // для нового расчета программа предлагает добавить товар.
    @org.junit.jupiter.api.Test
    public void shouldAboveUpperLimit() {

        Assertions.assertEquals(999, service.remain(1001));
    }

}
