public class AdditionAccumulatorState extends AccumulatorState {
    protected static AdditionAccumulatorState singleton;

    public synchronized static AdditionAccumulatorState instance() {
        if (singleton == null) {
            singleton = new AdditionAccumulatorState();
        }
        return singleton;
    }

    @Override
    protected void computeCurrentTotal(CalculatorContext calculatorContext) {
        calculatorContext.setCurrentTotal(calculatorContext.getCurrentTotal() + calculatorContext.getOperand());
    }
}
