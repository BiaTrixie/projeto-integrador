
public class Cliente {
    private String cnpj;
    private String email;
    private String nomeCompleto;
    private String senha;
    private String usuario;

    public Cliente(String cnpj, String email, String nomeCompleto, String senha, String usuario) {
        this.cnpj = cnpj;
        this.email = email;
        this.nomeCompleto = nomeCompleto;
        this.senha = senha;
        this.usuario = usuario;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public boolean validarCredenciais(String usuarioDigitado, String senhaDigitada) {
        return this.usuario.equals(usuarioDigitado) && this.senha.equals(senhaDigitada);
    }
   
}
