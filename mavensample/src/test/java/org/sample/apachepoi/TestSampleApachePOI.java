package org.sample.apachepoi;

import java.io.IOException;
import java.util.ArrayList;

import org.testng.annotations.Test;

public class TestSampleApachePOI {

	
		public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		ExcelDataApachePOI fetchData = new ExcelDataApachePOI();

		ArrayList<String> data = fetchData.getData("Add Profile");
		System.out.println(data);

	}

}
