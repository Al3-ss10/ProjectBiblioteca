package Biblioteca;
import java.util.ArrayList;

public class Biblioteca {
    private String nome;
    private String paese;
    private ArrayList<Libro> lista;

    Biblioteca(String nome, String paese) {
        if (nome.length()<5) throw new IllegalArgumentException("Il nome deve avere almeno 5 caratteri!");
        this.nome=nome;
        if (paese.length()<5) throw new IllegalArgumentException("Il nome del paese deve avere almeno 5 caratteri!");
        this.paese=paese;
        lista=new ArrayList<>();
    }

    String getNome() {return nome;}
    String getPaese() {return paese;}
    ArrayList<Libro> getLista() {return lista;}

    int getSize() {return lista.size();}
    /* String getSpecifiedSize() {
        int counterThriller=0;
        int counterGiallo=0;
        int counterHorror=0;
        int counterFantasy=0;
        int counterSciFi=0;
        int counterRomanzo=0;
        int counterCommedia=0;
        int counterStorico=0;
        int counterRomance=0;
        for (Libro libro:lista) {
            if (libro.getGenere().equals("thriller")) counterThriller++;
            if (libro.getGenere().equals("giallo")) counterGiallo++;
            if (libro.getGenere().equals("horror")) counterHorror++;
            if (libro.getGenere().equals("fantasy")) counterFantasy++;
            if (libro.getGenere().equals("scifi")) counterSciFi++;
            if (libro.getGenere().equals("romanzo")) counterRomanzo++;
            if (libro.getGenere().equals("commedia")) counterCommedia++;
            if (libro.getGenere().equals("storico")) counterStorico++;
            if (libro.getGenere().equals("romance")) counterRomance++;
        }
        return lista.size()+" libri, di cui: "+
            "\nThriller: "+counterThriller+" - Giallo: "+counterGiallo+
            "\nHorror: "+counterHorror+" - Fantasy: "+counterFantasy+
            "\nScifi: "+counterSciFi+" - Romanzo: "+counterRomanzo+
            "\nCommedia: "+counterCommedia+" - Storico: "+counterStorico+
            "\nRomance: "+counterRomance;
    }

    void prestaLibro(Libro libro) {
        if (lista.indexOf(libro).isInPrestito()) throw new IllegalArgumentException("Libro già in prestito!");
        lista.indexOf(libro).isInPrestito()=false
    }
    void restituisciLibro(Libro libro) {
        if (!lista.indexOf(libro).isInPrestito()) throw new IllegalArgumentException("Il libro non è mai stato prestato!");
        lista.indexOf(libro).isInPrestito()=true;
    } */

    void addLibro(Libro libro) {
        lista.add(libro);
        IO.println("Nuovo libro! /*titolo*/ di /*autore*/ !");
    }

    /* @Override
    public String toString() {
        String str;
        for (Libro libro:lista) str+=libro.getNome()+" - "+libro.getAutore()+"\n";
        return "Nome: "+nome+"\nLibri: "+str;
    } */
}
