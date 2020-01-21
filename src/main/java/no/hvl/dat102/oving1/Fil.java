package no.hvl.dat102.oving1;

import no.hvl.dat102.oving1.adt.FilmArkivADT;

import java.io.*;

public class Fil {
    final static String DELIM = "#";

    public static void lesFraFil(FilmArkivADT arkiv, String filnavn) {
        File file = new File(filnavn);

        if (!file.exists()) {
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;

            while ((line = reader.readLine()) != null) {
                arkiv.leggTilFilm(stringToFilm(line));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void skrivTilFil(FilmArkivADT arkiv, String filnavn) {
        File file = new File(filnavn);
        Film[] filmtabell = arkiv.hentFilmTabell();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            for (Film film : filmtabell) {
                writer.write(formatFilm(film) + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String formatFilm(Film film) {
        return film.getFilmnr() + DELIM +
                film.getProdusent() + DELIM +
                film.getTittel() + DELIM +
                film.getLansert() + DELIM +
                film.getSjanger() + DELIM +
                film.getFilmSelskap();
    }

    private static Film stringToFilm(String filmString) {
        String[] filmFelt = filmString.split(DELIM);

        int filmnr = Integer.parseInt(filmFelt[0]);
        String produsent = filmFelt[1];
        String tittel = filmFelt[2];
        int lansert = Integer.parseInt(filmFelt[3]);
        Sjanger sjanger = Sjanger.valueOf(filmFelt[4]);
        String filmselskap = filmFelt[5];

        return new Film(filmnr, produsent, tittel, lansert, sjanger, filmselskap);
    }
}
