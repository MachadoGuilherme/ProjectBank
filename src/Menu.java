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

        Cliente cl = new Cliente();
        Cartoes ca = new Cartoes();
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
                    System.out.print("Digite o Numero de Cliente: ");
                    numCliente = entrada.nextInt();

                    if(numCliente != contaCli.getCli().getNumeroCliente()){
                        System.out.println("\n\tNumero de Cliente Invalido ou Inexistente!\n");
                    }
                    else{
                        do {
                            System.out.println("\n0 - Voltar");
                            System.out.println("1 - Operações");
                            System.out.println("2 - Meus Dados");
                            System.out.println("3 - Alterar Meus Dados");
                            System.out.print("\nEscolha a Opção Desejada: ");
                            opcaoMenuCliente = entrada.nextInt();

                            if(opcaoMenuCliente < 0 || opcaoMenuCliente > 3) {
                                System.out.println("\n\tOpcao Invalida!\n");
                            }
                            else {
                                if(opcaoMenuCliente == 1) {
                                    System.out.println("\n\t==> !! Este Menu Está em Construção !! <==\n\t==> !! Pedimos Desculpas Pelo Transtorno !! <==\n\n\tMy Bank\n\tAss: A Gerencia.");
                                }//----------Fim da opcaoMenuCliente 1----------
                                if(opcaoMenuCliente == 2) {
                                    System.out.println("\n\tMeus Dados\n");
                                    contaCli.getCli().informacaoCliente();
                                }//----------Fim da opcaoMenuCliente 2----------
                                if(opcaoMenuCliente == 3){
                                    System.out.println("\n\tAlterar Meus Dados\n");
                                    contaCli.getCli().editarDadosCliente();
                                }//----------Fim da opcaoMenuCliente 3----------
                            }
                        }while(opcaoMenuCliente != 0);
                    }
                }//----------Fim da opcaoMenuInicial 2----------
//====================================================================================================================
                if(opcaoMenuInicial == 3) {

                    System.out.println("\n\t*** Menu do Banco ***");

                    do{
                        System.out.println("\n0 - Voltar");
                        System.out.println("1 - Cadastro de Cliente");
                        System.out.println("2 - Alterar dados de um Cliente");
                        System.out.println("3 - Cartões de Débito e/ou Credito");
                        System.out.println("4 - Contas");
                        System.out.print("\nEscolha a Opção Desejada: ");
                        opcaoMenuBanco = entrada.nextInt();

                        if(opcaoMenuBanco < 0 || opcaoMenuBanco > 4) {
                            System.out.println("\n\tOpcao Invalida!\n");
                        }
                        else{
                            if(opcaoMenuBanco == 1){
                                inserirCliente();
                                //cl.cadastroCliente();
                                //listaClientes.add(cl);
                            }//----------Fim da opcaoMenuBanco 1----------
                            if(opcaoMenuBanco == 2){
                                System.out.print("\nDigite o Numero do Cliente: ");
                                numCliente = entrada.nextInt();

                                if(numCliente != contaCli.getCli().getNumeroCliente()){
                                    System.out.println("\n\tNumero de Cliente Invalido ou Inexistente!\n");
                                }
                                else{
                                    contaCli.getCli().editarDadosClienteBanco();
                                }
                            }//----------Fim da opcaoMenuBanco 2----------
                            if(opcaoMenuBanco == 3){
                                System.out.println("\n\tCartões");
                                System.out.print("\nDigite o Numero do Cliente: ");
                                numCliente = entrada.nextInt();

                                if(numCliente != contaCli.getCli().getNumeroCliente()){
                                    System.out.println("\n\tNumero de Cliente Invalido ou Inexistente!\n");
                                }
                                else{
                                    do{
                                        System.out.println("\n0 - Voltar");
                                        System.out.println("1 - Gerar Cartão");
                                        System.out.println("2 - Consultar Cartões");
                                        System.out.println("3 - Editar Cartão");
                                        System.out.println("4 - Alterar Limite");
                                        System.out.println("5 - Operações");
                                        System.out.print("\nEscolha a Opção Desejada: ");
                                        opcaoMenuCartao = entrada.nextInt();

                                        if(opcaoMenuCartao < 0 || opcaoMenuCartao > 5) {
                                            System.out.println("\n\tOpcao Invalida!\n");
                                        }
                                        else {
                                            if(opcaoMenuCartao == 1){
                                                cartao.addNewCartao();
                                                listaCartoes.add(cartao);
                                            }
                                            if(opcaoMenuCartao == 2){
                                                cartao.consultaCartoes();
                                            }
                                            if(opcaoMenuCartao == 3){
                                                cartao.editarCartao();
                                            }
                                            if(opcaoMenuCartao == 4){
                                                cartao.alterarLimite();
                                            }
                                            if(opcaoMenuCartao == 5){
                                                cartao.operacoesCartaoCredito();
                                            }
                                        }
                                    }while (opcaoMenuCartao != 0);
                                }
                            }//----------Fim da opcaoMenuBanco 3----------
                            if (opcaoMenuBanco == 4){
                                System.out.println("\n\tContas");
                                do{
                                    System.out.println("\n0 - Voltar");
                                    System.out.println("1 - Criar Conta Ordem");
                                    System.out.println("2 - Criar Conta Polpança");
                                    System.out.println("3 - Consultar Contas");
                                    System.out.println("4 - Escolher Conta");
                                    System.out.println("5 - Associar Cliente a Conta");

                                    if (contaCli != null && contaCli.getCli() != null){
                                        System.out.println("6 - Depositar");
                                        System.out.println("7 - Levantar");
                                        System.out.println("\nConta " + contaCli.getNumeroDeConta() + " Está Selecionada");
                                        System.out.println("Cliente " + contaCli.getCli().getNomeCliente());
                                    }
                                    else{
                                        if (contaCli != null){
                                            System.out.println("\nConta " + contaCli.getNumeroDeConta() + " Está Selecionada");
                                        }
                                    }

                                    System.out.print("\nEscolha a Opção Desejada: ");
                                    opcaoMenuContas = entrada.nextInt();

                                    if(opcaoMenuContas < 0 || opcaoMenuContas > 7) {
                                        System.out.println("\n\tOpcao Invalida!\n");
                                    }
                                    else{
                                        if (opcaoMenuContas == 1){
                                            ContaOrdem co = new ContaOrdem();
                                            listaConta.add(co);
                                            System.out.println("\nConta Ordem Criada Com Sucesso!\nNumero de Conta: " + co.getNumeroDeConta());
                                        }
                                        if (opcaoMenuContas == 2){
                                            ContaPolpanca cp = new ContaPolpanca();
                                            listaConta.add(cp);
                                            System.out.println("\nConta Polpança Criada Com Sucesso!\nNumero de Conta: " + cp.getNumeroDeConta());
                                        }
                                        if (opcaoMenuContas == 3){
                                            System.out.println("\n\tVer Todas as Contas\n");
                                            for (int i=0; i < listaConta.size(); i++){
                                                Conta c = (Conta) listaConta.get(i);
                                                c.informacao();
                                            }
                                        }
                                        if (opcaoMenuContas == 4){
                                            escolheContaAtiva();
                                        }
                                        if (opcaoMenuContas == 5){
                                            if (contaCli != null){
                                                associarClienteConta();
                                            }
                                            else{
                                                System.out.println("\n\t>>> Você Deve Ativar Uma Conta Na Opção 4 <<<");
                                            }
                                        }
                                        if (opcaoMenuContas == 6){
                                            if (contaCli != null && contaCli.getCli() != null){
                                                fazDeposito();
                                            }
                                            else{
                                                System.out.println("\n\t>>> Você Deve Associar Um Cliente Na Opção 5 <<<");
                                            }
                                        }
                                        if (opcaoMenuContas == 7){
                                            if (contaCli != null && contaCli.getCli() != null){
                                                fazLevantamento();
                                            }
                                            else{
                                                System.out.println("\n\t>>> Você Deve Associar Um Cliente Na Opção 5 <<<");
                                            }
                                        }
                                    }
                                }while (opcaoMenuContas != 0);
                            }//----------Fim da opcaoMenuBanco 4----------
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
    private void fazDeposito(){
        contaCli.fazerDeposito();
    }
    private void fazLevantamento(){
        contaCli.fazerLevantamento();
    }
//====================================================================================================================
    private int entradaInteiro(String mensagem){
        Scanner entrada = new Scanner(System.in);
        System.out.println("\n" + mensagem);
        int inteiro = entrada.nextInt();
        return inteiro;
    }
//====================================================================================================================
    private void escolheContaAtiva(){
        int n = entradaInteiro("\tEscolher Conta\n\nNumero de Conta: ");
        Conta c = pesquisaConta(n);

        if (c != null){
            contaCli = c;
        }
        else {
            System.out.println("\nConta Inexistente\n");
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
        int numeroCliente = entradaInteiro("\tAssociar Cliente\n\nDigite o Numero de cliente: ");
	    Cliente cli = pesquisarCliente(numeroCliente);

	    if ( cli != null ) {
	        contaCli.setCli(cli);
	        }
	    else {
	        System.out.println("\nCliente inexistente");
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
    public void infoBank(){
        System.out.println("\n\t*** Informações ***\n");
        System.out.println("Banco My Bank" );
        System.out.println("Telefone: 123 456 789" );
        System.out.println("Captal Social: 1.000.000");
        System.out.println("Endereço\nRua X\nNumero: 1234\nKnowhere");
        System.out.println("\nAll Rights Reserved");
    }
//====================================================================================================================
}
