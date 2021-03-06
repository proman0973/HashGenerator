package de.aeschool.hashgenerator;

import de.aeschool.hashgenerator.log.ConsoleLogger;
import de.aeschool.hashgenerator.log.Log;
import de.aeschool.hashgenerator.log.UILogger;
import de.aeschool.hashgenerator.ui.MainWindow;

import javax.swing.*;
import java.awt.*;
import java.lang.management.ManagementFactory;

public class HashGenerator {
    public static void main(String[] args) {
        // Output logging to console
        Log.registerLogger(new ConsoleLogger());
        Log.registerLogger(new UILogger());

        // Check if in debug mode
        if (ManagementFactory.getRuntimeMXBean().getInputArguments().toString().contains("jdwp")) {
            Log.enableDebugging();
        }

        Log.d("Starting application");

        // Set look and feel
        try {
            Log.d("Setting system default look and feel...");
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            Log.e("Setting look and feel failed... Continuing with default");
        }

        // Start application
        EventQueue.invokeLater(() -> {
            MainWindow window = new MainWindow("HashGenerator");
            window.setVisible(true);
        });
    }
}
