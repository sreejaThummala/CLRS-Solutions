A thread can also wake up without being notified, interrupted, or timingout, so cakked spurious wakeups.
This will happen rarely in practice. 

``` java
    synchronized (obj) {
            while ("condition does not hold")
                obj.wait(timeout);
    }
    
```
``` java
synchronized (this) {
  long now = System.currentTimeMillis();
  long deadline = now + timeout;
  while (!condition && now < deadline) {
    wait(deadline - now);
    now = System.currentTimeMillis();
  }
  doStuffAssumingConditionIsTrueOrTimeoutHasOccurred();
}
```

Why ```future.get ``` doesnot have problem of spurious wakeups?
it uses higher primitive which takes care of it.

