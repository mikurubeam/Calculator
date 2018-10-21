public abstract class ComputeState extends State {
    protected abstract void computeCurrentTotal(CalculatorContext calculatorContext);
    @Override
    public void operation(Character c, CalculatorContext calculatorContext) {
        boolean willUpdate = true;

        if (c == null) {
            calculatorContext.setState(CompleteState.instance());
        } else if (isInputMatch("[+]", c)) {
            calculatorContext.setState(InitialAdditionState.instance());
        } else if (isInputMatch("[-]", c)) {
            calculatorContext.setState(InitialSubtractionState.instance());
        } else if (isInputMatch("[0-9]", c)) {
            willUpdate = false;
            calculatorContext.updateOperand(Integer.parseInt(c.toString()));
        } else {
            willUpdate = false;
            calculatorContext.setErrorMessage(
                    String.format("Invalid character (%c) (%s)", c, calculatorContext.getInputString())
            );
            calculatorContext.setState(ErrorState.instance());
        }

        if (willUpdate) {
            this.computeCurrentTotal(calculatorContext);
        }

        printContext(calculatorContext);
    }
}
