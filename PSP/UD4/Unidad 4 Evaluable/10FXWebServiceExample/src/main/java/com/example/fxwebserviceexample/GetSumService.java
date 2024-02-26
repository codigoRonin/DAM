package com.example.fxwebserviceexample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import javafx.concurrent.Service;
import javafx.concurrent.Task;

public class GetSumService extends Service<Integer> {
	int n1, n2;
	
	public GetSumService(int n1, int n2) {
		super();
		this.n1 = n1;
		this.n2 = n2;
	}
	
	@Override
	protected Task<Integer> createTask() {
		return new Task<Integer>() {
			@Override
			protected Integer call() throws Exception {
				BufferedReader bufInput = null;
				Integer result = 0;
				try {
					URL sumURL = new URL("http://localhost/services/sum/" + n1 + "/" + n2);
					URLConnection conn = sumURL.openConnection();
					
					bufInput = new BufferedReader(
							new InputStreamReader(conn.getInputStream()));
					result = Integer.parseInt(bufInput.readLine());
					
				} catch (IOException e) {} finally {
					if(bufInput != null) {
						try {
							bufInput.close();
						} catch (IOException e) {}
					}
				}
				
				Thread.sleep(5000); // simulate a 5 seconds delay!
				return result;
			}
		};
	}
	
}
