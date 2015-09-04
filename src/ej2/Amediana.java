package ej2;

public class Amediana {	
	public int[] formar(int[] A){
		int[] B = new int[A.length];
		Arreglo arr = new Arreglo(A.length);
		for (int j = 0; j < A.length; j++) //Itero sobre el arreglo ubicando la mediana correspondiente en cada caso
		{
			arr.agregar(A[j]);
			B[j] = arr.mediana();
		}
		return B;
	}
	
}
