package Biblioteca;

import java.time.LocalDate;
import java.util.Map;
import java.util.HashMap;

public class Lettore {
    private String nome;
    private int eta;
    private LocalDate oggi;

    private Map<Libro, Integer> libri;

    public Lettore(String nome, int eta) {
        libri = new HashMap<Libro, Integer>();
        this.nome=checkNome(nome.strip().toLowerCase());
        this.eta=checkEta(eta);
        oggi=LocalDate.now();
    }

    // -- Checkers -- \\
    private String checkNome(String nome){
        if(nome.isEmpty()){
            throw new IllegalArgumentException("nome inesistente");
        }
        else{
            return nome;
        }
    }
    private int checkEta(int eta){
        if (eta>=0){
            return eta;
        }else{
            throw new IllegalArgumentException("età negativa");
        }
    }


    // -- Setters -- \\

    public void setEta(int eta) {
        this.eta = checkEta(eta);
    }
    public void setNome(String nome) {
        this.nome = checkNome(nome.strip().toLowerCase());
    }
    // -- Getters -- \\

    public int getEta() {
        return eta;
    }
    public String getNome() {
        return nome;
    }
    public Map<Libro, Integer> getLibri() {return libri;}

    public void PrendiLibro(Libro libro, Biblioteca biblioteca,Log log) {

        String CodiceCorrente = libro.getId();
        if (biblioteca.checkPrestato(CodiceCorrente)) {
            throw new IllegalArgumentException("libro già in prestito");
        } else {
            LocalDate oggi=LocalDate.now();
            libri.put(libro, 0);
            biblioteca.setLibriprestato(CodiceCorrente,true);
            log.AggiungiLog(oggi + ": preso in prestito il libro: "+libro.getTitolo());
        }
    }

    public void RestituisciLibro(Libro libro, Biblioteca biblioteca, Log log) {
        if (!libri.containsKey(libro)) {
            throw new IllegalArgumentException("non puoi restituire un libro che non hai");
        }

        String codice = libro.getId();
        int data;
        if (biblioteca.checkPrestato(codice)) {
            data = libri.get(libro);
            log.AggiungiLog(oggi.plusDays(data) + ": restituito il libro: "+libro.getTitolo());
            libri.remove(libro);
            biblioteca.setLibriprestato(codice,false);
        }


    }

    public void AggiornaTempo() {
        for (Libro key : libri.keySet()) {
            int giorno = libri.get(key);
            giorno+=1;
            libri.put(key, giorno);
        }
    }

    @Override
    public String toString() {
        String testo="";
        for (Libro key : libri.keySet()){
            testo+="libro: " + key.getTitolo()+"\n";
        }
        return "nome: "+nome+" - età: "+eta+"\n"+testo;
    }
}