import java.util.ArrayList;

public class Atividade {
    // atributos
    public Atividade() {
        dados = new Dados();
    }

    public Dados dados;

    int idAtividade;
    /*
     * String descricao;
     * String dataInicio;
     * String dataTermino;
     */
    String responsavel;
    public ArrayList<Integer> idProfissionais = new ArrayList<Integer>();
    public ArrayList<Usuario> participantes = new ArrayList<Usuario>();

    /*
     * public Atividade(int idAtividade, String descricao, String dataInicio, String
     * dataTermino, String responsavel) {
     * this.idAtividade = idAtividade;
     * this.descricao = descricao;
     * this.dataInicio = dataInicio;
     * this.dataTermino = dataTermino;
     * this.responsavel = responsavel;
     * }
     */

    public Atividade(int idAtividade, String responsavel) {
        this.idAtividade = idAtividade;
        this.responsavel = responsavel;
    }

    public Atividade(int idAtividade, String responsavel, Dados dados) {
        this(idAtividade, responsavel);
        this.dados = dados;
    }
}