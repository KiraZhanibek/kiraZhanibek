package utilities;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JDBCUtils {

    //methods static
    //establishConnection
    // runSQLQuery(String query)--->will resturn list of maps
    //closeDataBase
    //countRows(string query)---> will return int

    private static Connection connection;
   private static  Statement statement;
   private static  ResultSet resultSet;

    //this method established a connections with oracle sql database

    public static void establishConnection()throws IOException, SQLException {
      connection= DriverManager.getConnection(
              Configuration.fileReader("dbhostname"),
              Configuration.fileReader("dbusername"),
              Configuration.fileReader("dbpassword"));
      statement=connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
    }
    // @param query
    //@return
    //@throw SQLException

    public static List<Map<String,Object>> runSQLQuery(String query)throws  SQLException {
        resultSet = statement.executeQuery(query);
        ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
        List<Map<String, Object>> listofMaps = new ArrayList<>();
        int columnCount = resultSetMetaData.getColumnCount();
        while (resultSet.next()) {
            Map<String, Object> row = new HashMap<>();
            for (int i = 1; i <= columnCount; i++) {
                String columnName = resultSetMetaData.getColumnName(i);
                Object columnValues = resultSet.getObject(columnName);
                row.put(columnName, columnValues);
            }
            listofMaps.add(row);
        }
        return listofMaps;
    }

    public static int countRows(String query )throws SQLException{

        resultSet=statement.executeQuery(query);
        return resultSet.getRow();
    }
   public static  void closeConnection()throws  SQLException{
        if(connection!=null){
            connection.close();
        }
        if(statement!=null){
            statement.close();
        }
        if(resultSet!=null){
            resultSet.close();

        }
    }


}
