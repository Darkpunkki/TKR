package entity;
import jakarta.persistence.*;

@Entity
public class TimeSpent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int homeworkHours;
    private int inClassHours;
    private int theoryHours;
    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    public TimeSpent() {
    }

    public TimeSpent(int homeworkHours, int inClassHours, int theoryHours, Student student) {
        this.homeworkHours = homeworkHours;
        this.inClassHours = inClassHours;
        this.theoryHours = theoryHours;
        this.student = student;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getHomeworkHours() {
        return homeworkHours;
    }

    public void setHomeworkHours(int homeworkHours) {
        this.homeworkHours = homeworkHours;
    }

    public int getInClassHours() {
        return inClassHours;
    }

    public void setInClassHours(int inClassHours) {
        this.inClassHours = inClassHours;
    }

    public int getTheoryHours() {
        return theoryHours;
    }

    public void setTheoryHours(int theoryHours) {
        this.theoryHours = theoryHours;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "TimeSpent{" +
                "id=" + id +
                ", homeworkHours=" + homeworkHours +
                ", inClassHours=" + inClassHours +
                ", theoryHours=" + theoryHours +
                '}';
    }

}
