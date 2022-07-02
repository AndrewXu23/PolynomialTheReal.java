public class Constant implements PolyInterface{
    private double coefficient;
    private double power;

    public Constant (double coefficient){
        this.coefficient = coefficient;
        this.power = 0;
    }

    // new constructor, no arguments and assume constant term is 0
    public Constant() {
        this.coefficient = 0;
        this.power = 0;
    }

    /**
     * Return the degree of the polynomial
     * @return
     */
    public int getDegree(){
        return 0;
    }

    /**
     * Return the coefficient for the term with specific power
     *
     * @return
     */
    public double getCoefficient(int power) throws IllegalArgumentException{
        if (power != 0) {
            // throw error
            throw new IllegalArgumentException("It should be a constant");
        } else if(power == 0) {
            return this.coefficient;
        }
    }
    /**
     * Return true: the number taken is a root
     *        false: the number taken is not a root
     * @return
     */
    public boolean isRoot(double number){
        return false;
    }

    /**
     * Return true: two polynomials are the same class and are qeuivalent
     *        false: two polynomials are not the same class or not qeuivalent
     * @return
     */
    public boolean isEqualTo(PolyInterface other){
        Constant otherConstant = (Constant) other;
        return this.coefficient == otherConstant.coefficient;
    }

    public double evaluateAt(double x){
        return this.coefficient;
    }

    /**
     * Return the power of the leading coefficient
     * @return
     */
    public double getLeadingCoefficient(){
        return this.coefficient;
    }

    /**
     * Return the polynomial evaluated at 0
     * @return
     */
    public double getYIntercept(){
        return this.coefficient;
    }

    /**
     * Return the sum of two polynomials
     *
     * @return
     */
    public PolyInterface plus(PolyInterface other){
        Constant otherConstant = (Constant) other;
        return new Constant(this.coefficient + otherConstant.coefficient);
    }

    /**
     * returns a String representation of the polynomial
     * @return
     */
    @Override
    public String getString(){
        return "p(x) = " +  this.coefficient;
    }

    @Override
    public String toString(){
        return getString();
    }
}
