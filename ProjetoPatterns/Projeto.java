import java.util.ArrayList;

public class Projeto {
    // atributos
    public Projeto() {
        dados = new Dados();
    }

    public Dados dados;

    int idProjeto;

    /*
     * String descricao;
     * String dataInicio;
     * String dataTermino;
     */

    String coordenador;
    public ArrayList<Integer> idProfissionais = new ArrayList<Integer>();
    String status = "Em processo de criação";

    /*
     * public Projeto(int idProjeto, String descricao, String dataInicio, String
     * dataTermino, String coordenador) {
     * this.idProjeto = idProjeto;
     * this.descricao = descricao;
     * this.dataInicio = dataInicio;
     * this.dataTermino = dataTermino;
     * this.coordenador = coordenador;
     * }
     */

    /*
     * public Projeto(int idProjeto, String dataInicio, String coordenador) {
     * this.idProjeto = idProjeto;
     * this.dataInicio = dataInicio;
     * this.coordenador = coordenador;
     * }
     */

    public Projeto(int idProjeto, String coordenador) {
        this.idProjeto = idProjeto;
        this.coordenador = coordenador;
    }

    public Projeto(int idProjeto, String coordenador, Dados dados) {
        this(idProjeto, coordenador);
        this.dados = dados;
    }
}
