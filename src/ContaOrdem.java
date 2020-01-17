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

        levantamento(lerValor("\nValor Levantamento: "));
    }
//================================================================================================================
    public void fazerDeposito(){

        depositar(lerValor("\nValor A Depositar: "));
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
