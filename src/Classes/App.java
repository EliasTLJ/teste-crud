package Classes;


public class App {
    public static void main(String[] args){ 
        Produto produto = new Produto(1);

        System.out.println(produto.getNome());

        Categoria categoria= new Categoria(1);

        System.out.println(categoria.getNome());

    }
}
