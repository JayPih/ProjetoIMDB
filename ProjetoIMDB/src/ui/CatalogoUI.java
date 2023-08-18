package ui;

import enums.CategoriaFilmes;
import enums.ClassificacaoIndicativa;
import model.Filmes;
import services.CatalogoService;

public class CatalogoUI extends PagedListUI<Filmes> {

    public CatalogoUI(PagedList<Filmes> pageSource) {
        super("Catálogo de Filmes - IMDB", pageSource);
    }

    @Override
    protected void showItem(Filmes item) {

        FilmesUI ui = new FilmesUI("", item, new EditItemCallback<Filmes>() {
            @Override
            public void remove(Filmes item) {

            }

            @Override
            public void add(Filmes item) {

            }

            @Override
            public boolean isNew(Filmes item) {
                return false;
            }
        });
        ui.show();
    }

    @Override
    protected void addItem() {
        Filmes newFilme = new Filmes();
        newFilme.setCategoriaFilmes(CategoriaFilmes.ACAO);
        newFilme.setClassificacaoIndicativa(ClassificacaoIndicativa.L);
        CatalogoService.getInstance().add(newFilme);
        showItem(newFilme);
    }
};