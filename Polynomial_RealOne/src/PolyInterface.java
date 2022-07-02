public interface PolyInterface {

    /**
     * Return the degree of the polynomial
     * @return
     */
    int getDegree();

    /**
     * Return the coefficient for the term with specific power
     *
     * @return
     */
    double getCoefficient(int power);

    /**
     * Return true: the number taken is a root
     *        false: the number taken is not a root
     * @return
     */
    boolean isRoot(double number);

    /**
     * Return true: two polynomials are the same class and are qeuivalent
     *        false: two polynomials are not the same class or not qeuivalent
     * @return
     */
    boolean isEqualTo(PolyInterface other);

    double evaluateAt(double number);

    /**
     * Return the power of the leading coefficient
     *
     * @return
     */
    double getLeadingCoefficient();

    /**
     * Return the polynomial evaluated at 0
     * @return
     */
    double getYIntercept();

    /**
     * Return the sum of two polynomials
     *
     * @return
     */
    PolyInterface plus(PolyInterface other);

    /**
     * returns a String representation of the polynomial
     * @return
     */
    String getString();

    /**
     * returns a new polynomial r
     *
     * @return
     */
    PolyInterface translate(double dx, double dy);

    /**
     * returns polynomial obtained by multiplying the two polynomials
     * @return
     */
    PolyInterface multiply(PolyInterface other);

}
