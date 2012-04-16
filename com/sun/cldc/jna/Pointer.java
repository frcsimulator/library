/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sun.cldc.jna;

import com.sun.squawk.Address;
import com.sun.squawk.realtime.OffsetOutOfBoundsException;
import com.sun.squawk.realtime.RawMemoryFloatAccess;
import com.sun.squawk.realtime.SizeOutOfBoundsException;

/**
 * Replacement for Pointer class, which probably shouldn't be used in the simulator.
 * @todo implement or determine if should be allowed at all
 * @author wolf
 */
public class Pointer extends RawMemoryFloatAccess {
	public Pointer(int size) {
            //@TODO eventually do away with pointer entirely, as of now it is quite engrained into the wpi libraries
            //throw new UnsupportedOperationException("Not implemented yet; should be replaced.");
            //stubbed because it is needed;
        }
	public Pointer(long base, int size) {
		throw new UnsupportedOperationException("Not implemented yet; should be replaced.");
	}
	public static Pointer NULL() {
		//throw new UnsupportedOperationException("Not implemented yet; should be replaced.");
            return new Pointer(0); //@TODO, should not be used, but currently required
	}
	public final Address address() {
		throw new UnsupportedOperationException("Not implemented yet; should be replaced.");
	}
	public final int getSize() {
		throw new UnsupportedOperationException("Not implemented yet; should be replaced.");
	}
	public final void free() throws IllegalStateException {
		throw new UnsupportedOperationException("Not implemented yet; should be replaced.");
	}
	public static void copyBytes(Pointer src, int srcOffset, Pointer dst, int dstOffset, int len)
			throws OffsetOutOfBoundsException, SizeOutOfBoundsException {
		throw new UnsupportedOperationException("Not implemented yet; should be replaced.");
	}
	public static Pointer createStringBuffer(String value) throws OutOfMemoryError {
		throw new UnsupportedOperationException("Not implemented yet; should be replaced.");
	}
	public final void setString(int offset, String value) {
		throw new UnsupportedOperationException("Not implemented yet; should be replaced.");
	}
}
