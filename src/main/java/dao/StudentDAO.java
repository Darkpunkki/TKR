package dao;

import entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class StudentDAO {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("e");

    public Student findStudentById(Long id) {
        EntityManager em = emf.createEntityManager();
        Student s = em.find(Student.class, id);
        em.close();
        return s;
    }
    public Student findStudentByName(String name) {
        EntityManager em = emf.createEntityManager();
        Student s = em.createQuery("SELECT s FROM Student s WHERE s.name = :name", Student.class)
                .setParameter("name", name)
                .getSingleResult();
        em.close();
        return s;
    }
    public void createStudent(Student s) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(s);
        em.getTransaction().commit();
        em.close();
    }
    public void updateStudent(Student s) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(s);
        em.getTransaction().commit();
        em.close();
    }

    public void deleteStudent(Student s) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Student student = em.find(Student.class, s.getId());
        if (student != null) {
            em.remove(student);
        }
        em.getTransaction().commit();
        em.close();
    }
}

