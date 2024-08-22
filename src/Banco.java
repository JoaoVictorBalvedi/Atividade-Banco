import java.util.ArrayList;

public class Banco {
    private ArrayList<String> extrato = new ArrayList<>();

    // Função de depósito
    public void depositar(Cliente cliente, float valor) {
        if (valor > 0) {
            cliente.setSaldo(cliente.getSaldo() + valor);
            extrato.add("Depósito: R$" + valor);
            System.out.println("Depósito de R$" + valor + " realizado com sucesso.");
        } else {
            System.out.println("Valor de depósito inválido.");
        }
    }

    // Função de saque
    public void sacar(Cliente cliente, float valor) {
        if (valor > 0 && valor <= cliente.getSaldo()) {
            cliente.setSaldo(cliente.getSaldo() - valor);
            extrato.add("Saque: R$" + valor);
            System.out.println("Saque de R$" + valor + " realizado com sucesso.");
        } else {
            System.out.println("Saque inválido. Verifique o saldo ou o valor inserido.");
        }
    }

    // Função para consultar saldo
    public void consultarSaldo(Cliente cliente) {
        System.out.println("Saldo atual: R$" + cliente.getSaldo());
    }

    // Função para gerar extrato
    public void gerarExtrato() {
        System.out.println("\n--- Extrato da Conta ---");
        for (String transacao : extrato) {
            System.out.println(transacao);
        }
        if (extrato.isEmpty()) {
            System.out.println("Nenhuma transação registrada.");
        }
    }
}
