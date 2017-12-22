package projeto.view;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.InputMismatchException;
import projeto.model.Praca;
import java.util.Scanner;
import projeto.model.Comercial;
import projeto.model.Concessionaria;
import projeto.model.Passeio;
import projeto.model.Veiculo;

public class Teste {
    
    static Veiculo carro;
    static Concessionaria consc = new Concessionaria();
    static Comercial comercialNovo = new Comercial();
    static Passeio passeioNovo = new Passeio();
    static Praca praca = new Praca();
    static Scanner leitor=new Scanner(System.in);
    
  
public static void Menu(){
       int totalPraca = 10,numeroPracas=0,codigoPraca,numeroEixos;
       String placa,data,hora,categoriaVeiculo;

       //Menu de opcoes
       do{
            System.out.println("\n1 - Cadastrar uma Praca de Pedagio");
            System.out.println("2 - Cadastrar um veiculo de categoria Passeio/Utilitario");
            System.out.println("3 - Cadastrar um veiculo de categoria Comercial");
            System.out.println("4 - Consultar faturamento para Prefeitura");
            System.out.println("5 - Consultar registro de veiculos");
            System.out.println("0 - Sair");
            System.out.println("\nDigite uma opcao: ");
            int opcao=leitor.nextInt();
            
            switch(opcao){
                case 1:
                    cadastrarPraca();
                    break;
                case 2:
                    cadastrarVeiculoCatA();
                    break;
                    
                case 3:
                    cadastrarVeiculoCatB(); 
                    break;
                    
                case 4:   
                    faturamentoDaPrefeitura();
                    break;
                case 5:
                    consultaRegistro();
                    break;
             
   default: System.out.println("incorreto");
            System.out.println("");
                    
              }
            
       }while(true);
    }
    
    public static void main(String[] args){

        Menu();
    }
    

    private static void cadastrarPraca(){  
        System.out.println("Digite o Valor por eixo: ");
        double valorEixo = leitor.nextDouble();
       
        System.out.println("Digite o endereco da nova Praca:");
        String endereco = leitor.next();     
        
        praca = new Praca(endereco,valorEixo);
        consc.CadastrarPraca(praca);

    }

    private static void cadastrarVeiculoCatA(){
        int codigoPraca;
        String placa;
        String data, time;
            
        //pega a data do sistema
        GregorianCalendar hoje = new GregorianCalendar();        
        SimpleDateFormat out = new SimpleDateFormat("dd/MM/yyyy");
        data = out.format(hoje.getTimeInMillis());              
        
        //pegando a hora do sistema
        SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mm:ss");
        time = dateFormat.format(new Date());
              
        System.out.println("Informe o codigo da praca onde deseja cadastrar o veiculo (lembre-se de comecar pelo 0): ");
        try{        
            codigoPraca = leitor.nextInt();
            System.out.println("Informe a placa do veiculo: ");
            placa = leitor.next();
            carro = new Passeio(placa,data,time);                             
            consc.getVetPraca()[codigoPraca].CadastrarVeiculo(carro,1);
        }catch(NullPointerException e){
            System.out.println("\n\nERRO!Voce informou um condigo de praca que nao existe\n");
            System.out.println("ATUALMENTE EXISTE "+consc.getQtdCadastrosP());
            System.out.println("lembre-se de comecar pelo 0\n\n");
        }catch(InputMismatchException InputMismatchException){
            System.out.println("ERRO");
            leitor.nextLine();
        }      
    }
    
    private static void cadastrarVeiculoCatB(){
        int codigoPraca;
        int numeroEixos;
        String placa;
        String data, time;
            
        //pega a data do sistema
        GregorianCalendar hoje = new GregorianCalendar();        
        SimpleDateFormat out = new SimpleDateFormat("dd/MM/yyyy");
        data = out.format(hoje.getTimeInMillis());
         
        //pegando a hora do sistema
        SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mm:ss");
        time = dateFormat.format(new Date());
        
        try{      
            System.out.println("Informe o codigo da praca onde o veiculo esta localizado (lembre-se de comecar pelo 0): ");
            codigoPraca = leitor.nextInt();  
            
            System.out.println("Informe a placa do veiculo: ");
            placa = leitor.next();  
            
            System.out.println("Informe o numero de eixos");
            numeroEixos = leitor.nextInt();    
            carro = new Comercial(placa,data,time);
            consc.getVetPraca()[codigoPraca].CadastrarVeiculo(carro, numeroEixos);
        }catch(NullPointerException NullPointerException){       
            System.out.println("\n\nERRO!Voce informou um condigo de praca que nao existe\n");
            System.out.println("ATUALMENTE EXISTE "+consc.getQtdCadastrosP());
            System.out.println("lembre-se de comecar pelo 0\n\n");
        }catch(InputMismatchException InputMismatchException){               
            System.out.println("Informe apenas números inteiros");
            leitor.nextLine(); 
        }      

    }            
    
    private static void faturamentoDaPrefeitura(){

        System.out.println(consc.toString());
               
         //Calcula Valor Total de todas as Pracas
        double ValorTotal = 0;
        for(int i=0;i<consc.getQtdCadastrosP();i++){
            for(int y=0; y<consc.getVetPraca()[i].getQtdCadastrosV(); y++){
                ValorTotal+=consc.getVetPraca()[i].getCar()[y].getPgmt();                      
            }      
        }
        System.out.println("Total arrecadado: "+ValorTotal);
         
        //Valor recebido pela Prefeitura ser� 30% do valor total
        double valorPre=ValorTotal*0.3;   
        System.out.println("Valor a ser recebido pela prefeitura: "+valorPre);             
    }

    private static void consultaRegistro(){
    	int achou=0;
        System.out.println("Informe a placa do veiculo a ser consultado: ");
    	String placa = leitor.next();
    	for (int i = 0; i<consc.getQtdCadastrosP(); i++){
            for(int x = 0; x<consc.getVetPraca()[i].getQtdCadastrosV(); x++){
                if (placa.equalsIgnoreCase(consc.getVetPraca()[i].getCar()[x].getPlaca())){
       	    	    System.out.println("______________________________________________________________________________________________________________________");
               	    System.out.println("Praca de Pedegio"+i);
    		    System.out.println("Codigo: " + consc.getVetPraca()[i].getCodigo()+ "                     Local:"+consc.getVetPraca()[i].getEndereco());
    		    System.out.println("Data: "+consc.getVetPraca()[i].getCar()[x].getData()+ " \nHora: "+consc.getVetPraca()[i].getCar()[x].getHora());
    		    System.out.println("_______________________________________________________________________________________________________________________");
                    achou=1;
                }	
    	    }
    	}
    	if(achou==0)
            System.out.println("\n\nPlaca Inexistente.\n\n");       
        }
}