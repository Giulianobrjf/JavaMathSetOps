import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner elemento = new Scanner(System.in);

        ArrayList<Integer> conjuntoA = new ArrayList();
        ArrayList<Integer> conjuntoB = new ArrayList();
        ArrayList<Integer> conjuntoC = new ArrayList();

        conjuntoA.add(5);
        conjuntoA.add(4);

        conjuntoB.add(3);
        conjuntoB.add(2);

        conjuntoC.add(1);
        conjuntoC.add(0);


        Conjunto e = new Conjunto();
        int opcao;

        do {

            System.out.println("\t Menu");
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
            System.out.println("\t 10. Menor que");
            System.out.println("\t 11. Maior que");
            System.out.println("\t 12. Igual a");
            System.out.println("\t 13. Quadrado de");
            System.out.println("\t 14. Raiz de");
            System.out.println("\t 15. Funcional");
            System.out.println("\t 17. Total");
            System.out.println("\t 18. Sobrejetora");
            System.out.println("\t 19. Menor que Composta");
            System.out.println("\t 20. Maior que Composta");

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
         case 10 ->{
             System.out.print(e.menorQue(conjuntoA,conjuntoB));
         }
             case 11 ->{
                 System.out.print(e.maiorQue(conjuntoA,conjuntoB));
             }
             case 12 ->{
                 System.out.print(e.igualQue(conjuntoA,conjuntoB));
             }
             case 13 ->{
                 System.out.print(e.quadradoDe(conjuntoA,conjuntoB));
             }
             case 14 ->{
                 System.out.print(e.raizDe(conjuntoA,conjuntoB));
             }
             case 15 -> {
                 System.out.print(e.funcional(e.menorQue(conjuntoA,conjuntoB)));
            }
             case 16 ->{
                 System.out.print(e.injetora(e.menorQue(conjuntoA,conjuntoB)));
             }
             case 17 ->{
                 System.out.print(e.total(e.menorQue(conjuntoA,conjuntoB),conjuntoA,conjuntoB));
             }
             case 18 ->{
                 System.out.println(e.sobrejetora(e.menorQue(conjuntoA,conjuntoB),conjuntoA,conjuntoB));
             }
             case 19 ->{
                 System.out.println(e.menorQueComposta(conjuntoA,conjuntoB,conjuntoC));
             }
             case 20 ->{
                 System.out.println(e.maiorQueComposta(conjuntoA,conjuntoB,conjuntoC));
             }
             case 21 ->{
             }


    default -> System.exit(1406);
}

        }while (opcao != 0);

    }
}

