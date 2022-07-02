public class Quadratic implements PolyInterface{

    private double coefficient1;
    private double coefficient2;
    private Constant constant;
//    private int constant;

    Quadratic(double coefficient1, double c, double v){
        this.coefficient1 =  coefficient1;
        this.coefficient2 =  coefficient2;
        this.constant = new Constant(c);
    }

    @Override
    public int getDegree() {
        return 2;
    }

    @Override
    public double getCoefficient(int power) {
        if (power == 0){
            // return the constant
            return this.constant.getCoefficient(0);
        } else if (power == 1){
            return this.constant.getCoefficient(1);
            // return coefficient of x
        } else if (power == 2){
            return this.constant.getCoefficient(2);
            // return coefficient of x^2
        } else {
            // illegal argument
            throw new IllegalArgumentException("Invalid Degree!");
        }
    }

    @Override
    public boolean isRoot(double number) {
        return evaluateAt(number) == 0;
    }

    @Override
    public boolean isEqualTo(PolyInterface other) {
        if (this.constant.getDegree() == other.getDegree()){
            if (this.constant.getCoefficient(0) == other.getCoefficient(0)){
                return true;
            }
        }
        return false;
    }

    @Override
    public double evaluateAt(double number) {
        return number*this.constant.getCoefficient(2) + number*this.constant.getCoefficient(1)
                + this.constant.getCoefficient(0);
    }

    @Override
    public double getLeadingCoefficient() {
        return this.coefficient1;
    }

    @Override
    public double getYIntercept() {
        return evaluateAt(0);
    }

    @Override
    public PolyInterface plus(PolyInterface other) throws IllegalArgumentException {
        if(other.getDegree() == 0){
            double v = other.getCoefficient(0) + this.constant.getCoefficient(0);
            return new Quadratic(this.coefficient1, this.coefficient2,(other.getCoefficient(0) + this.constant.getCoefficient(0)));
        }else if (other.getDegree() == 1){
            return new Quadratic(this.coefficient1, (other.getCoefficient(1) + this.getCoefficient(1)),(other.getCoefficient(0)
                    + this.constant.getCoefficient(0)));
        }else if(other.getDegree() == 2){
            return new Quadratic(this.coefficient1 + other.getCoefficient(2), (other.getCoefficient(1) + this.getCoefficient(1)),(other.getCoefficient(0)
                    + this.constant.getCoefficient(0)));
        }
        else{
            throw new IllegalArgumentException("Power should be less than 3");
        }
    }

    @Override
    public String getString() {
        if (getCoefficient(2) == 0){
            return new Line(coefficient2, 1).getString();
        }else if (getCoefficient(2) < 0){
            if (getCoefficient(2) == -1){
                if (this.constant.getCoefficient(0) == 0){
                    return "P(x) = -x^2" + getCoefficient(1);
                }else if (this.constant.getCoefficient(0) > 0){
                    return "P(x) = -x^2 + " + getCoefficient(1) + " x " + " + " + this.constant.getCoefficient(0);
                }else{
                    return "P(x) = -x^2 + " + getCoefficient(1) + " x " + " -" + this.constant.getCoefficient(0);
                }
            }
            else{
                return "P(x) = " + getCoefficient(2) + " x^2 " + new Line(coefficient2, 1).getString();
            }
        }else if (getCoefficient(2) == 1){
            return "P(x) = x^2" + new Line(coefficient2, 1).getString();
        }else{
            return "P(x) = " + getCoefficient(2) + "x^2" + new Line(coefficient2, 1).getString();
        }
    }

    @Override
    public PolyInterface translate(double dx, double dy) {
        return new Quadratic(this.getCoefficient(2) - (dx * this.coefficient1),
                this.getCoefficient(1) - (dx * this.coefficient2), this.getCoefficient(0) + dy);
    }

    @Override
    public PolyInterface multiply(PolyInterface other) throws IllegalArgumentException {
        if(other.getDegree() == 0){
            return new Quadratic(this.coefficient1 * other.getCoefficient(0), this.coefficient2 * other.getCoefficient(0),
                    (other.getCoefficient(0) * this.constant.getCoefficient(0)));
        }
        else{
            throw new IllegalArgumentException("Power should be less than 3");
        }
    }
}
