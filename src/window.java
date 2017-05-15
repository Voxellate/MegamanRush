import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;

class window {

    JLabel[] labels() {
        JLabel[] j = {playerLabel, enemyLabel, healthLabel};
        return j;
    }

    private void aKeyPressed(KeyEvent e) {

    }

    void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Lucas Dugdale
        frame = new JFrame();
        layerPane = new JLayeredPane();
        gameOverLabel = new JLabel();
        charPanel = new JPanel();
        a = new JLabel();
        b = new JLabel();
        c = new JLabel();
        d = new JLabel();
        e = new JLabel();
        f = new JLabel();
        g = new JLabel();
        h = new JLabel();
        i = new JLabel();
        j = new JLabel();
        k = new JLabel();
        l = new JLabel();
        m = new JLabel();
        n = new JLabel();
        o = new JLabel();
        p = new JLabel();
        q = new JLabel();
        r = new JLabel();
        s = new JLabel();
        t = new JLabel();
        u = new JLabel();
        v = new JLabel();
        w = new JLabel();
        x = new JLabel();
        y = new JLabel();
        z = new JLabel();
        healthLabel = new JLabel();
        playerLabel = new JLabel();
        enemyLabel = new JLabel();
        background = new JLabel();
        wordLabel = new JLabel();

        //======== frame ========
        {
            frame.setResizable(false);
            Container frameContentPane = frame.getContentPane();

            //======== layerPane ========
            {

                //---- gameOverLabel ----
                gameOverLabel.setText("GAME OVER");
                gameOverLabel.setFocusTraversalPolicyProvider(true);
                gameOverLabel.setHorizontalTextPosition(SwingConstants.CENTER);
                gameOverLabel.setHorizontalAlignment(SwingConstants.CENTER);
                gameOverLabel.setForeground(new Color(204, 204, 204));
                layerPane.add(gameOverLabel, JLayeredPane.DEFAULT_LAYER);
                gameOverLabel.setBounds(475, 170, 305, 45);

                //======== charPanel ========
                {

                    // JFormDesigner evaluation mark
                    charPanel.setBorder(new javax.swing.border.CompoundBorder(
                        new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                            "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                            javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                            java.awt.Color.red), charPanel.getBorder())); charPanel.addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});

                    charPanel.setLayout(new GridLayout(3, 0, 10, 10));

                    //---- a ----
                    a.setText("A");
                    a.setFont(new Font("MegaMan 2", Font.PLAIN, 18));
                    a.setHorizontalTextPosition(SwingConstants.CENTER);
                    a.setFocusable(false);
                    a.addKeyListener(new KeyAdapter() {
                        @Override
                        public void keyPressed(KeyEvent e) {
                            aKeyPressed(e);
                        }
                    });
                    charPanel.add(a);

                    //---- b ----
                    b.setText("B");
                    b.setFont(new Font("MegaMan 2", Font.PLAIN, 18));
                    b.setHorizontalTextPosition(SwingConstants.CENTER);
                    charPanel.add(b);

                    //---- c ----
                    c.setText("C");
                    c.setFont(new Font("MegaMan 2", Font.PLAIN, 18));
                    c.setHorizontalTextPosition(SwingConstants.CENTER);
                    charPanel.add(c);

                    //---- d ----
                    d.setText("D");
                    d.setFont(new Font("MegaMan 2", Font.PLAIN, 18));
                    d.setHorizontalTextPosition(SwingConstants.CENTER);
                    charPanel.add(d);

                    //---- e ----
                    e.setText("E");
                    e.setFont(new Font("MegaMan 2", Font.PLAIN, 18));
                    e.setHorizontalTextPosition(SwingConstants.CENTER);
                    charPanel.add(e);

                    //---- f ----
                    f.setText("F");
                    f.setFont(new Font("MegaMan 2", Font.PLAIN, 18));
                    f.setHorizontalTextPosition(SwingConstants.CENTER);
                    charPanel.add(f);

                    //---- g ----
                    g.setText("G");
                    g.setFont(new Font("MegaMan 2", Font.PLAIN, 18));
                    g.setHorizontalTextPosition(SwingConstants.CENTER);
                    charPanel.add(g);

                    //---- h ----
                    h.setText("H");
                    h.setFont(new Font("MegaMan 2", Font.PLAIN, 18));
                    h.setHorizontalTextPosition(SwingConstants.CENTER);
                    charPanel.add(h);

                    //---- i ----
                    i.setText("I");
                    i.setFont(new Font("MegaMan 2", Font.PLAIN, 18));
                    i.setHorizontalTextPosition(SwingConstants.CENTER);
                    charPanel.add(i);

                    //---- j ----
                    j.setText("J");
                    j.setFont(new Font("MegaMan 2", Font.PLAIN, 18));
                    j.setHorizontalTextPosition(SwingConstants.CENTER);
                    charPanel.add(j);

                    //---- k ----
                    k.setText("K");
                    k.setFont(new Font("MegaMan 2", Font.PLAIN, 18));
                    k.setHorizontalTextPosition(SwingConstants.CENTER);
                    charPanel.add(k);

                    //---- l ----
                    l.setText("L");
                    l.setFont(new Font("MegaMan 2", Font.PLAIN, 18));
                    l.setHorizontalTextPosition(SwingConstants.CENTER);
                    charPanel.add(l);

                    //---- m ----
                    m.setText("M");
                    m.setFont(new Font("MegaMan 2", Font.PLAIN, 18));
                    m.setHorizontalTextPosition(SwingConstants.CENTER);
                    charPanel.add(m);

                    //---- n ----
                    n.setText("N");
                    n.setFont(new Font("MegaMan 2", Font.PLAIN, 18));
                    n.setHorizontalTextPosition(SwingConstants.CENTER);
                    charPanel.add(n);

                    //---- o ----
                    o.setText("O");
                    o.setFont(new Font("MegaMan 2", Font.PLAIN, 18));
                    o.setHorizontalTextPosition(SwingConstants.CENTER);
                    charPanel.add(o);

                    //---- p ----
                    p.setText("P");
                    p.setFont(new Font("MegaMan 2", Font.PLAIN, 18));
                    p.setHorizontalTextPosition(SwingConstants.CENTER);
                    charPanel.add(p);

                    //---- q ----
                    q.setText("Q");
                    q.setFont(new Font("MegaMan 2", Font.PLAIN, 18));
                    q.setHorizontalTextPosition(SwingConstants.CENTER);
                    charPanel.add(q);

                    //---- r ----
                    r.setText("R");
                    r.setFont(new Font("MegaMan 2", Font.PLAIN, 18));
                    r.setHorizontalTextPosition(SwingConstants.CENTER);
                    charPanel.add(r);

                    //---- s ----
                    s.setText("S");
                    s.setFont(new Font("MegaMan 2", Font.PLAIN, 18));
                    s.setHorizontalTextPosition(SwingConstants.CENTER);
                    charPanel.add(s);

                    //---- t ----
                    t.setText("T");
                    t.setFont(new Font("MegaMan 2", Font.PLAIN, 18));
                    t.setHorizontalTextPosition(SwingConstants.CENTER);
                    charPanel.add(t);

                    //---- u ----
                    u.setText("U");
                    u.setFont(new Font("MegaMan 2", Font.PLAIN, 18));
                    u.setHorizontalTextPosition(SwingConstants.CENTER);
                    charPanel.add(u);

                    //---- v ----
                    v.setText("V");
                    v.setFont(new Font("MegaMan 2", Font.PLAIN, 18));
                    v.setHorizontalTextPosition(SwingConstants.CENTER);
                    charPanel.add(v);

                    //---- w ----
                    w.setText("W");
                    w.setFont(new Font("MegaMan 2", Font.PLAIN, 18));
                    w.setHorizontalTextPosition(SwingConstants.CENTER);
                    charPanel.add(w);

                    //---- x ----
                    x.setText("X");
                    x.setFont(new Font("MegaMan 2", Font.PLAIN, 18));
                    x.setHorizontalTextPosition(SwingConstants.CENTER);
                    charPanel.add(x);

                    //---- y ----
                    y.setText("Y");
                    y.setFont(new Font("MegaMan 2", Font.PLAIN, 18));
                    y.setHorizontalTextPosition(SwingConstants.CENTER);
                    charPanel.add(y);

                    //---- z ----
                    z.setText("Z");
                    z.setFont(new Font("MegaMan 2", Font.PLAIN, 18));
                    z.setHorizontalTextPosition(SwingConstants.CENTER);
                    charPanel.add(z);
                }
                layerPane.add(charPanel, JLayeredPane.DEFAULT_LAYER);
                charPanel.setBounds(10, 555, 435, 95);

                //---- healthLabel ----
                healthLabel.setIcon(new ImageIcon(getClass().getResource("/img/health_10.png")));
                layerPane.add(healthLabel, JLayeredPane.DEFAULT_LAYER);
                healthLabel.setBounds(20, 20, 56, 200);

                //---- playerLabel ----
                playerLabel.setIcon(new ImageIcon(getClass().getResource("/img/player_idle.png")));
                playerLabel.setHorizontalAlignment(SwingConstants.CENTER);
                layerPane.add(playerLabel, JLayeredPane.DEFAULT_LAYER);
                playerLabel.setBounds(275, 300, 108, 112);

                //---- enemyLabel ----
                enemyLabel.setIcon(new ImageIcon(getClass().getResource("/img/enemy_idle.png")));
                enemyLabel.setHorizontalAlignment(SwingConstants.CENTER);
                layerPane.add(enemyLabel, JLayeredPane.DEFAULT_LAYER);
                enemyLabel.setBounds(800, 320, 84, 92);

                //---- background ----
                background.setIcon(new ImageIcon(getClass().getResource("/img/background.png")));
                layerPane.add(background, JLayeredPane.DEFAULT_LAYER);
                background.setBounds(0, 0, 1260, 550);

                //---- wordLabel ----
                wordLabel.setFont(new Font("MegaMan 2", Font.PLAIN, 20));
                wordLabel.setHorizontalAlignment(SwingConstants.CENTER);
                layerPane.add(wordLabel, JLayeredPane.DEFAULT_LAYER);
                wordLabel.setBounds(570, 585, 675, 31);
            }

            GroupLayout frameContentPaneLayout = new GroupLayout(frameContentPane);
            frameContentPane.setLayout(frameContentPaneLayout);
            frameContentPaneLayout.setHorizontalGroup(
                frameContentPaneLayout.createParallelGroup()
                    .addComponent(layerPane, GroupLayout.DEFAULT_SIZE, 1573, Short.MAX_VALUE)
            );
            frameContentPaneLayout.setVerticalGroup(
                frameContentPaneLayout.createParallelGroup()
                    .addComponent(layerPane, GroupLayout.DEFAULT_SIZE, 823, Short.MAX_VALUE)
            );
            frame.setSize(1260, 690);
            frame.setLocationRelativeTo(frame.getOwner());
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }



    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Lucas Dugdale
    private JFrame frame;
    private JLayeredPane layerPane;
    private JLabel gameOverLabel;
    private JPanel charPanel;
    private JLabel a;
    private JLabel b;
    private JLabel c;
    private JLabel d;
    private JLabel e;
    private JLabel f;
    private JLabel g;
    private JLabel h;
    private JLabel i;
    private JLabel j;
    private JLabel k;
    private JLabel l;
    private JLabel m;
    private JLabel n;
    private JLabel o;
    private JLabel p;
    private JLabel q;
    private JLabel r;
    private JLabel s;
    private JLabel t;
    private JLabel u;
    private JLabel v;
    private JLabel w;
    private JLabel x;
    private JLabel y;
    private JLabel z;
    private JLabel healthLabel;
    private JLabel playerLabel;
    private JLabel enemyLabel;
    private JLabel background;
    private JLabel wordLabel;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
