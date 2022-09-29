package rvsusee.eb;

public interface EBBoard {
	int[] getInputs();
	double calculateBill(int unit,double unitCost);
}
