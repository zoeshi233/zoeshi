package expressions;

public class LessThan extends Expression {

	LessThan(int left, int right) {
		super(left, right);
		// TODO Auto-generated constructor stub
	}
	
	void evaluate() {
		this.value = (this.left < this.right);
	}
}
