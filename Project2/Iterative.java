import javax.swing.*;
import java.awt.*;
import java.util.*;

/**
 * @author Bob Wilson
 * @version 1.0, 12/20/2009
 * 
 * Applet with fractal pattern repetition using 
 * iterative drawing of triangles within triangles
 */

public class Iterative extends JApplet
{
  public void paint(Graphics screen)
  {
    screen.clearRect(0, 0, this.getWidth(), this.getHeight());
    screen.drawString(" Iterative Version", 0 , 10);
    Corner x = new Corner(0, this.getHeight());
    Corner y = new Corner(this.getWidth(), this.getHeight());
    Corner z = new Corner(this.getWidth() / 2, 0);
    
    drawTriangle(screen, new Triangle(x, y, z));  
  }
  
  /** 
   * iterative version of drawing
   * Note: It can work with either stack or queue for saving triangles
   * in five places in the code below: comment/uncomment one or the other ***
   * The only difference is in the order that sub-triangles are drawn.
   */
  
  private void drawTriangle(Graphics screen, Triangle t)
  {
    // add your code here
    //instantiate the stack that you need to save the Triangle at each level
    Stack<Triangle> stack = new Stack<Triangle>();
    
    stack.push(t); // push the initial triangle received as a parameter onto the stack
    
    while(!stack.isEmpty()) //Iterater while the stack is not empty
    {
      t = stack.pop(); // pop the next triangle off the stack
      
      t.draw(getGraphics()); //draw it
      
      if(t.size()>Triangle.SMALLEST) //push all the six lower lever triangle on the stack
      {
        stack.push(t.getNextLevel(Triangle.CORNER_ONE));
        stack.push(t.getNextLevel(Triangle.CORNER_TWO));
        stack.push(t.getNextLevel(Triangle.CORNER_THREE));
        stack.push(t.getNextLevel(Triangle.EDGE_ONE));
        stack.push(t.getNextLevel(Triangle.EDGE_TWO));
        stack.push(t.getNextLevel(Triangle.EDGE_THREE));    
      } 
    }
    /* // Iteration using queue
   
  //Instantiate the queue that you need to save the triangle at each level
  Queue<Triangle> q = new LinkedList<Triangle>();
  
  q.offer(t); //offer or push the initial triangle received as a parameter onto the queue
  
  while(!q.isEmpty()) //Iterate while the queue is not empty
  {
   t = q.poll(); // remove the next triangle off the queue

  t.draw(getGraphics()); //draw it

  if(t.size() > Triangle.SMALLEST) //offer or push all the six lower level triangle on the queue
  q.offer(t.getNextLevel(Triangle.CORNER_ONE));
   q.offer(t.getNextLevel(Triangle.CORNER_TWO));
   q.offer(t.getNextLevel(Triangle.CORNER_THREE));
   q.offer(t.getNextLevel(Triangle.EDGE_ONE));
   q.offer(t.getNextLevel(Triangle.EDGE_TWO));
   q.offer(t.getNextLevel(Triangle.EDGE_THREE));
  }*/
  }
}
    
