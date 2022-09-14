import java.util.ArrayList;

public class Projeto {
    // atributos
    int idProjeto;
    String descricao;
    String dataInicio;
    String dataTermino;
    String coordenador;
    int id_envolvidos[] = new int[50];
    public ArrayList<Integer> idProfissionais = new ArrayList<Integer>();
    String status = "Em processo de criação";

    // objeto
    Projeto(int idProjeto, String descricao, String dataInicio, String dataTermino, String coordenador) {
        this.idProjeto = idProjeto;
        this.descricao = descricao;
        this.dataInicio = dataInicio;
        this.dataTermino = dataTermino;
        this.coordenador = coordenador;
    }
}
