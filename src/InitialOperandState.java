public class InitialOperandState extends ComputeState {
    protected static InitialOperandState singleton;

    public synchronized static InitialOperandState instance() {
        if (singleton == null) {
            singleton = new InitialOperandState();
        }
        return singleton;
    }

    @Override
    protected void computeCurrentTotal(CalculatorContext calculatorContext) {
        calculatorContext.setCurrentTotal(calculatorContext.getOperand());
    }
}
