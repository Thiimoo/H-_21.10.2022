/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.htlgrieskirchen.pos3.pcp;


public class Main {
    public static void main(String[] args) {
        try {
            Executor runner = new Executor();
            
            runner.runExample();
        } catch (Exception e) {
            e.printStackTrace();
        }
        /*
            Welche Integer-Werte haben Consumer 1 bzw. 2 erhalten?
            Welche Integer-Werte wurden vom Producer produziert?
            Wie viele Integer-Werte wurden vom Storage gespeichert/geholt?
            Wie oft kam es zu einem over-/underflow des Storage?
         */
        //TODO menu implementation
    }

}
