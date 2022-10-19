import java.util.ArrayList;

public class Atividade {
    // atributos
    int idAtividade;
    String descricao;
    String dataInicio;
    String dataTermino;
    String responsavel;
    public ArrayList<Integer> idProfissionais = new ArrayList<Integer>();
    public ArrayList<Usuario> participantes = new ArrayList<Usuario>();

    Atividade(int idAtividade, String descricao, String dataInicio, String dataTermino, String responsavel) {
        this.idAtividade = idAtividade;
        this.descricao = descricao;
        this.dataInicio = dataInicio;
        this.dataTermino = dataTermino;
        this.responsavel = responsavel;
    }

    Atividade(int idAtividade, String dataInicio, String responsavel) {
        this.idAtividade = idAtividade;
        this.dataInicio = dataInicio;
        this.responsavel = responsavel;
    }
}
