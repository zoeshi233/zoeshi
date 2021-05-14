package expressions;

public class ConjoinAll extends ExpressionCollector {
	void evaluate() {
		boolean result = true;
		for(int i = 0; i < expressions.size(); i++) {
			expressions.get(i).evaluate();
			result = result && (boolean) expressions.get(i).getValue();
		}
		this.value = result;
	}
}
