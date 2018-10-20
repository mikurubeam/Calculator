public class InitialTotalState extends State {
    @Override
    public void operation(Character c, CalculatorContext calculatorContext) {
        if (c == null) {
            calculatorContext.setState(State.factory("Complete"));
        } else if (isInputMatch("[0-9]", c)) {
            calculatorContext.setCurrentTotal(calculatorContext.getCurrentTotal()*10 + Integer.parseInt(c.toString()));
        } else if (isInputMatch("[+]", c)) {
            calculatorContext.setState(State.factory("InitialAddition"));
        } else if (isInputMatch("[-]", c)) {
            calculatorContext.setState(State.factory("InitialSubtraction"));
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
