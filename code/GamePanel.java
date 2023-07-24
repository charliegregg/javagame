package code;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable {
    
    final int TILE_SIZE = 8;
    final int SCALE = 6;
    final int SCREEN_TILE_SIZE = TILE_SIZE * SCALE;

    final int WIDTH_IN_TILES = 16;
    final int HEIGHT_IN_TILES = 12;
    final int SCREEN_WIDTH = WIDTH_IN_TILES * SCREEN_TILE_SIZE;
    final int SCREEN_HEIGHT = HEIGHT_IN_TILES * SCREEN_TILE_SIZE;

    final int FPS = 60;
    final long NANO_PER_SEC = 1000000000;
    final int NANO_PER_MILLI = 1000000;

    KeyHandler keyH = new KeyHandler();
    Thread gameThread;
    GameManager manager;


    public GamePanel()  {
        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);

        this.addKeyListener(keyH);
        this.setFocusable(true);

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
            this.update();
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
    public void update() {
        if (keyH.is(KeyEvent.VK_W)) {
            y -= 4;
        }
        if (keyH.is(KeyEvent.VK_S)) {
            y += 4;
        }
        if (keyH.is(KeyEvent.VK_A)) {
            x -= 4;
        }
        if (keyH.is(KeyEvent.VK_D)) {
            x += 4;
        }
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        g2.setColor(Color.WHITE);
        g2.fillRect(x, y, SCREEN_TILE_SIZE, SCREEN_TILE_SIZE);
        g2.dispose();
        
    }
}
