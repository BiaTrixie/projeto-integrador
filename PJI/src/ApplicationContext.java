public class ApplicationContext {
    private static String usuarioLogado;
    private static String emailLogado;

    public static String getUsuarioLogado() {
        return usuarioLogado;
    }

    public static void setUsuarioLogado(String usuario, String email) {
        usuarioLogado = usuario;
        emailLogado = email;
    }

    public static String getEmailLogado() {
        return emailLogado;
    }
}
