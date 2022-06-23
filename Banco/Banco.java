import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Banco {
    private String nome;
    private ArrayList<Agencia> agencias;
    
    public Banco() {
        this.nome = nome;
        agencias = new ArrayList<>();
    }
    
    public double totalDinheiro() {
        return agencias.stream().mapToDouble(a->a.totalDinheiro()).sum();
    }
    
    public void rendimento() {
        agencias.stream().forEach(a->a.rendimento());
    }
    
    public String getNome() {
        return this.nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public ArrayList<Agencia> getAgencias() {
        return this.agencias;
    }
    
    public void setAgencias(ArrayList<Agencia> agencias) {
        this.agencias = agencias;
    }
}
