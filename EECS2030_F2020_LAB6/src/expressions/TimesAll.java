package expressions;

public class TimesAll extends ExpressionCollector {
	void evaluate() {
		int result = 1;
		for(int i = 0; i < expressions.size(); i++) {
			expressions.get(i).evaluate();
			result *= (int) expressions.get(i).getValue();
		}
		this.value = result;
	}
}
