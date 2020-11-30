package com.java.automation.lab.fall.cehanovich.core22.domain.io;

import com.java.automation.lab.fall.cehanovich.core22.domain.constant.IOConstant;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyReader {
    private Properties props = new Properties();

    private static PropertyReader instance;

    public synchronized static PropertyReader getInstance() {
        if(instance == null) {
            instance = new PropertyReader();
        }
        return instance;
    }

    private PropertyReader() {
        try {
            InputStream is = new FileInputStream(new File(IOConstant.PROPERTIES_PATH).getAbsoluteFile());
            this.props.load(is);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    public String getValue(String key) {
        return this.props.getProperty(key);   
    }
}
