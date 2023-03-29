package Model;

public class Monomial {
    private Double coef;
    private Integer exp;

    public Integer getExp() {
        return this.exp;
    }

    public void setExp(Integer exp) {
        this.exp = exp;
    }

    public Double getCoef() {
        return this.coef;
    }

    public void setCoef(Double coef) {
        this.coef = coef;
    }

    public Monomial(Integer exp, Double coef) {
        this.exp = exp;
        this.coef = coef;
    }

    public String toString() {
        String sign = (this.getCoef() < 0) ? " -" : " +";
        if (this.getExp().equals(0)) {
            return sign + Math.abs(this.coef);
        } else if (this.getExp().equals(1)) {
            return sign + Math.abs(this.coef) + "x";
        } else {
            return sign + Math.abs(this.coef) + "x^" + this.exp;
        }
    }
}
