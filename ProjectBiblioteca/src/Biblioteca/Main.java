package Biblioteca;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    static LocalDate oggi = LocalDate.now();
    void main() {

        Biblioteca biblioteca=new Biblioteca("Biblioteca Comunale", "Dalmine");
        Log log=new Log();
        Random random=new Random();
        IO.println("Benvenuto in "+biblioteca.getNome()+"\n");

        Lettore lettore1=new Lettore("Alessio",17);
        Lettore lettore2=new Lettore("Luca",40);
        ArrayList<Lettore> listaLettori=new ArrayList<>(List.of(lettore1, lettore2));
        ArrayList<String> eventiRandom=new ArrayList<>(List.of(
                "Presta libro", "Restituisci libro", "Nuovo libro"
        ));

        Libro libro1=new Libro("It","Stephen King", GenereLibro.horror, 1998, 350);
        Libro libro2=new Libro("La compagnia dell'Anello", "J.R.R.Tolkien", GenereLibro.fantasy, 1987, 500);
        Libro libro3=new Libro("I Promessi Sposi", "Alessandro Manzoni", GenereLibro.romanzo, 1840, 370);
        biblioteca.addLibro(libro1,log);
        biblioteca.addLibro(libro2,log);
        biblioteca.addLibro(libro3,log);

        boolean esci=false;
        while (!esci) {
            String evento=eventiRandom.get(random.nextInt(0, eventiRandom.size()));
            Lettore lettore=listaLettori.get(random.nextInt(0, listaLettori.size()));
            switch (evento) {
                case "Presta libro":
                    if (biblioteca.getListaLibri().isEmpty()) {
                        IO.println("La lista dei libri è vuota!");
                    } else {
                        IO.println("Evento - Presa in prestito di un libro!");
                        Libro libroP=biblioteca.getListaLibri().get(
                                random.nextInt(0, biblioteca.getListaLibri().size()
                                ));
                        IO.println(lettore.getNome()+" prende in prestito "+libroP.getTitolo()+"\n");
                        if (biblioteca.getListaLibri().contains(libroP)) {
                            lettore.PrendiLibro(libroP,biblioteca,log);
                            biblioteca.getListaLibri().remove(libroP);
                        } else IO.println(libroP.getTitolo()+" non è presente!");
                    }
                    break;

                case "Restituisci libro":
                    IO.println("Evento - Restituzione di un libro!");
                    if (lettore.getLibri().isEmpty()) {
                        IO.println("Il lettore non ha alcun libro da restituire!\n");
                    } else {
                        try {
                            //lista contenente i libri del lettore, si prende per l'evento casuale
                            Libro libroR=new ArrayList<>(lettore.getLibri().keySet()).get(
                                    random.nextInt(0, lettore.getLibri().size()
                                    ));
                            IO.println("Evento - "+lettore.getNome()+" restituisce "+libroR.getTitolo()+"\n");
                            lettore.RestituisciLibro(libroR,biblioteca,log);
                            biblioteca.getListaLibri().add(libroR); //così si aggiornano bene quando un libro è prestato

                        }
                        catch (IllegalArgumentException IAE) {IO.println(IAE.getMessage());}
                    }
                    break;

                case "Nuovo libro":
                    IO.println("Evento - Viene aggiunto un nuovo libro!");
                    String titolo=IO.readln("Inserisci il titolo: ");
                    String autore=IO.readln("Inserisci l'autore: ");
                    IO.println("\nThriller, Giallo, Horror,\nFantasy, Scifi, Romanzo,\nCommedia, Storico, Romance");

                    boolean continua=false;
                    GenereLibro genere=null;
                    while (!continua){
                        try {
                            genere=GenereLibro.valueOf(IO.readln("Inserisci il genere: ").toLowerCase());
                            continua=true;
                        } catch (IllegalArgumentException IAE) {IO.println("Non esiste questo genere!");}
                    }
                    int anno=0;
                    continua=false;
                    while (!continua) {
                        try {
                            anno=Integer.parseInt(IO.readln("Inserisci l'anno di uscita: "));
                            continua=true;
                        } catch (IllegalArgumentException IAE) {IO.println(IAE.getMessage());}
                    }
                    int pagine=0;
                    continua=false;
                    while (!continua) {
                        try {
                            pagine=Integer.parseInt(IO.readln("Inserisci il numero di pagine: "));
                            continua=true;
                        } catch (IllegalArgumentException IAE) {IO.println(IAE.getMessage());}
                    }

                    Libro newLibro=new Libro(titolo, autore, genere, anno, pagine);
                    biblioteca.addLibro(newLibro,log);
                    IO.println("Libro aggiunto!\n");
                    break;
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
                       oggi=oggi.plusDays(1);
                        break;
                    case 2:
                        IO.println(biblioteca.toString());
                        break;
                    case 3:
                        if (log.toString().isBlank()) {
                            IO.println("Nessun log registrato!\n");
                        }
                        else IO.println(log.toString());
                        break;
                    default:
                        IO.println("Qualcosa è andato storto!\n");
                        break;
                }
            } while (scelta>1);
        }
    }

    int menu() {
        IO.println("1 - Passa al giorno successivo");
        IO.println("2 - Visualizza libri");
        IO.println("3 - Visualizza i log");
        IO.println("0 - Esci");
        while (true) {
            int scelta = -1;
            boolean continua=false;
            while (!continua) {
            try {
                scelta=Integer.parseInt(IO.readln("Cosa scegli? "));
                continua=true;
            }catch (NumberFormatException IAE) {
                    IO.println(IAE.getMessage());}
            }
            if (scelta<0 || scelta>3) IO.print("Scelta non valida! ");
            else return scelta;
        }
    }
}
