import java.util.ArrayList;

public class Atividade {
    // atributos
    int idAtividade;
    String descricao;
    String dataInicio;
    String dataTermino;
    String responsavel;
    public ArrayList<Integer> idProfissionais = new ArrayList<Integer>();

    Atividade(int idAtividade, String descricao, String dataInicio, String dataTermino, String responsavel) {
        this.idAtividade = idAtividade;
        this.descricao = descricao;
        this.dataInicio = dataInicio;
        this.dataTermino = dataTermino;
        this.responsavel = responsavel;
    }

}
