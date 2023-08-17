import model.Filmes;
import ui.BasicUI;
import ui.CatalogoUI;

public class Main {
    public static void main(String[] args) {
        CatalogoFilmes catalogoFilmes = new CatalogoFilmes();
        for (int i = 0; i < 10; i++) {
            Filmes filmes = new Filmes();
            filmes.setNome("Filme ");
            catalogoFilmes.adicionarFilme(filmes);
        }

        BasicUI ui = new CatalogoUI(catalogoFilmes);
        ui.show();
    }
}
