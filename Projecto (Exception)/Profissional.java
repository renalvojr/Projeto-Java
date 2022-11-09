public class Profissional extends Usuario {
    private int chave;

    public Profissional(int coordenador) {
        super(coordenador);
    }

    public Profissional(int idUsuario, int senha, int tipo, int chave) {
        super(idUsuario, senha, tipo);
        this.chave = chave;
    }

    public int conferirChave() {
        return chave;
    }

    // Método retornado o ID e tipo do usuário para a UI
    @Override
    public String mostrarUsuario() {
        return "Id do Profissional" + super.idUsuario + "   " + "Tipo: " + super.tipo;
    }
}
