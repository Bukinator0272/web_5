package controller;


import model.dao.DeptDAOImpl;
import model.entity.Dept;

public class DeptController implements Controller<Dept, Integer> {

    private DeptDAOImpl deptDAO;

    public DeptController() {
        this.deptDAO = new DeptDAOImpl();
    }

    @Override
    public void create(Dept dept) {
        deptDAO.create(dept);
    }

    @Override
    public Dept read(Integer integer) {
        return deptDAO.read(integer);
    }

    @Override
    public void update(Dept dept) {
        deptDAO.update(dept);
    }

    @Override
    public void delete(Dept dept) {
        deptDAO.delete(dept);
    }

}
