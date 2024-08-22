import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Banco banco = new Banco();
        Cliente cliente = null;
        int opcaoInicial;

        do {
            System.out.println("\n--- Menu Principal ---");
            System.out.println("1. Cadastrar");
            System.out.println("2. Login");
            System.out.println("3. Sair");
            System.out.print("Escolha uma opção: ");
            opcaoInicial = scanner.nextInt();
            scanner.nextLine(); // Limpa o buffer

            switch (opcaoInicial) {
                case 1:
                    cliente = cadastrarCliente(scanner);
                    break;
                case 2:
                    if (cliente != null && loginCliente(scanner, cliente)) {
                        mostrarMenu(scanner, banco, cliente);
                    } else {
                        System.out.println("Cliente não encontrado ou ainda não cadastrado.");
                    }
                    break;
                case 3:
                    System.out.println("Saindo do sistema. Até logo!");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
                    break;
            }
        } while (opcaoInicial != 3);

        scanner.close();
    }

    public static Cliente cadastrarCliente(Scanner scanner) {
        System.out.print("Digite seu nome: ");
        String nome = scanner.nextLine();
        System.out.print("Digite sua idade: ");
        int idade = scanner.nextInt();
        System.out.print("Digite seu saldo inicial: ");
        float saldo = scanner.nextFloat();
        scanner.nextLine(); // Limpa o buffer do teclado
        System.out.print("Digite seu endereço: ");
        String endereco = scanner.nextLine();
        System.out.print("Digite seu telefone: ");
        String telefone = scanner.nextLine();
        System.out.print("Digite seu email: ");
        String email = scanner.nextLine();

        Cliente novoCliente = new Cliente(nome, idade, saldo, endereco, telefone, email);
        System.out.println("Cadastro realizado com sucesso!");
        return novoCliente;
    }

    public static boolean loginCliente(Scanner scanner, Cliente cliente) {
        System.out.print("Digite seu nome para login: ");
        String nome = scanner.nextLine();
        return cliente.getNome().equalsIgnoreCase(nome);
    }

    public static void mostrarMenu(Scanner scanner, Banco banco, Cliente cliente) {
        int opcao;

        do {
            System.out.println("\n--- Menu Bancário ---");
            System.out.println("1. Consultar Saldo");
            System.out.println("2. Depositar");
            System.out.println("3. Sacar");
            System.out.println("4. Gerar Extrato");
            System.out.println("5. Alterar Dados");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpa o buffer

            switch (opcao) {
                case 1:
                    banco.consultarSaldo(cliente);
                    break;
                case 2:
                    System.out.print("Digite o valor a ser depositado: ");
                    float valorDeposito = scanner.nextFloat();
                    banco.depositar(cliente, valorDeposito);
                    break;
                case 3:
                    System.out.print("Digite o valor a ser sacado: ");
                    float valorSaque = scanner.nextFloat();
                    banco.sacar(cliente, valorSaque);
                    break;
                case 4:
                    banco.gerarExtrato();
                    break;
                case 5:
                    alterarDadosCliente(scanner, cliente);
                    break;
                case 6:
                    System.out.println("Voltando ao menu principal.");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
                    break;
            }
        } while (opcao != 6);
    }

    public static void alterarDadosCliente(Scanner scanner, Cliente cliente) {
        System.out.print("Digite o novo nome: ");
        String nome = scanner.nextLine();
        System.out.print("Digite a nova idade: ");
        int idade = scanner.nextInt();
        scanner.nextLine(); // Limpa o buffer do teclado
        System.out.print("Digite o novo endereço: ");
        String endereco = scanner.nextLine();
        System.out.print("Digite o novo telefone: ");
        String telefone = scanner.nextLine();
        System.out.print("Digite o novo email: ");
        String email = scanner.nextLine();

        cliente.alterarDados(nome, idade, endereco, telefone, email);
    }
}
