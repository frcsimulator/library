/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sun.squawk.realtime;

/**
 *
 * @author wolf
 */
class RawMemoryAccess {
	public byte getByte(long offset) {
		throw new UnsupportedOperationException("RawMemoryAccess should not be called in the simulator!");
	}
	public void getBytes(long offset, byte[] bytes, int low, int number) {
		throw new UnsupportedOperationException("RawMemoryAccess should not be called in the simulator!");
	}
	public void setByte(long offset, byte value) {
		throw new UnsupportedOperationException("RawMemoryAccess should not be called in the simulator!");
	}
	public void setBytes(long offset, byte[] bytes, int low, int number) {
		throw new UnsupportedOperationException("RawMemoryAccess should not be called in the simulator!");
	}
	public int getInt(long offset) {
		throw new UnsupportedOperationException("RawMemoryAccess should not be called in the simulator!");
	}
	public void setInt(long offset,  int value) {
		throw new UnsupportedOperationException("RawMemoryAccess should not be called in the simulator!");
	}
	public short getShort(long offset) {
		throw new UnsupportedOperationException("RawMemoryAccess should not be called in the simulator!");
	}
	public void getShorts(long offset, short[] shorts, int low, int number) {
		throw new UnsupportedOperationException("RawMemoryAccess should not be called in the simulator!");
	}
	public void setShort(long offset, short value) {
		throw new UnsupportedOperationException("RawMemoryAccess should not be called in the simulator!");
	}
	public void setShorts(long offset, short[] shorts, int low, int number) {
		throw new UnsupportedOperationException("RawMemoryAccess should not be called in the simulator!");
	}
}
