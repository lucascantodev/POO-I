import java.util.Random;
import java.util.ArrayList;

public class MercadoTeste
{
    Random random = new Random();
    ArrayList<Produto> produtos = criarProdutos(100);
    
    public Rede montarTudo()
    {
        Rede r = criarRede();
        r.setMercados(criarMercados(5));
        return r;
    }

    public ArrayList<Venda> criarVendas(int num)
    {
        ArrayList<Venda> vendas = new ArrayList<>();
        for (int i=0; i<num; i++){
            Venda v = new Venda();
            v.setData("10/0"+ (random.nextInt(9)+1) + "/2022");
            v.setItens(criarItens(3));
            vendas.add(v);
        }
        return vendas;
    }
    
    public ArrayList<Produto> criarProdutos(int num)
    {
        ArrayList<Produto> prod = new ArrayList<Produto>();
        for (int i=0; i<num; i++){
            Produto pr = new Produto();
            pr.setDescricao("Produto "+(i+1));
            pr.setPreco((i+1) * 0.5);
            prod.add(pr);
    }
        return prod;
    }
    
    public ArrayList<Item> criarItens(int num)
    {

        ArrayList<Item> itens = new ArrayList<>();
        for (int i=0; i<num; i++){
            Produto p = produtos.get(random.nextInt(produtos.size()));
            Item item = new Item(p);
            item.setQuantidade(1.0);
            item.setPreco(p.getPreco());
            itens.add(item);
            p.setVendas(p.getVendas()+item.getQuantidade());
        }
        return itens;
    }
    
    public ArrayList<Mercadinho> criarMercados(int num)
    {
        ArrayList<Mercadinho> mercado = new ArrayList<>();
        for (int i=0; i<num; i++){
            Mercadinho mec = new Mercadinho();
            mec.setNome("Mercadinho "+(i+1));
            mec.setVendas(criarVendas(5));
            mercado.add(mec);
        }
        return mercado;
    }
    
    public Rede criarRede()
    {
        Rede r = new Rede();
        r.setNome("Rede de Mercadinhos");
        return r;
    }
}
