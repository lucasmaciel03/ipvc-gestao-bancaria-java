
package gestao_bancaria;

import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class Gestao_bancaria {

    public static void main(String[] args) {
        //Definir Scanner
        Scanner sc = new Scanner(System.in);

        
        //Definir Data e Máscara
        Date data = new Date();
        SimpleDateFormat formatar = new SimpleDateFormat("dd/MM/yyy");
        String dataAtual = formatar.format(data);
        
        //Mapa de Contas
        HashMap<Integer, Conta> contas = new HashMap();
        
        //Mapa de Titular
        HashMap<Integer, Titular> titulares = new HashMap();
        
        //Mapa de Movimentos
        HashMap<Integer, Movimento> movimentos = new HashMap();
        
        //Lista de Países de Nacionalidade de Risco
        String[] paisRisco
                = {"Argentina", "Australia", "Brasil", "Bélgica", "Canadá"};
        
        //Lista de Países Residência de Risco
        String[] residenciaRisco
                = {"Noruega", "França", "Luxemburgo", "Itália", "Índia"};
        
        //Variáveis Alternativas
        Conta c;
        Movimento m = null;
        Titular t;
        
        //Variáveis Menu
        int opcao;
        int numeroMovimento = 0;
        do{
            menu();
            System.out.println("|-");
            System.out.print("|-Escolha a opção: ");
            opcao = sc.nextInt();
            
            switch (opcao){
                case 1: //Criar Conta
                    
                    System.out.println("|-");
                    //Número da Conta
                    System.out.print("|-Número da Conta: ");
                    int numeroConta = sc.nextInt();
                    
                    //IBAN da Conta
                    System.out.print("|-IBAN: ");
                    String IBAN = sc.next();
                    
                    //Estado da Conta, começa Ativa
                    String estadoConta = "Ativa";
                    
                    //Adicionar Data
                    
                    //Saldo
                    System.out.print("|-Saldo: ");
                    double saldo = sc.nextDouble();
                    
                    //Dados referentes ao Titular
                    
                    System.out.println("|-Dados Referentes ao Titular");
                    
                    //Número da Entidade
                    System.out.print("|-Número da Entidade: ");
                    int numeroEntidade = sc.nextInt();
                    
                    //Nome da Entidade
                    System.out.print("|-Nome da Entidade: ");
                    String nomeEntidade = sc.next();
                    
                    //Número da Identificação
                    System.out.print("|-Número de Identificação Civil: ");
                    String numeroIdentificacao = sc.next();
                    
                    //NIF
                    System.out.print("|-Númerro de Identificação Fiscal (NIF): ");
                    String numeroFiscal = sc.next();
                    
                    //País de Nacionalidade
                    System.out.print("|-País de Nacionalidade: ");
                    String paisNacionalidade = sc.next();
                    
                    //Verifica Risco do País de Nacionalidade
                    int riscoPais = 0;
                    
                    for (int i=0; i < paisRisco.length; i++) {
                        if (paisRisco[i].equals(paisNacionalidade)){
                            riscoPais = 1;
                        }
                    }
                    
                    //País de Residência
                    System.out.print("|-País de Residência: ");
                    String paisResidencia = sc.next();
                    
                    //Verifica Risco do País Residência
                    int riscoResidencia = 0;
                    
                    for (int i=0;i<residenciaRisco.length;i++) {
                        if(residenciaRisco[i].equals(paisResidencia)){
                            riscoResidencia = 1;
                        }
                    }
                    
                    //Adicionar dados Titular
                    t = new Titular(numeroEntidade, nomeEntidade, numeroIdentificacao, numeroFiscal, paisNacionalidade, paisResidencia, riscoPais, riscoResidencia);
                    titulares.put(numeroEntidade, t);
                    
                    //Adicionar Dados da Conta
                    contas.put(numeroConta, new Conta(numeroConta, IBAN, t, estadoConta, dataAtual, saldo ));
                    
                    //Conta criada
                    System.out.println("|-");
                    System.out.println("|-A sua conta foi criada com sucesso!");
                    break;
                    
                case 2: //Mostrar Conta
                    
                    //Pedir Número Conta
                    System.out.print("|-Número da sua Conta: ");
                    numeroConta = sc.nextInt();
                    
                    c = contas.get(numeroConta);
                    if (c != null) {
                        System.out.println(c);
                    }else {
                        System.out.println("|-Conta não encontrada");
                    }
                    
                    break;
                    
                case 3: //Encerrar Conta
                    
                    //Pedir Número Conta
                    System.out.print("|-Número da Conta a encerrar: ");
                    numeroConta = sc.nextInt();
                    
                    c = contas.get(numeroConta);
                    if (c != null){
                        c.encerrarConta(dataAtual);
                        
                    }
                    
                    break;
                case 4: //Adicionar Titular
                    
                    //Pedir Número Conta
                    System.out.print("|-Número da Conta a adicionar Titular: ");
                    numeroConta = sc.nextInt();
                    
                    c = contas.get(numeroConta);
                    if ( c!= null){
                        
                         //Número de Entidade
                        System.out.print("|-Número de Entidade: ");
                        numeroEntidade = sc.nextInt();
                        
                        //Nome da Entidade
                        System.out.print("|-Nome da Entidade: ");
                        nomeEntidade = sc.next();
                        
                        //Número de Identificação
                        System.out.print("|-Número de Identificação Civil: ");
                        numeroIdentificacao = sc.next();
                        
                        //NIF
                        System.out.print("|-Número de Identificação Fiscal (NIF): ");
                        numeroFiscal = sc.next();
                        
                        //País de Nacionalidade
                        System.out.print("|-País de Nacionalidade: ");
                        paisNacionalidade = sc.next();
                                         
                        //Verifica Risco do País
                        riscoPais = 0;
                        
                        for (int i=0; i < paisRisco.length; i++) {
                        if (paisRisco[i].equals(paisNacionalidade)){
                            riscoPais = 1;
                        }
                        }
                        
                        //País de Residência
                        System.out.print("|-País de Residência: ");
                        paisResidencia = sc.next();
                        
                        //Verificia Risco da Residência
                        riscoResidencia = 0;
                        
                        for (int i=0;i<residenciaRisco.length;i++) {
                        if(residenciaRisco[i].equals(paisResidencia)){
                            riscoResidencia = 1;
                        }
                        }
                        
                     
                        
                        t = new Titular(numeroEntidade, nomeEntidade, numeroIdentificacao, numeroFiscal, paisNacionalidade, paisResidencia, riscoPais, riscoResidencia);
                        titulares.put(numeroEntidade, t);
                        c.adicionaTitular(t);
                        
                    }else{
                        System.out.println("|-Conta não encontrada");
                    }
                    
                    break;
                
                case 5: //Depósito
                    
                    String tipoMovimento = "Depósito Bancário";
                    
                    //Pedir Número da Conta
                    System.out.print("|-Conta Destino: ");
                    numeroConta = sc.nextInt();
                    
                    c = contas.get(numeroConta);
                    if (c != null){
                        
                        //Verificar Estado da Conta
                        if (c.getEstadoConta() == "Ativa"){
                            System.out.print("|-Número da Entidade Ordenante: ");
                            numeroEntidade = sc.nextInt();
                            
                            t = c.devolveTitular(numeroEntidade);
                            
                            if (t != null){
                                
                                System.out.print("|-Digite o valor a Depositar: ");
                                double valor = sc.nextDouble();
                                
                                //Verificar Estado Operação
                                String estadoOperacao = "Processada";
                                
                                if (t.getRiscoPais() == 1 && t.getRiscoResidencia() == 1){
                                    estadoOperacao = "Bloqueada";
                                    System.out.println("|-Estado da Operação Bloqueada");
                                    //Adicionar Movimento com o Estado Bloqueado
                                    numeroMovimento = numeroMovimento + 1;
                                    m = new Movimento (numeroMovimento, tipoMovimento, numeroEntidade, numeroConta, valor, dataAtual, estadoOperacao);
                                    movimentos.put(numeroMovimento, m);
                                    
                                } else if (t.getRiscoPais() == 1 || t.getRiscoResidencia() == 1){
                                        estadoOperacao = "Monitorização";
                                        System.out.println("|-Estado da Operação em Monitorização");
                                        //Adicionar Movimento com o Estado Monitorização
                                        numeroMovimento = numeroMovimento + 1;
                                        m = new Movimento(numeroMovimento, tipoMovimento, numeroEntidade, numeroConta, valor, dataAtual, estadoOperacao);
                                        movimentos.put(numeroMovimento, m);
                                        
                                }else{ // Caso não se verique nenhum Estado de Operação então, atualiza o Saldo
                                        c.deposito(valor);
                                        System.out.println("|-Depósito realizado com sucesso, o seu saldo é agora de " + c.getSaldo() + "€");
                                        //Adicionar Movimento com o Estado Processado
                                        numeroMovimento = numeroMovimento + 1;
                                        m = new Movimento(numeroMovimento, tipoMovimento, numeroEntidade, numeroConta, valor, dataAtual, estadoOperacao);
                                        movimentos.put(numeroMovimento, m);
                               }
                            }else {
                                System.out.println("|-Este número de Entidade não existe na conta " + numeroConta);
                            }
                        } else if (c.getEstadoConta() == "Encerrada"){
                                System.out.println("|-A sua conta encontra-se Encerrada");
                        }
                    }else{
                        System.out.println("|-Conta não encontrada");
                    }
                    
                    break;
                
                case 6: //Levantamento Bancário

                    tipoMovimento = "Levantamento Bancário";
                
                //Pedir Número Conta
                System.out.print("|-Conta Origem: ");
                numeroConta = sc.nextInt();
                
                c = contas.get(numeroConta);
                if (c != null){
                    
                    //Verificar Estado da Conta
                    if (c.getEstadoConta() == "Ativa"){
                        System.out.print("|-Número da Entidade Ordenante: ");
                        numeroEntidade = sc.nextInt();
                        
                        t = c.devolveTitular(numeroEntidade);
                        
                        if (t != null){
                            
                            System.out.print("|-Digite o valor a Levantar: ");
                            double valor = sc.nextDouble();
                            
                            //Verifica Estado da Operação
                            String estadoOperacao = "Processada";
                            
                            if (t.getRiscoPais() == 1 && t.getRiscoResidencia() == 1){
                                
                                estadoOperacao = "Bloqueada";
                                System.out.println("|-Estado da Operação Bloqueada");
                                
                                //Adicionar Movimento com o Estado Bloqueado
                                numeroMovimento = numeroMovimento + 1;
                                m = new Movimento (numeroMovimento, tipoMovimento, numeroConta, numeroEntidade, valor, dataAtual, estadoOperacao);
                                movimentos.put(numeroMovimento, m);
                            }else if (t.getRiscoPais() == 1 || t.getRiscoResidencia() == 1){
                                
                                estadoOperacao = "Monitorização";
                                System.out.println("|-Estado da Operação em Monitorização");
                                
                                //Adicionar Movimento com o Estado Monitorização
                                numeroMovimento = numeroMovimento + 1;
                                m = new Movimento (numeroMovimento, tipoMovimento, numeroConta, numeroEntidade, valor, dataAtual, estadoOperacao);
                                movimentos.put(numeroMovimento, m);
                                
                            }else{ //Caso não se verique nenhum Estado de Operação então, atualiza o Saldo
                                     c.levantamento(valor);
                                     System.out.println("|-Levantamento realizado com sucesso, o seu saldo é agora de " + c.getSaldo() + "€");
                                     
                                //Adicionar Movimento com o Estado Processada
                                numeroMovimento = numeroMovimento + 1;
                                m = new Movimento (numeroMovimento, tipoMovimento, numeroConta, numeroEntidade, valor, dataAtual, estadoOperacao);
                                movimentos.put(numeroMovimento, m);
                            }
                            
                            
                            
                        }else{
                            
                            System.out.println("|-Este número de Entidade não existe na conta " + numeroConta);
                        }
                        
                    }else if (c.getEstadoConta() == "Encerrada"){
                        
                        System.out.println("|-A sua conta encontra-se Encerrada");
                    }
                    
                }else{
                    System.out.println("|-Conta não encontrada");
                }
                
                break;
                
            case 7: //Transferência Bancária 
                tipoMovimento = "Transferência Bancária";
                    
                    //Pedir Número Conta Origem
                    
                    Conta c1;
                    System.out.print("|-Conta origem: ");
                    int numeroConta1 = sc.nextInt();
                    
                    c1 = contas.get(numeroConta1);
                    
                    if (c1 != null){
                        
                        //Verifica Estado da Conta
                        if (c1.getEstadoConta() == "Ativa"){
                            System.out.print("|-Número da Entidade: ");
                            numeroEntidade = sc.nextInt();
                            
                            t = c1.devolveTitular(numeroEntidade);
                            
                            if (t != null){
                                System.out.print("|-Conta Destino: ");
                                int numeroConta2 = sc.nextInt();
                                
                                c = contas.get(numeroConta2);
                                if (c != null){
                                    System.out.print("|-Digite o valor a Transferir: ");
                                    double valor = sc.nextDouble();
                                    
                                    //Verifica Estado Operação
                                    String estadoOperacao = "Processada";
                                    
                                    if (t.getRiscoPais() == 1 && t.getRiscoResidencia() == 1){
                                        
                                        estadoOperacao = "Bloqueada";
                                        System.out.println("|-Estado da Operação Bloqueada");
                                        
                                        //Adicionar Movimento com o estado Bloqueada
                                        numeroMovimento = numeroMovimento + 1;
                                        m = new Movimento (numeroMovimento, tipoMovimento, numeroConta1, numeroConta2, valor, dataAtual, estadoOperacao);
                                        movimentos.put(numeroMovimento, m);
                                        
                                    }else if (t.getRiscoPais() == 1 || t.getRiscoResidencia() == 1){
                                        
                                        estadoOperacao = "Monitorização";
                                        System.out.println("|-Estado da Operação Monitorização");
                                        
                                        //Adicionar Movimento com estado Monitorização
                                        numeroMovimento = numeroMovimento + 1;
                                        m = new Movimento (numeroMovimento, tipoMovimento, numeroConta1, numeroConta2, valor, dataAtual, estadoOperacao);
                                        movimentos.put(numeroMovimento, m);
                                        
                                    }else{
                                        c1.levantamento(valor);
                                        c.deposito(valor);
                                        System.out.println("Foi transferido com sucesso para a conta " + numeroConta2 + " o valor de " + valor+ "€ o seu saldo é agora de " + c1.getSaldo() +"€");
                                        
                                        //Adicionar Movimento com o Estado Monitorização
                                        m = new Movimento (numeroMovimento, tipoMovimento, numeroConta1, numeroConta2, valor, dataAtual, estadoOperacao);
                                        movimentos.put(numeroMovimento, m);
                                    }           
                                }else{
                                    System.out.println("|-Conta Destino não encontrada");
                                }       
                            }else{
                                System.out.println("|-Este número de Entidade não pertence à conta " + numeroConta1 );
                            } 
                        }else if (c1.getEstadoConta() == "Encerrada"){
                            System.out.println("|-A sua conta encontra-se Encerrada");
                        }
                    }else{
                        System.out.println("|-Conta não encontrada");
                    }
                    
                    break;
                    
                case 8: //Listagem e contabiliza  o de operações bloqueadas (com ou sem autorizapelo operador bancário);      
                    int numeroBloqueadas=0;
                    for (Movimento movimento : movimentos.values()){
                        if(movimento.getEstadoOperacao().equals("Bloqueada")){
                            System.out.println(movimento);
                            numeroBloqueadas = numeroBloqueadas + 1;
                        }     
                    }
                    System.out.println("|-Existe " + numeroBloqueadas + " movimento(s) bloqueado(s)");
                    if (numeroBloqueadas > 0 ){
                        System.out.println("|-");
                        System.out.println("|-1-Sim");
                        System.out.println("|-2-Não");
                        System.out.print("|-Deseja processar algum movimento: ");
                        int opcao2 = sc.nextInt();
                        if (opcao2 == 1){
                            
                            System.out.print("|-Qual o Número do Movimento que deseja processar: ");
                            int numeroMovimento2 = sc.nextInt();
                            
                            m = movimentos.get(numeroMovimento2);
                            if (m != null){
                                if (m.getTipoMovimento() == "Depósito Bancário"){
                                    
                                    int conta = m.getContaDestino();
                                    double valor = m.getValor();
                                
                                    c = contas.get(conta);
                                    c.deposito(valor);
                                
                                    m.atualizaEstado();
                                    System.out.println("|-Movimento número " +numeroMovimento2 + " processado, foram adicionados " + valor + "€" + "à conta " + conta);
                                }
                                if (m.getTipoMovimento() == "Levantamento Bancário"){
                                    
                                    int conta = m.getContaDestino();
                                    double valor = m.getValor();
                                
                                    c = contas.get(conta);
                                    c.levantamento(valor);
                                
                                    m.atualizaEstado();
                                    System.out.println("|-Movimento número " +numeroMovimento2 + " processado, foram levantdos " + valor + "€" + "da conta " + conta);
                                }
                                if (m.getTipoMovimento() == "Transferência Bancária"){
                                    
                                    
                                    int conta = m.getEntidadeOrdenante();
                                    int conta2 = m.getContaDestino();
                                    double valor = m.getValor();
                                
                                    c = contas.get(conta);
                                    c1 = contas.get(conta2);
                                    
                                    c.levantamento(valor);
                                    c1.deposito(valor);
                                
                                    m.atualizaEstado();
                                    System.out.println("|-Movimento número " +numeroMovimento2 + " processado, foram enviados " + valor + "€" + " para a  conta " + conta2 + " e retirados " + valor + " da conta " + conta);
                                }
   
                            }else{
                                System.out.println("|-Este Movimento não existe");
                            }
                        }
                        break;
                    }
                    break; 
                case 9: //Listagem e contabilização de operações em monitorização;
                    int numeroMonitorizacao=0;
                    for (Movimento movimento : movimentos.values()){
                        if(movimento.getEstadoOperacao().equals("Monitorização")){
                            System.out.println(movimento);
                            numeroMonitorizacao = numeroMonitorizacao + 1;            
                        }
                    }
                      System.out.println("|-Existe " + numeroMonitorizacao + " movimento(s) em monitorização");
                    if (numeroMonitorizacao > 0 ){
                        System.out.println("|-");
                        System.out.println("|-1-Sim");
                        System.out.println("|-2-Não");
                        System.out.print("|-Deseja processar algum movimento: ");
                        int opcao2 = sc.nextInt();
                        if (opcao2 == 1){
                            
                            System.out.print("|-Qual o Número do Movimento que deseja processar: ");
                            int numeroMovimento2 = sc.nextInt();
                            
                            m = movimentos.get(numeroMovimento2);
                            if (m != null){
                                if (m.getTipoMovimento() == "Depósito Bancário"){
                                    
                                    int conta = m.getContaDestino();
                                    double valor = m.getValor();
                                
                                    c = contas.get(conta);
                                    c.deposito(valor);
                                
                                    m.atualizaEstado();
                                    System.out.println("|-Movimento número " +numeroMovimento2 + " processado, foram adicionados " + valor + "€" + "à conta " + conta);
                                }
                                if (m.getTipoMovimento() == "Levantamento Bancário"){
                                    
                                    int conta = m.getContaDestino();
                                    double valor = m.getValor();
                                
                                    c = contas.get(conta);
                                    c.levantamento(valor);
                                
                                    m.atualizaEstado();
                                    System.out.println("|-Movimento número " +numeroMovimento2 + " processado, foram levantdos " + valor + "€" + "da conta " + conta);
                                }
                                if (m.getTipoMovimento() == "Transferência Bancária"){
                                    
                                    
                                    int conta = m.getEntidadeOrdenante();
                                    int conta2 = m.getContaDestino();
                                    double valor = m.getValor();
                                
                                    c = contas.get(conta);
                                    c1 = contas.get(conta2);
                                    
                                    c.levantamento(valor);
                                    c1.deposito(valor);
                                
                                    m.atualizaEstado();
                                    System.out.println("|-Movimento número " +numeroMovimento2 + " processado, foram enviados " + valor + "€" + " para a  conta " + conta2 + " e retirados " + valor + " da conta " + conta);
                                }
   
                            }else{
                                System.out.println("|-Este Movimento não existe");
                            }
                        }
                        break;
                    }
                    break;                    
                case 10: //Listagem e contabiliza  o de todas as operações processadas sem bloqueio nem monitorização;
                    int numeroProcessadas=0;
                    for (Movimento movimento : movimentos.values()){                
                        if(movimento.getEstadoOperacao().equals("Processada")){
                            System.out.println(movimento);
                            numeroProcessadas = numeroProcessadas + 1;                 
                        }         
                    } 
                      System.out.println("|-Existe " + numeroProcessadas + " movimento(s) processado(s)");
                    
                    break;
                    
                case 11: //O que percebi, Listar operaçoes de transferencias e dizer numero de op bloqueadas, monitorizadas e processadas
                    int numeroBloqueadasTr = 0;
                    int numeroMonitorizacaoTr = 0;
                    int numeroProcessadasTr = 0;
                    
                    for (Movimento movimento : movimentos.values()){
                        if(movimento.getTipoMovimento().equals("Transferência Bancária")){
                            if(movimento.getTipoMovimento().equals("Transferência Bancária") && movimento.getEstadoOperacao().equals("Bloqueada")){
                                System.out.println(movimento);
                                numeroBloqueadasTr = numeroBloqueadasTr + 1;
                            }
                            if(movimento.getTipoMovimento().equals("Transferência Bancária") && movimento.getEstadoOperacao().equals("Monitorização")){
                                System.out.println(movimento);
                                numeroMonitorizacaoTr = numeroMonitorizacaoTr + 1;
                            }
                            if(movimento.getTipoMovimento().equals("Transferência Bancária") && movimento.getEstadoOperacao().equals("Processada")){
                                System.out.println(movimento);
                                numeroProcessadasTr = numeroProcessadasTr + 1;
                            }
                        }
                    } 
                    System.out.println("|-Existe " + numeroBloqueadasTr + " movimento(s) bloqueado(s)");
                    System.out.println("|-Existe " + numeroMonitorizacaoTr + " movimento(s) em monitorização");
                    System.out.println("|-Existe " + numeroProcessadasTr + " movimento(s) processado(s)");
                    if (numeroBloqueadasTr > 0 || numeroMonitorizacaoTr > 0 || numeroProcessadasTr > 0 ){
                        System.out.println("|-");
                        System.out.println("|-1-Sim");
                        System.out.println("|-2-Não");
                        System.out.print("|-Deseja processar algum movimento: ");
                        int opcao2 = sc.nextInt();
                        if (opcao2 == 1){
                            
                            System.out.print("|-Qual o Número do Movimento que deseja processar: ");
                            int numeroMovimento2 = sc.nextInt();
                            
                            m = movimentos.get(numeroMovimento2);
                            if (m != null){
                                if (m.getTipoMovimento() == "Depósito Bancário"){
                                    
                                    int conta = m.getContaDestino();
                                    double valor = m.getValor();
                                
                                    c = contas.get(conta);
                                    c.deposito(valor);
                                
                                    m.atualizaEstado();
                                    System.out.println("|-Movimento número " +numeroMovimento2 + " processado, foram adicionados " + valor + "€" + "à conta " + conta);
                                }
                                if (m.getTipoMovimento() == "Levantamento Bancário"){
                                    
                                    int conta = m.getContaDestino();
                                    double valor = m.getValor();
                                
                                    c = contas.get(conta);
                                    c.levantamento(valor);
                                
                                    m.atualizaEstado();
                                    System.out.println("|-Movimento número " +numeroMovimento2 + " processado, foram levantdos " + valor + "€" + "da conta " + conta);
                                }
                                if (m.getTipoMovimento() == "Transferência Bancária"){
                                    
                                    
                                    int conta = m.getEntidadeOrdenante();
                                    int conta2 = m.getContaDestino();
                                    double valor = m.getValor();
                                
                                    c = contas.get(conta);
                                    c1 = contas.get(conta2);
                                    
                                    c.levantamento(valor);
                                    c1.deposito(valor);
                                
                                    m.atualizaEstado();
                                    System.out.println("|-Movimento número " +numeroMovimento2 + " processado, foram enviados " + valor + "€" + " para a  conta " + conta2 + " e retirados " + valor + " da conta " + conta);
                                }
   
                            }else{
                                System.out.println("|-Este Movimento não existe");
                            }
                        }
                        break;
                    }
                    break;
                    
                case 12: // O que percebi, listar todas as operações que contém um ordenante, um beneficiário ou titular de conta de origem/destino
                    int numeroBloqueadasTr2 = 0;
                    int numeroMonitorizacaoTr2 = 0;
                    int numeroProcessadasTr2 = 0;
                        
                    int numeroBloqueadasDep = 0;
                    int numeroMonitorizacaoDep = 0;
                    int numeroProcessadasDep = 0;
                    
                    int numeroBloqueadasLev = 0;
                    int numeroMonitorizacaoLev = 0;
                    int numeroProcessadasLev = 0;
                    
                    for (Movimento movimento : movimentos.values()){
                            
                            //Depósito Bancário
                            if(movimento.getTipoMovimento().equals("Depósito Bancário") && movimento.getEstadoOperacao().equals("Bloqueada")){
                                System.out.println(movimento);
                                numeroBloqueadasDep = numeroBloqueadasDep + 1;
                            }
                            if(movimento.getTipoMovimento().equals("Depósito Bancário") && movimento.getEstadoOperacao().equals("Monitorização")){
                                System.out.println(movimento);
                                numeroMonitorizacaoDep = numeroMonitorizacaoDep + 1;
                            }
                            if(movimento.getTipoMovimento().equals("Depósito Bancárioa") && movimento.getEstadoOperacao().equals("Processada")){
                                System.out.println(movimento);
                                numeroProcessadasDep = numeroProcessadasDep + 1;
                            }
                            //Levantamento Bancária
                            if(movimento.getTipoMovimento().equals("Levantamento Bancário") && movimento.getEstadoOperacao().equals("Bloqueada")){
                                System.out.println(movimento);
                                numeroBloqueadasLev = numeroBloqueadasLev + 1;
                            }
                            if(movimento.getTipoMovimento().equals("Levantamento Bancário") && movimento.getEstadoOperacao().equals("Monitorização")){
                                System.out.println(movimento);
                                numeroMonitorizacaoLev = numeroMonitorizacaoLev + 1;
                            }
                            if(movimento.getTipoMovimento().equals("Levantamento Bancário") && movimento.getEstadoOperacao().equals("Processada")){
                                System.out.println(movimento);
                                numeroProcessadasLev = numeroProcessadasLev + 1;
                            }
                            //Transferência Bancária
                            if(movimento.getTipoMovimento().equals("Transferência Bancária") && movimento.getEstadoOperacao().equals("Bloqueada")){
                                System.out.println(movimento);
                                numeroBloqueadasTr2 = numeroBloqueadasTr2 + 1;
                            }
                            if(movimento.getTipoMovimento().equals("Transferência Bancária") && movimento.getEstadoOperacao().equals("Monitorização")){
                                System.out.println(movimento);
                                numeroMonitorizacaoTr2 = numeroMonitorizacaoTr2 + 1;
                            }
                            if(movimento.getTipoMovimento().equals("Transferência Bancária") && movimento.getEstadoOperacao().equals("Processada")){
                                System.out.println(movimento);
                                numeroProcessadasTr2 = numeroProcessadasTr2 + 1;
                            }
                        }
                    
                    System.out.println("|-Existe " + numeroBloqueadasTr2 + " movimento(s) bloqueado(s)");
                    System.out.println("|-Existe " + numeroMonitorizacaoTr2+ " movimento(s) em monitorização");
                    System.out.println("|-Existe " + numeroProcessadasTr2 + " movimento(s) processado(s)");
                    if (numeroBloqueadasTr2 > 0 || numeroMonitorizacaoTr2 > 0 || numeroProcessadasTr2 > 0 ){
                        System.out.println("|-");
                        System.out.println("|-1-Sim");
                        System.out.println("|-2-Não");
                        System.out.print("|-Deseja processar algum movimento: ");
                        int opcao2 = sc.nextInt();
                        if (opcao2 == 1){
                            
                            System.out.print("|-Qual o Número do Movimento que deseja processar: ");
                            int numeroMovimento2 = sc.nextInt();
                            
                            m = movimentos.get(numeroMovimento2);
                            if (m != null){
                                if (m.getTipoMovimento() == "Depósito Bancário"){
                                    
                                    int conta = m.getContaDestino();
                                    double valor = m.getValor();
                                
                                    c = contas.get(conta);
                                    c.deposito(valor);
                                
                                    m.atualizaEstado();
                                    System.out.println("|-Movimento número " +numeroMovimento2 + " processado, foram adicionados " + valor + "€" + "à conta " + conta);
                                }
                                if (m.getTipoMovimento() == "Levantamento Bancário"){
                                    
                                    int conta = m.getContaDestino();
                                    double valor = m.getValor();
                                
                                    c = contas.get(conta);
                                    c.levantamento(valor);
                                
                                    m.atualizaEstado();
                                    System.out.println("|-Movimento número " +numeroMovimento2 + " processado, foram levantdos " + valor + "€" + "da conta " + conta);
                                }
                                if (m.getTipoMovimento() == "Transferência Bancária"){
                                    
                                    
                                    int conta = m.getEntidadeOrdenante();
                                    int conta2 = m.getContaDestino();
                                    double valor = m.getValor();
                                
                                    c = contas.get(conta);
                                    c1 = contas.get(conta2);
                                    
                                    c.levantamento(valor);
                                    c1.deposito(valor);
                                
                                    m.atualizaEstado();
                                    System.out.println("|-Movimento número " +numeroMovimento2 + " processado, foram enviados " + valor + "€" + " para a  conta " + conta2 + " e retirados " + valor + " da conta " + conta);
                                }
   
                            }else{
                                System.out.println("|-Este Movimento não existe");
                            }
                        }
                        break;
                    }
                    break;
                    
                case 13: //Listagem ordenada de operções por data
                
                    
            }
        }while(opcao != 0);
        
       
    
    }
    
    public static void menu(){
        System.out.println("|-");
        System.out.println("|--------------------------Conta------------------------------|");
        System.out.println("|-01-Nova Conta-----------------------------------------------|");
        System.out.println("|-02-Ver Conta------------------------------------------------|");
        System.out.println("|-03-Encerrar Conta-------------------------------------------|");
        System.out.println("|-04-Adicionar Titular----------------------------------------|");
        System.out.println("|------------------------Movimentos---------------------------|");
        System.out.println("|-05-Depósito Bancário----------------------------------------|");
        System.out.println("|-06-Levantamento Bancário------------------------------------|");
        System.out.println("|-07-Transferência Bancária-----------------------------------|");
        System.out.println("|------------------------Listagem-----------------------------|");
        System.out.println("|-08-Operações bloqueadas-------------------------------------|");
        System.out.println("|-09-Operações em monotorização-------------------------------|");
        System.out.println("|-10-Operações sem bloqueio-----------------------------------|");
        System.out.println("|-11-Número de Operações Conta Origem ou Conta Destino--------|");
        System.out.println("|-12-Número de Operações Ordenante, Beneficiário ou TItular---|");
        System.out.println("|-13-Operações Ordenadas por Data-----------------------------|");
        System.out.println("|-00-Sair-----------------------------------------------------|");
    }   
}
