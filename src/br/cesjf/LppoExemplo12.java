/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cesjf;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Locale;

/**
 *
 * @author Igor
 */
public class LppoExemplo12 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            String driverURL = "jdbc:derby://localhost:1527/lppo-2016-1";
            Connection conexao = DriverManager.getConnection(driverURL, "usuario", "senha");

            Statement operacao = conexao.createStatement();
            String sql = String.format(Locale.US, "SELECT nome AS etiqueta, quantidade, preco, quantidade*preco AS valor FROM produto WHERE quantidade>0");
            System.out.println(sql);
            ResultSet resultado = operacao.executeQuery(sql);
            System.out.println("[Produto]\t[Qtd.]\t[Preço]\t[Valor]");
            while(resultado.next()){
        System.out.println(
                resultado.getString("etiqueta")
                +"\t"
                + resultado.getInt("quantidade")
                +"\t"
                + String.format("R$%6.2f", resultado.getFloat("preco"))
                +"\t"
                + String.format("R$%8.2f", resultado.getFloat("valor"))
        );
            }

            conexao.close();
        } catch (ClassNotFoundException ex) {
            System.err.println("Driver do JavaDB não disponível!");
            System.exit(1);
        } catch (SQLException ex) {
            System.err.println("Erro ao executar operação no SGBD:\n" + ex);
        }

    }

}
