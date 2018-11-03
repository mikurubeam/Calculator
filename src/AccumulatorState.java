public abstract class AccumulatorState extends State {
    protected abstract void computeCurrentTotal(CalculatorContext calculatorContext);

    @Override
    public void operation(Character c, CalculatorContext calculatorContext) {
        if (c == null) {
            this.computeCurrentTotal(calculatorContext);
            calculatorContext.setState(CompleteState.instance());
        } else if (isInputMatch("[+]", c)) {
            this.computeCurrentTotal(calculatorContext);
            calculatorContext.setState(AdditionInitialState.instance());
        } else if (isInputMatch("[-]", c)) {
            this.computeCurrentTotal(calculatorContext);
            calculatorContext.setState(SubtractionInitialState.instance());
        } else if (isInputMatch("[0-9]", c)) {
            calculatorContext.updateOperand(Integer.parseInt(c.toString()));
        } else {
            calculatorContext.setErrorMessage(
                    String.format("Invalid character (%c) (%s)", c, calculatorContext.getInputString())
            );
            calculatorContext.setState(ErrorState.instance());
        }

        printContext(calculatorContext);
    }
}
