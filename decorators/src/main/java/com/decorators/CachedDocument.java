package com.decorators;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CachedDocument extends DocumentDecorator {

    public CachedDocument(Document document) {
        super(document);
    }

    public String parse(String path) {
        String cachedResult = getCachedParsedString(path);
        if (cachedResult != null) {
            return cachedResult;
        }

        // If not cached, parse and return the result from the superclass
        String result = super.parse(path);
        // Optionally, store the result in the cache
        saveParsedStringToCache(path, result);
        return result;
    }

    private String getCachedParsedString(String path) {
        String parsedString = null;
        String url = "jdbc:sqlite:/Users/ira/Desktop/lab10/decorators/db.sqlite"; // Database connection URL

        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement("SELECT parsed_string FROM my_table WHERE path = ?")) {
            pstmt.setString(1, path);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                parsedString = rs.getString("parsed_string");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return parsedString;
    }

    private void saveParsedStringToCache(String path, String parsedString) {
        String url = "jdbc:sqlite:db.sqlite"; // Database connection URL

        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement("INSERT INTO my_table (path, parsed_string) VALUES (?, ?)")) {
            pstmt.setString(1, path);
            pstmt.setString(2, parsedString);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}