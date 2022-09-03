public class Atividade {
    // atributos
    int idAtividade;
    String descricao;
    String dataInicio;
    String dataTermino;
    String responsavel;
    // Profissionais envolvidos;
    // Tarefas a serem realizadas por cada profissional

    Atividade(int idAtividade, String descricao, String dataInicio, String dataTermino, String responsavel) {
        this.idAtividade = idAtividade;
        this.descricao = descricao;
        this.dataInicio = dataInicio;
        this.dataTermino = dataTermino;
        this.responsavel = responsavel;
    }
}
