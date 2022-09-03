public class Projeto {
    // atributos
    int idProjeto;
    String descricao;
    String dataInicio;
    String dataTermino;
    String coordenador;
    // array list de profissionais envolvidos no projeto
    // array list de atividades dentro desse projeto
    // valor da bolsa para cada profissional
    // periodo de vigência da bolsa

    // objeto
    Projeto(int idProjeto, String descricao, String dataInicio, String dataTermino, String coordenador) {
        this.idProjeto = idProjeto;
        this.descricao = descricao;
        this.dataInicio = dataInicio;
        this.dataTermino = dataTermino;
        this.coordenador = coordenador;
    }
}
