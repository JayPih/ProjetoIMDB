import model.Filmes;

import java.util.ArrayList;
import java.util.List;

public class CatalogoFilmes implements ui.PagedList<Filmes> {
    private List<Filmes> filmes;

    public CatalogoFilmes() {
        filmes = new ArrayList<>();
    }

    @Override
    public List<Filmes> listar(int pagina, int tamanhoPagina) {
        List<Filmes> listagem = new ArrayList<>();
        int primeiroRegistro = tamanhoPagina * (pagina - 1);
        if (primeiroRegistro > filmes.size() - 1) {
            return listagem;
        }
        int ultimoRegistro = Math.min(primeiroRegistro + tamanhoPagina, filmes.size());
        for (int i = primeiroRegistro; i < ultimoRegistro; i++) {
            Filmes filme = filmes.get(i);
            listagem.add(filme);
        }
        return listagem;
    }

    void adicionarFilme(Filmes filme) {
        filmes.add(filme);
    }

    void removerFilme(Filmes filme) {
        filmes.remove(filme);
    }

    List<Filmes> pesquisarFilme(String titulo) {
        List<Filmes> encontrados = new ArrayList<>();
        for (Filmes filme : filmes) {
            if (filme.getNome().toLowerCase().contains(titulo.toLowerCase())) {
                encontrados.add(filme);
            }
        }
        return encontrados;
    }
}
