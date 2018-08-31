package App.Handler;

import java.sql.*;
import java.util.HashMap;

public class SQLHandler {

    private static SQLHandler single_instance = null;

    private final String hostName = "eddiesserver.database.windows.net";
    private final String dbName = "DokkanData";
    private final String user = "dokkanreader";
    private final String password = "BackingBakh9000";
    private final String url = String.format("jdbc:sqlserver://%s:1433;database=%s;user=%s;password=%s;encrypt=true;hostNameInCertificate=*.database.windows.net;loginTimeout=30;", hostName, dbName, user, password);
    private Connection connection = null;

    private SQLHandler() {

    }

    public static SQLHandler getInstance() {
        if (single_instance == null){
            single_instance = new SQLHandler();
        }

        return single_instance;
    }

    public HashMap<Integer, String > statsBuilderInitialisation(){
        HashMap<Integer, String>  query_result = new HashMap<>();
        try {
            connection = DriverManager.getConnection(url);
            String schema = connection.getSchema();
            System.out.println("Successful connection - Schema: " + schema);

            String selectLRImage = "SELECT N.cid, N.ICON_IMAGE"
                    + " FROM NAME AS N";


            try (Statement statement = connection.createStatement();
                 ResultSet resultSet = statement.executeQuery(selectLRImage)) {

                while (resultSet.next()){
                    query_result.put(resultSet.getInt(1), resultSet.getString(2));

                }
                connection.close();


            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return query_result;
    }

}







