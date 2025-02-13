import dao.StudentDAO;
import entity.Student;
import entity.TimeSpent;

import java.util.ArrayList;
import java.util.List;

public class main {
    public static void main(String[] args) {
        StudentDAO studentDAO = new StudentDAO();

        // Create a new student
        Student student = new Student();
        student.setName("Jimi");
        student.setEmail("Jimbo@gmail.com");
        studentDAO.createStudent(student);
        System.out.println("Created student: " + student);

        // Create some TimeSpent entries for this student
        TimeSpent homeworkSession = new TimeSpent(3, 0, 0, student);
        TimeSpent inClassSession = new TimeSpent(0, 4, 0, student);
        TimeSpent theorySession = new TimeSpent(0, 0, 2, student);

        // Associate these time entries with the student
        List<TimeSpent> timeEntries = new ArrayList<>();
        timeEntries.add(homeworkSession);
        timeEntries.add(inClassSession);
        timeEntries.add(theorySession);
        student.setTimeSpent(timeEntries);

        // Update the student so that the timeSpent list is saved.
        studentDAO.updateStudent(student);

        // Retrieve the student from the database and print the time spent details.
        Student retrievedStudent = studentDAO.findStudentById(student.getId());
        System.out.println("Retrieved student: " + retrievedStudent);
        System.out.println("Time Spent details: ");
        if (retrievedStudent.getTimeSpent() != null) {
            for (TimeSpent ts : retrievedStudent.getTimeSpent()) {
                System.out.println(ts);
            }
        } else {
            System.out.println("No time spent entries found.");
        }
    }
}
