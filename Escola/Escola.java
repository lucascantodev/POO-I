import java.util.ArrayList;
public class Escola
{
    private String nome;
    private ArrayList<Estudante> estudantes;
    
    public Escola()
    {
        
    }
    
    public String getNome(){
        return this.nome;
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public ArrayList<Estudante> getEstudantes(){
        return this.estudantes;
    }
    
    public void setEstudantes(ArrayList<Estudante> estudantes){
        this.estudantes = estudantes;
    }
    
    public double media(){
        double soma = 0;
        for(Estudante e:estudantes){
            soma+=e.getNivelDeLeitura();
        }
        
        return soma/estudantes.size();
    }
    
    public ArrayList<Estudante> acimaDaMedia(double media){
        ArrayList<Estudante> acimaDaMedia = new ArrayList<>();
        for(Estudante e:estudantes){
            if(e.getNivelDeLeitura()>media) acimaDaMedia.add(e);
        }
        return acimaDaMedia;
    }
    
    public ArrayList<Estudante> acimaDaMedia(){
        ArrayList<Estudante> acimaDaMedia = new ArrayList<>();
        for(Estudante e:estudantes){
            if(e.getNivelDeLeitura()>media()) acimaDaMedia.add(e);
        }
        return acimaDaMedia;
    }
}
