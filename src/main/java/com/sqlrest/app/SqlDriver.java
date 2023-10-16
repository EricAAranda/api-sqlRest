package com.sqlrest.app;

import java.sql.*;
import java.util.*;
 



public class SqlDriver {

	private String userOracle= "AUTOMATIZACION_BACK";
	private String passwordOracle= "qa.654321";
	private String connectioStringOracle= "jdbc:oracle:thin:@10.6.2.111:1524:dbitades";


    public List executeQuery(Request request) throws SQLException {
        Connection connection = null;
        Statement statement = null;
        ResultSet rs = null;

        try {
            connection = DriverManager.getConnection(connectioStringOracle, userOracle, passwordOracle);
            statement = connection.createStatement();
            rs = statement.executeQuery(request.getQuery().toString());
            return jsonBuilder(rs);
        } finally {
            // Cerrar los recursos en el orden inverso a su apertura
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    // Manejar cualquier excepción al cerrar el ResultSet
                    e.printStackTrace();
                }
            }

            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    // Manejar cualquier excepción al cerrar el Statement
                    e.printStackTrace();
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    // Manejar cualquier excepción al cerrar la conexión
                    e.printStackTrace();
                }
            }
        }
    }

    public List updateQuery(Request request) throws SQLException {
        Connection connection = null;
        Statement statement = null;
        ResultSet rs = null;

        try {
            connection = DriverManager.getConnection(connectioStringOracle, userOracle, passwordOracle);
            statement = connection.createStatement();
            rs = statement.executeQuery(request.getQuery().toString());
        } finally {
            // Cerrar los recursos en el orden inverso a su apertura
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    // Manejar cualquier excepción al cerrar el ResultSet
                    e.printStackTrace();
                }
            }

            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    // Manejar cualquier excepción al cerrar el Statement
                    e.printStackTrace();
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    // Manejar cualquier excepción al cerrar la conexión
                    e.printStackTrace();
                }
            }
        }
    return null;}

    public List jsonBuilder(ResultSet resultSet) throws SQLException{
        List<Map<String,  ? >> result = new ArrayList<>();
        while (resultSet.next()) {
            Map<String, Object> row = new HashMap<String, Object>();
            for (int i = 1; i<= resultSet.getMetaData().getColumnCount(); i++){
                row.put(resultSet.getMetaData().getColumnLabel(i).toUpperCase(), resultSet.getObject(i));
            }
            result.add(row);
        }

        return result;
    }

}