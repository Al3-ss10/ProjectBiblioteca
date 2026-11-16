package Biblioteca;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    void main() {
        Biblioteca biblioteca=new Biblioteca("Biblioteca Comunale", "Dalmine");

        Lettore lettore1=new Lettore("Alessio",17);
        Lettore lettore2=new Lettore("Luca",40);
        ArrayList<Lettore> listaLettori=new ArrayList<>(List.of(lettore1, lettore2));
        ArrayList<String> eventiRandom=new ArrayList<>(List.of(
                "Presta libro", "Restituisci libro", "Nuovo libro"
        ));
        Log log=new Log();

        Libro libro1=new Libro("It","Stephen King", GenereLibro.horror, 1998, 350);
        Libro libro2=new Libro("La compagnia dell'Anello", "J.R.R.Tolkien", GenereLibro.fantasy, 1987, 500);
        Libro libro3=new Libro("I Promessi Sposi", "Alessandro Manzoni", GenereLibro.romanzo, 1840, 370);
        ArrayList<Libro> listaLibri=new ArrayList<>(List.of(libro1, libro2, libro3));
        biblioteca.addLibro(libro1, log);
        biblioteca.addLibro(libro2, log);
        biblioteca.addLibro(libro3, log);

        Random random=new Random();
        IO.println("Benvenuto in "+biblioteca.getNome());

        boolean esci=false;
        while (!esci) {
            String evento=eventiRandom.get(random.nextInt(0, eventiRandom.size()));
            Lettore lettore=listaLettori.get(random.nextInt(0, listaLettori.size()));
            switch (evento) {
                case "Presta libro":
                    Libro libroP=listaLibri.get(random.nextInt(0, listaLibri.size()));
                    lettore.PrendiLibro(libroP,biblioteca,log);
                    IO.println(lettore+" prende in prestito "+libroP);
                    break;
                case "Restituisci libro":
                    try {
                        Libro libroR=listaLibri.get(random.nextInt(0, listaLibri.size()));
                        lettore.RestituisciLibro(libroR,biblioteca,log);
                        IO.println(lettore+" restituisce "+libroR);
                    }
                    catch (IllegalArgumentException IAE) {IO.println(IAE.getMessage());}
                    break;
                case "Nuovo libro":
                    IO.println("Tempo di aggiungere un nuovo libro!");
                    String titolo=IO.readln("Inserisci il titolo: ");
                    String autore=IO.readln("Inserisci l'autore: ");
                    IO.println("Thriller, Giallo, Horror,\nFantasy, Scifi, Romanzo,\nCommedia, Storico, Romance");
                    GenereLibro genere=GenereLibro.valueOf(IO.readln("Inserisci il genere: "));
                    int anno=Integer.parseInt(IO.readln("Inserisci l'anno di uscita: "));
                    if (anno>2026) throw new IllegalArgumentException("Non puoi inserire un libro che non è ancora uscito!");
                    int pagine=Integer.parseInt(IO.readln("Inserisci il numero di pagine: "));
                    if (pagine<=0) throw new IllegalArgumentException("Le pagine non possono essere negative!");

                    Libro newLibro=new Libro(titolo, autore, genere, anno, pagine);
                    biblioteca.addLibro(newLibro, log);
            }

            int scelta;
            do {
                scelta=menu();
                switch (scelta) {
                    case 0:
                        IO.println("Arrivederci!");
                        esci=true;
                        break;
                    case 1:
                        for (Lettore lett:listaLettori) {
                            lett.AggiornaTempo();
                        }
                        break;
                    case 2:
                        IO.println(biblioteca.toString());
                        break;
                    case 3:
                        IO.println(log.toString());
                        break;
                    default:
                        IO.println("Qualcosa è andato storto!");
                }
            } while (scelta!=0);
        }
    }

    int menu() {
        IO.println("1 - Passa al giorno successivo");
        IO.println("2 - Visualizza libri presi in prestito");
        IO.println("3 - Visualizza i log");
        IO.println("0 - Esci");
        while (true) {
            int scelta=Integer.parseInt(IO.readln("Cosa scegli? "));
            if (scelta<0 || scelta>3) throw new IllegalArgumentException("Scelta non valida!");
            return scelta;
        }
    }
}