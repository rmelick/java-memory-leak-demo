# java-memory-leak-demo
Example project with a few memory leaks and cpu performance problems that can be found with a profiler (like Yourkit)

The actual leaks are describe in problems.md.  Please do not look there until you think you have solved everything.

## Application overview
This test application is meant to mirror a somewhat normal web service that serves as an in memory cache
of an event stream.  Messages come in, and the values within the cache are updated.

## Suggested testing procedure
### Generate heap dump
The normal case for memory problems is that you only have a heap dump, you cannot attach a live profiler to your
production code.  You can run the following command to execute this application for 5 minutes and then generate
a normal heap dump file

### Live profiling
You can then attach yourkit and watch the memory usage