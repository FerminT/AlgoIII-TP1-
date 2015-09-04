package ej2;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Random;
import org.junit.Test;

public class AmedianaTest{

	@Test
	public void test1(){
		int[] A= {2, 3, 4, 1, 2};
		Amediana n = new Amediana();
		A = n.formar(A);
		String resultado = "";
		for (int i = 0; i < A.length; i++)
			resultado += Integer.toString(A[i]) + ((i != A.length - 1) ? " " : ""); //Solo agrego espacio si no es el último caracter
		assertEquals("2 2 3 2 2", resultado);
		System.out.println(resultado);
		System.out.println("Ok.");
	}
	
	@Test
	public void test2(){
		int[] A={2, 7, 2, 8, 4, 9, 1, 6, 5};
		Amediana n = new Amediana();
		A = n.formar(A);
		String resultado = "";
		for (int i = 0; i < A.length; i++)
			resultado += Integer.toString(A[i]) + ((i != A.length - 1) ? " " : ""); //Solo agrego espacio si no es el último caracter
		assertEquals("2 4 2 4 4 5 4 5 5", resultado);
		System.out.println(resultado);
		System.out.println("Ok.");
	}
	
	@Test
	public void test3(){
		int[] A= {1, 87, 4};
		Amediana n = new Amediana();
		A = n.formar(A);
		String resultado = "";
		for (int i = 0; i < A.length; i++)
			resultado += Integer.toString(A[i]) + ((i != A.length - 1) ? " " : ""); //Solo agrego espacio si no es el último caracter
		assertEquals("1 44 4", resultado);
		System.out.println(resultado);
		System.out.println("Ok.");
	}
	
	@Test
	public void test4(){
		int[] A={4, 0, 32, 6, 8, 10};
		Amediana n = new Amediana();
		A = n.formar(A);
		String resultado = "";
		for (int i = 0; i < A.length; i++)
			resultado += Integer.toString(A[i]) + ((i != A.length - 1) ? " " : ""); //Solo agrego espacio si no es el último caracter
		assertEquals("4 2 4 5 6 7", resultado);
		System.out.println(resultado);
		System.out.println("Ok.");
	}
	
	//TEST DE PERFORMANCE

	public void testear(int[] A){
		Amediana n = new Amediana();
		A = n.formar(A);
		String resultado = "";
		for (int i = 0; i < A.length; i++)
			resultado += Integer.toString(A[i]) + ((i != A.length - 1) ? " " : ""); //Solo agrego espacio si no es el último caracter
		System.out.println(resultado);
		System.out.println("Ok.");
	}
	
	@Test
	public void testGenerador(){
		Random rand = new Random();
		int[] A = new int[17000];
		for (int i = 0; i < A.length; i++)
			A[i] = rand.nextInt(10000000); //de 0 al valor que le indique
		testear(A);
	}
	
	@Test
	public void testArchivo() throws IOException //lee del in y escribe en el out
	{
        BufferedReader is = new BufferedReader( new InputStreamReader( getClass().getResourceAsStream( "Tp1Ej2.in" )));
        BufferedWriter os = new BufferedWriter( new FileWriter( getClass().getResource("").getPath() + "Tp1Ej2.out") );
        String line;
        while((line = is.readLine()) != null)
        {
        	StringTokenizer st = new StringTokenizer(line);
        	int[] r = new int[st.countTokens()];
        	int k = 0;
        	while (st.hasMoreTokens())
        	{
        		r[k] = Integer.parseInt(st.nextToken());
        		k++;
        	}
        	Amediana resultado = new Amediana();
        	r = resultado.formar(r);
        	for (int i = 0; i < r.length; i++)
        	{
        		System.out.print(Integer.toString(r[i]) + " ");
        		os.append(Integer.toString(r[i]) + ((i != r.length - 1) ? " " : ""));
        	}
        	System.out.println("");
        	os.append(System.lineSeparator());
        }
        os.close();
	}
}
