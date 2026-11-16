package Biblioteca;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class Biblioteca {
    private String nome;
    private String paese;
    private ArrayList<String> listaLibri;
    private Map<String,Boolean> libriprestati;

    public Biblioteca(String nome, String paese) {
        if (nome.length()<5)
            throw new IllegalArgumentException("Il nome deve avere almeno 5 caratteri!");
        this.nome=nome;
        if (paese.length()<5)
            throw new IllegalArgumentException("Il nome del paese deve avere almeno 5 caratteri!");
        this.paese=paese;
        listaLibri=new ArrayList<>();
        libriprestati=new HashMap<String,Boolean>();

    }

    public String getNome() {return nome;}
    public String getPaese() {return paese;}
    public ArrayList<String> getListaLibri() {return listaLibri;}
    public Map<String, Boolean> getLibriprestati() {return libriprestati;}

    public void setLibriprestato(String codice, boolean valore) {
        if (checkLibroPresente(codice)) {
            if (checkPrestato(codice) == valore) {
                throw new IllegalArgumentException("non è cambiato nulla");
            } else {
                libriprestati.put(codice, valore);
            }
        }else{
            throw new IllegalArgumentException("libro non presente in biblioteca");
        }
    }
    public void addLibro(Libro libro,Log log) {
        listaLibri.add(libro.getId());
        libriprestati.put(libro.getId(),false);
        log.AggiungiLog("Nuovo libro! "+libro.getTitolo()+" di "+libro.getAutore()+"!");
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
