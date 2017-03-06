/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.turmaa.agenda;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.management.RuntimeErrorException;
import javax.swing.JOptionPane;

/**
 *
 * @author DouglasOliveira
 */
public class pessoaDAO {

    Connectionfactory con = new Connectionfactory();
    Date data = new Date();
    SimpleDateFormat formatador = new SimpleDateFormat("yyyy/MM/dd HH:mm:SS");

    public void Cadastrar(pessoa pessoa) {
        con.Connection();
        try {

            PreparedStatement pst = con.con.prepareStatement("INSERT INTO pessoas"
                    + "(nome,telefone,dataNascimento,dataRegistro,Email)" + " VALUES(?,?,?,?,?)");

            pst.setString(1, pessoa.getNome());
            pst.setString(2, pessoa.getTelefone());
            pst.setString(3, pessoa.getData());
            pst.setString(4, formatador.format(data));
            pst.setString(5, pessoa.getEmail());
            pst.execute();

            JOptionPane.showMessageDialog(null, " Dados Salvos com Sucesso!");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, " Erro ao Salvar!\n " + ex);
        }
        con.closeConnection();
    }

    public List<pessoa> retornaTodas() throws SQLException {

        List<pessoa> clientes = new ArrayList<>();

        try {
            Connectionfactory con = new Connectionfactory();
            con.Connection();
            String sql = "select * from pessoas";
            PreparedStatement stmt = con.con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                pessoa Pessoa = new pessoa();
                Pessoa.setId(rs.getInt("id"));
                Pessoa.setNome(rs.getString("nome"));
                Pessoa.setData(rs.getString("DataNascimento"));
                Pessoa.setDataRegistro(rs.getString("DataRegistro"));
                Pessoa.setEmail(rs.getString("Email"));

                clientes.add(Pessoa);
            }
            rs.close();
            stmt.close();
        } catch (Error e) {
            throw new RuntimeErrorException(e);
        }
        return clientes;
    }

    public List<pessoa> retornadesc(String desc) throws SQLException {

        List<pessoa> clientes = new ArrayList<>();

        try {
            Connectionfactory con = new Connectionfactory();
            con.Connection();

            PreparedStatement stmt = con.con.prepareStatement("select * from pessoas Where nome LIKE ?");
            stmt.setString(1, "%" + desc + "%");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                pessoa Pessoa = new pessoa();
                Pessoa.setId(rs.getInt("id"));
                Pessoa.setNome(rs.getString("nome"));
                Pessoa.setData(rs.getString("DataNascimento"));
                Pessoa.setDataRegistro(rs.getString("DataRegistro"));
                Pessoa.setEmail(rs.getString("Email"));

                clientes.add(Pessoa);

            }
            rs.close();
            stmt.close();
        } catch (Error e) {
            throw new RuntimeErrorException(e);
        }
        return clientes;
    }

}
