package Biblioteca;
import java.util.ArrayList;


public class Log {
    private ArrayList<String> logs;

    public Log(){

        logs= new ArrayList<>();
    }
    ArrayList<String> getLog(){

        return logs;
    }
    public void AggiungiLog(String testo){

        logs.add(testo);
    }

    @Override
    public String toString() {
        String txt = "";
        for (String testo: logs){
            txt += testo + "\n";
        }
        return txt;
    }
}
