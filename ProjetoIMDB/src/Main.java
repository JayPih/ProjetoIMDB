import enums.CategoriaFilmes;
import enums.ClassificacaoIndicativa;
import model.Filmes;
import services.CatalogoService;
import ui.BasicUI;
import ui.CatalogoUI;

public class Main {
    public static void main(String[] args) {
        CatalogoService catalogoService = CatalogoService.getInstance();
        /*
        CatalogoFilmes catalogoFilmes = new CatalogoFilmes();
        for (int i = 0; i < 10; i++) {
            Filmes filmes = new Filmes();
            filmes.setNome("Filme " + i);
            catalogoFilmes.adicionarFilme(filmes);
            catalogoService.add(filmes);
        }
        catalogoService.exportar("catalogo.dat",true);
        */
        catalogoService.importar("catalogo.dat");

        BasicUI ui = new CatalogoUI(new CatalogoFilmes());
        ui.show();

        catalogoService.exportar("catalogo.dat", true);
    }
}
