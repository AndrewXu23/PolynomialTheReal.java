public interface Comparable<Fraction>{
    /**
     * Return positive:fraction1 bigger than fraction2
     * negative:fraction1 less than fraction2
     * 0:fraction1 equals to fraction2
     * @return
     */
    int compareTo(Fraction other);
}
