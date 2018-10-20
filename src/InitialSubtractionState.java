public class InitialSubtractionState extends State {
    protected static InitialSubtractionState singleton;

    public synchronized static InitialSubtractionState instance() {
        if (singleton == null) {
            singleton = new InitialSubtractionState();
        }
        return singleton;
    }

    @Override
    public void operation(Character c, CalculatorContext calculatorContext) {
        if (c == null) {
            calculatorContext.setState(
                    new ErrorState(
                            String.format("Invalid trailing operator (-) (%s)", calculatorContext.getInputString())
                    )
            );
        } else if (isInputMatch("[1-9]", c)) {
            calculatorContext.setOperand(Integer.parseInt(c.toString()));
            calculatorContext.setState(SubtractionOperandState.instance());
        } else {
            calculatorContext.setState(
                    new ErrorState(
                            String.format("Invalid leading character (%c) (%s)", c, calculatorContext.getInputString())
                    )
            );
        }

        printContext(calculatorContext);
    }
}
