package com.myapp.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/export")
@CrossOrigin(origins = "*")
public class ExportController {

    // Requirement #3: Use threads to accelerate processing
    @PostMapping("/start")
    public String startExport() {
        // Creăm un fir de execuție nou (Thread) explicit
        Thread exportThread = new Thread(() -> {
            try {
                System.out.println("--- [Thread-ul Secundar] Începe exportul datelor... ---");

                // Simulam o operațiune grea (durează 5 secunde)
                Thread.sleep(5000);

                System.out.println("--- [Thread-ul Secundar] Export finalizat! Fisier salvat. ---");
                // Aici am putea genera un PDF sau trimite un email
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        // Pornim thread-ul
        exportThread.start();

        // Serverul returneaza raspunsul IMEDIAT, nu așteaptă cele 5 secunde
        return "Export started in background! Check server console.";
    }
}