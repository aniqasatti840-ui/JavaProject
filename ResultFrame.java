package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ResultFrame extends JFrame {
    
   
    private int animationOffset = 0;
    private boolean directionUp = true;
    private Timer resultTimer;

    public ResultFrame(boolean won, Suspect killer) {
        setTitle("Case Closed!");
        setSize(520, 280); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        
        JPanel customAnimatedPanel = new JPanel() {
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
        customAnimatedPanel.setLayout(new GridBagLayout());
        setContentPane(customAnimatedPanel);

        
        resultTimer = new Timer(30, new ActionListener() {
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
        resultTimer.start(); 

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(12, 12, 12, 12);

        JLabel outcomeLabel = new JLabel();
        outcomeLabel.setFont(new Font("Serif", Font.BOLD, 26));
        
        JLabel detailsLabel = new JLabel();
        detailsLabel.setFont(new Font("Arial", Font.BOLD, 14)); 
        detailsLabel.setForeground(Color.WHITE); 

        
        if (won) {
            outcomeLabel.setText("CASE SOLVED!");
            outcomeLabel.setForeground(new Color(46, 204, 113)); 
            detailsLabel.setText("Excellent work, Detective! " + killer.getName() + " (" + killer.getRole() + ") was indeed the true killer.");
        } else {
            outcomeLabel.setText("GAME OVER!");
            outcomeLabel.setForeground(new Color(231, 76, 60)); 
            detailsLabel.setText("Wrong choice! The real culprit was " + killer.getName() + " (" + killer.getRole() + "), who has now escaped.");
        }

        gbc.gridx = 0; gbc.gridy = 0;
        add(outcomeLabel, gbc);

        gbc.gridx = 0; gbc.gridy = 1;
        add(detailsLabel, gbc);

       
        JButton exitBtn = new JButton("Exit Game");
        exitBtn.setFont(new Font("Arial", Font.BOLD, 14));
        exitBtn.setBackground(new Color(52, 73, 94));
        exitBtn.setForeground(Color.WHITE);
        
        exitBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resultTimer.stop(); 
                System.exit(0); 
            }
        });

        gbc.gridx = 0; gbc.gridy = 2;
        add(exitBtn, gbc);
    }
}