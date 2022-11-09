public class Usuario {

    // atributos
    int idUsuario;
    int senha;
    int tipo;// 1 - graduação, 2 - mestrado, 3 - doutorado, 4 - pesquisador, 5 -
             // profissional, 6 - tecnico
    int coordenador;
    int bolsa = 0;
    String vigencia;

    public Usuario(int coordenador) {
        this.coordenador = coordenador;
    }

    public Usuario(int idUsuario, int senha, int tipo) {
        this.idUsuario = idUsuario;
        this.senha = senha;
        this.tipo = tipo;
    }

    // Método retornado o ID e tipo do usuário para a UI
    public String mostrarUsuario() {
        return "Id do Profissional" + idUsuario + "   " + "Tipo: " + tipo;
    }
}
