public class ContaOrdem extends Conta{

    public ContaOrdem(){
        super();
    }
//================================================================================================================
    public void informacaoContaOrdem(){
        super.informacao();
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
}
