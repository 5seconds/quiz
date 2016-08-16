package br.com.fiveseconds.quiz.dao;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

public class ConnectionFactory {
public Connection getConnection() throws SQLException {
String nomeBanco = "projeto";
String usuario = "root";
String senha = "1234";
try {
Class.forName("com.mysql.jdbc.Driver");
} catch (ClassNotFoundException e) {
throw new SQLException(e);
}
return (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/" + nomeBanco,
usuario, senha);
}
}
