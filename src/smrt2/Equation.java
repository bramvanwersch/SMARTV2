package smrt2;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonTypeInfo;


// To enable deserialisation using correct subtype when stored polymorphically
@JsonTypeInfo(use=JsonTypeInfo.Id.CLASS, include=JsonTypeInfo.As.PROPERTY, property="@class")
public class Equation {

	protected String rightHandSide;
	protected String leftHandSide;
	protected String[] variables;
	protected String[] operators;

	public Equation() {
		super();
	}

	public String getLeftHandSide() {
		return this.leftHandSide;
	}

	public void setLeftHandSide(String leftHandSide) {
		this.leftHandSide = leftHandSide;
	}

	public String getRightHandSide() {
		return this.rightHandSide;
	}

	public void setRightHandSide(String rightHandSide) {
		this.rightHandSide = rightHandSide;
	}

	@JsonIgnore
	public String[] getVariables() {
		return this.variables;
	}
	
	@JsonIgnore
	public String[] getOperators() {
		return this.operators;
	}

	public String[] toArray() {
		String[] AlgebraicEquationArray = {this.getLeftHandSide(),this.getRightHandSide()};
		return AlgebraicEquationArray;
	}

	public boolean testRightHandSide() {
		RightHandSideChecker tester = new RightHandSideChecker();
		return tester.test(this.getVariables(), this.getOperators());
	}

}