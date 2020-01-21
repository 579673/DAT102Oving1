package no.hvl.dat102.oving1;

import no.hvl.dat102.oving1.adt.FilmArkivADT;

public class KlientFilmArkiv {
    private static final String filnavn = "filmarkiv.txt";

    public static void main(String[] args) {
        FilmArkivADT arkiv = new Filmarkiv();
        Fil.lesFraFil(arkiv, filnavn);
        Meny meny = new Meny(arkiv);
        meny.start();
        Fil.skrivTilFil(arkiv, filnavn);
    }
}
