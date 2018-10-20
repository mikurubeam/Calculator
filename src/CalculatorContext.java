import java.util.ArrayList;
import java.util.List;

public class CalculatorContext {
    private int currentTotal = 0;
    private char operation = '+';
    private int operand = 0;
    private State state = State.factory("Initial");
    private boolean verbose = false;
    private String inputString;

    public CalculatorContext(String inputString) {
        this.inputString = inputString;
    }

    public CalculatorContext(String inputString, boolean verbose) {
        this(inputString);
        this.verbose = verbose;
    }

    public int getCurrentTotal() {
        return currentTotal;
    }

    public void setCurrentTotal(int currentTotal) {
        this.currentTotal = currentTotal;
    }

    public char getOperation() {
        return operation;
    }

    public void setOperation(char operation) {
        this.operation = operation;
    }

    public int getOperand() {
        return operand;
    }

    public void setOperand(int operand) {
        this.operand = operand;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public boolean isVerbose() {
        return verbose;
    }

    public void setVerbose(boolean verbose) {
        this.verbose = verbose;
    }

    public String getInputString() {
        return inputString;
    }

    private void executeOperation(Character c) throws Exception {
        this.getState().operation(c, this);
    }

    private void run() {
        try {
            Character c;
            int i = 0;
            while (this.isRunning()) {
                if (i < this.getInputString().length()) {
                    c = this.getInputString().charAt(i);
                } else {
                    c = null;
                }

                i++;

                this.executeOperation(c);
            }

            this.printResults();
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    private boolean isRunning() {
        return (this.getState().isComplete() == false);
    }

    private void printResults() {
        System.out.println(String.format("Results: %s = %d", this.inputString, this.currentTotal));
    }

    public static void main(String[] args) {
        List<CalculatorContext> contextList = new ArrayList<>();
        contextList.add(new CalculatorContext("1+2+3+4"));
        contextList.add(new CalculatorContext("11+12+13+14"));
        contextList.add(new CalculatorContext("11+12-13-14"));
        contextList.add(new CalculatorContext("01"));
        contextList.add(new CalculatorContext("1+02"));
        contextList.add(new CalculatorContext("1++2"));
        contextList.add(new CalculatorContext("1.2"));
        contextList.add(new CalculatorContext("1/2"));
        contextList.add(new CalculatorContext("1*2"));
        contextList.add(new CalculatorContext("1%2"));
        contextList.add(new CalculatorContext("1+2+3+4+"));

        for (CalculatorContext calculatorContext : contextList) {
            calculatorContext.run();
        }
    }

    @Override
    public String toString() {
        return "Input String:\t" + this.inputString + "\n"
                + "Current Total:\t" + this.currentTotal + "\n"
                + "Operation:\t" + this.operation + "\n"
                + "Operand:\t" + this.operand + "\n"
                + "Current State:\t" + this.state.getClass().getName() + "\n";
    }
}
