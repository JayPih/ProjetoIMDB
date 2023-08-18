package ui;

import model.Diretor;
import util.ConsoleUIHelper;

import java.time.LocalDate;

public class DiretorUI extends EditItemUI<Diretor> {
    public DiretorUI(String titulo, Diretor item, EditItemCallback<Diretor> editItemCallback) {
        super(titulo, item, editItemCallback);
    }

    @Override
    public int drawItemDetails() {
        ConsoleUIHelper.drawWithRightPadding("Nome: " + item.getNome(), colunas, ' ');
        ConsoleUIHelper.drawWithRightPadding("Sobrenome: " + item.getSobrenome(), colunas, ' ');
        ConsoleUIHelper.drawWithRightPadding("Data de nascimento: " + item.getDataNascimento(), colunas, ' ');
        ConsoleUIHelper.drawWithRightPadding("Altura: " + item.getAltura(), colunas, ' ');
        ConsoleUIHelper.drawWithRightPadding("Oscar: " + item.isOscar(), colunas, ' ');
        ConsoleUIHelper.drawWithRightPadding("Numero de filmes dirigidos: " + item.getNumFilmesDirigidos(), colunas, ' ');
        return 6;
    }

    @Override
    public String[] fillFieldsNames() {
        return new String[]{"Nome", "Sobrenome", "Data de nascimento", "Altura", "Oscar", "Numero de filmes dirigidos"};
    }

    @Override
    public void fillField(Diretor item, int option) {
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
                boolean oscar = Boolean.parseBoolean(ConsoleUIHelper.askSimpleInput("Recebeu oscar: "));
                item.setOscar(oscar);
                break;
            case 6:
                int numFilmesDirigidos = Integer.parseInt(ConsoleUIHelper.askSimpleInput("Informe o numero de filmes dirigidos: "));
                item.setNumFilmesDirigidos(numFilmesDirigidos);
                break;
        }
    }

    @Override
    protected void newItem() {
        Diretor newDiretor = new Diretor();
        DiretorUI ui = new DiretorUI(titulo + " :: Novo", newDiretor, editItemCallback);
        ui.show();
    }
}