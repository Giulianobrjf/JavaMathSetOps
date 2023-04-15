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

            for (int i = 0; i < conjuntoX.size(); i++) {
                if(!pertence(conjuntoX.get(i),conjuntoY)){
                    return false;
                }
            }
            return true;
        }
        public boolean igual (ArrayList<Integer> conjuntoX, ArrayList<Integer> conjuntoY){
                if(!contido(conjuntoX,conjuntoY) && conjuntoX.size() == conjuntoY.size() ){
                    return  true;

                }
                return false;

        }

}
