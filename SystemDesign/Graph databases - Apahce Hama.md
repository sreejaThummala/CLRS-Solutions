Bulk Synchronous Parallel Computing
  Local computation
  Process communication
  Barrier synchronization

BSP on Hadoop
  BSP is different from Map reduce
    Map reduce does not preserve data locality
    BSP locality is preserved
  Hadoop RPC is used for peer to peer communication
  Zoo keeper is used to achieve barrier synchronization
    send message nad call sync to achieve barrier syncrhonization
    waits till all the peers send the message
  
    
Architecture
  http://techroz.com/wp-content/uploads/2016/03/119-1.png
  BSPServer
    Master server
      its owns state
      status of
        slaves
        counters
        super steps
        task
      allocation of tasks
  Groom server / slave
    Manages life cycle of tasks allocated to it by BSP Server
    Based on task spuns one or more BSP Peers
    It then becomes master nodes to BSP peers( workers)
    Periodically sends a heart beat to master to report its status and metrics
  zookeeper
    for coordination
  
  
    
