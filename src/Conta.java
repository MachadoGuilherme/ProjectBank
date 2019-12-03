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
}