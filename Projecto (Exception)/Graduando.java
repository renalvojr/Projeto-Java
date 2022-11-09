public class Graduando extends Usuario {
    int chave;

    public Graduando(int idUsuario, int senha, int tipo, int chave) {
        super(idUsuario, senha, tipo);
        this.chave = chave;
    }
}