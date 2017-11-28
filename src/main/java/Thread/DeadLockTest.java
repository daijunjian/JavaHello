package Thread;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 这是一个简单的线程死锁列子
 *
 */
public class DeadLockTest {
    
    final static ReentrantLock lock1 = new ReentrantLock();
    final static ReentrantLock lock2 = new ReentrantLock();
    
    public static void main(String[] args) {
        new Thread(){
            @Override
            public void run() {
                lock1.lock();
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                lock2.lock();
                System.out.println("xxxx2");
                lock2.lock();
                lock1.lock();
            }
        }.start();

        new Thread(){
            @Override
            public void run() {
                lock2.lock();
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                lock1.lock();
                System.out.println("xxxx2");
                lock1.unlock();
                lock2.unlock();
            }
        }.start();

    }

}