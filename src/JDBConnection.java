import java.sql.*;
//import org.apache.log4j.Logger;

public class JDBConnection {
//    final static Logger logger = Logger.getLogger(JDBConnection.class);

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";


    public static void main (String... args) {

        Connection connection = null;
        Statement statement = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");

//          logger.info(JDBConnection.class + "JDBC Driver is started");
            connection = DriverManager.getConnection(DB_URL,USER,PASS);

            statement = connection.createStatement();
            String sql = "SELECT * FROM user";
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String login = resultSet.getString("login");
                String password = resultSet.getString("password");

                System.out.println("ID >> " + id);
                System.out.println("First name >> " + login);
                System.out.println("Second name >> " + password + "\n");
            }

        }  catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement!=null) {

                    statement.close();
                    connection.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }
}
