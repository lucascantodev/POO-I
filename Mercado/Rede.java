import java.util.ArrayList;

public class Rede
{
    private String nome;
    private ArrayList <Mercadinho> mercados;
    
    public Rede()
    {
        nome = "Carrefour";
    }
    
    public ArrayList<Mercadinho> getMercados(){
        return this.mercados;
    }
    
    public void setMercados(ArrayList<Mercadinho> mercados){
        this.mercados = mercados;
    }
    
    public String getNome(){
        return this.nome;
    }
    
    public void setNome(String nome){
        this.nome = nome;
    } 
    
    public double total(){
        double soma = 0;
        for(Mercadinho m:mercados){
            soma+=m.total();
        }
        
        return soma;
    }
    
    public double total(String data){ 
        double soma = 0;
        for(Mercadinho m:mercados){
            soma+=m.total(data);
        }
        
        return soma;
    }
}
