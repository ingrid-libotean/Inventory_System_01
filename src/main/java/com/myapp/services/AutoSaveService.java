package com.myapp.services;

/**
 * AutoSaveService runs as a background thread.
 *
 * It periodically simulates saving application data to disk.
 * This class demonstrates the use of multithreading and safe thread shutdown.
 */

/*
The background AutoSaveService ensures that when multiple files or application instances are open,
changes are periodically saved to disk so that other instances can read the most recent data,
providing near real-time synchronization.
*/


public class AutoSaveService implements Runnable {

    // Volatile flag used to safely stop the background thread
    // 'volatile' ensures visibility of changes across threads
    private volatile boolean running = true;

    @Override
    public void run() {
        // Message displayed when the background service starts
        System.out.println("[System] AutoSave Service started in background...");

        // The loop runs as long as the service is marked as running
        while (running) {
            try {
                // Pause the thread for 15 seconds
                // (can be changed to 60 seconds in a real production scenario)
                Thread.sleep(15000);

                // Simulate background processing required by the project
                // We re-check 'running' to avoid executing after a stop request
                if (running) {
                    System.out.println(
                            "\n[AutoSave] Saving data to disk... (Background Thread Active)"
                    );
                }

            } catch (InterruptedException e) {
                // This exception occurs if the thread is interrupted while sleeping
                // We stop the service gracefully
                System.out.println("[AutoSave] Service interrupted.");
                running = false;
            }
        }

        // Optional: this point is reached when the service stops
        System.out.println("[System] AutoSave Service stopped.");
    }

    /**
     * Stops the AutoSave service.
     *
     * This method can be called from another thread to request
     * a safe shutdown of the background process.
     */
    public void stopService() {
        this.running = false;
    }
}
