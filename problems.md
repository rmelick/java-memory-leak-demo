# Memory leaks:
## Callbacks not completing
  Problem: Resources that should be cleaned up on callback completion are not being cleaned up because the callback
  never completes
## Static tree reference
  Problem: A static value is holding an ever growing list of references to other values

# False memory leaks:
These may look like a memory leak, but they mirror actual scenarios you see in production code
## Lots of strings
  Each message contains many strings, and these messages are persisted in hash maps, etc.


# Cpu performance problems:
## Expensive hashCode 
  Problem: An expensive hashcode is defined for something used as a key in a HashMap
  Class: 
  How to discover it:
  