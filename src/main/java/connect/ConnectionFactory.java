package connect;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {

    private String host;
    private String login;
    private String password;

    public ConnectionFactory() {
        try {
            var fis = new FileInputStream("src/main/resources/config.properties");
            Properties property = new Properties();
            property.load(fis);

            host = property.getProperty("db.host");
            login = property.getProperty("db.login");
            password = property.getProperty("db.password");
        } catch (IOException e) {
            System.err.println("ОШИБКА: Файл свойств отсутствует");
        }
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(host, login, password);
    }
}
