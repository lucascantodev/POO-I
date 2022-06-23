public class Item extends Produto
{
    private double quantidade;
    private Produto produto;
    private double preco;
    
    public Item(Produto product)
    {
        produto = product;
    }
    
    public double getQuantidade() {
        return quantidade;
    }
    
    public void setQuantidade(double quantidade){
        this.quantidade=quantidade;
    }
    
    public Produto getProduto(){
        return this.produto;
    }
    
    public void setProduto(Produto produto){
        this.produto = produto;
    }
    
    public double total(){
        return preco * quantidade;
    }
    
    public double getPreco(){
        return this.preco;
    }
    
    public void setPreco(double preco){
        this.preco = preco;
    }
}
