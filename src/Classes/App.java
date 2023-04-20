package Classes;


public class App {
    public static void main(String[] args){ 
        Produto produto = new Produto(2);

        System.out.print(produto.getNome());

        Categoria categoria= new Categoria(2);

        System.out.print(categoria.getNome());

        //ola
    }
}
