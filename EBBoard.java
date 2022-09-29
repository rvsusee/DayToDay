package rvsusee;

public interface EBBoard {
	int[] getInputs();
	int calculateBill(int unit,int unitCost,int tax);
}
