public interface FractionInterface {


    /**
     * Return the scientific value (decimal) of the fraction
     * @return
     */
    double toDouble(Fraction constructor);

    /**
     * Return the reciprocal of this fraction
     * @return
     */
    FractionInterface reciprocal();

    /**
     * Return the sum of current fraction to the one passed to it
     * @return
     */
    FractionInterface add(FractionInterface otherFraction);

    /**
     * returns a String depicting the fraction’s value in simplest form
     * @return
     */
    String toString();

}

