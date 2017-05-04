package cliente;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelos.Operacao;
import servidor.Servidor;

public class Cliente {

    public static void main(String[] args) {
        
        // Canais de Entrada e Saida
        ObjectOutputStream saidaDados;
        ObjectInputStream entradaDados;

        // Socket(conexao) com o servidor
        Socket cliente_servidor;

        // Scanner (entrada de dados)
        Scanner sc = new Scanner(System.in);

        // Declarar e Instanciar Operação
        Operacao operacao = new Operacao();
        
        // Obter informação do cliente
        System.out.print("Digite seu nome: ");
        operacao.setRequisitante(sc.nextLine());
        
        try {
            // Tentar realizar conexão com o servidor
            cliente_servidor = new Socket("localhost", 20171);
            
            // Realizar conexão com os canais de transmissão
            saidaDados = new ObjectOutputStream(cliente_servidor.getOutputStream());
            entradaDados = new ObjectInputStream(cliente_servidor.getInputStream());
            
            // Laço infinito de requisições
            while(true){
                System.out.print("Digite a operação: ");
                operacao.setA(sc.nextDouble());
                operacao.setTipo(sc.next().charAt(0));
                operacao.setB(sc.nextDouble());
                
                // Enviar operação
                saidaDados.writeObject(new Operacao(operacao));
                
                // Receber resposta
                System.out.println("Resultado: " + entradaDados.readObject());
            }
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
}
