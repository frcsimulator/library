/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.sourceforge.frcsimulator.internals;

/**
 *
 * @author wolf
 */
public class FrcBotSimProperty<T> {
	public boolean setByCode, physical;
	protected T value;

	public FrcBotSimProperty() {

	}
	public FrcBotSimProperty(T defaultValue) {
		value=defaultValue;
	}

	public T get() {
		return value;
	}
	public void set(T to) {
		value=to;
	}
}
