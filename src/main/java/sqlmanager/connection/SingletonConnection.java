package sqlmanager.connection;



import com.mysql.jdbc.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Класс-синглетон коннекта к бд
 * Created by E. Svetozarov on 22.02.2017.
 */
public class SingletonConnection {
    private static Connection connection;

    private final  String URL = "jdbc:mysql://localhost:3306/example?useSSL=false&useUnicode=true&characterEncoding=utf-8";
    private final String LOGIN = "root";
    private final String PASSWORD = "1234";

    private SingletonConnection() throws SQLException {
        connection = (Connection) DriverManager.getConnection(URL, LOGIN, PASSWORD);
    }

    /**
     * Функция возвращает connection, создает только один connection
     * @return - возвращает ссылку на connection
     * @throws SQLException
     */
    public static Connection getConnection() throws SQLException {
        if(connection == null) {
            new SingletonConnection();
        }
        return connection;
    }
}
