public class Line implements PolyInterface {
    private double coefficient;
    private Constant constant;
//    private int constant;

    Line(double coefficient, double c){
        this.coefficient =  coefficient;
        this.constant = new Constant(c);
    }
    public int getDegree() {
            return 1;
    }

    @Override
    public double getCoefficient(int power) throws IllegalArgumentException{
        if (power == 0){
            // return the constant
            return this.constant.getCoefficient(0);
        } else if (power == 1){
            return this.coefficient;
            // return coefficient of x
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
    public boolean isEqualTo(PolyInterface other) throws IllegalArgumentException{
        if (this.constant.getDegree() == other.getDegree()){
            if (this.constant.getCoefficient(0) == other.getCoefficient(0)){
                return true;
            }
        }
        return false;
    }

    @Override
    public double evaluateAt(double number) {
        return number*this.constant.getCoefficient(1) + this.constant.getCoefficient(0);
    }

    @Override
    public double getLeadingCoefficient() {
        return this.coefficient;
    }

    @Override
    public double getYIntercept() {
        return evaluateAt(0);
    }

    @Override
    public PolyInterface plus(PolyInterface other) throws IllegalArgumentException{
        if(other.getDegree() == 0){
            double v = other.getCoefficient(0) + this.constant.getCoefficient(0);
            return new Line(this.coefficient, (other.getCoefficient(0) + this.constant.getCoefficient(0)));
        }else if (other.getDegree() == 1){
            return new Line((int) (other.getCoefficient(1) + this.getCoefficient(1)),(other.getCoefficient(0)
                    + this.constant.getCoefficient(0)));
        }else if(other.getDegree() == 2){
            return other.plus(this);
        }
        else{
            throw new IllegalArgumentException("Power should be less than 3");
        }
    }

    @Override
    public String getString() {
        if (getCoefficient(1) == 0){
            return "P(x) = " + this.constant.getCoefficient(0);
        }else if (getCoefficient(1) < 0){
            if (getCoefficient(1) == -1){
                if (this.constant.getCoefficient(0) == 0){
                    return "P(x) = -x";
                }else if (this.constant.getCoefficient(0) > 0){
                    return "P(x) = -x + " + this.constant.getCoefficient(0);
                }else{
                    return "P(x) = -x " + this.constant.getCoefficient(0);
                }
            }else{
                if (this.constant.getCoefficient(0) == 0){
                    return "P(x) = -" + this.constant.getCoefficient(1) + "x";
                }else if (this.constant.getCoefficient(0) > 0){
                    return "P(x) = -" + this.constant.getCoefficient(1) + "x + " + this.constant.getCoefficient(0);
                }else{
                    return "P(x) = -" + this.constant.getCoefficient(1) + "x - " + this.constant.getCoefficient(0);
                }
            }
        }else{
            if (this.constant.getCoefficient(0) == 0){
                return "P(x) = " + this.constant.getCoefficient(1) + "x";
            }else if (this.constant.getCoefficient(0) > 0){
                return "P(x) = " + this.constant.getCoefficient(1) + "x + " + this.constant.getCoefficient(0);
            }else{
                return "P(x) = " + this.constant.getCoefficient(1) + "x - " + this.constant.getCoefficient(0);
            }
        }
    }

    @Override
    public String toString(){
        return getString();
    }

    @Override
    public PolyInterface translate(double dx, double dy) {
        return new Line(this.coefficient, this.getCoefficient(0) - (dx * this.coefficient) + dy);
    }

    @Override
    public PolyInterface multiply(PolyInterface other) throws IllegalArgumentException {
        if(other.getDegree() == 0){
            double v = other.getCoefficient(0) + this.constant.getCoefficient(0);
            return new Line(this.coefficient * other.getCoefficient(0), (other.getCoefficient(0) * this.constant.getCoefficient(0)));
        }else if (other.getDegree() == 1){
            return new Quadratic((int) (other.getCoefficient(1) * this.getCoefficient(1)),
                    (int) (other.getCoefficient(1) * this.getCoefficient(0)) + (int) (other.getCoefficient(0) * this.getCoefficient(1)),
                    (other.getCoefficient(0) + this.constant.getCoefficient(0)));
        }
        else{
            throw new IllegalArgumentException("Power should be less than 3");
        }
    }
}
