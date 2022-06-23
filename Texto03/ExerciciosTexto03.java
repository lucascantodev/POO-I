import java.util.Date;
import java.text.SimpleDateFormat;
import java.io.File;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;

public class ExerciciosTexto03
{
    public ExerciciosTexto03() 
    {
            
    }
    
    public String exercicio3_1()
    {
        Date dataAtual = new Date();
        String data = new SimpleDateFormat("dd/MM/yyyy").format(dataAtual);
        return "" + new Date();
    }
    
    public String exercicio3_2(String data) throws Exception
    {
        return new SimpleDateFormat("EEEE, dd, MMM, yyyy").format(new SimpleDateFormat("dd/MM/yyyy"));
    }
    
    public String[] exercicio3_3(String diretorio)
    {
        if (new File(diretorio).exists()) {
            return new File(diretorio).list();
        } else {
            return new String[]{null};
        }
    }
    
    public String[] exercicio3_4(String diretorio) 
    {
        File caminho = new File(diretorio);
        
        if (caminho.exists()) {
            String[] itens = caminho.list();
            for (int i=0; i<itens.length; i++) {
                if (new File(caminho.getPath() + "/" + itens[i]).isDirectory()) {
                    itens[i] = "[D]" + itens[i];
                } else {
                    itens[i] = "[A]" + itens[i];
                }
            }
            return itens;
        }
        return new String[] {null};
    }
    
    public boolean exercicio3_5(String caminhoParametro)
    {
        File arquivo = new File(caminhoParametro);
        if (arquivo.exists()) {
            arquivo.delete();
            return true;
        } else {
            return false;
        }
    }
    
    public void exercicio3_6() 
    {
        JFrame jframe = new JFrame();
        jframe.setTitle("Janela Com 2 Arquivos");
        jframe.setSize(300, 300);
        
        JMenuBar menuBar = new JMenuBar();
        jframe.setJMenuBar(menuBar);
        menuBar.add(new JMenu("Arquivo"));
        menuBar.add(new JMenu("Editar"));
        
        jframe.setVisible(true);
    }
    
    public boolean exercicio3_7(String caminhoParametro)
    {
        File arquivo = new File(caminhoParametro);
        try {
            if (arquivo.exists()) {
                Runtime.getRuntime().exec(new String[] {"notepad", caminhoParametro});
                return true;
            } else {
                return false;
            }
        }
        catch (Exception e) {
            return false;
        }
    }
    
    public boolean exercicios3_8(String caminhoParametro)
    {
        File arquivo = new File(caminhoParametro);
        
        try {
            if(arquivo.exists()) {
                Runtime.getRuntime().exec(new String[]{caminhoParametro});
                return true;
            } else {
                return false;
            }
        }
        catch (Exception e) {
            return false;
        }
    }
    
    public void exercicio3_9()
    {
        JFrame jframe = new JFrame();
        jframe.setTitle("Janela Vazia");
        jframe.setExtendedState(jframe.MAXIMIZED_BOTH);
        jframe.setVisible(true);
    }
    
    public String exercicio3_10(String primeiraData, String segundaData) throws Exception
    {
        String data = new SimpleDateFormat("dd/MM/yyyy").format(primeiraData);
        String data2 = new SimpleDateFormat("dd/MM/yyyy").format(segundaData);
        
        if (primeiraData.compareTo(segundaData)>0) {
            return primeiraData;
        } else {
            return segundaData;
        }
    }
    
    public String[] exercicio3_11(String[] datas) throws Exception
    {
        Date[] dates = new Date[datas.length];
        for(int i=0; i<datas.length; i++){
            dates[i] = new SimpleDateFormat("dd/MM/yyyy").parse(datas[i]);
            Date k = dates[i];
            String ks = datas[i];
            int j = i-1;
            while(j>=0 && dates[j].compareTo(k)>0){
                dates[j+1] = dates[j];
                datas[j+1] = datas[j];
                j = j-1;
            }
            dates[j+1] = k;
            datas[j+1] = ks;
        }
        
        return datas;
    }
    
    public String exercicio3_12(String data) throws Exception
    {
        return new SimpleDateFormat("EEEE").format(new SimpleDateFormat("dd/MM/yyyy").parse(data));
    }
}