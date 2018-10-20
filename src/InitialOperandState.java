public class InitialOperandState extends State {
    protected static InitialOperandState singleton;

    public synchronized static InitialOperandState instance() {
        if (singleton == null) {
            singleton = new InitialOperandState();
        }
        return singleton;
    }

    @Override
    public void operation(Character c, CalculatorContext calculatorContext) {
        if (c == null) {
            calculatorContext.setState(CompleteState.instance());
        } else if (isInputMatch("[0-9]", c)) {
            calculatorContext.setCurrentTotal(calculatorContext.getCurrentTotal()*10 + Integer.parseInt(c.toString()));
        } else if (isInputMatch("[+]", c)) {
            calculatorContext.setState(InitialAdditionState.instance());
        } else if (isInputMatch("[-]", c)) {
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
