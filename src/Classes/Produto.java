

package Classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Interfaces.crud;



public class Produto implements crud{
    int id;
    int categoria_id;
    String nome;
    double preco;
    int quantidade;

    public Produto (){
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
        String sql = "INSERT INTO produtos(categoria_id,nome,preco,quantidade)VALUES(?,?,?,?)";

try{
    Connection con = DB.conexao();
    PreparedStatement stmt = con.prepareStatement(sql);


    stmt.setInt(1,this.getCategoria_id());
    stmt.setString(2,this.getNome());
    stmt.setDouble(3,this.getPreco());
    stmt.setInt(4,this.getQuantidade());
    stmt.execute();
   }catch(SQLException e){
    System.out.print("Erro no adicionar produtos:"+e.toString());
   }
        
    }

    @Override
    public void atualizar() {
        String sql = "UPDATE produtos SET categoria_id = ?, nome = ?, preco = ?, quantidade = ? WHERE id = ?";

        try {
            Connection con = DB.conexao();
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, this.getCategoria_id());
            stmt.setString(2, this.getNome());
            stmt.setDouble(3, this.getPreco());
            stmt.setInt(4, this.getQuantidade());
            stmt.setInt(5, this.getId());
            stmt.executeUpdate();
 
        } catch (SQLException e) {
            System.out.println("Erro no Atualizar Produto"+ e.toString());
           
        }
      
        
    }

    @Override
    public void deletar() {
       String sql =
        
    }

    @Override
    public ArrayList<Produto> listar(){
        String sql = "SELECT * FROM produtos";
        ArrayList<Produto> produtos = new ArrayList<>();
    
        try {
            Connection con = DB.conexao();
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet registros = stmt.executeQuery();
    
            while(registros.next()){
                Produto temp = new Produto();
                temp.setId(registros.getInt("id"));
                temp.setNome(registros.getString("nome"));
    
                produtos.add(temp);
            }
    
    
    
        } catch (SQLException e) {
            System.out.println("Erro no Listar Produto" + e.toString());
            
        }
        
        return produtos;
    
    }
    
    

  
    }

    
          
    
                                                         
