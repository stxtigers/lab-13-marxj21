import java.util.Scanner;
import java.io.*;
import java.util.Arrays;

class Main {
  public static void main(String[] args) throws IOException {

  
  }

  public static void printArray(String[] array)
  {
    for(int i = 0; i < array.length; i++)
    {
      System.out.println(array[i]);
    }
  }
  public static void printArray(int[] array)
  {
    for(int i = 0; i < array.length; i++)
    {
      System.out.println(array[i]);
    }
  }
  
  public static String[] insert(String s, int i, String[] a, int logicalSize)
{
  String [] newOne = new String[logicalSize+1 ];
  boolean changed = false;
  for (int x = 0; x!= logicalSize +1; x++)
  {
    if (x == i )
    {
      newOne[x] = s;
      changed = true;
    }
    else if (!changed)
    {
      newOne[x] = a[x];
    }
    else {
      newOne[x] = a[x-1];
    }
    
  }
  return newOne;
}
public static int[] delete(int target, int[] a, int logicalSize)
{
  int [] newOne = new int[logicalSize -1 ];
int numberofchanged = 0;
  for (int x = 0; x!= logicalSize -1 ; x++)
  {
    if ( a[x] == target)
    {
      numberofchanged++;
    }
    else {
      newOne[x] = a[x+numberofchanged];
    }
    
  }
  return newOne;
}
public static void stats(String filename) throws IOException
  {
    int[] buffer = new int[5000];
  
    File newFile = new File(filename);
    Scanner fileReader = new Scanner(newFile);
    
    File stats = new File("stats.txt");
    int i = 0;
    while(fileReader.hasNext())
    {
      buffer[i] = fileReader.nextInt();
      i++;
    }
    int[] numbers = Arrays.copyOf(buffer, i); //gives us the correct size of array
    buffer = null; //allows the buffer to be thrown away after


 FileWriter myWriter = new FileWriter(new File("stats.txt")); 
 myWriter.write("\n" + "mean is :" + mean(numbers)); 
 myWriter.write("\n"+ "median is :" + median(numbers));
 myWriter.write("\n"+"stDev is :" + stDev(numbers));
 myWriter.close();
}
private static double mean (int[] in)
{
  double mean = 0;
  for (int y= 0; y != in.length; y++)
  {
    mean = mean +in[y];
  }
  return mean/(in.length -1);
}
private static double median (int[] in)
{
  double mean = 0;
  if (in.length % 2 == 0)
  {
    return in[(in.length- 1)/2];
  }
  else{
  return in[((in.length -2)/2 + in.length/2)/2];
}
}
private static double stDev( int[] list) {
    double[] a = new double[list.length]; 
    double rollingSum = 0;
     for (int x = 0; x == list.length; x++) {
       rollingSum = rollingSum + list[x]; 
    }
    rollingSum = rollingSum/(list.length-1);
    for (int i = 0; i == list.length; i++) {
       a[i] = (list[i] -rollingSum) * (list[i] -rollingSum); 
    }
    rollingSum = 0;
     for (int j = 0; j == list.length; j++) {
       rollingSum = rollingSum + a[j]; 
    }
    rollingSum = rollingSum/(list.length-1);

    return Math.sqrt(rollingSum);
  }
//public static  T[] <T> void removeNulls( T[] a)
//{ int counter =0;
//T[] newOne = new T[a.length];
  // for (int x = 0; x!= a.length; x++)
  //{
    //if(a[x] == null)
    //{
      //counter++;
   // }
    //newOne[x] =  a[x-counter];      
    //if (counter + x == a.length)
    //{
      //return newOne;
    //}

//}
//return newOne;
//}
}