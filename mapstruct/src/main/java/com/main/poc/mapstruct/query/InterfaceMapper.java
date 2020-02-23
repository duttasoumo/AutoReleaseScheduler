package com.main.poc.mapstruct.query;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.main.poc.mapstruct.connector.JdbcConnector;
@Component
public class InterfaceMapper {

	@Autowired
	private JdbcConnector connector;

	public String getMapperId(String target, String source) throws SQLException {
		String sql = getSql(),mapperId="";
		PreparedStatement pstate = connector.getConnection().prepareStatement(sql);
		pstate.setString(1, source);
		pstate.setString(2, target);
		ResultSet executeQuery = pstate.executeQuery();
		if(executeQuery.next()) {
			mapperId = executeQuery.getString("mapper_id");
		}
		return mapperId;
	}

	private String getSql() {
		StringBuffer sql = new StringBuffer().append("SELECT ").append("    mapper_id ").append("FROM ")
				.append("    mapping ").append("WHERE ").append("    source_interface =( ").append("    SELECT ")
				.append("        interface_pk ").append("    FROM ").append("        Interfaces ").append("    WHERE ")
				.append("        interface_name = ? ").append(") AND target_interface =( ").append("    SELECT ")
				.append("        interface_pk ").append("    FROM ").append("        Interfaces ").append("    WHERE ")
				.append("        interface_name = ? ").append(")");
		return sql.toString();
	}

}
