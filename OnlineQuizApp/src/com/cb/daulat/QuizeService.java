package com.cb.daulat;

public interface QuizeService {
	public void addQuestion(Question q);
	
	public void start();
	
	public void showResult();
	
	public String getRemarks(double percentage);
	
	
	
	
}
