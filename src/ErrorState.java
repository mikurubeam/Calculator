public class ErrorState extends State {
    protected static ErrorState singleton;

    public synchronized static ErrorState instance() {
        if (singleton == null) {
            singleton = new ErrorState();
        }
        return singleton;
    }

    @Override
    public void operation(Character c, CalculatorContext calculatorContext) throws Exception {
        calculatorContext.setState(CompleteState.instance());
        throw new Exception(calculatorContext.getErrorMessage());
    }
}
