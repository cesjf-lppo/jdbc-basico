package br.cesjf;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class LppoExemplo15 {
    public static void main(String[] args) {
        //Cria objeto na memória
        Produto novoProduto = new Produto();
        novoProduto.setNome("Celular");
        novoProduto.setPreco(900.0f);
        novoProduto.setQuantidade(3);
        
        //Envia objeto para o banco de dados
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            String driverURL = "jdbc:derby://localhost:1527/lppo-2016-1";
            Connection conexao = DriverManager.getConnection(driverURL, "usuario", "senha");

            Statement operacao = conexao.createStatement();
            
            String sql = "INSERT INTO produto(nome, quantidade, preco, atualizado) VALUES('"
                    + novoProduto.getNome() + "', "
                    + novoProduto.getQuantidade() + ","
                    + novoProduto.getPreco() + ", CURRENT_TIMESTAMP)";
            operacao.executeUpdate(sql);

            conexao.close();
        } catch (ClassNotFoundException ex) {
            System.err.println("Driver do JavaDB não disponível!");
            System.exit(1);
        } catch (SQLException ex) {
            System.err.println("Erro ao executar operação no SGBD:\n" + ex);
        }

    }
    
}
