public class ContaOrdem extends Conta{

    public ContaOrdem(){
        super();
    }
//================================================================================================================
    public void informacao(){
        super.informacao();
        if (getCli() != null) {
            System.out.println("\nSaldo Atual na Conta: " + getCli().getSaldoAtual() + "€");
        }
    }
//================================================================================================================
    public void fazerLevantamento(){

        getCli().setSaldoAtual(getCli().getSaldoAtual() - lerValor("\nValor Levantamento: "));
        System.out.println("\tLevantamento Efetuado!");
        System.out.println("\nSeu Saldo é: " + getCli().getSaldoAtual() + "€");

    }
//================================================================================================================
    public void fazerDeposito(){

        getCli().setSaldoAtual(getCli().getSaldoAtual() + lerValor("\nValor Deposito: "));
        System.out.println("\tDeposito Efetuado!");
        System.out.println("\nSeu Saldo é: " + getCli().getSaldoAtual() + "€");

    }
//================================================================================================================
public boolean levantar(int valor) {

    boolean conseguiuLevantar = true;

    if (valor <= getSaldoConta()) {
        super.levantamento(valor);
    }
    else {
        conseguiuLevantar = false;
        setMensagemDaUltimaOperacao("\tNão tem saldo suficiente!!\n");
    }
    return conseguiuLevantar;
}
//================================================================================================================
    public String toString(){
        return new String("Conta Ordem");
    }
//================================================================================================================
}
