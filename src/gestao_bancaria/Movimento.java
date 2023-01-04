
package gestao_bancaria;

public class Movimento {
    //Variáveis referentes ao Movimento
    private int numeroMovimento;
    private int entidadeOrdenante;
    private int contaDestino; 
    private String dataMovimento;
    private String tipoMovimento;
    private double valor;
    private int numeroMovimentos;
    private String estadoOperacao;
    
    
    
    public Movimento (int numeroMovimento, String tipoMovimento, int entidadeOrdenante, int contaDestino, double valor, String dataMovimento,  String estadoOperacao){
        this.numeroMovimento = numeroMovimento;
        this.tipoMovimento = tipoMovimento;
        this.entidadeOrdenante = entidadeOrdenante;
        this.contaDestino = contaDestino;
        this.valor = valor;
        this.dataMovimento = dataMovimento;
        this.estadoOperacao = estadoOperacao;
    }
     
    public void atualizaEstado(){
        this.setEstadoOperacao("Processada");
    }
    //Getter and Setter

    public int getEntidadeOrdenante() {
        return entidadeOrdenante;
    }

    public void setEntidadeOrdenante(int entidadeOrdenante) {
        this.entidadeOrdenante = entidadeOrdenante;
    }

    public int getContaDestino() {
        return contaDestino;
    }

    public void setContaDestino(int contaDestino) {
        this.contaDestino = contaDestino;
    }

    public String getDataMovimento() {
        return dataMovimento;
    }

    public void setDataMovimento(String dataMovimento) {
        this.dataMovimento = dataMovimento;
    }

    public String getTipoMovimento() {
        return tipoMovimento;
    }

    public void setTipoMovimento(String tipoMovimento) {
        this.tipoMovimento = tipoMovimento;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getNumeroMovimentos() {
        return numeroMovimentos;
    }

    public void setNumeroMovimentos(int numeroMovimentos) {
        this.numeroMovimentos = numeroMovimentos;
    }

    public String getEstadoOperacao() {
        return estadoOperacao;
    }

    public void setEstadoOperacao(String estadoOperacao) {
        this.estadoOperacao = estadoOperacao;
    }
    
    @Override
    public String toString(){
        if (this.getTipoMovimento() == "Depósito Bancário")
        {
            String str=
                "|-" + "\n" +
                "|-Número Movimento: " + this.numeroMovimento + "\n" +
                "|-Tipo de Movimento: " + this.tipoMovimento + "\n" +
                "|-" + "\n" +
                "|-Entidade Ordenante: " + this.entidadeOrdenante + "\n" +
                "|-Conta Destino: " + this.contaDestino + "\n" +
                "|-Valor: " + this.valor + "€" + "\n" +
                "|-Data Movimento: " + this.dataMovimento + "\n" +
                "|-Estado Operação: " + this.estadoOperacao + "\n" +
                "|-"; 

                
        return str;
        } else if(this.getTipoMovimento() == "Levantamento Bancário") {
            String str=
                "|-" + "\n" +
                "|-Número Movimento: " + this.numeroMovimento + "\n" +   
                "|-Tipo de Movimento: " + this.tipoMovimento + "\n" +
                "|-" + "\n" +
                "|-Conta Origem: " + this.entidadeOrdenante + "\n" +
                "|-Entidade Ordenante: " + this.contaDestino + "\n" +
                "|-Valor: " + this.valor + "€" + "\n" +
                "|-Data Movimento: " + this.dataMovimento + "\n" +
                "|-Estado Operação: " + this.estadoOperacao  + "\n" +
                "|-";
          
      
                
        return str;
        } else {      
             String str=
                "|-" + "\n" +    
                "|-Número Movimento: " + this.numeroMovimento + "\n" +
                "|-Tipo de Movimento: " + this.tipoMovimento + "\n" +
                "|-" + "\n" +
                "|-Conta Origem: " + this.entidadeOrdenante + "\n" +
                "|-Conta Destino: " + this.contaDestino + "\n" +
                "|-Valor: " + this.valor + "€" + "\n" +
                "|-Data Movimento: " + this.dataMovimento + "\n" +
                "|-Estado Operação: " + this.estadoOperacao + "\n" +
                "|-";
            return str;
        }
        
    }   
}
