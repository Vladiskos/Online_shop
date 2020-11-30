package com.java.automation.lab.fall.cehanovich.core22.domain.service;

import com.java.automation.lab.fall.cehanovich.core22.domain.classes.RGB;
import com.java.automation.lab.fall.cehanovich.core22.domain.constant.PropertyConstant;
import com.java.automation.lab.fall.cehanovich.core22.domain.dao.RGBDAO;
import com.java.automation.lab.fall.cehanovich.core22.domain.dao.impl.mock.RGBDAOImpl;

import java.util.List;

public class RGBService extends BaseService{
    private static final RGBDAO DAO = RGBDAO_MAP.get(PROPS.getValue(PropertyConstant.ENV_KEY));


    public static RGB createRGB(int red, int green, int blue) {
        return DAO.create(new RGB(red, green, blue));
    }

    public static RGB getRGBById(Long id) {
        return DAO.getById(id);
    }

    public static List<RGB> get() {
        return DAO.get();
    }

    public static RGB update(RGB o) {
        return DAO.update(o);
    }

    public static void deleteById(Long id) {
        DAO.deleteById(id);
    }
}
