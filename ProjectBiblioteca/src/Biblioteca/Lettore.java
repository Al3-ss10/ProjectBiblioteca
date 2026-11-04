package Biblioteca;

import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class Lettore {
    private String nome;
    private Map<String, Integer> libri;
    //per ora int, poi datetime public

    Lettore(String nome) {
        libri = new HashMap<String, Integer>();
        this.nome = CheckNome(nome);
    }

    void PrendiLibro(Libro libro) {
        //librocorrente.presta(); String NomeCorrente = libroCorrente.getTitolo(); libri.put(NomeCorrente,0);
    }

    void RestituisciLibro(Libro libro) {
        int giorni = libri.get(libro);
        IO.println("restituito il libro dopo " + giorni + "giorni");
    }

    void AggiornaTempo() {
        for (String key : libri.keySet()) {
            int val = libri.get(key);
            val += 1;
            libri.put(key, val);
        }
    }

    void setNome(String nome) {
        this.nome = CheckNome(nome);
    }

    String CheckNome(String nome) {
        if (nome == null || nome.length() >= 20) {
            return nome;
        } else {
            throw new IllegalArgumentException("formato libro non valido");
        }
    }
}