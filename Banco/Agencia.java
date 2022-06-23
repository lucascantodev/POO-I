import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Agencia {
    private String codigo;
    private ArrayList<Conta> contas;
    
    void Agencia(String codigo) {
        this.codigo = codigo;
        contas = new ArrayList<>();
    }
    
    public Conta pesquisar(String codigo) {
        return contas.stream().filter(c->c.getCodigo()==codigo).findFirst().get();
    }
    
    public double totalDinheiro() {
        return contas.stream().mapToDouble(c->c.getSaldo()).sum();
    }
    
    public void cobrarManutencao() {
        contas.stream().forEach(c->c.manutencao());
    }
    
    public void cobrarManutencaoContaCorrente() {
        contas.stream().filter(c->c.getTipo().equals("Conta Corrente")).forEach(c->c.manutencao());
    }
    
    public List<Conta> velhacos() {
        return contas.stream().filter(c->c.ehVelhaco()).collect(Collectors.toList());
    }
    
    public List<Conta> aniversariantes() {
        return contas.stream().filter(c->c.getAniversario().startsWith(DateTimeFormatter.ofPattern("dd").format(LocalDateTime.now()) + "/")).collect(Collectors.toList());
    }
    
    public void rendimento() {
        aniversariantes().stream().filter(c->c.getTipo().equals("Conta Poupança")).forEach(c->c.render());
    }
    
    public double totalCredores() {
        return contas.stream().filter(c->!c.ehVelhaco()).mapToDouble(c->c.getSaldo()).sum();
    }
    
    public List<Conta> contas(String[] codigos) {
        return Arrays.asList(codigos).stream().map(c->pesquisar(c)).collect(Collectors.toList());
    }
    
    public double mediaSaldo() {
        return contas.stream().mapToDouble(c->c.getSaldo()).average().orElse(Double.NaN);
    }
    
    public HashMap<String, List<Conta>> LocalizarContas() {
        HashMap<String, List<Conta>> contasDevedoras = new HashMap<String, List<Conta>>();        
        contasDevedoras.put("Devedoras", contas.stream().filter(c->c.ehVelhaco()).collect(Collectors.toList()));
        contasDevedoras.put("Não Devedoras", contas.stream().filter(c->!c.ehVelhaco()).collect(Collectors.toList()));
        return contasDevedoras;
    }
    
    public boolean depositar(String codigo, double valor) {
        if(pesquisar(codigo).depositar(valor)) return true;
        return false;
    }
    
    public boolean transferir(String contaOrigem, String contaDestino, double valor) {
        if(pesquisar(contaOrigem).transferir(valor, pesquisar(contaDestino))) return true;
            return false;
    }
    
    public boolean sacar(String codigo, double valor) {
        if(pesquisar(codigo).sacar(valor)) return true;
        return false;
    }

    public ArrayList<String> getExtrato(String codigo) {
        return pesquisar(codigo).getTransacoes();
    }
    
    public String getCodigo() {
        return this.codigo;
    }
    
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    
    public ArrayList<Conta> getContas() {
        return this.contas;
    }
    
    public void setContas(ArrayList<Conta> contas) {
        this.contas = contas;
    }
}