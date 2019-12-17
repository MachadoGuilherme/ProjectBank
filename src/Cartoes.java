import java.util.Scanner;

public abstract class Cartoes {

    private static int nextNumber = 0;

    private int idCartao;
    private int numeroCartao = 0;
    private String nomeCartao;
    private String tipoCartao = "CREDITO";
    private int limiteCartao = 0;
    private int saldoCartaoCredito = 0;
    private int comprasCartaoCredito = 0;
    private int pagamentoCartaoCredito = 0;
    private int valorPagar = 0;
    private String marcaCartao = "Master Bank";
    private Cliente cl;

    int quantidadeCompras;
    int numCartao;
    int numCartaoLimite;
//================================================================================================================
    public Cartoes(){
        ++nextNumber;
        idCartao = nextNumber;

        cl = null;
    }
//================================================================================================================
    public void consultaCartoes(){

        System.out.println("Cartão: " + getMarcaCartao());
        System.out.println("Numero do Cartão: " + getNumeroCartao());
        System.out.println("Limite Atual do Cartão: " + getLimiteCartao());
        System.out.println("Saldo Atual no Cartão: " + getSaldoCartaoCredito());
        System.out.println("Tipo de Cartão: " + getTipoCartao());

    }
//================================================================================================================
    public void compraCartao(){
        Scanner entrada = new Scanner(System.in);

        consultaCartoes();
        System.out.print("\nQuantas Compras Quer Pagar: ");
        quantidadeCompras = entrada.nextInt();
        System.out.print("\n");

        for(int i = 1; i <= quantidadeCompras; i++){
            System.out.print("Pagamento Numero " + i + " de Valor: ");
            comprasCartaoCredito = entrada.nextInt();

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
            pagamentoCartaoCredito = entrada.nextInt();
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
    public void alterarLimite(){

        Scanner entrada = new Scanner(System.in);

        if(getTipoCartao() == "DEBITO"){
            System.out.println("\nCliente Não Possui Cartão de Credito!\n");
        }
        else{
            System.out.println("\n\tAlterar Limite do Cartão\n");

            System.out.print("\nDigite o Numero do Cartão a ser Alterado o Limite: ");
            numCartaoLimite = entrada.nextInt();

            if (numCartaoLimite != getNumeroCartao()) {
                System.out.println("\n\tNumero de Cartão Invalido ou Inexistente!\n");
            }
            else{
                System.out.println("\nCartão: " + getMarcaCartao());
                System.out.println("Limite Anterior: " + getLimiteCartao() + "\nNovo Limite: ");
                limiteCartao = entrada.nextInt();

                System.out.println("\nLimite Alterado com Sucesso!");
            }
        }
    }
//================================================================================================================
    public void editarCartao(){

        Scanner entrada = new Scanner(System.in);

        if(getNumeroCartao() == 0){
            System.out.println("\nCliente Não Possui Cartão!\n");
        }
        else{
            System.out.println("\n\tEditar Cartões\n");

            System.out.println("\nCliente: " + cl.getNomeCliente());
            System.out.print("\nDigite o Numero do Cartão a ser Alterado: ");
            numCartao = entrada.nextInt();

            if(numCartao != getNumeroCartao()){
                System.out.println("\n\tNumero de Cartão Invalido ou Inexistente!\n");
            }
            else{
                System.out.print("\nNome Anterior no Cartão: " + getNomeCartao() + "\nNovo Nome: ");
                nomeCartao = entrada.next().toUpperCase();
                System.out.print("Numero Anterior no Cartão: " + getNumeroCartao() + "\nNovo Numero: ");
                numeroCartao = entrada.nextInt();
                System.out.print("Tipo Anterior de Cartão: " + getTipoCartao() + "\nNovo Tipo: ");
                setTipoCartao(entrada.next().toUpperCase());

                if(getTipoCartao() != "DEBITO"){
                    System.out.print("Qual o Limite do Cartão: ");
                    setLimiteCartao(entrada.nextInt());
                }
                else{
                    setLimiteCartao(0);
                }

                System.out.println("\nDados Alterado com Sucesso!");
            }
        }
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

    public int getLimiteCartao() {
        return limiteCartao;
    }
    public void setLimiteCartao(int limiteCartao) {
        this.limiteCartao = limiteCartao;
    }

    public int getSaldoCartaoCredito() {
        return saldoCartaoCredito;
    }
    public void setSaldoCartaoCredito(int saldoCartaoCredito) {
        this.saldoCartaoCredito = saldoCartaoCredito;
    }

    public int getComprasCartaoCredito() {
        return comprasCartaoCredito;
    }
    public void setComprasCartaoCredito(int comprasCartaoCredito) {
        this.comprasCartaoCredito = comprasCartaoCredito;
    }

    public int getPagamentoCartaoCredito() {
        return pagamentoCartaoCredito;
    }
    public void setPagamentoCartaoCredito(int pagamentoCartaoCredito) {
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
