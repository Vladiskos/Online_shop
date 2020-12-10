package com.java.automation.lab.fall.cehanovich.core22.domain.runner;

import com.java.automation.lab.fall.cehanovich.core22.domain.classes.*;
import com.java.automation.lab.fall.cehanovich.core22.domain.classes.info.BillingInfo;
import com.java.automation.lab.fall.cehanovich.core22.domain.enums.*;
import com.java.automation.lab.fall.cehanovich.core22.domain.enums.Currency;
import com.java.automation.lab.fall.cehanovich.core22.domain.service.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.*;
import java.util.stream.Collectors;
import java.util.concurrent.*;


public class Main {

    public static void main(String[] args) {
        /*
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
        BillingInfo a = new BillingInfo(BigDecimal.valueOf(100), PaymentType.ON_SPOT,"info",
                new Address(5,City.MINSK, "Puskina", 5, 9),
                LocalDate.of(2020,03,12),
                LocalDate.of(2020,03,12));
         */

/*

        BillingInfoService.createBillingInfo(1, BigDecimal.valueOf(100), PaymentType.ON_SPOT,"info",
                new Address(1,City.MINSK, "Puskina", 22, 22),
                LocalDate.of(2020,03,12),
                LocalDate.of(2020,03,12)
                );


        System.out.println(PaymentType.ON_SPOT);
        System.out.println(PaymentType.ONLINE);

*/
/*
        VariationService.createVariation(1,Size.S,Color.BLACK,5,LocalDate.of(2020,12,12), LocalDate.of(2020,12,12));
        ProductService.createProduct(1, "q", "brand", "description",
                new Variation(1,Size.S,Color.BLACK,5,LocalDate.of(2020,12,12),
                        LocalDate.of(2020,12,12)),LocalDate.of(2020,12,12),
                        LocalDate.of(2020,12,12));
*/


        //SubcategoryService.createSubcategory(1,3,"333", products);
/*
        Set<Subcategory> subcategories = new HashSet<>();
        subcategories.add(new Subcategory(1,3,"333", products));
        subcategories.add(new Subcategory(1,3,"123", products));
        subcategories.add(new Subcategory(1,3,"321", products));
        subcategories.add(new Subcategory(1,3,"3323", products));



        CategoryService.createCategory(1, subcategories, "qw");
*/

        CouponService.createCoupon(1,true,5, LocalDate.of(2020, 12,8),
                LocalDate.of(2020, 12,8));

        try {
            BankCardService.createBankCard("1111 1111 1111 1111", "10/13", "112", BigDecimal.valueOf(2000));
        } catch (Exception e) {
            e.printStackTrace();
        }

        Set<BankCard> bankCards = new HashSet<>();
        try {
            bankCards.add(new BankCard("1111 1111 1111 1111", "10/13", "112", BigDecimal.valueOf(2000)));
        } catch (Exception e) {
            e.printStackTrace();
        }

        RegisteredUserService.createRegisteredUser(1,"Vasya", "Filipov", "123123",
                "vasya1212@mail.ru", bankCards, 5, LocalDate.of(1999, 10, 10),
                "salt", 6873426, LocalDate.now(), LocalDate.now(), 1);



        Map<Variation, BigDecimal> priceAndProduct = new HashMap<>();
        priceAndProduct.put(new Variation(1,Size.S,Color.BLACK,5,LocalDate.of(2020,12,12),
                LocalDate.of(2020,12,12)), BigDecimal.valueOf(1111));


        PriceBook priceBook = new PriceBook(1,Currency.BYN,true, LocalDate.of(2010,10,10),
                LocalDate.of(2012,10,10), priceAndProduct, LocalDate.of(2012,10,10),
                LocalDate.of(2012,10,10));

        List<Variation> variations = new ArrayList<>();



        RegisteredUser reg = new RegisteredUser(1,"Vasya", "Filipov", "123123",
                "vasya1212@mail.ru", bankCards, 5, LocalDate.of(1999, 10, 10),
                "salt", 6873426, LocalDate.now(), LocalDate.now(), 1);

        try {
            BasketService.createBasket(12, variations, BigDecimal.valueOf(13),
                    new BankCard("1111 1111 1111 1111", "10/13", "112", BigDecimal.valueOf(2000)),
                    priceBook, new Coupon(1,true,5, LocalDate.of(2020, 12,8),
                            LocalDate.of(2020, 12,8)), reg, LocalDate.of(2020,12,12),
                    LocalDate.of(2020,12,12));
        } catch (Exception e) {
            e.printStackTrace();
        }

        Basket b = new Basket();

        try {
            b = new Basket(1, variations, BigDecimal.valueOf(13),
                    new BankCard("1111 1111 1111 1111", "10/13", "112", BigDecimal.valueOf(2000)),
                    priceBook, new Coupon(1,true,5, LocalDate.of(2020, 12,8),
                    LocalDate.of(2020, 12,8)), reg, LocalDate.of(2020,12,12),
                    LocalDate.of(2020,12,12));
        } catch (Exception e) {
            e.printStackTrace();
        }

        ;

        OrderService.createOrder(1, b, "description", BigDecimal.valueOf(13),
                LocalDate.of(2020,10,10), LocalDate.of(2020,10,10));



/*


        Set<Product> products = new HashSet<>();
        products.add(new Product(1, "name", "brand", "description",
                new Variation(1,Size.S,Color.BLACK,5,LocalDate.of(2020,12,12),
                        LocalDate.of(2020,12,12)),LocalDate.of(2020,12,12),
                LocalDate.of(2020,12,12)));



        Map<Variation, BigDecimal> priceAndProduct = new HashMap<>();
        priceAndProduct.put(new Variation(1,Size.S,Color.BLACK,5,LocalDate.of(2020,12,12),
                LocalDate.of(2020,12,12)), BigDecimal.valueOf(1111));

        PriceBookService.createPriceBook(1,Currency.BYN,true, LocalDate.of(2010,10,10),
                LocalDate.of(2012,10,10), priceAndProduct, LocalDate.of(2012,10,10),
                LocalDate.of(2012,10,10));


        Set<BankCard> bankCards = new HashSet<>();
        try {
            bankCards.add(new BankCard("1111 1111 1111 1111", "10/13", "112", BigDecimal.valueOf(2000)));
        } catch (Exception e) {
            e.printStackTrace();
        }

        RegisteredUserService.createRegisteredUser(1,"Vasya", "Filipov", "123123",
                "vasya1212@mail.ru", bankCards, 5, LocalDate.of(1999, 10, 10),
                "salt", 6873426, LocalDate.now(), LocalDate.now(), 1);

        AddressService.createAddress(1,City.MINSK, "Puskina", 11, 11);
        BillingInfoService.createBillingInfo(1, BigDecimal.valueOf(100), PaymentType.ON_SPOT,"info",
                new Address(1,City.MINSK, "Puskina", 22, 22),
                LocalDate.of(2020,03,12),
                LocalDate.of(2020,03,12)
        );

        CouponService.createCoupon(1,true,5, LocalDate.of(2020, 12,8),
                LocalDate.of(2020, 12,8));

*/


    }
}
