package com.java.automation.lab.fall.cehanovich.core22.domain.runner;

import com.java.automation.lab.fall.cehanovich.core22.domain.classes.*;
import com.java.automation.lab.fall.cehanovich.core22.domain.enums.City;
import com.java.automation.lab.fall.cehanovich.core22.domain.enums.Color;
import com.java.automation.lab.fall.cehanovich.core22.domain.enums.Currency;
import com.java.automation.lab.fall.cehanovich.core22.domain.enums.Size;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.*;
import java.util.stream.Collectors;
import java.util.concurrent.*;


public class Main {

    public static void main(String[] args) {
        Set<BankCard> cards = new HashSet<>();
        cards.add(new BankCard());
        cards.add(new BankCard());
        cards.add(new BankCard());
        Address address = new Address(City.MINSK, "qwerty", 65, 4);

        User us1 = new RegisteredUser(1,"firstname", "lastname", "contactNumber",
                "email", cards, address, 3, LocalDate.of(2000,1,1));
        User us2 = new RegisteredUser(2,"firstname", "lastname", "contactNumber",
                "email", cards, address, 3, LocalDate.of(2000,1,1));


        Basket b = new Basket();
        List<Variation> variations = new ArrayList<>();

        Product product = new Product(13,"1234","sfdg","wcer");
        Variation var = new Variation(1,Size.S,Color.BLACK, product,5);
        variations.add(var);
        variations.add(var);
        variations.add(var);

        PaymentMethod paymentMethod = new BankCard();
        paymentMethod.setBalance(BigDecimal.valueOf(2000));

        Map<Variation, BigDecimal> priceAndProduct = new HashMap<>();
        priceAndProduct.put(var,BigDecimal.valueOf(100));

        PriceBook priceBook = new PriceBook(Currency.EUR,true, OffsetDateTime.now(), OffsetDateTime.now(),
                priceAndProduct);

        Coupon coupon = new Coupon(1, true, 5);

        Basket b1 = new Basket(1, variations, BigDecimal.valueOf(53.52), paymentMethod, priceBook, coupon);
        Basket b2 = new Basket(2, variations, BigDecimal.valueOf(53.52), paymentMethod, priceBook, coupon);
        Runnable thr1 = () -> {
            for (int i = 0; i < 5; i++) {
                us1.takeAnOrder(b1,"", BigDecimal.valueOf(0));
            }
        };
        Runnable thr2 = () -> {
            for (int i = 0; i < 5; i++) {
                us2.takeAnOrder(b1,"", BigDecimal.valueOf(0));
            }
        };

        Executor executor = Executors.newFixedThreadPool(5);
        executor.execute(thr1);
        executor.execute(thr2);

    }
}
