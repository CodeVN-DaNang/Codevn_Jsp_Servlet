package entity;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author vannhat
 */
public class Candidate {
    //CandidateId, FirstName, LastName, BirthDate, Address, Phone, Email andCandidatetype
    private int candidateId;
    private String candidateFirstName;
    private String candidateLastName;
    private String birthDate;
    private String address;
    private String phone;
    private String email;
    private CandidateType candidateType;

    public Candidate() {
    }

    public Candidate(int candidateId, String candidateFirstName, String candidateLastName, String birthDate, String address, String phone, String email, CandidateType candidateType) {
        this.candidateId = candidateId;
        this.candidateFirstName = candidateFirstName;
        this.candidateLastName = candidateLastName;
        this.birthDate = birthDate;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.candidateType = candidateType;
    }

    public int getCandidateId() {
        return candidateId;
    }

    public void setCandidateId(int candidateId) {
        this.candidateId = candidateId;
    }

    public String getCandidateFirstName() {
        return candidateFirstName;
    }

    public void setCandidateFirstName(String candidateFirstName) {
        this.candidateFirstName = candidateFirstName;
    }

    public String getCandidateLastName() {
        return candidateLastName;
    }

    public void setCandidateLastName(String candidateLastName) {
        this.candidateLastName = candidateLastName;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public CandidateType getCandidateType() {
        return candidateType;
    }

    public void setCandidateType(CandidateType candidateType) {
        this.candidateType = candidateType;
    }

    @Override
    public String toString() {
        return "Candidate{" + "candidateId=" + candidateId + ", candidateFirstName=" + candidateFirstName + ", candidateLastName=" + candidateLastName + ", birthDate=" + birthDate + ", address=" + address + ", phone=" + phone + ", email=" + email + ", candidateType=" + candidateType + '}';
    }
    
    
    
}
