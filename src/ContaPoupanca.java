public class ContaPoupanca extends Conta {

    private double juros;
//=================================================================================================================
    public ContaPoupanca(){
        super();
        juros = 1.15;
    }
//=================================================================================================================
    public boolean levantar(int valor){
        setMensagemDaUltimaOperacao("\n\tAinda Não Pode Realizar Levantamentos");
        return false;
    }
//=================================================================================================================
    public void fazerLevantamento(){

        System.out.println("\n\tNão é Possivel Realizar Levantamentos");
    }
//=================================================================================================================
    public void fazerDeposito(){

        getCli().setSaldoAtual(getCli().getSaldoAtual() + lerValor("\nValor Deposito: "));
        System.out.println("\tDeposito Efetuado!");
        System.out.println("\nSeu Saldo é: " + getCli().getSaldoAtual() + "€");

    }
//=================================================================================================================
    public void informacao(){
        super.informacao();
        if (getCli() != null) {
            System.out.println("\nSaldo Atual na Conta: " + getSaldo() + "€");
        }
    }
//=================================================================================================================
    public double getSaldo(){
        double s = super.getCli().getSaldoAtual();
        s = (s * juros) / 100 + s;
        return s;
    }
//=================================================================================================================
    public String toString(){
        return new String("Conta Poupança");
    }
//=================================================================================================================
}
