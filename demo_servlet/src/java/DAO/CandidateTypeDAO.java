/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import database.BaseConnection;
import entity.CandidateType;
import java.sql.Connection;
import java.util.ArrayList;
import java.sql.*;

/**
 *
 * @author vannhat
 */
public class CandidateTypeDAO {

    ArrayList<CandidateType> candidateTypes = new ArrayList<>();
    Connection con = BaseConnection.getConnection();

    public ArrayList<CandidateType> getAllCandidateTypes() {
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from candidatetype");
            while (rs.next()) {
                int id = rs.getInt("cTypeId");
                String name = rs.getString("cTypeName");
                CandidateType ctype = new CandidateType(id, name);
                candidateTypes.add(ctype);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return candidateTypes;
    }

    public CandidateType getCandidateTypeById(int typeId) {
        try {
            PreparedStatement st = con.prepareStatement("select * from candidatetype where cTypeId = ?");
            st.setInt(1, typeId);
            ResultSet rs = st.executeQuery();
            rs.next();
            int id = rs.getInt("cTypeId");
            String name = rs.getString("cTypeName");
            return new CandidateType(id, name);
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

}
