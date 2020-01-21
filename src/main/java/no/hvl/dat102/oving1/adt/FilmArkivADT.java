package no.hvl.dat102.oving1.adt;

import no.hvl.dat102.oving1.Film;
import no.hvl.dat102.oving1.Sjanger;

public interface FilmArkivADT {
    Film[] hentFilmTabell();
    void leggTilFilm(Film film);
    boolean slettFilm(int filmnr);
    Film[] sokTittel(String delstreng);
    Film[] sokProdusent(String delstreng);
    int antallSjanger(Sjanger sjanger);
}
