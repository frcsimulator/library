/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sun.cldc.jna;

/**
 * Replacement for native library wrappers which throws exceptions indicating
 * they need to be replaced.
 * @author wolf
 */
public class NativeLibrary {
	public static NativeLibrary getDefaultInstance() {
		throw new UnsupportedOperationException("Calls to NativeLibrary need to be replaced in the simulator!");
	}
	public Function getFunction(String funcName) {
		throw new UnsupportedOperationException("Calls to NativeLibrary need to be replaced in the simulator!");
	}
	public BlockingFunction getBlockingFunction(String funcName) {
		throw new UnsupportedOperationException("Calls to NativeLibrary need to be replaced in the simulator!");
	}
}
