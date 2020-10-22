import java.sql.*;

public class InsertQE {
    public static void main(String[] argv){
        DatabaseAuthInformation db_info = new DatabaseAuthInformation();
        db_info.parse_auth_info("auth/mysql.auth");

        String db_connection_url = String.format("jdbc:mysql://%s:%s/%s?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC"
                        ,db_info.getHost(),
                db_info.getPort(),
                db_info.getDatabase_name());
        /* Prepare the query statement */
        String query_string =
                "insert into station values(?,?)";
        /* DB insertion process */
        try (Connection db_connection = DriverManager.getConnection(db_connection_url,
                db_info.getUsername(),
                db_info.getPassword());

             PreparedStatement db_statement = db_connection.prepareStatement(query_string)){
            /* Set the query statement */
            db_statement.setString(1, "Haha");
            db_statement.setInt(2, 100023);
            db_statement.executeUpdate();
            db_statement.setString(1, "Mama");
            db_statement.setInt(2, 100024);
            db_statement.executeUpdate();
            db_statement.setString(1, "Papa");
            db_statement.setInt(2, 100025);

            /* Send query and get the result */
            int result = db_statement.executeUpdate();
            System.out.println("Updated query: " + result);
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
