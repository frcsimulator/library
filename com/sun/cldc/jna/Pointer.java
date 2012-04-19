/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sun.cldc.jna;

import com.sun.squawk.Address;
import com.sun.squawk.realtime.OffsetOutOfBoundsException;
import com.sun.squawk.realtime.RawMemoryFloatAccess;
import com.sun.squawk.realtime.SizeOutOfBoundsException;
import net.sourceforge.frcsimulator.internals.CRIO;

/**
 * Replacement for Pointer class, which probably shouldn't be used in the simulator.
 * @todo implement or determine if should be allowed at all
 * @author wolf
 */
public class Pointer extends RawMemoryFloatAccess {
	public Pointer(int size) {
            if(CRIO.getInstance().isDebugging()) System.err.println("fixme:Pointer should not be used");
            //@TODO eventually do away with pointer entirely, as of now it is quite engrained into the wpi libraries
            //throw new UnsupportedOperationException("Not implemented yet; should be replaced.");
        }
	public Pointer(long base, int size) {
            if(CRIO.getInstance().isDebugging()) System.err.println("fixme:Pointer should not be used");
		//throw new UnsupportedOperationException("Not implemented yet; should be replaced.");
	}
	public static Pointer NULL() {
		//throw new UnsupportedOperationException("Not implemented yet; should be replaced.");
            if(CRIO.getInstance().isDebugging()) System.err.println("fixme:Pointer should not be used");
            return new Pointer(0); //@TODO, should not be used, but currently required
	}
	public final Address address() {
            if(CRIO.getInstance().isDebugging()) System.err.println("fixme:Pointer should not be used");
            return new Address(); //@TODO should not be used
	}
	public final int getSize() {
            if(CRIO.getInstance().isDebugging()) System.err.println("fixme:Pointer should not be used");
            return 0; //@TODO should not be used
	}
	public final void free() throws IllegalStateException {
            
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
