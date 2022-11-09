public class Mestrando extends Usuario {
    int chave;

    public Mestrando(int idUsuario, int senha, int tipo, int chave) {
        super(idUsuario, senha, tipo);
        this.chave = chave;
    }
}