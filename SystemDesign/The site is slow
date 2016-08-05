A website with multiple webservers connected to single relation database on a third server

the site is slow
why?
one of the webserveres went down
look at logs --- always look at logs
run a test suite to diagnose the issue
look at server logs to check if load balancer/ router has gone wrong
look at CPU utilization, heap untilization of the servers (both web and database)
network pipe between webserver and database server
database connection pooling issue
SQL statements are drainign webserver resorces
is database being locked up on insert
is databases being hit at evey page load

what if database becomes scarce resource
Cache ?
write through cache / write back cache (difference)
what are ideal caches for:

1. read-write data  
2. static data
3. dynamic data
