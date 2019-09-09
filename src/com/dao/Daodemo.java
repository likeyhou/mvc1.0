package com.dao;

import com.domain.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Daodemo {

    public List<Student> getAll(){

        List<Student> students = new ArrayList<>();

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            String driverClass = "com.mysql.jdbc.Driver";
            String url = "jdbc:mysql:///app?serverTimezone=UTC&useUnicode=true&characterEncoding=UTF-8&useSSL=false";
            String user = "root";
            String password = "root";

            Class.forName(driverClass);
            connection = DriverManager.getConnection(url, user, password);

            String sql = "SELECT name, id, grade " +
                    "FROM student";
            preparedStatement = connection.prepareStatement(sql);

            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                String name= resultSet.getString(1);
                String id = resultSet.getString(2);
                int grade = resultSet.getInt(3);
                Student student = new Student(name, id,  grade);
                students.add(student);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            try {
                if(resultSet != null){
                    resultSet.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                if(preparedStatement != null){
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                if(connection != null){
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return students;
    }



    public void del(String id){

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            String driverClass = "com.mysql.jdbc.Driver";
            String url = "jdbc:mysql:///app?serverTimezone=UTC&useUnicode=true&characterEncoding=UTF-8&useSSL=false";
            String user = "root";
            String password = "root";


            Class.forName(driverClass);
            connection = DriverManager.getConnection(url, user, password);

            String sql = "DELETE FROM student WHERE id = ?";
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, id);

            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally{

            try {
                if(preparedStatement != null){
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                if(connection != null){
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }




    }



        }






