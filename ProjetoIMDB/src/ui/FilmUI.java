package ui;

import model.Filmes;
import util.ConsoleUIHelper;

public class FilmUI extends BasicUI {
    private final Filmes film;
    private final EditItemCallback<Filmes> editItemCallback;

    public FilmUI(String pageTitle, Filmes film, EditItemCallback<Filmes> editItemCallback){
        super(pageTitle);
        this.film = film;
        this.editItemCallback = editItemCallback;
    }

    @Override
    public int drawContent() {
        ConsoleUIHelper.drawWithRightPadding("Título: " + film.getNome(), columns, ' ');
        ConsoleUIHelper.drawWithRightPadding("Descrição: " + film.getDescricao(), columns, ' ');
        ConsoleUIHelper.drawWithRightPadding("Lançamento: " + film.getDataLancamento(), columns, ' ');
        ConsoleUIHelper.drawWithRightPadding("Orçamento: " + film.getOrcamento(), columns, ' ');
        ConsoleUIHelper.drawWithRightPadding("Categorias: " + film.getCategorias(), columns, ' ');
        ConsoleUIHelper.drawWithRightPadding("Diretor: " + film.getDiretor(), columns, ' ');
        ConsoleUIHelper.drawWithRightPadding("Atores: " + film.getAtores(), columns, ' ');
        return 7;
    }

    @Override
    public int menuLines() {
        return 0;
    }

    @Override
    public boolean drawMenu() {
        String[] options;
        if(editItemCallback.isNew(film)){
            options = new String[]{"Salvar e sair","Alterar Título","Alterar Descrição","Alterar Data de Lançamento","Alterar Orçamento","Alterar Categorias","Alterar Diretor","Alterar Ator"};
        } else {
            options = new String[]{"Novo Filme","Alterar Título","Alterar Descrição","Alterar Data de Lançamento","Alterar Orçamento","Alterar Categorias","Alterar Diretor","Alterar Ator","Sair"};
        }
        int selectedOption = ConsoleUIHelper.askChooseOption("Escolha uma opção", options);
        boolean keepShowing = true;
        switch (selectedOption){
            case 0:
                if (editItemCallback.isNew(film)){
                    saveAndExit();
                    keepShowing =false;
                } else {
                    String filmName = ConsoleUIHelper.askSimpleInput("Insira o nome do filme");
                    newFilm(filmName);
                }
                break;
            case 1:
                fillTitle();
                break;
            case 2 :
                fillDescription();
                break;
            case 3 :
                fillReleaseDate();
                break;
            case 4 :
                fillBudgets();
                break;
            case 5 :
                fillCategories();
                break;
            case 6 :
                fillDirector();
                break;
            case 7 :
                fillActors();
                break;
            default:
                saveAndExit();
                keepShowing = false;
        }
        return keepShowing;
    }

    private void newFilm(String filmName){
        Filmes newFilm = new Filmes();
        newFilm.title = filmName;
        FilmUI newFilmUI = new FilmUI(pageTitle, newFilm, editItemCallback);
        newFilmUI.show();
    }

    private void fillTitle() {
        String value = ConsoleUIHelper.askSimpleInput("Informe o título");
        //film.setTitulo(value);
    }
    private void fillDescription() {
        String value = ConsoleUIHelper.askSimpleInput("Informe a descrição");
        //film.setDescription(value);
    }
    private void fillReleaseDate() {
        String value = ConsoleUIHelper.askSimpleInput("Informe a data de lançamento");
        //film.setReleaseDate(value);
    }
    private void fillBudgets() {
        String value = ConsoleUIHelper.askSimpleInput("Informe o orçamento");
        //film.setBudget(value);
    }
    private void fillCategories() {
        String value = ConsoleUIHelper.askSimpleInput("Informe a categoria");
        //film.setTitulo(value);
    }
    private void fillDirector() {
        String value = ConsoleUIHelper.askSimpleInput("Informe o diretor");
        //film.setTitulo(value);
    }
    private void fillActors() {
        String value = ConsoleUIHelper.askSimpleInput("Informe o ator");
        //film.setTitulo(value);
    }
}
