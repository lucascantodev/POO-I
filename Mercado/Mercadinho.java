import java.util.ArrayList;

public class Mercadinho
{
    private ArrayList <Venda> vendas;
    private String nome;
    
    public Mercadinho()
    {
        
    }
    
    public ArrayList<Venda> getVendas(){
        return this.vendas;
    }
    
    public void setVendas(ArrayList<Venda> vendas){
        this.vendas = vendas;
    }
    
    public String getNome(){
        return this.nome;
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public double total(String data)
    {
        double soma=0;
        for (Venda v:vendas){
            if(data.equals(v.getData())){
                soma+=v.total();
            }
        }
        
        return soma;
    }
    
    public double total(){
        double soma = 0;
        for(Venda v:vendas){
            soma+=v.total();
        }
        
        return soma;
    }
}
