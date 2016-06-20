package xuexi;

import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;

import redis.clients.jedis.Jedis;

import com.danga.MemCached.MemCachedClient;
import com.danga.MemCached.SockIOPool;

public class XueXi {
	public int a;
	public Hashtable t1;
	public final Te te11 = new Te();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long id = 1;
		long id1 = id;
		XueXi xuexi1 = new XueXi();
		xuexi1.hehehe();
    
	}
	public void ce(){
		Integer a = 129;
		Integer b = 129;
		System.out.println(a.equals(b));
	}
	public void redis(){
		//Connecting to Redis server on localhost
	    Jedis jedis = new Jedis("112.74.22.35",6379);
	    System.out.println("Connection to server sucessfully");
	    //check whether server is running or not
        jedis.set("test", "123456");
        System.out.println("is:"+jedis.get("test"));
	}
	public void memcached(){
		  /*初始化SockIOPool，管理memcached的连接池*/
        String[] servers = { "112.74.22.35:12111" };
        SockIOPool pool = SockIOPool.getInstance();
        pool.setServers(servers);
        pool.setFailover(true);
        pool.setInitConn(10);
        pool.setMinConn(5);
        pool.setMaxConn(250);
        pool.setMaintSleep(30);
        pool.setNagle(false);
        pool.setSocketTO(3000);
        pool.setAliveCheck(true);
        pool.initialize();
        /*建立MemcachedClient实例*/
        MemCachedClient memCachedClient = new MemCachedClient();
        for (int i = 0; i < 10; i++) {
            /*将对象加入到memcached缓存*/
            boolean success = memCachedClient.set("" + i, "Hello!");
            /*从memcached缓存中按key值取对象*/
            String result = (String) memCachedClient.get("" + i);
            System.out.println(String.format("set( %d ): %s", i, success));
            System.out.println(String.format("get( %d ): %s", i, result));
        }
	}
	public void test3(){
		HashMap paramMap = null;
    	ArrayList list = new ArrayList();
		for(int i=0;i<125;i++){
			paramMap = new HashMap();
			paramMap.put("hehe", i);
    		list.add(paramMap);
    	}
		for(int i=0,len=list.size();i<len;i++){
			System.out.println(((HashMap)list.get(i)).get("hehe"));
		}
	}
	public void ceshi1(){
		int b;
		String a = "呵呵";
		b = 5;
		byte[] a1 = a.getBytes();
		System.out.println(a1.length);
	}
	public void ceshi(){
		int a = new Integer(1);
		int b = 1;
		System.out.println(a == b);
		String c = new String("hehe");
		String d = "hehe";
		System.out.println(c == d);
		System.out.println(c.equals(d));
	}
    public void xiugai(Te te){
    	HashMap programMap = null;
    	HashMap paramMap = null;
    	ArrayList list = new ArrayList();
    	te.a = 5;
    	for(int i=0;i<25;i++){
    		programMap = new HashMap();
    		programMap.put("hehe", i);
    		list.add(programMap);
    		programMap = null;
    	}
    	for(int i=0;i<list.size();i++){
    		paramMap = (HashMap) list.get(i);
    		if(paramMap!=null){
    		   System.out.println(paramMap.get("hehe"));
    		}
        }
    }
    public void abc(){
    	t1=new Hashtable();
    	t1.put("hehe", "1");
    	ArrayList a = new ArrayList();
    	ArrayList b =new ArrayList();
    	HashSet h = new HashSet();
    	a.add(3);
    	a.add(3);
    	System.out.println(a.size());
    	h.add(new String("3"));
    	h.add(new String("3"));
    	System.out.println(h.size());
    	String m = "abc";
    	String n = m;
    	m = "aa";
    	System.out.println(m+"@"+n);
    }
    public void hehehe(){
    	Te tt = new Te();
    	Te tt1 = tt;
    	tt = null;
    	tt1 = null;
        try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    }
}
class Te{
	int a = 1;
	int b;
	Te t1;
	@Override
	protected void finalize() {
		t1=this;
		System.out.println(t1.a);
		System.out.println("我已经被垃圾回收器回收了...");
	}
}
