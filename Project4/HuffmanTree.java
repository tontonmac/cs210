/**
 * Huffman coding tree implementation
 * the main method is a test case
 * @author Bob Wilson
 * @version January 19, 2010
 */

import java.util.*;
import java.util.Map.Entry;
import java.util.jar.Attributes.Name;

@SuppressWarnings("unused")
public class HuffmanTree
{
  private HashMap<Character, String> encodeTable;
  private HashMap<String, Character> decodeTable;
  private double compressionRatio;
  
  public HuffmanTree(String message)
  {
    // Build a map of characters to their frequencies in the message text
    // Create a HuffmanNode for each character to eventually build tree
    
    HashMap<Character,HuffmanNode> map = new HashMap<Character,HuffmanNode>();  //create a HashMap
    
    String s = message;
    
    for(int i = 0; i < s.length(); i++)
    {
      char c = s.charAt(i);
      
      HuffmanNode v = map.get(c); //get the value of each character
      
      if(map.containsKey(c))
      {
        v.increment(); //increment the frequency if the character is found
      }
      else
      { 
        HuffmanNode x = new HuffmanNode(c, 1, null, null);
        map.put(c, x); //add the new character to the map
      }
    }
    // Create a PriorityQueue to "sort" the HuffmanNode objects.
    // Iterate over a set of Map.Entry objects from the frequency
    
    PriorityQueue<HuffmanNode> q = new PriorityQueue<HuffmanNode>();
    
    for(Map.Entry<Character, HuffmanNode> x : map.entrySet())
    {
      // map and put each HuffManNode object into the priority queue
      q.add(x.getValue());
    }
    // Combine the two lowest frequency nodes until there is only one node left
    // The last node left in the queue will be the root of the Huffman code tree
    while(q.size() > 1)
    {
      HuffmanNode r = q.poll(); //remove the first element on the queue
      HuffmanNode l = q.poll(); //remove the second element on the queue
      
      int f1 = r.getFrequency(); //get the frequency of the first element
      int f2 = l.getFrequency();//get the frequency of the second element
      int f3 = f1 + f2; //sum of the frequency
      
      HuffmanNode node = new HuffmanNode('*', f3, r, l); //create a new huffman node with those element
      
      q.add(node); //add that node to the queue
    }
    // Build HashMaps for the encode and decode tables
    encodeTable  = new HashMap<Character, String>(); //create the table for encoded characters
    decodeTable = new HashMap<String, Character>(); //create the table for decoded characters
    
    buildTables(q.poll(), ""); //build table using the elements in the queue
  }
  
  // recursive method to perform a post order traversal of the Huffman code tree
  // and build encode and decode tables as reverse mappings of each other
  
  private void buildTables(HuffmanNode node, String code)
  {
    if(node.getValue()=='*') //if the node contains * then build the table 
    {
      buildTables(node.getOne(), code + "1"); //build the taable assigning "1" to the node 
      buildTables(node.getZero(), code + "0"); //nuild the table assinging "0" to the node
    }
    else
    {
      encodeTable.put(node.getValue(), code ); //if not, add it to the table to encode
      decodeTable.put(code, node.getValue());  //if not, add it to the table to decode
    }
  }
  
  // Use the encode table to encode the message character by character
  // and calculate the compression ratio for this message
  
  public String encode(String message)
  {
    String s = "";                      
    String str;  
    int y = 0;
    
    for (int i=0; i <message.length(); i++)  //loop through the message    
    {
      char c = message.charAt(i);
      
      str = encodeTable.get(c);  //get the encoded character 
      s += str + "\n";        //concatenate the string character to the encoded character              
      y += str.length();  //get the length of the string
    }
    compressionRatio = (double)(8*message.length())/y; //calculate the compression ration
    return s; //return the encode string
  }
  
  // Identify code sequences in the encoded message and
  // use the decode table to decode each code sequence
  
  public String decode(String encodedMessage)
  {
    Scanner scan = new Scanner (encodedMessage);  //scan through the encoded message  
    String s = "";                               
    while (scan.hasNext())                       
      s+=decodeTable.get(scan.next());  //decode the encoded message         
    return s;            //return the decoded message            
  }
  
  // provide the compression ratio for the most recent message encoding
  // should be called immediately after encoding the message to get valid data
  
  public double getCompressionRatio()
  {
    return compressionRatio; //return the compression ratio
  }
  
  // A test case for this class
  
  public static void main(String [] args)
  {
    String message = "The quick brown fox jumps over the lazy dog's back 1234567890 times."; 
    message = "Now is the time for all good men to come to the aid of their country.";
    HuffmanTree myTree = new HuffmanTree(message);
    System.out.println("Message is: " + message);
    String encodedMessage = myTree.encode(message);
    System.out.println("Encoded as:\n" + encodedMessage);
    System.out.println("Compression Ratio: " + myTree.getCompressionRatio() + " to 1");
    System.out.println("Decoded as: " + myTree.decode(encodedMessage));
  }
}