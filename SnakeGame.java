import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.LinkedList;
import java.util.Random;

public class SnakeGame extends JPanel implements KeyListener, ActionListener {
    private final int CELL_SIZE = 20;
    private final int GRID_WIDTH = 30;
    private final int GRID_HEIGHT = 20;

    private final LinkedList<Point> snake = new LinkedList<>();
    private Point food;
    private int directionX = 1, directionY = 0;
    private int score = 0;

    private final javax.swing.Timer timer = new javax.swing.Timer(100, this);

    public SnakeGame() {
        setPreferredSize(new Dimension(GRID_WIDTH * CELL_SIZE, GRID_HEIGHT * CELL_SIZE));
        setBackground(Color.BLACK);
        setFocusable(true);
        addKeyListener(this);

        snake.add(new Point(5, 5));
        placeFood();
        timer.start();
    }

    private void placeFood() {
        Random rand = new Random();
        food = new Point(rand.nextInt(GRID_WIDTH), rand.nextInt(GRID_HEIGHT));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Draw snake
        g.setColor(Color.GREEN);
        for (Point p : snake) {
            g.fillRect(p.x * CELL_SIZE, p.y * CELL_SIZE, CELL_SIZE, CELL_SIZE);
        }

        // Draw food
        g.setColor(Color.RED);
        g.fillRect(food.x * CELL_SIZE, food.y * CELL_SIZE, CELL_SIZE, CELL_SIZE);

        // Draw score
        g.setColor(Color.WHITE);
        g.drawString("Score: " + score, 10, 20);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        move();
        repaint();
    }

    private void move() {
        Point head = snake.getLast();
        Point newHead = new Point(head.x + directionX, head.y + directionY);

        // Check collision with food
        if (newHead.equals(food)) {
            snake.add(newHead);
            score++;
            placeFood();
        } else {
            snake.add(newHead);
            snake.removeFirst();
        }

        // Collision with wall or self
        if (newHead.x < 0 || newHead.y < 0 || newHead.x >= GRID_WIDTH || newHead.y >= GRID_HEIGHT
                || snake.subList(0, snake.size() - 1).contains(newHead)) {
            timer.stop();
            JOptionPane.showMessageDialog(this, "Game Over! Final Score: " + score);
            System.exit(0);
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP -> { if (directionY == 0) { directionX = 0; directionY = -1; } }
            case KeyEvent.VK_DOWN -> { if (directionY == 0) { directionX = 0; directionY = 1; } }
            case KeyEvent.VK_LEFT -> { if (directionX == 0) { directionX = -1; directionY = 0; } }
            case KeyEvent.VK_RIGHT -> { if (directionX == 0) { directionX = 1; directionY = 0; } }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {}

    @Override
    public void keyTyped(KeyEvent e) {}

    public static void main(String[] args) {
        JFrame frame = new JFrame("🐍 Snake Game - DevOps Automation Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.add(new SnakeGame());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
