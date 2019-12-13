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
    public void informacao(){
        System.out.println(toString() + "\n\tNumero De Conta: " + numeroDeConta);
        if (cli == null){
            System.out.println("\n\tSem Cliente Associado!\n");
        }
        else{
            System.out.println("Cliente: " + cli.getNomeCliente());
        }
    }
//======================================================================================================
    public void depositar(double valor){
        saldoConta = saldoConta + valor;
    }
//======================================================================================================
    public void levantamento(double valor){
        saldoConta = saldoConta - valor;
        System.out.println("\tLevantamento Efetuado!\n");
        //return true;
    }
//======================================================================================================
    public double lerValor(String mensagem) {
        Scanner input = new Scanner(System.in);

        System.out.println(mensagem);
        double v = input.nextDouble();
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
    public String getMensagemDaUltimaOperacao() {
        return mensagemDaUltimaOperacao;
    }

    public void setMensagemDaUltimaOperacao(String mensagemDaUltimaOperacao) {
        this.mensagemDaUltimaOperacao = mensagemDaUltimaOperacao;
    }
//======================================================================================================
}