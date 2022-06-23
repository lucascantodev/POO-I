import java.util.ArrayList; 
public class SerieDeLucas
{
    final int p,q;
    ArrayList<Integer> numeros;
    
    public SerieDeLucas(int p, int q)
    {
        this.p = p;
        this.q = q;
        numeros = new ArrayList<Integer>();
        
        numeros.add(0);
        numeros.add(1);
    }
    
    public int proxTermo()
    {   //Xn = p*Xn-1 - q*Xn-2
        int termo = p*(numeros.get(numeros.size()-1)) - q*(numeros.get(numeros.size()-2));        
        numeros.add(termo);
        return termo;
    }
    
    public int saltarTermo(int n){
        int index = n-1;
        while(numeros.size() < n){
            proxTermo();
        }
        return numeros.get(index);
    }
    
    public ArrayList<Integer> getNumeros(){
        return numeros;
    }
}