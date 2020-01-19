import java.util.Scanner;

public abstract class Conta {

    private static int nextNumber = 0;

    private int numeroDeConta;
    private double saldoConta;
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
    public void infoTipoConta(){
        System.out.println("\n" + toString() + " Está Selecionada");
    }
//======================================================================================================
    public void informacao(){
        System.out.println("\n\t----------------------");
        System.out.println("\t|•• Dados de Conta ••|");
        System.out.println("\t----------------------\n");
        System.out.println("Tipo de Conta: " + toString() + "\nNumero De Conta: " + numeroDeConta);
        if (cli == null){
            System.out.println("\n\tSem Cliente Associado!\n");
        }
        else{
            cli.informacaoCliente();
        }
    }
//======================================================================================================
    public void depositar(double valor){

    }
    public void fazerDeposito(){

    }
//======================================================================================================
    public void levantamento(double valor){

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

    public double getSaldoConta() {

        return saldoConta;
    }

    public void setSaldoConta(double saldoConta) {
        this.saldoConta = saldoConta;
    }

    public String getMensagemDaUltimaOperacao() {
        return mensagemDaUltimaOperacao;
    }

    public void setMensagemDaUltimaOperacao(String mensagemDaUltimaOperacao) {
        this.mensagemDaUltimaOperacao = mensagemDaUltimaOperacao;
    }
//======================================================================================================
}