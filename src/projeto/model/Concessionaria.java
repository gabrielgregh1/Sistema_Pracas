package projeto.model;


public class Concessionaria {
    private String nome;
    private String endereco;
    private Praca[] vetPraca = new Praca[10];
    private int qtdCadastrosP=0;
    
    //Construtor da classe concessionaria
    public Concessionaria(String nome, String endereco) {
        this.nome = nome;
        this.endereco = endereco;
    }
    public Concessionaria(){}
    /*QtdCadastro servira para sabermos quantas pracas foram cadastradas, facilitando a 
    *utilizacao na hora de executarmos o progama
    */
    public int getQtdCadastrosP() {
        return qtdCadastrosP;
    }
    
    //Metodos get e set da classe concessionaria
    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }
    
    //Este metodo fornecera acesso ao vetor Praca contido nesta classe
    public Praca[] getVetPraca() {
        return vetPraca;
    }
    
    //Metodo para salvar novas pracas no vetor, somando a qtd de pracas cadastradas
    public boolean CadastrarPraca(Praca novo){
        if(vetPraca.length>=qtdCadastrosP){
           vetPraca[qtdCadastrosP]=novo;
           qtdCadastrosP++;
           return true;
       }
        return false;
    }

    @Override
    public String toString() {
        
        StringBuilder into = new StringBuilder();
        into.append("---------- CONCESSIONARIA ----------").append("\n\n");
   
        for(int i = 0 ; i < qtdCadastrosP ; i++){
            into.append(vetPraca[i].toString());
        }
         into.append("-----------------------------------").append("\n");
        return into.toString();
    }

}
