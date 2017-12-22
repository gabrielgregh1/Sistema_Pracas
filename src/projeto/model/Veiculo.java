package projeto.model;

public abstract class Veiculo {
    private String categoria;
    private String placa, data, hora;
    private double pgmt;

    //Construtor da classe Veiculo
    public Veiculo() {}
    public Veiculo(String categoria,String placa, String data, String hora) {
        this.categoria = categoria;
        this.placa = placa;
        this.data = data;
        this.hora = hora;
    }
    
    //metodos getters e setters da classe
    public String getPlaca() {
        return placa;
    }

    public String getData() {
        return data;
    }

    public String getHora() {
        return hora;
    }

    public String getCategoria() {
        return categoria;
    }


    public double getPgmt() {
        return pgmt;
    }

    public void setPgmt(double pgmt) {
        this.pgmt = pgmt;
    }

    @Override
    public String toString() {
        
        StringBuilder into = new StringBuilder();
        into.append("Categoria: ").append(categoria).append("\t")
            .append("Placa: ").append(placa).append("\t")
            .append("Data: ").append(data).append("\t")
            .append("Hora: ").append(hora).append("\t")
            .append("Pagamento: ").append(pgmt).append("\t").append("\n");
        
        return into.toString();
    }
    
    
}
