import java.util.Scanner;

public class Estoque {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        final int maxProdutos = 100;
        int[][] estoque = new int[maxProdutos][2]; // [0] - Código do produto, [1] - Quantidade

        int opcao;
        do {
            System.out.println("=======Bem Vindo a G&P Sports=======");
            System.out.println("1. Cadastrar produto");
            System.out.println("2. Registrar entrada de produtos");
            System.out.println("3. Registrar saída de produtos");
            System.out.println("4. Verificar saldo de um produto");
            System.out.println("5. Mostrar estoque");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            System.out.println("====================================");

            switch (opcao) {
                case 1:
                    cadastrarProduto(estoque, scanner);
                    break;
                case 2:
                    registrarEntrada(estoque, scanner);
                    break;
                case 3:
                    registrarSaida(estoque, scanner);
                    break;
                case 4:
                    verificarSaldo(estoque, scanner);
                    break;
                case 5:

                    break;
                case 6:
                    System.out.println("Saindo do programa.");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 6);

        scanner.close();
    }

    public static void registrarEntrada(int[][] estoque, Scanner scanner) {
        System.out.print("Digite o código do produto: ");
        int codigo = scanner.nextInt();

        System.out.print("Digite a quantidade a ser adicionada: ");
        int quantidade = scanner.nextInt();

        int indiceProduto = encontrarProduto(estoque, codigo);

        if (indiceProduto != -1) {
            estoque[indiceProduto][1] += quantidade;
            System.out.println("Entrada registrada com sucesso!");
        } else {
            adicionarProduto(estoque, codigo, quantidade);
        }
    }

    public static void registrarSaida(int[][] estoque, Scanner scanner) {
        System.out.print("Digite o código do produto: ");
        int codigo = scanner.nextInt();

        System.out.println("Digite a quantidade a ser retirada: ");
        int quantidade = scanner.nextInt();

        int indiceProduto = encontrarProduto(estoque, codigo);

        if (indiceProduto != -1) {
            if (estoque[indiceProduto][1] >= quantidade) {
                estoque[indiceProduto][1] -= quantidade;
                System.out.println("Saída registrada com sucesso!");
            } else {
                System.out.println("Quantidade insuficiente em estoque.");
            }
        } else {
            System.out.println("Produto não encontrado no estoque.");
        }
    }

    public static void verificarSaldo(int[][] estoque, Scanner scanner) {
        System.out.print("Digite o código do produto: ");
        int codigo = scanner.nextInt();

        int indiceProduto = encontrarProduto(estoque, codigo);

        if (indiceProduto != -1) {
            System.out.println("Saldo atual do produto: " + estoque[indiceProduto][1]);
        } else {
            System.out.println("Produto não encontrado no estoque.");
        }
    }

    public static int encontrarProduto(int[][] estoque, int codigo) {
        for (int i = 0; i < estoque.length; i++) {
            if (estoque[i][0] == codigo) {
                return i;
            }
        }
        return -1;
    }

    public static void adicionarProduto(int[][] estoque, int codigo, int quantidade) {
        for (int i = 0; i < estoque.length; i++) {
            if (estoque[i][0] == 0) {
                estoque[i][0] = codigo;
                estoque[i][1] = quantidade;
                System.out.println("Produto adicionado ao estoque!");
                break;
            }
        }
    }

    public static void cadastrarProduto(int[][] estoque, Scanner scanner) {
        System.out.println("Digite o nome do produto: ");
        String nome = scanner.next();
        System.out.print("Digite o código do novo produto: ");
        int codigo = scanner.nextInt();
        if (encontrarProduto(estoque, codigo) == -1) {
            System.out.print("Digite a quantidade inicial do produto: ");
            int quantidadeInicial = scanner.nextInt();

            adicionarProduto(estoque, codigo, quantidadeInicial);
            System.out.println("Produto cadastrado com sucesso!");
        } else {
            System.out.println("Já existe um produto com esse código no estoque.");
        }
    }

    public static void mostrarEstoque(String[][] estoque) {
        System.out.println("===== Estoque =====");
        System.out.println("Código | Nome | Quantidade");

        for (int i = 0; i < estoque.length; i++) {
            if (estoque[i][0] != null) {
                System.out.println(estoque[i][0] + " | " + estoque[i][1] + " | " + estoque[i][2]);
            }
        }
    }
}






