public class SubtractionOperandState extends ComputeState {
    protected static SubtractionOperandState singleton;

    public synchronized static SubtractionOperandState instance() {
        if (singleton == null) {
            singleton = new SubtractionOperandState();
        }
        return singleton;
    }

    @Override
    protected void computeCurrentTotal(CalculatorContext calculatorContext) {
        calculatorContext.setCurrentTotal(calculatorContext.getCurrentTotal() - calculatorContext.getOperand());
    }
}
