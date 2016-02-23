/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cesjf;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Igor
 */
public class LppoExemplo1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            String driverURL = "jdbc:derby://localhost:1527/lppo-2016-1";
            Connection conexao = DriverManager.getConnection(driverURL, "usuario", "senha");
            if(conexao.isValid(300)){
                System.out.println("A conexão foi bem sucedida!");
                DatabaseMetaData meta = conexao.getMetaData();
                System.out.println(meta.getDatabaseProductName());
                System.out.println(meta.getDatabaseProductVersion());
                System.out.println(meta.getURL());
                System.out.println(meta.getUserName());
            }
            System.out.println("Hello world");
            conexao.close();
        } catch (ClassNotFoundException ex) {
            System.err.println("Driver do JavaDB não disponível!");
            System.exit(1);
        } catch (SQLException ex) {
            System.err.println("Erro ao conectar com o SGBD!\n" + ex);
        }

    }

}
