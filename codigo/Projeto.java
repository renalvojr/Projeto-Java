public class Projeto {
    
    // atributos
    int idProjeto;
    String descricao;
    String dataInicio;
    String dataTermino;
    String coordenador;
    // profissionais envolvidos: array
    // atividades: array
    // valor da bolsa para cada profissional
    // período de vigencia da bolsa
    

    // objeto
    Projeto(int idProjeto, String descricao, String dataInicio, String dataTermino, String coordenador) {
        this.idProjeto = idProjeto;    
        this.descricao = descricao;
        this.dataInicio = dataInicio;
        this.dataTermino = dataTermino;
        this.coordenador = coordenador;
    }
}