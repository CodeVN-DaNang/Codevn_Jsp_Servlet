/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author vannhat
 */
public class CandidateType {
    private int typeId;
    private String typeName;

    public CandidateType(int typeId, String typeName) {
        this.typeId = typeId;
        this.typeName = typeName;
    }

    public CandidateType() {
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    @Override
    public String toString() {
        return "CandidateType{" + "typeId=" + typeId + ", typeName=" + typeName + '}';
    }
    
    
}
