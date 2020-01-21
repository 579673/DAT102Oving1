package no.hvl.dat102.oving1;

import no.hvl.dat102.oving1.adt.FilmArkivADT;

public class Filmarkiv implements FilmArkivADT {
    private Film[] filmTabell;
    private int antallFilmer;

    public Filmarkiv() {
        this.filmTabell = new Film[10];
        this.antallFilmer = 0;
    }

    @Override
    public Film[] hentFilmTabell() {
        return trimTabell(filmTabell, antallFilmer);
    }

    @Override
    public void leggTilFilm(Film film) {
        if (antallFilmer >= filmTabell.length) {
            utvidTabell();
        }
        filmTabell[antallFilmer] = film;
        antallFilmer++;
    }

    @Override
    public boolean slettFilm(int filmnr) {
        boolean slettet = false;
        for (int i = 0; i < filmTabell.length; i++) {
            if (filmTabell[i].getFilmnr() == filmnr) {
                filmTabell[i] = null;
                slettet = true;
            }
        }
        pakkTabell();
        return slettet;
    }

    @Override
    public Film[] sokTittel(String delstreng) {
        Film[] resultat = new Film[antallFilmer];
        int antallFunnet = 0;

        for (Film film : filmTabell) {
            if (film.getTittel().contains(delstreng)) {
                resultat[antallFunnet] = film;
               antallFunnet++;
            }
        }

        return trimTabell(resultat, antallFunnet);
    }

    @Override
    public Film[] sokProdusent(String delstreng) {
       Film[] resultat = new Film[antallFilmer];
        int antallFunnet = 0;

        for (Film film : filmTabell) {
            if (film.getProdusent().contains(delstreng)) {
                resultat[antallFunnet] = film;
               antallFunnet++;
            }
        }

        return trimTabell(resultat, antallFunnet);
    }

    @Override
    public int antallSjanger(Sjanger sjanger) {
        int antall = 0;
        for (Film film : filmTabell) {
            if (film.getSjanger().equals(sjanger)) {
                antall++;
            }
        }
        return antall;
    }

    private Film[] trimTabell(Film[] tabell, int antallFilmer) {
        Film[] nyTab = new Film[antallFilmer];
        System.arraycopy(filmTabell, 0, nyTab, 0, antallFilmer);
        return nyTab;
    }

    private void utvidTabell() {
        int nyLengde = (int)(filmTabell.length * 1.5);
        Film[] nyTabell = new Film[nyLengde];
        System.arraycopy(filmTabell, 0, nyTabell, 0, filmTabell.length);
        filmTabell = nyTabell;
    }

    private void pakkTabell() {
        boolean moved;
        do {
            moved = false;
            for (int i = 0; i < filmTabell.length - 1; i++) {
                if (filmTabell[i] == null) {
                    swap(i, i+1);
                    moved = true;
                }
            }
        } while (moved);
    }

    private void swap(int a, int b) {
        Film temp = filmTabell[a];
        filmTabell[a] = filmTabell[b];
        filmTabell[b] = temp;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (Film film : trimTabell(filmTabell, antallFilmer)) {
            builder.append(film);
            builder.append("\n");
        }
        return builder.toString();
    }
}
