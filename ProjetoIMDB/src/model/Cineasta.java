package model;

public abstract class Cineasta {
    private String nome;
    private String sobrenome;
    private String dataNascimento;
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

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
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