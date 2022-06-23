import java.util.ArrayList;
import java.util.Random;

public class Calculos
{
    Random random = new Random();
    
    public Calculos()
    {
        
    }
    
    public Estado montarTudo()
    {
        Estado e = criarEstado();
        e.setCidades(criarCidades(2));
        for (Cidade c: e.getCidades()){
            c.setEscolas(criarEscolas(5));
            for (Escola escola: c.getEscolas()){
                escola.setEstudantes(criarEstudantes(10));
            }
        }
        return e;
    }
    
    public Cidade[] criarCidades(int num)
    {
        Cidade[] cidades = new Cidade[num];
        for (int i=0; i<cidades.length; i++){
            cidades[i] = new Cidade();
            cidades[i].setNome("Cidade " +i); 
        }
        return cidades;
    }
    
    public Escola[] criarEscolas(int num)
    {
        Escola[] escolas = new Escola[num];
        for (int i=0; i<escolas.length; i++){
            escolas[i] = new Escola();
            escolas[i].setNome("Escola " +i); 
        }
        return escolas;
    }

    public ArrayList<Estudante> criarEstudantes(int num)
    {
        ArrayList<Estudante> estudantes = new ArrayList<>();
        for (int i=0; i<num; i++){
            Estudante e = new Estudante();
            e.setCpf("00000" + (i+1));
            e.setNivelDeLeitura(random.nextInt(11));
            estudantes.add(e);
        }
        return estudantes;
    }
    
    public Estado criarEstado()
    {
        Estado e = new Estado();
        e.setNome("Estado " + (random.nextInt(28)+1));
        return e;
    }
}
