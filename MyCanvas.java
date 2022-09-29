import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;
import java.awt.Graphics;

//genramos una nueva clase y hereda las caracteristicas de panel
public class MyCanvas extends JPanel {
        public MyCanvas (){
            setPreferredSize(new Dimension(400,300));
            setBackground(Color.GRAY);
    }
    @Override
protected void paintComponent(Graphics g){
    super.paintComponent(g);
    Paintbrush paintbrush = new Paintbrush(g);
    paintbrush.drawSky();
    paintbrush.drawMountains();
    paintbrush.drawTree();
}


}

