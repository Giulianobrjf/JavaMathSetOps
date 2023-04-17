import java.util.ArrayList;
import java.util.List;

public class Conjunto {


    public boolean pertence(int valor, List<Integer> conjunto) {
        for (int i = 0; i < conjunto.size(); i++) {
            if (conjunto.get(i) == valor) {
                return true;
            }
        }
        return false;
    }

    public boolean contido(ArrayList<Integer> conjuntoX, ArrayList<Integer> conjuntoY) {

        for (int i = 0; i < conjuntoX.size(); i++) {
            if (!pertence(conjuntoX.get(i), conjuntoY)) {
                return false;
            }
        }
        return true;
    }

    public boolean igual(ArrayList<Integer> conjuntoX, ArrayList<Integer> conjuntoY) {
        if (contido(conjuntoX, conjuntoY) && conjuntoX.size() == conjuntoY.size()) {
            return true;

        }
        return false;

    }

    public List uniao(List<Integer> conjuntoX, List<Integer> conjuntoY) {
        ArrayList<Integer> conjuntoUniao = new ArrayList();
        for (int i = 0; i < conjuntoX.size(); i++) {
            conjuntoUniao.add(conjuntoX.get(i));
        }
        for (int i = 0; i < conjuntoY.size(); i++) {
            int valorteste = conjuntoY.get(i);
            if (!pertence(valorteste, conjuntoX)) {
                conjuntoUniao.add(conjuntoY.get(i));

            }
        }

        return conjuntoUniao;
    }

    public List intersecao(List<Integer> conjuntoX, List<Integer> conjuntoY) {
        List<Integer> conjuntoIntersecao = new ArrayList();
        for (int i = 0; i < conjuntoX.size(); i++) {
            int valorteste = conjuntoX.get(i);
            if (pertence(valorteste, conjuntoY)) {
                conjuntoIntersecao.add(conjuntoX.get(i));
            }
        }
        return conjuntoIntersecao;
    }

    public List produtoCartesiano(ArrayList<Integer> conjuntoX, ArrayList<Integer> conjuntoY) {
        ArrayList<ArrayList<Integer>> produtocartesiano = new ArrayList();
        for (int j = 0; j < conjuntoY.size(); j++) {
            for (int i = 0; i < conjuntoX.size(); i++) {
                    ArrayList<Integer> temporarioCartesiano = new ArrayList();
                    temporarioCartesiano.add(conjuntoX.get(i));
                    temporarioCartesiano.add(conjuntoY.get(j));
                    produtocartesiano.add(temporarioCartesiano);
            }
        }
        return produtocartesiano;
    }
    public List reverteProdutoCartesiano (List<List<Integer>> produtoCartesiano) {
        ArrayList<Integer> reverteProdutoCartesiano = new ArrayList();
        for (int j = 0; j < produtoCartesiano.size(); j++) {
          int valorteste = produtoCartesiano.get(j).get(0);
            if(!pertence(valorteste,reverteProdutoCartesiano)){
                reverteProdutoCartesiano.add(produtoCartesiano.get(j).get(0));
            }

        }
        return reverteProdutoCartesiano;
    }

    public List<List<Integer>> conjuntoDasPartes(ArrayList<Integer> conjuntoX) {
        int n = conjuntoX.size(); // ^ n
        int numeroDeSubconjuntos = 1 << n; // 2 ^ n
        List<List<Integer>> conjuntoDasPartes = new ArrayList<>();
        for (int i = 0; i < numeroDeSubconjuntos; i++) {
            List<Integer> temporarioConjuntoDasPartes = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if((i & (1 << j)) != 0){
                    temporarioConjuntoDasPartes.add(conjuntoX.get(j));
                }
            }
            conjuntoDasPartes.add(temporarioConjuntoDasPartes);
        }
        return  conjuntoDasPartes;
    }
    public List<Integer> reverteConjuntoDasPartes(List<List<Integer>> conjuntoDasPartes) {
        List<Integer> reverteConjuntoDasPartes = new ArrayList();
        for (int j = 0; j < conjuntoDasPartes.size(); j++) {
            List<Integer> temporarioConjuntoDasPartes = conjuntoDasPartes.get(j);
            reverteConjuntoDasPartes = uniao(reverteConjuntoDasPartes,temporarioConjuntoDasPartes);
            }

            return reverteConjuntoDasPartes;
        }
    public List diferencaDeConjuntos (int escolha,ArrayList<Integer> conjuntoX, ArrayList<Integer> conjuntoY) {
        ArrayList<Integer> diferencaDeConjuntos = new ArrayList();
        if (escolha == 0) {
            for (int i = 0; i < conjuntoX.size(); i++) {
                int valorteste = conjuntoX.get(i);
                if (!pertence(valorteste, conjuntoY)) {
                        diferencaDeConjuntos.add(conjuntoX.get(i));
                }
            }

        }
        if (escolha == 1) {
            for (int i = 0; i < conjuntoY.size(); i++) {
                int valorteste = conjuntoY.get(i);
                if (!pertence(valorteste, conjuntoX)) {
                    diferencaDeConjuntos.add(conjuntoY.get(i));
                }
            }
        }
        return  diferencaDeConjuntos;
    }
}



