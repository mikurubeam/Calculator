public class CompleteState extends State {
    protected static CompleteState singleton;

    public synchronized static CompleteState instance() {
        if (singleton == null) {
            singleton = new CompleteState();
        }
        return singleton;
    }

    @Override
    public boolean isComplete() {
        return true;
    }

    @Override
    public void operation(Character c, CalculatorContext calculatorContext) throws Exception {
        printContext(calculatorContext);
    }
}
