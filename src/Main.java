import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner elemento = new Scanner(System.in);

        ArrayList<Integer> conjuntoA = new ArrayList();
        ArrayList<Integer> conjuntoB = new ArrayList();

        for(int i = 1;i<3;i++){
            conjuntoA.add(i);
            conjuntoB.add(i);

        }
        conjuntoB.add(5);





        Conjunto e = new Conjunto();
        int opcao;

        do {

            System.out.println("Menu");
            System.out.println("\t 0. Sair");
            System.out.println("\t 1. Pertencimento");
            System.out.println("\t 2. Contido ou igual");
            System.out.println("\t 3. Matriz");
            System.out.println("Opcao: ");
            opcao = elemento.nextInt();
         switch (opcao) {

         case 1 -> {
                 System.out.print("Digite um numero para verificar sua pertinencia: ");
             int valor = elemento.nextInt();
             if (e.pertence(valor, conjuntoA)) {
                 System.out.println(valor + " Pertence ao conjunto");

             } else {
                 System.out.println(valor + " Não Pertence ao conjunto");
             }
         }

         case 2 -> {
             if (e.contido(conjuntoA,conjuntoB)) {
                 System.out.println(conjuntoA + " É contido mas não é igual ao " + conjuntoB);
             } else if(e.igual(conjuntoA,conjuntoB)){
                 System.out.println(conjuntoA + " É contido e igual ao "+ conjuntoB);
             }else{
                 System.out.println(conjuntoA + " Não é contido nem igual ao " + conjuntoB);
             }
         }
    default -> System.exit(1406);
}

        }while (opcao != 0);

    }
}

