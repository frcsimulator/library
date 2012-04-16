/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sun.cldc.jna;

/**
 * Superclass of types representing native pointers. This should never be used
 * in the simulator.
 * @author wolf
 */
public class PointerType {
	public Pointer getPointer() {
		throw new UnsupportedOperationException("Calls to Pointers should not be used in the simulator.");
	}
}
