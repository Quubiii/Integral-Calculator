import javax.swing.*;
import java.awt.*;
import org.scilab.forge.jlatexmath.TeXFormula;
import org.scilab.forge.jlatexmath.TeXIcon;

public class GUI extends JPanel {
    private static final int WIDTH = 1000;
    private static final int HEIGHT = 700;

    public GUI() {
        // JFrame
        JFrame frame = new JFrame("Integral Calculator");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(WIDTH, HEIGHT);
        frame.setLayout(new BorderLayout());
        frame.setLocationRelativeTo(null);

        // Main panel
        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(Color.LIGHT_GRAY); // Example background color
        mainPanel.setLayout(new FlowLayout()); // Example layout manager

        // Side panel
        JPanel sidePanel = new JPanel();
        JLabel functionLabel = new JLabel("Function: ");
        functionLabel.setForeground(Color.WHITE);
        functionLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
        JTextField functionText = new JTextField();
        sidePanel.setBackground(Color.DARK_GRAY);
        sidePanel.setLayout(new BoxLayout(sidePanel, BoxLayout.Y_AXIS));
        sidePanel.add(functionLabel);
        sidePanel.add(functionText);

        // Frame execution
        frame.add(mainPanel, BorderLayout.CENTER);
        frame.add(sidePanel, BorderLayout.WEST);

        // Frame visible
        frame.setVisible(true);
    }
}
