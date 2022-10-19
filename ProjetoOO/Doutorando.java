public class Doutorando extends Usuario {
    int chave;

    public Doutorando(int idUsuario, int senha, int tipo, int chave) {
        super(idUsuario, senha, tipo);
        this.chave = chave;
    }
}