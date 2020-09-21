package controller;

import model.dao.EmpDAOImpl;
import model.entity.Emp;

import java.util.List;

public class EmpController implements Controller<Emp, Integer> {

    private EmpDAOImpl empDAO;

    public EmpController() {
        this.empDAO = new EmpDAOImpl();
    }

    @Override
    public void create(Emp emp) {
        empDAO.create(emp);
    }

    @Override
    public Emp read(Integer integer) {
        return empDAO.read(integer);
    }

    @Override
    public void update(Emp emp) {
        empDAO.update(emp);
    }

    @Override
    public void delete(Emp emp) {
        empDAO.delete(emp);
    }

    public List<Emp> getAll() {
        return empDAO.getAll();
    }

    public List<Emp> getAllByName(String name) {
        return empDAO.getAllByName(name);
    }


}
