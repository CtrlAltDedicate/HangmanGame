import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame {
    private Hangman hangman;
    private JLabel wordLabel;
    private JLabel attemptsLabel;
    private User currentUser;

    public GameFrame(User user) {
        this.currentUser = user;
        this.hangman = new Hangman(WordFetcher.fetchWord());

        setTitle("Hangman Game");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        wordLabel = new JLabel(hangman.getGuess(), SwingConstants.CENTER);
        wordLabel.setFont(new Font("Arial", Font.BOLD, 24));
        add(wordLabel, BorderLayout.NORTH);

        attemptsLabel = new JLabel("Wrong guesses: 0", SwingConstants.CENTER);
        add(attemptsLabel, BorderLayout.SOUTH);

        JPanel lettersPanel = new JPanel(new GridLayout(3, 9));
        for (char c = 'a'; c <= 'z'; c++) {
            JButton btn = new JButton(String.valueOf(c));
            btn.addActionListener(e -> {
                btn.setEnabled(false);
                playTurn(c);
            });
            lettersPanel.add(btn);
        }

        add(lettersPanel, BorderLayout.CENTER);
        setVisible(true);
    }

    private void playTurn(char c) {
        boolean correct = hangman.makeGuess(c);
        wordLabel.setText(hangman.getGuess());
        attemptsLabel.setText("Wrong guesses: " + hangman.getWrongGuesses());

        if (hangman.isComplete()) {
            currentUser.setScore(currentUser.getScore() + 10);
// No update needed, score is stored in memory
            JOptionPane.showMessageDialog(this, "You win! Score: " + currentUser.getScore());
            new LoginFrame();
            dispose();
        } else if (hangman.isGameOver()) {
            JOptionPane.showMessageDialog(this, "You lost! Word was: " + hangman.getWord());
            new LoginFrame();
            dispose();
        }
    }
}
