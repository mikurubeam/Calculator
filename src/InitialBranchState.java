public abstract class InitialBranchState extends State {
    protected String trailingOperatorErrorMessage;

    @Override
    public void operation(Character c, CalculatorContext calculatorContext) {
        if (c == null) {
            calculatorContext.setErrorMessage(
                    String.format(this.trailingOperatorErrorMessage, calculatorContext.getInputString())
            );
            calculatorContext.setState(ErrorState.instance());
        } else if (isInputMatch("[1-9]", c)) {
            calculatorContext.setOperand(Integer.parseInt(c.toString()));
            calculatorContext.setState(SubtractionOperandState.instance());
        } else {
            calculatorContext.setErrorMessage(
                    String.format("Invalid leading character (%c) (%s)", c, calculatorContext.getInputString())
            );
            calculatorContext.setState(ErrorState.instance());
        }

        printContext(calculatorContext);
    }
}
