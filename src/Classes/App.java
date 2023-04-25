package Classes;


public class App {
    public static void main(String[] args){ 
        Produto produto = new Produto(1);

        System.out.println(produto.getNome());

        Categoria categoria= new Categoria(1);

        System.out.println(categoria.getNome());


        //cadastrar categoria
        Categoria categoria = new Categoria(0);
        categoria.setNome("Nova Categoria");
        categoria.adicionar();

        //cadastrarr produto 
        Produto produto = new Produto(0);
        produto.setNome("Novo Produto");
        produto.setCategoria_id(2);
        produto.adicionar();

        
    }
}
