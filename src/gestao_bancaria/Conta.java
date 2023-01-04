
package gestao_bancaria;
import java.util.ArrayList;

public class Conta {
    //Variáveis referentes à conta
    private int numeroConta;
    private String IBAN;
    private String estadoConta;
    private String dataAbertura;
    private String dataEncerramento; //Quando Aplicável
    private double saldo;
    
    //Array List Titular
    private ArrayList<Titular> titular;
    
    public Conta (int numeroConta, String IBAN, Titular titular, String estadoConta, String dataAbertura, double saldo){
        this.numeroConta = numeroConta;
        this.IBAN = IBAN;
        //Adicionar dados relativos ao titular
        this.titular = new ArrayList();
        this.titular.add(titular);
        //-//
        this.estadoConta = estadoConta;
        this.dataAbertura = dataAbertura;
        this.saldo = saldo;
    }
    
    //Adicionar Titular
    public void adicionaTitular(Titular titular){
        this.titular.add(titular);
    }
    
    //Encerrar Conta
    public void encerrarConta(String dataAtual){
        if (this.getSaldo() > 0){
            System.out.println("|-");
            System.out.println("|-Não foi possível encerrar, a conta contém saldo");
        } else if (this.getSaldo() < 0){
            System.out.println("|-Não foi possível encerrar, a conta contém débito");
        }else {
            System.out.println("|-A sua conta foi encerrada");
            this.setEstadoConta("Encerrada");
            this.dataEncerramento = dataAtual;
        }
    }
    
    //Depósito Bancário
    public void deposito (double valor){
        this.setSaldo(this.getSaldo() + valor);
    }
    
    //Levantamento Bancário
    public void levantamento(double valor){
        if (this.getSaldo() >= valor){
            this.setSaldo(this.getSaldo() - valor);
        }else{
            System.out.println("|-Não tem Saldo suficiente para realizar esta transação");
        }
        
    }
    
    //Verifica Titular
    public Titular devolveTitular (int numeroEntidade){
         for(Titular t: this.titular)
        {
            if (t.getNumeroEntidade() == numeroEntidade){
                return t;
            }   
        } 
         return null; 
    }
    
    //Getter and Setter

    public int getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(int numeroConta) {
        this.numeroConta = numeroConta;
    }

    public String getIBAN() {
        return IBAN;
    }

    public void setIBAN(String IBAN) {
        this.IBAN = IBAN;
    }

    public String getEstadoConta() {
        return estadoConta;
    }

    public void setEstadoConta(String estadoConta) {
        this.estadoConta = estadoConta;
    }

    public String getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(String dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public String getDataEncerramento() {
        return dataEncerramento;
    }

    public void setDataEncerramento(String dataEncerramento) {
        this.dataEncerramento = dataEncerramento;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public ArrayList<Titular> getTitular() {
        return titular;
    }

    public void setTitular(ArrayList<Titular> titular) {
        this.titular = titular;
    }
    
        //Apresentar Dados
    @Override
    public String toString(){
        if (this.getDataEncerramento() != null)
        {
            String str=
                "|-Sua Conta" + "\n" +
                "|-" + "\n" +
                "|-Número da Conta: " + this.numeroConta + "\n" +
                "|-IBAN: " + this.IBAN + "\n" +
                "|-Estado da Conta: " + this.estadoConta + "\n" +
                "|-Data de Abertura: " + this.dataAbertura + "\n" +
                "|-Data Encerramento: " + this.dataEncerramento + "\n" +
                "|-Saldo: " + this.saldo + "\n" +
                "|-"; 
        //Adicionar Dados Titular
        for(Titular t : this.titular){
            str = str + t;
        }
                
        return str;
        } else {
            String str=
                "|-" + "\n" +
                "|-Sua Conta" + "\n" +
                "|-" + "\n" +
                "|-Número da Conta: " + this.numeroConta + "\n" +
                "|-IBAN: " + this.IBAN + "\n" +
                "|-Estado da Conta: " + this.estadoConta + "\n" +
                "|-Data de Abertura: " + this.dataAbertura + "\n" +
                "|-Saldo: " + this.saldo + "€" + "\n" +
                "|-" + "\n"; 
        //Adicionar Dados Titular
        for(Titular t : this.titular){
            str = str + t;
        }
                
        return str;
        } 
        
    }   
}
