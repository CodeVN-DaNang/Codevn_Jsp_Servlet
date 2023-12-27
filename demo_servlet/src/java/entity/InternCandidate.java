/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author vannhat
 */
public class InternCandidate extends Candidate {
    private String major;
    private String semester;
    private String universityName;

    public InternCandidate() {
    }

    public InternCandidate(String major, String semester, String universityName, int candidateId, String candidateFirstName, String candidateLastName, String birthDate, String address, String phone, String email, CandidateType candidateType) {
        super(candidateId, candidateFirstName, candidateLastName, birthDate, address, phone, email, candidateType);
        this.major = major;
        this.semester = semester;
        this.universityName = universityName;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }

    @Override
    public String toString() {
        return "InternCandidate{" + "major=" + major + ", semester=" + semester + ", universityName=" + universityName + '}';
    }
    
    
    
}
