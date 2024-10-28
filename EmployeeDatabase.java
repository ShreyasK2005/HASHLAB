import java.util.*;
import java.io.*;
public class EmployeeDatabase
{
  private boolean linear;
  private Entry[] eN;
  private int size;
  private final int capacity = 11;
  private int d;
  
  public EmployeeDatabase(boolean mode)
  {
    linear = mode;
    eN = new Entry[11];
    size = 0;
    d = capacity;
  }
  private class Entry
  {
    private int ID;
    private Employee employee;
    public Entry(int i, Employee e)
    {
      ID = i;
      employee = e;
    }
    @Override
    public String toString()
    {
      return ID + " " + employee;
    }
  }
  public int hashCode(int key)
  { 
    return (key/2)%d;
  }
   
  public void put(int key, Employee value)
  {
   if(size > d/2)
   {
     resizeAndRehash();
   }
   else if(size <= d/2)
   { 
    int index = hashCode(key);
    int c = 1;
    while (eN[index] != null)
    {
      if(eN[index].ID != key)
      {
         if(linear == false)
         {
          index = (index + 1)%d;
         }
         else
         {
          index = (index + c +c*c) % d;
          c++;
         }
      }
      else
      { 
       eN[index]= null;
      }  
    }
    eN[index] = new Entry(key, value);
    size++;
   }
  }
  
  public void resizeAndRehash()
  {
    Entry[] newA = eN;
    d = d * 2;
    eN = new Entry[d];
    for(int i = 0; i < newA.length; i++)
    {
      if(newA[i] != null)
      {
        put(newA[i].ID, newA[i].employee);
      }
    }
  }
  
  public Employee get(int key)
  {
    int index = hashCode(key);
    if(eN[index] !=null)
    {
      int c = 1;
      int checcker = 0;
      while(checcker != d)
      {
          if(eN[index].ID != key)
          {
            if(linear == false)
            {         
             index = (index + 1)%d;
            }
            else
            {
             index = (index + c +c*c) % d;
             c++;
            }
          }
          else
          {
            return eN[index].employee;
          }
        checcker++;
      }
    }
    return null;
  }
  
}