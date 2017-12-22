package projeto.model;


public class Praca {
    private static int cont=0;
    private int codigo;
    private Veiculo[] car = new Veiculo[10];
    private double valorEixo;
    private String endereco;
    int qtdCadastrosV=0;
    
    //construtor da classe Praca
    public Praca(String endereco,double ValorEixo) {
        this.valorEixo = ValorEixo;
        this.endereco=endereco;
        this.codigo = cont;
        Praca.cont++;
    }
    public Praca(){}
    
    //Este metodo fornecera acesso ao vetor de veiculos contido nesta classe
    public Veiculo[] getCar() {
        return car;
    }

    //metodo para sabermos a quantidade de veiculos ja cadastrados
    public int getQtdCadastrosV() {
        return qtdCadastrosV;
    }
    
    //metodos getters e setters da classe Praca
    public int getCodigo() {
        return codigo;
    }

    public double getValorEixo() {
        return valorEixo;
    }


    public String getEndereco() {
        return endereco;
    }
    
    //Metodo para cadastrar Novo Veiculo com base em sua categoria e quantidade de eixos
    public boolean CadastrarVeiculo(Veiculo novo, int qtdEixos){
        
        if(car.length>qtdCadastrosV){
           car[qtdCadastrosV]=novo;
           
           //categorial 2 == Passeio
           if(car[qtdCadastrosV] instanceof Passeio){
               car[qtdCadastrosV].setPgmt(valorEixo);
              
           }//categoria 3 == Comercial
           else if(car[qtdCadastrosV] instanceof Comercial){
               car[qtdCadastrosV].setPgmt(valorEixo*qtdEixos);
               
           }
           qtdCadastrosV++;
           return true;
       }
        return false;
    }

    @Override
    public String toString() {
        
        StringBuilder into = new StringBuilder();
        into.append("           PRACA ").append(codigo).append("           ").append("\n")
            .append("Endereco: ").append(endereco).append("\n")
            .append("Valor Eixo: ").append(valorEixo).append("\n\n")
            .append("Carros Categoria I").append("\n");
        
        for(int i = 0 ; i < qtdCadastrosV ; i++){
            if(car[i] instanceof Passeio)
                into.append(car[i].toString());
        }
        
        into.append("\n").append("Carros Categoria II: ").append("\n");
                
        for(int i = 0 ; i < qtdCadastrosV ; i++){
            if(car[i] instanceof Comercial)
                into.append(car[i].toString());
        }
        into.append("\n\n");
        return into.toString();
    }
        
}
