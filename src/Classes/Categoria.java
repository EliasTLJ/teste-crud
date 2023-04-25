
package Classes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Interfaces.crud;



public class Categoria implements crud{
    String nome;
    int id; 

    public Categoria (){
        if(id>0){
            String sql ="SELECT * FROM categorias WHERE id = ?";

            try{
                Connection con = DB.conexao();
                PreparedStatement stmt = con.prepareStatement(sql);
                stmt.setInt(1, id);
                ResultSet registro = stmt.executeQuery();

                while(registro.next()){
                    this.setId(registro.getInt("id"));
                    this.setNome(registro.getString("nome"));
                }

            }catch(SQLException e){
                System.out.print("Erro na consulta de categoria" + e.toString());
            }
        }
    }
            
    
    public int get(){
        return id;
      }
    public void setId(int id){
        this.id = id;
    }
    
    public String getNome(){
        return nome;
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }
    
   public Categoria(int id,String nome){
        this.setId(id);
        this.setNome(nome);
    }


@Override
public void adicionar() {
    String sql = "INSERT INTO categorias(nome)VALUES(?)";

try{
    Connection con = DB.conexao();
    PreparedStatement stmt = con.prepareStatement(sql);

    stmt.setString(1,this.getNome());
    stmt.execute();
   }catch(SQLException e){
    System.out.print("Erro no adicionar categoria:"+e.toString());
   }
}


@Override
public void atualizar() {
    
    
}


@Override
public void deletar() {
    // TODO Auto-generated method stub
    
}


@Override
public ArrayList<Categoria> listar(){
    String sql = "SELECT * FROM categorias";
    ArrayList<Categoria> categorias = new ArrayList<>();

    try {
        Connection con = DB.conexao();
        PreparedStatement stmt = con.prepareStatement(sql);
        ResultSet registros = stmt.executeQuery();

        while(registros.next()){
            Categoria temp = new Categoria();
            temp.setId(registros.getInt("id"));
            temp.setNome(registros.getString("nome"));

            categorias.add(temp);
        }



    } catch (SQLException e) {
        System.out.println("Erro no Listar Categoria" + e.toString());
        
    }
    
    return categorias;

}

}
