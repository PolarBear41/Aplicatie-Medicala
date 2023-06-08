/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package WebScraper;

/**
 *
 * @author Asus
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class DatabaseManager {
    private static final String CONNECTION_URL = "jdbc:derby://localhost:1527/Licenta DB";
    private static final String DB_USER = "andrei1";
    private static final String DB_PASSWORD = "andrei1";

    public void insertData(List<MentalDisorder> disorders) {
        try (Connection connection = DriverManager.getConnection(CONNECTION_URL, DB_USER, DB_PASSWORD)) {
            String insertQuery = "INSERT INTO MENTAL_DISORDERS (code, name) VALUES (?, ?)";
            PreparedStatement statement = connection.prepareStatement(insertQuery);

            for (MentalDisorder disorder : disorders) {
                statement.setString(1, disorder.getCode());
                statement.setString(2, disorder.getName());
                statement.addBatch();
            }

            statement.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}