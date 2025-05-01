package mylab.customer.vo;


import java.time.LocalDate;

public class CustomerVO {

    private Long id;
    private String email;
    private String name;
    private LocalDate entryDate;
    private int age;


    public CustomerVO(String email, String name, LocalDate entryDate, int age) {

        this.email = email;
        this.name = name;
        this.entryDate = entryDate;
        this.age = age;
    }
    public CustomerVO() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(LocalDate entryDate) {
        this.entryDate = entryDate;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "CustomerVO{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", entryDate=" + entryDate +
                ", age=" + age +
                '}';
    }
}
