package model;

import java.time.LocalDate;
import java.util.Date;

public abstract class Cineasta {
    private String nome;
    private String sobrenome;
    private LocalDate dataNascimento;
    private double altura;
    private boolean isOscar;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public boolean isOscar() {
        return isOscar;
    }

    public void setOscar(boolean oscar) {
        isOscar = oscar;
    }


}