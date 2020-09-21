package model.dao;


import model.connection.PoolConnectionBuilder;
import model.entity.Dept;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DeptDAOImpl implements DAO<Dept, Integer> {

    private Connection connection;

    public DeptDAOImpl() {
        this.connection = new PoolConnectionBuilder().getConnection();
    }

    @Override
    public void create(Dept dept) {
        String sqlQuery = "INSERT INTO DEPT VALUES (?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)) {
            preparedStatement.setInt(1, dept.getDeptno());
            preparedStatement.setString(2, dept.getDname());
            preparedStatement.setString(3, dept.getLoc());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Dept read(Integer integer) {
        String sqlQuery = "SELECT * FROM DEPT WHERE DEPTNO = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)) {
            preparedStatement.setInt(1, integer);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return new Dept(
                        integer,
                        resultSet.getString("DNAME"),
                        resultSet.getString("LOC"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void update(Dept dept) {
        String sqlQuery = "UPDATE DEPT SET DNAME = ?, LOC = ? WHERE DEPTNO = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement((sqlQuery))) {
            preparedStatement.setString(1, dept.getDname());
            preparedStatement.setString(2, dept.getLoc());
            preparedStatement.setInt(3, dept.getDeptno());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Dept dept) {
        String sqlQuery = "DELETE FROM DEPT WHERE DEPTNO = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)) {
            preparedStatement.setInt(1, dept.getDeptno());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
