/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.turmaa.agenda;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author DouglasOliveira
 */
public class pessoaDAO {

    Connectionfactory con = new Connectionfactory();

    public void Cadastrar(pessoa pessoa) {
        con.Connection();
        try {

            PreparedStatement pst = con.con.prepareStatement("INSERT INTO pessoas"
                    + "(nome,telefone,dataNascimento,dataRegistro,Email)" + " VALUES(?,?,?,?,?)");
            
            String data = (new java.text.SimpleDateFormat("dd/MM/yyyy").format(new java.util.Date(System.currentTimeMillis())));
            pst.setString(1, pessoa.getNome());
            pst.setString(2, pessoa.getTelefone());
            pst.setString(3, pessoa.getData());
            pst.setString(4, data);
            pst.setString(5, pessoa.getEmail());
            pst.execute();

            JOptionPane.showMessageDialog(null, " Dados Salvos com Sucesso!");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, " Erro ao Salvar!\n " + ex);
        }
        con.closeConnection();
    }

}
