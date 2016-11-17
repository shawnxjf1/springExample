package com.person.io.nio.core;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

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
	 * FIXME 想用 template 来操作
	 */
	public void readDataIntoChannel()
	{
		RandomAccessFile aFile = new RandomAccessFile("data/nio-data.txt", "rw");
	    FileChannel inChannel = aFile.getChannel();

	    ByteBuffer buf = ByteBuffer.allocate(48);

	    int bytesRead = inChannel.read(buf);
	    while (bytesRead != -1) {
	      System.out.println("Read " + bytesRead);
	      buf.flip();
	      while(buf.hasRemaining()){
	          System.out.print((char) buf.get());
	      }
	      buf.clear();
	      bytesRead = inChannel.read(buf);
	    }
	    aFile.close();
	}
}
