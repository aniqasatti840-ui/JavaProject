package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends JFrame {
    private GameManager gameManager;
    
    // Animation Attributes (Color shift logic variables)
    private int animationOffset = 0;
    private boolean directionUp = true;
    private Timer menuTimer;

    public MainMenu(GameManager gameManager) {
        this.gameManager = gameManager;

        setTitle("Main Menu - Murder Mystery");
        setSize(550, 420); // Dynamic components ke liye thoda vertical space adjust kiya hai
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // 1. Customized Animated Background Panel Pattern
        JPanel customAnimatedPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                
                // Mathematical equation to slowly morph colors smoothly
                Color upperColor = new Color(30 + animationOffset / 4, 42 + animationOffset / 3, 60 + animationOffset / 2);
                Color lowerColor = new Color(44 - animationOffset / 6, 62 - animationOffset / 5, 80);
                
                // Drawing dynamic software gradient layout
                GradientPaint runtimeGradient = new GradientPaint(0, 0, upperColor, getWidth(), getHeight(), lowerColor);
                g2d.setPaint(runtimeGradient);
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        customAnimatedPanel.setLayout(new BorderLayout(15, 15));
        setContentPane(customAnimatedPanel); // Replaced default panel with animation layer

        // 2. Setting up the Event Thread Animation loop Timer
        menuTimer = new Timer(30, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Modifying bounds to create a subtle pulsing shift effect
                if (directionUp) {
                    animationOffset += 2;
                    if (animationOffset >= 110) directionUp = false;
                } else {
                    animationOffset -= 2;
                    if (animationOffset <= 0) directionUp = true;
                }
                repaint(); // Safely repaints the gradient without breaking Swing components
            }
        });
        menuTimer.start(); // Dynamic execution starts immediately

        // 3. Top Header Panel Setup
        JPanel topPanel = new JPanel();
        topPanel.setOpaque(false); // Made transparent so animation shows underneath
        JLabel welcomeLabel = new JLabel("Welcome, Detective " + gameManager.getDetective().getName());
        welcomeLabel.setFont(new Font("Serif", Font.ITALIC, 20));
        welcomeLabel.setForeground(Color.WHITE);
        topPanel.add(welcomeLabel);
        add(topPanel, BorderLayout.NORTH);

       
        JTextArea storyArea = new JTextArea();
        storyArea.setText("\n CASE BRIEF:\n"
                + " Lord Reginald was found dead in his private study room last night at 11:00 PM.\n"
                + " The primary cause of death appears to be severe poisoning.\n"
                + " Four individuals were present in the mansion at the time of the crime.\n\n"
                + " Your objective is to interrogate them, gather key evidence, and identify the killer.\n"
                + " Be careful! A false accusation will allow the real culprit to escape.");
        storyArea.setFont(new Font("Arial", Font.PLAIN, 14));
        storyArea.setEditable(false);
        
        
        storyArea.setBackground(new Color(255, 255, 255, 225)); 
        storyArea.setForeground(Color.BLACK);
        storyArea.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
       
        JScrollPane scrollPane = new JScrollPane(storyArea);
        scrollPane.setOpaque(false);
        scrollPane.getViewport().setOpaque(false);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        add(scrollPane, BorderLayout.CENTER);

        
        JPanel bottomPanel = new JPanel();
        bottomPanel.setOpaque(false); // Made transparent
        JButton investigateButton = new JButton("Start Investigation");
        investigateButton.setFont(new Font("Arial", Font.BOLD, 16));
        investigateButton.setBackground(new Color(192, 41, 43));
        investigateButton.setForeground(Color.WHITE);
        bottomPanel.add(investigateButton);
        add(bottomPanel, BorderLayout.SOUTH);

       
        investigateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuTimer.stop(); // CRITICAL: Stop the clock before leaving to prevent memory leaks
                new InvestigationFrame(gameManager).setVisible(true);
                dispose(); // Destroys this menu window securely
            }
        });
    }
}