import dao.StudentDAO;
import entity.Student;

public class main {

    public static void main(String[] args) {
        StudentDAO studentDAO = new StudentDAO();
        Student s = studentDAO.findStudentById(1L);

        System.out.println(s);
        System.out.println(s.getTimeSpent());

        // Create a new student
        System.out.println("Creating a new student");
        Student newStudent = new Student();
        newStudent.setName("John Doe");
        newStudent.setEmail("john@doe.com");
        studentDAO.createStudent(newStudent);
        Student john = studentDAO.findStudentByName("John Doe");
        revertDb(studentDAO, s, john);
        System.out.println("retrieved the new student from database :");
        System.out.println(john);

        // Update the student
        System.out.println("Updating the student name. original name : " + s.getName());
        s.setName("Jane Doe");
        studentDAO.updateStudent(s);
        System.out.println("Updated student name : " + s.getName());


    }

    public static void revertDb(StudentDAO studentDAO, Student s, Student john) {
        studentDAO.deleteStudent(john);
        s.setName("asd");
        studentDAO.updateStudent(s);
    }
}
