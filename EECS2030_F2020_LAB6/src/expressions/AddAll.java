package expressions;

public class AddAll extends ExpressionCollector {
	void evaluate() {
		int result = 0;
		for(int i = 0; i < expressions.size(); i++) {
			expressions.get(i).evaluate();
			result += (int) expressions.get(i).getValue();
			}
		this.value = result;
	}
}
