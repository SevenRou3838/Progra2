import java.awt.Dimension;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.event.*;

public class MyCanvas extends JPanel implements KeyListener,ActionListener{
    Point pSun = new Point(Config.WINDOW_W/2, Config.WINDOW_H/2);  
    public MyCanvas () {
        setPreferredSize(new Dimension(Config.WINDOW_W,Config.WINDOW_H));
        setBackground(Config.COLOR_BG);
    }
    @Override //Siempre va existir este metodo 
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        Paintbrush paintBrush = new Paintbrush(g);
        paintBrush.drawSky();
        

        paintBrush.drawMountains(15,120,100,40,180,120);
        paintBrush.drawMountains(180,120,250,40,350,120);
        paintBrush.drawMountains(100,120,175,40,250,100);
        paintBrush.drawMountains(200,175,350,50,400,175);
        paintBrush.drawTree(200,50);
        paintBrush.drawTree(100,20);
        paintBrush.drawTree(300,40);
        paintBrush.drawTree(50,110);

        paintBrush.drawSun(pSun);
        paintBrush.drawCar(250,100);
        


    }

    @Override 
    public void keyPressed(KeyEvent event){

        int key = event.getKeyCode(); 
        if(key == KeyEvent.VK_UP){
            pSun.setY(pSun.getY()-Config.SUN_STEP);
        }

        if(key == KeyEvent.VK_DOWN){
            pSun.setY(pSun.getY()+Config.SUN_STEP);
        }

        if(key == KeyEvent.VK_RIGHT){
            pSun.setX(pSun.getX()+Config.SUN_STEP);
        }

        if(key == KeyEvent.VK_LEFT){
            pSun.setX(pSun.getX()-Config.SUN_STEP);
        }

        repaint();

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        
    }
    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }
    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }
}

