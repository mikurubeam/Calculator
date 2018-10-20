public class InitialSubtractionState extends InitialBranchState {
    protected static InitialSubtractionState singleton;

    private InitialSubtractionState() {
        this.trailingOperatorErrorMessage = "Invalid trailing operator (-) (%s)";
    }

    public synchronized static InitialSubtractionState instance() {
        if (singleton == null) {
            singleton = new InitialSubtractionState();
        }
        return singleton;
    }
}
