package com.person.io.impl;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

import com.person.io.IRandomAccessProcessor;

public class RandomAccessFileImpl implements IRandomAccessProcessor {

	String randomFileName;
	RandomAccessFile randomFile;

	public void setRandomFileName(String randomFileName) {
		this.randomFileName = randomFileName;
	}

	public RandomAccessFile getRandomFile() {
		return this.randomFile;
	}

	@Override
	public void process() throws IOException {
	    this.randomFile  = new RandomAccessFile(this.randomFileName, "rw");
		FileChannel inChannel = randomFile.getChannel();
		ByteBuffer buf = ByteBuffer.allocate(48);

		while (inChannel.read(buf) != -1) {
			buf.flip();
				System.out.print((char) buf.get());
		}
		buf.clear();
	    inChannel.read(buf);
	}
}
