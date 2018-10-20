public class AdditionOperandState extends ComputeState {
    protected static AdditionOperandState singleton;

    public synchronized static AdditionOperandState instance() {
        if (singleton == null) {
            singleton = new AdditionOperandState();
        }
        return singleton;
    }

    @Override
    protected void computeCurrentTotal(CalculatorContext calculatorContext) {
        calculatorContext.setCurrentTotal(calculatorContext.getCurrentTotal() + calculatorContext.getOperand());
    }
}
