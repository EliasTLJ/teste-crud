import Classes.Produto;

public class App {
    public static void main(String[] args){ 
  /*       Produto produto = new Produto(1);

        System.out.println(produto.getNome());

        Categoria categoria= new Categoria(1);

        System.out.println(categoria.getNome()); */


        /*//cadastrar categoria
        Categoria Categoria = new Categoria(0);
        categoria.setNome("Nova Categoria");
        categoria.adicionar();

        //cadastrar produto 
        Produto Produto = new Produto(0);
        produto.setNome("Novo Produto");
        produto.setCategoria_id(2);
        produto.adicionar();*/

        Produto produto = new Produto();
        produto.setNome("Batatao");
        produto.setPreco(9.99);
        produto.setQuantidade(122);
        produto.atualizar();

        System.out.println(produto.getNome());

        

        

        
    }
}
