Protecting writes to a static field by synchronizing on an instance lock is not thread-safe

Static fields should generally be guarded by static locks, and instance fields guarded by instance locks.

```java
synchronized (Test.class) {
  if (!initialized) {
    initialize();
    initialized = true;
  }
}
```
