package no.hvl.dat102.oving1;

import java.util.Objects;

public class Film {
    private int filmnr;
    private String produsent;
    private String tittel;
    private int lansert;
    private Sjanger sjanger;
    private String filmSelskap;

    public Film() {
    }

    public Film(int filmnr, String produsent, String tittel, int lansert, Sjanger sjanger, String filmSelskap) {
        this.filmnr = filmnr;
        this.produsent = produsent;
        this.tittel = tittel;
        this.lansert = lansert;
        this.sjanger = sjanger;
        this.filmSelskap = filmSelskap;
    }

    public int getFilmnr() {
        return filmnr;
    }

    public void setFilmnr(int filmnr) {
        this.filmnr = filmnr;
    }

    public String getProdusent() {
        return produsent;
    }

    public void setProdusent(String produsent) {
        this.produsent = produsent;
    }

    public String getTittel() {
        return tittel;
    }

    public void setTittel(String tittel) {
        this.tittel = tittel;
    }

    public int getLansert() {
        return lansert;
    }

    public void setLansert(int lansert) {
        this.lansert = lansert;
    }

    public Sjanger getSjanger() {
        return sjanger;
    }

    public void setSjanger(Sjanger sjanger) {
        this.sjanger = sjanger;
    }

    public String getFilmSelskap() {
        return filmSelskap;
    }

    public void setFilmSelskap(String filmSelskap) {
        this.filmSelskap = filmSelskap;
    }

    @Override
    public String toString() {
        return "Filmnr: " + filmnr + "\n" +
                "Produsent: " + produsent + "\n" +
                "Tittel: " + tittel + "\n" +
                "Lansert: " + lansert + "\n" +
                "Sjanger: " + sjanger + "\n" +
                "FilmSelskap: " + filmSelskap + "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Film film = (Film) o;
        return filmnr == film.filmnr &&
                lansert == film.lansert &&
                Objects.equals(produsent, film.produsent) &&
                Objects.equals(tittel, film.tittel) &&
                sjanger == film.sjanger &&
                Objects.equals(filmSelskap, film.filmSelskap);
    }

    @Override
    public int hashCode() {
        return Objects.hash(filmnr, produsent, tittel, lansert, sjanger, filmSelskap);
    }
}

