import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class State {

    public boolean isComplete() {
        return false;
    }

    public abstract void operation(Character c, CalculatorContext calculatorContext) throws Exception;

    static boolean isInputMatch(String pattern, Character c) {
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(c.toString());
        return m.matches();
    }

    static void printContext(CalculatorContext calculatorContext) {
        if (calculatorContext.isVerbose()) {
            System.out.println(calculatorContext);
        }
    }
}
