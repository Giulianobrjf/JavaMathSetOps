import java.util.ArrayList;
import java.util.List;

public class Conjunto {




    public boolean pertence(int valor,ArrayList<Integer> conjunto) {
        for (int i = 0; i < conjunto.size(); i++) {
            if (conjunto.get(i) == valor) {
                return true;
            }
        }
        return false;
    }
        public boolean contido(ArrayList<Integer> conjuntoX, ArrayList<Integer> conjuntoY) {
            int a = 0;

            for (int i = 0; i < conjuntoX.size(); i++) {
                if(!pertence(conjuntoX.get(i),conjuntoY)){
                    return false;
                }
            }
            return true;
        }

}
