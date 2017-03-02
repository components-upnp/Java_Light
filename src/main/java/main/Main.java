/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import upnp.AmpouleServer;

/**
 *
 * @author telly
 */
public class Main {
    public static void main(String[] args) {
        Thread serverThread = new Thread(new AmpouleServer());
        serverThread.setDaemon(false);
        serverThread.start();
    }
}
