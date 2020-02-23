package com.main.poc.mapstruct.connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class JdbcConnector {

	private Connection connection;

	public JdbcConnector(@Value("${spring.datasource.driver-class-name}") String driverClass,
			@Value("${spring.datasource.url}") String dbUrl, @Value("${spring.datasource.username}") String userName,
			@Value("${spring.datasource.password}") String password) throws SQLException, ClassNotFoundException {
		Class.forName(driverClass);
		connection = DriverManager.getConnection(dbUrl, userName, password);
	}

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}
}
