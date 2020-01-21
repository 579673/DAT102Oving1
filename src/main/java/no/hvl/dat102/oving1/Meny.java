package no.hvl.dat102.oving1;

import no.hvl.dat102.oving1.adt.FilmArkivADT;

import java.util.Scanner;

public class Meny {
    private Tekstgrensesnitt gui;
    private FilmArkivADT arkiv;

    public Meny(FilmArkivADT arkiv) {
        this.gui = new Tekstgrensesnitt();
        this.arkiv = arkiv;
    }

    public void start() {
        System.out.println("Velkommen til filmarkivet. Kos deg.");
        Scanner scanner = new Scanner(System.in);
        boolean ferdig = false;

        while (!ferdig) {
            System.out.println("1: Vis filmarkivet.");
            System.out.println("2: Vis statistikk.");
            System.out.println("3: Legg til film.");
            System.out.println("4: Søk i filmer etter tittel.");
            System.out.println("5: Søk i filmer etter produsent.");
            System.out.println("6: Slett film etter filmnummer.");
            System.out.println("0: Avslutt.");

            int selection = scanner.nextInt();
            scanner.nextLine();

            switch (selection) {
                case 1: System.out.println(arkiv);
                        break;
                case 2: gui.skrivUtStatistikk(arkiv);
                        break;
                case 3: arkiv.leggTilFilm(gui.lesFilm());
                        break;
                case 4: System.out.println("Tittel: ");
                        String tittel = scanner.nextLine();
                        gui.skrivUtFilmDelstrengTittel(arkiv, tittel);
                        break;
                case 5: System.out.println("Produsent: ");
                        String produsent = scanner.nextLine();
                        gui.skrivUtEtterProdusent(arkiv, produsent);
                        break;
                case 6: System.out.println("Filmnummer: ");
                        int filmNr = scanner.nextInt();
                        arkiv.slettFilm(filmNr);
                        break;
                case 0: System.out.println("Avslutter arkivet. Ha en fin dag.");
                        ferdig = true;
                        break;
                default: System.out.println(selection + " er ikke er gyldig valg! :)");
            }
        }
    }
}
