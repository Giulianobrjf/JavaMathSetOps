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
        conjuntoA.add(7);



        System.out.print("Digite um numero para verificar sua pertinencia: ");
        int valor = elemento.nextInt();
        Conjunto e = new Conjunto();

        if (e.pertence(valor,conjuntoA)) {
            System.out.println(valor + " Pertence ao conjunto");
        } else {
            System.out.println(valor + " Não Pertence ao conjunto");
        }


        if (e.contido(conjuntoA,conjuntoB)) {
            System.out.println(conjuntoA + " É contido ao conjunto");
        } else {
            System.out.println(conjuntoA + " Não é contido ao conjunto");
        }
    }


}