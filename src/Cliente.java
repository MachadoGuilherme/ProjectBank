import java.util.Scanner;

public class Cliente {

    private String nomeCliente = "";
    private int telefone = 0;
    private String email = "";
    private String profissao = "";
    private int numeroCliente = 0;
    private static int proximoCliente = 0;
    private int saldoInicial = 0;
    private int saldoAtual = 0;
//============================================================================================================
    public void informacaoCliente(){
        Cartoes ca = new Cartoes();

        System.out.println("Numero de Cliente: " + getNumeroCliente());
        System.out.println("Nome: " + getNomeCliente());
        System.out.println("Telefone: " + getTelefone());
        System.out.println("e-mail: " + getEmail());
        System.out.println("Profissão: " + getProfissao());

        if (ca.getLimiteCartao() != 0) {
            System.out.println("Cartão: " + ca.getTipoCartao());
            System.out.println("Limite Atual do Cartão é: " + ca.getLimiteCartao() + "€");
            System.out.println("Saldo Disponivel: " + ca.getSaldoCartaoCredito() + "€");
        }

        System.out.println("\nSaldo Atual na Conta: " + saldoAtual + "€");
    }
//============================================================================================================
    public void cadastroCliente(){
        Scanner entrada = new Scanner(System.in);

        System.out.print("\nNome: ");
        nomeCliente = entrada.nextLine().toUpperCase();
        System.out.print("Telefone: ");
        telefone = entrada.nextInt();
        System.out.print("e-mail: ");
        email = entrada.next().toLowerCase();
        System.out.print("Profissão: ");
        profissao = entrada.next().toUpperCase();
        do{
            System.out.print("\nSaldo Inicial: ");
            saldoInicial = entrada.nextInt();
            if(saldoInicial < 100){
                System.out.println("\n==> Saldo Inicial Deve Ser no Minimo 100€ <==");
            }
            else {
                saldoAtual = saldoInicial;
            }
        }while (saldoInicial < 100);

        ++proximoCliente;
        numeroCliente = proximoCliente;

        System.out.println("\nNumero de Cliente: " + getNumeroCliente());
    }
//============================================================================================================
    public void editarDadosClienteBanco(){
        Scanner entrada = new Scanner(System.in);

        System.out.print("\nNome Anterior: " + getNomeCliente() + "\nNovo Nome: ");
        setNomeCliente(entrada.nextLine().toUpperCase());
        System.out.print("Telefone Anterior: " + getTelefone() + "\nNovo Telenofe: ");
        setTelefone(entrada.nextInt());
        System.out.print("e-mail Anterior: " + getEmail() + "\nNovo e-mail: ");
        setEmail(entrada.next().toLowerCase());
        System.out.print("Profissão Anterior: " + getProfissao() + "\nNova Profissão: ");
        setProfissao(entrada.next().toUpperCase());

        System.out.println("\nDados Alterado com Sucesso!");
    }
//============================================================================================================
    public void editarDadosCliente(){
        Scanner entrada = new Scanner(System.in);

        System.out.print("\nTelefone Anterior: " + getTelefone() + "\nNovo Telenofe: ");
        setTelefone(entrada.nextInt());
        System.out.print("e-mail Anterior: " + getEmail() + "\nNovo e-mail: ");
        setEmail(entrada.next().toLowerCase());

        System.out.println("\nDados Alterado com Sucesso!");
    }
//============================================================================================================
    public String getNomeCliente() {
        return nomeCliente;
    }
    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public int getTelefone() {
        return telefone;
    }
    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getProfissao() {
        return profissao;
    }
    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    public int getNumeroCliente(){
        return numeroCliente;
    }
    public void setNumeroCliente(int numeroCliente){
        this.numeroCliente = numeroCliente;
    }

    public int getSaldoInicial() {
        return saldoInicial;
    }
    public void setSaldoInicial(int saldoInicial) {
        this.saldoInicial = saldoInicial;
    }

    public int getSaldoAtual() {
        return saldoAtual;
    }
    public void setSaldoAtual(int saldoAtual) {
        this.saldoAtual = saldoAtual;
    }
//============================================================================================================
}
