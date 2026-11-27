package Biblioteca;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class Biblioteca {
    private String nome;
    private String paese;
    private ArrayList<Libro> listaLibri;
    private Map<String,Boolean> libriprestati;

    public Biblioteca(String nome, String paese) {

        this.nome=checkNome(nome);

        this.paese=checkpaese(paese);

        listaLibri=new ArrayList<>();
        libriprestati=new HashMap<String,Boolean>();

    }




    private String checkNome(String nome){
        if (nome.isEmpty()){throw new IllegalArgumentException("nome inesistente");}
        else{return nome;}
    }
    private String checkpaese(String paese){
        if (paese.isEmpty()){throw new IllegalArgumentException("paese inesistente");}
        else{return paese;}
    }

    public void setNome(String nome) {
        this.nome=checkNome(nome);
    }

    public void setPaese(String paese) {
        this.paese = checkpaese(paese);
    }

    public String getNome() {return nome;}
    public String getPaese() {return paese;}
    public ArrayList<Libro> getListaLibri() {return listaLibri;}
    public Map<String, Boolean> getLibriprestati() {return libriprestati;}

    public void setLibriprestato(Libro libro, boolean valore) {
        if (checkLibroPresente(libro)) {
            if (checkPrestato(libro) == valore) {
                throw new IllegalArgumentException("ERRORE: libro già in prestito o libro già disponibile");
            } else {
                libriprestati.put(libro.getId(), valore);
            }
        }else{
            throw new IllegalArgumentException("libro non presente in biblioteca");
        }
    }
    public void addLibro(Libro libro,Log log) {
        listaLibri.add(libro);
        libriprestati.put(libro.getId(),false);
        log.AggiungiLog(Main.oggi+": aggiunto il libro "+ libro.getTitolo()+" alla biblioteca");

    }
    public boolean checkLibroPresente(Libro libro){
        if (libriprestati.containsKey(libro)){
            return listaLibri.contains(libro);
        }else{
            throw new IllegalArgumentException("libro non presente in biblioteca");
        }

    }

    public boolean checkPrestato(Libro libro){
        if (checkLibroPresente(libro)){
            return libriprestati.get(libro.getId());
        }else {
            throw new IllegalArgumentException("libro non presente");
        }
    }

    @Override
    public String toString() {
        String testo="";
        for (String cod: libriprestati.keySet()){
            boolean prestato=libriprestati.get(cod);
            testo+=cod+": "+((prestato)?"non disponibile":"disponibile")+"\n";
        }
        return "nome: "+nome+"\n"+ "paese: "+paese+"\n"+testo;
    }
}
