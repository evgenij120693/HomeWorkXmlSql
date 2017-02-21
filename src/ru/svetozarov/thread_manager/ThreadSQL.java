package ru.svetozarov.thread_manager;

import com.mysql.jdbc.Connection;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import ru.svetozarov.jabx_parser.JabxParser;
import ru.svetozarov.modul_for_sql.complex.ComplexModulSQL;
import ru.svetozarov.modul_for_sql.simple.ModulSQLDriver;
import ru.svetozarov.objects.collections.ListAddedEntries;
import ru.svetozarov.objects.entity.*;
import ru.svetozarov.objects.list_entity.*;

import javax.xml.bind.JAXBException;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

/**
 * Класс реализующий выгрузку/загрузку из/в бд
 * Created by E. Svetozarov on 21.02.2017.
 */
public class ThreadSQL extends Thread{
    private static final Logger logger = Logger.getLogger(ThreadSQL.class);

    static {
        DOMConfigurator.configure("src/ru/svetozarov/resources/log4j.xml");
    }

    private final  String URL = "jdbc:mysql://localhost:3306/taxi?useSSL=false&useUnicode=true&characterEncoding=utf-8";
    private final String LOGIN = "root";
    private final String PASSWORD = "1234";
    private ListAddedEntries entries;
    private boolean mode;
    private Connection connection;
    private String nameTable;
    private JabxParser jabxParser = new JabxParser();

    public ListAddedEntries getEntries() {
        return entries;
    }

    public void setEntries(ListAddedEntries entries) {
        this.entries = entries;
    }

    public boolean isMode() {
        return mode;
    }

    public void setMode(boolean mode) {
        this.mode = mode;
    }

    public String getNameTable() {
        return nameTable;
    }

    public void setNameTable(String nameTable) {
        this.nameTable = nameTable;
    }


    private void readFromTable() throws SQLException, IllegalAccessException, JAXBException {
            ComplexModulSQL complexModulSQL = new ComplexModulSQL();
            switch (nameTable) {
                case "order":
                    List<Order> list = complexModulSQL.selectAll(Order.class);
                    ListOrder temp = new ListOrder();
                    temp.setOrderList(list);
                    jabxParser.writeObjectToXML(temp, nameTable);
                    break;
                case "auto":
                    ListAuto auto = new ListAuto();
                    auto.setAutoList(complexModulSQL.selectAll(Auto.class));
                    jabxParser.writeObjectToXML(auto, nameTable);
                    break;
                case "client":
                    ListClient client = new ListClient();
                    client.setClientList(complexModulSQL.selectAll(Client.class));
                    jabxParser.writeObjectToXML(client, nameTable);
                    break;
                case "driver":
                    ListDriver driver = new ListDriver();
                    driver.setDriverList(ModulSQLDriver.select());
                    jabxParser.writeObjectToXML(driver, nameTable);
                    break;
                case "status_driver":
                    ListStatusDrive statusDrive = new ListStatusDrive();
                    statusDrive.setStatusDriveList(complexModulSQL.selectAll(Status_driver.class));
                    jabxParser.writeObjectToXML(statusDrive, nameTable);
                    break;
                case "status_order":
                    ListStatusOrder statusOrder = new ListStatusOrder();
                    statusOrder.setStatusOrderList(complexModulSQL.selectAll(Status_order.class));
                    jabxParser.writeObjectToXML(statusOrder, nameTable);
                    break;
        }
        logger.info("Export from table '"+nameTable+"' successfull");
    }

    private  void writeToSql() throws SQLException, IllegalAccessException, JAXBException {
        try (Connection conn = (Connection) DriverManager.getConnection(URL, LOGIN, PASSWORD)) {
            ComplexModulSQL complexModulSQL = new ComplexModulSQL();
            switch (nameTable) {
                case "order":
                    ListOrder listOrder= (ListOrder) jabxParser.readXML(ListOrder.class, nameTable);;
                    List<Order> tempOrder = listOrder.getOrderList();
                    while (tempOrder.size() != 0){
                        for (int i = 0; i < tempOrder.size(); ) {
                            if(complexModulSQL.insertComplexObject(tempOrder.get(i), entries, conn)){
                                tempOrder.remove( tempOrder.get(i));
                            }else{
                                i++;
                            }
                        }
                    }
                    break;
                case "auto":
                    ListAuto listAuto= (ListAuto) jabxParser.readXML(ListAuto.class, nameTable);;
                    List<Auto> tempAuto = listAuto.getAutoList();
                    while (tempAuto.size() != 0){
                        for (int i = 0; i < tempAuto.size(); ) {
                            if(complexModulSQL.insertComplexObject(tempAuto.get(i), entries, conn)){
                                tempAuto.remove( tempAuto.get(i));
                            }else{
                                i++;
                            }
                        }
                    }
                    break;
                case "client":
                    ListClient listClient = (ListClient) jabxParser.readXML(ListClient.class, nameTable);;
                    List<Client> tempClient = listClient.getClientList();
                    while (tempClient.size() != 0){
                        for (int i = 0; i < tempClient.size(); ) {
                            if(complexModulSQL.insertComplexObject(tempClient.get(i), entries, conn)){
                                tempClient.remove( tempClient.get(i));
                            }else{
                                i++;
                            }
                        }
                    }
                    break;
                case "driver":
                    ListDriver listDriver = (ListDriver) jabxParser.readXML(ListDriver.class, nameTable);;
                    List<Driver> tempDriver = listDriver.getDriverList();
                    while (tempDriver.size() != 0){
                        for (int i = 0; i < tempDriver.size(); ) {
                            if(complexModulSQL.insertComplexObject(tempDriver.get(i), entries, conn)){
                                tempDriver.remove( tempDriver.get(i));
                            }else{
                                i++;
                            }
                        }
                    }
                    break;
                case "status_driver":
                    ListStatusDrive listStatusDrive = (ListStatusDrive) jabxParser.readXML(ListStatusDrive.class, nameTable);
                    List<Status_driver> temp = listStatusDrive.getStatusDriveList();
                    while (temp.size() != 0){
                        for (int i = 0; i < temp.size(); ) {
                            if(complexModulSQL.insertComplexObject(temp.get(i), entries, conn)){
                                temp.remove( temp.get(i));
                            }else{
                                i++;
                            }
                        }
                    }
                    break;
                case "status_order":
                    ListStatusOrder listStatusOrder = (ListStatusOrder) jabxParser.readXML(ListStatusOrder.class, nameTable);;
                    List<Status_order> tempStatusOrder = listStatusOrder.getStatusOrderList();
                    while (tempStatusOrder.size() != 0){
                        for (int i = 0; i < tempStatusOrder.size(); ) {
                            if(complexModulSQL.insertComplexObject(tempStatusOrder.get(i), entries, conn)){
                                tempStatusOrder.remove( tempStatusOrder.get(i));
                            }else{
                                i++;
                            }
                        }
                    }
                    break;
            }
            logger.info("Import in table '"+nameTable+"' successfull");
        }
    }

    @Override
    public void run() {
        try {
            if(mode){
                readFromTable();
            }else{
                writeToSql();

            }
        } catch (SQLException e) {
            logger.error("Error create connection to SQL.\n"+e.getMessage());

            e.printStackTrace();
        } catch (IllegalAccessException e) {
            logger.error("Error read from SQL\n"+e.getMessage());
        } catch (JAXBException e) {
            logger.error("Error write file .xml \n"+e.getMessage());
            e.printStackTrace();
        }
    }
}
