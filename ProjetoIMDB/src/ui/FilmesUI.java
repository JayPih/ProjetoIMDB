package ui;

import enums.CategoriaFilmes;
import model.Filmes;
import util.ConsoleUIHelper;

public class FilmesUI extends EditItemUI<Filmes> {
    public FilmesUI(String titulo, Filmes item, EditItemCallback<Filmes> editItemCallback) {
        super(titulo, item, editItemCallback);
    }

    @Override
    public int drawItemDetails() {
        ConsoleUIHelper.drawWithRightPadding("Categoria: " + item.getCategoriaFilmes().name(), colunas, ' ');
        ConsoleUIHelper.drawWithRightPadding("Nome: " + item.getNome(), colunas, ' ');
        ConsoleUIHelper.drawWithRightPadding("Sobrenome: " + item.getDescricao(), colunas, ' ');
        return 3;
    }

    @Override
    public String[] fillFieldsNames() {
        return new String[]{"Tipo","Nome","Sobrenome"};
    }

    @Override
    public void fillField(Filmes item, int option) {
        switch (option) {
            case 0:
                break;
            case 1:
                String nome = ConsoleUIHelper.askSimpleInput("Informe o nome do filme");
                item.setNome(nome);
                break;
            case 2:
                String lancamento = ConsoleUIHelper.askSimpleInput("Informe a data de lançamento");
                item.setDataLancamento(lancamento);
                break;
        }
    }

    @Override
    protected void newItem() {
        Filmes newFilme = new Filmes();
        newFilme.setCategoriaFilmes(CategoriaFilmes.ACAO);
        FilmesUI ui = new FilmesUI(titulo + " :: Novo", newFilme, editItemCallback);
        ui.show();
    }
}
