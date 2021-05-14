package expressions;

public class Subtraction extends Expression {

	Subtraction(int left, int right) {
		super(left, right);
		// TODO Auto-generated constructor stub
	}
	
	void evaluate() {
		this.value = this.left - this.right;
	}
}
