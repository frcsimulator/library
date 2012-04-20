/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.communication;

import com.sun.cldc.jna.Pointer;
import net.sourceforge.frcsimulator.internals.UnsimulatedOperationException;

/**
 *
 * @author wolf
 */
abstract class InternalSemaphore {
	public final Pointer getPointer() {
		throw new UnsimulatedOperationException("Don't use pointers in the simulator (in Semaphore)");
	}
	public abstract void flush() throws SemaphoreException;
	public abstract void give() throws SemaphoreException;
	public abstract void takeMillis(int timeout) throws SemaphoreException;
	public void takeForever() throws SemaphoreException {
		takeMillis(Semaphore.WAIT_FOREVER);
	}
	public abstract boolean tryTake() throws SemaphoreException;
	public abstract void close() throws SemaphoreException;
	public abstract void free() throws SemaphoreException;
}
