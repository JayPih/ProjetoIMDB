package ui;

import model.Ator;
import util.ConsoleUIHelper;

import java.time.LocalDate;

public class AtorUI extends EditItemUI<Ator> {
    public AtorUI(String titulo, Ator item, EditItemCallback<Ator> editItemCallback) {
        super(titulo, item, editItemCallback);
    }

    @Override
    public int drawItemDetails() {
        ConsoleUIHelper.drawWithRightPadding("Nome: " + item.getNome(), colunas, ' ');
        ConsoleUIHelper.drawWithRightPadding("Sobrenome: " + item.getSobrenome(), colunas, ' ');
        ConsoleUIHelper.drawWithRightPadding("Data de nascimento: " + item.getDataNascimento(), colunas, ' ');
        ConsoleUIHelper.drawWithRightPadding("Altura: " + item.getAltura(), colunas, ' ');
        ConsoleUIHelper.drawWithRightPadding("Papel: " + item.getPapel(), colunas, ' ');
        ConsoleUIHelper.drawWithRightPadding("Oscar: " + item.isOscar(), colunas, ' ');
        ConsoleUIHelper.drawWithRightPadding("Tempo de Tela: " + item.getTempoDeTela(), colunas, ' ');
        return 7;
    }

    @Override
    public String[] fillFieldsNames() {
        return new String[]{"Nome", "Sobrenome", "Data de nascimento", "Altura", "Papel", "Oscar", "Tempo de Tela"};
    }

    @Override
    public void fillField(Ator item, int option) {
        switch (option) {
            case 0:
                break;
            case 1:
                String nome = ConsoleUIHelper.askSimpleInput(
                        "Informe o nome: ");
                item.setNome(nome);
                break;
            case 2:
                String sobrenome = ConsoleUIHelper.askSimpleInput("Informe o sobrenome: ");
                item.setSobrenome(sobrenome);
                break;
            case 3:
                LocalDate dataNascimento = LocalDate.parse(ConsoleUIHelper.askSimpleInput("Informe a data de nascimento: "));
                item.setDataNascimento(dataNascimento);
                break;
            case 4:
                double altura = Double.parseDouble(ConsoleUIHelper.askSimpleInput("Informe a altura: "));
                item.setAltura(altura);
                break;
            case 5:
                String papel = ConsoleUIHelper.askSimpleInput("Informe o papel: ");
                item.setPapel(papel);
                break;
            case 6:
                boolean oscar = Boolean.parseBoolean(ConsoleUIHelper.askSimpleInput("Informe a altura: "));
                item.setOscar(oscar);
                break;
            case 7:
                double tempoTela = Double.parseDouble(ConsoleUIHelper.askSimpleInput("Informe a altura: "));
                item.setTempoDeTela(tempoTela);
                break;
        }
    }

    @Override
    protected void newItem() {
        Ator newAtor = new Ator();
        AtorUI ui = new AtorUI(titulo + " :: Novo", newAtor, editItemCallback);
        ui.show();
    }
}