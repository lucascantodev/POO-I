import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Conta {
    public String codigo;
    private String tipo;
    private double saldo;
    private double limite;
    private double taxa_manutencao;
    private double porc_rendimento;
    private String aniversario;
    private ArrayList<String> transacoes;
    
    void Conta(String codigo, String tipo) {
        this.saldo = 0;
        this.tipo = tipo;
        this.codigo = codigo;
    }
    
    public boolean sacar(double valor) {
        if(valor > 0 & ((this.saldo + this.limite)>= valor)){
            this.saldo -= valor;
            transacoes.add("Data: " + LocalDateTime.now() + "/ Saque: -R$" + valor + " Saldo: R$" + saldo);
            return true;
        }
        return false;
    }
    
    public boolean depositar(double valor) {
        this.saldo += valor;
        transacoes.add("Data: " + LocalDateTime.now() + "/ Depósito: +R$" + valor + " Saldo: R$" + saldo);
        return true;
    }
    
    public boolean transferir(double valor, Conta contaDestino) {
        if(valor<=saldo+limite){
            saldo -= valor;
            contaDestino.saldo += valor;
            contaDestino.depositar(valor);
            transacoes.add("Data: " + LocalDateTime.now() + "/ Transferência Enviada: -R$" + valor + " Saldo: R$" + saldo);
            contaDestino.transacoes.add("Data: " + LocalDateTime.now() + "/ Transferência Recebida: +R$" + valor + " Saldo: R$" + saldo);
            return true;
        }
        return false;
    }
    
    public boolean render() {
        saldo += saldo*porc_rendimento;
        transacoes.add("Data: " + LocalDateTime.now() + " / Rendimento: +R$" + taxa_manutencao + " Saldo: R$" + saldo);
        return true;
    }
    
    public boolean manutencao() {
        saldo -= taxa_manutencao;
        if(transacoes.stream().filter(t->t.startsWith("Data: "+ DateTimeFormatter.ofPattern("yyyy-MM-dd").format(LocalDateTime.now()))
         && t.contains("Taxa de Manutenção")).collect(Collectors.toList()).size()<1){
            transacoes.add("Data: " + LocalDateTime.now() + " / Taxa de Manutenção: -R$" + taxa_manutencao + " Saldo: R$" + saldo);
            return true;
        }
        return false;
    }
    
    public double getLimite() {
        return this.limite;
    }
    
    public void setLimite(double limite) {
        this.limite = limite;
    }
    
    public double getTaxa_manutencao() {
        return this.taxa_manutencao;
    }
    
    public void setTaxa_manutencao(double taxa_manutencao) {
        this.taxa_manutencao = taxa_manutencao;
    }
    
    public double getPorc_rendimento() {
        return this.porc_rendimento;
    }
    
    public void setPorc_rendimento(double porc_rendimento) {
        this.porc_rendimento = porc_rendimento;
    }
    
    public String getAniversario() {
        return this.aniversario;
    }
    
    public void setAniversario(String aniversario) {
        this.aniversario = aniversario;
    }
    
    public ArrayList<String> getTransacoes() {
        return this.transacoes;
    }
    
    public double getSaldo() {
        return this.saldo;
    }
    
    public String getTipo(){
        return this.tipo;
    }
    
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    public String getCodigo() {
        return this.codigo;
    }
    
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    
    public boolean ehVelhaco() {
        return (saldo<0) ? true : false;
    }
}
