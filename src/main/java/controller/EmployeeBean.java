package controller;


import dao.EmployeDao;
import jakarta.annotation.ManagedBean;
import jakarta.faces.bean.SessionScoped;
import jakarta.faces.context.FacesContext;
import model.Employe;

import java.util.List;
import java.util.Map;

@ManagedBean
@SessionScoped
public class EmployeeBean {

    public String addEmploye() {
        Employe st= new Employe();
        Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
        sessionMap.put("Employe", st);
        return  "/affecation.xhtml";
    }
    public String saveEmployee(Employe employe) {
        EmployeDao employeDao = new EmployeDao();
        employeDao.SaveEmploye(employe);
        System.out.println(employe);
        return  "/EmployeList.xhtml";
    }
    public List<Employe> EmployeList() {
        EmployeDao employeDao = new EmployeDao();
        return employeDao.getEmployeList();
    }
    public String deletEmplye(Long id) {
        EmployeDao employeDao = new EmployeDao();
        employeDao.deleteStudent(id);
        System.out.println("employe elimineee");
        return "EmployeList.xhtml";
    }

}
