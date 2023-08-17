package model;
public class Ator extends Cineasta{

    private String papel;
    private double tempoDeTela;
    private String filmesPresente;
    private String dataNascimento;
    private String altura;
    private boolean isOscar;

    public String getPapel() {
        return papel;
    }

    public void setPapel(String papel) {
        this.papel = papel;
    }

    public double getTempoDeTela() {
        return tempoDeTela;
    }

    public void setTempoDeTela(double tempoDeTela) {
        this.tempoDeTela = tempoDeTela;
    }

    public String getFilmesPresente() {
        return filmesPresente;
    }

    public void setFilmesPresente(String filmesPresente) {
        this.filmesPresente = filmesPresente;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getAltura() {
        return altura;
    }

    public void setAltura(String altura) {
        this.altura = altura;
    }

    public boolean isOscar() {
        return isOscar;
    }

    public void setOscar(boolean oscar) {
        isOscar = oscar;
    }
}
