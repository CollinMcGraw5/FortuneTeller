import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class FortuneTellerFrame extends JFrame {
    private JTextArea fortuneArea;
    private ArrayList<String> fortunes;
    private int lastIndex = -1;

    public FortuneTellerFrame() {
        setTitle("Fortune Teller");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Fonts
        Font titleFont = new Font("Serif", Font.BOLD, 48);
        Font fortuneFont = new Font("SansSerif", Font.PLAIN, 18);
        Font buttonFont = new Font("Dialog", Font.BOLD, 20);

        // Top Panel
        ImageIcon originalIcon = new ImageIcon("resources/fortune_teller.png");
        Image scaledImage = originalIcon.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
        ImageIcon icon = new ImageIcon(scaledImage);
        JLabel titleLabel = new JLabel("Fortune Teller", icon, JLabel.CENTER);
        titleLabel.setVerticalTextPosition(JLabel.TOP);
        titleLabel.setHorizontalTextPosition(JLabel.CENTER);
        titleLabel.setFont(titleFont);
        JPanel topPanel = new JPanel();
        topPanel.add(titleLabel);
        add(topPanel, BorderLayout.NORTH);

        // Middle Panel
        fortuneArea = new JTextArea(10, 40);
        fortuneArea.setFont(fortuneFont);
        fortuneArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(fortuneArea);
        add(scrollPane, BorderLayout.CENTER);

        // Bottom Panel
        JButton readButton = new JButton("Read My Fortune!");
        JButton quitButton = new JButton("Quit");
        readButton.setFont(buttonFont);
        quitButton.setFont(buttonFont);

        JPanel bottomPanel = new JPanel();
        bottomPanel.add(readButton);
        bottomPanel.add(quitButton);
        add(bottomPanel, BorderLayout.SOUTH);

        // Fortunes
        fortunes = new ArrayList<>();
        fortunes.add("You will find a cookie with no fortune.");
        fortunes.add("Your pet is plotting against you.");
        fortunes.add("You will soon discover your socks are mismatched.");
        fortunes.add("Beware of pigeons with agendas.");
        fortunes.add("You will dream of tacos tonight.");
        fortunes.add("Your keyboard knows your secrets.");
        fortunes.add("You will win a staring contest with your reflection.");
        fortunes.add("Your coffee will taste suspiciously like tea.");
        fortunes.add("You will invent a new dance move by accident.");
        fortunes.add("Your fortune is under construction.");
        fortunes.add("You will laugh at a joke you don’t understand.");
        fortunes.add("You will meet someone who also dislikes Mondays.");

        // Button Actions
        readButton.addActionListener(e -> {
            int index;
            do {
                index = new Random().nextInt(fortunes.size());
            } while (index == lastIndex);
            lastIndex = index;
            fortuneArea.append(fortunes.get(index) + "\n");
        });

        quitButton.addActionListener(e -> System.exit(0));

        // Frame Sizing
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        int width = (int) (screenSize.width * 0.75);
        int height = (int) (screenSize.height * 0.75);
        setSize(width, height);
        setLocationRelativeTo(null);
    }
}