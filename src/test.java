import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class test {

    // Connect to your database.
    // Replace server name, username, and password with your credentials
    public static void main(String[] args) {
        String connectionUrl =
                "jdbc:mysql://sql11.freesqldatabase.com:3306/sql11495010";


        ResultSet resultSet = null;

        try (Connection connection = DriverManager.getConnection(connectionUrl,"sql11495010", "SRwSuf13UR" );
             Statement statement = connection.createStatement();) {

            Class.forName("com.mysql.cj.jdbc.Driver");

            // Create and execute a SELECT SQL statement.
            String selectSql = "SELECT * FROM schueler";
            resultSet = statement.executeQuery(selectSql);

            // Print results from select statement
            while (resultSet.next()) {
                System.out.println(resultSet.getString(4) + " " + resultSet.getString(5));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}