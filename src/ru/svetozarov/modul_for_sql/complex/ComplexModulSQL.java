package ru.svetozarov.modul_for_sql.complex;

import com.mysql.jdbc.Connection;
import ru.svetozarov.modul_for_sql.connection.SingletonConnection;
import ru.svetozarov.objects.collections.ListAddedEntries;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;

/**
 * Класс для выгрузки и загрузки объетов в бд
 * Created by E. Svetozarov on 16.02.2017.
 */
public class ComplexModulSQL<T> {
    private static final String db = "taxi";
    private final String[] objectsType = {"status_driver", "auto", "client", "driver"};
    private final String[] fieldsId = {"id_status", "id_auto", "id_client", "id_driver"};

    /**
     * Функция выборки данных из базы
     * @param object-тип возвращаемого объекта, по которому строится запрос
     * @return - возвращаем записи, помещенные в коллекцию объектов
     * @throws SQLException
     * @throws IllegalAccessException
     */
    public ArrayList<T> selectAll(Class object)
            throws SQLException, IllegalAccessException {
        Connection conn = SingletonConnection.getConnection();
        Field fields[] = object.getDeclaredFields();
        String nameParentTable = object.getSimpleName().toLowerCase();
        String pseudonymParentTable = nameParentTable.substring(0, 3);
        String str = "Select * from " + db + "." + nameParentTable + " as " + pseudonymParentTable;
        ArrayList<T> list = new ArrayList<T>();

        int lenght = fields.length;
        boolean flagJoin = false;

        PreparedStatement preparedStatement = conn.prepareStatement(str);
        ResultSet rs = preparedStatement.executeQuery();
        int tempIndex = 0;
        while (rs.next()) {
            try {
                T ob = (T) object.newInstance();
                m:for (int i = 0; i < fields.length; i++) {
                    setFieldObject(rs, fields[i], i+tempIndex, ob);
                }
                list.add(ob);
            } catch (InstantiationException e) {
                System.out.println("error create object...");
            }
        }
        return list;
    }

    private void setFieldObject(ResultSet resultSet, Field field, int index, T object)
            throws SQLException, IllegalAccessException, InstantiationException {
        field.setAccessible(true);
        switch (field.getType().getSimpleName().toLowerCase()) {
            case "string":
                field.set(object, resultSet.getString(++index));
                break;
            case "int":
                field.set(object, resultSet.getInt(++index));
                break;
            case "date":
                field.set(object, resultSet.getDate(++index));
                break;
            case "char":
                field.set(object, resultSet.getString(++index).charAt(0));
                break;
        }
    }

    private void setFieldSQL(PreparedStatement preparedStatement, Field field, T object, int index) throws IllegalAccessException, SQLException {

        switch (field.getType().getSimpleName().toLowerCase()) {
            case "string":
                preparedStatement.setString(index, (String) field.get(object));
                break;
            case "int":
                preparedStatement.setInt(index, (Integer) field.get(object));
                break;
            case "date":
                preparedStatement.setDate(index, (Date) field.get(object));
                break;
            case "char":
                preparedStatement.setString(index, field.get(object).toString());
                break;
            case "auto":
            case "status_driver":
            case "status_order":
            case "client":
            case "order":
            case "driver":
                Field tempFields[] = field.get(object).getClass().getDeclaredFields();
                tempFields[0].setAccessible(true);
                preparedStatement.setInt(index, (Integer) tempFields[0].get(field.get(object)));

                break;
        }
    }

    /**
     * Функция вставки записи в базу данных
     * @param object - запись
     * @param entries - объект, хранящий id-шники уже втавленных записей
     * @param conn - наш коннекшн к базе
     * @return - в случае успешного завершения true, иначе - false
     * @throws SQLException
     * @throws IllegalAccessException
     */
    public boolean insertComplexObject(T object, ListAddedEntries entries, Connection conn) throws SQLException, IllegalAccessException {
        Class obj = object.getClass();
        String str = "INSERT IGNORE " + db + "." + obj.getSimpleName().toLowerCase() + " set  ";
        Field[] fields = obj.getDeclaredFields();
        String strValue = "";
        int lenght = fields.length;
        m:
        for (int i = 0; i < lenght; i++) {
            if (i > 0) {
                strValue += ", ";
            }
            fields[i].setAccessible(true);
            for (String embedded :
                    objectsType) {
                if (embedded.equals(fields[i].getType().getSimpleName().toLowerCase())) {
                    if (fields[i].get(object) == null) {
                        continue m;
                    }
                    //insertComplexObject((T) fields[i].get(object));
                    Field tempFields[] = fields[i].get(object).getClass().getDeclaredFields();
                    tempFields[0].setAccessible(true);
                    if(!checkEntries(entries, obj.getSimpleName().toLowerCase(), fields[i].getName(),
                            (Integer) tempFields[0].get(fields[i].get(object)))){
                        return false;
                    }
                    strValue += "id_" + fields[i].getName() + "=?";
                    continue m;
                }

            }

            for (String field:
                 fieldsId  ) {
                if(field.equals(fields[i].getName())){
                    if(!checkEntries(entries, obj.getSimpleName().toLowerCase(), fields[i].getName(),
                            (Integer) fields[i].get(object) )){
                        return false;
                    }
                }
            }
            strValue += fields[i].getName() + "=?";
        }

        str += strValue;


        PreparedStatement preparedStatement = conn.prepareStatement(str);
        for (int i = 0; i < lenght; i++) {
            int index = i + 1;
            setFieldSQL(preparedStatement, fields[i], object, index);
        }
        preparedStatement.executeUpdate();
        addEntries(entries, obj.getSimpleName().toLowerCase(), (Integer) fields[0].get(object));
        return true;
    }


    private boolean checkEntries(ListAddedEntries entries, String objectName, String field, int id){
        boolean result = false;
        switch (field){

            case "status":
                switch (objectName){
                    case "driver":
                        result = entries.checkStatusDriver(id);
                        break;
                    case "order":
                        result = entries.checkStatusOrder(id);
                        break;
                }
            case "auto":
                result = entries.checkAuto(id);
                break;
            case "id_driver":
                result = entries.checkDriver(id);
                break;
            case "id_client":
                result = entries.checkClient(id);
                break;
            case "id_status":
                switch (objectName){
                    case "driver":
                        result = entries.checkStatusDriver(id);
                        break;
                    case "order":
                        result = entries.checkStatusOrder(id);
                        break;
                }
                break;
            case "id_auto":
                result = entries.checkAuto(id);
        }
        return  result;
    }

    private void addEntries(ListAddedEntries entries, String objectName, int id){
        switch (objectName){
            case "status_driver":
                entries.addedStatusDriver(id);
                break;
            case "status_order":
                entries.addedStatusOrder(id);
                break;
            case "driver":
                entries.addedClient(id);
                break;
            case "client":
                entries.addedDriver(id);
                break;
            case "auto":
                entries.addedAuto(id);
                break;
        }
    }
}
