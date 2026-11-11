package Biblioteca;

import java.time.Year;
import java.util.ArrayList;
import java.util.Random;
import java.util.Map;
import java.util.HashMap;

public class Libro {
    private String titolo;
    private String autore;
    private GenereLibro genere;
    private int anno;
    private int nPagine;
    private String id;
    private String isbn;
    private boolean inPrestito;
    private static ArrayList<String> listaID = new ArrayList<>();
    private static ArrayList<String> listaISBN = new ArrayList<>();
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
    private String checkTitolo(String titolo){
        if (titolo == null || titolo.length() < 1){
            throw new IllegalArgumentException("ERRORE: titolo non valido!");
        } else {
            return titolo;
        }
    }
    private String checkAutore(String autore){
        if (autore == null || autore.length() < 1){
            throw new IllegalArgumentException("ERRORE: autore non valido!");
        } else {
            return autore;
        }
    }
    private int checkAnno(int anno){
        if (anno < 1000 || anno > Year.now().getValue()){
            throw new IllegalArgumentException("ERRORE: anno non valido!");
        } else {
            return anno;
        }
    }
    private int checknPagine(int nPagine){
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
    String getId(){
        return this.id;
    }
    String getIsbn() {return this.isbn;}
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
    void setInPrestito(boolean inPrestito) {this.inPrestito = inPrestito;}

    // ----- TO STRING -----
    @Override
    public String toString() {
        return titolo.toUpperCase() + " di " + autore.toUpperCase() + "\n" +
                "   - genere " + genere + " - id " + id + " - isbn " + isbn + "\n" +
                "   - n° pag " + nPagine + " - anno di pubblicazione " + anno + " - in prestito (" + inPrestito + ")\n";
    }

    // ----- METODI -----
    void randomID(){
        String[] caratteri = {
                "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M",
                "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z",
                "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m",
                "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z",
                "0", "1", "2", "3", "4", "5", "6", "7", "8", "9"
        };
        do {
            String id = "";
            for (int i = 0; i < 5; i++) {
                int indiceCasuale = random.nextInt(caratteri.length);
                id += caratteri[indiceCasuale];
            }
        } while (listaID.contains(id));
        this.id = id;
        listaID.add(id);
    }
    void randomISBN(){
        Map<String, String> dizionarioGenere = Map.of(
                "thriller","00001",
                "giallo","00002",
                "horror","00003",
                "fantasy","00004",
                "scifi","00005",
                "romanzo","00006",
                "commedia","00007",
                "storico","00008",
                "romance","00009"
        );

        do {
            String isbn = "978-88-";

            isbn += dizionarioGenere.get(genere.name());
            isbn += "-";

            for (int i = 0; i < 2; i++) {
                int numeroLibroSpecifico = random.nextInt(0, 10);
                isbn += numeroLibroSpecifico;
            }
            isbn += "-";

            String soloCifre = isbn.replace("-", "");
            int somma = 0;
            for (int i = 0; i < soloCifre.length(); i++) {
                int cifra = Character.getNumericValue(soloCifre.charAt(i));
                if (i % 2 == 0) {
                    somma += cifra * 1;
                } else {
                    somma += cifra * 3;
                }
            }
            int resto = somma % 10;
            int cifraControllo = (10 - resto) % 10;
            isbn += cifraControllo;

        } while (listaISBN.contains(isbn));
        this.isbn = isbn;
        listaISBN.add(isbn);
    }
}
