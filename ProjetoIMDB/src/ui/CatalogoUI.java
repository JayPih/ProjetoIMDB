package ui;

import model.Filmes;

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

    }

    @Override
    protected void addItem() {

    }
};