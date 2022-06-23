import java.util.ArrayList;
import java.util.HashMap;
import java.lang.Math;
import java.util.*;
import java.util.stream.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Cliente {
    private String nome;
    private String cpf;
    private String genero;
    private String dataNascimento;
    private ArrayList<Metrica> metricas;
    private Metrica meta;
    private TreeMap<String, Metrica> metricasTree = new TreeMap<String, Metrica>();
    
    public Cliente() {
        metricas = new ArrayList<>();
    }
    
    public boolean update(String nome, String genero, String dataNascimento) {
        this.nome = nome;
        this.genero = genero;
        this.dataNascimento = dataNascimento;
        return true;
    }
    
    public Metrica searchMetrica(String data) {
        return metricas.stream().filter(m->m.getData().equals(data)).findFirst().orElse(null);
    }
    
    public boolean addMetrica(double altura, double peso, double cintura, double biceps, double triceps, double peito, String data){
        if(searchMetrica(data)==null){
            Metrica m = new Metrica();
            m.setAltura(altura); 
            m.setPeso(peso); 
            m.setCintura(cintura); 
            m.setBiceps(biceps); 
            m.setTriceps(triceps); 
            m.setPeito(peito); 
            m.setData(data); 
            metricas.add(m);
            
            return true;
        }
        return false;
    }   
    
    public boolean attMetrica(double altura, double peso, double cintura, double biceps, double triceps, double peito, String data){
        Metrica m = searchMetrica(data);
        if(m!=null){
            m.update(altura, peso, cintura, biceps, triceps, peito);
            return true;
        }
        return false;
    }
    
    public boolean deleteMetrica(String data){
        Metrica m = searchMetrica(data);
        if(m!=null){
            metricas.remove(m);
            return true;    
        }
        return false;
    }
    
    public List<Metrica> ordenarMetricas(){
        this.metricas = new ArrayList<Metrica>(metricas.stream().sorted((d1, d2)->d1.getData().compareTo(d2.getData())).collect(Collectors.toList()));
        return metricas.stream().sorted((d1, d2)->d1.getData().compareTo(d2.getData())).collect(Collectors.toList());
    }
    
    public double imcAtual()
    {
        return metricaAtual().imc();
    }
    
    public double pesoAtual()
    {
        return metricaAtual().getPeso();
    }
    
    public double alturaAtual()
    {
        return metricaAtual().getAltura();
    }
    
    public double bicepsAtual()
    {
        return metricaAtual().getBiceps();
    }
    
    public double peitoralAtual()
    {
        return metricaAtual().getPeito();
    }
    
    public double pesoInicial()
    {
        return metricaInicial().getPeso();
    }

    public double alturaInicial()
    {
        return metricaInicial().getAltura();
    
    }
    
    public double bicepsInicial()
    {
        return metricaInicial().getBiceps();
    }
    
    public double peitoralInicial()
    {
        return metricaInicial().getPeito();
    }
    
    public double pesoVariacao()
    {
        return pesoAtual() - pesoInicial();
    }
    
    public double alturaVariacao()
    {
        return alturaAtual() - alturaInicial();
    }
    
    public double bicepsVariacao()
    {
        return bicepsAtual() - bicepsInicial();
    }
    
    public double peitoralVariacao()
    {
        return peitoralAtual() - peitoralInicial();
    }
    
    public Metrica metricaAtual()
    {
        ordenarMetricas();
        return metricas.get(metricas.size()-1);
    }
    
    public Metrica metricaInicial()
    {
        ordenarMetricas();
        return metricas.get(0);
    }
    
    public String forma()
    {
        if(imcAtual()<18.5) return "Baixo Peso";
        else if(imcAtual()>=18.5 && imcAtual()<25) return "Peso Normal";
        else if(imcAtual()>=25 && imcAtual()<30) return "Excesso de Peso";
        if(imcAtual()>=18.5 && imcAtual()<25) return "Obesidade";
        else return "Obesidade Extrema";
    } 
    
    public double desvioPeso()
    {
        int cont = 0;
        double desvioPadrao = 0;
        for(Metrica m:metricas){
            desvioPadrao += Math.pow(m.getPeso()-mediaPeso(), 2);
            cont++;
        }
        return Math.sqrt(desvioPadrao / (cont - 1));
    }
    
    public double mediaPeso()
    {
        return metricas.stream().mapToDouble(m->m.getPeso()).average().orElse(Double.NaN);
    }
    
    public String getNome(){
        return this.nome;
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public String getGenero(){
        return this.genero;
    }
    
    public void setGenero(String genero){
        this.genero = genero;
    }
    
    public String getDataNascimento(){
        return this.dataNascimento;
    }
    
    public void setDataNascimento(String dataNascimento){
        this.dataNascimento = dataNascimento;
    }
    
    public String getCpf(){
        return this.cpf;
    }
    
    public void setCpf(String cpf){
        this.cpf = cpf;
    }
    
    public ArrayList<Metrica> getMetricas(){
        return this.metricas;
    }
    
    public void setMetricas(ArrayList<Metrica> metricas){
        this.metricas = metricas;
    }
    
    public TreeMap<String, Metrica> getMetricasTree(){
        return this.metricasTree;
    }
    
    public void setMetricasTree(TreeMap<String, Metrica> metricasTree){
        this.metricasTree = metricasTree;
    }
    
    public Metrica getMeta(){
        return this.meta;
    }
    
    public void setMeta(Metrica meta){
        this.meta = meta;
    }
}
