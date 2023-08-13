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
    private ClassificacaoIndicativa classificacaoIndicativa;

    private List<Ator> ator;
    private List<Diretor> diretor;

    private CategoriaFilmes categoriaFilme;



}
