public class AdditionInitialState extends InitialState {
    protected static AdditionInitialState singleton;

    private AdditionInitialState() {
        this.trailingOperatorErrorMessage = "Invalid trailing operator (+) (%s)";
    }

    public synchronized static AdditionInitialState instance() {
        if (singleton == null) {
            singleton = new AdditionInitialState();
        }
        return singleton;
    }

    @Override
    protected void moveToAccumulatorState(CalculatorContext calculatorContext) {
        calculatorContext.setState(AdditionAccumulatorState.instance());
    }
}
