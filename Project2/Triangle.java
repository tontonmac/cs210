import javax.swing.*;
import java.awt.*;

/**
 * @author Bob Wilson
 * @version 1.0, 12/20/2009
 * 
 * Triangle class for fractal pattern generation
 */

public class Triangle
{
  // indices for sub-triangles
  public static final int CORNER_ONE = 0;
  public static final int CORNER_TWO = 1;
  public static final int CORNER_THREE = 2;
  public static final int EDGE_ONE = 3;
  public static final int EDGE_TWO = 4;
  public static final int EDGE_THREE = 5;
  
  // smallest perimeter for triangle to be drawn
  public static final int SMALLEST = 30;
  
  private Corner x;
  private Corner y;
  private Corner z;
  
  public Triangle(Corner x, Corner y, Corner z)
  {
    this.x = x;
    this.y = y;
    this.z = z;
  }
  
  public void draw(Graphics screen)
  {
    screen.drawLine(x.w, x.d, y.w, y.d);
    screen.drawLine(y.w, y.d, z.w, z.d);
    screen.drawLine(z.w, z.d, x.w, x.d);
  }
  
  public int size()
  {
    // write your code here
    //calculates the size of the triangle and returns the int value.
    int xy = (int) Math.sqrt(Math.pow((x.w - y.w), 2) 
                               + Math.pow((x.d - y.d), 2));
    
    int yz = (int) Math.sqrt(Math.pow((y.w - z.w), 2) 
                               + Math.pow((y.d - z.d), 2));
    
    int xz = (int) Math.sqrt(Math.pow((x.w - z.w), 2) 
                               + Math.pow((x.d - z.d), 2));
    
    return xy + yz+ xz;
  }
  
    /*calculates the corners of a  selected (index) lower level triangle
   *  and returns it as a Triangle object
   */
  public Triangle getNextLevel(int index)
  {
    Triangle t = null;
    // write your code here
    /*calculate the three new corners using the midpoints 
   * of the edges of the current triangle
   */
    if(index == CORNER_ONE)
    { 
      Corner c1 = x.mid(z).mid(z);
      Corner c2 = y.mid(z).mid(z);
      Corner c3 = x.mid(z).mid(y.mid(z)); 
      t = new Triangle(c1, c2, c3);
    }
    else
      if(index == CORNER_TWO)
    {
      Corner d1 = x.mid(z).mid(x);
      Corner d2 = x.mid(z).mid(x.mid(y));
      Corner d3 = x.mid(y).mid(x); 
      t = new Triangle(d1, d2, d3);
    }
    else
      if(index == CORNER_THREE)
    {
      
      Corner e1 = x.mid(y).mid(y.mid(z));
      Corner e2 = y.mid(z).mid(y);
      Corner e3 = x.mid(y).mid(y);
      t = new Triangle(e1, e2, e3);
    }
    else
      if(index == EDGE_ONE)
    {
      
      Corner f1 = x.mid(z);
      Corner f2 = x.mid(z).mid(y.mid(z));
      Corner f3 = x.mid(z).mid(x.mid(y));
      t = new Triangle(f1, f2, f3);
    }
    else
      if(index == EDGE_TWO)
    {
      
      Corner g1 = x.mid(z).mid(y.mid(z));
      Corner g2 = y.mid(z);
      Corner g3 = x.mid(y).mid(y.mid(z)); 
      t = new Triangle(g1, g2, g3);
    }
    else
      if(index == EDGE_THREE)
    {
      
      Corner h1 = x.mid(z).mid(x.mid(y));
      Corner h2 = x.mid(y).mid(y.mid(z));
      Corner h3 = x.mid(y);
      t = new Triangle(h1, h2, h3);
    }
    
    return t;
  }
}
