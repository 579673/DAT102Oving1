package no.hvl.dat102.oving1;

import no.hvl.dat102.oving1.adt.FilmArkivADT;

import java.util.Scanner;

public class Tekstgrensesnitt {

    public Film lesFilm() {
        System.out.println("Skriv inn filmdetaljer.");
        Scanner scanner = new Scanner(System.in);

        System.out.println("FilmNr: ");
        int filmnr = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Produsent: ");
        String produsent = scanner.nextLine();
        System.out.println("Tittel: ");
        String tittel = scanner.nextLine();
        System.out.println("Lanseringsår: ");
        int lansert = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Sjanger: ");
        Sjanger sjanger = Sjanger.valueOf(scanner.nextLine().toUpperCase());
        System.out.println("Filmselskap: ");
        String filmSelskap = scanner.nextLine();

        return new Film(filmnr, produsent, tittel, lansert, sjanger, filmSelskap);
    }



    public void skrivUtFilmDelstrengTittel(FilmArkivADT arkiv, String tittel) {
        for (Film film : arkiv.hentFilmTabell()) {
            if (film.getTittel().equalsIgnoreCase(tittel)) {
                System.out.println(film);
            }
        }
    }

    public void skrivUtEtterProdusent(FilmArkivADT arkiv, String produsent) {
        for (Film film : arkiv.hentFilmTabell()) {
            if (film.getProdusent().equalsIgnoreCase(produsent)) {
                System.out.println(film);
            }
        }
    }

    public void skrivUtStatistikk(FilmArkivADT arkiv) {
        int antallFilmer = arkiv.hentFilmTabell().length;
        System.out.println("Totalt antall filmer: " + antallFilmer);
        if (antallFilmer == 0) {
            return;
        }
        for (Sjanger sjanger : Sjanger.values()) {
            System.out.println(formaterSjanger(sjanger) + ": " + arkiv.antallSjanger(sjanger));
        }
    }

    private String formaterSjanger(Sjanger sjanger) {
        String sjangerStr = sjanger.toString();
        return sjangerStr.substring(0, 1).toUpperCase() + sjangerStr.substring(1).toLowerCase();
    }

}
