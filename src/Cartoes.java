import java.util.Scanner;

public abstract class Cartoes {

    private static int nextNumber = 0;

    private int idCartao;
    private int numeroCartao;
    private String nomeCartao;
    private String tipoCartao;
    private int limiteCartao;
    private int saldoCartaoCredito;
    private int comprasCartaoCredito;
    private int pagamentoCartaoCredito;
    private int valorPagar;
    private String marcaCartao;
    private Cliente cl;

    int quantidadeCompras;
    int numCartao;
    int numCartaoLimite;
    int opcaoAddCartao;
    int menuOperacaoCartaoCredito;
//================================================================================================================
    public Cartoes(){
        ++nextNumber;
        idCartao = nextNumber;

        cl = null;
    }
//================================================================================================================
    public void addNewCartao(){
        Scanner entrada = new Scanner(System.in);

            do{
                System.out.println("0 - Voltar");
                System.out.println("1 - Cartão de Débito/Credito");
                System.out.println("2 - Cartão de Débito");
                System.out.print("\nEscolha a Opção Desejada: ");
                opcaoAddCartao = entrada.nextInt();

                if(opcaoAddCartao < 0 || opcaoAddCartao > 2){
                    System.out.println("\n\tOpcao Invalida!\n");
                }
                else{
                    if(opcaoAddCartao == 1){

                        System.out.print("\nDigite o Nome a ser Impresso no Cartão: ");
                        setNomeCartao(entrada.next().toUpperCase());
                        System.out.print("Digite os Numeros do Cartão: ");
                        setNumeroCartao(entrada.nextInt());
                        System.out.print("Qual o Limite Inicial do Cartão: ");
                        setLimiteCartao(entrada.nextInt());

                        setTipoCartao("Credito".toUpperCase());
                        System.out.println("\n\tCartão " + getMarcaCartao() + " com Limite Inicial de: " + getLimiteCartao() + "€" + "\n\tCriado com Sucesso");
                    }
                    //---------------------------------------------------------------------------------------------
                    if(opcaoAddCartao == 2){

                        System.out.print("\nDigite o Nome a ser Impresso no Cartão: ");
                        setNomeCartao(entrada.next().toUpperCase());
                        System.out.print("Digite os Numeros do Cartão: ");
                        setNumeroCartao(entrada.nextInt());

                        setTipoCartao("Debito".toUpperCase());
                        System.out.println("\n\tCartão " + getMarcaCartao() + "\n\tCriado com Sucesso");
                    }
                }
                opcaoAddCartao = 0;
            }while(opcaoAddCartao != 0);
    }
//================================================================================================================
    public void operacoesCartaoCredito(){
        //Cliente cl = new Cliente();
        Scanner entrada = new Scanner(System.in);

        setSaldoCartaoCredito((getLimiteCartao() - getComprasCartaoCredito()) + getPagamentoCartaoCredito());

        if(getTipoCartao() == "DEBITO"){
            System.out.println("\nCliente Não Possui Cartão de Credito!\n");
        }
        else {
            do{
                System.out.println("\n0 - Voltar");
                System.out.println("1 - Compras");
                System.out.println("2 - Pagamentos");
                System.out.println("3 - Consultar Saldo");
                System.out.print("\nEscolha a Opção Desejada: ");
                menuOperacaoCartaoCredito = entrada.nextInt();

                if(menuOperacaoCartaoCredito < 0 || menuOperacaoCartaoCredito > 3){
                    System.out.println("\n\tOpcao Invalida!\n");
                }
                else{
                    if(menuOperacaoCartaoCredito == 1){
                        System.out.println("\n\tCompras\n");
                        System.out.println("Cliente: " + cl.getNomeCliente());
                        System.out.println("Cartão: " + getMarcaCartao());
                        System.out.println("Numero do Cartão: " + getNumeroCartao());
                        System.out.println("Saldo Atual no Cartão: " + getSaldoCartaoCredito() + "€");
                        System.out.println("Limite Atual do Cartão: " + getLimiteCartao() + "€");
                        System.out.print("\nQuantas Compras Quer Pagar: ");
                        quantidadeCompras = entrada.nextInt();
                        System.out.print("\n");

                        for(int i = 1; i <= quantidadeCompras; i++){
                            System.out.print("Conta Numero " + i + " de Valor: ");
                            comprasCartaoCredito = entrada.nextInt();

                            if(this.comprasCartaoCredito > this.saldoCartaoCredito || this.comprasCartaoCredito > this.limiteCartao){
                                System.out.println("\n\tSaldo Insuficiente!\n");
                            }
                            else {
                                setSaldoCartaoCredito(getLimiteCartao() - getComprasCartaoCredito());
                                System.out.println("Pagamento Efetuado");
                                System.out.println("Saldo Atual no Cartão: " + getSaldoCartaoCredito() + "€\n");
                            }
                        }
                    }
                    if (menuOperacaoCartaoCredito == 2){
                        System.out.println("\n\tPagamento Cartão Credito\n");
                        System.out.println("Cartão: " + getMarcaCartao());
                        System.out.println("Numero do Cartão: " + getNumeroCartao());
                        System.out.println("Saldo Atual no Cartão: " + getSaldoCartaoCredito() + "€");
                        if (getSaldoCartaoCredito() == getLimiteCartao()){
                            System.out.println("\n\tNão Tem Valores a Pagar!\n");
                        }
                        else{
                            valorPagar = getLimiteCartao() - getSaldoCartaoCredito();
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
                    if(menuOperacaoCartaoCredito == 3){
                        System.out.println("\nCliente: " + cl.getNomeCliente());
                        System.out.println("Cartão: " + getMarcaCartao());
                        System.out.println("Numero do Cartão: " + getNumeroCartao());
                        System.out.println("Saldo Atual no Cartão: " + getSaldoCartaoCredito() + "€");
                        System.out.println("Limite Atual do Cartão: " + getLimiteCartao() + "€");
                    }
                }
            }while (menuOperacaoCartaoCredito != 0);
        }
    }
//================================================================================================================
    public void consultaCartoes(){

        //setSaldoCartaoCredito((getLimiteCartao() - getComprasCartaoCredito()) + getPagamentoCartaoCredito());

        System.out.println("\n\tConsulta de Cartões\n");
        System.out.println("\nCliente: " + cl.getNomeCliente());
        System.out.println("Cartão: " + getMarcaCartao());
        System.out.println("Numero do Cartão: " + getNumeroCartao());
        if(getLimiteCartao() != 0){
            System.out.println("Saldo Atual no Cartão: " + getSaldoCartaoCredito());
            System.out.println("Limite Atual do Cartão: " + getLimiteCartao());
        }
        System.out.println("Tipo de Cartão: " + getTipoCartao());
        System.out.println("\n");
    }
//================================================================================================================
    public void alterarLimite(){
        //Cliente cl = new Cliente();
        Scanner entrada = new Scanner(System.in);

        if(getTipoCartao() == "DEBITO"){
            System.out.println("\nCliente Não Possui Cartão de Credito!\n");
        }
        else{
            System.out.println("\n\tAlterar Limite do Cartão\n");

            System.out.println("\nCliente: " + cl.getNomeCliente());
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
        //Cliente cl = new Cliente();
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
