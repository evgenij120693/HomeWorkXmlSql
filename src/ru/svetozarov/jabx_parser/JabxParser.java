package ru.svetozarov.jabx_parser;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

/**
 * Класс для сериализации и десериализации объектов в XML
 * Created by E. Svetozarov on 18.02.2017.
 */
public class JabxParser  {
    /**
     * Функция десериализации объекта по данным xml
     * @param c - тип десериализуемого объекта
     * @param name - имя файла
     * @return - возвращает десериализованный готовый объект
     * @throws JAXBException
     */
    public Object readXML( Class c, String name) throws JAXBException {
        File file = new File(name+".xml");
        JAXBContext context = JAXBContext.newInstance(c);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        Object object = unmarshaller.unmarshal(file);
        return object;
    }

    /**
     * Функция сериализации объекта в xml
     * @param c - сериализуемый объект
     * @param name - имя файла xml, в который будет записан результат сериализации
     * @throws JAXBException
     */
    public void writeObjectToXML( Object c, String name) throws JAXBException {
        File file = new File(name+".xml");
        JAXBContext context = JAXBContext.newInstance(c.getClass());
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marshaller.marshal(c,file);
    }
}
