package ru.stqa.pft.mantis.appmanager;

import org.apache.commons.net.telnet.TelnetClient;

import javax.mail.Session;
import javax.mail.Store;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

public class JamesHelper {
    private final ApplicationManager app;
    private final TelnetClient telnet;
    private final Session mailSession;
    private InputStream in;
    private PrintStream out;
    private Store store;
    private String mailserver;

    public JamesHelper(ApplicationManager app) {
        this.app = app;
        telnet = new TelnetClient();
        mailSession = Session.getDefaultInstance(System.getProperties());
    }

    public void createUser(String name, String password) {
        initTelnetSession();
//        write("adduser " + name + " " + password);
//        String result = readUntil("User " + name + " added");
//        closeTelnetSession();
    }

    private void initTelnetSession() {
        mailserver = app.getProperty("mailserver.host");
        int port = Integer.parseInt(app.getProperty("mailserver.port"));
        String login = app.getProperty("mailserver.adminLogin");
        String password = app.getProperty("mailserver.adminPassword");

        try {
            telnet.connect(mailserver, 9999);
            in = telnet.getInputStream();
            out = new PrintStream(telnet.getOutputStream());
        } catch (Exception e) {
            e.printStackTrace();
        }

        readUntil("Login id:");
    }

    private String readUntil(String pattern) {
        try {
            char lastChar = pattern.charAt(pattern.length() - 1);
            StringBuilder sb = new StringBuilder();
            char ch = (char) in.read();
            while (true) {
                System.out.print("ch");
                sb.append(ch);
                if (ch == lastChar) {
                    if (sb.toString().endsWith(pattern)) {
                        return sb.toString();
                    }
                }
                ch = (char) in.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


}
