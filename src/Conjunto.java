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

    public List reverteProdutoCartesiano(List<List<Integer>> produtoCartesiano) {
        ArrayList<Integer> reverteProdutoCartesiano = new ArrayList();
        for (int j = 0; j < produtoCartesiano.size(); j++) {
            int valorteste = produtoCartesiano.get(j).get(0);
            if (!pertence(valorteste, reverteProdutoCartesiano)) {
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
                if ((i & (1 << j)) != 0) {
                    temporarioConjuntoDasPartes.add(conjuntoX.get(j));
                }
            }
            conjuntoDasPartes.add(temporarioConjuntoDasPartes);
        }
        return conjuntoDasPartes;
    }

    public List<Integer> reverteConjuntoDasPartes(List<List<Integer>> conjuntoDasPartes) {
        List<Integer> reverteConjuntoDasPartes = new ArrayList();
        for (int j = 0; j < conjuntoDasPartes.size(); j++) {
            List<Integer> temporarioConjuntoDasPartes = conjuntoDasPartes.get(j);
            reverteConjuntoDasPartes = uniao(reverteConjuntoDasPartes, temporarioConjuntoDasPartes);
        }

        return reverteConjuntoDasPartes;
    }

    public List diferencaDeConjuntos(int escolha, ArrayList<Integer> conjuntoX, ArrayList<Integer> conjuntoY) {
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
        return diferencaDeConjuntos;
    }

    public List<ArrayList<Integer>> menorQue(ArrayList<Integer> conjuntoX, ArrayList<Integer> conjuntoY) {
        ArrayList<ArrayList<Integer>> menorQue = new ArrayList<>();
        for (int j = 0; j < conjuntoX.size(); j++) {
            for (int i = 0; i < conjuntoY.size(); i++) {
                ArrayList<Integer> temporario = new ArrayList<>();
                if (conjuntoX.get(j) < conjuntoY.get(i)) {
                    temporario.add(conjuntoX.get(j));
                    temporario.add(conjuntoY.get(i));
                    menorQue.add(temporario);
                }

            }
        }
        return menorQue;
    }

    public List<ArrayList<Integer>> menorQueComposta(ArrayList<Integer> conjuntoX, ArrayList<Integer> conjuntoY, ArrayList<Integer> conjuntoZ) {
        List<ArrayList<Integer>> menorQueXY = menorQue(conjuntoX, conjuntoY);
        List<ArrayList<Integer>> menorQueComposta = new ArrayList<>();

        for (int i = 0; i < menorQueXY.size(); i++) {
            int x = menorQueXY.get(i).get(0);
            int y = menorQueXY.get(i).get(1);
            for (int j = 0; j < conjuntoZ.size(); j++) {
                int z = conjuntoZ.get(j);
                if (y < z) {
                    ArrayList<Integer> temporarioComposta = new ArrayList<>();
                        temporarioComposta.add(x);
                        temporarioComposta.add(z);
                        if (!menorQueComposta.contains(temporarioComposta)) {
                            menorQueComposta.add(temporarioComposta);
                        }
                }
            }
        }
        return menorQueComposta;
    }

    public List<ArrayList<Integer>> maiorQue(ArrayList<Integer> conjuntoX, ArrayList<Integer> conjuntoY) {
        ArrayList<ArrayList<Integer>> maiorQue = new ArrayList<>();
        for (int j = 0; j < conjuntoX.size(); j++) {
            for (int i = 0; i < conjuntoY.size(); i++) {
                ArrayList<Integer> temporario = new ArrayList<>();
                if (conjuntoX.get(j) > conjuntoY.get(i)) {
                    temporario.add(conjuntoX.get(j));
                    temporario.add(conjuntoY.get(i));
                    maiorQue.add(temporario);
                }

            }
        }
        return maiorQue;
    }


    public List<ArrayList<Integer>> maiorQueComposta(ArrayList<Integer> conjuntoX, ArrayList<Integer> conjuntoY, ArrayList<Integer> conjuntoZ) {
        List<ArrayList<Integer>> maiorQueXY = maiorQue(conjuntoX, conjuntoY);
        List<ArrayList<Integer>> maiorQueComposta = new ArrayList<>();

        for (int i = 0; i < maiorQueXY.size(); i++) {
            int x = maiorQueXY.get(i).get(0);
            int y = maiorQueXY.get(i).get(1);
            for (int j = 0; j < conjuntoZ.size(); j++) {
                int z = conjuntoZ.get(j);
                if (y > z) {
                    ArrayList<Integer> temporarioComposta = new ArrayList<>();
                    temporarioComposta.add(x);
                    temporarioComposta.add(z);
                    if (!maiorQueComposta.contains(temporarioComposta)) {
                        maiorQueComposta.add(temporarioComposta);
                    }
                }
            }
        }

        return maiorQueComposta;
    }
    public List<ArrayList<Integer>> igualQue(ArrayList<Integer> conjuntoX, ArrayList<Integer> conjuntoY) {
        ArrayList<ArrayList<Integer>> igualQue = new ArrayList<>();
        for (int j = 0; j < conjuntoX.size(); j++) {
            for (int i = 0; i < conjuntoY.size(); i++) {
                ArrayList<Integer> temporario = new ArrayList<>();

                if (conjuntoX.get(j) == conjuntoY.get(i)) {
                    temporario.add(conjuntoX.get(j));
                    temporario.add(conjuntoY.get(i));
                    igualQue.add(temporario);
                }


            }
        }
        return igualQue;
    }
    public List<ArrayList<Integer>> igualQueComposta(ArrayList<Integer> conjuntoX, ArrayList<Integer> conjuntoY, ArrayList<Integer> conjuntoZ) {
        List<ArrayList<Integer>> igualQueXY = igualQue(conjuntoX, conjuntoY);
        List<ArrayList<Integer>> igualQueComposta = new ArrayList<>();

        for (int i = 0; i < igualQueXY.size(); i++) {
            int x = igualQueXY.get(i).get(0);
            int y = igualQueXY.get(i).get(1);
            for (int j = 0; j < conjuntoZ.size(); j++) {
                int z = conjuntoZ.get(j);
                if (y == z) {
                    ArrayList<Integer> temporarioComposta = new ArrayList<>();
                    temporarioComposta.add(x);
                    temporarioComposta.add(z);
                    if (!igualQueComposta.contains(temporarioComposta)) {
                         igualQueComposta.add(temporarioComposta);
                    }

                }
            }
        }

        return igualQueComposta;
    }
    public List<ArrayList<Integer>> quadradoDe(ArrayList<Integer> conjuntoX, ArrayList<Integer> conjuntoY) {
        ArrayList<ArrayList<Integer>> quadradoDe = new ArrayList<>();
        for (int j = 0; j < conjuntoX.size(); j++) {
            for (int i = 0; i < conjuntoY.size(); i++) {
                ArrayList<Integer> temporario = new ArrayList<>();

                if (conjuntoX.get(j) == (conjuntoY.get(i) * conjuntoY.get(i))) {
                    temporario.add(conjuntoX.get(j));
                    temporario.add(conjuntoY.get(i));
                    quadradoDe.add(temporario);
                }
            }
        }
        return quadradoDe;
    }
    public List<ArrayList<Integer>> quadradoDeComposta(ArrayList<Integer> conjuntoX, ArrayList<Integer> conjuntoY, ArrayList<Integer> conjuntoZ) {
        List<ArrayList<Integer>> quadradoDeXY = quadradoDe(conjuntoX, conjuntoY);
        List<ArrayList<Integer>> quadradoDeComposta = new ArrayList<>();

        for (int i = 0; i < quadradoDeXY.size(); i++) {
            int x = quadradoDeXY.get(i).get(0);
            int y = quadradoDeXY.get(i).get(1);
            for (int j = 0; j < conjuntoZ.size(); j++) {
                int z = conjuntoZ.get(j);
                if (x == y * y) {
                    ArrayList<Integer> temporarioComposta = new ArrayList<>();
                    temporarioComposta.add(x);
                    temporarioComposta.add(z);
                    if (!quadradoDeComposta.contains(temporarioComposta)) {
                        quadradoDeComposta.add(temporarioComposta);
                    }

                }
            }
        }

        return quadradoDeComposta;
    }

    public List<ArrayList<Integer>> raizDe(ArrayList<Integer> conjuntoX, ArrayList<Integer> conjuntoY) {
        ArrayList<ArrayList<Integer>> raizDe = new ArrayList<>();
        for (int j = 0; j < conjuntoX.size(); j++) {
            for (int i = 0; i < conjuntoY.size(); i++) {
                ArrayList<Integer> temporario = new ArrayList<>();

                if ((conjuntoX.get(j) * conjuntoX.get(j)) == conjuntoY.get(i)) {
                    temporario.add(conjuntoX.get(j));
                    temporario.add(conjuntoY.get(i));
                    raizDe.add(temporario);
                }
            }
        }
        return raizDe;
    }
    public List<ArrayList<Integer>> raizDeComposta(ArrayList<Integer> conjuntoX, ArrayList<Integer> conjuntoY, ArrayList<Integer> conjuntoZ) {
        List<ArrayList<Integer>> raizDeXY = raizDe(conjuntoX, conjuntoY);
        List<ArrayList<Integer>> raizDeComposta = new ArrayList<>();

        for (int i = 0; i < raizDeXY.size(); i++) {
            int x = raizDeXY.get(i).get(0);
            int y = raizDeXY.get(i).get(1);
            for (int j = 0; j < conjuntoZ.size(); j++) {
                int z = conjuntoZ.get(j);
                if (x * x == y) {
                    ArrayList<Integer> temporarioComposta = new ArrayList<>();
                    temporarioComposta.add(x);
                    temporarioComposta.add(z);
                    if (!raizDeComposta.contains(temporarioComposta)) {
                        raizDeComposta.add(temporarioComposta);
                    }

                }
            }
        }

        return raizDeComposta;
    }

    public boolean funcional(List<ArrayList<Integer>> relacao) {
        boolean funcional = true;

        ArrayList<Integer> classificacao = new ArrayList<>();

        for (int i = 0; i < relacao.size(); i++) {
            if (pertence(relacao.get(i).get(0), classificacao)) {
                funcional = false;
            }
            classificacao.add(relacao.get(i).get(0));
        }

        if (funcional) {
            System.out.println("É Funcional");
        }else{
            System.out.println("Não é Funcional");
        }
        return funcional;
    }

    public boolean injetora(List<ArrayList<Integer>> relacao) {
        boolean injetora = true;


        ArrayList<Integer> classificacao = new ArrayList<>();
        for (int i = 0; i < relacao.size(); i++) {
            if (pertence(relacao.get(i).get(1), classificacao)) {
                injetora = false;
            }
            classificacao.add(relacao.get(i).get(1));
        }

        if (injetora) {
            System.out.println("É Injetora");
        }else{
            System.out.println("Não é Injetora");
        }
        return injetora;
    }

    public boolean total(List<ArrayList<Integer>> relacao, ArrayList<Integer> conjuntoX) {
        boolean total = true;

        ArrayList<Integer> classificacao = new ArrayList<>();
        for (int i = 0; i < relacao.size(); i++) {
            if (!pertence(relacao.get(i).get(0), classificacao)) {
                classificacao.add(relacao.get(i).get(0));
            }
        }

        for (int i = 0; i < conjuntoX.size(); i++) {
            if (!pertence(conjuntoX.get(i), classificacao)) {
                total = false;
                break;
            }
        }

        if (total) {
            System.out.println("É Total");
        } else {
            System.out.println("Não é Total");
        }
        return total;
    }

    public boolean sobrejetora(List<ArrayList<Integer>> relacao, ArrayList<Integer> conjuntoY) {
        boolean sobrejetora = true;

        ArrayList<Integer> classificacao = new ArrayList<>();
        for (int i = 0; i < relacao.size(); i++) {
            if (!pertence(relacao.get(i).get(1), classificacao)) {
                classificacao.add(relacao.get(i).get(1));
            }
        }

        for (int i = 0; i < conjuntoY.size(); i++) {
            if (!pertence(conjuntoY.get(i), classificacao)) {
                sobrejetora = false;
                break;
            }
        }

        if (sobrejetora) {
            System.out.println("É Sobrejetora");
        }else{
            System.out.println("Não é Sobrejetora");
        }

        return sobrejetora;
    }
    public boolean monomorfismo(List<ArrayList<Integer>> relacao,ArrayList<Integer> conjuntoX) {
        boolean total = total(relacao,conjuntoX);
        boolean injetora = injetora(relacao);
        boolean monomorfismo = injetora && total;

        if (monomorfismo) {
            System.out.println("É Monomorfismo");
        } else {
            System.out.println("Não é Monomorfismo");
        }

        return monomorfismo;
    }
    public boolean epimorfismo(List<ArrayList<Integer>> relacao,ArrayList<Integer> conjuntoY) {
        boolean sobrejetora = sobrejetora(relacao,conjuntoY);
        boolean funcional = funcional(relacao);
        boolean epimorfismo = funcional && sobrejetora;

        if (epimorfismo) {
            System.out.println("É Epimorfismo");
        } else {
            System.out.println("Não é Epimorfismo");
        }

        return epimorfismo;
    }
    public boolean isomorfismo(List<ArrayList<Integer>> relacao,ArrayList<Integer> conjuntoX,ArrayList<Integer> conjuntoY) {
        boolean epimorfismo = epimorfismo(relacao,conjuntoY);
        boolean monomorfismo = monomorfismo(relacao,conjuntoX);
        boolean isomorfismo = epimorfismo && monomorfismo;

        if (isomorfismo) {
            System.out.println("É Isomorfismo");
        } else {
            System.out.println("Não é Isomorfismo");
        }

        return epimorfismo;
    }
}



