
import java.util.*;
public class GerenciadorDeCargos {

    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        //lendo quantidade de cargos
        int nCargos = sc.nextInt();

        //lendo linha vazia
        String ler = sc.nextLine();

        String [] cargos = new String [nCargos];
        double [][] pesos = new double [nCargos][14];

        for(int i=0; i<nCargos; i++){
            cargos[i] = sc.nextLine();

            //lê as linhas e coloca numa String
            String linha = sc.nextLine();

            //lê a String criada e separa os doubles
            Scanner leitor = new Scanner (linha);
            leitor.useLocale(Locale.ENGLISH);

            for(int j=0; j<14; j++){
                pesos[i][j] = leitor.nextDouble();
            } 
        }
        //lendo número de pessoas
        int nPessoas = sc.nextInt();

        //lendo linha vazia
        String ler1 = sc.nextLine();

        String [] nomes = new String [nPessoas];
        double [][] notasPessoas = new double [nPessoas][14];

        for(int i=0; i<nPessoas; i++){
            nomes[i] = sc.nextLine();

            String linha = sc.nextLine();
            Scanner leitor = new Scanner (linha);
            leitor.useLocale(Locale.ENGLISH);

            for(int j=0; j<14; j++){
                    notasPessoas [i][j] = leitor.nextDouble();
            }
        }

        //array da pontuação de cada pessoa em cada cargo
        double [][] pontos = new double [nPessoas][nCargos];

        //armazenando as pontuações
        for(int i=0; i<nPessoas; i++){
            for(int j=0; j<nCargos; j++){
                for(int a=0; a<14; a++){
                        pontos[i][j] += pesos[j][a]*notasPessoas[i][a];
                }
            }
        }

        //ordendando array
        int n = pontos.length;
        double temp = 0;
        String tempNomes;

        for(int a=0; a<nCargos; a++){
            //array de ordenação das pessoas
            String [] ordem = new String [nPessoas];

            //armazenando os nomes nesse array
            for(int b=0; b<ordem.length; b++){
                    ordem [b] = nomes [b];
            }
            for(int i=1; i<n; i++){  
                for(int j=0; j<i; j++){  
                    if(pontos[i][a]>pontos[j][a]){  
                        temp = pontos[i][a];            
                        pontos[i][a] = pontos[j][a];  
                        pontos[j][a] = temp; 

                        tempNomes = ordem[i];
                        ordem[i] = ordem[j];
                        ordem[j] = tempNomes; 
                    }
                }  
            } 
            System.out.println(cargos[a]); 

            for(int j=0; j<nomes.length; j++){
                System.out.println(ordem[j]);
            }
            System.out.println("");
        }
    }  
}