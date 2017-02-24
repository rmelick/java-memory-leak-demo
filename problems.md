# Memory leaks:
## Database connections not closed
  Problem: The connection should be closed in the exception handler
  Class: DeviceDB
  How to discover it: Look for h2 related things in the memory usage graph

# False memory leaks:
These may look like a memory leak, but they mirror actual scenarios you see in production code
## Lots of strings
  Each message contains many strings, and these messages are persisted in hash maps, etc.


# Cpu performance problems:
## Expensive hashCode 
  Problem: An expensive hashcode is defined for something used as a key in a HashMap
  Class: GuidAndName
  How to discover it: Cpu profiling
  