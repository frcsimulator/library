/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sun.squawk;

/**
 * The Address class is used to abstract machine addresses. This should probably
 * never be used in the simulator, and throws exceptions stating so.
 * @author wolf
 */
public class Address {
	public UWord toUWord() {
		throw new UnsupportedOperationException("Calls to Address need to be replaced in the simulator!");
	}
}
