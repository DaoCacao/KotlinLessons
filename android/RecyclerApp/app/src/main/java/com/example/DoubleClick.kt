package com.example

import android.os.Handler
import android.view.View

class DoubleClick(doubleClickListener: DoubleClickListener, DOUBLE_CLICK_INTERVAL: Long) : View.OnClickListener {
    /*
   * Duration of click interval.
   * 200 milliseconds is a best fit to double click interval.
   */
    private var DOUBLE_CLICK_INTERVAL: Long

    /*
   * Handler to process click event.
   */
    private val mHandler = Handler()

    /*
   * Click callback.
   */
    private val doubleClickListener: DoubleClickListener

    /*
   * Number of clicks in @DOUBLE_CLICK_INTERVAL interval.
   */
    private var clicks = 0

    /*
   * Flag to check if click handler is busy.
   */
    private var isBusy = false

    /**
     * Builds a DoubleClick.
     *
     * @param doubleClickListener the click listener to notify clicks.
     */
    constructor(doubleClickListener: DoubleClickListener) : this(doubleClickListener, 200L) {
        DOUBLE_CLICK_INTERVAL = 200L // default time to wait the second click.
    }

    init {
        this.doubleClickListener = doubleClickListener
        this.DOUBLE_CLICK_INTERVAL = DOUBLE_CLICK_INTERVAL // developer specified time to wait the second click.
    }

    override fun onClick(view: View) {
        if (!isBusy) {
            //  Prevent multiple click in this short time
            isBusy = true

            // Increase clicks count
            clicks++
            mHandler.postDelayed({
                if (clicks >= 2) {  // Double tap.
                    doubleClickListener.onDoubleClick(view)
                }
                if (clicks == 1) {  // Single tap
                    doubleClickListener.onSingleClick(view)
                }

                // we need to  restore clicks count
                clicks = 0
            }, DOUBLE_CLICK_INTERVAL)
            isBusy = false
        }
    }
}

interface DoubleClickListener {
    fun onSingleClick(view: View?)
    fun onDoubleClick(view: View?)
}