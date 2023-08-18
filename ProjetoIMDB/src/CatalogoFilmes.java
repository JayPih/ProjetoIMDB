import model.Filmes;
import services.CatalogoService;

import java.util.ArrayList;
import java.util.List;

public class CatalogoFilmes implements ui.PagedList<Filmes> {
    private CatalogoService catalogoService;

    public CatalogoFilmes(){catalogoService = CatalogoService.getInstance();}

    @Override
    public List<Filmes> listar(int pagina, int tamanhoPagina) {
        List<Filmes> filmes = catalogoService.getFilmesList();
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
        catalogoService.add(filme);
    }

    void removerFilme(Filmes filme) {
        catalogoService.del(filme);
    }

    List<Filmes> pesquisarFilme(String titulo) {
        List<Filmes> filmes = catalogoService.getFilmesList();
        List<Filmes> encontrados = new ArrayList<>();
        for (Filmes filme : filmes) {
            if (filme.getNome().toLowerCase().contains(titulo.toLowerCase())) {
                encontrados.add(filme);
            }
        }
        return encontrados;
    }
}
