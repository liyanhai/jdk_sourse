1、公平锁、非公平锁
    synchronized 非公平
    ReentrantLock reentrantLock = new ReentrantLock(true); 公平锁
2、可重入锁（又名递归锁）
    synchronized 和 ReentrantLock 都是可重入锁