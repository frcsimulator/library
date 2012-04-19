/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sun.cldc.jna;

import net.sourceforge.frcsimulator.internals.CRIO;

/**
 * Replacement for native library wrappers which throws exceptions indicating
 * they need to be replaced.
 * @author wolf
 */
public class NativeLibrary {
	public static NativeLibrary getDefaultInstance() {
		if(CRIO.getInstance().isDebugging()) System.err.println("fixme:NativeLibrary should not be used");
                return new NativeLibrary();//@TODO should not be used
	}
	public Function getFunction(String funcName) {
            if(CRIO.getInstance().isDebugging()) System.err.println("fixme:NativeLibrary should not be used");
		return new Function();//@TODO should not be used
	}
	public BlockingFunction getBlockingFunction(String funcName) {
            if(CRIO.getInstance().isDebugging()) System.err.println("fixme:NativeLibrary should not be used");
		return new BlockingFunction();//@TODO should not be used
	}
}
