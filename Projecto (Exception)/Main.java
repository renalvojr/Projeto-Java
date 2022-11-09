import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {

    public static void main(String[] args) {

        // arraylists
        ArrayList<Usuario> arrayDeUsuarios = new ArrayList<Usuario>();
        ArrayList<Projeto> arrayDeProjetos = new ArrayList<Projeto>();
        ArrayList<Atividade> arrayDeAtividades = new ArrayList<Atividade>();
        Scanner input = new Scanner(System.in);

        while (true) {
            // Sistema de log in
            System.out.println("======= Log In =======");

            int logIn = 00;
            while (logIn == 00) {
                try {
                    System.out.println(
                            "(1) Entrar em uma conta existente\n(2) Criar uma conta\n(3) Recuperar senha\n(4) Encerrar Sistema");
                    logIn = input.nextInt();
                    input.nextLine();
                } catch (InputMismatchException ime) {
                    System.out.println("Digite um número inteiro no ID e Senha");
                    input.nextLine();
                }
            }

            // logando em uma conta existente
            if (logIn == 1) {
                int idLogIn = 00;
                int senhaLogIn = 00;
                while (idLogIn == 00 || senhaLogIn == 00) {
                    try {
                        System.out.println("Digite seu ID de usuário");
                        idLogIn = input.nextInt();
                        input.nextLine();
                        System.out.println("Digite sua senha");
                        senhaLogIn = input.nextInt();
                        input.nextLine();
                    } catch (InputMismatchException ime) {
                        System.out.println("Digite um número inteiro no ID e Senha");
                        input.nextLine();
                    }
                }

                // se não exister ainda nenhum usuário no arraylist (ou seja, essa conta não
                // existe)
                if (arrayDeUsuarios.isEmpty())
                    System.out.println("ID ou senha inválida");

                // checando se essa conta existe
                for (int i = 0; i < arrayDeUsuarios.size(); i++) {
                    if (arrayDeUsuarios.get(i).idUsuario == idLogIn && arrayDeUsuarios.get(i).senha == senhaLogIn) {
                        System.out.println("Usuário logado com sucesso");
                        int idUsuarioLogado = arrayDeUsuarios.get(i).idUsuario;
                        int tipoUsuarioLogado = arrayDeUsuarios.get(i).tipo;
                        int chave = 1;

                        // Conta existente, usuário logado
                        while (chave == 1) {
                            System.out.println("======= Sistema de Gerenciamento =======");
                            System.out.println("Seu ID: " + idUsuarioLogado + "  Seu tipo: " + tipoUsuarioLogado);

                            // Se for um estudante de graduação, mestrado, doutorado ou técnico:
                            if (tipoUsuarioLogado == 1 || tipoUsuarioLogado == 2 || tipoUsuarioLogado == 3
                                    || tipoUsuarioLogado == 6) {

                                // Entrar em um projeto/atividade ou deslogar
                                int escolha = 00;
                                while (escolha == 00) {
                                    try {
                                        System.out.println(
                                                "   (1) Entrar em algum projeto ou atividade\n   (2) Deslogar");
                                        escolha = input.nextInt();
                                        input.nextLine();
                                    } catch (InputMismatchException ime) {
                                        System.out.println("Digite um número inteiro no ID e Senha");
                                        input.nextLine();
                                    }
                                }
                                // Entrar em um projeto/atividade
                                if (escolha == 1) {
                                    int escolha2 = 00;
                                    while (escolha2 == 00) {
                                        try {
                                            System.out.println(
                                                    "   (1) Entrar em um projeto\n   (2) Entrar em uma atividade");
                                            escolha2 = input.nextInt();
                                            input.nextLine();
                                        } catch (InputMismatchException ime) {
                                            System.out.println("Digite um número inteiro no ID e Senha");
                                            input.nextLine();
                                        }
                                    }

                                    if (escolha2 == 1) {
                                        // Escolhendo em qual projeto entrar
                                        System.out.println("Digite o ID do projeto que deseja entrar");
                                        int idProjetoEntrar = input.nextInt();

                                        // Navegando o arraylist de projetos
                                        for (int ii = 0; ii < arrayDeProjetos.size(); ii++) {
                                            // Projeto encontrado
                                            if (arrayDeProjetos.get(ii).idProjeto == idProjetoEntrar) {
                                                // Adicionando o usuário no projeto
                                                arrayDeProjetos.get(ii).idProfissionais.add(idUsuarioLogado);
                                                // Finalizando o loop
                                                ii = arrayDeProjetos.size();
                                                System.out.println("Você entrou no projeto");
                                            }
                                        }
                                        // O mesmo aplicado para Projeto
                                    } else if (escolha2 == 2) {
                                        System.out.println("Digite o ID da atividade que deseja entrar");
                                        int idAtividadeEntrar = input.nextInt();
                                        for (int ii = 0; ii < arrayDeAtividades.size(); ii++) {
                                            if (arrayDeAtividades.get(ii).idAtividade == idAtividadeEntrar) {
                                                arrayDeAtividades.get(ii).idProfissionais.add(idUsuarioLogado);
                                                ii = arrayDeAtividades.size();
                                                System.out.println("Você entrou na atividade");
                                            }
                                        }
                                    }
                                }
                                // Deslogar
                                else if (escolha == 2) {
                                    chave = 2;
                                }
                            }

                            // Se for profissional ou pesquisador
                            else if (tipoUsuarioLogado == 4 || tipoUsuarioLogado == 5) {
                                System.out.println(
                                        "   (1) Cadastrar um Usuário\n   (2) Criar um Projeto\n   (3) Criar uma Atividade\n   (4) Editar um Usuáro\n   (5) Editar um Projeto\n   (6) Editar uma Atividade\n   (7) Procurar por um Usuário, Atividade ou Projeto\n   (8) Relatório dos Projetos e Atividades da Instituição\n   (9) Adicionar, Excluir ou Mover usuários de um projeto ou atividade\n   (10) Fazer intercambio de usuários\n   (11) Gerenciar pagamento de bolsas\n   (12) Deslogar");
                                int escolha = input.nextInt();

                                // Cadastrar um usuário
                                if (escolha == 1) {
                                    int idUsuario = 00;
                                    int senha = 00;
                                    int tipo = 00;
                                    while (idUsuario == 00 | senha == 00 | tipo == 00) {
                                        try {
                                            System.out.println(
                                                    "Digite o id, senha e tipo do novo usuário que está sendo criado");
                                            idUsuario = input.nextInt();
                                            input.nextLine();
                                            senha = input.nextInt();
                                            input.nextLine();
                                            tipo = input.nextInt();
                                            input.nextLine();
                                        } catch (InputMismatchException ime) {
                                            System.out.println("Digite um número inteiro no ID e Senha");
                                            input.nextLine();
                                        }
                                    }
                                    arrayDeUsuarios.add(new Usuario(idUsuario, senha, tipo));
                                    System.out.println("Usuário criado");
                                }
                                // Criando um projeto
                                else if (escolha == 2) {
                                    int idProjeto = 00;
                                    while (idProjeto == 00) {
                                        try {
                                            System.out.println(
                                                    "Digite o id, descrição, data de início, data de término, e o coordenador, respectivamente");
                                            idProjeto = input.nextInt();
                                            input.nextLine();
                                        } catch (InputMismatchException ime) {
                                            System.out.println("Digite um número inteiro no ID e Senha");
                                            input.nextLine();
                                        }
                                    }
                                    String descricaoProjeto = input.nextLine();
                                    String dataInicio = input.nextLine();
                                    String dataTermino = input.nextLine();
                                    String coordenador = input.nextLine();
                                    arrayDeProjetos.add(new Projeto(idProjeto, descricaoProjeto, dataInicio,
                                            dataTermino, coordenador));
                                }
                                // Criando uma atividade
                                else if (escolha == 3) {
                                    int idAtividade = 00;
                                    while (idAtividade == 00) {
                                        try {
                                            System.out.println(
                                                    "Digite o id, descrição, data de início, data de término e o responsável, respectivamente");
                                            idAtividade = input.nextInt();
                                            input.nextLine();
                                        } catch (InputMismatchException ime) {
                                            System.out.println("Digite um número inteiro no ID e Senha");
                                            input.nextLine();
                                        }
                                    }
                                    String descricaoAtividade = input.nextLine();
                                    String dataInicio = input.nextLine();
                                    String dataTermino = input.nextLine();
                                    String responsavel = input.nextLine();
                                    arrayDeAtividades
                                            .add(new Atividade(idAtividade, descricaoAtividade, dataInicio, dataTermino,
                                                    responsavel));
                                }
                                // Editar usuário
                                else if (escolha == 4) {
                                    int idUsuarioModificado = 00;
                                    while (idUsuarioModificado == 00) {
                                        try {
                                            System.out.println(("Qual o id do usuário à ser modificado?"));
                                            idUsuarioModificado = input.nextInt();
                                            input.nextLine();
                                        } catch (InputMismatchException ime) {
                                            System.out.println("Digite um número inteiro no ID e Senha");
                                            input.nextLine();
                                        }
                                    }
                                    int indiceUsuarioModificado;

                                    // Encontrando o indice do usuário que queremos editar
                                    for (int iii = 0; iii < arrayDeUsuarios.size(); iii++) {
                                        // Caso o usuário seja encontrado
                                        if (idUsuarioModificado == arrayDeUsuarios.get(iii).idUsuario) {
                                            indiceUsuarioModificado = iii;
                                            System.out.println("   (1) Mudar o id do Usuário\n   (2) Excluir Usuário");
                                            int escolha2 = input.nextInt();

                                            // Modificando o id do usuário
                                            if (escolha2 == 1) {
                                                System.out.println("Qual será o novo id do usuário?");
                                                int novoIdUsuario = input.nextInt();
                                                arrayDeUsuarios.get(indiceUsuarioModificado).idUsuario = novoIdUsuario;
                                                System.out.println("Id modificado com sucesso");

                                                // Excluindo o usuário
                                            } else if (escolha2 == 2) {
                                                // Excluindo esse usuário do arraylist de usuários
                                                arrayDeUsuarios.remove(indiceUsuarioModificado);
                                                System.out.println("Usuário excluído com sucesso");
                                            }
                                            // Finalizando o Loop
                                            iii = arrayDeUsuarios.size();
                                            // Caso o usuário não exista
                                        } else if (idUsuarioModificado != arrayDeUsuarios.get(iii).idUsuario
                                                && iii == arrayDeUsuarios.size() - 1) {
                                            System.out.println("Esse usuário não existe");
                                        }
                                    }
                                }
                                // Editando projeto
                                else if (escolha == 5) {
                                    int idProjetoModificado = 00;
                                    while (idProjetoModificado == 00) {
                                        try {
                                            System.out.println(("Qual o id do projeto à ser modificado?"));
                                            idProjetoModificado = input.nextInt();
                                            input.nextLine();
                                        } catch (InputMismatchException ime) {
                                            System.out.println("Digite um número inteiro no ID e Senha");
                                            input.nextLine();
                                        }
                                    }
                                    int indiceProjetoModificado;

                                    // Procurando o projeto à ser modificado
                                    for (int iii = 0; iii < arrayDeProjetos.size(); iii++) {
                                        // Caso o projeto seja encontrado
                                        if (idProjetoModificado == arrayDeProjetos.get(iii).idProjeto) {
                                            indiceProjetoModificado = iii;

                                            System.out.println(
                                                    "   (1) Modificar id\n   (2) Modificar descrição\n   (3) Modificar data de início\n   (4) Modificar data de término\n   (5) Modificar coordenador\n   (6) Excluir Projeto\n   (7) Modificando o status do projeto\n");
                                            int escolha2 = input.nextInt();
                                            input.nextLine();

                                            // Modificando id do projeto
                                            if (escolha2 == 1) {
                                                System.out.println("Qual será o novo id do projeto?");
                                                int novoIdProjeto = input.nextInt();
                                                input.nextLine();
                                                arrayDeProjetos.get(indiceProjetoModificado).idProjeto = novoIdProjeto;
                                                System.out.println("Id modificado com sucesso");

                                                // Modificando descrição
                                            } else if (escolha2 == 2) {
                                                System.out.println("Digite a nova descrição");
                                                String novaDescricao = input.nextLine();
                                                arrayDeProjetos.get(indiceProjetoModificado).descricao = novaDescricao;
                                                System.out.println("Descrição modificada com sucesso");

                                                // Modificando data de início
                                            } else if (escolha2 == 3) {
                                                System.out.println("Digite a nova data de início");
                                                String novaDataInicio = input.nextLine();
                                                arrayDeProjetos
                                                        .get(indiceProjetoModificado).dataInicio = novaDataInicio;
                                                System.out.println("Data de início modificada com sucesso");

                                                // Modificando data de término
                                            } else if (escolha2 == 4) {
                                                System.out.println("Digite a nova data de término");
                                                String novaDataTermino = input.nextLine();
                                                arrayDeProjetos
                                                        .get(indiceProjetoModificado).dataTermino = novaDataTermino;

                                                // Modificando o coordenador do projeto
                                            } else if (escolha2 == 5) {
                                                System.out.println("Digite o nome do novo coordenador");
                                                String novoCoordenador = input.nextLine();
                                                arrayDeProjetos
                                                        .get(indiceProjetoModificado).coordenador = novoCoordenador;
                                            } else if (escolha2 == 6) {
                                                arrayDeProjetos.remove(indiceProjetoModificado);
                                                System.out.println("Projeto excluido");

                                                // Modificando o status do projeto (Iniciado ou Em andamento)
                                            } else if (escolha2 == 7) {
                                                // Caso esse projeto ainda não tenha descrição, podemos apenas setar ele
                                                // como Iniciado ou Em andamento
                                                if (arrayDeProjetos.get(indiceProjetoModificado).descricao.isEmpty()) {
                                                    int escolha3 = 00;
                                                    while (escolha3 == 00) {
                                                        try {
                                                            System.out.println(
                                                                    "Modificar para: (1) Iniciado   (2) Em andamento");
                                                            escolha3 = input.nextInt();
                                                            input.nextLine();
                                                        } catch (InputMismatchException ime) {
                                                            System.out
                                                                    .println("Digite um número inteiro no ID e Senha");
                                                            input.nextLine();
                                                        }
                                                    }

                                                    // Setando o projeto para "Iniciado"
                                                    if (escolha3 == 1) {
                                                        arrayDeProjetos
                                                                .get(indiceProjetoModificado).status = "Iniciado";
                                                        // Setando o projeto para "Em andamento"
                                                    } else if (escolha3 == 2) {
                                                        arrayDeProjetos
                                                                .get(indiceProjetoModificado).status = "Em andamento";
                                                    }
                                                    // Caso o Projeto tenha descrição
                                                } else {
                                                    int escolha3 = 00;
                                                    while (escolha3 == 00) {
                                                        try {
                                                            System.out.println(
                                                                    "Modificar para: (1) Iniciado   (2) Em andamento   (3) Concluído");
                                                            escolha3 = input.nextInt();
                                                            input.nextLine();
                                                        } catch (InputMismatchException ime) {
                                                            System.out
                                                                    .println("Digite um número inteiro no ID e Senha");
                                                            input.nextLine();
                                                        }
                                                    }

                                                    // Mudando o status para Iniciado
                                                    if (escolha3 == 1) {
                                                        arrayDeProjetos
                                                                .get(indiceProjetoModificado).status = "Iniciado";
                                                        // Mudando o status para Em andamento
                                                    } else if (escolha3 == 2) {
                                                        arrayDeProjetos
                                                                .get(indiceProjetoModificado).status = "Em andamento";
                                                        // Mudando o status para Concluído
                                                    } else if (escolha3 == 3) {
                                                        arrayDeProjetos
                                                                .get(indiceProjetoModificado).status = "Concluído";
                                                    }
                                                }
                                            }
                                            // Caso o projeto à ser modificado não seja encontrado
                                        } else if (idProjetoModificado != arrayDeProjetos.get(iii).idProjeto
                                                && iii == arrayDeProjetos.size() - 1) {
                                            System.out.println("Projeto não encontrado");
                                        }
                                    }
                                }
                                // Editando uma atividade (Seguindo a mesma lógica anterior)
                                else if (escolha == 6) {
                                    int idAtividadeModificada = 00;
                                    while (idAtividadeModificada == 00) {
                                        try {
                                            System.out.println("Qual o id da atividade à ser modificada?");
                                            idAtividadeModificada = input.nextInt();
                                            input.nextLine();
                                        } catch (InputMismatchException ime) {
                                            System.out.println("Digite um número inteiro no ID e Senha");
                                            input.nextLine();
                                        }
                                    }
                                    int indiceAtividadeModificada;

                                    for (int iii = 0; iii < arrayDeAtividades.size(); iii++) {
                                        if (idAtividadeModificada == arrayDeAtividades.get(iii).idAtividade) {
                                            indiceAtividadeModificada = iii;

                                            System.out.println(
                                                    "   (1) Modificar o id\n   (2) Modificar a descrição\n   (3) Modificar a data de início\n   (4) Modificar a data de término\n   (5) Modificar o responsável\n   (6) Excluir atividade");
                                            int escolha2 = input.nextInt();

                                            if (escolha2 == 1) {
                                                System.out.println("Digite o novo id");
                                                int novoIdAtividade = input.nextInt();
                                                arrayDeAtividades
                                                        .get(indiceAtividadeModificada).idAtividade = novoIdAtividade;
                                                System.out.println("Id modificado com sucesso");

                                            } else if (escolha2 == 2) {
                                                System.out.println("Digite a nova descrição");
                                                String novaDescricao = input.nextLine();
                                                arrayDeAtividades
                                                        .get(indiceAtividadeModificada).descricao = novaDescricao;
                                                System.out.println("Descrição modificada com sucesso");

                                            } else if (escolha2 == 3) {
                                                System.out.println("Digite a nova data de início");
                                                String novaDataInicio = input.nextLine();
                                                arrayDeAtividades
                                                        .get(indiceAtividadeModificada).dataInicio = novaDataInicio;
                                                System.out.println("Data de início modificada com sucesso");

                                            } else if (escolha2 == 4) {
                                                System.out.println("Digite a nova data de término");
                                                String novaDataTermino = input.nextLine();
                                                arrayDeAtividades
                                                        .get(indiceAtividadeModificada).dataTermino = novaDataTermino;
                                                System.out.println("Data de término modificada com sucesso");
                                            } else if (escolha2 == 5) {
                                                System.out.println("Digite o novo responsável");
                                                String novoResponsavel = input.nextLine();
                                                arrayDeAtividades
                                                        .get(indiceAtividadeModificada).responsavel = novoResponsavel;
                                                System.out.println("Responsável modificado com sucesso");
                                            } else if (escolha2 == 6) {
                                                arrayDeAtividades.remove(indiceAtividadeModificada);
                                                System.out.println("Atividade excluida");
                                            }
                                        } else if (idAtividadeModificada != arrayDeAtividades.get(iii).idAtividade
                                                && iii == arrayDeAtividades.size() - 1) {
                                            System.out.println("Atividade não encontrada");
                                        }
                                    }
                                }
                                // Procurando um usuário, projeto ou atividade (Consultas)
                                else if (escolha == 7) {
                                    int escolhaProcurar = 00;
                                    while (escolhaProcurar == 00) {
                                        try {
                                            System.out.println(
                                                    "   (1) Procurar Usuário\n   (2) Procurar Projeto\n   (3) Procurar Atividade");
                                            escolhaProcurar = input.nextInt();
                                            input.nextLine();
                                        } catch (InputMismatchException ime) {
                                            System.out.println("Digite um número inteiro no ID e Senha");
                                            input.nextLine();
                                        }
                                    }

                                    // Procurando um usuário
                                    if (escolhaProcurar == 1) {
                                        System.out.println("Qual o id do usuário?");
                                        int idUsuarioProcurar = input.nextInt();
                                        // Procurando o usuário no arraylist
                                        for (int iii = 0; iii < arrayDeUsuarios.size(); iii++) {
                                            // Caso o usuário seja encontrado
                                            if (idUsuarioProcurar == arrayDeUsuarios.get(iii).idUsuario) {
                                                System.out.println("Usuário encontrado:");
                                                System.out.println(arrayDeUsuarios.get(iii));
                                                // Finalizando o loop
                                                iii = arrayDeUsuarios.size();

                                                // Caso o usuário não seja não encontrado
                                            } else if (idUsuarioProcurar != arrayDeUsuarios.get(iii).idUsuario
                                                    && iii == arrayDeUsuarios.size() - 1) {
                                                System.out.println("Usuário não encontrado");
                                            }
                                        }

                                        // Procurando um projeto (Seguindo a mesma lógica anterior)
                                    } else if (escolhaProcurar == 2) {
                                        System.out.println("Qual o id do projeto?");
                                        int idProjetoProcurar = input.nextInt();
                                        for (int iii = 0; iii < arrayDeProjetos.size(); iii++) {
                                            if (idProjetoProcurar == arrayDeProjetos.get(iii).idProjeto) {
                                                System.out.println("Projeto encontrado:");
                                                System.out.println(arrayDeProjetos.get(iii));
                                                iii = arrayDeProjetos.size();
                                            } else if (idProjetoProcurar != arrayDeProjetos.get(iii).idProjeto
                                                    && iii == arrayDeProjetos.size() - 1) {
                                                System.out.println("Projeto não encontrado");
                                            }
                                        }

                                        // Procurando uma atividade (Seguindo a mesma lógica anterior)
                                    } else if (escolhaProcurar == 3) {
                                        System.out.println("Qual o id da atividade?");
                                        int idAtividadeProcurar = input.nextInt();
                                        for (int pi = 0; pi < arrayDeAtividades.size(); pi++) {
                                            if (idAtividadeProcurar == arrayDeAtividades.get(pi).idAtividade) {
                                                System.out.println("Atividade encontrada:");
                                                System.out.println(arrayDeAtividades.get(pi));
                                                pi = arrayDeAtividades.size();
                                            } else if (idAtividadeProcurar != arrayDeAtividades.get(pi).idAtividade
                                                    && pi == arrayDeAtividades.size() - 1) {
                                                System.out.println("Atividade não encontrada");
                                            }
                                        }
                                    }
                                }

                                // Mostrando relatório
                                else if (escolha == 8) {
                                    try {
                                        if (arrayDeProjetos.isEmpty()) {
                                            System.out.println("Não há nenhum projeto em andamento");
                                        } else {
                                            System.out
                                                    .println("Número de projetos em andamento: "
                                                            + arrayDeProjetos.size());
                                            for (int iii = 0; iii < arrayDeProjetos.size(); iii++) {
                                                System.out.println(arrayDeProjetos.get(iii).idProjeto + " ");
                                            }
                                        }

                                        if (arrayDeAtividades.isEmpty()) {
                                            System.out.println("Não há nenhuma atividade em andamento");
                                        } else {
                                            System.out.println(
                                                    "Número de atividades em andamento: " + arrayDeAtividades.size());
                                            for (int iii = 0; iii < arrayDeAtividades.size(); iii++) {
                                                System.out.println(arrayDeAtividades.get(iii).idAtividade + " ");
                                            }
                                        }
                                    } catch (Exception e) {
                                        System.out.println("Relatório ainda não existente");
                                    }
                                }
                                // Excluindo, adicionando ou movendo usuários em uma atividade ou projeto
                                // específico
                                else if (escolha == 9) {
                                    int escolhaEditar = 00;

                                    while (escolhaEditar == 00)
                                        try {
                                            System.out.println(
                                                    " (1) Adicionar usuário a um projeto\n (2) Remover usuário de um projeto\n (3) Adicionar usuário a uma atividade\n (4) Remover usuário de uma atividade");

                                            escolhaEditar = input.nextInt();
                                            input.nextLine();
                                        } catch (InputMismatchException ime) {
                                            System.out.println("Digite um número inteiro no ID e Senha");
                                            input.nextLine();
                                        }

                                    // Adicionar usuário a um projeto
                                    if (escolhaEditar == 1) {
                                        int idUser = 00;
                                        int idProj = 00;
                                        while (idUser == 00 || idProj == 00) {
                                            try {
                                                System.out.println("Qual o id do usuário?");
                                                idUser = input.nextInt();
                                                input.nextLine();
                                                System.out.println("Qual o id do projeto?");
                                                idProj = input.nextInt();
                                                input.nextLine();
                                            } catch (InputMismatchException ime) {
                                                System.out.println("Digite um número inteiro no ID e Senha");
                                                input.nextLine();
                                            }
                                        }

                                        // procurando o indice do projeto
                                        for (int iii = 0; iii < arrayDeProjetos.size(); iii++) {
                                            if (arrayDeProjetos.get(iii).idProjeto == idProj) {
                                                arrayDeProjetos.get(iii).idProfissionais.add(idUser);
                                                System.out.println(arrayDeProjetos.get(iii).idProfissionais);
                                                iii = arrayDeProjetos.size();
                                            }
                                        }

                                    }
                                    // Excluindo usuário de um projeto
                                    else if (escolhaEditar == 2) {
                                        System.out.println("Qual o id do usuário?");
                                        int idUser = input.nextInt();
                                        System.out.println("Qual o id do projeto?");
                                        int idProj = input.nextInt();

                                        // procurando o indice do projeto
                                        for (int iii = 0; iii < arrayDeProjetos.size(); iii++) {
                                            // Caso o projeto seja encontrado
                                            if (arrayDeProjetos.get(iii).idProjeto == idProj) {
                                                // Procurando o indice do usuário dentro desse projeto
                                                for (int pii = 0; pii < arrayDeProjetos.get(iii).idProfissionais
                                                        .size(); pii++) {
                                                    // Usuário encontrado
                                                    if (arrayDeProjetos.get(iii).idProfissionais.get(pii) == idUser) {
                                                        arrayDeProjetos.get(iii).idProfissionais.remove(pii);
                                                        // Finalizando o loop
                                                        pii = arrayDeProjetos.get(iii).idProfissionais
                                                                .size();
                                                    }
                                                }
                                                // Finalizando o loop
                                                iii = arrayDeProjetos.size();
                                                System.out.println(arrayDeProjetos.get(iii).idProfissionais);
                                            }
                                        }
                                    }
                                    // Adicionando usuário em uma atividade
                                    else if (escolhaEditar == 3) {
                                        System.out.println("Qual o id do usuário?");
                                        int idUser = input.nextInt();
                                        System.out.println("Qual o id da atividade?");
                                        int idProj = input.nextInt();

                                        // Procurando o indice da atividade
                                        for (int iii = 0; iii < arrayDeAtividades.size(); iii++) {
                                            if (arrayDeAtividades.get(iii).idAtividade == idProj) {
                                                arrayDeAtividades.get(iii).idProfissionais.add(idUser);
                                                System.out.println(arrayDeAtividades.get(iii).idProfissionais);
                                                iii = arrayDeAtividades.size();
                                            }
                                        }
                                    }
                                    // Excluindo usuário de uma atividade
                                    else if (escolhaEditar == 4) {
                                        System.out.println("Qual o id do usuário?");
                                        int idUser = input.nextInt();
                                        System.out.println("Qual o id da atividade?");
                                        int idProj = input.nextInt();

                                        // Procurando o indice da atividade
                                        for (int iii = 0; iii < arrayDeAtividades.size(); iii++) {
                                            // Atividade encontrada
                                            if (arrayDeAtividades.get(iii).idAtividade == idProj) {
                                                arrayDeAtividades.get(iii).idProfissionais.remove(idUser);
                                                System.out.println(arrayDeAtividades.get(iii).idProfissionais);
                                                iii = arrayDeAtividades.size();
                                            }
                                        }
                                    }
                                }
                                // Intercambio de usuários
                                else if (escolha == 10) {
                                    int idUser = 00;
                                    int idProj = 00;
                                    while (idUser == 00 || idProj == 00)
                                        try {
                                            System.out.println("Qual o id do usuário?");
                                            idUser = input.nextInt();
                                            input.nextLine();
                                            System.out
                                                    .println("Qual o id da atividade que deseja fazer o intercambio?");
                                            idProj = input.nextInt();
                                            input.nextLine();
                                        } catch (InputMismatchException ime) {
                                            System.out.println("Digite um número inteiro no ID e Senha");
                                            input.nextLine();
                                        }

                                    for (int pp = 0; pp < arrayDeAtividades.size(); pp++) {
                                        if (arrayDeAtividades.get(pp).idAtividade == idProj) {
                                            arrayDeAtividades.get(pp).idProfissionais.add(idUser);
                                            System.out.println(arrayDeAtividades.get(pp).idProfissionais);
                                            pp = arrayDeAtividades.size();
                                            System.out.println("Intercambio realizado");
                                        }
                                    }
                                }
                                // Gerenciar o pagamento de bolsa
                                else if (escolha == 11) {
                                    int idUs = 00;
                                    while (idUs == 00) {
                                        try {
                                            System.out.println("ID do Usuário que você deseja gerenciar a bolsa");
                                            idUs = input.nextInt();
                                            input.nextLine();
                                        } catch (InputMismatchException ime) {
                                            System.out.println("O ID deve ser um inteiro");
                                            input.nextLine();
                                        }
                                    }

                                    for (int us = 0; us < arrayDeUsuarios.size(); us++) {
                                        if (arrayDeUsuarios.get(us).idUsuario == idUs) {
                                            if (arrayDeUsuarios.get(us).bolsa == 0) {
                                                System.out.println("Esse usuário ainda não possui nenhuma bolsa");

                                                System.out.println("   (1) Adicionar uma bolsa ao usuário");
                                                int escolhav = input.nextInt();

                                                if (escolhav == 1) {
                                                    System.out.println(
                                                            "Digite o valor da bolsa, e em seguida sua vigencia");
                                                    int valor_bolsa = input.nextInt();
                                                    input.nextLine();
                                                    String vigencia_bolsa = input.nextLine();

                                                    arrayDeUsuarios.get(us).bolsa = valor_bolsa;
                                                    arrayDeUsuarios.get(us).vigencia = vigencia_bolsa;
                                                    System.out.println("Bolsa adicionada com sucesso");
                                                }
                                            } else {
                                                System.out.println("Valor da bolsa: " + arrayDeUsuarios.get(us).bolsa
                                                        + "  Vigencia: " + arrayDeUsuarios.get(us).vigencia);

                                                System.out.println(
                                                        "   (1) Editar valor ou vigencia da bolsa\n   (2) Sair");
                                                int escolhav = input.nextInt();

                                                if (escolhav == 1) {
                                                    System.out.println(
                                                            "   (1) Modificar valor da bolsa\n   (2) Modificar vigencia da bolsa");
                                                    int escolhavv = input.nextInt();

                                                    if (escolhavv == 1) {
                                                        System.out.println("Digite o novo valor da bolsa");
                                                        int valor_bolsa2 = input.nextInt();
                                                        arrayDeUsuarios.get(us).bolsa = valor_bolsa2;
                                                        System.out.println("Valor da bolsa modificado com sucesso");
                                                    } else if (escolhavv == 2) {
                                                        System.out.println("Digite o nova data de vigencia");
                                                        input.nextLine();
                                                        String vigencia_bolsa2 = input.nextLine();
                                                        arrayDeUsuarios.get(us).vigencia = vigencia_bolsa2;
                                                        System.out.println("Data de vigencia modificada com sucesso");
                                                    }
                                                } else if (escolhav == 2) {
                                                    System.out.println("Gerenciamento de bolsas encerrado");
                                                }
                                            }

                                        }
                                    }
                                }

                                // Deslogar
                                else if (escolha == 12) {
                                    chave = 2;
                                }
                            }
                        }
                        i = arrayDeUsuarios.size();
                    } else {
                        System.out.println("ID ou senha inválida");
                    }
                }

                // criando uma conta
            } else if (logIn == 2) {
                int idLogIn = 00;
                int senhaLogIn = 00;

                while (idLogIn == 00 || senhaLogIn == 00)
                    try {
                        System.out.println("ID de usuário");
                        idLogIn = input.nextInt();
                        input.nextLine();
                        System.out.println("Senha");
                        senhaLogIn = input.nextInt();
                        input.nextLine();
                    } catch (InputMismatchException ime) {
                        System.out.println("Digite um número inteiro no ID e Senha");
                        input.nextLine();
                    }

                System.out.println(
                        "Tipo de usuário:\n(1) Graduação\n(2) Mestrado\n(3) Doutorado\n(4) Pesquisador\n(5) Profissional\n(6) Técnico");
                int tipo = input.nextInt();

                // checando se essa conta já existe
                // ...

                // criando usuário caso ele não exista
                arrayDeUsuarios.add(new Usuario(idLogIn, senhaLogIn, tipo));

                // dizendo se é coordenador ou não
                if (tipo == 4 || tipo == 5) {
                    System.out.println("(0) Não coordenador\n(1) Coordenador");
                    int e_coordenador = input.nextInt();

                    // se for coordenador
                    if (e_coordenador == 1) {
                        for (int pi2 = 0; pi2 < arrayDeUsuarios.size(); pi2++) {
                            if (arrayDeUsuarios.get(pi2).idUsuario == idLogIn) {
                                arrayDeUsuarios.get(pi2).coordenador = 1;
                                pi2 = arrayDeUsuarios.size();
                            }
                        }
                    }
                    // se não for coordenador
                    else if (e_coordenador == 0) {
                        for (int pi2 = 0; pi2 < arrayDeUsuarios.size(); pi2++) {
                            if (arrayDeUsuarios.get(pi2).idUsuario == idLogIn) {
                                arrayDeUsuarios.get(pi2).coordenador = 0;
                                pi2 = arrayDeUsuarios.size();
                            }
                        }
                    }
                    System.out.println(arrayDeUsuarios.get(0).coordenador);

                }

                System.out.println("Usuário criado");

                // recuperando senha
            } else if (logIn == 3) {
                System.out.println("Recuperação de senha");
                int idLogIn = 00;
                while (idLogIn == 00) {
                    try {
                        System.out.println("Digite seu ID de usuário");
                        idLogIn = input.nextInt();
                        input.nextLine();
                    } catch (InputMismatchException ime) {
                        System.out.println("Digite um número inteiro no ID e Senha");
                        input.nextLine();
                    }
                }

                // checando se essa conta existe
                for (int i = 0; i < arrayDeUsuarios.size(); i++) {
                    // modificando senha
                    if (arrayDeUsuarios.get(i).idUsuario == idLogIn) {
                        System.out.println("Digite sua nova senha");
                        int novaSenha = input.nextInt();
                        arrayDeUsuarios.get(i).senha = novaSenha;
                        System.out.println("Senha modificada com sucesso");
                        i = arrayDeUsuarios.size();
                    } else {
                        System.out.println("ID não encontrado");
                    }
                }

                // fechando o sistema
            } else if (logIn == 4) {
                input.close();
                System.exit(0);
            }
        }

    }
}