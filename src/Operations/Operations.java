package Operations;

import Form.Monomial;
import Form.Polynomial;
import java.util.Map;

public class Operations {
    public static Polynomial addPolynomials(Polynomial p1, Polynomial p2)
    {
        Polynomial result = new Polynomial(); //a new polynomial in which I'll store the result
        //iterate through p1
        for(Map.Entry<Integer, Monomial> input: p1.getPolynomial().entrySet())
        {
            int exp = input.getKey();//get the exponent of the current monomial
            int coefficient = input.getValue().getCoefficient(); //get the coefficient of the current monomial

            if(p2.getPolynomial().containsKey(exp))//if p2 has a monomial with the same power
            {
                coefficient += p2.getPolynomial().get(exp).getCoefficient();//add the coefficients
            }
            if(coefficient != 0)//if the resulting coefficient is not 0
            {
                Monomial monomial = new Monomial(coefficient, exp);//create a new monomial
                result.setMonomial(monomial);//add monomial to the result polynomial
            }
        }
        //iterate through p2
        for(Map.Entry<Integer, Monomial> input : p2.getPolynomial().entrySet())
        {
            int exp = input.getKey();
            int coefficient = input.getValue().getCoefficient();
            if(!p1.getPolynomial().containsKey(exp))//if p1 does not have a monomial with the same power
            {
                Monomial monomial = new Monomial(coefficient, exp);
                result.setMonomial(monomial);
            }
        }
        return result;

    }
    public static Polynomial subPolynomials(Polynomial p1, Polynomial p2)
    {
        Polynomial result = new Polynomial();
        for(Map.Entry<Integer, Monomial> input : p1.getPolynomial().entrySet())
        {
            int coefficient = input.getValue().getCoefficient();
            int exp = input.getKey();

            if(p2.getPolynomial().containsKey(exp))
            {
                coefficient -= p2.getPolynomial().get(exp).getCoefficient();
            }
            if(coefficient != 0)
            {
                Monomial monomial = new Monomial(coefficient,exp);
                result.setMonomial(monomial);
            }
        }
        for(Map.Entry<Integer,Monomial> input: p2.getPolynomial().entrySet())
        {
            int coefficient = input.getValue().getCoefficient();
            int exp = input.getKey();
            if(!p1.getPolynomial().containsKey(exp))
            {
                coefficient = -coefficient;
                Monomial monomial = new Monomial(coefficient,exp);
                result.setMonomial(monomial);
            }
        }
        return result;

    }
    public static Polynomial multiplyPolynomials(Polynomial p1, Polynomial p2)
    {
        Polynomial result = new Polynomial();
        //loop through each term in p1
        for(Map.Entry<Integer, Monomial> inputP1: p1.getPolynomial().entrySet())
        {
            int coefficientP1 = inputP1.getValue().getCoefficient();//get the coefficient of the current term in p1
            int expP1  = inputP1.getKey();//get the exponent of the current term in p1
            //loop through each term in p2
            for(Map.Entry<Integer, Monomial> inputP2: p2.getPolynomial().entrySet())
            {
                int coefficientP2 = inputP2.getValue().getCoefficient();//get the coefficient of the current term in p2
                int expP2 = inputP2.getKey();//get the exponent of the current term in p2
                int newExp = expP1 + expP2;//compute the exponent of the product term
                int newCoeff = coefficientP1*coefficientP2;//compute the coefficient of the product term
                //check if the result polynomials contains a term with the same power
                if(result.getPolynomial().containsKey(newExp))
                {
                    newCoeff += result.getCoefficient(newExp);//add the existing coefficient to the existing coefficient
                }
                if(newCoeff != 0)
                {
                    Monomial monomial = new Monomial(newCoeff, newExp);
                    result.setMonomial(monomial);
                }
            }
        }
        return result;
    }

}
