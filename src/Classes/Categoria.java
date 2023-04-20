
package Classes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Interfaces.crud;



public class Categoria implements crud{
    String nome;
    int id; 

    public Categoria (int id){
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
