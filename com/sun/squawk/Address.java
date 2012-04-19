/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sun.squawk;

import net.sourceforge.frcsimulator.internals.CRIO;

/**
 * The Address class is used to abstract machine addresses. This should probably
 * never be used in the simulator, and throws exceptions stating so.
 * @author wolf
 */
public class Address {
    public Address(){
		if(CRIO.getInstance().isDebugging()) System.err.println("fixme:Address should not be used");
    }
	public UWord toUWord() {
		if(CRIO.getInstance().isDebugging()) System.err.println("fixme:Address should not be used");
                return new UWord();
	}
}
