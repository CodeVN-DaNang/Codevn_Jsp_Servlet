/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author vannhat
 */
public class ExperienceCandidate extends Candidate {
    private int expInYear;
    private String proSkill;

    public ExperienceCandidate() {
    }

    public ExperienceCandidate(int expInYear, String proSkill, int candidateId, String candidateFirstName, String candidateLastName, String birthDate, String address, String phone, String email, CandidateType candidateType) {
        super(candidateId, candidateFirstName, candidateLastName, birthDate, address, phone, email, candidateType);
        this.expInYear = expInYear;
        this.proSkill = proSkill;
    }

    public int getExpInYear() {
        return expInYear;
    }

    public void setExpInYear(int expInYear) {
        this.expInYear = expInYear;
    }

    public String getProSkill() {
        return proSkill;
    }

    public void setProSkill(String proSkill) {
        this.proSkill = proSkill;
    }

    @Override
    public String toString() {
        return "ExperienceCandidate{" + "expInYear=" + expInYear + ", proSkill=" + proSkill + '}';
    }
    
    
    
}
