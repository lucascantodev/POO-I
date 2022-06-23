import java.util.ArrayList;
public class Venda
{
    private String data;
    private ArrayList <Item> itens;
    
    public Venda()
    {
        
    }
    
    public String getData(){
        return this.data;
    }
    
    public void setData(String data){
        this.data = data;
    }
    
    public ArrayList<Item> getItens(){
        return this.itens;
    }
    
    public void setItens(ArrayList<Item> itens){
        this.itens = itens;
    }
    
    public double total(){
        double soma=0 ;
        for(Item i:itens){
            soma+=i.total();    
        }
        return soma;
    }
}
