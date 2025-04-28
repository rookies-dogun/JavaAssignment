package workshop.student.entity;



public class Student {
    private String studentId;
    private String name;
    private String major;
    private int grade;

    public Student(String studentId, String name, String major, int grade) {
        this.studentId = studentId;
        this.name = name;
        this.major = major;
        this.grade = grade;


    }

    public String getStudentId() {
        return studentId;
    }
    public String getName() {
        return name;
    }
    public String getMajor() {
        return major;
    }
    public int getGrade() {
        return grade;
    }
    public void setGrade(int grade) {
        if(grade < 0 || grade > 4){
            System.out.println("학년은 1~4학년 사이여야 합니다");
        }else{
            this.grade = grade;    
        }
        
    }


}