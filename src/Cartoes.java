import java.util.Scanner;

public abstract class Cartoes {

    private static int nextNumber = 0;

    private int idCartao;
    private int numeroCartao = 0;
    private String nomeCartao;
    private String tipoCartao = "CREDITO";
    private double limiteCartao = 0;
    private double saldoCartaoCredito = 0;
    private double comprasCartaoCredito = 0;
    private double pagamentoCartaoCredito = 0;
    private double valorPagar = 0;
    private String marcaCartao = "Master Bank";
    private Cliente cl;

    int quantidadeCompras;
//================================================================================================================
    public Cartoes(){
        ++nextNumber;
        idCartao = nextNumber;

        cl = null;
    }
//================================================================================================================
    public void consultaCartoes(){

        System.out.println("\n\tMeus Dados de Cartão\nCartão: " + getMarcaCartao());
        System.out.println("Nome no Cartão: " + getNomeCartao());
        System.out.println("Numero do Cartão: " + getNumeroCartao());
        System.out.println("Limite do Cartão: " + getLimiteCartao() + "€");
        System.out.println("Saldo no Cartão: " + getSaldoCartaoCredito() + "€");
        System.out.println("Tipo de Cartão: " + getTipoCartao());

    }
//================================================================================================================
    public void compraCartao(){
        Scanner entrada = new Scanner(System.in);

        System.out.print("\nQuantas Compras Quer Pagar: ");
        quantidadeCompras = entrada.nextInt();
        System.out.print("\n");

        for(int i = 1; i <= quantidadeCompras; i++){
            System.out.print("Pagamento Numero " + i + " de Valor: ");
            comprasCartaoCredito = entrada.nextDouble();

            if(comprasCartaoCredito > saldoCartaoCredito || comprasCartaoCredito > limiteCartao){
                System.out.println("\n\tSaldo Insuficiente!\n");
            }
            else {
                saldoCartaoCredito = saldoCartaoCredito - comprasCartaoCredito;

                System.out.println("Pagamento Efetuado!");
                System.out.println("Saldo Atual no Cartão: " + getSaldoCartaoCredito() + "€\n");
            }
        }
    }
    public void fazerCompraCartao(){

    }
//====================================================================================================================
    public void pagamentoCartao(){
        Scanner entrada = new Scanner(System.in);

        if (getSaldoCartaoCredito() == getLimiteCartao()){
            System.out.println("\n\t>>> Não Tem Valores a Pagar! <<<\n");
        }
        else{
            valorPagar = limiteCartao - saldoCartaoCredito;
            System.out.println("\n\tTens a Pagar: " + valorPagar + "€");
            System.out.print("\nQuanto Quer Pagar: ");
            pagamentoCartaoCredito = entrada.nextDouble();
            if (pagamentoCartaoCredito > valorPagar){
                System.out.println("\n\tValor É Maior Que o Valor a Pagar!\n");
            }
            else{
                saldoCartaoCredito = pagamentoCartaoCredito + saldoCartaoCredito;
                System.out.println("Pagamento Efetuado");
                System.out.println("Saldo Atual no Cartão: " + getSaldoCartaoCredito() + "€\n");
            }
        }
    }
    public void fazerPagamentoCartao(){

    }
//================================================================================================================
    public void alterarLimiteCartao(){

        Scanner entrada = new Scanner(System.in);

        System.out.println("Cartão: " + getMarcaCartao());
        System.out.print("Limite Anterior: " + getLimiteCartao() + "€\nNovo Limite: ");
        limiteCartao = entrada.nextDouble();

        saldoCartaoCredito = limiteCartao;

        System.out.println("\nLimite Alterado com Sucesso!");
    }
    public void alteraLimiteCartao(){

    }
//================================================================================================================
    public void editarCartao(){

        Scanner entrada = new Scanner(System.in);

        System.out.println("Cartão: " + getMarcaCartao());
        System.out.print("Nome Anterior no Cartão: " + getNomeCartao() + "\nNovo Nome: ");
        nomeCartao = entrada.next().toUpperCase();
        System.out.print("Numero Anterior no Cartão: " + getNumeroCartao() + "\nNovo Numero: ");
        numeroCartao = entrada.nextInt();

        System.out.println("\nDados Alterado com Sucesso!");
    }
    public void editaCartao(){

    }
//================================================================================================================
    public int getNumeroCartao() {
        return numeroCartao;
    }
    public void setNumeroCartao(int numeroCartao) {
        this.numeroCartao = numeroCartao;
    }

    public String getNomeCartao() {
        return nomeCartao;
    }
    public void setNomeCartao(String nomeCartao) {
        this.nomeCartao = nomeCartao;
    }

    public String getTipoCartao() {
        return tipoCartao;
    }
    public void setTipoCartao(String tipoCartao) {
        this.tipoCartao = tipoCartao;
    }

    public double getLimiteCartao() {

        return limiteCartao;
    }
    public void setLimiteCartao(double limiteCartao) {

        this.limiteCartao = limiteCartao;
    }

    public double getSaldoCartaoCredito() {

        return saldoCartaoCredito;
    }
    public void setSaldoCartaoCredito(double saldoCartaoCredito) {

        this.saldoCartaoCredito = saldoCartaoCredito;
    }

    public double getComprasCartaoCredito() {

        return comprasCartaoCredito;
    }
    public void setComprasCartaoCredito(double comprasCartaoCredito) {
        this.comprasCartaoCredito = comprasCartaoCredito;
    }

    public double getPagamentoCartaoCredito() {

        return pagamentoCartaoCredito;
    }
    public void setPagamentoCartaoCredito(double pagamentoCartaoCredito) {
        this.pagamentoCartaoCredito = pagamentoCartaoCredito;
    }

    public String getMarcaCartao() {
        return marcaCartao;
    }
    public void setMarcaCartao(String marcaCartao) {
        this.marcaCartao = marcaCartao;
    }

    public Cliente getCl(){
        return cl;
    }
    public void setCl(Cliente cl){

        this.cl = cl;
    }

    public int getIdCartao() {
        return idCartao;
    }
    public void setIdCartao(int idCartao) {
        this.idCartao = idCartao;
    }
    //================================================================================================================
}
