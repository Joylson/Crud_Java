/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author Joylson
 */
public class Usuario {
    private int Id;
    private String nome;
    private String Senha;
    private String Email;

    public Usuario(int Id, String nome, String Senha, String Email) {
        this.Id = Id;
        this.nome = nome;
        this.Senha = Senha;
        this.Email = Email;
    }

    public Usuario() {
    }

    
    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return Senha;
    }

    public void setSenha(String Senha) {
        this.Senha = Senha;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }
    
}
