import java.util.ArrayList;
import java.util.Scanner;

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
            System.out.println(
                    "(1) Entrar em uma conta existente\n(2) Criar uma conta\n(3) Recuperar senha\n(4) Encerrar Sistema");
            int logIn = input.nextInt();

            // logando em uma conta
            if (logIn == 1) {
                System.out.println("Digite seu ID de usuário");
                int idLogIn = input.nextInt();
                System.out.println("Digite sua senha");
                int senhaLogIn = input.nextInt();

                // se não exister ainda nenhum usuário no arraylist
                if (arrayDeUsuarios.isEmpty())
                    System.out.println("ID ou senha inválida");
                // checando se essa conta existe
                for (int i = 0; i < arrayDeUsuarios.size(); i++) {
                    if (arrayDeUsuarios.get(i).idUsuario == idLogIn && arrayDeUsuarios.get(i).senha == senhaLogIn) {
                        System.out.println("Usuário logado com sucesso");
                        int u = 1;

                        //////////////////////////////////////////////////////////// PROGRAMA
                        //////////////////////////////////////////////////////////// /////////////////////////////////
                        //////////////////////////////////////////////////////////// //////////////////////////////////////////////
                        while (u == 1) {
                            System.out.println("======= Sistema de Gerenciamento =======");
                            System.out.println("Seu ID: " + arrayDeUsuarios.get(i).idUsuario + "  Seu tipo: "
                                    + arrayDeUsuarios.get(i).tipo);

                            // Se for um estudante de graduação, mestrado, doutorado ou técnico:
                            if (arrayDeUsuarios.get(i).tipo == 1 || arrayDeUsuarios.get(i).tipo == 2
                                    || arrayDeUsuarios.get(i).tipo == 3 || arrayDeUsuarios.get(i).tipo == 6) {

                                // entrar em um projeto ou atividade

                                System.out.println("(1) Deslogar");
                                // pegando o input do usuário
                                int escolha = input.nextInt();

                                // Deslogar
                                if (escolha == 1) {
                                    u = 2;
                                }
                            }

                            // se for profissional ou pesquisador
                            else if (arrayDeUsuarios.get(i).tipo == 4 || arrayDeUsuarios.get(i).tipo == 5) {
                                System.out.println(
                                        "   (1) Adicionar um Usuário\n   (2) Adicionar um Projeto\n   (3) Adicionar uma Atividade\n   (4) Editar um Usuáro\n   (5) Editar um Projeto\n   (6) Editar uma Atividade\n   (7) Procurar por um Usuário, Atividade ou Projeto\n   (8) Relatório dos Projetos e Atividades da Instituição\n   (9) Adicionar, Excluir ou Mover usuários de um projeto ou atividade\n   (10) Deslogar");

                                // pegando o input do usuário
                                int escolha = input.nextInt();

                                // adicionando um usuário
                                if (escolha == 1) {
                                    System.out
                                            .println("Digite o id, senha e tipo do novo usuário que está sendo criado");
                                    int idUsuario = input.nextInt();
                                    int senha = input.nextInt();
                                    int tipo = input.nextInt();
                                    arrayDeUsuarios.add(new Usuario(idUsuario, senha, tipo));
                                    System.out.println("Usuário criado");

                                }
                                // adicionando um projeto
                                else if (escolha == 2) {
                                    System.out.println(
                                            "Digite o id, descrição, data de início, data de término, e o coordenador, respectivamente");
                                    int idProjeto = input.nextInt();
                                    input.nextLine();
                                    String descricaoProjeto = input.nextLine();
                                    String dataInicio = input.nextLine();
                                    String dataTermino = input.nextLine();
                                    String coordenador = input.nextLine();
                                    arrayDeProjetos.add(new Projeto(idProjeto, descricaoProjeto, dataInicio,
                                            dataTermino, coordenador));
                                }
                                // adicionando uma atividade
                                else if (escolha == 3) {
                                    System.out.println(
                                            "Digite o id, descrição, data de início, data de término e o responsável, respectivamente");
                                    int idAtividade = input.nextInt();
                                    input.nextLine();
                                    String descricaoAtividade = input.nextLine();
                                    String dataInicio = input.nextLine();
                                    String dataTermino = input.nextLine();
                                    String responsavel = input.nextLine();
                                    arrayDeAtividades
                                            .add(new Atividade(idAtividade, descricaoAtividade, dataInicio, dataTermino,
                                                    responsavel));

                                }
                                // editar usuário
                                else if (escolha == 4) {
                                    System.out.println(("Qual o id do usuário à ser modificado?"));
                                    int idUsuarioModificado = input.nextInt();
                                    int indiceUsuarioModificado;

                                    // encontrando o indice do usuário em questão
                                    for (int pi = 0; pi < arrayDeUsuarios.size(); pi++) {
                                        if (idUsuarioModificado == arrayDeUsuarios.get(pi).idUsuario) {
                                            indiceUsuarioModificado = pi;

                                            System.out.println("   (1) Mudar o id do Usuário\n   (2) Excluir Usuário");
                                            int escolhaModificar = input.nextInt();

                                            if (escolhaModificar == 1) {
                                                System.out.println("Qual será o novo id do usuário?");
                                                int novoIdUsuario = input.nextInt();
                                                arrayDeUsuarios.get(indiceUsuarioModificado).idUsuario = novoIdUsuario;
                                                System.out.println("Id modificado com sucesso");

                                            } else if (escolhaModificar == 2) {
                                                arrayDeUsuarios.remove(indiceUsuarioModificado);
                                                System.out.println("Usuário excluído com sucesso");

                                            }
                                            i = arrayDeUsuarios.size();
                                        } else if (idUsuarioModificado != arrayDeUsuarios.get(pi).idUsuario
                                                && pi == arrayDeUsuarios.size() - 1) {
                                            System.out.println("Esse usuário não existe");
                                        }
                                    }
                                }
                                // editando projeto
                                else if (escolha == 5) {
                                    System.out.println(("Qual o id do projeto à ser modificado?"));
                                    int idProjetoModificado = input.nextInt();
                                    int indiceProjetoModificado;

                                    for (int pi = 0; pi < arrayDeProjetos.size(); pi++) {
                                        if (idProjetoModificado == arrayDeProjetos.get(pi).idProjeto) {
                                            indiceProjetoModificado = pi;

                                            System.out.println(
                                                    "   (1) Modificar id\n   (2) Modificar descrição\n   (3) Modificar data de início\n   (4) Modificar data de término\n   (5) Modificar coordenador\n   (6) Excluir Projeto\n");
                                            int escolhaModificar = input.nextInt();

                                            if (escolhaModificar == 1) {
                                                System.out.println("Qual será o novo id do projeto?");
                                                int novoIdProjeto = input.nextInt();
                                                arrayDeProjetos.get(indiceProjetoModificado).idProjeto = novoIdProjeto;
                                                System.out.println("Id modificado com sucesso");

                                            } else if (escolhaModificar == 2) {
                                                System.out.println("Digite a nova descrição");
                                                String novaDescricao = input.nextLine();
                                                arrayDeProjetos.get(indiceProjetoModificado).descricao = novaDescricao;
                                                System.out.println("Descrição modificada com sucesso");

                                            } else if (escolhaModificar == 3) {
                                                System.out.println("Digite a nova data de início");
                                                String novaDataInicio = input.nextLine();
                                                arrayDeProjetos
                                                        .get(indiceProjetoModificado).dataInicio = novaDataInicio;
                                                System.out.println("Data de início modificada com sucesso");

                                            } else if (escolhaModificar == 4) {
                                                System.out.println("Digite a nova data de término");
                                                String novaDataTermino = input.nextLine();
                                                arrayDeProjetos
                                                        .get(indiceProjetoModificado).dataTermino = novaDataTermino;

                                            } else if (escolhaModificar == 5) {
                                                System.out.println("Digite o nome do novo coordenador");
                                                String novoCoordenador = input.nextLine();
                                                arrayDeProjetos
                                                        .get(indiceProjetoModificado).coordenador = novoCoordenador;
                                            } else if (escolhaModificar == 6) {
                                                arrayDeProjetos.remove(indiceProjetoModificado);
                                                System.out.println("Projeto excluido");

                                                // modificando o status do projeto
                                            } else if (escolhaModificar == 7) {
                                                if (arrayDeProjetos.get(indiceProjetoModificado).descricao.isEmpty()) {
                                                    System.out
                                                            .println("Modificar para: (1) Iniciado   (2) Em andamento");
                                                    int esc = input.nextInt();
                                                    if (esc == 1) {
                                                        arrayDeProjetos
                                                                .get(indiceProjetoModificado).status = "Iniciado";
                                                    } else if (esc == 2) {
                                                        arrayDeProjetos
                                                                .get(indiceProjetoModificado).status = "Em andamento";
                                                    }
                                                } else {
                                                    System.out
                                                            .println(
                                                                    "Modificar para: (1) Iniciado   (2) Em andamento   (3) Concluído");
                                                    int esc = input.nextInt();
                                                    if (esc == 1) {
                                                        arrayDeProjetos
                                                                .get(indiceProjetoModificado).status = "Iniciado";
                                                    } else if (esc == 2) {
                                                        arrayDeProjetos
                                                                .get(indiceProjetoModificado).status = "Em andamento";
                                                    } else if (esc == 3) {
                                                        arrayDeProjetos
                                                                .get(indiceProjetoModificado).status = "Concluído";
                                                    }
                                                }
                                            }

                                        } else if (idProjetoModificado != arrayDeProjetos.get(pi).idProjeto
                                                && pi == arrayDeProjetos.size() - 1) {
                                            System.out.println("Projeto não encontrado");
                                        }
                                    }
                                }
                                // editando atividade
                                else if (escolha == 6) {
                                    System.out.println("Qual o id da atividade à ser modificada?");
                                    int idAtividadeModificada = input.nextInt();
                                    int indiceAtividadeModificada;

                                    for (int pi = 0; pi < arrayDeAtividades.size(); pi++) {
                                        if (idAtividadeModificada == arrayDeAtividades.get(pi).idAtividade) {
                                            indiceAtividadeModificada = pi;

                                            System.out.println(
                                                    "   (1) Modificar o id\n   (2) Modificar a descrição\n   (3) Modificar a data de início\n   (4) Modificar a data de término\n   (5) Modificar o responsável\n   (6) Excluir atividade");
                                            int escolhaModificarAtividade = input.nextInt();

                                            if (escolhaModificarAtividade == 1) {
                                                System.out.println("Digite o novo id");
                                                int novoIdAtividade = input.nextInt();
                                                arrayDeAtividades
                                                        .get(indiceAtividadeModificada).idAtividade = novoIdAtividade;
                                                System.out.println("Id modificado com sucesso");

                                            } else if (escolhaModificarAtividade == 2) {
                                                System.out.println("Digite a nova descrição");
                                                String novaDescricao = input.nextLine();
                                                arrayDeAtividades
                                                        .get(indiceAtividadeModificada).descricao = novaDescricao;
                                                System.out.println("Descrição modificada com sucesso");

                                            } else if (escolhaModificarAtividade == 3) {
                                                System.out.println("Digite a nova data de início");
                                                String novaDataInicio = input.nextLine();
                                                arrayDeAtividades
                                                        .get(indiceAtividadeModificada).dataInicio = novaDataInicio;
                                                System.out.println("Data de início modificada com sucesso");

                                            } else if (escolhaModificarAtividade == 4) {
                                                System.out.println("Digite a nova data de término");
                                                String novaDataTermino = input.nextLine();
                                                arrayDeAtividades
                                                        .get(indiceAtividadeModificada).dataTermino = novaDataTermino;
                                                System.out.println("Data de término modificada com sucesso");
                                            } else if (escolhaModificarAtividade == 5) {
                                                System.out.println("Digite o novo responsável");
                                                String novoResponsavel = input.nextLine();
                                                arrayDeAtividades
                                                        .get(indiceAtividadeModificada).responsavel = novoResponsavel;
                                                System.out.println("Responsável modificado com sucesso");
                                            } else if (escolhaModificarAtividade == 6) {
                                                arrayDeAtividades.remove(indiceAtividadeModificada);
                                                System.out.println("Atividade excluida");
                                            }
                                        } else if (idAtividadeModificada != arrayDeAtividades.get(pi).idAtividade
                                                && pi == arrayDeAtividades.size() - 1) {
                                            System.out.println("Atividade não encontrada");
                                        }
                                    }
                                }
                                // procurando usuário, atividade ou projeto
                                else if (escolha == 7) {
                                    System.out.println(
                                            "   (1) Procurar Usuário\n   (2) Procurar Projeto\n   (3) Procurar Atividade");
                                    int escolhaProcurar = input.nextInt();

                                    if (escolhaProcurar == 1) {
                                        System.out.println("Qual o id do usuário?");
                                        int idUsuarioProcurar = input.nextInt();
                                        for (int pi = 0; pi < arrayDeUsuarios.size(); pi++) {
                                            if (idUsuarioProcurar == arrayDeUsuarios.get(pi).idUsuario) {
                                                System.out.println("Usuário encontrado:");
                                                System.out.println(arrayDeUsuarios.get(pi));
                                                pi = arrayDeUsuarios.size();
                                            } else if (idUsuarioProcurar != arrayDeUsuarios.get(pi).idUsuario
                                                    && pi == arrayDeUsuarios.size() - 1) {
                                                System.out.println("Usuário não encontrado");
                                            }
                                        }

                                    } else if (escolhaProcurar == 2) {
                                        System.out.println("Qual o id do projeto?");
                                        int idProjetoProcurar = input.nextInt();
                                        for (int pi = 0; pi < arrayDeProjetos.size(); pi++) {
                                            if (idProjetoProcurar == arrayDeProjetos.get(pi).idProjeto) {
                                                System.out.println("Projeto encontrado:");
                                                System.out.println(arrayDeProjetos.get(pi));
                                                pi = arrayDeProjetos.size();
                                            } else if (idProjetoProcurar != arrayDeProjetos.get(pi).idProjeto
                                                    && pi == arrayDeProjetos.size() - 1) {
                                                System.out.println("Projeto não encontrado");
                                            }
                                        }

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
                                // Relatório
                                else if (escolha == 8) {

                                    if (arrayDeProjetos.isEmpty()) {
                                        System.out.println("Não há nenhum projeto em andamento");
                                    } else {
                                        System.out
                                                .println("Número de projetos em andamento: " + arrayDeProjetos.size());
                                        for (int pi = 0; pi < arrayDeProjetos.size(); pi++) {
                                            System.out.println(arrayDeProjetos.get(pi).idProjeto + " ");
                                        }
                                    }

                                    if (arrayDeAtividades.isEmpty()) {
                                        System.out.println("Não há nenhuma atividade em andamento");
                                    } else {
                                        System.out.println(
                                                "Número de atividades em andamento: " + arrayDeAtividades.size());
                                        for (int pi = 0; pi < arrayDeAtividades.size(); pi++) {
                                            System.out.println(arrayDeAtividades.get(pi).idAtividade + " ");
                                        }
                                    }

                                }
                                // Excluindo, adicionando ou movendo usuários em uma atividade ou projeto
                                // específico
                                else if (escolha == 9) {
                                    System.out.println(
                                            " (1) Adicionar usuário a um projeto\n (1) Remover usuário de um projeto\n (3) Adicionar usuário a uma atividade\n (4) Remover usuário de uma atividade");
                                    int escolhaEditar = input.nextInt();

                                    // adicionar usuário a um projeto
                                    if (escolhaEditar == 1) {
                                        System.out.println("Qual o id do usuário?");
                                        int idUser = input.nextInt();
                                        System.out.println("Qual o id do projeto?");
                                        int idProj = input.nextInt();

                                        // procurando o indice do projeto
                                        for (int pi3 = 0; pi3 < arrayDeProjetos.size(); pi3++) {
                                            if (arrayDeProjetos.get(pi3).idProjeto == idProj) {
                                                arrayDeProjetos.get(pi3).idProfissionais.add(idUser);
                                                System.out.println(arrayDeProjetos.get(pi3).idProfissionais);
                                                pi3 = arrayDeProjetos.size();
                                            }
                                        }

                                    }
                                    // excluindo de um projeto
                                    else if (escolhaEditar == 2) {
                                        System.out.println("Qual o id do usuário?");
                                        int idUser = input.nextInt();
                                        System.out.println("Qual o id do projeto?");
                                        int idProj = input.nextInt();

                                        // procurando o indice do projeto
                                        for (int pi3 = 0; pi3 < arrayDeProjetos.size(); pi3++) {
                                            if (arrayDeProjetos.get(pi3).idProjeto == idProj) {
                                                for (int pii = 0; pii < arrayDeProjetos.get(pi3).idProfissionais
                                                        .size(); pii++) {
                                                    if (arrayDeProjetos.get(pi3).idProfissionais.get(pii) == idUser) {
                                                        arrayDeProjetos.get(pi3).idProfissionais.remove(pii);
                                                        pii = arrayDeProjetos.get(pi3).idProfissionais
                                                                .size();
                                                    }

                                                }
                                                pi3 = arrayDeProjetos.size();
                                                System.out.println(arrayDeProjetos.get(pi3).idProfissionais);
                                            }

                                        }
                                    }
                                    // adicionando em uma atividade
                                    else if (escolhaEditar == 3) {
                                        System.out.println("Qual o id do usuário?");
                                        int idUser = input.nextInt();
                                        System.out.println("Qual o id da atividade?");
                                        int idProj = input.nextInt();

                                        // procurando o indice do projeto
                                        for (int pi3 = 0; pi3 < arrayDeAtividades.size(); pi3++) {
                                            if (arrayDeAtividades.get(pi3).idAtividade == idProj) {
                                                arrayDeAtividades.get(pi3).idProfissionais.add(idUser);
                                                System.out.println(arrayDeAtividades.get(pi3).idProfissionais);
                                                pi3 = arrayDeAtividades.size();
                                            }
                                        }
                                    }
                                    // excluindo de uma atividade
                                    else if (escolhaEditar == 4) {
                                        System.out.println("Qual o id do usuário?");
                                        int idUser = input.nextInt();
                                        System.out.println("Qual o id da atividade?");
                                        int idProj = input.nextInt();

                                        // procurando o indice do projeto
                                        for (int pi3 = 0; pi3 < arrayDeAtividades.size(); pi3++) {
                                            if (arrayDeAtividades.get(pi3).idAtividade == idProj) {
                                                arrayDeAtividades.get(pi3).idProfissionais.remove(idUser);
                                                System.out.println(arrayDeAtividades.get(pi3).idProfissionais);
                                                pi3 = arrayDeAtividades.size();
                                            }
                                        }
                                    }
                                }
                                // Deslogar
                                else if (escolha == 10) {
                                    u = 2;
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
                System.out.println("ID de usuário");
                int idLogIn = input.nextInt();
                System.out.println("Senha");
                int senhaLogIn = input.nextInt();
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
                System.out.println("Alteração de senha");
                System.out.println("Digite seu ID de usuário");
                int idLogIn = input.nextInt();

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
                        System.out.println("ID ou senha inválida");
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