/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.turmaa.agenda;

import java.text.SimpleDateFormat;

/**
 *
 * @author DouglasOliveira
 */
public class pessoa {

    private String Nome;
    private SimpleDateFormat DataNascimento;
    private String Telefone;
    private String Email;

    public String setNome(String novoNome) {
        return this.Nome = novoNome;

    }

    public String getNome() {
        return this.Nome;

    }

    public SimpleDateFormat setData(SimpleDateFormat novoDataNascimento) {
        return this.DataNascimento = novoDataNascimento;

    }

    public SimpleDateFormat getData() {
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
