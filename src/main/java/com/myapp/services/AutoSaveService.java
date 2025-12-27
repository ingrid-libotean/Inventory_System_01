package com.myapp.services;

public class AutoSaveService implements Runnable {
    // Variabilă volatilă pentru a putea opri thread-ul în siguranță
    private volatile boolean running = true;

    @Override
    public void run() {
        System.out.println("[System] AutoSave Service started in background...");

        while (running) {
            try {
                // Thread-ul "doarme" 60 de secunde (sau 15 secunde pentru testare rapidă)
                Thread.sleep(15000);

                // Aici simulăm procesarea în background cerută de proiect
                if (running) {
                    System.out.println("\n[AutoSave] Saving data to disk... (Background Thread Active)");
                }

            } catch (InterruptedException e) {
                System.out.println("[AutoSave] Service interrupted.");
                running = false;
            }
        }
    }

    public void stopService() {
        this.running = false;
    }
}