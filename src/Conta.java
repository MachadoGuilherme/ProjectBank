public abstract class Conta {

    private static int nextNumber = 0;

    private int numeroDeConta;
    private double saldoConta;

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
//======================================================================================================
}