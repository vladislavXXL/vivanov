package ru.job4j3.threads.pool;

import org.junit.Before;
import org.junit.Test;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.StampedLock;
import java.util.stream.IntStream;

/**
 * Class with test to run different types of executors.
 *
 * @author v.ivanov
 * @version 1
 * @since 13.04.2019
 */
public class ExecutorsTest {

    /** Field newFixedThreadPool executor.*/
    private static ExecutorService executor;

    /** Field newWorkStealingPool executor.*/
    private static ExecutorService executorInvoke;

    /** Field newScheduledThreadPool executor.*/
    private static ScheduledExecutorService executorScheduled;

    /** Field count.*/
    private int count = 1;

    /** Field countSync.*/
    private int countSync = 1;

    /** Field countLock.*/
    private int countLock = 1;

    /** Field ReentrantLock instance.*/
    private ReentrantLock lock;

    /** Field ReadWriteLock instance.*/
    private ReadWriteLock readWriteLock;

    /** Field StampedLock instance.*/
    private StampedLock stampedLock;

    /**
     * Initialization method.
     */
    @Before
    public void setUp() {
        executor = Executors.newFixedThreadPool(1);
        executorInvoke = Executors.newWorkStealingPool();
        executorScheduled = Executors.newScheduledThreadPool(1);
        lock = new ReentrantLock();
        readWriteLock = new ReentrantReadWriteLock();
        stampedLock = new StampedLock();
    }

    /**
     * Work with an ExecutorService(newFixedThreadPool()) and Future instance.
     */
    @Test
    public void executorFuture() {
        Future<Integer> future = executor.submit(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
                return 123;
            } catch (InterruptedException e) {
                throw new IllegalStateException();
            }
        });
        System.out.println("Future done? " + future.isDone());
        int result = 0;
        try {
            executor.shutdown();
            result = future.get(5, TimeUnit.SECONDS);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Future done? " + future.isDone());
        System.out.println("" + result);
    }

    /**
     * Work with ExecutorService(newWorkStealingPool()) and invokeAll().
     */
    @Test
    public void executorInvokeAll() {
        List<Callable<Integer>> callables = Arrays.asList(
                () -> 1,
                () -> 2,
                () -> 3,
                () -> 4
        );
        try {
            executorInvoke.invokeAll(callables)
                    .stream()
                    .map(future -> {
                        try {
                            return future.get();
                        } catch (Exception e) {
                            throw new IllegalStateException();
                        }
                    }).forEach(System.out::println);
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }
    }

    /**
     * Work with ExecutorService(newWorkStealingPool()) and invokeAny().
     */
    @Test
    public void executorInvokeAny() {
        List<Callable<String>> callables = Arrays.asList(
                callable("task1", 2),
                callable("task2", 1),
                callable("task3", 3)
        );
        String result = "";
        try {
            result = executorInvoke.invokeAny(callables);
        } catch (Exception e) {
            throw new IllegalStateException();
        }
        System.out.println(result);
    }

    /**
     * Work with ScheduledExecutorService(newScheduledThreadPool()), schedule() and getDelay().
     */
    @Test
    public void executorScheduled() {
        Runnable task = () -> System.out.println("Scheduling: " + System.nanoTime());
        ScheduledFuture<?> future = executorScheduled.schedule(task, 3, TimeUnit.SECONDS);
        try {
            TimeUnit.MILLISECONDS.sleep(1337);
        } catch (Exception e) {
            e.printStackTrace();
        }
        long remainingDelay = future.getDelay(TimeUnit.MILLISECONDS);
        System.out.printf("Remaining delay: %s ms\n", remainingDelay);
    }

    /**
     * Work with ScheduledExecutorService(newScheduledThreadPool()) and scheduleAtFixedRate().
     */
    @Test
    public void executorScheduleAtFixedRate() {
        Runnable task = () -> System.out.println("Scheduling at fixed rate: " + System.nanoTime());
        int initialDelay = 0;
        int period = 2;
        executorScheduled.scheduleAtFixedRate(task, initialDelay, period, TimeUnit.SECONDS);
    }

    /**
     * Work with ScheduledExecutorService(newScheduledThreadPool()) and scheduleWithFixedDelay().
     */
    @Test
    public void executorScheduleWithFixedDelay() {
        Runnable task = () -> {
            try {
                TimeUnit.SECONDS.sleep(2);
                System.out.println("Scheduling with fixed delay: " + System.nanoTime());
            } catch (InterruptedException e) {
                System.err.println("Task interrupted.");
            }
        };
        executorScheduled.scheduleWithFixedDelay(task, 0, 1, TimeUnit.SECONDS);
    }

    /**
     * Method to make race condition.
     */
    @Test
    public void runRaceCondition() {
        ExecutorService executor1 = Executors.newFixedThreadPool(2);
        IntStream.range(1, 10000)
                .forEach(i -> executor1.submit(this::increment));
        stop(executor1);
        System.out.printf("Value with race condition: %d\n", count);

        ExecutorService executor2 = Executors.newFixedThreadPool(2);
        IntStream.range(1, 10000)
                .forEach(i -> executor2.submit(this::incrementSync));
        stop(executor2);
        System.out.printf("Value without race condition: %d\n", countSync);

        ExecutorService executor3 = Executors.newFixedThreadPool(2);
        IntStream.range(1, 10000)
                .forEach(i -> executor3.submit(this::incrementLocked));
        stop(executor3);
        System.out.printf("Value 'locked' without race condition: %d\n", countLock);
    }

    /**
     * Method to check ReentrantLock instance methods.
     */
    @Test
    public void reentrantLockMethods() {
        ExecutorService executorLock = Executors.newFixedThreadPool(2);
        executorLock.submit(() -> {
           lock.lock();
           try {
               sleep(1);
           } finally {
               lock.unlock();
           }
        });
        executorLock.submit(() -> {
            System.out.println("Locked: " + lock.isLocked());
            System.out.println("Held by me: " + lock.isHeldByCurrentThread());
            boolean locked = lock.tryLock();
            System.out.println("Lock acquired: " + locked);
        });
    }

    /**
     * Method to check work with ReadWriteLock(ReentrantReadWriteLock) instance.
     */
    @Test
    public void readWriteLock() {
        ExecutorService executorReadWrite = Executors.newFixedThreadPool(2);
        Map<String, String> map = new HashMap<>();
        executorReadWrite.submit(() -> {
            readWriteLock.writeLock().lock();
            try {
                sleep(1);
                map.put("key1", "value1");
            } finally {
                readWriteLock.writeLock().unlock();
            }
        });
        Runnable readTask = () -> {
            readWriteLock.readLock().lock();
            try {
                System.out.println(map.get("key1"));
                sleep(1);
            } finally {
                readWriteLock.readLock().unlock();
            }
        };
        executorReadWrite.submit(readTask);
        executorReadWrite.submit(readTask);
        stop(executorReadWrite);
    }

    /**
     * Method to check work with StampedLock instance.
     */
    @Test
    public void stampedLock() {
        ExecutorService executorStampedLock = Executors.newFixedThreadPool(2);
        Map<String, String> map = new HashMap<>();
        executorStampedLock.submit(() -> {
            long stamp = stampedLock.writeLock();
            try {
                sleep(1);
                map.put("key_stamped", "value_stamped");
            } finally {
                stampedLock.unlockWrite(stamp);
            }
        });
        Runnable readTask = () -> {
            long stamp = stampedLock.readLock();
            try {
                System.out.println(map.get("key_stamped"));
                sleep(1);
            } finally {
                stampedLock.unlockRead(stamp);
            }
        };
        executorStampedLock.submit(readTask);
        executorStampedLock.submit(readTask);
        stop(executorStampedLock);
    }

    /**
     * Method with optimistic StampedLock example.
     */
    @Test
    public void optimisticStampedLock() {
        ExecutorService executorOptimistic = Executors.newFixedThreadPool(2);
        executorOptimistic.submit(() -> {
            long stamp = stampedLock.tryOptimisticRead();
            try {
                System.out.println("Optimistic Lock Valid: " + stampedLock.validate(stamp));
                sleep(1);
                System.out.println("Optimistic Lock Valid: " + stampedLock.validate(stamp));
                sleep(2);
                System.out.println("Optimistick Lock Valid: " + stampedLock.validate(stamp));
            } finally {
                stampedLock.unlock(stamp);
            }
        });
        executorOptimistic.submit(() -> {
            long stamp = stampedLock.writeLock();
            try {
                System.out.println("Write lock acquired.");
            } finally {
                stampedLock.unlock(stamp);
                System.out.println("Write done");
            }
        });
        stop(executorOptimistic);
    }

    /**
     * Work with semaphores.
     */
    @Test
    public void checkSemaphores() {
        ExecutorService executorSemaphore = Executors.newFixedThreadPool(10);
        Semaphore semaphore = new Semaphore(5);
        Runnable longRunningTask = () -> {
            boolean permit = false;
            try {
                permit = semaphore.tryAcquire(1, TimeUnit.SECONDS);
                if (permit) {
                    System.out.println("Semaphore acquired");
                    sleep(5);
                } else {
                    System.out.println("Could not acquire semaphore");
                }
            } catch (InterruptedException e) {
                throw new IllegalStateException();
            } finally {
                if (permit) {
                    semaphore.release();
                }
            }
        };
        IntStream.range(0, 10)
                .forEach(i -> executorSemaphore.submit(longRunningTask));
        stop(executorSemaphore);
    }

    /**
     * Method to make Callable instance with delay.
     *
     * @param result Callable instance
     * @param sleepSeconds delay in seconds
     * @return result Callable instance with delay
     */
    private Callable callable(String result, long sleepSeconds) {
        return () -> {
            TimeUnit.SECONDS.sleep(sleepSeconds);
            return result;
        };
    }

    /**
     * Method to run sleep.
     * @param seconds period in seconds
     */
    private void sleep(int seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
    }

    /**
     * Method to stop specific executor.
     *
     * @param executor executor to stop
     */
    private void stop(ExecutorService executor) {
        try {
            executor.shutdown();
            executor.awaitTermination(60, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            System.err.println("Termination interrupted");
        } finally {
            if (!executor.isTerminated()) {
                System.err.println("Killing non-finished tasks");
            }
            executor.shutdown();
        }
    }

    /**
     * Increment method not threadsafe.
     */
    private void increment() {
        this.count++;
    }

    /**
     * Threadsafe increment method.
     */
    private synchronized void incrementSync() {
        this.countSync++;
    }

    /**
     * Threadsafe ReentrantLock increment.
     */
    private void incrementLocked() {
        lock.lock();
        try {
            this.countLock++;
        } finally {
            lock.unlock();
        }
    }
}
