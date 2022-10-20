package oct;
class Table  
{     
	synchronized static void printTable(int n){    
		System.out.println("Thread: "+Thread.currentThread().getName());
		for(int i=1;i<=10;i++){    
			System.out.println(n*i);    
			try{    
				Thread.sleep(1000);
			}catch(Exception e){}    
		}    
	}
}    
class MyThread1 extends Thread{    
	Table table = new Table();
	public void run(){
		table.printTable(1);    
	}    
}
class MyThread2 extends Thread{    
	Table table = new Table();
	public void run(){    
		table.printTable(10);    
	}    
}
class MyThread3 extends Thread{    
	Table table = new Table();
	public void run(){    
		table.printTable(100);    
	}    
}    
class MyThread4 extends Thread{    
	Table table = new Table();
	public void run(){    
		table.printTable(1000);    
	}    
}    
public class UsingStaticSyncMethod{    
public static void main(String t[]){  
MyThread1 t1=new MyThread1();    
MyThread1 t2=new MyThread1();    
MyThread1 t3=new MyThread1();    
MyThread1 t4=new MyThread1();    
t1.setName("1");
t2.setName("2");
t3.setName("3");
t4.setName("4");
t1.start();    
t2.start();    
t3.start();    
t4.start();    
}    
}    