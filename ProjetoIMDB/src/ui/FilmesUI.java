package ui;

import enums.CategoriaFilmes;
import model.Filmes;
import util.ConsoleUIHelper;

import java.math.BigDecimal;

public class FilmesUI extends EditItemUI<Filmes> {
    public FilmesUI(String titulo, Filmes item, EditItemCallback<Filmes> editItemCallback) {
        super(titulo, item, editItemCallback);
    }

    @Override
    public int drawItemDetails() {
        ConsoleUIHelper.drawWithRightPadding("Categoria: " + item.getCategoriaFilmes().name(), colunas, ' ');
        ConsoleUIHelper.drawWithRightPadding("Nome: " + item.getNome(), colunas, ' ');
        ConsoleUIHelper.drawWithRightPadding("Descrição: " + item.getDescricao(), colunas, ' ');
        ConsoleUIHelper.drawWithRightPadding("Data de Lançamento: " + item.getDataLancamento(), colunas, ' ');
        ConsoleUIHelper.drawWithRightPadding("Orçamento: " + item.getOrcamento(), colunas, ' ');
        ConsoleUIHelper.drawWithRightPadding("Filme com oscar: " + item.getIsOscar(), colunas, ' ');
        return 6;
    }

    @Override
    public String[] fillFieldsNames() {
        return new String[]{"Tipo","Nome","Descrição", "Data de Lançamento", "Orçamento", "Filme com oscar"};
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
                String descricao = ConsoleUIHelper.askSimpleInput("Informe a descrição");
                item.setDescricao(descricao);

                break;
            case 3:
                String lancamento = ConsoleUIHelper.askSimpleInput("Informe a data de lançamento");
                item.setDataLancamento(lancamento);
                break;
            case 4:
                BigDecimal orcamento = BigDecimal.valueOf(Double.parseDouble(ConsoleUIHelper.askSimpleInput("Informe o orçamento")));
                item.setOrcamento(orcamento);
                break;
            case 5:
                boolean oscar = Boolean.parseBoolean(ConsoleUIHelper.askSimpleInput("O filmes tem Oscar? true/false"));
                item.setIsOscar(oscar);
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
