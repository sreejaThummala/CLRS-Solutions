UUID generator
  Each application threads be created the ids independently. 
  No additional components 
  No single points of failure
  No contention for id generation
  If timestamps are used as first component for id generation, it can sorted
  To make unique ids without contention, the id generation should be considerably long (more storage space)

DB ticket servers
  Use incremental properties of DB to create a uniqueness
  use multiple dbs to avoid single point of failure
  no sortedness if use multiple dbs
  might become write bottleneck

Twitter snowflake <?>
  Additional complexity of having multiple independent components

Distributed UUID generation
  Goals
    Create an unique id
    Each id is given a lease of unlimited time
    the lenght of id is small (64-bit)
    scalable wrt request rate
    no spf
  
  Architecture
    a cluster / pool of id generator
    client cluster
    load balancer between id generator and clients
    
    Central book-keeper /maintain uniqueness
    A central server which keeps a counter  
      global counter
      what if it crashes
      contention is higher
    Solution
      Ask for a range of ids instead of global counter
      will reduce contention
      the server persists to disk 
        if it crashes it will know what range is allocated
      A standby is needed as backup
      it will need to sync up with central server  / or share disks with the primary
      it will monitor the health of primary server and will take up the role of primary 
    
    Peer multicast
      Instead of central server we can have workers coordiante between with each other for range allocation
      each client keeps track of current range allocated to it and highest range allocated to it
      range allocation request will be broadcasted to all the peers
      the client will then update its range after acknowledgements
      multiple requests at same time:
        distributed coordination algorithms
          bully algorithm
      no persistence needed 
      if it crashes, it can broadcase/mutlicase range allocation request
    
    Distributed hashtable
      key base routed scheme of DHT means each node will create a DHT node and join DHT ring
      under this scheme no need of brodcasting of range allocation requests
        implicit range allocation to nodes
        if one node fails, others take care of range ( immediate neighbour will contain replicated data)
      what if a clients exhauts its range
        it will create a new DHT node to join DHT ring
        
    
