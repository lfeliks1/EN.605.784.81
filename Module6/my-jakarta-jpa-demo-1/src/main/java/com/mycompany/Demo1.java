package com.mycompany;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import com.mycompany.model.Student;
import com.mycompany.model.Course;

public class Demo1
{
    public static void main( String[] args ) {
        EntityManagerFactory emf = null;
        EntityManager em = null;

        try {
            emf = Persistence.createEntityManagerFactory("default");
            em = emf.createEntityManager();
            Student student1 = new Student("Student_11");
            Student student2 = new Student("Student_22");
            Student student3 = new Student("Student_33");
            Course course1 = new Course("605.784 - Enterprise computing with Java", "Computer Science");
            Course course2 = new Course("685.652 - Data Engineering Principles and Practice", "Data Science");

            //Insert
            em.getTransaction().begin();
            em.persist(student1);
            em.persist(student2);
            em.persist(student3);

            em.persist(course1);
            em.persist(course2);

            //Find
            Student selectedStudent1 = em.find(Student.class, 1);
            System.out.println("\n              " + selectedStudent1);
            Student selectedStudent2 = em.find(Student.class, 2);
            System.out.println("\n              " + selectedStudent2);
            Student selectedStudent3 = em.find(Student.class, 3);
            System.out.println("\n              " + selectedStudent3);

            Course selectedCourse1 = em.find(Course.class, 100);
            System.out.println("\n              " + selectedCourse1);
            Course selectedCourse2 = em.find(Course.class, 101);
            System.out.println("\n              " + selectedCourse2);

            // JPQL Query
            Object num1 = em.createQuery(							
                "SELECT COUNT(c) FROM Course c").getSingleResult();
            System.out.println("\n              " +   "Number of rows in COURSE table is = " + num1.toString());
            
            //Delete
            em.remove(em.find(Course.class, 100));

            //Update
            Course selectedCourse4 = em.find(Course.class, 101);
            selectedCourse4.setName("625.664 - Computational Statistics");
            em.persist(selectedCourse4);
            em.getTransaction().commit();

            // Find
            Course selectedCourse5 = em.find(Course.class, 101);
            System.out.println("\n              " + selectedCourse5);

            // JPQL Query
            Object num2 = em.createQuery(							
                "SELECT COUNT(stud) FROM Student stud").getSingleResult();
            System.out.println("\n              " +   "Number of rows in STUDENT table is = " + num2.toString());
            num2 = em.createQuery(							
                "SELECT COUNT(c) FROM Course c").getSingleResult();
            System.out.println("\n              " +   "Number of rows in COURSE table is = " + num2.toString());

        } catch (Exception ex) {
            System.out.println("\n              Exception message = " + ex.getMessage());
        } finally {
            if (emf != null) {
                emf.close();
            }
            if (em != null) {
                em.close();
            }
        }
    }
}

