public class ContaPolpanca extends Conta {

    private double juros;
//=================================================================================================================
    public ContaPolpanca(){
        super();
        juros = 2.15;
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
        depositar(lerValor("Valor do Deposito: "));
    }
//=================================================================================================================
    public void informacaoContaPolpanca(){
        super.informacao();
        System.out.println("Saldo: " + getSaldoConta());
    }
//=================================================================================================================
    public int getSaldo(){
        int s = super.getSaldoConta();
        s *= juros;
        return s;
    }
//=================================================================================================================
}