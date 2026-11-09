package Biblioteca;

import java.time.Year;
import java.util.Random;

public class Libro {
    private String titolo;
    private String autore;
    private GenereLibro genere;
    private int anno;
    private int nPagine;
    private String codice;
    private boolean inPrestito;
    // private DateTime durataPrestito;

    Random random = new Random();

    Libro(String titolo, String autore, GenereLibro genere, int anno, int nPagine){
        this.titolo = checkTitolo(titolo);
        this.autore = checkAutore(autore);
        this.genere = genere;
        this.anno = checkAnno(anno);
        this.nPagine = checknPagine(nPagine);
    }

    // ----- CHECK -----
    String checkTitolo(String titolo){
        if (titolo == null || titolo.length() < 1){
            throw new IllegalArgumentException("ERRORE: titolo non valido!");
        } else {
            return titolo;
        }
    }
    String checkAutore(String autore){
        if (autore == null || autore.length() < 1){
            throw new IllegalArgumentException("ERRORE: autore non valido!");
        } else {
            return autore;
        }
    }
    int checkAnno(int anno){
        if (anno < 1000 || anno > Year.now().getValue()){
            throw new IllegalArgumentException("ERRORE: anno non valido!");
        } else {
            return anno;
        }
    }
    int checknPagine(int nPagine){
        if (nPagine <= 0){
            throw new IllegalArgumentException("ERRORE: numero pagine non valido!");
        } else {
            return nPagine;
        }
    }

    // ----- GET -----
    String getTitolo(){
        return titolo;
    }
    String getAutore(){
        return autore;
    }
    GenereLibro getGenere(){
        return genere;
    }
    int getAnno(){
        return anno;
    }
    int getnPagine(){
        return nPagine;
    }
    String getCodice(){
        return codice;
    }
    boolean getInPrestito(){
        return inPrestito;
    }

    // ----- SET -----
    void setTitolo(String titolo){
        this.titolo = checkTitolo(titolo);
    }
    void setAutore(String autore){
        this.autore = checkAutore(autore);
    }
    void setGenere(GenereLibro genere){
        this.genere = genere;
    }
    void setAnno(int anno){
        this.anno = checkAnno(anno);
    }
    void setnPagine(int nPagine){
        this.nPagine = checknPagine(nPagine);
    }
    void setInPrestito(boolean inPrestito) {
        this.inPrestito=inPrestito;
    }

    // manca set codice e in prestito
    // fare tostring presta restituisci
    void randomCodice(){
        String[] caratteri = {
                "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M",
                "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z",
                "0", "1", "2", "3", "4", "5", "6", "7", "8", "9"
        };
        String codice = "";
        for (int i = 0; i < 5; i++) {
            int indiceCasuale = random.nextInt(caratteri.length);
            codice = codice + caratteri[indiceCasuale];
        }

    }
}
