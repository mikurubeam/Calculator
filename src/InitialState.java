public class InitialState extends State {
    @Override
    public void operation(Character c, CalculatorContext calculatorContext) throws Exception{
        if (isInputMatch("[1-9]", c)) {
            calculatorContext.setOperand(Integer.parseInt(c.toString()));
            calculatorContext.setState(State.factory("InitialTotal"));
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
