package expressions;

public class Multiplication extends Expression {

	Multiplication(int left, int right) {
		super(left, right);
		// TODO Auto-generated constructor stub
	}
	
	void evaluate() {
		this.value = this.left * this.right;
	}
}
