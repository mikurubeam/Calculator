public class ErrorState extends State {
    String errorMessage;

    public ErrorState(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    @Override
    public void operation(Character c, CalculatorContext calculatorContext) throws Exception {
        calculatorContext.setState(State.factory("Complete"));
        throw new Exception(this.errorMessage);
    }
}
