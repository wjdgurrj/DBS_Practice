import java.sql.*;

public class CreateQE {
    public static void main(String[] argv){
        DatabaseAuthInformation db_info = new DatabaseAuthInformation();
        db_info.parse_auth_info("auth/mysql.auth");

        String db_connection_url = String.format("jdbc:mysql://%s:%s/%s?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", db_info.getHost(),
                db_info.getPort(),
                db_info.getDatabase_name());
        /* Prepare the query statement */
        String query_string =
                "create table via (Code varchar(30), Name varchar(30), D_time varchar(10), S_time varchar(10)," +
                        " primary key(Code), foreign key (Name) references station(Name));";
        /* DB insertion process */
        try (Connection db_connection = DriverManager.getConnection(db_connection_url,
                db_info.getUsername(),
                db_info.getPassword());

             PreparedStatement db_statement = db_connection.prepareStatement(query_string)){
            /* Set the query statement */

            /* Send query and get the result */
            int result = db_statement.executeUpdate();
            System.out.println("Updated query: " + result);
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
