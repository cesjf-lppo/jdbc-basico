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

/**
 *
 * @author Igor
 */
public class LppoExemplo10 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            String driverURL = "jdbc:derby://localhost:1527/lppo-2016-1";
            Connection conexao = DriverManager.getConnection(driverURL, "usuario", "senha");

            Statement operacao = conexao.createStatement();
            String sql = String.format(Locale.US, "UPDATE produto SET quantidade=quantidade-1 WHERE quantidade>=1");
            System.out.println(sql);
            int n = operacao.executeUpdate(sql);
            System.out.println(n+" registros afetados!");

            conexao.close();
        } catch (ClassNotFoundException ex) {
            System.err.println("Driver do JavaDB não disponível!");
            System.exit(1);
        } catch (SQLException ex) {
            System.err.println("Erro ao executar operação no SGBD:\n" + ex);
        }

    }

}
