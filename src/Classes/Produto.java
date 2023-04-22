

package Classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Interfaces.crud;


public class Produto implements crud{
    int id;
    int categoria_id;
    String nome;
    double preco;
    int quantidade;

    public Produto (int id){
        if(id>0){
            String sql ="SELECT * FROM produtos WHERE id = ?";

            try{
                Connection con = DB.conexao();
                PreparedStatement stmt = con.prepareStatement(sql);
                stmt.setInt(1, id);//erros
                ResultSet registro = stmt.executeQuery();
                while(registro.next()){
                    this.setId(registro.getInt("id"));
                    this.setNome(registro.getString("nome"));
                    this.setPreco(registro.getDouble("preco"));
                    this.setQuantidade(registro.getInt("quantidade"));
                }

            }catch(SQLException e){
                System.out.print("Erro na consulta de produto" + e.toString());
            }
        }
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCategoria_id(int categoria_id) {
        this.categoria_id = categoria_id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public int getId() {
        return id;
    }

    public int getCategoria_id() {
        return categoria_id;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    @Override
    public void adicionar() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void atualizar() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void deletar() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void listar() {
        // TODO Auto-generated method stub
        
    }

    

  
    }

    
          
    
                                                         
