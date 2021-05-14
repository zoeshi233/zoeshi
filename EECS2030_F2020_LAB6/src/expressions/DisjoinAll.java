package expressions;

public class DisjoinAll extends ExpressionCollector {
	void evaluate() {
		boolean result = false;
		for(int i = 0; i < expressions.size(); i++) {
			expressions.get(i).evaluate();
			result = result || (boolean) expressions.get(i).getValue();
		}
		this.value = result;
	}
}
