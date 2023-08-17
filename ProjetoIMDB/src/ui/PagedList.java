package ui;

import model.Filmes;

import java.util.List;

public interface PagedList<T> {
    List<T> listar(int page, int pageSize);
}
