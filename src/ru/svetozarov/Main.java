package ru.svetozarov;

import ru.svetozarov.jabx_parser.JabxParser;
import ru.svetozarov.modul_for_sql.complex.ComplexModulSQL;
import ru.svetozarov.objects.entity.*;
import ru.svetozarov.objects.entity.Driver;
import ru.svetozarov.objects.list_entity.ListOrder;
import ru.svetozarov.thread_manager.ManagerThread;
import ru.svetozarov.thread_manager.ThreadSQL;

import javax.xml.bind.JAXBException;
import java.io.File;
import java.sql.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by E. Svetozarov on 16.02.2017.
 */
public class Main {
    public static void main(String[] args) throws ClassNotFoundException, JAXBException, SQLException, IllegalAccessException {
        Class.forName("com.mysql.jdbc.Driver");
        List<ThreadSQL> listThread = new ArrayList<>();
        ManagerThread managerThread = new ManagerThread(true, listThread);
        managerThread.start();
    }
}

