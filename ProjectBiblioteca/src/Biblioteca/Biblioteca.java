package Biblioteca;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class Biblioteca {
    private String nome;
    private String paese;
    private ArrayList<Libro> listaLibri;
    private Map<String,Boolean> libriprestati;

    public Biblioteca(String nome, String paese) {
        if (nome.length()<5)
            throw new IllegalArgumentException("Il nome deve avere almeno 5 caratteri!");
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

    public void setLibriprestato(String codice, boolean valore) {
        if (checkLibroPresente(codice)) {
            if (checkPrestato(codice) == valore) {
                throw new IllegalArgumentException("ERRORE: libro già in prestito o libro già disponibile");
            } else {
                libriprestati.put(codice, valore);
            }
        }else{
            throw new IllegalArgumentException("libro non presente in biblioteca");
        }
    }
    public void addLibro(Libro libro) {
        listaLibri.add(libro);
        libriprestati.put(libro.getId(),false);
    }
    public boolean checkLibroPresente(String codice){
        return listaLibri.contains(codice);
    }

    public boolean checkPrestato(String codice){
        if (checkLibroPresente(codice)){
            return libriprestati.get(codice);
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
