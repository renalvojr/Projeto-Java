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
            System.out.println("======= Sistema de Gerenciamento =======");
            System.out.println(
                    "   (1) Adicionar um Usuário\n   (2) Adicionar um Projeto\n   (3) Adicionar uma Atividade\n   (4) Editar um Usuáro\n   (5) Editar um Projeto\n   (6) Editar uma Atividade\n   (7) Procurar por um Usuário, Atividade ou Projeto\n   (8) Sair");

            // pegando o input do usuário
            int escolha = input.nextInt();

            if (escolha == 1) {
                System.out.println("Digite o id do novo usuário que está sendo criado");
                int idUsuario = input.nextInt();
                arrayDeUsuarios.add(new Usuario(idUsuario));
                System.out.println("Usuário criado");

                for (int i = 0; i < arrayDeUsuarios.size(); i++) {
                    System.out.println(arrayDeUsuarios.get(i).idUsuario);
                }

            } else if (escolha == 2) {
                System.out.println(
                        "Digite o id, descrição, data de início, data de término, e o coordenador, respectivamente");
                int idProjeto = input.nextInt();
                input.nextLine();
                String descricaoProjeto = input.nextLine();
                String dataInicio = input.nextLine();
                String dataTermino = input.nextLine();
                String coordenador = input.nextLine();
                arrayDeProjetos.add(new Projeto(idProjeto, descricaoProjeto, dataInicio, dataTermino, coordenador));

            } else if (escolha == 3) {
                System.out.println(
                        "Digite o id, descrição, data de início, data de término e o responsável, respectivamente");
                int idAtividade = input.nextInt();
                input.nextLine();
                String descricaoAtividade = input.nextLine();
                String dataInicio = input.nextLine();
                String dataTermino = input.nextLine();
                String responsavel = input.nextLine();
                arrayDeAtividades
                        .add(new Atividade(idAtividade, descricaoAtividade, dataInicio, dataTermino, responsavel));

            } else if (escolha == 4) {
                System.out.println(("Qual o id do usuário à ser modificado?"));
                int idUsuarioModificado = input.nextInt();
                int indiceUsuarioModificado;

                // encontrando o indice do usuário em questão
                for (int i = 0; i < arrayDeUsuarios.size(); i++) {
                    if (idUsuarioModificado == arrayDeUsuarios.get(i).idUsuario) {
                        indiceUsuarioModificado = i;

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
                    } else if (idUsuarioModificado != arrayDeUsuarios.get(i).idUsuario
                            && i == arrayDeUsuarios.size() - 1) {
                        System.out.println("Esse usuário não existe");
                    }
                }

            } else if (escolha == 5) {
                System.out.println(("Qual o id do projeto à ser modificado?"));
                int idProjetoModificado = input.nextInt();
                int indiceProjetoModificado;

                for (int i = 0; i < arrayDeProjetos.size(); i++) {
                    if (idProjetoModificado == arrayDeProjetos.get(i).idProjeto) {
                        indiceProjetoModificado = i;

                        System.out.println(
                                "   (1) Modificar id\n   (2) Modificar descrição\n   (3) Modificar data de início\n   (4) Modificar data de término\n   (5) Modificar coordenador");
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
                            arrayDeProjetos.get(indiceProjetoModificado).dataInicio = novaDataInicio;
                            System.out.println("Data de início modificada com sucesso");

                        } else if (escolhaModificar == 4) {
                            System.out.println("Digite a nova data de término");
                            String novaDataTermino = input.nextLine();
                            arrayDeProjetos.get(indiceProjetoModificado).dataTermino = novaDataTermino;

                        } else if (escolhaModificar == 5) {
                            System.out.println("Digite o nome do novo coordenador");
                            String novoCoordenador = input.nextLine();
                            arrayDeProjetos.get(indiceProjetoModificado).coordenador = novoCoordenador;
                        }
                    } else if (idProjetoModificado != arrayDeProjetos.get(i).idProjeto
                            && i == arrayDeProjetos.size() - 1) {
                        System.out.println("Projeto não encontrado");
                    }
                }

            } else if (escolha == 6) {
                System.out.println("Qual o id da atividade à ser modificada?");
                int idAtividadeModificada = input.nextInt();
                int indiceAtividadeModificada;

                for (int i = 0; i < arrayDeAtividades.size(); i++) {
                    if (idAtividadeModificada == arrayDeAtividades.get(i).idAtividade) {
                        indiceAtividadeModificada = i;

                        System.out.println(
                                "   (1) Modificar o id\n   (2) Modificar a descrição\n   (3) Modificar a data de início\n   (4) Modificar a data de término\n   (5) Modificar o responsável");
                        int escolhaModificarAtividade = input.nextInt();

                        if (escolhaModificarAtividade == 1) {
                            System.out.println("Digite o novo id");
                            int novoIdAtividade = input.nextInt();
                            arrayDeAtividades.get(indiceAtividadeModificada).idAtividade = novoIdAtividade;
                            System.out.println("Id modificado com sucesso");

                        } else if (escolhaModificarAtividade == 2) {
                            System.out.println("Digite a nova descrição");
                            String novaDescricao = input.nextLine();
                            arrayDeAtividades.get(indiceAtividadeModificada).descricao = novaDescricao;
                            System.out.println("Descrição modificada com sucesso");

                        } else if (escolhaModificarAtividade == 3) {
                            System.out.println("Digite a nova data de início");
                            String novaDataInicio = input.nextLine();
                            arrayDeAtividades.get(indiceAtividadeModificada).dataInicio = novaDataInicio;
                            System.out.println("Data de início modificada com sucesso");

                        } else if (escolhaModificarAtividade == 4) {
                            System.out.println("Digite a nova data de término");
                            String novaDataTermino = input.nextLine();
                            arrayDeAtividades.get(indiceAtividadeModificada).dataTermino = novaDataTermino;
                            System.out.println("Data de término modificada com sucesso");
                        } else if (escolhaModificarAtividade == 5) {
                            System.out.println("Digite o novo responsável");
                            String novoResponsavel = input.nextLine();
                            arrayDeAtividades.get(indiceAtividadeModificada).responsavel = novoResponsavel;
                            System.out.println("Responsável modificado com sucesso");
                        }
                    } else if (idAtividadeModificada != arrayDeAtividades.get(i).idAtividade
                            && i == arrayDeAtividades.size() - 1) {
                        System.out.println("Atividade não encontrada");
                    }
                }

            } else if (escolha == 7) {
                System.out.println("   (1) Procurar Usuário\n   (2) Procurar Projeto\n   (3) Procurar Atividade");
                int escolhaProcurar = input.nextInt();

                if (escolhaProcurar == 1) {
                    System.out.println("Qual o id do usuário?");
                    int idUsuarioProcurar = input.nextInt();
                    for (int i = 0; i < arrayDeUsuarios.size(); i++) {
                        if (idUsuarioProcurar == arrayDeUsuarios.get(i).idUsuario) {
                            System.out.println("Usuário encontrado:");
                            System.out.println(arrayDeUsuarios.get(i));
                            i = arrayDeUsuarios.size();
                        } else if (idUsuarioProcurar != arrayDeUsuarios.get(i).idUsuario
                                && i == arrayDeUsuarios.size() - 1) {
                            System.out.println("Usuário não encontrado");
                        }
                    }

                } else if (escolhaProcurar == 2) {
                    System.out.println("Qual o id do projeto?");
                    int idProjetoProcurar = input.nextInt();
                    for (int i = 0; i < arrayDeProjetos.size(); i++) {
                        if (idProjetoProcurar == arrayDeProjetos.get(i).idProjeto) {
                            System.out.println("Projeto encontrado:");
                            System.out.println(arrayDeProjetos.get(i));
                            i = arrayDeProjetos.size();
                        } else if (idProjetoProcurar != arrayDeProjetos.get(i).idProjeto
                                && i == arrayDeProjetos.size() - 1) {
                            System.out.println("Projeto não encontrado");
                        }
                    }

                } else if (escolhaProcurar == 3) {
                    System.out.println("Qual o id da atividade?");
                    int idAtividadeProcurar = input.nextInt();
                    for (int i = 0; i < arrayDeAtividades.size(); i++) {
                        if (idAtividadeProcurar == arrayDeAtividades.get(i).idAtividade) {
                            System.out.println("Atividade encontrada:");
                            System.out.println(arrayDeAtividades.get(i));
                            i = arrayDeAtividades.size();
                        } else if (idAtividadeProcurar != arrayDeAtividades.get(i).idAtividade
                                && i == arrayDeAtividades.size() - 1) {
                            System.out.println("Atividade não encontrada");
                        }
                    }
                }

            } else if (escolha == 8) {
                input.close();
                System.exit(0);
            }
        }
    }
}