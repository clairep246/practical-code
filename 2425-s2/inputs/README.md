PE1.1.in:
- 2 priority levels, queues of size 1.
- 1 admin, 2 tickets
- Single admin no congestions

PE1.2.in:
- 2 priority levels, queues of size 1.
- 2 admin, 2 tickets
- 2 admins no congestion (handles multiple admins)

PE1.3.in
- 2 priority levels, queues of size 1.
- 2 admins, three tickets
- (Handles choosing higher priority tickets)

PE1.4.in:
- 2 priority levels, queues of size 1.
- 1 admins, three tickets
- Congestion (handles congestion)

PE1.5.in:
- 2 priority levels, queues of size 2.
- 1 admin, three tickets
- No congestion. (handles long queues)

PE1.6.in
- 2 priority levels, queue size 2
- 2 admins, 0 tickets
- Vanilla case without tickets

PE1.7.in
- 2 priority levels, queue size 2
- 0 admin, 4 tickets
- Vanilla case without admins


PE1.6.in - Able to handle AdminArrivalEvent
PE1.7.in - Able to handle TicketArrivalEvent
PE1.1.in - Able to handle single admin processing the tickets
PE1.2.in - Able to handle multiple admins processing the tickets
PE1.3.in - Able to handle choosing higher priority tickets
PE1.4.in - Able to handle CongestionEvent
PE1.5.in - Able to handle all events