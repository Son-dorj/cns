import java.util.*;
public class crc
{
	void div(int a[],int k)
	{
		int count=0;
		int gp[]={1,0,0,0,1,0,0,0,0,0,0,1,0,0,0,0,1};
		for(int i=0;i<k;i++)
			if(a[i]==1)
			{
				for(int j=i;j<17+i;j++)
				{
					a[j]=a[j]^gp[count++];
				}
				count=0;
			}
	}
	public static void main (String args[])
	{
		int a[]=new int[100];
		int b[]=new int[100];
		int len, k, flag=0;
		crc ob=new crc();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the length of message:\t");
		len=sc.nextInt();
		k=len;
		for(int i=0;i<len;i++)
			a[i]=sc.nextInt();
		for(int i=0;i<16;i++)
			a[len++]=0;
		for(int i=0;i<len;i++)
			b[i]=a[i];
		ob.div(a,k);
		for (int i=0;i<len;i++)
			a[i]=a[i]^b[i];
		System.out.println("data to be transmitted\t");
		for (int i=0;i<len;i++)
			System.out.print(a[i]+" ");
		System.out.println();
		System.out.println("enter the recieved data\t");
		for(int i=0;i<len;i++)
			a[i]=sc.nextInt();
		ob.div(a,k);
		for(int i=0;i<len;i++)
			if(a[i]!=0)
			{
				flag=1;
				break;			
			}
		if(flag==0)
			System.out.println("No Error");	
		else
			System.out.println("Data corrupted");	
		
	}
}

