public class Usuario {
    // atributos
    int idUsuario;
    int senha;
    int tipo;
    int coordenador;
    int bolsa = 0;
    String vigencia;
    // 1 - graduação, 2 - mestrado, 3 - doutorado, 4 - pesquisador, 5 -
    // profissional, 6 - tecnico

    public Usuario(int coordenador) {
        this.coordenador = coordenador;
    }

    Usuario(int idUsuario, int senha, int tipo) {
        this.idUsuario = idUsuario;
        this.senha = senha;
        this.tipo = tipo;
    }
}
