public class Cliente {
    private String nome;
    private int idade;
    private float saldo;
    private String endereco;
    private String telefone;
    private String email;

    public Cliente(String nome, int idade, float saldo, String endereco, String telefone, String email) {
        this.nome = nome;
        this.idade = idade;
        this.saldo = saldo;
        this.endereco = endereco;
        this.telefone = telefone;
        this.email = email;
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Função para alterar os dados do usuário
    public void alterarDados(String nome, int idade, String endereco, String telefone, String email) {
        this.nome = nome;
        this.idade = idade;
        this.endereco = endereco;
        this.telefone = telefone;
        this.email = email;
        System.out.println("Dados alterados com sucesso!");
    }
}
