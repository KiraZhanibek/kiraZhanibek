package runner;

import utilities.Configuration;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JDBCTest {
    // JDBC -java database Connectivity

    public static void main(String[] args) throws IOException, SQLException {
        //Connection class
        //Statment
        //ResultSet
        Connection connection = DriverManager.getConnection(
                Configuration.fileReader("dbhostname"),
                Configuration.fileReader("dbusername"),
                Configuration.fileReader("dbpassword"));
        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY);
        ResultSet resultSet = statement.executeQuery("select * from employees");
        System.out.println(resultSet.getRow());
        resultSet.next();
        resultSet.next();
        String myFirstData = resultSet.getString("first_name");
        System.out.println(myFirstData);
        resultSet.next();
        System.out.println(resultSet.getString("first_name"));
        resultSet.next();
        System.out.println(resultSet.getString("employee_id"));
        System.out.println(resultSet.getRow());

        ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
        System.out.println("-------------------------------------------------");
        System.out.println(resultSetMetaData.getColumnCount());
        System.out.println(resultSetMetaData.getColumnName(5));
        System.out.println(resultSetMetaData.getColumnType(5));
        List<Map<String, Object>> list = new ArrayList<>();
        resultSet.next();
        while (resultSet.next()) {
            Map<String, Object> row = new HashMap();
            for (int i = 1; i <= resultSetMetaData.getColumnCount(); i++) {
                row.put(resultSetMetaData.getColumnName(i), resultSet.getObject(resultSetMetaData.getColumnName(i)));
            }
            list.add(row);
        }
        for (int i=0;i<list.size();i++){
            for(Object key:list.get(i).keySet()){
                System.out.println(list.get(i).get(key));


            }
        }

    }
}
