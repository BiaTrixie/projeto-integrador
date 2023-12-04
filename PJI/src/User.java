
public class User {

    private String nome;
    private String senha;

    public User(String nome, String senha) {
        this.nome = nome;
        this.senha = senha;
    }

    public boolean validarCredenciais(String nome, String senha) {
        return this.nome.equals(nome) && this.senha.equals(senha);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
