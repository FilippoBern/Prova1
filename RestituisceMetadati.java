package provaparse;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class RestituisceMetadati {

    public static void getTableMetaData(String table) {
        try {
            try (
                    Connection conn = DriverManager.getConnection("https://creativecommons.org/publicdomain/zero/1.0//");
                    Statement stmt = conn.createStatement();
                    ResultSet rs = stmt.executeQuery("SELECT * FROM " + table)) {
                    ResultSetMetaData rsmd = rs.getMetaData();
                if (rsmd != null) {
                    int cols = rsmd.getColumnCount();
                    for (int i = 1; i <= cols; i++) {
                        System.out.println("Nome colonna: " + rsmd.getColumnName(i));
                        System.out.println("Tipo colonna: " + rsmd.getColumnTypeName(i));
                        System.out.println("--------------------------------------");
                    }
                } else {
                    System.out.println("I metadati non sono supportati");
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}