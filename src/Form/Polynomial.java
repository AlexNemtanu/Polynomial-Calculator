package Form;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.*;

public class Polynomial{
    private final HashMap<Integer, Monomial> polynomial;
    public Polynomial()
    {
        this.polynomial = new HashMap<>();
    }
    //method to set a monomial to the polynomial
    public void setMonomial(Monomial monomial)
    {
        int exp = monomial.getExp();
        if(polynomial.containsKey(exp)) //we check if the polynomial already has the exponent of the monomial
        {
            Monomial existMonomial = polynomial.get(exp);//we take the monomial with the same exponent
            int newCoeff = existMonomial.getCoefficient() + monomial.getCoefficient();
            existMonomial.setCoefficient(newCoeff);  //the coefficient is set
        }else {
            polynomial.put(exp, monomial);//if not, we add the new monomial in the polynomial
        }
    }
    public static Polynomial setPolynomial(String inputString)
    {
        Polynomial polynomial = new Polynomial();
        //regular expression to match each term in the input string
        String termRegex = "([-+]?[0-9]*)\\*?x\\^?([0-9]+)?";
        Pattern pattern = Pattern.compile(termRegex);
        Matcher termMatcher = pattern.matcher(inputString);//we use a Matcher object to find matches for the regular expression within the input string

        if(!termMatcher.find())//if no match is found, display an error message
        {
            throw new IllegalArgumentException("Invalid format of the polynomial");
        }
        // loop through each matched term and create a Monomial object to represent it
        do{
            //extract the coefficient and power from the matched term
            String coeffString = termMatcher.group(1);
            String expString = termMatcher.group(2);
            int coefficient = coeffString.isEmpty()? 1 : Integer.parseInt(coeffString); // if the coefficient is empty, he is either 1 or the coefficient of the monomial
            int exp = (expString == null || expString.isEmpty())? 1 : Integer.parseInt(expString);

            Monomial monomial = new Monomial(coefficient, exp);
            polynomial.setMonomial(monomial);
        }while (termMatcher.find());
        return polynomial;
    }
    public String polynomialToString() {
        StringBuilder string = new StringBuilder();
        int exp;
        //loop through each exponent in descending order
        for (exp = this.findGradeOfPolynomial(); exp >= 0; exp--) {
            int coefficient = this.getCoefficient(exp);//get the coefficient for the current exponent

            if (coefficient == 0) {//if the coeff is 0, skip to next iteration
                continue;
            }
            if (coefficient > 0 && string.length() > 0) {//if the coeff is positive and not the first term, append the + sign
                string.append("+");
            }
            if (coefficient == -1 && exp > 0) { //if the coeff is negative and not -1, append the - sign
                string.append("-");
            } else if (coefficient != 1 || exp == 0) {
                string.append(coefficient);
            }
            if (exp > 0) {
                string.append("x");
                if (exp > 1) {
                    string.append("^").append(exp);
                }
            }
        }
        if(string.length() == 0) {//if the string builder is empty, the polynomial is 0
            string.append("0");
        }
        return string.toString();//return polynomial as a String
    }
    public HashMap<Integer, Monomial> getPolynomial() {
        return polynomial;
    }
    public int findGradeOfPolynomial()
    {
        int grade = 0;//initialize the maximum grade to 0
        //iterate through each monomial in the polynomial
        for(Map.Entry<Integer, Monomial> input : polynomial.entrySet())
        {
            int currentGrade = input.getKey();//get the grade of the current monomial
            if(currentGrade > grade)
            {
                grade = currentGrade;
            }
        }
        return grade;
    }
    public int getCoefficient(int exp)//method to return the coefficient of the monomial that has the specified exponent
    {
        if(polynomial.containsKey(exp))//check if there is a monomial with the specified power as the key in the map
            return polynomial.get(exp).getCoefficient();

        return 0;//if there is no monomial with the specified power as the key map, return 0
    }
}