import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

    private String nome;
    ArrayList listaClientes;
    ArrayList listaCartoes;
    ArrayList listaConta;
    Conta contaCli;
    Cartoes cartao;

    public Menu(String nome) {
        this.nome = nome;
        listaClientes = new ArrayList();
        listaCartoes = new ArrayList();
        listaConta = new ArrayList();
        contaCli = null;
        cartao = null;
    }
//====================================================================================================================
    public void inicioSistema() {

        System.out.println("\tBem Vindo ao My Bank\n");

        Scanner entrada = new Scanner(System.in);

        int opcaoMenuInicial;
        int opcaoMenuCliente;
        int opcaoMenuBanco;
        int opcaoMenuCartao;
        int opcaoMenuContas;
        int numCliente;
        int opcaoMenuOperacoes;
        int opcaoMenuCli;
        int menuOperacaoCartaoCredito;

        Cliente cl = new Cliente();
        //Cartoes ca = new Cartoes();
//====================================================================================================================
        do {
            System.out.println("\n##-Menu Inicial-##\n");
            System.out.println("1 - Informações do Banco");
            System.out.println("2 - Cliente");
            System.out.println("3 - Banco");
            System.out.println("0 - Sair\n");
            System.out.print("Escolha a Opção Desejada: ");
            opcaoMenuInicial = entrada.nextInt();

            if(opcaoMenuInicial < 0 || opcaoMenuInicial > 3) {
                System.out.println("\n\tOpcao Invalida!\n");
            }
            else {
//====================================================================================================================
                if(opcaoMenuInicial == 1) {
                    infoBank();
                }//----------Fim da opcaoMenuInicial 1----------
//====================================================================================================================
                if(opcaoMenuInicial == 2) {
                    System.out.println("\n\t*** Area do Cliente ***\n");
                    System.out.println("Para Acessar Entre Com Os Dados\n");
                    System.out.print("Digite o Numero de Cliente: ");
                    numCliente = entrada.nextInt();

                    if(contaCli != null && contaCli.getCli() != null && contaCli.getCli().getNumeroCliente() == numCliente){
                        System.out.println("\nOlá " + contaCli.getCli().getNomeCliente());
                        do {
                            System.out.println("\n0 - Voltar");
                            System.out.println("1 - Operações");
                            System.out.println("2 - Meus Dados");
                            System.out.println("3 - Alterar Meus Dados");
                            System.out.println("\nConta " + contaCli.getNumeroDeConta() + " Está Selecionada");
                            System.out.print("\nEscolha a Opção Desejada: ");
                            opcaoMenuCliente = entrada.nextInt();

                            if(opcaoMenuCliente < 0 || opcaoMenuCliente > 3) {
                                System.out.println("\n\tOpcao Invalida!\n");
                            }
                            else {
                                if(opcaoMenuCliente == 1) {
                                    //System.out.println("\n\t==> !! Este Menu Está em Construção !! <==\n\t==> !! Pedimos Desculpas Pelo Transtorno !! <==\n\n\tMy Bank\n\tAss: A Gerencia.");
                                    do {
                                        System.out.println("\n0 - Voltar");
                                        System.out.println("1 - Depositar");
                                        System.out.println("2 - Levantar");
                                        System.out.println("3 - Saldo");
                                        if (cartao != null){
                                            System.out.println("4 - Cartão Credito");
                                        }
                                        System.out.print("\nEscolha a Opção Desejada: ");
                                        opcaoMenuOperacoes = entrada.nextInt();

                                        if (opcaoMenuOperacoes < 0 || opcaoMenuOperacoes > 4){
                                            System.out.println("\n\tOpcao Invalida!\n");
                                        }
                                        else {
                                            if (opcaoMenuOperacoes == 1){
                                                fazDeposito();
                                            }
                                            if (opcaoMenuOperacoes == 2){
                                                fazLevantamento();
                                            }
                                            if (opcaoMenuOperacoes == 3){
                                                System.out.println("Seu Saldo é: " + contaCli.getCli().getSaldoAtual() + "€");
                                            }
                                            if (opcaoMenuOperacoes == 4){
                                                if (cartao != null){
                                                    System.out.println("\n\tOperações Cartão de Credito\n");
                                                    do {
                                                        System.out.println("0 - Voltar");
                                                        System.out.println("1 - Compras");
                                                        System.out.println("2 - Pagamentos");
                                                        System.out.println("3 - Consultar Saldo");
                                                        System.out.print("\nEscolha a Opção Desejada: ");
                                                        menuOperacaoCartaoCredito = entrada.nextInt();

                                                        if(menuOperacaoCartaoCredito < 0 || menuOperacaoCartaoCredito > 3){
                                                            System.out.println("\n\tOpcao Invalida!\n");
                                                        }
                                                        else {
                                                            if (menuOperacaoCartaoCredito == 1){
                                                                System.out.println("\n\tCompras\n");
                                                                fazCompraCartao();
                                                            }
                                                            if (menuOperacaoCartaoCredito == 2){
                                                                System.out.println("\n\tPagamento Cartão Credito");
                                                                fazPagamentoCartao();
                                                            }
                                                            if (menuOperacaoCartaoCredito == 3){
                                                                System.out.println("\nSaldo Atual no Cartão: " + cartao.getSaldoCartaoCredito() + "€");
                                                                System.out.println("Limite Atual do Cartão: " + cartao.getLimiteCartao() + "€\n");
                                                            }
                                                        }
                                                    }while (menuOperacaoCartaoCredito != 0);
                                                }
                                            }
                                        }
                                    }while (opcaoMenuOperacoes != 0);
                                }//----------Fim da opcaoMenuCliente 1----------
                                if(opcaoMenuCliente == 2) {
                                    System.out.println("\n\tMeus Dados");
                                    contaCli.informacao();
                                    if (cartao != null){
                                        cartao.consultaCartoes();
                                    }
                                }//----------Fim da opcaoMenuCliente 2----------
                                if(opcaoMenuCliente == 3){
                                    System.out.println("\n\tAlterar Meus Dados\n");
                                    contaCli.getCli().editarDadosCliente();
                                }//----------Fim da opcaoMenuCliente 3----------
                            }
                        }while(opcaoMenuCliente != 0);
                    }
                    else{
                        System.out.println("\n\tCliente Invalido ou Inexistente!");
                    }
                }//----------Fim da opcaoMenuInicial 2----------
//====================================================================================================================
                if(opcaoMenuInicial == 3) {

                    System.out.println("\n\t*** Menu do Banco ***");

                    do{
                        System.out.println("\n0 - Voltar");
                        System.out.println("1 - Cliente");
                        System.out.println("2 - Cartões");
                        System.out.println("3 - Contas");

                        System.out.print("\nEscolha a Opção Desejada: ");
                        opcaoMenuBanco = entrada.nextInt();

                        if(opcaoMenuBanco < 0 || opcaoMenuBanco > 3) {
                            System.out.println("\n\tOpcao Invalida!");
                        }
                        else{
                            if (opcaoMenuBanco == 1){
                                System.out.println("\n\tMenu Cliente");
                                do {
                                    System.out.println("\n0 - Voltar");
                                    System.out.println("1 - Cadastro de Cliente");
                                    System.out.println("2 - Alterar dados de um Cliente");
                                    System.out.println("3 - Apagar um Cliente");
                                    System.out.println("4 - Listar Todos os Clientes");

                                    if (contaCli != null && contaCli.getCli() != null) {
                                        System.out.println("\nCliente " + contaCli.getCli().getNomeCliente());
                                        System.out.println("Conta " + contaCli.getNumeroDeConta() + " Está Selecionada");
                                    }

                                    System.out.print("\nEscolha a Opção Desejada: ");
                                    opcaoMenuCli = entrada.nextInt();

                                    if (opcaoMenuCli < 0 || opcaoMenuCli > 4) {
                                        System.out.println("\n\tOpcao Invalida!");
                                    }
                                    else {
                                        if (opcaoMenuCli == 1) {
                                            inserirCliente();
                                            gerandoConta();
                                        }//----------Fim da opcaoMenuCli 1----------
                                        if (opcaoMenuCli == 2) {
                                            if (contaCli != null && contaCli.getCli() != null) {
                                                contaCli.getCli().editarDadosClienteBanco();
                                            } else {
                                                System.out.println("\n\t>>> Você Deve Associar Um Cliente No Menu Contas <<<");
                                            }
                                        }//----------Fim da opcaoMenuCli 2----------
                                        if (opcaoMenuCli == 3) {
                                            System.out.println("\n\tApagar Cliente");
                                            apagarCliente();
                                        }//----------Fim da opcaoMenuCli 3----------
                                        if (opcaoMenuCli == 4){
                                            System.out.println("\n\tVer Todos os Clientes");
                                            for (int i = 0; i < listaClientes.size(); i++){
                                                Cliente clie = (Cliente) listaClientes.get(i);
                                                clie.informacaoCliente();
                                            }
                                        }//----------Fim da opcaoMenuCli 4----------
                                    }
                                }while (opcaoMenuCli != 0) ;
                            }//----------Fim da opcaoMenuBanco 1----------
                            if(opcaoMenuBanco == 2){
                                System.out.println("\n\tMenu Cartões");
                                do{
                                    System.out.println("\n0 - Voltar");
                                    System.out.println("1 - Gerar Cartão de Credito");
                                    System.out.println("2 - Consultar Cartões");

                                    if (cartao != null){
                                        System.out.println("3 - Apagar Cartão");
                                        System.out.println("4 - Editar Cartão");
                                        System.out.println("5 - Alterar Limite");
                                        System.out.println("6 - Operações");
                                        System.out.println("\nConta " + contaCli.getNumeroDeConta() + " Está Selecionada");
                                        System.out.println("Cliente " + contaCli.getCli().getNomeCliente());
                                        System.out.println("ID Cartão " + cartao.getIdCartao() + " Tipo " + cartao.getTipoCartao());
                                    }
                                    else {
                                        System.out.println("7 - Associar Cliente a Cartão");
                                    }

                                    System.out.print("\nEscolha a Opção Desejada: ");
                                    opcaoMenuCartao = entrada.nextInt();

                                    if(opcaoMenuCartao < 0 || opcaoMenuCartao > 7) {
                                        System.out.println("\n\tOpcao Invalida!\n");
                                    }
                                    else {
                                        if(opcaoMenuCartao == 1){
                                            CartaoCredito cac = new CartaoCredito();

                                            System.out.println("\n\tGerar Cartão de Credito");
                                            System.out.println("\nNome no Cartão: ");
                                            cac.setNomeCartao(entrada.next().toUpperCase());
                                            System.out.println("Numero do Cartão: ");
                                            cac.setNumeroCartao(entrada.nextInt());
                                            System.out.println("Limite do Cartão: ");
                                            cac.setLimiteCartao(entrada.nextInt());

                                            cac.setSaldoCartaoCredito(cac.getLimiteCartao());

                                            listaCartoes.add(cac);
                                            System.out.println("\nCartão de Credito Criado Com Sucesso!\nID do Cartão: " + cac.getIdCartao());

                                        }
                                        if(opcaoMenuCartao == 2){
                                            for (int i=0; i < listaCartoes.size(); i++){
                                                Cartoes c = (Cartoes) listaCartoes.get(i);
                                                System.out.println("\n\tConsulta de Cartões\n");
                                                c.consultaCartoes();
                                            }
                                        }
                                        if(opcaoMenuCartao == 3){
                                            System.out.println("\n\tApagar Cartão");
                                            apagarCartao();
                                        }
                                        if(opcaoMenuCartao == 4){
                                            if (cartao != null){
                                                System.out.println("\n\tEditar Cartão\n");
                                                editarCartao();
                                            }
                                            else {
                                                System.out.println("\n\tNão Existe Cartão Associado!");
                                            }
                                        }
                                        if(opcaoMenuCartao == 5){
                                            if (cartao != null){
                                                System.out.println("\n\tAlterar Limite do Cartão\n");
                                                alterarLimiteCartao();
                                            }
                                            else {
                                                System.out.println("\n\tNão Existe Cartão Associado!");
                                            }
                                        }
                                        if(opcaoMenuCartao == 6){
                                            if (cartao != null){
                                            System.out.println("\n\tOperações\n");
                                                do {
                                                    System.out.println("0 - Voltar");
                                                    System.out.println("1 - Compras");
                                                    System.out.println("2 - Pagamentos");
                                                    System.out.println("3 - Consultar Saldo");
                                                    System.out.print("\nEscolha a Opção Desejada: ");
                                                    menuOperacaoCartaoCredito = entrada.nextInt();

                                                    if(menuOperacaoCartaoCredito < 0 || menuOperacaoCartaoCredito > 3){
                                                        System.out.println("\n\tOpcao Invalida!\n");
                                                    }
                                                    else {
                                                        if (menuOperacaoCartaoCredito == 1){
                                                            System.out.println("\n\tCompras\n");
                                                            fazCompraCartao();
                                                        }
                                                        if (menuOperacaoCartaoCredito == 2){
                                                            System.out.println("\n\tPagamento Cartão Credito");
                                                            fazPagamentoCartao();
                                                        }
                                                        if (menuOperacaoCartaoCredito == 3){
                                                            System.out.println("\nSaldo Atual no Cartão: " + cartao.getSaldoCartaoCredito() + "€");
                                                            System.out.println("Limite Atual do Cartão: " + cartao.getLimiteCartao() + "€\n");
                                                        }
                                                    }
                                                }while (menuOperacaoCartaoCredito != 0);
                                            }
                                            else {
                                                System.out.println("\n\tNão Existe Cartão Associado!");
                                            }
                                        }
                                        if (opcaoMenuCartao == 7){
                                            if (contaCli != null){
                                                System.out.println("\n\tAssociar Cartão Para o Cliente " + contaCli.getCli().getNomeCliente());
                                                associaClienteCartao();
                                            }
                                            else{
                                                System.out.println("\n\t>>> Você Deve Ativar Um Cliente no Menu Contas <<<");
                                            }
                                        }
                                    }
                                }while (opcaoMenuCartao != 0);
                            }//----------Fim da opcaoMenuBanco 2----------
                            if (opcaoMenuBanco == 3){
                                System.out.println("\n\tContas");
                                do{
                                    System.out.println("\n0 - Voltar");
                                    System.out.println("1 - Criar Conta Ordem");
                                    System.out.println("2 - Criar Conta Polpança");
                                    System.out.println("3 - Listar Todas as Contas");
                                    System.out.println("4 - Apagar Conta");
                                    if (contaCli == null){
                                        System.out.println("5 - Escolher Conta");
                                    }
                                    if (contaCli != null && contaCli.getCli() == null){
                                        System.out.println("6 - Associar Cliente a Conta");
                                    }

                                    if (contaCli != null && contaCli.getCli() != null){
                                        System.out.println("7 - Depositar");
                                        System.out.println("8 - Levantar");
                                        System.out.println("9 - Mudar Conta");
                                        System.out.println("\nConta " + contaCli.getNumeroDeConta() + " Está Selecionada");
                                        System.out.println("Cliente " + contaCli.getCli().getNomeCliente());
                                    }
                                    else{
                                        if (contaCli != null){
                                            System.out.println("9 - Mudar Conta");
                                            System.out.println("\nConta " + contaCli.getNumeroDeConta() + " Está Selecionada");
                                        }
                                    }

                                    System.out.print("\nEscolha a Opção Desejada: ");
                                    opcaoMenuContas = entrada.nextInt();

                                    if(opcaoMenuContas < 0 || opcaoMenuContas > 9) {
                                        System.out.println("\n\tOpcao Invalida!\n");
                                    }
                                    else{
                                        if (opcaoMenuContas == 1){
                                            criaContaOrdem();
                                        }
                                        if (opcaoMenuContas == 2){
                                            criaContaPolpanca();
                                        }
                                        if (opcaoMenuContas == 3){
                                            System.out.println("\n\tVer Todas as Contas");
                                            for (int i=0; i < listaConta.size(); i++){
                                                Conta c = (Conta) listaConta.get(i);
                                                c.informacao();
                                            }
                                        }
                                        if (opcaoMenuContas == 4){
                                            System.out.println("\n\tApagar Conta");
                                            apagarConta();
                                        }
                                        if (opcaoMenuContas == 5){
                                            System.out.println("\n\tEscolher Conta");
                                            escolheContaAtiva();
                                        }
                                        if (opcaoMenuContas == 6){
                                            if (contaCli != null){
                                                System.out.println("\n\tAssociar Cliente");
                                                associarClienteConta();
                                            }
                                            else{
                                                System.out.println("\n\t>>> Você Deve Ativar Uma Conta Na Opção 4 <<<");
                                            }
                                        }
                                        if (opcaoMenuContas == 7){
                                            if (contaCli != null && contaCli.getCli() != null){
                                                fazDeposito();
                                            }
                                            else{
                                                System.out.println("\n\t>>> Você Deve Associar Um Cliente Na Opção 5 <<<");
                                            }
                                        }
                                        if (opcaoMenuContas == 8){
                                            if (contaCli != null && contaCli.getCli() != null){
                                                fazLevantamento();
                                            }
                                            else{
                                                System.out.println("\n\t>>> Você Deve Associar Um Cliente Na Opção 5 <<<");
                                            }
                                        }
                                        if (opcaoMenuContas == 9){
                                            contaCli = null;
                                            System.out.println("\n\tEscolher Conta");
                                            escolheContaAtiva();
                                        }
                                    }
                                }while (opcaoMenuContas != 0);
                            }//----------Fim da opcaoMenuBanco 3----------
                        }
                    }while(opcaoMenuBanco != 0);
                }//----------Fim da opcaoMenuInicial 3----------
//====================================================================================================================
            }

        }while(opcaoMenuInicial != 0);
        System.out.println("\n### Até a Proxima! ###\n");
//====================================================================================================================
    }
//====================================================================================================================
    private void fazCompraCartao(){
        cartao.fazerCompraCartao();
    }
    private void fazPagamentoCartao(){
        cartao.fazerPagamentoCartao();
    }
    private void alterarLimiteCartao(){
        cartao.alteraLimiteCartao();
    }
    private void editarCartao(){
        cartao.editaCartao();
    }
//====================================================================================================================
    private void fazDeposito(){
        contaCli.fazerDeposito();
    }
    private void fazLevantamento(){
        contaCli.fazerLevantamento();
    }
//====================================================================================================================
    private void criaContaPolpanca(){
        ContaPolpanca cp = new ContaPolpanca();
        listaConta.add(cp);
        System.out.println("\nConta Polpança Criada Com Sucesso!\nNumero de Conta: " + cp.getNumeroDeConta());
    }
//====================================================================================================================
    private void criaContaOrdem(){
        ContaOrdem co = new ContaOrdem();
        listaConta.add(co);
        System.out.println("\nConta Ordem Criada Com Sucesso!\nNumero de Conta: " + co.getNumeroDeConta());
    }
//====================================================================================================================
    private int entradaInteiro(String mensagem){
        Scanner entrada = new Scanner(System.in);
        System.out.println("\n" + mensagem);
        int inteiro = entrada.nextInt();
        return inteiro;
    }
//====================================================================================================================
    private void apagarConta(){

        int num = entradaInteiro("Digite o Numero de Conta: ");

        Conta con = pesquisaConta(num);
        if (con == null){
            System.out.println("\nConta Invalida ou Inexistente");
        }
        else {
            listaConta.remove(con);
            System.out.println("\nConta Apagada Com Sucesso!");
        }
    }
//====================================================================================================================
    private void apagarCartao(){

        int num = entradaInteiro("Digite o ID do Cartão: ");

        Cartoes car = pesquisaCartao(num);
        if (car == null){
            System.out.println("\nCartão Invalido ou Inexistente");
        }
        else {
            listaCartoes.remove(car);
            System.out.println("\nCartão Apagado Com Sucesso!");
        }
    }
//====================================================================================================================
    private void apagarCliente(){

        int num = entradaInteiro("Digite o Numero de Cliente: ");

        Cliente cli = pesquisarCliente(num);
        if (cli == null){
            System.out.println("\nCliente Invalido ou Inexistente");
        }
        else {
            listaClientes.remove(cli);
            System.out.println("\nCliente Apagado Com Sucesso!");
        }
    }
//====================================================================================================================
    private void associaClienteCartao(){
        int cart = entradaInteiro("ID do Cartão: ");
        Cartoes ca = pesquisaCartao(cart);

        if (ca != null){
            cartao = ca;
        }
        else {
            System.out.println("\nID do Cartão Invalido ou Inexistente");
        }
    }
//====================================================================================================================
    private Cartoes pesquisaCartao(int idCartao){
        Cartoes car = null;

        for (int i = 0; i < listaCartoes.size(); i++){
            Cartoes cart = (Cartoes) listaCartoes.get(i);

            if (cart.getIdCartao() == idCartao){
                car = cart;
                break;
            }
        }
        return car;
    }
//====================================================================================================================
    private void escolheContaAtiva(){
        int n = entradaInteiro("Numero de Conta: ");
        Conta c = pesquisaConta(n);

        if (c != null){
            contaCli = c;
        }
        else {
            System.out.println("\nConta Invalida ou Inexistente\n");
        }
    }
//====================================================================================================================
    private Conta pesquisaConta(int numeroConta){
        Conta cont = null;

        for(int i=0; i < listaConta.size(); i++){
            Conta con = (Conta) listaConta.get(i);

            if(con.getNumeroDeConta() == numeroConta){
                cont = con;
                break;
            }
        }
        return cont;
    }
//====================================================================================================================
private Cliente pesquisarCliente(int numeroCliente) {

    Cliente cli = null;

    for (int i = 0; i < listaClientes.size(); i++) {
        Cliente c = (Cliente) listaClientes.get(i);

        if ( c.getNumeroCliente() == numeroCliente) {
            cli = c;
        }
    }
    return cli;
}
//====================================================================================================================
    private void associarClienteConta() {
        int numeroCliente = entradaInteiro("Digite o Numero de cliente: ");
	    Cliente cli = pesquisarCliente(numeroCliente);

	    if ( cli != null ) {
	        contaCli.setCli(cli);
	        }
	    else {
	        System.out.println("\nCliente Invalido ou Inexistente");
	        }
	    }
//====================================================================================================================
    public void addCliente(Cliente cl){

        listaClientes.add(cl);
    }
//====================================================================================================================
    private void inserirCliente(){
        Cliente newCliente = new Cliente();
        newCliente.cadastroCliente();

        addCliente(newCliente);
    }
//====================================================================================================================
    private void gerandoConta(){
        criaContaOrdem();

        System.out.println("\n\tConfirme o Numero de Conta Deste Cliente");
        escolheContaAtiva();
        System.out.println("\n\tConfirme o Numero Deste Cliente");
        associarClienteConta();
    }
//====================================================================================================================
    public void infoBank(){
        System.out.println("-------------------------------");
        System.out.println("|                             |");
        System.out.println("|\t*** Informações ***       |");
        System.out.println("|                             |");
        System.out.println("|  Banco My Bank              |");
        System.out.println("|  Telefone: 123 456 789      |" );
        System.out.println("|  Captal Social: 1.000.000€  |");
        System.out.println("|                             |");
        System.out.println("|  Endereço                   |");
        System.out.println("|  Rua X                      |");
        System.out.println("|  Numero: 1234               |");
        System.out.println("|  Distrito: Knowhere         |");
        System.out.println("|                             |");
        System.out.println("|  All Rights Reserved        |");
        System.out.println("-------------------------------");
    }
//====================================================================================================================
}
