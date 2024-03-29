import java.util.HashMap;
import java.util.Map;
import java.util.*;
import java.util.stream.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Academia
{
    private String nome;
    private ArrayList<Cliente> clientes;
    private TreeMap<String, Cliente> clientesTree = new TreeMap<String, Cliente>();
    
    public Academia()
    {
        clientes = new ArrayList<>();
    }
    
    public HashMap<String, List<Cliente>> mapearClientes(){
        HashMap<String, List<Cliente>> formaClientes = new HashMap<String, List<Cliente>>();        
        formaClientes.put("Baixo Peso", clientes.stream().filter(c->c.forma().equals("Baixo Peso")).collect(Collectors.toList()));
        formaClientes.put("Normal", clientes.stream().filter(c->c.forma().equals("Normal")).collect(Collectors.toList()));
        formaClientes.put("Excesso de Peso", clientes.stream().filter(c->c.forma().equals("Excesso de Peso")).collect(Collectors.toList()));
        formaClientes.put("Obesidade", clientes.stream().filter(c->c.forma().equals("Obesidade")).collect(Collectors.toList()));
        formaClientes.put("Obesidade Extrema", clientes.stream().filter(c->c.forma().equals("Obesidade Extrema")).collect(Collectors.toList()));
        return formaClientes;
    }
    
    public Cliente pesquisar(String cpf) {
        return clientes.stream().filter(c->c.getCpf().equals(cpf)).findFirst().get();
    }
    
    public List<Cliente> aniversariantes(){
        return clientes.stream().filter(c->c.getDataNascimento().endsWith("/" + DateTimeFormatter.ofPattern("MM/dd")
        .format(LocalDateTime.now()))).collect(Collectors.toList());
    }
    
    public List<Cliente> mesAniversariantes(String mes){
        return clientes.stream().filter(c->c.getDataNascimento().endsWith("/" + mes + "/" + DateTimeFormatter.ofPattern("dd")
        .format(LocalDateTime.now()))).collect(Collectors.toList());
    }
    
    public List<Cliente> clientesPesoNormal() {
        return clientes.stream().filter(c->c.forma().equals("Peso Normal")).collect(Collectors.toList());
    }
    
    public List<Cliente> maiorPeitoral() {
        double maiorPeitoral = clientes.stream().max(Comparator.comparing(Cliente::peitoralAtual)).get().peitoralAtual();
        return clientes.stream().filter(c->c.peitoralAtual()==maiorPeitoral).collect(Collectors.toList());
    }
    
    public List<Cliente> melhoresVariacaoBiceps() {
        double melhorVariacaoBiceps = clientes.stream().max(Comparator.comparing(Cliente::bicepsVariacao)).get().bicepsVariacao();
        return clientes.stream().filter(c->c.bicepsVariacao()==melhorVariacaoBiceps).collect(Collectors.toList());
    }
    
    public boolean addCliente(String nome, String cpf, String genero, String dataNascimento) {
        Cliente c = new Cliente();
        c.setNome(nome);
        c.setCpf(cpf);
        c.setGenero(genero);
        c.setDataNascimento(dataNascimento);
        clientes.add(c);
        return true;
    }
    
    public boolean updateCliente(String cpf, String nome, String genero, String dataNascimento) {
        Cliente c = pesquisar(cpf);
        if(c!=null) {
            c.update(nome, genero, dataNascimento);
            return true;
        }
        return false;
    }
    
    public boolean excluirCliente(String cpf) {
        Cliente c = pesquisar(cpf);
        if(c!=null) {
            clientes.remove(c);
            return true;
        }
        return false;
    }
    
    public void ordenarMetricasClientes() {
        clientes.stream().forEach(c->c.ordenarMetricas());
    }
    
    public String getNome() {
        return this.nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public ArrayList<Cliente> getClientes() {
        return this.clientes;
    }
    
    public void setClientes(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }
    
    public TreeMap<String, Cliente> getClientesTree() {
        return this.clientesTree;
    }
    
    public void setClientesTree(TreeMap<String, Cliente> clientesTree) {
        this.clientesTree = clientesTree;
    }

    public double imcAcademia() {
        double media=0.0;
        int parcelas=0, i=0;
        
        while(i < clientes.size()) {
            if(clientes.get(i).imcAtual()!=-1){
                media+=clientes.get(i).imcAtual();
                parcelas++;
            } i++;
        }
        return parcelas==0?0: media/parcelas;
    }
    
    public HashMap classificaPesoClientes() {
        HashMap<String, List<Cliente>> pesoClientes = new HashMap<String, List<Cliente>>();
        pesoClientes.put("Baixo Peso", clientes.stream().filter(c->c.forma().equals("Baixo Peso")).collect(Collectors.toList()));
        pesoClientes.put("Peso Normal", clientes.stream().filter(c->c.forma().equals("Peso Normal")).collect(Collectors.toList()));
        pesoClientes.put("Excesso de Peso", clientes.stream().filter(c->c.forma().equals("Excesso de Peso")).collect(Collectors.toList()));
        pesoClientes.put("Obesidade", clientes.stream().filter(c->c.forma().equals("Obesidade")).collect(Collectors.toList()));
        pesoClientes.put("Obesidade Extrema", clientes.stream().filter(c->c.forma().equals("Obesidade Extrema")).collect(Collectors.toList()));
        
        return pesoClientes;
    }
    
    public HashMap mediaDesvioPesoClientes() {
        HashMap<String, ArrayList<Double>> metricasClientes = new HashMap<String, ArrayList<Double>>();
        
        for(Cliente cli:clientes) {
            metricasClientes.put(cli.getNome(), new ArrayList<>());
            metricasClientes.get(cli.getNome()).add(cli.desvioPeso()); 
            metricasClientes.get(cli.getNome()).add(cli.mediaPeso()); 
        }
        return metricasClientes;
    }
    
    public HashMap maioresAlturasPorGenero() {
        HashMap<String, ArrayList<Cliente>> generoAlturas = new HashMap<String, ArrayList<Cliente>>();
        double maiorAltura = 0;
        
        for(Cliente cli:clientes) {
            if(cli.metricaAtual().getAltura()>=maiorAltura){
                if(generoAlturas.get(cli.getGenero())!=null){
                    generoAlturas.get(cli.getGenero()).add(cli); 
                }else{
                    generoAlturas.put(cli.getGenero(), new ArrayList<>()); 
                    generoAlturas.get(cli.getGenero()).add(cli);    
                }
            }
        }
        return generoAlturas;
    }
    
    public HashMap clientesPorGenero() {
        HashMap<String, Integer> clientesGenero = new HashMap<String, Integer>();
    
        for(Cliente cli:clientes) {
            if(clientesGenero.get(cli.getGenero())!=null){
                clientesGenero.put(cli.getGenero(), clientesGenero.get(cli.getGenero())+1); 
            }else{
                clientesGenero.put(cli.getGenero(), 1); 
            }
        }
        return clientesGenero;
    }
}
