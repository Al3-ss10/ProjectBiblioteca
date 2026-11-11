package Biblioteca;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.time.LocalDate;

public class Biblioteca {
    private String nome;
    private String paese;
    private ArrayList<Libro> listaLibri;
    /*dizionario con valori booleani (libro prestato o no)
    ogni lettore prende un libro dalla biblioteca*/

    Biblioteca(String nome, String paese) {
        if (nome.length()<5)
            throw new IllegalArgumentException("Il nome deve avere almeno 5 caratteri!");
        this.nome=nome;
        if (paese.length()<5)
            throw new IllegalArgumentException("Il nome del paese deve avere almeno 5 caratteri!");
        this.paese=paese;
    }

    String getNome() {return nome;}
    String getPaese() {return paese;}

    void prestaLibro(Libro libro, Lettore lettore) {
        if (!listaLibri.contains(libro))
            throw new IllegalArgumentException("Non abbiamo quel libro!");
        if (listaLibri.get(listaLibri.indexOf(libro)).getInPrestito())
            throw new IllegalArgumentException("Libro già in prestito!");

        listaLibri.get(listaLibri.indexOf(libro)).setInPrestito(false);
    }
    void restituisciLibro(Libro libro, Lettore lettore) {
        if (!listaLibri.get(listaLibri.indexOf(libro)).getInPrestito())
            throw new IllegalArgumentException("Il libro non è mai stato prestato!");
        listaLibri.get(listaLibri.indexOf(libro)).setInPrestito(true);
    }
    void addLibro(Libro libro) {
        listaLibri.add(libro);
        IO.println("Nuovo libro! "+libro.getTitolo()+" di "+libro.getAutore()+"!");
    }

    @Override
    public String toString() {
        String libri=""; //qua ci aggiungiamo le informazioni su ogni libro
        String name="Nome: "+nome+"\nLibri:\n";
        for (Libro libro:listaLibri) libri=libri.concat(
                "- "+libro.getTitolo()+" di "+libro.getAutore()+"("+libro.getAnno()+")\n");
        return name+libri;
    }
}
 