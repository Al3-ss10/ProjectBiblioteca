package Biblioteca;

import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class Lettore {
    private String codice;
    private Map<String, Integer> libri;
    //per ora int, poi datetime public

    Lettore(String codice) {
        libri = new HashMap<String, Integer>();
        this.codice = CheckCodice(codice);
    }

    void PrendiLibro(Libro libro) {
        //librocorrente.presta(); String NomeCorrente = libroCorrente.getTitolo(); libri.put(NomeCorrente,0);
    }

    void RestituisciLibro(Libro libro) {
        int giorni = libri.get(codice);
        IO.println("restituito il libro dopo " + giorni + "giorni");
    }

    void AggiornaTempo() {
        for (String key : libri.keySet()) {
            int val = libri.get(key);
            val += 1;
            libri.put(key, val);
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