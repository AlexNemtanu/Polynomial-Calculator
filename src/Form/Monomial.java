package Form;

public class Monomial {

    private final int exp; //the exponent of the monomial
    private int coefficient; // the coefficient of the monomial

    public Monomial(int coefficient, int exp)
    {
        this.coefficient = coefficient;
        this.exp = exp;
    }
    public void setCoefficient(int coefficient)
    {
        this.coefficient=coefficient;
    }
    public int getExp()
    {
        return exp;
    }
    public int getCoefficient()
    {
        return coefficient;
    }

}
