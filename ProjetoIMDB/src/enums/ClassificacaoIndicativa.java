package enums;

public enum ClassificacaoIndicativa {
    L("Livre para todos os públicos"),
    _10("Não recomendado para menores de 10 anos"),
    _12("Não recomendado para menores de 12 anos"),
    _14("Não recomendado para menores de 14 anos"),
    _16("Não recomendado para menores de 16 anos"),
    _18("Não recomendado para menores de 18 anos");

    private final String descricao;

    private ClassificacaoIndicativa(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
