/**
 * Huffman Node class implements a node in a Huffman coding tree
 * @author Bob Wilson
 * @version January 19, 2010
 */

public class HuffmanNode implements Comparable<HuffmanNode>
{
  private char value;
  private int frequency;
  private HuffmanNode zero;
  private HuffmanNode one;
  
  public HuffmanNode(char value, int frequency, HuffmanNode zero, HuffmanNode one)
  {
    this.value = value;
    this.frequency = frequency;
    this.zero = zero;
    this.one = one;
  }
  
  public int compareTo(HuffmanNode that)
  {
    return this.frequency - that.frequency;
  }
  
  public String toString()
  {
    return "{Character: " + value + ", Frequency: " + frequency + ", Zero: " + zero + ", One: " + one + "}";
  }
  
  public char getValue()
  {
    return value;
  }
  
  public int getFrequency()
  {
    return frequency;
  }
  
  /**
   * Increments the frequency count
   */
  public void increment() {
    frequency++;
  }
  
  public HuffmanNode getZero()
  {
    return zero;
  }
  
  public HuffmanNode getOne()
  {
    return one;
  }
}