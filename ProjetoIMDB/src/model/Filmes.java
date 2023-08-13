package model;

import enums.CategoriaFilmes;
import enums.ClassificacaoIndicativa;

import java.math.BigDecimal;
import java.util.List;

public class Filmes {
    private String nome;
    private String dataLancamento;
    private BigDecimal orcamento;
    private String descricao;
    private boolean isOscar;

    private List<Ator> ator;
    private List<Diretor> diretor;

    private CategoriaFilmes categoriaFilme;
    private ClassificacaoIndicativa classificacaoIndicativa;


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(String dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public BigDecimal getOrcamento() {
        return orcamento;
    }

    public void setOrcamento(BigDecimal orcamento) {
        this.orcamento = orcamento;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public CategoriaFilmes getCategoriaFilme() {
        return categoriaFilme;
    }

    public void setCategoriaFilme(CategoriaFilmes categoriaFilme) {
        this.categoriaFilme = categoriaFilme;
    }

    public ClassificacaoIndicativa getClassificacaoIndicativa() {
        return classificacaoIndicativa;
    }

    public void setClassificacaoIndicativa(ClassificacaoIndicativa classificacaoIndicativa) {
        this.classificacaoIndicativa = classificacaoIndicativa;
    }
    public boolean isOscar() {
        return isOscar;
    }

    public void setOscar(boolean oscar) {
        isOscar = oscar;
    }
}
