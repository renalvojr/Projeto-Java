import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("test");

        // Array list para os usuários, projetos e atividades
        ArrayList<Usuario> arrayDeUsuarios = new ArrayList<Usuario>();
        ArrayList<Projeto> arrayDeProjetos = new ArrayList<Projeto>();
        ArrayList<Atividade> arrayDeAtividades = new ArrayList<Atividade>();

        System.out.println("====== Sistema ======");
        System.out.println("Escolha uma das opções:\n   (1) Adicionar Usuário\n   (2) Adicionar um Projeto\n   (3) Adicionar Atividade\n  ------------\n   (4) Remover um Usuário\n   (5) Remover um Projeto\n   (6) Remover uma Atividade\n   (7) Encerrar Sistema");

         // pegando a escolha do usuário
        Scanner input = new Scanner(System.in);
        int escolha = input.nextInt();
        input.nextLine();
         
        if (escolha == 1) {
 
             // Adicionando um usuário
             System.out.println("Nome do usuário: ");
             String nomeUsuario = input.nextLine();
             System.out.println("Tipo de usuário (Aluno, Professor, Pesquisador, Profissional ou Técnico): ");
             String tipoDeUsuario = input.nextLine();
             System.out.println("Id do projeto que está participando: ");
             int projetoUsuario = input.nextInt();
             System.out.println("Id da atividade que está participando dentro desse projeto: ");
             int atividadeUsuario = input.nextInt();
             
             // Colocando esse novo usuário dentro do array list de usuários
             arrayDeUsuarios.add(new Usuario(nomeUsuario, tipoDeUsuario, projetoUsuario, atividadeUsuario));
             System.out.println("usuario Criado");
 
         } else if (escolha == 2) {
 
             // Adicionando um Projeto
             System.out.println("Id do projeto que está sendo criado: ");
             int idProjeto = input.nextInt();
             input.nextLine();
             System.out.println("Descrição do Projeto: ");
             String descricao = input.nextLine();
             System.out.println("Data e hora de inicio: ");
             String dataInicio = input.nextLine();
             System.out.println("Data e hora de término: ");
             String dataTermino = input.nextLine();
             System.out.println("Coordenador do projeto: ");
             String coordenador = input.nextLine();

             // Colocando esse novo projeto dentro do array list de projetos
             arrayDeProjetos.add(new Projeto(idProjeto, descricao, dataInicio, dataTermino, coordenador));
             System.out.println("Projeto Criado");
             
        } else if (escolha == 3) {
            
            // Adicionando uma atividade
            System.out.print("Id do projeto que será adicionada uma atividade: ");
            int idProjetoEditado = input.nextInt();
            System.out.print("Id da atividade que está sendo criada: ");
            int idAtividade = input.nextInt();
            System.out.print("Descrição da Atividade: ");
            String descricaoAtividade = input.nextLine();
            System.out.print("Data e hora de inicio: ");
            String dataInicioAtividade = input.nextLine();
            System.out.print("Data e hora de término: ");
            String dataTerminoAtividade = input.nextLine();
            System.out.print("Responsável pela Atividade: ");
            String responsavel = input.nextLine();

            // Colocando essa nova atividade dentro do array list de atividades
            arrayDeAtividades.add(new Atividade(idProjetoEditado, idAtividade, descricaoAtividade, dataInicioAtividade, dataTerminoAtividade, responsavel));
            System.out.println("Atividade criada");

        } else if (escolha == 4) {

            // Removendo um usuário
            System.out.println("id do usuário a ser removido: ");
            int idUsuarioRemovido = input.nextInt();
            arrayDeUsuarios.remove(idUsuarioRemovido);
            System.out.println("Usuario Removido");

        } else if (escolha == 5) {

            // Excluindo um projeto
            System.out.println("id do projeto a ser removido: ");
            int idProjetoRemovido = input.nextInt();
            arrayDeProjetos.remove(idProjetoRemovido);
            System.out.println("Projeto Removido");

        } else if (escolha == 6) { 

            // Excluindo uma atividade
            System.out.println("id da atividade a ser removida: ");
            int idAtividadeRemovida = input.nextInt();
            arrayDeAtividades.remove(idAtividadeRemovida);
            System.out.println("Atividade Removida");

        } else if (escolha == 7) {

            // Saindo do sistema
            System.out.println("Sistema encerrado");
            System.exit(0);
        }

        input.close();
    }  
}