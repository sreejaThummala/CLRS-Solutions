Yield high hit rates and excellent concurrency

#Eviction policy
##LRU
* Simple
* Ability to predict the future is limited to the history of entries residing in cache
* Modern caches extend the usage history
** include resent past
*** recency
*** frequency
* Example
** countmin sketch
** uses a matrix of counters and multiple hash functions
