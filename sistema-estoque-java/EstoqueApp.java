public class EstoqueApp {
    public static void main(String[] args) {
        Estoque estoque = new Estoque();

        System.out.println("=== 1. TENTANDO CADASTRAR PRODUTO COM QUANTIDADE NEGATIVA ===");
        try {
            ProdutoComum pInvalido = new ProdutoComum("Teclado", 100.0, -5);
            estoque.adicionarProduto(pInvalido);
        } catch (QuantidadeInvalidaException e) {
            System.out.println("EXCEÇÃO CAPTURADA COM SUCESSO: " + e.getMessage());
        } catch (EstoqueException e) {
            System.out.println("Exceção genérica de estoque: " + e.getMessage());
        }

        System.out.println("\n=== 2. CADASTRO DE PRODUTOS VÁLIDOS ===");
        try {
            ProdutoComum p1 = new ProdutoComum("Camiseta", 50.0, 10);
            ProdutoComum p2 = new ProdutoComum("Calça Jeans", 120.0, 5);
            ProdutoPerecivel p3 = new ProdutoPerecivel("Iogurte", 5.0, 20, 10);
            ProdutoPerecivel p4 = new ProdutoPerecivel("Leite", 4.0, 10, 2);

            estoque.adicionarProduto(p1);
            estoque.adicionarProduto(p2);
            estoque.adicionarProduto(p3);
            estoque.adicionarProduto(p4);

            System.out.println("Produtos cadastrados:");
            estoque.listarProdutos();

            System.out.printf("%nValor Total do Estoque: R$ %.2f%n", estoque.calcularValorTotalEstoque());

        } catch (QuantidadeInvalidaException e) {
            System.out.println("Erro ao cadastrar produto: " + e.getMessage());
        }

        System.out.println("\n=== 3. EXECUTANDO VENDA BEM-SUCEDIDA ===");
        try {
            System.out.println("Vendendo 3 unidades de Camiseta (Índice 0)...");
            estoque.venderProduto(0, 3);
            System.out.println("Venda efetuada com sucesso!");
        } catch (ProdutoIndisponivelException e) {
            System.out.println("Erro na venda: " + e.getMessage());
        }

        System.out.println("\n=== 4. TENTANDO VENDER MAIS DO QUE O DISPONÍVEL ===");
        try {
            System.out.println("Tentando vender 15 unidades de Camiseta (Estoque restante: 7)...");
            estoque.venderProduto(0, 15);
        } catch (ProdutoIndisponivelException e) {
            System.out.println("EXCEÇÃO CAPTURADA COM SUCESSO: " + e.getMessage());
        } catch (EstoqueException e) {
            System.out.println("Exceção genérica de estoque: " + e.getMessage());
        }

        System.out.println("\n=== 5. ESTADO FINAL DO ESTOQUE E VALOR TOTAL ===");
        estoque.listarProdutos();
        System.out.printf("Valor Total Final do Estoque: R$ %.2f%n", estoque.calcularValorTotalEstoque());
    }
}
