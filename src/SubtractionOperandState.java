public class SubtractionOperandState extends State {
    protected static SubtractionOperandState singleton;

    public synchronized static SubtractionOperandState instance() {
        if (singleton == null) {
            singleton = new SubtractionOperandState();
        }
        return singleton;
    }

    @Override
    public void operation(Character c, CalculatorContext calculatorContext) {
        if (c == null) {
            calculatorContext.setCurrentTotal(calculatorContext.getCurrentTotal() - calculatorContext.getOperand());
            calculatorContext.setState(CompleteState.instance());
        } else if (isInputMatch("[0-9]", c)) {
            calculatorContext.setOperand(calculatorContext.getOperand()*10 + Integer.parseInt(c.toString()));
        } else if (isInputMatch("[+]", c)) {
            calculatorContext.setCurrentTotal(calculatorContext.getCurrentTotal() - calculatorContext.getOperand());
            calculatorContext.setState(InitialAdditionState.instance());
        } else if (isInputMatch("[-]", c)) {
            calculatorContext.setCurrentTotal(calculatorContext.getCurrentTotal() - calculatorContext.getOperand());
            calculatorContext.setState(InitialSubtractionState.instance());
        } else {
            calculatorContext.setState(
                    new ErrorState(
                            String.format("Invalid character (%c) (%s)", c, calculatorContext.getInputString())
                    )
            );
        }

        printContext(calculatorContext);
    }
}
