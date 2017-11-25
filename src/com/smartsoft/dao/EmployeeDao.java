package com.smartsoft.dao;

import com.smartsoft.bean.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDao {

    public static Connection getConnection(){

        Connection connection = null;
        try {
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://localhost:5432/myemployees";
            String root = "postgres";
            String password = "";
            connection = DriverManager.getConnection(url, root, password);

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static int save(Employee employee) {
        int status = 0;
        Connection connection = null;
        try {
            String query = "INSERT INTO emp(username, email, password, country)VALUES (?, ?, ?, ?)";
            connection = EmployeeDao.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, employee.getName());
            preparedStatement.setString(2, employee.getEmail());
            preparedStatement.setString(3, employee.getPassword());
            preparedStatement.setString(4, employee.getCountry());

            status = preparedStatement.executeUpdate();
            connection.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }

    public static int update(Employee employee){
        int status = 0;

        Connection connection = EmployeeDao.getConnection();
        try {
            String sql = "UPDATE emp SET username=?, email=?, password=?, country=? WHERE id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, employee.getName());
            preparedStatement.setString(2, employee.getEmail());
            preparedStatement.setString(3, employee.getPassword());
            preparedStatement.setString(4, employee.getCountry());
            preparedStatement.setInt(5, employee.getId());

            status = preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return status;
    }

    public static int delete(int id){
        int status = 0;
        Connection connection = EmployeeDao.getConnection();
        String sql = "DELETE FROM emp WHERE id=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            status = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }

    public static Employee getEmployeeById(int id){
        Employee employee = new Employee();
        Connection connection = EmployeeDao.getConnection();
        String sql = "SELECT * FROM emp WHERE id=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                employee.setId(resultSet.getInt(1));
                employee.setName(resultSet.getString(2));
                employee.setEmail(resultSet.getString(3));
                employee.setPassword(resultSet.getString(4));
                employee.setCountry(resultSet.getString(5));
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employee;
    }

    public static List<Employee> getAllEmployees(){
        List<Employee> employees = new ArrayList<>();
        Connection connection = EmployeeDao.getConnection();
        String sql = "SELECT * FROM emp";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                Employee employee = new Employee();
                employee.setId(resultSet.getInt(1));
                employee.setName(resultSet.getString(2));
                employee.setEmail(resultSet.getString(3));
                employee.setPassword(resultSet.getString(4));
                employee.setCountry(resultSet.getString(5));
                employees.add(employee);
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employees;
    }
}
