#HAProxy
* solution for load balancing and reverse proxing both TCP and HTTP requestws
* HAProxy can continue to operate in the presence of failed backend servers, handling crossover reliably and seamlessly. It also has built-in health checks that will remove a backend if it fails several health checks in a row. 
* With dynamic routing you can transfer incoming traffic to a variety of backend servers, fully configurable with Access Control Lists (ACLs).

#Reverse proxying
* As a reverse proxy cache, Traffic Server serves requests on behalf of origin servers. 
* Traffic Server is configured in such a way that it appears to clients like a normal origin server.

##Advantages
  * Reverse proxy caching
    * Traffic Server acts as a proxy cache on behalf of the origin servers that store the content
  * offloads heavily used origins server
  * Provide security for origin servers that contain sensitive information.
  
#Implementation
  * A client browser sends an HTTP request addressed to a host called www.host.com on port 80. 
  * Traffic Server receives the request because it is acting as the origin server (the origin server’s advertised hostname resolves to Traffic Server).
  * Traffic Server locates a map rule in the remap.config file and remaps the request to the specified origin server (realhost.com).
  * If the request cannot be served from cache, Traffic Server opens a connection to the origin server (or more likely, uses an existing connection it has pre-established), retrieves the content, and optionally caches it for future use.
  * If the request was a cache hit and the content is still fresh in the cache, or the content is now available through Traffic Server because of step 3, Traffic Server sends the requested object to the client from the cache directly.
