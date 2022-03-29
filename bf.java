import java.util.*;
public class bf{
private int n;
private int D[];
public static final int max=999;
public bf(int n)
{
	this.n=n;
	D=new int[n+1];
}
public void shortest(int s, int a[][])
{
	for(int i=1;i<n+1;i++)
		D[i]=max;
	D[s]=0;	
	for(int k=1;k<n;k++)
		for(int i=1;i<n+1;i++)
			for(int j=1;j<n+1;j++)
				if(a[i][j]!=max)
					if(D[j]>D[i]+a[i][j])
						{ D[j]=D[i]+a[i][j]; System.out.println(i+" "+j); }
	for(int i=1;i<n+1;i++)
		for(int j=1;j<n+1;j++)
			if(a[i][j]!=max)
				if(D[j]>D[i]+a[i][j])
				{	System.out.println("-ve edge cycle");
					return;
				}
	for(int i=1;i<n+1;i++)
		System.out.println("Distance from "+s+" to "+i+" is "+D[i]);
}
public static void main(String args[])
{
	int n=0, s;
	Scanner sc = new Scanner(System.in);
	System.out.println("enter the no. of nodes\t");
	n=sc.nextInt();
	bf ob=new bf(n);
	int a[][]=new int[n+1][n+1];
	System.out.println("enter the matrix\t");
	for(int i=1;i<n+1;i++)
		for(int j=1;j<n+1;j++)
		{
			a[i][j]=sc.nextInt();
			if(i==j)
			{
				a[i][j]=0;
				continue;
			}
			if(a[i][j]==0)
				a[i][j]=max;
		}
	
	System.out.println("enter the source node\t");
	s=sc.nextInt();
	ob.shortest(s,a);
	sc.close();
}
}
