import java.util.Scanner;

public class Cliente {

    private String nomeCliente = "";
    private String telefone = "";
    private String email = "";
    private String profissao = "";
    private int numeroCliente = 0;
    private static int proximoCliente = 0;
    private double saldoInicial = 0;
    private double saldoAtual = 0;
    private int clientePrivado = 0;
    public int escolhaClientePrivado = 0;
    public int escolhaClientePrivate = 1;

    private Cartoes ca;
//============================================================================================================
    public void informacaoCliente(){

        if (getClientePrivado() == 1){
            gestorContaUm();
        }
        else{
            gestorContaDois();
        }

        System.out.println("\t•• Dados do Cliente ••\n");
        System.out.println("Numero de Cliente: " + getNumeroCliente());
        System.out.println("Nome: " + getNomeCliente());
        System.out.println("Telefone: " + getTelefone());
        System.out.println("e-mail: " + getEmail());
        System.out.println("Profissão: " + getProfissao());

    }
//============================================================================================================
    public void cadastroCliente(){
        Scanner entrada = new Scanner(System.in);

        System.out.println("\n\tCadastro de Cliente");

        do {
            System.out.println("\nCliente VIP ou Normal ?\n");
            System.out.println("1 - VIP");
            System.out.println("2 - Normal");
            System.out.print("\nEscolha a Opção Desejada: ");
            escolhaClientePrivado = entrada.nextInt();

            if(escolhaClientePrivado < 1 || escolhaClientePrivado > 2) {
                System.out.println("\n\tOpcao Invalida!");
            }

            if (escolhaClientePrivado == 1){
                setClientePrivado(1);
                escolhaClientePrivate = 0;
            }
            if (escolhaClientePrivado == 2){
                setClientePrivado(2);
                escolhaClientePrivate = 0;
            }
        }while (escolhaClientePrivate != 0);

        entrada.nextLine();
        System.out.print("\nNome: ");
        nomeCliente = entrada.nextLine().toUpperCase();
        System.out.print("Telefone: ");
        telefone = entrada.nextLine().toLowerCase();
        System.out.print("e-mail: ");
        email = entrada.next().toLowerCase();
        entrada.nextLine();
        System.out.print("Profissão: ");
        profissao = entrada.nextLine().toUpperCase();
        do{
            System.out.print("\nSaldo Inicial: ");
            saldoInicial = entrada.nextDouble();
            if(saldoInicial < 100){
                System.out.println("\n==> Saldo Inicial Deve Ser no Minimo 100€ <==");
            }
            else {
                saldoAtual = saldoInicial;
            }
        }while (saldoInicial < 100);

        ++proximoCliente;
        numeroCliente = proximoCliente;

        System.out.println("\nCliente " + getNomeCliente() + " Cadastrado Com Sucesso!\nNumero de Cliente: " + getNumeroCliente());
    }
//============================================================================================================
    public void editarDadosClienteBanco(){
        Scanner entrada = new Scanner(System.in);

        System.out.print("\nNome Anterior: " + getNomeCliente() + "\nNovo Nome: ");
        setNomeCliente(entrada.nextLine().toUpperCase());
        System.out.print("Telefone Anterior: " + getTelefone() + "\nNovo Telenofe: ");
        setTelefone(entrada.nextLine().toLowerCase());
        System.out.print("e-mail Anterior: " + getEmail() + "\nNovo e-mail: ");
        setEmail(entrada.next().toLowerCase());
        entrada.nextLine();
        System.out.print("Profissão Anterior: " + getProfissao() + "\nNova Profissão: ");
        setProfissao(entrada.nextLine().toUpperCase());

        System.out.println("\nDados Alterado com Sucesso!");
    }
//============================================================================================================
    public void editarDadosCliente(){
        Scanner entrada = new Scanner(System.in);

        System.out.print("\nTelefone Anterior: " + getTelefone() + "\nNovo Telenofe: ");
        setTelefone(entrada.nextLine().toLowerCase());
        System.out.print("e-mail Anterior: " + getEmail() + "\nNovo e-mail: ");
        setEmail(entrada.next().toLowerCase());

        System.out.println("\nDados Alterado com Sucesso!");
    }
//============================================================================================================
    public void gestorContaUm(){
        System.out.println("\n\tCliente VIP\n\n\t•• Seu Gestor de Conta é ••\n");
        System.out.println("Gestor: Hulk");
        System.out.println("Telefone: 987 654 321\nRamal: 123");
        System.out.println("e-mail: hulk@mybank.com\n");
    }
//============================================================================================================
    public void gestorContaDois(){
        System.out.println("\n\t•• Seu Gestor de Conta é ••\n");
        System.out.println("Lucy");
        System.out.println("Telefone: 001 002 003\nRamal: 321");
        System.out.println("e-mail: lucy@mybank.com\n");
    }
//============================================================================================================
    public String getNomeCliente() {
        return nomeCliente;
    }
    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
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

    public double getSaldoInicial() {

        return saldoInicial;
    }
    public void setSaldoInicial(double saldoInicial) {

        this.saldoInicial = saldoInicial;
    }

    public double getSaldoAtual() {

        return saldoAtual;
    }
    public void setSaldoAtual(double saldoAtual) {

        this.saldoAtual = saldoAtual;
    }

    public Cartoes getCa() {
        return ca;
    }
    public void setCa(Cartoes ca) {
        this.ca = ca;
    }


    public int getClientePrivado() {
        return clientePrivado;
    }

    public void setClientePrivado(int clientePrivado) {
        this.clientePrivado = clientePrivado;
    }
//============================================================================================================
}
