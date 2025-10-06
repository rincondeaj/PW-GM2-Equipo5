package es.uco.pw.demo.model;

public class Skipper {
    private int skipperId;
    private String dni;
    private String name;
    private String birthDate;
    private String issueDate;
    private String title;

    // Getters
    public int getSkipperId() {
        return skipperId;
    }
    public String getDni() {
        return dni;
    }
    public String getName() {
        return name;
    }
    public String getBirthDate() {
        return birthDate;
    }
    public String getIssueDate() {
        return issueDate;
    }
    public String getTitle() {
        return title;
    }

    // Setters
    public void setSkipperId(int skipperId) {
        this.skipperId = skipperId;
    }
    public void setDni(String dni) {
        this.dni = dni;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }
    public void setIssueDate(String issueDate) {
        this.issueDate = issueDate;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    
}
