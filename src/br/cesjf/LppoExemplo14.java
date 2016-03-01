package br.cesjf;

import static java.lang.Class.forName;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 *
 * @author Igor
 */
public class LppoExemplo14 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            //Cria lista de produtos
            List<Produto> produtos =  new ArrayList<>();
            
            //Carrega lista de produtos a partir do banco
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            String driverURL = "jdbc:derby://localhost:1527/lppo-2016-1";
            Connection conexao = DriverManager.getConnection(driverURL, "usuario", "senha");

            Statement operacao = conexao.createStatement();
            String sql = String.format(Locale.US, "SELECT nome, quantidade, preco FROM produto");
            System.out.println(sql);
            ResultSet resultado = operacao.executeQuery(sql);
            while(resultado.next()){
                Produto novoProduto = new Produto();
                produtos.add(novoProduto);
                novoProduto.setNome(resultado.getString("nome"));
                novoProduto.setQuantidade(resultado.getInt("quantidade"));
                novoProduto.setPreco(resultado.getFloat("preco"));
            }
            conexao.close();
            
            //Imprime lista de produtos
            
            System.out.println("[Produto]\t[Qtd.]\t[Preço]\t[Valor]");
            for (int i = 0; i < produtos.size(); i++) {
                Produto p = produtos.get(i);
                System.out.println(p);
            }
        } catch (ClassNotFoundException ex) {
            System.err.println("Driver do JavaDB não disponível!");
            System.exit(1);
        } catch (SQLException ex) {
            System.err.println("Erro ao executar operação no SGBD:\n" + ex);
        }

    }

}
