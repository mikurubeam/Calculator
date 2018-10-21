public class InitialAdditionState extends InitialBranchState {
    protected static InitialAdditionState singleton;

    private InitialAdditionState() {
        this.trailingOperatorErrorMessage = "Invalid trailing operator (+) (%s)";
    }

    public synchronized static InitialAdditionState instance() {
        if (singleton == null) {
            singleton = new InitialAdditionState();
        }
        return singleton;
    }

    @Override
    protected void moveToOperandState(CalculatorContext calculatorContext) {
        calculatorContext.setState(AdditionOperandState.instance());
    }
}
