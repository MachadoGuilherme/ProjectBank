public class ContaPolpanca extends Conta {

    private double juros;
//=================================================================================================================
    public ContaPolpanca(){
        super();
        juros = 2.15;
    }
//=================================================================================================================
    public boolean levantar(double valor){
        setMensagemDaUltimaOperacao("\tAinda Não Pode Realizar Levantamentos!\n");
        return false;
    }
//=================================================================================================================
    public void fazerLevantamento(){
        System.out.println("\tNão é Possivel Realizar Levantamentos\n");
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
    public double getSaldo(){
        double s = super.getSaldoConta();
        s *= juros;
        return s;
    }
//=================================================================================================================
}
