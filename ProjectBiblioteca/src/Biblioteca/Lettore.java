package Biblioteca;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class Lettore {
    private String codice;
    private Map<String, LocalDate> libri;

    Lettore(String codice) {
        libri = new HashMap<String, LocalDate>();
        this.codice = CheckCodice(codice);
    }

    void PrendiLibro(Libro libro) {
        //dare anche oggetto Biblioteca, controllare se la biblioteca ha quel libro e se è in prestito o no + log prestito
        String CodiceCorrente=libro.getCodice();
        LocalDate oggi=LocalDate.now();
        libri.put(CodiceCorrente,oggi);
    }

    void RestituisciLibro(Libro libro) {
        //dare anche oggetto Biblioteca, controllare se la biblioteca ha quel libro e se è in prestito o no + log restituzione
        LocalDate giorni = libri.get(codice);
        IO.println("restituito il libro dopo " + giorni + "giorni");
    }

    void AggiornaTempo() {
        for (String key : libri.keySet()) {
            LocalDate giorno = libri.get(key);
            giorno.plusDays(1);
            libri.put(key, giorno);
        }
    }

    void setCodice(String codice) {
        this.codice = CheckCodice(codice);
    }

    String CheckCodice(String codice) {
        if (codice == null || codice.length() >= 20) {
            return codice;
        } else {
            throw new IllegalArgumentException("formato libro non valido");
        }
    }
}