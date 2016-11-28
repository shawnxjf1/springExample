package com.person.io;

import java.io.IOException;
import java.io.RandomAccessFile;

public interface IRandomAccessProcessor {
	
	public RandomAccessFile getRandomFile();
	
	public void process() throws IOException;
}
