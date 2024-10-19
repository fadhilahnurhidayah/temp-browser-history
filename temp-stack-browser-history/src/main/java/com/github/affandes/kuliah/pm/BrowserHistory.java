package com.github.affandes.kuliah.pm;

import java.util.ArrayList;
import java.util.Scanner;

public class BrowserHistory{
    private ArrayList<String> history; // Menyimpan history browser

    public BrowserHistory() {
        history = new ArrayList<>();
    }

    public void view() {
        if (history.isEmpty()) {
            System.out.println("History kosong.");
        } else {
            System.out.println("History browser (dari yang paling baru):");
            for (int i = history.size() - 1; i >= 0; i--) {
                System.out.println((history.size() - i) + ". " + history.get(i));
            }
        }
    }

    public void browse(String website) {
        history.add(website);
        System.out.println("Website \"" + website + "\" telah ditambahkan ke history.");
    }

    public void back() {
        if (!history.isEmpty()) {
            String lastWebsite = history.remove(history.size() - 1);
            System.out.println("Kembali dari website \"" + lastWebsite + "\".");
        } else {
            System.out.println("Tidak ada history untuk kembali.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BrowserHistory simulator = new BrowserHistory();
        String command;

        System.out.println("Selamat datang di Simulator History Browser!");
        System.out.println("Perintah: view, browse <website>, back, exit");

        while (true) {
            System.out.print("Masukkan perintah: ");
            command = scanner.nextLine().trim();

            if (command.equalsIgnoreCase("view")) {
                simulator.view();
            } else if (command.startsWith("browse ")) {
                String website = command.substring(7); // Mengambil nama website
                simulator.browse(website);
            } else if (command.equalsIgnoreCase("back")) {
                simulator.back();
            } else if (command.equalsIgnoreCase("exit")) {
                System.out.println("Keluar dari simulator.");
                break;
            } else {
                System.out.println("Perintah tidak dikenali. Coba lagi.");
            }
        }

        scanner.close();
    }
}

