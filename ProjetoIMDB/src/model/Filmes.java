package model;

import enums.CategoriaFilmes;
import enums.ClassificacaoIndicativa;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Filmes {
    private String nome;
    private String dataLancamento;
    private BigDecimal orcamento;
    private String descricao;
    private boolean isOscar;

    private List<Ator> atores;
    private List<Diretor> diretores;

    private CategoriaFilmes categoriaFilmes;
    private ClassificacaoIndicativa classificacaoIndicativa;

    public Filmes(){
        this.categoriaFilmes = CategoriaFilmes.ACAO;
        this.classificacaoIndicativa = ClassificacaoIndicativa.L;
        this.atores = new ArrayList<>();
        this.diretores = new ArrayList<>();
    }

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

    public CategoriaFilmes getCategoriaFilmes() {
        return categoriaFilmes;
    }

    public void setCategoriaFilmes(CategoriaFilmes categoriaFilme) {
        this.categoriaFilmes = categoriaFilme;
    }

    public ClassificacaoIndicativa getClassificacaoIndicativa() {
        return classificacaoIndicativa;
    }

    public void setClassificacaoIndicativa(ClassificacaoIndicativa classificacaoIndicativa) {
        this.classificacaoIndicativa = classificacaoIndicativa;
    }
    public boolean getIsOscar() {
        return isOscar;
    }

    public void setIsOscar(boolean isOscar) {
        this.isOscar = isOscar;
    }

    @Override
    public String toString() {
        return getNome();
    }

    public boolean add(Ator ator){return atores.add(ator);}
    public boolean add(Diretor diretor){return diretores.add(diretor);}

    public List<Ator> getAtores() {return Collections.unmodifiableList(atores);}
    public List<Diretor> getDiretores() {return Collections.unmodifiableList(diretores);}
}
