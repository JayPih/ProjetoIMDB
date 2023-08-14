package ui;

import model.Filmes;
import util.ConsoleUIHelper;

import java.util.List;

public class PagedListUI extends  BasicUI {
    protected final int PAGE_SIZE;
    protected int currentPage;

    protected PagedList pageSource;
    private List<Filmes> dataList;
    public PagedListUI(String pageTitle, PagedList pageSource) {
        this(DEFAULT_COLUMNS, DEFAULT_ROWS, pageTitle, pageSource);
    }

    public PagedListUI(int columns, int rows, String pageTitle, PagedList pageSource) {
        super(columns, rows, pageTitle);
        PAGE_SIZE = rows - 4;
        currentPage = 1;
        this.pageSource = pageSource;
    }

    @Override
    public int drawContent() {
        dataList = pageSource.listarFilmes(currentPage,PAGE_SIZE);
        for (int i = 0; i < dataList.size(); i++) {
            Filmes filme = dataList.get(i);
            ConsoleUIHelper.drawWithRightPadding(i + " : " + filme.toString(), columns, ' ');
        }
        return dataList.size();
    }

    @Override
    public int menuLines() {
        return 0;
    }

    @Override
    public boolean drawMenu() {
        String[] options = {"Página Anterior", "Página Seguinte", "Novo item", "Ver detalhes", "Sair"};
        int selectedOption = ConsoleUIHelper.askChooseOption("Escolha uma opção", options);

        switch (selectedOption) {
            case 0: {
                previousPage();
                break;
            }
            case 1: {
                nextPage();
                break;
            }
            case 2: {
                addItem();
                break;
            }
            case 3: {
                seeItem();
                break;
            }
            default: {
                return false;
            }
        }
        return true;
    }
    private void previousPage(){

    }

    private void nextPage(){

    }

    private void addItem(){

    }

    private void seeItem(){
        int itemId = ConsoleUIHelper.askNumber("Informe o número do item a exibir").intValue();
        if (itemId >= 0 && itemId < dataList.size()){
            System.out.println("Você escolheu o item " + dataList.get(itemId).toString());
        } else {
            ConsoleUIHelper.showMessageAndWait("Número inválido! Favor inserir um número válido", 7);
        }
    }
}
