package DBTest;

import java.sql.*;

public class task1 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://3.239.253.255:3306/syntaxhrm_mysql";
        String username = "syntax_hrm";
        String password = "syntaxhrm123";

        try {
            //we need to establish the connection to the database
            Connection conn = DriverManager.getConnection(url,username,password);
            System.out.println("Connection is created for batch 15");
            // create a statement to send sql queries
            Statement statement = conn.createStatement();
            //ResultSet rset = statement.executeQuery("select FirstName,LastName from person");

            ResultSet rset = statement.executeQuery("");
//            while(rset.next()){
//                String fName = rset.getString("FirstName");
//                String lName = rset.getString("LastName");
//                System.out.println(fName +" "+lName);
//            }

            // ResultSetMetaData object that contains info about the result
            //information such as in  the table how many columns are there,
            //            //name of the columns, rows and number of the rows

            ResultSetMetaData metaData = rset.getMetaData();
            for (int i = 1; i <=metaData.getColumnCount(); i++) {
                String columnName = metaData.getColumnName(i);
                System.out.println(columnName);
            }
            System.out.println();

            //we want to loop every coulmn and every row
            while (rset.next()){
                for (int i = 1; i <=metaData.getColumnCount(); i++) {
                    String value = rset.getString(metaData.getColumnName(i));
                    System.out.println(value + " ");
                }
                // just to change line
                System.out.println();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
