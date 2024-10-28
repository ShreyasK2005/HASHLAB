import java.util.*;
import java.io.*;
public class Practice
{
  public static void main (String[] args)
  { 
    int[] k = {10, 100, 32, 45, 58, 126, 1, 29, 200, 400, 15};
    for(int a : k)
    {
      System.out.print(p(a) + " ");
    }
  }
  
  public static int p(int v)
  {
    int num = 11;
    int n = (v/2) % num;
    return n;
  }
  
  //2
  //O(1)
  
  //3
  //O(n)
  
}