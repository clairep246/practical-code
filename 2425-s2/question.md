# CS2030S AY24/25 Sem 2  
## Practical Assessment 1 (Session I @ 4 PM)

## INSTRUCTIONS TO CANDIDATES

1. The total mark is 40.  We may deduct up to 4 marks for violating of
   style.

2. This is a CLOSED-BOOK assessment. You are only allowed to refer to one
   double-sided A4-size paper.

3. You should see the following files/directories in your home directory.

4. `CongestionException.java`, `Simulation.java`, `Simulator.java`,
   `Event.java`, `PE1.java`, `Queue.java`, and `Seq.java` are given classes
   for implementing your discrete event simulator.   Do not modify these
   files.

- `.pristine`, that contains a clean copy of the files above for your 
   reference. 

- `test-main.sh` and `test.jar` for testing your code.

- `.vimrc`, `.vim`, and `.backup`, for `vim` configuration and backup files.

- The rest of the .java files are for you to edit and solve the given task.      

5. Only the files directly under your home directory will be graded. Do not
   put your code under a subdirectory.

6. Write your student number on top of EVERY FILE you created or edited as
   part of the `@author` tag. Do not write your name.

7. To compile your code, run `javac -Xlint:unchecked -Xlint:rawtypes
   *.java`.  You can also compile the files individually if you wish.

Any code you wrote that cannot be compiled will result in 0 marks will be
given for the question or questions that depend on it.  Make sure your
program compiles by running
```
    javac -Xlint:unchecked -Xlint:rawtypes *.java
```
before submission.

API: The interface `Comparable<T>` has the following abstract method:

```
  int compareTo(T o)
```

Compares this object with the specified object for order. Returns a
negative integer, zero, or a positive integer as this object is less than,
equal to, or greater than the specified object.

## QUESTIONS

A new Request Tracking System (RT System) is introduced to track the
queries from students. The student submits a ticket in the system, which
gets queued in the system as per the ticket's priority.When an
administrator arrives, the tickets are processed as per their priorities
until all tickets are resolved.

The school wants to know if this RT System meets the demands for our
students. Knowing that you have helped build a simulator before, the school
has tasked you with building a discrete event simulation for request
tracking.

## Question 1 — Admin Class (2 marks)

Write a class named `Admin`, which represents an administrator who
processes tickets.  Each `Admin` has a field named `id` of type `int`,
which cannot be changed once initialized.

The `Admin` constructor takes in an `int` value as the parameter,
representing the `id` of the administrator. The `Admin` class also
overrides the `toString` method.


Write your class so that it behaves exactly as follows:

```
jshell> Admin p = new Admin(123)
p ==> A123
```

You can test your class with:

```bash
java -cp test.jar:. Test1
```


## Question 2 — Ticket Class (5 marks)

Write a class named `Ticket`, which represents a ticket submitted by the
student.  Every ticket is identified by a unique id of type `int`. It is
assigned at the creation of a ticket by the system and cannot be changed
once initialized. The first ticket ever created has the id **100**, the
next ticket **101**, and so on.

Every ticket also has a field named `priority` of type `int` and a field
named `time`, to represent the processing time of the ticket, of type
`double`.  They are initialised via the constructor of `Ticket` as shown in
the example below.

You can assume that priority is always given as a non-negative number, with
0 being the lowest priority.

Write the class `Ticket` so that it provides the following methods:

- The method `getPriority` takes no argument and returns the priority of
the ticket.  - The method `getProcessingTime` takes no argument and returns
the processing time of the ticket.

The `Ticket` class also overrides the `toString` method.  An example string
representation of `Ticket` is in the form `T100` where 100 is the id of the
ticket.

The `toString` method should return strings like:
```
T100
```

Write your class so that it behaves exactly as follows:

```
jshell> Ticket t1 = new Ticket(1, 2.0)
t1 ==> T100

jshell> Ticket t2 = new Ticket(0, 3.0)
t2 ==> T101

jshell> t2.getProcessingTime()
$4 ==> 3.0

jshell> t1.getPriority()
$5 ==> 1
```

You can test the `Ticket` class as follows:
```bash
java -cp test.jar:. Test2
```

---

## Question 3 — TicketQueue Class (8 marks)

You have been provided with the implementation of `Queue<T>`.  Write a
class named `TicketQueue` that extends `Queue<T>` and allows comparison of
two `TicketQueue` objects.  Every ticket queue has a field named `priority`
of type `int` that denotes the priority of tickets in the queue.  The
priority cannot be updated once initialized.  The priority of the queue and
the size of the queue are passed as parameters to the constructor of
`TicketQueue`.

Write the class `TicketQueue` so that it overrides the following methods:

- `enq` takes in a ticket as an argument. It enqueues the ticket only if
its priority matches the priority of the queue. Otherwise, it returns
`false`.

- `compareTo` takes in a ticket queue as an argument and returns the
relative order of this queue and the argument $q$.  

The queues are ordered using the following rules:

- An empty queue is always considered the smallest (last in ordering).

- If both queues are empty, the current queue is considered "less than" the
specified queue.

- When both queues are non-empty, they are first compared by their
priority.

- The queue with the smaller (lower) priority type is considered "less
than" the other queue.

- If both queues have the same priority, they are then compared by the
number of tickets in the queue.

- The queue with fewer tickets is considered "less than" the other queue.

- If both queues have the same priority and the same number of tickets, the
current queue is considered "less than"  the argument queue by default.

The `TicketQueue` class also overrides the `toString` method.  An example
string representation of `TicketQueue` is in the form

```
 Q0 [ T100 ]
```

The suffix `0` in `Q0` refers to the priority of the queue and `T100`
refers to the ticket in the queue.

Write your class so that it behaves exactly as follows:

```
jshell> TicketQueue tq1 = new TicketQueue(0, 2)
tq1 ==> Q0 [ ]

jshell> TicketQueue tq2 = new TicketQueue(1, 1)
tq2 ==> Q1 [ ]

jshell> TicketQueue tq3 = new TicketQueue(0, 1)
tq3 ==> Q0 [ ]

jshell> tq1.enq(new Ticket(0, 2.0))
$7 ==> true

jshell> tq1.enq(new Ticket(1, 3.0))
$8 ==> false

jshell> tq1.toString()
$9 ==> "Q0 [ T100 ]"

jshell> tq1.enq(new Ticket(0, 2.0))
$10 ==> true

jshell> tq1.toString()
$11 ==> "Q0 [ T100 T102 ]"

jshell> tq2.compareTo(tq1)
$12 ==> -1

jshell> tq2.enq(new Ticket(1, 3.0))
$13 ==> true

jshell> tq1.toString()
$14 ==> "Q0 [ T100 T102 ]"

jshell> tq2.compareTo(tq1)
$15 ==> 1

jshell> tq3.compareTo(tq1)
$16 ==> -1

jshell> tq3.enq(new Ticket(0, 2.0))
$17 ==> true

jshell> tq1.toString()
$18 ==> "Q0 [ T100 T102 ]"

jshell> tq3.compareTo(tq1)
$19 ==> -1

jshell> tq3.compareTo(tq2)
$20 ==> -1
```

You can test the `TicketQueue` class as follows:
```
java -cp test.jar:. Test3
```

## Question 4 — RTSystem Class (9 marks)

You have been provided with the implementation of `Seq<T extends
Comparable<T>>`. The implementation also provides the `max` method to find
the maximum element in the sequence respectively.  You have also been
provided with `CongestionException` which is a checked exception.  Please
skim through both implementations before you answer this question.

Write a class `RTSystem` that simulates a request tracking system. It
maintains a sequence of ticket queues.  `RTSystem` is initialised with the
number of queues Np and the queue capacity Nc via its constructor.  It
holds a queue for each priority starting from 0 to Np - 1. Every ticket
queue can hold a maximum of Nc tickets.

Write `RTSystem` so that it implements the following methods:

- The method `fileTicket` takes in a submitted ticket and returns the
updated `RTSystem`.  It files the ticket under a queue with the
corresponding priority.  If the ticket queue is full, it throws
`CongestionException`.

- The method `nextTicket` takes no argument and returns the ticket with the
highest priority in the system.  If multiple tickets have the same
priority, then it breaks ties by returning the ticket that is filed
earliest.  If there is no ticket in the system, the method returns `null`.

The `RTSystem` class also overrides the `toString` method.  An example
string representation of `TicketQueue` is in the form

```
 RT: [ 0:Q0 [ T100 ], 1:Q1 [ T101 ] ]
```

The example shows a request tracking system with two queues.

Write your class so that it behaves exactly as follows:


```
jshell> RTSystem rts = new RTSystem(2, 2)
rts ==> RT: [ 0:Q0 [ ], 1:Q1 [ ] ]

jshell> rts.fileTicket(new Ticket(0, 2.0))
$9 ==> RT: [ 0:Q0 [ T100 ], 1:Q1 [ ] ]

jshell> rts.fileTicket(new Ticket(0, 2.0))
$10 ==> RT: [ 0:Q0 [ T100 T101 ], 1:Q1 [ ] ]

jshell> rts.fileTicket(new Ticket(1, 3.0))
$11 ==> RT: [ 0:Q0 [ T100 T101 ], 1:Q1 [ T102 ] ]

jshell> rts.fileTicket(new Ticket(0, 1.0))

jshell> rts.nextTicket()
$13 ==> T102

jshell> rts.nextTicket()
$14 ==> T100
```

You can test the `RTSystem` class as follows:
```
java -cp test.jar:. Test4
```

## Question 5 Simulation

Now we are ready to implement our simulation. We have provided you with the
class `Event`, `Simulator`, `Simulation`, and `RTSimulation`.  The first
three classes are the same as what we provided in your Exercises 1 - 3.

To initialize the `RTSimulation`, it reads the following from the standard
input:

- Two positive integers Np and Nq that correspond to the number of priority
levels (equals to the number of queues), and the size of every queue.

- Two positive integers Na and Nt that correspond to the number of admins
and the number of tickets.

- The next Na lines contain two values each, representing arrival time and
admin id.

- The next NT lines contain three values each, representing filing time,
priority (a number in $[0, Np - 1]$), and processing time.

You can assume that the input is correctly formatted and always follows the
specified restrictions.

The code to read these inputs has been given to you in `RTSimulation`.  The
code to initialize the events has also been given but has been commented
out.  A good place to start is to uncomment the two lines and write the
necessary classes to make the simulation run properly.

After initializing the simulator with the events specified in the input
files above, the simulation runs as follows:

- Tickets submitted at the specified timings in the system.

- If the queue is congested, the ticket is dropped.

- Admins arrive at the specified timings in the system.

- Admin picks up a ticket and processes the ticket.

- The time required to process every ticket is specified when the tickets
are filed in the system.

- An admin takes 0.2 units of time to pick up a new ticket for processing

- After a ticket is processed, the admin picks up a new ticket to process
until there are no tickets left to process. The admin then silently leaves
and the simulation ends.

We are interested in simulating and printing out the following events.

- `AdminArrivalEvent`: Arrival of an admin

- `TicketSubmittedEvent`: Submission of a ticket

- `TicketDroppedEvent`: Dropping of a ticket (due to congestion in a queue)

- `TicketPickupEvent`: Pickup of a ticket (due to assignment to an admin at
the arrival or after processing of another ticket)

- `TicketProcessedEvent`: Completion of the processing of a ticket

A sample expected output is as follows (the number of priority levels and
size of the queue were set to 2 and 1 respectively):

```
0.500 T100 submitted RT: [ 0:Q0 [ ], 1:Q1 [ ] ]
1.000 T101 submitted RT: [ 0:Q0 [ T100 ], 1:Q1 [ ] ]
1.000 T101 dropped: Q0 is congested
2.000 A123 arrived RT: [ 0:Q0 [ T100 ], 1:Q1 [ ] ]
2.200 A123 picked up T100 RT: [ 0:Q0 [ ], 1:Q1 [ ] ]
3.200 T102 submitted RT: [ 0:Q0 [ ], 1:Q1 [ ] ]
3.200 T100 processed RT: [ 0:Q0 [ ], 1:Q1 [ T102 ] ]
3.400 A123 picked up T102 RT: [ 0:Q0 [ ], 1:Q1 [ ] ]
4.400 T102 processed RT: [ 0:Q0 [ ], 1:Q1 [ ] ]
```

In the example above, 

- Lines 1 - 2 and Line 6 are output from the submission events of the
tickets. Each line prints the ticket submitted, followed by the string
"submitted", followed by the status of `RTSystem`.

- Line 3 corresponds to the dropping of a ticket.  It prints the ticket,
followed by the string "dropped:", followed by the message of the
`CongestionException`.

- Line 4 corresponds to the arrival of the administrator. It prints the
administrator, followed by the string "arrived", followed by the status of
`RTSystem`.

- Lines 5 and 8 correspond to the ticket pickup event. Each line prints the
administrator, followed by a string "picked up", followed by the ticket,
followed by the `RTSystem`.

- Lines 7 and 9 correspond to the completion of the processing of a ticket.
Each line prints the ticket, followed by the string "processed", followed
by the status of the system.

You may add new classes and methods as needed.

You can run the simulation using the main program `Main`.  You can find
some test cases in `inputs` and the expected output in `outputs`.  A test
script `test-main.sh` has been given for testing.

You can test your code with
```
 ./test-main.sh
```

## END OF PAPER
