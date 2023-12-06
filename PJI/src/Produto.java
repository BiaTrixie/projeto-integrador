public class Produto {
    private String codigo;
    private String descricao;
    private String nome;
    private double valorProduto;
    private double valorRevenda;
    private int clienteId;
    

    public int getClienteId() {
        return clienteId;
    }

    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
    }
    
    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public double getValorProduto() {
        return valorProduto;
    }
    public void setValorProduto(double valorProduto) {
        this.valorProduto = valorProduto;
    }
    public double getValorRevenda() {
        return valorRevenda;
    }
    public void setValorRevenda(double valorRevenda) {
        this.valorRevenda = valorRevenda;
    }

    
}
