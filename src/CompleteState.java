public class CompleteState extends State {
    @Override
    public boolean isComplete() {
        return true;
    }

    @Override
    public void operation(Character c, CalculatorContext calculatorContext) throws Exception {
        printContext(calculatorContext);
    }
}
