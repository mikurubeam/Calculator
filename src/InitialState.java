public class InitialState extends State {
    protected static InitialState singleton;

    public synchronized static InitialState instance() {
        if (singleton == null) {
            singleton = new InitialState();
        }
        return singleton;
    }

    @Override
    public void operation(Character c, CalculatorContext calculatorContext) throws Exception{
        if (isInputMatch("[1-9]", c)) {
            calculatorContext.setOperand(Integer.parseInt(c.toString()));
            calculatorContext.setState(InitialOperandState.instance());
        } else {
            calculatorContext.setErrorMessage(
                    String.format("Invalid leading character (%c) (%s)", c, calculatorContext.getInputString())
            );
            calculatorContext.setState(ErrorState.instance());
        }

        printContext(calculatorContext);
    }
}
