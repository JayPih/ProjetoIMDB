package services;

import enums.CategoriaFilmes;
import enums.ClassificacaoIndicativa;
import model.Ator;
import model.Diretor;
import model.Filmes;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class CatalogoService {
    private static CatalogoService instance;

    public synchronized static CatalogoService getInstance() {
        if (instance == null) {
            instance = new CatalogoService();
        }
        return instance;
    }

    private List<Filmes> filmesList;

    private CatalogoService() {
        filmesList = new LinkedList<>();
    }

    public List<Filmes> getFilmesList() {
        return Collections.unmodifiableList(filmesList);
    }

    public void add(Filmes filmes) {
        filmesList.add(filmes);
    }

    public void del(Filmes filmes) {
        filmesList.remove(filmes);
    }

    public void importar(String path) {
        Path importPath = Paths.get(path).toAbsolutePath();
        try {
            Files.lines(importPath, StandardCharsets.UTF_8).forEach(line -> {
                String[] tokens = line.split(Character.toString(247));
                if (tokens[0].equals("F")) {
                    filmesList.add(textToFilmes(tokens));
                } else if (tokens[0].equals("A")) {
                    if (!filmesList.isEmpty()) {
                        Filmes filmes = filmesList.get(filmesList.size()-1);
                        Ator ator = textToAtor(tokens);
                        filmes.add(ator);
                    }
                } else if (tokens[0].equals("D")) {
                    if (!filmesList.isEmpty()) {
                        Filmes filmes = filmesList.get(filmesList.size()-1);
                        Diretor diretor = textToDiretor(tokens);
                        filmes.add(diretor);
                    }
                }
            });
        } catch (IOException ignored) {
            System.err.println(ignored.getMessage());
        }
    }

    public boolean exportar(String path, boolean sobrescrever) {
        Path exportPath = Paths.get(path).toAbsolutePath();
        try {
            if (Files.exists(exportPath)) {
                if (!sobrescrever) {
                    return false;
                } else {
                    Path copyPath = exportPath.getParent().resolve(exportPath.toFile().getName().concat(".bkp"));
                    Files.copy(exportPath, copyPath, StandardCopyOption.REPLACE_EXISTING);
                    Files.deleteIfExists(exportPath);
                }
            }
            Files.createFile(exportPath);
            for (Filmes filmes : filmesList) {
                Files.writeString(exportPath, filmesToText(filmes), StandardCharsets.UTF_8, StandardOpenOption.APPEND);
                for (Ator ator : filmes.getAtores()) {
                    Files.writeString(exportPath, atorToText(ator), StandardCharsets.UTF_8, StandardOpenOption.APPEND);
                }
                for (Diretor diretor : filmes.getDiretores()) {
                    Files.writeString(exportPath, diretorToText(diretor), StandardCharsets.UTF_8, StandardOpenOption.APPEND);
                }
            }
            return true;
        } catch (IOException ignored) {
            System.err.println(ignored.getMessage());
        }
        return false;
    }

    private String filmesToText(Filmes filmes) {
        return String.join(Character.toString(247),
                "F",
                filmes.getNome(),
                filmes.getDataLancamento(),
                String.valueOf(filmes.getOrcamento()),
                filmes.getDescricao(),
                String.valueOf(filmes.getIsOscar()),
                filmes.getCategoriaFilmes().name(),
                filmes.getClassificacaoIndicativa().name(),
                "\n"
        );
    }

    private Filmes textToFilmes(String[] tokens) {
        if (tokens.length < 8) {
            return null;
        }
        Filmes filmes = new Filmes();
        filmes.setNome(tokens[1]);
        filmes.setDataLancamento(tokens[2]);
        double orcamento = tokens[3].equals("null") ?  0.0d : Double.parseDouble(tokens[3]);
        filmes.setOrcamento(BigDecimal.valueOf(orcamento));
        filmes.setDescricao(tokens[4]);
        filmes.setIsOscar(tokens[5].equals("true"));
        CategoriaFilmes categoria;
        try {
            categoria = CategoriaFilmes.valueOf(tokens[6]);
        } catch (IllegalArgumentException e) {
            categoria = CategoriaFilmes.ACAO;
        }
        filmes.setCategoriaFilmes(categoria);
        ClassificacaoIndicativa classificacao;
        try {
            classificacao = ClassificacaoIndicativa.valueOf(tokens[7]);
        } catch (IllegalArgumentException e) {
            classificacao = ClassificacaoIndicativa.L;
        }
        filmes.setClassificacaoIndicativa(classificacao);
        return filmes;
    }

    private String atorToText(Ator ator) {
        return String.join(Character.toString(247),
                "A",
                ator.getNome(),
                ator.getSobrenome(),
                ator.getDataNascimento(),
                String.valueOf(ator.getAltura()),
                String.valueOf(ator.getIsOscar()),
                ator.getPapel(),
                String.valueOf(ator.getTempoDeTela()),
                "\n"
        );
    }

    private Ator textToAtor(String[] tokens) {
        if (tokens.length < 8) {
            return null;
        }
        Ator ator = new Ator();
        ator.setNome(tokens[1]);
        ator.setSobrenome(tokens[2]);
        ator.setDataNascimento(tokens[3]);
        ator.setAltura(tokens[4].equals("null") ? 0.0d : Double.parseDouble(tokens[4]));
        ator.setIsOscar(tokens[5].equals("true"));
        ator.setPapel(tokens[6]);
        ator.setTempoDeTela(tokens[6].equals("null") ? 0.0d : Double.parseDouble(tokens[6]));
        return ator;
    }

    private String diretorToText(Diretor diretor) {
        return String.join(Character.toString(247),
                "D",
                diretor.getNome(),
                diretor.getSobrenome(),
                diretor.getDataNascimento(),
                String.valueOf(diretor.getAltura()),
                String.valueOf(diretor.getIsOscar()),
                String.valueOf(diretor.getNumFilmesDirigidos()),
                "\n"
        );
    }

    private Diretor textToDiretor(String[] tokens) {
        if (tokens.length < 7) {
            return null;
        }
        Diretor diretor = new Diretor();
        diretor.setNome(tokens[1]);
        diretor.setSobrenome(tokens[2]);
        diretor.setDataNascimento(tokens[3]);
        diretor.setAltura(tokens[4].equals("null") ? 0.0d : Double.parseDouble(tokens[4]));
        diretor.setIsOscar(tokens[5].equals("true"));
        diretor.setNumFilmesDirigidos(tokens[6].equals("null") ? 0 : Integer.parseInt(tokens[6]));
        return diretor;
    }
}
