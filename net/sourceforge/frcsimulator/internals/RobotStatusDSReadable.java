/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.sourceforge.frcsimulator.internals;

import net.sourceforge.frcsimulator.mistware.Simulator;

/**
 *
 * @author benjamin
 */
public class RobotStatusDSReadable {
    private static String m_kStatus;
    public static void setStatus(String status){
        Simulator.msg(RobotStatusDSReadable.class, Thread.currentThread(), "Is this even necessary? There is no physical driver station and there are other ways of finding out the status.");
        m_kStatus = status;
    }
    public static String getStatus(){
        Simulator.msg(RobotStatusDSReadable.class, Thread.currentThread(), "Is this even necessary? There is no physical driver station and there are other ways of finding out the status.");
        return m_kStatus;
    }
    private RobotStatusDSReadable(){}
}
