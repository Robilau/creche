package Infraestrutura;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DAO {

    public static long add(PreparedStatement statement) throws SQLException {
        int affectedRows = statement.executeUpdate();
        statement.getConnection().close();
        if (affectedRows != 0) {
            ResultSet generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.next()) {
                return generatedKeys.getLong(1);
            }
        }
        return 0;
    }

    public static boolean update(PreparedStatement statement) throws SQLException, Exception {
        int affectedRows = statement.executeUpdate();
        statement.getConnection().close();
        if (affectedRows != 0) {
            return true;
        }
        return false;
    }

    public static boolean delete(PreparedStatement statement) throws SQLException, Exception {
        int affectedRows = statement.executeUpdate();
        statement.getConnection().close();
        if (affectedRows != 0) {
            return true;
        }
        return false;
    }

    public static ResultSet get(PreparedStatement statement) throws SQLException {
        ResultSet rs = statement.executeQuery();
        statement.getConnection().close();
        return rs;
    }

    public static PreparedStatement criarStatementRetornandoChaveGerada(String query) throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/DBCreche", "postgres", "aluno");
        return conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
    }

    public static PreparedStatement criarStatement(String query) throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/DBCreche", "postgres", "aluno");
        return conn.prepareStatement(query);
    }
}
