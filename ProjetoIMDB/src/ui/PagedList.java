package ui;

import model.Filmes;

import java.util.List;

public interface PagedList {
    List<Filmes> listarFilmes(int page, int pageSize);
}
