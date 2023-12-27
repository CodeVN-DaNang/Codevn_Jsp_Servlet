/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import database.BaseConnection;
import entity.Candidate;
import entity.CandidateType;
import entity.ExperienceCandidate;
import entity.FresherCandidate;
import entity.InternCandidate;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.*;

/**
 *
 * @author vannhat
 */
public class CandidateDAO {

    ArrayList<Candidate> candidates = new ArrayList<>();
    Connection con = BaseConnection.getConnection();
    CandidateTypeDAO ctDAO = new CandidateTypeDAO();

    public ArrayList<Candidate> getAllCandidates() {
        candidates.clear();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from candidate");
            while (rs.next()) {
                int id = rs.getInt("cId");
                String firstName = rs.getString("cFName");
                String lastName = rs.getString("cLName");
                String birthDate = rs.getString("cBirthDate");
                String address = rs.getString("cAddress");
                String phone = rs.getString("cPhone");
                String email = rs.getString("cEmail");
                int typeId = rs.getInt("cTypeId");
                CandidateType type = ctDAO.getCandidateTypeById(typeId);
                Candidate candidate = null;
                if (typeId == 1) {
                    candidate = getExperienceCandidate(new Candidate(id, firstName, lastName, birthDate, address, phone, email, type));
                } else if (typeId == 2) {
                    candidate = getFresherCandidate(new Candidate(id, firstName, lastName, birthDate, address, phone, email, type));
                } else if (typeId == 3) {
                    candidate = getInternCandidate(new Candidate(id, firstName, lastName, birthDate, address, phone, email, type));
                }
                if (candidate != null) {
                    candidates.add(candidate);
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return candidates;

    }

    public Candidate getCandidateById(int id) {
        try {
            PreparedStatement pt = con.prepareStatement("select * from candidate where cId = ?");
            pt.setInt(1, id);
            ResultSet rs = pt.executeQuery();
            while (rs.next()) {
                id = rs.getInt("cId");
                String firstName = rs.getString("cFName");
                String lastName = rs.getString("cLName");
                String birthDate = rs.getString("cBirthDate");
                String address = rs.getString("cAddress");
                String phone = rs.getString("cPhone");
                String email = rs.getString("cEmail");
                int typeId = rs.getInt("cTypeId");
                CandidateType type = ctDAO.getCandidateTypeById(typeId);
                Candidate candidate = null;
                if (typeId == 1) {
                    candidate = getExperienceCandidate(new Candidate(id, firstName, lastName, birthDate, address, phone, email, type));
                } else if (typeId == 2) {
                    candidate = getInternCandidate(new Candidate(id, firstName, lastName, birthDate, address, phone, email, type));
                } else if (typeId == 3) {
                    candidate = getFresherCandidate(new Candidate(id, firstName, lastName, birthDate, address, phone, email, type));
                }
                return candidate;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;

    }

    public Candidate getExperienceCandidate(Candidate candidate) {
        try {
            PreparedStatement st = con.prepareStatement("select * from experiencecandidate where cId = ?");
            st.setInt(1, candidate.getCandidateId());
            ResultSet rs = st.executeQuery();
            rs.next();
            int expInYear = rs.getInt("expInYear");
            String proSkill = rs.getString("proSkill");
            return new ExperienceCandidate(expInYear, proSkill, candidate.getCandidateId(), candidate.getCandidateFirstName(), candidate.getCandidateLastName(), candidate.getBirthDate(), candidate.getAddress(), candidate.getPhone(), candidate.getEmail(), candidate.getCandidateType());
        } catch (Exception e) {
            System.out.println(e);

        }
        return null;
    }
    
    public Candidate getFresherCandidate(Candidate candidate) {
        try {
            PreparedStatement st = con.prepareStatement("select * from freshercandidate where cId = ?");
            st.setInt(1, candidate.getCandidateId());
            ResultSet rs = st.executeQuery();
            rs.next();
            int graduationDate = rs.getInt("graduationdate");
            String graduationRank = rs.getString("graduationrank");
            String education = rs.getString("education");
            return new FresherCandidate(graduationDate, graduationRank, education, candidate.getCandidateId(), candidate.getCandidateFirstName(), candidate.getCandidateLastName(), candidate.getBirthDate(), candidate.getAddress(), candidate.getPhone(), candidate.getEmail(), candidate.getCandidateType());
        } catch (Exception e) {
            System.out.println(e);

        }
        return null;
    }
    
    public Candidate getInternCandidate(Candidate candidate) {
        try {
            PreparedStatement st = con.prepareStatement("select * from interncandidate where cId = ?");
            st.setInt(1, candidate.getCandidateId());
            ResultSet rs = st.executeQuery();
            rs.next();
            String major = rs.getString("major");
            String semester = rs.getString("semester");
            String university = rs.getString("universityName");
            return new InternCandidate(major, semester, university, candidate.getCandidateId(), candidate.getCandidateFirstName(), candidate.getCandidateLastName(), candidate.getBirthDate(), candidate.getAddress(), candidate.getPhone(), candidate.getEmail(), candidate.getCandidateType());
        } catch (Exception e) {
            System.out.println(e);

        }
        return null;
    }
    
}
