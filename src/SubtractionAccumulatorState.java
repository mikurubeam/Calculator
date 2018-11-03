public class SubtractionAccumulatorState extends AccumulatorState {
    protected static SubtractionAccumulatorState singleton;

    public synchronized static SubtractionAccumulatorState instance() {
        if (singleton == null) {
            singleton = new SubtractionAccumulatorState();
        }
        return singleton;
    }

    @Override
    protected void computeCurrentTotal(CalculatorContext calculatorContext) {
        calculatorContext.setCurrentTotal(calculatorContext.getCurrentTotal() - calculatorContext.getOperand());
    }
}
