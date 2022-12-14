public class Pesquisador extends Usuario {
    int chave;

    public Pesquisador(int coordenador) {
        super(coordenador);
    }

    public Pesquisador(int idUsuario, int senha, int tipo, int chave) {
        super(idUsuario, senha, tipo);
        this.chave = chave;
    }
}