import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.spi.DirStateFactory.Result;

class CFG {
    public static void main(String[] args) throws ClassNotFoundException {
        java.sql.Statement st = null;
        Connection connection = null;
        String url = "jdbc:mysql://localhost:3306/corejavacrudapplication";
        String username = "root";
        String password = "";
        String Driver_Class = "com.mysql.jdbc.Driver";
        String query = "Select * from person";

        try {
            Class.forName(Driver_Class);
            connection = DriverManager.getConnection(url, username, password);
            if (connection != null) {
                System.out.println("The connection established successfully");
                st = connection.createStatement();
                ResultSet rs = st.executeQuery(query);

                while (rs.next()) {
                    rs.next();
                    String name = rs.getString("name");
                    System.out.println(name);
                }
                st.close();
                connection.close();
                System.out.println("COnnection is closed");

            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}