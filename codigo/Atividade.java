public class Atividade {
    // atributos
    int idAtividade;
    int idProjeto;
    String descricao;
    String dataInicio;
    String dataTermino;
    String responsavel;
    // profissionais envolvidos na atividade
    // tarefas a serem realizadas por cada profissional

    // objeto
    Atividade(int idProjeto, int idAtividade, String descricao, String dataInicio, String dataTermino, String responsavel) {
        this.idAtividade = idAtividade;    
        this.descricao = descricao;
        this.dataInicio = dataInicio;
        this.dataTermino = dataTermino;
        this.responsavel = responsavel;
    }
}