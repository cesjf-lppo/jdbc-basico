/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cesjf;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Locale;
import java.util.Random;

/**
 *
 * @author Igor
 */
public class LppoExemplo8 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            String driverURL = "jdbc:derby://localhost:1527/lppo-2016-1";
            Connection conexao = DriverManager.getConnection(driverURL, "usuario", "senha");

            Statement operacao = conexao.createStatement();
            Random rnd = new Random();
            for (int i = 0; i < 10; i++) {
                String nome = "Produto " + (rnd.nextInt(100) + 1);
                Integer quantidade = (rnd.nextInt(20) + 1);
                Float preco = (rnd.nextFloat() * 100 + 1);
                String sql = String.format(Locale.US, "INSERT INTO produto(nome, quantidade, preco, atualizado) VALUES('%s', %d , %f, CURRENT_TIMESTAMP)", nome, quantidade, preco);
                System.out.println(sql);
                operacao.executeUpdate(sql);
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
