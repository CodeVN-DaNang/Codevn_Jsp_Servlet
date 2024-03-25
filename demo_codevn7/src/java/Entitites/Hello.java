/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Entitites;

/**
 *
 * @author codevn
 */
public class Hello {
    private String id;
    private String name;
    private TypeHello typeHello;

    public Hello(String id, String name, TypeHello typeHello) {
        this.id = id;
        this.name = name;
        this.typeHello = typeHello;
    }

    public Hello() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TypeHello getTypeHello() {
        return typeHello;
    }

    public void setTypeHello(TypeHello typeHello) {
        this.typeHello = typeHello;
    }

    @Override
    public String toString() {
        return "Hello{" + "id=" + id + ", name=" + name + ", typeHello=" + typeHello + '}';
    }

    
    
    
    
}
