import java.awt.*;

public class Cell extends Rectangle{
    
    private static int sizeRect = 80;
    private int col;
    private int row;
    private int value = 0;
    private boolean pending = false;
    private Color colour = new Color(255, 255, 224);

    public Cell(){
        super(0,0,0,0);
        this.col = 0;
        this.row = 0;
    }

    public Cell(int col, int row, int x, int y){
        super(x,y, sizeRect, sizeRect);
        this.col = col;
        this.row = row;
    }

    public int getCol() {
        return this.col;
    }

    public int getRow() {
        return this.row;
    }

    public void setColor(Color color) {
        this.colour = color;
    }

    public int getSizeRect() {
        return this.sizeRect;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    public boolean getState() {
        return this.pending;
    }

    public void setPending(boolean state) {
        this.pending = state;
    }

    void paint(Graphics g, Point mouseLoc) {
        if(contains(mouseLoc)) {
            g.setColor(Color.LIGHT_GRAY);
        } else if (value == 0 || pending) {
            g.setColor(this.colour);
        } else {
            g.setColor(Color.WHITE);
        }
        g.fillRect(x, y, sizeRect, sizeRect);
        g.setColor(Color.BLACK);
        g.drawRect(x, y, sizeRect, sizeRect);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 30));
        if (value != 0) {
            g.drawString(String.valueOf(value), x+35, y+50);
        }
    }

    public boolean contains(Point p){
        if (p != null){
            return super.contains(p);
        } else {
            return false;
        }
    }
}
