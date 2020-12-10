package com.java.automation.lab.fall.cehanovich.core22.domain.service;

import com.java.automation.lab.fall.cehanovich.core22.domain.classes.*;
import com.java.automation.lab.fall.cehanovich.core22.domain.constant.PropertyConstant;
import com.java.automation.lab.fall.cehanovich.core22.domain.dao.VariationDAO;
import com.java.automation.lab.fall.cehanovich.core22.domain.dao.impl.mock.VariationDAOImpl;
import com.java.automation.lab.fall.cehanovich.core22.domain.enums.Color;
import com.java.automation.lab.fall.cehanovich.core22.domain.enums.Size;

import java.time.LocalDate;
import java.util.List;

public class VariationService extends BaseService{
    private static final VariationDAO DAO = VARIATION_DAO_MAP.get(PROPS.getValue(PropertyConstant.ENV_KEY));


    public static Variation createVariation(int id, Size size, Color color, int discount, LocalDate created, LocalDate modified) {
        return DAO.create(new Variation(id, size, color, discount, created, modified));
    }

    public static Variation getVariationById(Long id) {
        return DAO.getById(id);
    }

    public static List<Variation> get() {
        return DAO.get();
    }

    public static Variation update(Variation o) {
        return DAO.update(o);
    }

    public static void deleteById(Long id) {
        DAO.deleteById(id);
    }
}
