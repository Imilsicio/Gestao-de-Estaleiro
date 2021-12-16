/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Monteiro
 */
public class Usuario extends Pessoa {
    private String senha;

    public Usuario(String senha, int id, String nome, String sexo) {
        super(id, nome, sexo);
        this.senha = senha;
    }

    public Usuario(String senha, String nome) {
        super(nome);
        this.senha = senha;
    }

    public Usuario(String senha, String nome, String sexo) {
        super(nome, sexo);
        this.senha = senha;
    }

    public Usuario() {
    }
    

    

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
}
