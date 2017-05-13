import javax.swing.*;

class spriteUpdate extends Thread{

    @Override
    public void run() {
        String[] update = window.giveStates();
        JLabel spriteLabel = window.giveLabel();
        String image1 = "/img/" + update[0] + "_" + update[1] + ".png";
        String image2 = "/img/" + update[0] + "_idle.png";
        spriteLabel.setIcon(new ImageIcon(spriteUpdate.class.getResource(image1)));
        try {Thread.sleep(1000);} catch (InterruptedException e) {e.printStackTrace();}
        spriteLabel.setIcon(new ImageIcon(spriteUpdate.class.getResource(image2)));
    }
}
