package Logic;

import Model.Polynomial;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OperationsPTest {

    @Test
    void add() throws Exception {
        OperationsP op = new OperationsP();

        Polynomial p1 = new Polynomial("+3x^2-1");
        Polynomial p2 = new Polynomial("-x^2+x+6");
        Polynomial p = op.add(p1, p2);
        Polynomial _p = new Polynomial("+2x^2+x+5");

        String strP = p.toString();
        String _strP = _p.toString();

        Assertions.assertEquals(_strP, strP);

    }

    @Test
    void sub() throws Exception {
        OperationsP op = new OperationsP();

        Polynomial p1 = new Polynomial("+3x^2-1");
        Polynomial p2 = new Polynomial("-x^2+x+6");
        Polynomial p = op.sub(p1, p2);
        Polynomial _p = new Polynomial("+4x^2-x-7");

        String strP = p.toString();
        String _strP = _p.toString();

        Assertions.assertEquals(_strP, strP);
    }

    @Test
    void mul() throws Exception {
        OperationsP op = new OperationsP();

        Polynomial p1 = new Polynomial("+x^2-2");
        Polynomial p2 = new Polynomial("-x^2+x");
        Polynomial p = op.mul(p1, p2);
        Polynomial _p = new Polynomial("-x^4+x^3+2x^2-2x");

        String strP = p.toString();
        String _strP = _p.toString();

        Assertions.assertEquals(_strP, strP);
    }

    @Test
    void div() throws Exception {
        OperationsP op = new OperationsP();

        Polynomial p1 = new Polynomial("+x^3-2x^2+6x-5");
        Polynomial p2 = new Polynomial("+x^2-1");
        Polynomial[] p = op.div(p1, p2);
        Polynomial _pq = new Polynomial("+x-2");
        Polynomial _pr = new Polynomial("+7x-7");

        String strPq = p[0].toString();
        String strPr = p[1].toString();

        String _strPq = _pq.toString();
        String _strPr = _pr.toString();

        Assertions.assertEquals(_strPq, strPq);
        Assertions.assertEquals(_strPr, strPr);
    }

    @Test
    void der() throws Exception {
        OperationsP op = new OperationsP();

        Polynomial p1 = new Polynomial("+3x^2-1");
        Polynomial p = op.der(p1);
        Polynomial _p = new Polynomial("+6x");

        String strP = p.toString();
        String _strP = _p.toString();

        Assertions.assertEquals(_strP, strP);
    }

    @Test
    void intg() throws Exception{
        OperationsP op = new OperationsP();

        Polynomial p1 = new Polynomial("+3x^2-1");
        Polynomial p = op.intg(p1);
        Polynomial _p = new Polynomial("+x^3-x");

        String strP = p.toString();
        String _strP = _p.toString();

        Assertions.assertEquals(_strP, strP);
    }

    @Test
    void wrongMul() throws Exception {
        OperationsP op = new OperationsP();

        Polynomial p1 = new Polynomial("+x^2-2");
        Polynomial p2 = new Polynomial("-x^2+x");
        Polynomial p = op.mul(p1, p2);
        Polynomial _p = new Polynomial("-x^4+x^3+2x^2-x");

        String strP = p.toString();
        String _strP = _p.toString();

        Assertions.assertEquals(_strP, strP);
    }

    @Test
    void wrongIntg() throws Exception{
        OperationsP op = new OperationsP();

        Polynomial p1 = new Polynomial("+3x^2-1");
        Polynomial p = op.intg(p1);
        Polynomial _p = new Polynomial("+x^3-2x");

        String strP = p.toString();
        String _strP = _p.toString();

        Assertions.assertEquals(_strP, strP);
    }
}