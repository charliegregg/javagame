package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashSet;
import java.util.Set;

public class KeyHandler implements KeyListener {

    private Set<String> keys = new HashSet<>();

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        String keyText = KeyEvent.getKeyText(e.getKeyCode());
        keys.add(keyText);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        String keyText = KeyEvent.getKeyText(e.getKeyCode());
        keys.remove(keyText);
    }

    public boolean is(String keyText) {
        return keys.contains(keyText);
    }
}
