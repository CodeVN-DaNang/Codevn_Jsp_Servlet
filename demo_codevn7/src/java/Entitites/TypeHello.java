/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Entitites;

/**
 *
 * @author codevn
 */
public class TypeHello {
    private int typeHelloId;
    private String typeHelloName;

    public TypeHello(int typeHelloId, String typeHelloName) {
        this.typeHelloId = typeHelloId;
        this.typeHelloName = typeHelloName;
    }

    public TypeHello() {
    }

    public int getTypeHelloId() {
        return typeHelloId;
    }

    public void setTypeHelloId(int typeHelloId) {
        this.typeHelloId = typeHelloId;
    }

    public String getTypeHelloName() {
        return typeHelloName;
    }

    public void setTypeHelloName(String typeHelloName) {
        this.typeHelloName = typeHelloName;
    }

    @Override
    public String toString() {
        return "TypeHello{" + "typeHelloId=" + typeHelloId + ", typeHelloName=" + typeHelloName + '}';
    }
    
    
    
}
