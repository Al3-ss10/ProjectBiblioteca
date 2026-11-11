package Biblioteca;
import java.util.ArrayList;


public class Log {
    ArrayList<String> logs;

    Log(){
        logs= new ArrayList<>();
    }
    ArrayList getLog(){
        return logs;
    }
    void AggiungiLog(String testo){
        logs.add(testo);
    }

    @Override
    public String toString() {
        String txt = "";
        for (String testo: logs){
            txt = txt + testo + "\n";
        }
        return txt;
    }
}
