import java.util.*;
public class Employee
{
  private String name;
  public Employee(String n)
  {
    name = n;
    
  }
  
  @Override
  public String toString()
  {
    return name + " ";
  }
  
}