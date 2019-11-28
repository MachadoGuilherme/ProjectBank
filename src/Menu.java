import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

    private String nome;
    ArrayList listaClientes;
    ArrayList listaCartoes;

    public Menu(String nome) {
        this.nome = nome;
        listaClientes = new ArrayList();
        listaCartoes = new ArrayList();
    }
//====================================================================================================================
    public void inicioSistema() {

        System.out.println("\tBem Vindo ao My Bank\n");

        Scanner entrada = new Scanner(System.in);

        int opcaoMenuInicial;
        int opcaoMenuCliente;
        int opcaoMenuBanco;
        int opcaoMenuCartao;
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

                    if(numCliente != cl.getNumeroCliente()){
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
                                    cl.informacaoCliente();
                                }//----------Fim da opcaoMenuCliente 2----------
                                if(opcaoMenuCliente == 3){
                                    System.out.println("\n\tAlterar Meus Dados\n");
                                    cl.editarDadosCliente();
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
                        System.out.print("\nEscolha a Opção Desejada: ");
                        opcaoMenuBanco = entrada.nextInt();

                        if(opcaoMenuBanco < 0 || opcaoMenuBanco > 3) {
                            System.out.println("\n\tOpcao Invalida!\n");
                        }
                        else{
                            if(opcaoMenuBanco == 1){
                                cl.cadastroCliente();
                                listaClientes.add(cl);
                            }//----------Fim da opcaoMenuBanco 1----------
                            if(opcaoMenuBanco == 2){
                                System.out.print("\nDigite o Numero do Cliente: ");
                                numCliente = entrada.nextInt();

                                if(numCliente != cl.getNumeroCliente()){
                                    System.out.println("\n\tNumero de Cliente Invalido ou Inexistente!\n");
                                }
                                else{
                                    cl.editarDadosClienteBanco();
                                }
                            }//----------Fim da opcaoMenuBanco 2----------
                            if(opcaoMenuBanco == 3){
                                System.out.println("\n\tCartões");
                                System.out.print("\nDigite o Numero do Cliente: ");
                                numCliente = entrada.nextInt();

                                if(numCliente != cl.getNumeroCliente()){
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
                                                ca.addNewCartao();
                                                listaCartoes.add(ca);
                                            }
                                            if(opcaoMenuCartao == 2){
                                                ca.consultaCartoes();
                                            }
                                            if(opcaoMenuCartao == 3){
                                                ca.editarCartao();
                                            }
                                            if(opcaoMenuCartao == 4){
                                                ca.alterarLimite();
                                            }
                                            if(opcaoMenuCartao == 5){
                                                ca.operacoesCartaoCredito();
                                            }
                                        }
                                    }while (opcaoMenuCartao != 0);
                                }
                            }
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