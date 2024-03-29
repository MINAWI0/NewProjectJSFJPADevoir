package dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import model.Employe;
import model.EntityMangerSingleton;

import java.util.ArrayList;
import java.util.List;

public class EmployeDao {
    private EntityManager entity = EntityMangerSingleton.getEntityManagerFactory().createEntityManager();
    public void SaveEmploye(Employe employe) {
        entity.getTransaction().begin();
        entity.persist(employe);
        entity.getTransaction().commit();
    }
    public void editStudent(Employe employe) {
        entity.getTransaction().begin();
        entity.merge(employe);
        entity.getTransaction().commit();
    }
    public Employe searchStudent(Long id) {
        Employe st = new Employe();
        st = entity.find(Employe.class, id);
        return st;
    }
    public void deleteStudent(Long id) {
        Employe st = new Employe();
        st = entity.find(Employe.class, id);
        entity.getTransaction().begin();
        entity.remove(st);
        entity.getTransaction().commit();
    }
    public List<Employe> getEmployeList() {
        List<Employe> listEmployes = new ArrayList<>();
        Query q = entity.createQuery("SELECT st FROM Employe st");
        listEmployes = q.getResultList();
        return listEmployes;
    }

}
