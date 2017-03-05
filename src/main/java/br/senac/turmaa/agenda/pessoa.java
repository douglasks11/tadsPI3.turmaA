/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.turmaa.agenda;



/**
 *
 * @author DouglasOliveira
 */
public class pessoa {

    private String Nome;
    private String DataNascimento;
    private String Telefone;
    private String Email;

    public String setNome(String novoNome) {
        return this.Nome = novoNome;

    }

    public String getNome() {
        return this.Nome;

    }

    public String setData(String novoDataNascimento) {
        return this.DataNascimento = novoDataNascimento;

    }

    public String getData() {
        return this.DataNascimento;

    }

    public String setTelefone(String novoTelefone) {
        return this.Telefone = novoTelefone;

    }

    public String getTelefone() {
        return this.Telefone;

    }

    public String setEmail(String novoEmail) {
        return this.Email = novoEmail;

    }

    public String getEmail() {
        return this.Email;

    }

}
