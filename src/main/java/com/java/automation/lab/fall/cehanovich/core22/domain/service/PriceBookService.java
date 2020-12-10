package com.java.automation.lab.fall.cehanovich.core22.domain.service;

import com.java.automation.lab.fall.cehanovich.core22.domain.classes.PriceBook;
import com.java.automation.lab.fall.cehanovich.core22.domain.classes.Variation;
import com.java.automation.lab.fall.cehanovich.core22.domain.constant.PropertyConstant;
import com.java.automation.lab.fall.cehanovich.core22.domain.dao.PriceBookDAO;
import com.java.automation.lab.fall.cehanovich.core22.domain.dao.impl.mock.PriceBookDAOImpl;
import com.java.automation.lab.fall.cehanovich.core22.domain.enums.Currency;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.Map;

public class PriceBookService extends BaseService{
    private static final PriceBookDAO DAO = PRICE_BOOK_DAO_MAP.get(PROPS.getValue(PropertyConstant.ENV_KEY));

    public static PriceBook createPriceBook(long id, Currency currency, boolean enabled, LocalDate validFrom,
                                            LocalDate validTo, Map<Variation, BigDecimal> priceAndProduct,
                                            LocalDate created, LocalDate modified) {
        return DAO.create(new PriceBook(id,currency, enabled, validFrom, validTo, priceAndProduct, created, modified));
    }

    public static PriceBook getPriceBookById(Long id) {
        return DAO.getById(id);
    }

    public static List<PriceBook> get() {
        return DAO.get();
    }

    public static PriceBook update(PriceBook o) {
        return DAO.update(o);
    }

    public static void deleteById(Long id) {
        DAO.deleteById(id);
    }
}
