public class ContaPolpanca extends Conta {

    private double juros;
//=================================================================================================================
    public ContaPolpanca(){
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

        depositar(lerValor("Valor do Deposito: "));
    }
//=================================================================================================================
    public void informacao(){
        super.informacao();
        System.out.println("\nSaldo Atual na Conta: " + getSaldo() + "€");
    }
//=================================================================================================================
    public double getSaldo(){
        double s = super.getCli().getSaldoAtual();
        s = (s * juros) / 100 + s;
        return s;
    }
//=================================================================================================================
    public String toString(){
        return new String("Conta Polpança");
    }
//=================================================================================================================
}
