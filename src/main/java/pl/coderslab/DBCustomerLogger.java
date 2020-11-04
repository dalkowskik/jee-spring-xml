package pl.coderslab;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.time.LocalDateTime;

@Component
@Qualifier("DBLogger")
public class DBCustomerLogger implements CustomerLogger{
    @Value("${url}")
    private String url;
    @Value("${url2}")
    private String url2;
    @Value("${url3}")
    private String url3;
    @Override
    public void log() {
        LocalDateTime localDateTime;
        localDateTime = LocalDateTime.now();
        try (Connection conn = DriverManager.getConnection(url,url2,url3)){
            PreparedStatement preStmt =
                    conn.prepareStatement("INSERT INTO logs_content(content) VALUES (?)");
            preStmt.setString(1, String.valueOf(localDateTime));
            preStmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
