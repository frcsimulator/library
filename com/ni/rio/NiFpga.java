/**
   \file       NiRioEntryPoints.h
   \author     Erik Hons <erik.hons@ni.com>
   \date       12/14/2004

   \brief Declarations for RIO services client DLL entry points

   Intended to be called from a C client, or the LabVIEW
   interface.

   � Copyright 2004. National Instruments. All rights reserved.
*/

package com.ni.rio;

import com.sun.cldc.jna.*;
import com.sun.cldc.jna.ptr.IntByReference;
import net.sourceforge.frcsimulator.internals.CRIO;
import net.sourceforge.frcsimulator.mistware.Simulator;

/**
 * The Nifpga class provides access to the FPGA on the cRIO. This is a wrapper around the accessors
 * in Nifpga.h
 */
public class NiFpga implements NiRioConstants
{
   // ---------------------------
   // Fifo Operations:

	private static final class configFifoFn {
            public static int call3(int arg0, int arg1, int arg2){
                Simulator.fixme(NiFpga.class, Thread.currentThread(), "configFifoFn stubbed");
                return 0; //@TODO actually get working
            }
        }

    /**
     * Specifies the depth of the host memory part of the DMA FifO. This method is
     * optional. In order to see the actual depth configured, use
     * Nifpga_ConfigureFifo2.
     *
     * @param hClient handle to a currently open session
     * @param channel FifO to configure
     * @param fifoDepthInElements requested number of elements in the host memory part of the
     *              DMA FifO
     * @param status result of the call
     */
    public static void configureFifo(int hClient, int channel, int fifoDepthInElements, NiRioStatus status)
   {
      mergeStatus(status,
                  configFifoFn.call3(hClient, channel, fifoDepthInElements));
	}

	private static final class startFifoFn {
            public static int call2(int arg0, int arg1){
                Simulator.fixme(NiFpga.class, Thread.currentThread(), "startFifoFn stubbed");
                return 0; //@TODO actually get working
            }
        }
    
    /**
     * Starts a FifO. This method is optional.
     *
     * @param hClient handle to a currently open session
     * @param channel FifO to start
     * @param status result of the call
     */
    public static void startFifo(int hClient, int channel, NiRioStatus status)
   {
      mergeStatus(status,
                  startFifoFn.call2(hClient, channel));
	}

	private static final class stopFifoFn {
            public static int call2(int arg0, int arg1){
                Simulator.fixme(NiFpga.class, Thread.currentThread(), "stopFifoFn stubbed");
                return 0; // @TODO actually get working
            }
        }

    /**
     * Stops a FifO. This method is optional.
     *
     * @param hClient handle to a currently open session
     * @param channel FifO to start
     * @param status result of the call
     */
    public static void stopFifo(int hClient, int channel, NiRioStatus status)
   {
      mergeStatus(status,
                  stopFifoFn.call2(hClient, channel));
	}

	private static final class readFifoU32Fn {
            public static int call6(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5){
                Simulator.fixme(NiFpga.class, Thread.currentThread(), "readFifoU32Fn stubbed");
                return 0;//@TODO actually get working
            }
        }

    /**
     * Reads from a target-to-host FifO of unsigned 32-bit integers.
     *
     * @param hClient handle to a currently open session
     * @param channel target-to-host FifO from which to read
     * @param buf outputs the data that was read
     * @param num number of elements to read
     * @param timeout timeout in milliseconds, or Nifpga_InfiniteTimeout
     * @param remaining outputs the number of elements
     *                          remaining in the host memory part of the DMA FifO
     * @param status result of the call
     */
    public static void readFifoU32(int hClient, int channel, Pointer buf, int num, int timeout, IntByReference remaining, NiRioStatus status)
   {
      mergeStatus(status,
                  readFifoU32Fn.call6(hClient,
                                      channel,
                                      buf.address().toUWord().toPrimitive(),
                                      num,
                                      timeout,
                                      remaining.getPointer().address().toUWord().toPrimitive()));
	}


   // ---------------------------
   // I/O:
    
    /**
     * Conditionally sets the status to a new value. The previous status is
     * preserved unless the new status is more of an error, which means that
     * warnings and errors overwrite successes, and errors overwrite warnings. New
     * errors do not overwrite older errors, and new warnings do not overwrite
     * older warnings.
     *
     * @param status status to conditionally set
     * @param newStatus int value new status value that may be set
     */
    static void mergeStatus(NiRioStatus statusA, int statusB) {
        statusA.setStatus(statusB);
    }

	private static final class writeU32Fn {
            public static int call3(int arg0, int arg1, int arg2){
                if(CRIO.getInstance().isDebugging()) System.err.println("fixme:writeU32Fn stubbed");
                return 0;//@TODO actually get working
            }
        }

    /**
     * Writes an unsigned 32-bit integer value to a given control or indicator.
     *
     * @param hClient handle to a currently open session
     * @param offset control or indicator to which to write
     * @param value value to write
     * @param status result of the call
     */
    public static void writeU32(int hClient, int offset, int value, NiRioStatus status)
   {
//      System.out.print("write offset = 0x");
//      System.out.println(Long.toString(offset, 16));
//      System.out.print("value = 0x");
//      System.out.println(Long.toString(((long)value) & 0xFFFFFFFFL, 16));
      mergeStatus(status, writeU32Fn.call3(hClient, offset, value));
	}

    private static IntByReference readValue = new IntByReference(0);
    
    private static final class readU32Fn {
        public static int call3(int arg0, int arg1, int arg2){
            if(CRIO.getInstance().isDebugging()) System.err.println("fixme:readU32Fn stubbed");
            return 0;//@TODO actually get working
        }
    }

    /**
     * Reads an unsigned 32-bit integer value from a given offset
     *
     * @param hClient handle to a currently open session
     * @param offset indicator or control from which to read
     * @param status result of the call 
     * @return outputs the value that was read
     */
    public static synchronized int readU32(int hClient, int offset, NiRioStatus status) {
//      System.out.print("read offset = 0x");
//      System.out.println(Long.toString(offset, 16));
        mergeStatus(status,
                readU32Fn.call3(hClient, offset, 0/*readValue.getPointer()*/));
//      System.out.print("value = 0x");
//      System.out.println(Long.toString(((long)value) & 0xFFFFFFFFL, 16));
        return readValue.getValue();
    }

   // ---------------------------
   // IRQs:

	private static final class reserveIrqContextFn {
            public static int call2(int arg0, int arg1){
                System.out.println("fixme:reserveIrqContextFn stubbed");
                return 0; //@TODO actually get working
            }
        }

    /**
     * IRQ contexts are single-threaded; only one thread can wait with a particular
     * context at any given time. Clients must reserve as many contexts as the
     * application requires.
     *
     * if a context is successfully reserved (the returned status is not an error),
     * it must be unreserved later. Otherwise a memory leak will occur.
     *
     * @param hClient handle to a currently open session
     * @param context outputs the IRQ context
     * @param NiRioStatus result of the call
     */
    public static void reserveIrqContext(int hClient, IntByReference context, NiRioStatus status)
   {
       mergeStatus(status,
                  reserveIrqContextFn.call2(hClient, context.getPointer().address().toUWord().toPrimitive()));
	}

    private static final class unreserveIrqContextFn {
        public static int call2(int arg0, int arg1){
            if(CRIO.getInstance().isDebugging()) System.err.println("fixme:unreserveIrqContextFn stubbed");
            return 0;//@TODO actually get working
        }
    }
    /**
     * Unreserves an IRQ context obtained from reserveIrqContext.
     *
     * @param session handle to a currently open session
     * @param context IRQ context to unreserve
     * @return result of the call
     */
    public static void unreserveIrqContext(int hClient, IntByReference context, NiRioStatus status)
   {
      mergeStatus(status,
                  unreserveIrqContextFn.call2(hClient, context.getValue()));
	}

   private static IntByReference irqsAsserted = new IntByReference(0);

   private static final class waitOnIrqsFn {
       public static int call6(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5){
           if(CRIO.getInstance().isDebugging()) System.err.println("fixme:waitOnIrqsFn stubbed");
           return 0;//@TODO actually get working
       }
   }

    /**
     * This is a blocking function that stops the calling thread until the FPGA
     * asserts any IRQ in the irqs parameter, or until the function call times out.
     * Before calling this function, you must use Nifpga_ReserveIrqContext to
     * reserve an IRQ context. No other threads can use the same context when this
     * function is called.
     *
     * You can use the irqsAsserted parameter to determine which IRQs were asserted
     * for each function call.
     * 
     * @todo if this really blocks, then waitOnIrqsFn should probably be a BlockingFunction
     *
     * @param hClient handle to a currently open session
     * @param context IRQ context with which to wait
     * @param irqs bitwise OR of Nifpga_Irqs
     * @param timeout timeout in milliseconds, or Nifpga_InfiniteTimeout
     * @param irqsAsserted if non-NULL, outputs bitwise OR of IRQs that were
     *                     asserted
     * @param timedOut if non-NULL, outputs whether the timeout expired
     * @return bitwise OR of IRQs that were asserted
     */
    public static synchronized int waitOnIrqs(int hClient, IntByReference context, int irqs, int timeout, NiRioStatus status) {
        irqsAsserted.setValue(0);
        mergeStatus(status,
                waitOnIrqsFn.call6(hClient, context.getValue(), irqs, timeout, 0/*irqsAsserted.getPointer().address().toUWord().toPrimitive()*/, 0));
        return irqsAsserted.getValue();
    }

    private NiFpga() {
    }

}
