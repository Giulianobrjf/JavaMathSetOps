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
        conjuntoA.add(6);

        Conjunto e = new Conjunto();
        int opcao;

        do {

            System.out.println("Menu");
            System.out.println("\t 0. Sair");
            System.out.println("\t 1. Pertencimento");
            System.out.println("\t 2. Contido ou igual");
            System.out.println("\t 3. União");
            System.out.println("\t 4. Interseção");
            System.out.println("\t 5. Produto Cartesiano");
            System.out.println("\t 6. Reversão Produto Cartesiano");
            System.out.println("\t 7. Conjunto das Partes");
            System.out.println("\t 8. Reversão Conjunto das Partes");
            System.out.println("\t 9. Diferença dos Conjuntos");
            System.out.println("Opcao: ");
            opcao = elemento.nextInt();
         switch (opcao) {

         case 1 -> {
                 System.out.print("Digite um numero para verificar sua pertinencia: ");
             int valor = elemento.nextInt();
             if (e.pertence(valor, conjuntoA)) {
                 System.out.println(valor + " Pertence ao conjunto " + conjuntoA);

             } else {
                 System.out.println(valor + " Não Pertence ao conjunto " + conjuntoA);
             }
         }

         case 2 -> {
             if (e.igual(conjuntoA,conjuntoB)) {
                 System.out.println(conjuntoA + " É contido e igual ao " + conjuntoB);
             } else if(e.contido(conjuntoA,conjuntoB)){
                 System.out.println(conjuntoA + " É contido mas não é igual ao "+ conjuntoB);
             }else{
                 System.out.println(conjuntoA + " Não é contido nem igual ao " + conjuntoB);
             }
         }
         case 3 -> {
             System.out.println(e.uniao(conjuntoA,conjuntoB));
         }
         case 4 -> {
             System.out.println(e.intersecao(conjuntoA,conjuntoB));

         }
         case 5 -> {
             System.out.println("O produto Cartesiano é: "+e.produtoCartesiano(conjuntoA,conjuntoB));
         }
         case 6 ->{
             System.out.println(e.reverteProdutoCartesiano(e.produtoCartesiano(conjuntoA,conjuntoB)));
         }
         case 7 ->{
             System.out.println(e.conjuntoDasPartes(conjuntoA));
         }
         case 8 -> {
             System.out.println(e.reverteConjuntoDasPartes(e.conjuntoDasPartes(conjuntoA)));
         }
         case 9 ->{
             System.out.print("Digite 0 para fazer A/B ou 1 para B/A ");
             int escolha = elemento.nextInt();
             System.out.print(e.diferencaDeConjuntos(escolha,conjuntoA,conjuntoB));
         }
    default -> System.exit(1406);
}

        }while (opcao != 0);

    }
}

