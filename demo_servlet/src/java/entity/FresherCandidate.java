/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author vannhat
 */
public class FresherCandidate extends Candidate {
    private int graduationDate;
    private String graduationRank;
    private String education;

    public FresherCandidate() {
    }

    public FresherCandidate(int graduationDate, String graduationRank, String education, int candidateId, String candidateFirstName, String candidateLastName, String birthDate, String address, String phone, String email, CandidateType candidateType) {
        super(candidateId, candidateFirstName, candidateLastName, birthDate, address, phone, email, candidateType);
        this.graduationDate = graduationDate;
        this.graduationRank = graduationRank;
        this.education = education;
    }

    public int getGraduationDate() {
        return graduationDate;
    }

    public void setGraduationDate(int graduationDate) {
        this.graduationDate = graduationDate;
    }

    public String getGraduationRank() {
        return graduationRank;
    }

    public void setGraduationRank(String graduationRank) {
        this.graduationRank = graduationRank;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    @Override
    public String toString() {
        return "FresherCandidate{" + "graduationDate=" + graduationDate + ", graduationRank=" + graduationRank + ", education=" + education + '}';
    }
    
    
    
}
