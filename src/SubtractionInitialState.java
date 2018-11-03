public class SubtractionInitialState extends InitialState {
    protected static SubtractionInitialState singleton;

    private SubtractionInitialState() {
        this.trailingOperatorErrorMessage = "Invalid trailing operator (-) (%s)";
    }

    public synchronized static SubtractionInitialState instance() {
        if (singleton == null) {
            singleton = new SubtractionInitialState();
        }
        return singleton;
    }

    @Override
    protected void moveToAccumulatorState(CalculatorContext calculatorContext) {
        calculatorContext.setState(SubtractionAccumulatorState.instance());
    }
}
