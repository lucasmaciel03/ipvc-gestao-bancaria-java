
package gestao_bancaria;

import java.util.ArrayList;

public class Titular {
    
    //Variáveis referentes ao titular
    private int numeroEntidade;
    private ArrayList<Movimento> movimentos;
    private String nomeEntidade;
    private String numeroIdentificacao;
    private String numeroFiscal;
    private String paisNacionalidade;
    private String paisResidencia;
    private int riscoPais;
    private int riscoResidencia;
    
    public Titular(int numeroEntidade, String nomeEntidade, String numeroIdentificacao, String numeroFiscal, String paisNacionalidade, String paisResidencia , int riscoPais, int riscoResidencia) {
        this.numeroEntidade = numeroEntidade;
        this.nomeEntidade = nomeEntidade;
        this.numeroIdentificacao = numeroIdentificacao;
        this.numeroFiscal = numeroFiscal;
        this.paisNacionalidade = paisNacionalidade;
        this.paisResidencia = paisResidencia;
        this.riscoPais = riscoPais;
        this.riscoResidencia = riscoResidencia;  
    }
    
    //Getter and Setter


    public int getNumeroEntidade() {
        return numeroEntidade;
    }

    public void setNumeroEntidade(int numeroEntidade) {
        this.numeroEntidade = numeroEntidade;
    }

    public ArrayList<Movimento> getMovimentos() {
        return movimentos;
    }

    public void setMovimentos(ArrayList<Movimento> movimentos) {
        this.movimentos = movimentos;
    }

    public String getNomeEntidade() {
        return nomeEntidade;
    }

    public void setNomeEntidade(String nomeEntidade) {
        this.nomeEntidade = nomeEntidade;
    }

    public String getNumeroIdentificacao() {
        return numeroIdentificacao;
    }

    public void setNumeroIdentificacao(String numeroIdentificacao) {
        this.numeroIdentificacao = numeroIdentificacao;
    }

    public String getNumeroFiscal() {
        return numeroFiscal;
    }

    public void setNumeroFiscal(String numeroFiscal) {
        this.numeroFiscal = numeroFiscal;
    }

    public String getPaisNacionalidade() {
        return paisNacionalidade;
    }

    public void setPaisNacionalidade(String paisNacionalidade) {
        this.paisNacionalidade = paisNacionalidade;
    }

    public String getPaisResidencia() {
        return paisResidencia;
    }

    public void setPaisResidencia(String paisResidencia) {
        this.paisResidencia = paisResidencia;
    }

    public int getRiscoPais() {
        return riscoPais;
    }

    public void setRiscoPais(int riscoPais) {
        this.riscoPais = riscoPais;
    }

    public int getRiscoResidencia() {
        return riscoResidencia;
    }

    public void setRiscoResidencia(int riscoResidencia) {
        this.riscoResidencia = riscoResidencia;
    }
    
    @Override
    public String toString() {
        return "|-Dados do(s) Titular(es)-" + "\n"
                + "|-" + "\n"
                + "|-Número de Entidade: " + this.numeroEntidade + "\n"
                + "|-Nome de Entidade: " + this.nomeEntidade + "\n"
                + "|-Número de Identificação Civil da Entidade: " + this.numeroIdentificacao + "\n"
                + "|-Número de Identificação Fiscal (NIF): " + this.numeroFiscal + "\n"
                + "|-País de Nacionalide: " + this.paisNacionalidade + "\n"
                + "|-País de Residência: " + this.paisResidencia + "\n"
                + "|-";

    }

}
