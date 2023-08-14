import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import model.Filmes;
import model.Ator;

public class Main {
    public static void main(String[] args) {

        List<Filmes> catalogo = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Selecione uma opção:");
            System.out.println("1 - Cadastrar Filme");
            System.out.println("2 - Cadastrar Ator");
            System.out.println("3 - Cadastrar Diretor");
            System.out.println("4 - Associar Filme com Ator/Diretor");
            System.out.println("5 - Pesquisar Filme por Nome");
            System.out.println("6 - Sair");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    // Lógica para cadastrar filme
                    break;
                case 2:
                    // Lógica para cadastrar ator
                    break;
                case 3:
                    // Lógica para cadastrar diretor
                    break;
                case 4:
                    // Lógica para associar ator/diretor a um filme
                    break;
                case 5:
                    System.out.println("Digite o nome do filme para pesquisa:");
                    String nomePesquisa = scanner.nextLine();
                    pesquisarFilmePorNome(catalogo, nomePesquisa);
                    break;
                case 6:
                    System.out.println("Encerrando o programa...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    public static void pesquisarFilmePorNome(List<Filmes> catalogo, String nomePesquisa) {
        for (Filmes filme : catalogo) {
            if (filme.getNome().equalsIgnoreCase(nomePesquisa)) {
                System.out.println("Filme Encontrado:");
                System.out.println("Nome: " + filme.getNome());
                System.out.println("Data de Lançamento: " + filme.getDataLancamento());
                System.out.println("Orçamento: " + filme.getOrcamento());
                System.out.println("Descrição: " + filme.getDescricao());
                System.out.println("Diretor: " + filme.getDiretor().getNome());
                System.out.println("Atores: ");
                for (Ator ator : filme.getAtores()) {
                    System.out.println("- " + ator.getNome());
                }
                return;  // Sai da função depois de encontrar o filme
            }
        }
        System.out.println("Nenhum filme encontrado com o nome informado.");
    }
}
