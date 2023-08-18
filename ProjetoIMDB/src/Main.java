import enums.CategoriaFilmes;
import enums.ClassificacaoIndicativa;
import model.Filmes;
import services.CatalogoService;
import ui.BasicUI;
import ui.CatalogoUI;

public class Main {
    public static void main(String[] args) {
        CatalogoService catalogoService = CatalogoService.getInstance();

        catalogoService.importar("catalogo.dat");

        BasicUI ui = new CatalogoUI(new CatalogoFilmes());
        ui.show();

        catalogoService.exportar("catalogo.dat", true);
    }
}
