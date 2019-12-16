package runner;

import utilities.JDBCUtils;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class JDBCTest2 {
    public static void main(String[] args) throws SQLException{
        try {
            JDBCUtils.establishConnection();
            List<Map<String,Object>> dbdata=JDBCUtils.runSQLQuery("select first_name ,last_name,salary from employees");
            System.out.println(dbdata.get(1).get("FIRST_NAME"));
            System.out.println(dbdata.get(0).get("SALARY"));
            System.out.println(JDBCUtils.countRows("Select fist_name,last_name,salary from employees"));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.closeConnection();
            System.out.println("DataBase is closed");
        }


    }
}
