package model.dao;


import model.connection.PoolConnectionBuilder;
import model.entity.Emp;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmpDAOImpl implements DAO<Emp, Integer> {

    private Connection connection;
    private DeptDAOImpl deptDAO;

    public EmpDAOImpl() {
        this.connection = new PoolConnectionBuilder().getConnection();
        this.deptDAO = new DeptDAOImpl();
    }

    @Override
    public void create(Emp emp) {
        String sqlQuery = "INSERT INTO EMP VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)) {
            preparedStatement.setInt(1, emp.getEmpno());
            preparedStatement.setString(2, emp.getEname());
            preparedStatement.setString(3, emp.getJob());
            preparedStatement.setInt(4, emp.getMgr());
            preparedStatement.setObject(5, Date.valueOf(emp.getHireDate()));
            preparedStatement.setInt(6, emp.getSal());
            preparedStatement.setInt(7, emp.getComm());
            preparedStatement.setInt(8, emp.getDept().getDeptno());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Emp read(Integer integer) {
        String sqlQuery = "SELECT * FROM EMP WHERE EMPNO = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)) {
            preparedStatement.setInt(1, integer);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return new Emp(
                        resultSet.getInt("EMPNO"),
                        resultSet.getString("ENAME"),
                        resultSet.getString("JOB"),
                        resultSet.getInt("MGR"),
                        resultSet.getDate("HIREDATE").toLocalDate(),
                        resultSet.getInt("SAL"),
                        resultSet.getInt("COMM"),
                        deptDAO.read(resultSet.getInt("DEPTNO"))
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Emp> getAll() {
        String sqlQuery = "SELECT * FROM EMP";
        List<Emp> emps = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Emp emp = new Emp();
                emp.setEmpno(resultSet.getInt("EMPNO"));
                emp.setEname(resultSet.getString("ENAME"));
                emp.setJob(resultSet.getString("JOB"));
                emp.setMgr(resultSet.getInt("MGR"));
                emp.setHireDate(resultSet.getDate("HIREDATE").toLocalDate());
                emp.setSal(resultSet.getInt("SAL"));
                emp.setComm(resultSet.getInt("COMM"));
                emp.setDept(deptDAO.read(resultSet.getInt("DEPTNO")));
                emps.add(emp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return emps;
    }

    public List<Emp> getAllByName(String name) {
        String sqlQuery = "SELECT * FROM EMP WHERE ENAME = ?";
        List<Emp> emps = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)) {
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Emp emp = new Emp();
                emp.setEmpno(resultSet.getInt("EMPNO"));
                emp.setEname(resultSet.getString("ENAME"));
                emp.setJob(resultSet.getString("JOB"));
                emp.setMgr(resultSet.getInt("MGR"));
                emp.setHireDate(resultSet.getDate("HIREDATE").toLocalDate());
                emp.setSal(resultSet.getInt("SAL"));
                emp.setComm(resultSet.getInt("COMM"));
                emp.setDept(deptDAO.read(resultSet.getInt("DEPTNO")));
                emps.add(emp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return emps;
    }

    @Override
    public void update(Emp emp) {
        String sqlQuery = "UPDATE EMP SET ENAME = ?, JOB = ?, MGR = ?, HIREDATE = ?, SAL = ?, COMM = ?, DEPTNO = ? WHERE EMPNO = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)) {
            preparedStatement.setString(1, emp.getEname());
            preparedStatement.setString(2, emp.getJob());
            preparedStatement.setInt(3, emp.getMgr());
            preparedStatement.setObject(4, Date.valueOf(emp.getHireDate()));
            preparedStatement.setInt(5, emp.getSal());
            preparedStatement.setInt(6, emp.getComm());
            preparedStatement.setInt(7, emp.getDept().getDeptno());
            preparedStatement.setInt(8, emp.getEmpno());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Emp emp) {
        String sqlQuery = "DELETE FROM EMP WHERE EMPNO = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)) {
            preparedStatement.setInt(1, emp.getEmpno());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
