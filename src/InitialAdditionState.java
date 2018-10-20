public class InitialAdditionState extends State {
    @Override
    public void operation(Character c, CalculatorContext calculatorContext) {
        calculatorContext.setCurrentTotal(calculatorContext.getCurrentTotal() + calculatorContext.getOperand());
        if (c == null) {
            calculatorContext.setState(
                    new ErrorState(
                            String.format("Invalid trailing operator (%c) (%s)", c, calculatorContext.getInputString())
                    )
            );
        } else if (isInputMatch("[1-9]", c)) {
            calculatorContext.setOperand(calculatorContext.getOperand()*10 + Integer.parseInt(c.toString()));
            calculatorContext.setState(State.factory("AdditionOperand"));
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
