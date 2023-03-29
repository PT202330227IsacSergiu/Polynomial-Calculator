package Logic;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import Model.*;
public class OperationsP {

    public OperationsP() {
    }

    public Polynomial add(Polynomial p1, Polynomial p2) {

        Polynomial p = new Polynomial();
        boolean exist;
        for (Map.Entry<Integer, Double> entry1 : p1.getTerm().entrySet()) {
            exist = false;
            for (Map.Entry<Integer, Double> entry2 : p2.getTerm().entrySet()) {
                if (entry1.getKey().equals(entry2.getKey())) {
                    exist = true;
                    p.addMono(new Monomial(entry1.getKey(), entry1.getValue() + entry2.getValue()));
                }
            }
            if (!exist) {
                p.addMono(new Monomial(entry1.getKey(), entry1.getValue()));
            }
        }

        for (Map.Entry<Integer, Double> entry2 : p2.getTerm().entrySet()) {
            exist = false;
            for (Map.Entry<Integer, Double> entry : p.getTerm().entrySet()){
                if(entry2.getKey().equals(entry.getKey())) {
                    exist = true;
                    break;
                }
            }
            if(!exist){
                p.addMono(new Monomial(entry2.getKey(), entry2.getValue()));
            }
        }

        Set<Double> set = new HashSet<>();
        set.add(0.0);
        p.getTerm().values().removeAll(set);

        return p;
    }

    public Polynomial sub(Polynomial p1, Polynomial p2) {

        Polynomial p = new Polynomial();
        Polynomial _p2 = new Polynomial();
        for (Map.Entry<Integer, Double> entry : p2.getTerm().entrySet()){
            _p2.addMono(new Monomial(entry.getKey(),-entry.getValue()));
        }
        OperationsP op = new OperationsP();
        p = op.add(p1,_p2);
        return p;

    }

    public Polynomial mul(Polynomial p1, Polynomial p2) {
        Polynomial p = new Polynomial();
        OperationsP op = new OperationsP();
        for (Map.Entry<Integer, Double> entry1 : p1.getTerm().entrySet()) {
            Polynomial aux = new Polynomial();
            for (Map.Entry<Integer, Double> entry2 : p2.getTerm().entrySet()) {
                aux.addMono(new Monomial(entry1.getKey()+entry2.getKey(),
                        entry1.getValue()*entry2.getValue()));
            }
            p = op.add(p,aux);
        }
        return p;

    }

    public Polynomial[] div(Polynomial p1, Polynomial p2) throws Exception {
        if(p2.getTerm().firstKey().equals(0) && p2.getTerm().firstEntry().getValue().equals(0.0)){
            throw new Exception(" · Cant't divide by 0 · ");
        }

        if(p1.getTerm().firstKey()<p2.getTerm().firstKey()){
            Polynomial aux = new Polynomial(p1);
            p1 = new Polynomial(p2);
            p2 = new Polynomial(aux);
        }

        Polynomial q = new Polynomial();
        OperationsP op = new OperationsP();

        while (!(p1.getTerm().firstKey()<p2.getTerm().firstKey())){

            Polynomial aux_add;
            Polynomial aux_min = new Polynomial();
            q.addMono(new Monomial(p1.getTerm().firstKey() - p2.getTerm().firstKey(),
                                        p1.getTerm().firstEntry().getValue()/p2.getTerm().firstEntry().getValue()));
            aux_min.addMono(new Monomial(p1.getTerm().firstKey() - p2.getTerm().firstKey(),
                                        -p1.getTerm().firstEntry().getValue()/p2.getTerm().firstEntry().getValue()));
            aux_add = op.mul(aux_min, p2);
            p1 = op.add(p1, aux_add);
            if(p1.getTerm().size() == 0){
                p1.addMono(new Monomial(0,0.0));
                break;
            }

        }
        Polynomial[] p = new Polynomial[2];
        p[0] = new Polynomial();
        p[0].getTerm().putAll(q.getTerm());

        p[1] = new Polynomial();
        p[1].getTerm().putAll(p1.getTerm());
        return p;

    }

    public Polynomial der(Polynomial p) {
        Polynomial _p = new Polynomial();
        for (Map.Entry<Integer, Double> entry : p.getTerm().entrySet()) {
            if(entry.getKey()!=0) {
                _p.addMono(new Monomial(entry.getKey() - 1, entry.getValue() * (entry.getKey())));
            }
        }
        return _p;

    }

    public Polynomial intg(Polynomial p) {
        Polynomial _p = new Polynomial();
        for (Map.Entry<Integer, Double> entry : p.getTerm().entrySet()) {
            _p.addMono(new Monomial(entry.getKey()+1,entry.getValue()/(entry.getKey()+1)));
        }
        return _p;
    }
}
