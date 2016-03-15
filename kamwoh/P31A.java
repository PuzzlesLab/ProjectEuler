
package projecteuler;

import java.util.ArrayList;


public class P31A {
	
    public static void main(String[] args)
    {
        int n = 200;
        int[] coin = {1,2,5,10,20,50,100,200};
        int[] way = new int[n+1];
        way[0]=1;
        for(int i=0;i<coin.length;i++)
        {
            for(int j=coin[i];j<=n;j++)
            {
                System.out.println("i "+i+" j "+j+" coin[i] "+coin[i]+" j-coin[i] "+(j-coin[i]));
                System.out.println("way["+j+"] "+way[j]+" + way["+(j-coin[i])+"] "+way[j-coin[i]]);
                way[j]+=way[j-coin[i]];
                System.out.println("new way["+j+"] "+way[j]);
                System.out.println("");
            }
            System.out.println("");
        }
        System.out.println("way "+way[n]);
    }
    
    public static int count(int[] rm, int n)
    {
        int count = 0;
        for(int i=0;i<rm.length;i++)
        {
            if(n-rm[i]>=0)
                count++;
        }
        return count;
    }
    
    public static int[] get(int[] rm,int n)
    {
        int[] s = new int[count(rm,n)];
        for(int i=0;i<s.length;i++)
        {
            if(n-rm[i]>=0)
                s[i]=n-rm[i];
        }
        return s;
    }
    
}

class Graph
{
    public boolean[] already;
    public Bag[] bag;
    public int count=0;
    public int vertex;
    public int sum = 0;
    public Graph(int vertex)
    {
        this.vertex = vertex;
        already = new boolean[vertex];
        bag = new Bag[vertex];
        
        for(int i=0;i<vertex;i++)
        {
            already[i]=false;
            bag[i]=new Bag();
        }
    }
    
    public void addEdge(int v, int w)
    {
        bag[v].add(w);
    }
    
    public int getdfs(int[] rm,int n)
    {
        dfs(rm,n);
        return sum;
    }
    
    public void dfs(int[] rm, int n)
    {
        if(n==0)
            return;
        for(int i=0;i<rm.length;i++)
        {
            if(!already[n])
            {
                int temp = n;
                while(temp>0)
                {
                    temp-=rm[i];
                }
                sum++;
                dfs(rm,n-rm[i]);
                
                already[n]=true;
            }
            dfs(rm,n-1);
        }
    }
    
    public void display()
    {
        for(int i=bag.length-1;i>=0;i--)
        {
            System.out.println(i+" : "+bag[i].list);
        }
    }
    
}

class Bag
{
    public ArrayList<Integer> list = new ArrayList<>();
    
    public Bag()
    {
        
    }
    
    public void add(int v)
    {
        list.add(v);
    }
    
    public boolean contains(int v)
    {
        return list.contains(v);
    }
    
}