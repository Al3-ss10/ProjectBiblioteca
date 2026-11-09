package Biblioteca;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class Biblioteca {
    private String nome;
    private String paese;
    private Map<String, String> indexLibri;
    //<nome del libro, nome del lettore>

    Biblioteca(String nome, String paese) {
        if (nome.length()<5) throw new IllegalArgumentException("Il nome deve avere almeno 5 caratteri!");
        this.nome=nome;
        if (paese.length()<5) throw new IllegalArgumentException("Il nome del paese deve avere almeno 5 caratteri!");
        this.paese=paese;
        indexLibri=new HashMap<>();
    }

    String getNome() {return nome;}
    String getPaese() {return paese;}

    int getSize() {return indexLibri.size();}
    String getSpecifiedSize() {
        int counterThriller=0;
        int counterGiallo=0;
        int counterHorror=0;
        int counterFantasy=0;
        int counterSciFi=0;
        int counterRomanzo=0;
        int counterCommedia=0;
        int counterStorico=0;
        int counterRomance=0;
        /* for (Libro libro:listaLibri) {
            if (libro.getGenere().equals("thriller")) counterThriller++;
            if (libro.getGenere().equals("giallo")) counterGiallo++;
            if (libro.getGenere().equals("horror")) counterHorror++;
            if (libro.getGenere().equals("fantasy")) counterFantasy++;
            if (libro.getGenere().equals("scifi")) counterSciFi++;
            if (libro.getGenere().equals("romanzo")) counterRomanzo++;
            if (libro.getGenere().equals("commedia")) counterCommedia++;
            if (libro.getGenere().equals("storico")) counterStorico++;
            if (libro.getGenere().equals("romance")) counterRomance++;
        } */
        return indexLibri.size()+" libri, di cui:"+
            "\nThriller: "+counterThriller+" - Giallo: "+counterGiallo+
            "\nHorror: "+counterHorror+" - Fantasy: "+counterFantasy+
            "\nScifi: "+counterSciFi+" - Romanzo: "+counterRomanzo+
            "\nCommedia: "+counterCommedia+" - Storico: "+counterStorico+
            "\nRomance: "+counterRomance;
    }

    /* void prestaLibro(Libro libro, Lettore lettore) {
        if (listaLibri.get(listaLibri.indexOf(libro)).getInPrestito())
            throw new IllegalArgumentException("Libro già in prestito!");
        listaLibri.get(listaLibri.indexOf(libro)).setInPrestito(false);
        indexLibri.get(libro)
    }
    void restituisciLibro(Libro libro, Lettore lettore) {
        if (!listaLibri.get(listaLibri.indexOf(libro)).getInPrestito())
            throw new IllegalArgumentException("Il libro non è mai stato prestato!");
        listaLibri.get(listaLibri.indexOf(libro)).setInPrestito(true);
    }
    void addLibro(Libro libro) {
        indexLibri.put(libro.getTitolo(), libro.getAutore());
        IO.println("Nuovo libro! "+libro.getTitolo()+" di "+libro.getAutore()+"!");
    }

    @Override
    public String toString() {
        String libri=""; //qua ci aggiungiamo le informazioni su ogni libro
        String name="Nome: "+nome+"\nLibri:\n";
        for (Libro libro:) libri=libri.concat(
                "- "+libro.getTitolo()+" di "+libro.getAutore()+"(");
        return name+libri;
    } */
}
