import java.util.ArrayList;
import java.util.List;

public class Conjunto {


    public boolean pertence(int valor, ArrayList<Integer> conjunto) {
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

    public List uniao(ArrayList<Integer> conjuntoX, ArrayList<Integer> conjuntoY) {
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

    public List intersecao(ArrayList<Integer> conjuntoX, ArrayList<Integer> conjuntoY) {
        ArrayList<Integer> conjuntoIntersecao = new ArrayList();
        for (int i = 0; i < conjuntoX.size(); i++) {
            conjuntoIntersecao.add(conjuntoX.get(i));
        }
        for (int i = 0; i < conjuntoY.size(); i++) {
            int valorteste = conjuntoY.get(i);
            if (!pertence(valorteste, conjuntoX)) {
                conjuntoIntersecao.remove(conjuntoIntersecao.get(i));
            }

        }
        return conjuntoIntersecao;
    }

    public String produtoCartesiano(ArrayList<Integer> conjuntoX, ArrayList<Integer> conjuntoY) {
        String produtocartesiano = "O produto cartesiano é ";
        for (int ia = 0; ia < conjuntoY.size(); ia++) {
            for (int i = 0; i < conjuntoX.size(); i++) {
                int valorteste = conjuntoY.get(i);
                if (!pertence(valorteste, conjuntoX)) {
                    produtocartesiano = produtocartesiano + "(" + conjuntoX.get(i) + "," + conjuntoY.get(ia) + ")" + "(" + conjuntoY.get(ia) + "," + conjuntoX.get(i) + ")";
                }
            }
        }
        return produtocartesiano;
    }
}

