public class Tecnico extends Usuario {
    public int chave;

    public Tecnico(int idUsuario, int senha, int tipo, int chave) {
        super(idUsuario, senha, tipo);
        this.chave = chave;
    }
}