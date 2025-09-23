import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * A very simple GUI (graphical user interface) for the clock display.
 * In this implementation, time runs at about 3 minutes per second, so that
 * testing the display is a little quicker.
 * 
 * @author Michael Kölling and David J. Barnes
 * @version 2016.02.29
 */

 
public class Clock
{
    private JFrame frame;
    private JLabel timeLabel;
    private JLabel dateLabel;
    private Timer timer;
    
    /**
     * Constructor for objects of class Clock
     */
    public Clock()
    {
        makeFrame();
        startClock();
    }
    
    
    /**
     * 'About' function: show the 'about' box.
     */
    private void showAbout()
    {
        JOptionPane.showMessageDialog (frame, 
                    "Clock Version 1.0\n" +
                    "A simple interface for the 'Objects First' clock display project",
                    "About Clock", 
                    JOptionPane.INFORMATION_MESSAGE);
    }
    
    /**
     * Quit function: quit the application.
     */
    private void quit()
    {
        System.exit(0);
    }

    
    /**
     * Create the Swing frame and its content.
     */
    private void makeFrame()
    {
        frame = new JFrame("Clock");
        JPanel contentPane = (JPanel)frame.getContentPane();
        contentPane.setBorder(new EmptyBorder(1, 60, 1, 60));

        makeMenuBar(frame);
        
        // Specify the layout manager with nice spacing
        contentPane.setLayout(new BorderLayout(12, 12));
        
        // Create the image pane in the center
        timeLabel = new JLabel("00:00:00", SwingConstants.CENTER);
        Font timeFont = timeLabel.getFont().deriveFont(96.0f);
        timeLabel.setFont(timeFont);
        contentPane.add(timeLabel, BorderLayout.CENTER);

        // Date label (lebih kecil di bawah jam)
        dateLabel = new JLabel("Loading...", SwingConstants.CENTER);
        Font dateFont = dateLabel.getFont().deriveFont(24.0f);
        dateLabel.setFont(dateFont);
        contentPane.add(dateLabel, BorderLayout.SOUTH);

        
        // building is done - arrange the components      
        frame.pack();
        
        // place the frame at the center of the screen and show
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation(d.width/2 - frame.getWidth()/2, d.height/2 - frame.getHeight()/2);
        frame.setVisible(true);
    }
    private void startClock() {
    timer = new Timer(1000, e -> updateTime());
    timer.start();
}

private void updateTime() {
    LocalDateTime now = LocalDateTime.now();

    // format jam
    DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("HH:mm:ss");
    timeLabel.setText(now.format(timeFormat));

    // format tanggal
    DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("EEEE, dd MMMM yyyy");
    dateLabel.setText(now.format(dateFormat));
}
    
    /**
     * Create the main frame's menu bar.
     * 
     * @param frame   The frame that the menu bar should be added to.
     */
    private void makeMenuBar(JFrame frame)
    {
        final int SHORTCUT_MASK =
            Toolkit.getDefaultToolkit().getMenuShortcutKeyMask();

        JMenuBar menubar = new JMenuBar();
        frame.setJMenuBar(menubar);
        
        JMenu menu;
        JMenuItem item;
        
        // create the File menu
        menu = new JMenu("File");
        menubar.add(menu);
        
        item = new JMenuItem("About Clock...");
            item.addActionListener(e -> showAbout());
        menu.add(item);

        menu.addSeparator();
        
        item = new JMenuItem("Quit");
            item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, SHORTCUT_MASK));
            item.addActionListener(e -> quit());
        menu.add(item);
    }
    

    public static void main(String[] args)
    {
        new Clock();
    }
}

