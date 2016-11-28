package com.person.io.nio.core;

import org.junit.Test;

import com.person.io.IOProcessTemplate;
import com.person.io.impl.RandomAccessFileImpl;

/**
 * FileChannel
   DatagramChannel
   SocketChannel
   ServerSocketChannel
 * @author lakala-shawn
 *
 */
public class ChannelsConcept {
	
	/**
	 */
	@Test
	public void readDataIntoChannel()
	{
		RandomAccessFileImpl randomFileProcessor = new RandomAccessFileImpl();
		//FIXME 输出有问题
		randomFileProcessor.setRandomFileName("/Users/shawn/bbs.py");
		new IOProcessTemplate().processRandomAccessFile(randomFileProcessor);
	}
}
