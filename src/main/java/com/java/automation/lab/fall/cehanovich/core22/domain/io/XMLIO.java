package com.java.automation.lab.fall.cehanovich.core22.domain.io;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.util.function.Supplier;


public class XMLIO<T> {
    private Class<T> clasz;

    public XMLIO(Class<T> clasz) {
        this.clasz = clasz;
    }

    @SuppressWarnings(value = "unchecked")
    public T read(String pathTo) throws JAXBException {
        T obj = null;
        JAXBContext context = JAXBContext.newInstance(clasz);
        return (T) context.createUnmarshaller().unmarshal(new File(pathTo).getAbsoluteFile());
    }

    @SuppressWarnings(value = "unchecked")
    public void write(T obj, String pathTo) throws JAXBException {
        System.out.println(obj.getClass());
        JAXBContext context = JAXBContext.newInstance(obj.getClass());
        Marshaller mar = context.createMarshaller();
        mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        mar.marshal(obj, new File(pathTo).getAbsoluteFile());
    }
}
