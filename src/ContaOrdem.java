public class ContaOrdem extends Conta{

    public ContaOrdem(){
        super();
    }
//================================================================================================================
    public void informacaoContaOrdem(){
        super.informacao();
    }
//================================================================================================================
    public void fazerLevantaento(){
        levantamento(lerValor("Valor Levantamento: "));
    }
//================================================================================================================
    public void fazerDeposito(){
        depositar(lerValor("Valor A Depositar: "));
    }
//================================================================================================================
public boolean levantar(double valor) {

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
