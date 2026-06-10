package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Loginframe extends JFrame {
    private JTextField nameField;
    private JButton startButton;
    
   
    private int animationOffset = 0;
    private boolean directionUp = true;
    private Timer dynamicTimer;

    public Loginframe() {
        setTitle("Murder Mystery Detective Game - Login");
        setSize(450, 260);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
       
        JPanel customAnimatedContentPane = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                
               
                Color upperColor = new Color(30 + animationOffset / 4, 42 + animationOffset / 3, 60 + animationOffset / 2);
                Color lowerColor = new Color(44 - animationOffset / 6, 62 - animationOffset / 5, 80);
                
                
                GradientPaint runtimeGradient = new GradientPaint(0, 0, upperColor, getWidth(), getHeight(), lowerColor);
                g2d.setPaint(runtimeGradient);
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        customAnimatedContentPane.setLayout(new BorderLayout(10, 10));
        setContentPane(customAnimatedContentPane); 

        
        dynamicTimer = new Timer(30, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                if (directionUp) {
                    animationOffset += 2;
                    if (animationOffset >= 110) directionUp = false;
                } else {
                    animationOffset -= 2;
                    if (animationOffset <= 0) directionUp = true;
                }
                repaint(); 
            }
        });
        dynamicTimer.start(); 

        
        JPanel headerPanel = new JPanel();
        headerPanel.setOpaque(false); 
        JLabel titleLabel = new JLabel("CRIME SCENE INVESTIGATION");
        titleLabel.setFont(new Font("Serif", Font.BOLD, 22));
        titleLabel.setForeground(Color.WHITE);
        headerPanel.add(titleLabel);
        add(headerPanel, BorderLayout.NORTH);

        
        JPanel centerPanel = new JPanel(new GridBagLayout());
        centerPanel.setOpaque(false); 
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);

        JLabel promptLabel = new JLabel("Enter Detective Name:");
        promptLabel.setFont(new Font("Arial", Font.BOLD, 14)); 
        promptLabel.setForeground(Color.WHITE); 
        gbc.gridx = 0; gbc.gridy = 0;
        centerPanel.add(promptLabel, gbc);

        nameField = new JTextField(15);
        nameField.setFont(new Font("Arial", Font.PLAIN, 14));
        gbc.gridx = 1; gbc.gridy = 0;
        centerPanel.add(nameField, gbc);

        startButton = new JButton("Enter Crime Scene");
        startButton.setFont(new Font("Arial", Font.BOLD, 14));
        startButton.setBackground(new Color(39, 174, 96));
        startButton.setForeground(Color.WHITE);
        gbc.gridx = 0; gbc.gridy = 1; gbc.gridwidth = 2;
        centerPanel.add(startButton, gbc);

        add(centerPanel, BorderLayout.CENTER);

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText().trim();
                if (name.isEmpty()) {
                    JOptionPane.showMessageDialog(Loginframe.this, 
                        "Please enter your name, Detective!", 
                        "Error", 
                        JOptionPane.WARNING_MESSAGE);
                } else {
                    dynamicTimer.stop(); 
                    
                    GameManager gameManager = new GameManager(name);
                    new MainMenu(gameManager).setVisible(true);
                    dispose(); 
                }
            }
        });
    }
}