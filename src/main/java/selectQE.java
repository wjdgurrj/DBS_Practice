import java.sql.*;

public class selectQE {
    public static void main(String[] argv){
        DatabaseAuthInformation db_info = new DatabaseAuthInformation();
        db_info.parse_auth_info("auth/mysql.auth");

        String db_connection_url = String.format("jdbc:mysql://%s:%s/%s?useUnicode=true&" +
                        "useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", db_info.getHost(),
                db_info.getPort(),
                db_info.getDatabase_name());
        /* Prepare the query statement */
        String query_string =
                "(select S.Route_name, S.Day ,S.S_time, S.D_time " +
                "from schedule as S, route as R " +
                "where S.S_time > 11.30 and S.Route_name = R.Route_name and R.S_station = 'Ga' and R.D_station = 'Da')" +
                "UNION" +
                "(select c.Route_name, c.Day ,c.S_time, c.D_time " +
                "from schedule as c,via as V " +
                "where c.Code = V.Code and (V.Name = 'Ga' or V.Name = 'Da') and V.S_time > 11.30)";
        /* DB insertion process */
        try (Connection db_connection = DriverManager.getConnection(db_connection_url,
                db_info.getUsername(),
                db_info.getPassword());

             Statement db_statement = db_connection.createStatement()){
            /* Send query and get the result */
            ResultSet result_set = db_statement.executeQuery(query_string);
            while(result_set.next()) {
                System.out.println("#" + result_set.getString(1) + " " + result_set.getString(2) + " " + result_set.getFloat(3)+ " " + result_set.getFloat(4));
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
