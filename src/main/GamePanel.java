package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable {
    
    final static public int TILE_SIZE = 8;
    final static public int SCALE = 6;
    final static public int SCREEN_TILE_SIZE = TILE_SIZE * SCALE;

    final static public int WIDTH_IN_TILES = 16;
    final static public int HEIGHT_IN_TILES = 12;
    final static public int SCREEN_WIDTH = WIDTH_IN_TILES * SCREEN_TILE_SIZE;
    final static public int SCREEN_HEIGHT = HEIGHT_IN_TILES * SCREEN_TILE_SIZE;

    final static public int FPS = 60;
    final static public long NANO_PER_SEC = 1000000000;
    final static public int NANO_PER_MILLI = 1000000;

    final static public KeyHandler keyH = new KeyHandler();
    Thread gameThread;
    GameManager manager;


    public GamePanel()  {
        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);

        this.addKeyListener(keyH);
        this.setFocusable(true);

        manager = new GameManager(keyH);

    }
    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        long drawInterval = NANO_PER_SEC/FPS;
        long lastTime = System.nanoTime();
        while (gameThread != null) {
            manager.update();
            this.repaint();
            long currentTime = System.nanoTime();
            long remainingTime = drawInterval - (currentTime - lastTime);
            lastTime = currentTime;
            if (remainingTime < 0) {
                remainingTime = 0;
            }
            long remainingMillis = remainingTime / NANO_PER_MILLI;
            int remainingNanos = (int) remainingTime % NANO_PER_MILLI;
            try {
                Thread.sleep(remainingMillis, remainingNanos);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;
        manager.render(g2);
        g2.dispose();
    }
}
