package ru.svetozarov.modul_for_sql.simple;

import ru.svetozarov.modul_for_sql.connection.SingletonConnection;
import ru.svetozarov.objects.entity.Auto;
import ru.svetozarov.objects.entity.Driver;
import ru.svetozarov.objects.entity.Status_driver;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Класс для вызгрузки и загрузки данных из/в таблицу Driver
 * Created by E. Svetozarov on 20.02.2017.
 */
public class ModulSQLDriver {
    public static List<Driver> select() throws SQLException {
        String query = "Select * from taxi.driver as dr JOIN taxi.auto as au ON" +
                " dr.id_auto=au.id JOIN taxi.status_driver as st ON dr.id_status=st.id";
        Connection conn = SingletonConnection.getConnection();
        PreparedStatement preparedStatement = conn.prepareStatement(query);
        ResultSet rs = preparedStatement.executeQuery();
        List<Driver> list = new ArrayList<>();

        while (rs.next()) {
            Driver entity = new Driver();
            entity.setId(rs.getInt(1));
            entity.setLast_name(rs.getString(2));
            entity.setFirst_name(rs.getString(3));
            entity.setPhone_number(rs.getString(4));
            entity.setLogin(rs.getString(5));
            entity.setPassword(rs.getString(6));
            entity.setRating(rs.getInt(7));

            Auto auto = new Auto();
            auto.setId(rs.getInt(10));
            auto.setModel(rs.getString(11));
            auto.setReg_number(rs.getString(12));
            auto.setColor(rs.getString(13));
            entity.setAuto(auto);

            Status_driver status_driver = new Status_driver();
            status_driver.setId(rs.getInt(14));
            status_driver.setName(rs.getString(15));
            status_driver.setDescription(rs.getString(16));
            entity.setStatus(status_driver);
            list.add(entity);
        }
        return list;
    }

}
