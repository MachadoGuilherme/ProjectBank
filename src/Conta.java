import java.util.Scanner;

public abstract class Conta {

    private static int nextNumber = 0;

    private int numeroDeConta;
    private int saldoConta;
    private String mensagemDaUltimaOperacao;

    private Cliente cli;
//======================================================================================================
    public Conta(){
        ++nextNumber;
        numeroDeConta = nextNumber;

        saldoConta = 0;
        cli = null;
    }
//======================================================================================================
    public void informacao(){
        System.out.println(toString() + "\nNumero De Conta: " + numeroDeConta);
        if (cli == null){
            System.out.println("\n\tSem Cliente Associado!\n");
        }
        else{
            //System.out.println("Cliente: " + cli.getNomeCliente());
            cli.informacaoCliente();
        }
    }
//======================================================================================================
    public void depositar(int valor){
        saldoConta = saldoConta + valor;
        cli.setSaldoAtual((cli.getSaldoAtual()) + saldoConta);
        System.out.println("\tDeposito Efetuado!");
    }
    public void fazerDeposito(){

    }
//======================================================================================================
    public void levantamento(int valor){
        saldoConta = saldoConta - valor;
        cli.setSaldoAtual((cli.getSaldoAtual()) - saldoConta);
        System.out.println("\tLevantamento Efetuado!");
        //return true;
    }
    public void fazerLevantamento(){

    }
//======================================================================================================
    public int lerValor(String mensagem) {
        Scanner input = new Scanner(System.in);

        System.out.println(mensagem);
        int v = input.nextInt();
        return v;
    }
//======================================================================================================
    public Cliente getCli() {

        return cli;
    }
    public void setCli(Cliente cli) {

        this.cli = cli;
    }

    public int getNumeroDeConta() {

        return numeroDeConta;
    }

    public int getSaldoConta() {

        return saldoConta;
    }
    public String getMensagemDaUltimaOperacao() {
        return mensagemDaUltimaOperacao;
    }

    public void setMensagemDaUltimaOperacao(String mensagemDaUltimaOperacao) {
        this.mensagemDaUltimaOperacao = mensagemDaUltimaOperacao;
    }
//======================================================================================================
}