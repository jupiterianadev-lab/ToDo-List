import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class ToDoList {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ArrayList<Task> Task = new ArrayList<>();
        boolean executando = true;

        System.out.println("===== SISTEMA DE GESTÃO DE TAREFAS =====");

        while (executando) {
            System.out.println("\n========= MENU PRINCIPAL =========");
            System.out.println("1- Adicionar nova tarefa");
            System.out.println("2- Listar tarefas pendentes");
            System.out.println("3- Buscar tarefa por título");
            System.out.println("4- Marcar tarefa como concluída");
            System.out.println("5- Remover tarefa");
            System.out.println("0- Encerrar o sistema");
            System.out.println("===================================");
            System.out.println("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1 -> {
                    System.out.println("\nTítulo da tarefa: ");
                    String titulo = scanner.nextLine();

                    System.out.println("Descrição da tarefa: ");
                    String descricao = scanner.nextLine();

                    System.out.println("Data de entrega (AAAA-MM-DD): ");
                    LocalDate dataEntrega = LocalDate.parse(scanner.nextLine());

                    Task novaTarefa = new Task(titulo, descricao, dataEntrega);
                    Task.add(novaTarefa);
                    System.out.println("\n✅ Tarefa adicionada com sucesso!");
                }

                case 2 -> {
                    System.out.println("\n=== TAREFAS PENDENTES ===");
                    boolean existePendente = false;

                    for (Task t : Task) {
                        if (!t.isConcluida()) {
                            System.out.println(t);
                            existePendente = true;
                        }
                    }

                    if (!existePendente) {
                        System.out.println("Nenhuma tarefa pendente no momento.");
                    }
                }

                case 3 -> {
                    System.out.println("\nDigite o título da tarefa: ");
                    String tituloBusca = scanner.nextLine();
                    boolean encontrada = false;

                    for (Task t : Task) {
                        if (t.getTitulo().equalsIgnoreCase(tituloBusca)) {
                            System.out.println(t);
                            encontrada = true;
                        }
                    }

                    if (!encontrada) {
                        System.out.println("\n⚠️ Nenhuma tarefa encontrada com esse título.");
                    }
                }

                case 4 -> {
                    System.out.println("\nInforme o título da tarefa a concluir: ");
                    String tituloConcluir = scanner.nextLine();
                    boolean encontrada = false;

                    for(Task t : Task) {
                        if (t.getTitulo().equalsIgnoreCase(tituloConcluir)) {
                            t.setConcluida(true);
                            System.out.println("\n✅ Tarefa marcada como concluída!");
                            encontrada = true;
                            break;
                        }
                    }

                    if (encontrada) {
                        System.out.println("\n⚠️ Tarefa não encontrada.");
                    }
                }

                case 5 -> {
                    System.out.println("\nDigite o título da tarefa a ser removida: ");
                    String tituloRemover = scanner.nextLine();
                    boolean removida = Task.removeIf(t -> t.getTitulo().equalsIgnoreCase(tituloRemover));

                    if (removida) {
                        System.out.println("\n🗑️ Tarefa removida com sucesso!");
                    } else {
                        System.out.println("\n⚠️ Nenhuma tarefa com esse título foi encontrada.");
                    }
                }

                case 0 -> {
                    System.out.println("\n🔚 Encerrando o sistema... Até logo!");
                    executando = false;
                }

                default -> System.out.println("\nOpção inválida. Tente novamente.");
            }
        }

        scanner.close();
    }
}
