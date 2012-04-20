/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.communication;

import com.sun.cldc.jna.Pointer;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sourceforge.frcsimulator.internals.UnimplementedOperationException;
import net.sourceforge.frcsimulator.internals.UnsimulatedOperationException;

/**
 *
 * @author wolf
 */
public class Semaphore extends InternalSemaphore {
	public static final int WAIT_FOREVER = -1;
	static final int SEM_Q_FIFO                = 0x00; /* first in first out queue */
    static final int SEM_Q_PRIORITY            = 0x01; /* priority sorted queue */
    static final int SEM_DELETE_SAFE           = 0x04; /* owner delete safe (mutex opt.) */
    static final int SEM_INVERSION_SAFE        = 0x08; /* no priority inversion (mutex opt.) */
    static final int SEM_EVENTSEND_ERR_NOTIFY  = 0x10; /* notify when eventRsrcSend fails */
    static final int SEM_INTERRUPTIBLE         = 0x20; /* interruptible on RTP signal */

	private Options options;
	private InternalSemaphore m_semaphore;
	/**
     * Create a new semaphore.
     * @param options The options to create the semaphore with.
     */
    public Semaphore (Options options) {
		// TODO what to do with options?
		m_semaphore = new BooleanSemaphore();
    }

    /**
     * Create a semaphore with the given initial state.
     * @param options The options to create the semaphore with.
     * @param initialState The initial state for the semaphore to have.
     */
    public Semaphore (Options options, boolean initialState) {
		throw new UnimplementedOperationException("Mutex semaphore not implemented yet.");
	}

    /**
     * Create a counting semaphore with the given value.
     * @param options The options to create the semaphore with.
     * @param count The initial count for the semaphore to hold.
     */
    public Semaphore (Options options, int count) {
		throw new UnimplementedOperationException("Counting semaphore not implemented yet.");
    }

	@Override
	public void flush() throws SemaphoreException {
		m_semaphore.flush();
	}

	@Override
	public void give() throws SemaphoreException {
		m_semaphore.give();
	}

	@Override
	public void takeMillis(int timeout) throws SemaphoreException {
		m_semaphore.takeMillis(timeout);
	}

	@Override
	public boolean tryTake() throws SemaphoreException {
		return m_semaphore.tryTake();
	}

	@Override
	public void close() throws SemaphoreException {
		m_semaphore.close();
	}

	@Override
	public void free() throws SemaphoreException {
		m_semaphore.free();
	}

	private class BooleanSemaphore extends InternalSemaphore {
		java.util.concurrent.Semaphore semaphore;
		@Override
		public void flush() throws SemaphoreException {
			// TODO How do you flush a semaphore? Put it in the toilet?
			throw new UnsupportedOperationException("Not supported yet.");
		}
		@Override
		public void give() throws SemaphoreException {
			semaphore.release();
		}
		@Override
		public void takeMillis(int timeout) throws SemaphoreException {
			try {
				if (!semaphore.tryAcquire(timeout, TimeUnit.MILLISECONDS)){ // Acquire failed
					// TODO is this the correct error code?
					throw new SemaphoreException(SemaphoreException.S_objLib_OBJ_TIMEOUT);
				}
			} catch (InterruptedException ex) {
				// TODO what should happen on interrupt??
				throw new SemaphoreException(SemaphoreException.S_objLib_OBJ_ID_ERROR);
			}
		}
		@Override
		public void takeForever() throws SemaphoreException {
			semaphore.acquireUninterruptibly();
		}
		@Override
		public boolean tryTake() throws SemaphoreException {
			return semaphore.tryAcquire();
		}
		@Override
		public void close() throws SemaphoreException {
			// TODO how on earth do you close a semaphore?
			throw new UnsupportedOperationException("Not supported yet.");
		}
		@Override
		public void free() throws SemaphoreException {
			// TODO And how are you supposed to free one?
			throw new UnsupportedOperationException("Not supported yet.");
		}
	}
	/**
     * Options to create a semaphore with.
     */
    public static class Options {
        int value = 0;
        /**
         * Set true to use a priority sorted queue, false to use first-in first-out
         * @param priority
         */
        public void setPrioritySorted(boolean priority) {
            if (priority) value |= SEM_Q_PRIORITY;
            else value &= ~SEM_Q_PRIORITY;
        }
        /**
         * Set whether or not the semaphore is delete safe.
         * @param delSafe True to make the semaphore delete safe.
         */
        public void setDeleteSafe(boolean delSafe) {
            if (delSafe) value |= SEM_DELETE_SAFE;
            else value &= ~SEM_DELETE_SAFE;
        }
        /**
         * Set whether the semaphore is inversion safe.
         * @param invSafe True to set the semaphore to inversion safe.
         */
        public void setInversionSafe(boolean invSafe) {
            if (invSafe) value |= SEM_INVERSION_SAFE;
            else value &= ~SEM_INVERSION_SAFE;
        }
        /**
         * Set whether the semaphore should notify on an error.
         * @param errNot True to set error notify.
         */
        public void setErrorNotify(boolean errNot) {
            if (errNot) value |= SEM_EVENTSEND_ERR_NOTIFY;
            else value &= ~SEM_EVENTSEND_ERR_NOTIFY;
        }
        /**
         * Set whether the semaphore is interruptable.
         * @param intable True allows this semaphore to be interrupted.
         */
        public void setInterruptable(boolean intable) {
            if (intable) value |= SEM_INTERRUPTIBLE;
            else value &= ~SEM_INTERRUPTIBLE;
        }
    }
}
