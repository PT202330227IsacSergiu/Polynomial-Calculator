package Model;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Polynomial {

    private TreeMap<Integer, Double> term;

    public Polynomial() {
        term = new TreeMap<>(Collections.reverseOrder());
    }
    public Polynomial(Polynomial a){
        term = new TreeMap<>(Collections.reverseOrder());
        term.putAll(a.getTerm());
    }

    public Polynomial(String str) throws Exception {
        String errStr = "";
        boolean excBool = false;

        term = new TreeMap<>(Collections.reverseOrder());
        Pattern pattern = Pattern.compile("(([-+](\\d+(\\.\\d+)?)?)([x])?([\\^]?(\\d))?)");
        Matcher matcher = pattern.matcher(str);
        Matcher valid = pattern.matcher(str);

        if (str.length() == 0) {
            errStr += " · Both text fields must contains a polynomial · \n";
            excBool = true;
        } else  if (!(Character.compare(str.charAt(0), '-') == 0 || Character.compare(str.charAt(0), '+') == 0)) {
            errStr += " · Polynomial must start with { - , + } ·\n · Every monomial must have a sign · \n";
            excBool = true;
        } else {
            while (matcher.find()) {
                int exp = 0;
                double coef = 0.0;
                if (matcher.group(2).equals("-")) {
                    coef = -1.0;
                } else if ((matcher.group(2).equals("+"))) {
                    coef = 1.0;
                } else {
                    coef = Double.parseDouble(matcher.group(2));
                }
                try {
                    exp = Integer.parseInt(matcher.group(7));
                } catch (NumberFormatException ex1) {
                    try {
                        if (matcher.group(5).equals("x")) {
                            exp = 1;
                        }
                    } catch (NullPointerException ex2) {
                        exp = 0;
                    }
                }

                if (term.containsKey(exp)) {
                    coef += term.get(exp);
                }
                term.put(exp, coef);
            }
        }
        if (excBool) {
            throw new Exception(errStr);
        }
    }

    public void addMono(Monomial a) {
        term.put(a.getExp(), a.getCoef());

    }

    public TreeMap<Integer, Double> getTerm() {
        return this.term;
    }

    public String toString() {
        String r = "";
        if (term.size() == 0) {
            r += "0";
        } else {
            for (Map.Entry<Integer, Double> m : term.entrySet()) {
                Monomial x = new Monomial(m.getKey(), m.getValue());
                r += x.toString();
            }
        }
        r += " ";

        return r;
    }
}
