A thread can also wake up without being notified, interrupted, or timingout, so cakked spurious wakeups.
This will happen rarely in practice. 

``` java
    synchronized (obj) {
            while ("condition does not hold")
                obj.wait(timeout);
    }
    
```

Why ```future.get ``` doesnot have problem of spurious wakeups?
it uses higher primitive which takes care of it.

