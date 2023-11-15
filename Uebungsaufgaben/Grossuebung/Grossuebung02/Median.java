package Grossuebung02;

import java.util.Arrays;

public class Median {

	public static void main(String[] args) {
		double[] test1a = new double[] {};
		double[] test1b = new double[] { 1 };
		double[] test1c = new double[] { 1, 3, 5, 6, 8 };
		double[] test1d = new double[] { 1, 3, 5, 6, 8, 9};
		double[][] test2a = new double[][] {};
		double[][] test2b = new double[][] { { 1 } };
		double[][] test2c = new double[][] { { 1, 2, 3 }, { 4, 5 } };
		double[][] test2d = new double[][] { { 1, 2, 3 }, { }, { 4, 5, 6 }, { 7 } };
		
		System.out.println(median(test1a)); // 0.0
		System.out.println(median(test1b)); // 1.0
		System.out.println(median(test1c)); // 5.0
		System.out.println(median(test1d)); // 5.5
		
		System.out.println("--------");
		
		System.out.println(medianOfMedians(test2a)); // 0.0
		System.out.println(medianOfMedians(test2b)); // 1.0
		System.out.println(medianOfMedians(test2c)); // 3.25
		System.out.println(medianOfMedians(test2d)); // 3.5

		System.out.println("--------");
		
		System.out.println(median2Dim(test2a)); // 0.0
		System.out.println(median2Dim(test2b)); // 1.0
		System.out.println(median2Dim(test2c)); // 3.0
		System.out.println(median2Dim(test2d)); // 4.0
	}
	
	public static double median(double[] values) {
        //check if the array is empty
        if (values.length == 0) {
            return 0;
        } 

        //if the number is odd then is this the median
        double median = values[values.length / 2];

        //if the array is even we need to calculate the average between the two numbers in the middle
        if (values.length % 2 == 0) {
            median += values[values.length / 2 - 1];
            median /= 2.0;
        }
		return median;
	}
	
	public static double medianOfMedians(double[][] values) {
        double[] medians = new double[values.length];

        //going through the array and assigning the median of the rows to a different array
        for (int i =  0; i < values.length; i++) {
            medians[i] = median(values[i]);
        }
        Arrays.sort(medians);
        
		return median(medians);
	}

	public static double median2Dim(double[][] values) {
        int counter = 0;
        for (int i = 0; i < values.length; i++) {
            counter += values.length;
        }
        double[] median = new double[counter];
        for (int i = 0; i < values.length; i++) {
            for (int j = 0; j < values.length; j++) {
                median[i] = values[i][j];
            }
        }
		return median(median);
	}

}