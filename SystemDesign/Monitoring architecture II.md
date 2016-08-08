UDP is enough as sampling is only needed
If some packets are lost, its ok.

TextTSD

RRDTool
  Round robin database
  RRDTool is used to store metrics in constant space over time
    high resolution data (few minutes data) of near time which fades over time
    http://code.flickr.net/2008/10/27/counting-timing/
    How to get counters to RRDTool:
      a daemon to which counter name is sent on UDP
      the daemon then increments counter and updates to RRD
Sharding of time based series
  
  
  
