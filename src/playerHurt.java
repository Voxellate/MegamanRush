import javax.swing.*;

class playerHurt extends Thread{

    @Override
    public void run() {
        JLabel playerLabel = window.giveLabel();
        System.out.println("Click!");
        playerLabel.setIcon(new ImageIcon(playerHurt.class.getResource("/img/MM_Hurt.png")));
        System.out.println("Back!");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        playerLabel.setIcon(new ImageIcon(playerHurt.class.getResource("/img/MM_Idle.png")));
    }
}
