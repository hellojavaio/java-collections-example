# java-collections-example
example for java collections

http://www.cs.rochester.edu/u/scott/papers/2009_Scherer_CACM_SSQ.pdf

---

## Set

### EnumSet<E extends Enum<E>>

- RegularEnumSet
  
  - 内部存储结构为一个 `long` `Bit` 形式记载枚举的站位.`long` 的大小为 `-2^63 ~ 2^63-1`
  
- JumboEnumSet

  - 内部存储结构为一个 `long` 的数组,先查找出是哪一个数组然后再进行位运算
  
- complementOf 取反 EnumSet 没有被包含的枚举集合  

### HashSet

- `HashSet` 实际上就是 `HashMap` 的键集合

#### LinkedHashSet

- `LinkedHashSet` 实际上就是 `LinkedHashMap` 的键集合

### CopyOnWriteArraySet<E>

- `CopyOnWriteArrayList` 的子实现

### SortedSet<E>

- `Set` 约束添加一个保证，它的迭代器将以升序元素顺序遍历集合。
- `E first()` // 返回 `set` 里第一个元素
- `E last()`  //  返回 `set` 里最后一个元素

#### NavigableSet<E>

- `E ceiling(E e)` // 返回此集合中的最小元素大于或等于 `e`;如果不存在这样的元素，则返回 `null`
- `E floor(E e)`   // 返回此集合中最大的元素小于或等于 `e`;如果没有这样的元素，则返回 `null`
- `E higher(E e)`  // 返回此集合中的最小元素严格大于 `e`，如果不存在这样的元素，则返回 `null`
- `E lower(E e)`   // 返回此集合中最大的元素严格小于 `e`，如果没有这样的元素，则返回 `null`

##### TreeSet

- `TreeMap` 的键集合

##### ConcurrentSkipListSet<E>

- `ConcurrentSkipListMap` 的子实现

---

## Queue

- `add` 新增,失败会异常

- `offer` 新增,失败会返回 `false`

- `remove` 删除某个节点,没有这个节点会抛出异常

- `poll` 检索头部和删除节点

- `element` 检索头部节点,没有会抛出异常

- `peek` 检索头部节点

### AbstractQueue

- 实现接口关联 `add` 与 `off` 关联,`remove` 与 `poll` 关联, `element` 与 `peek` 关联, `clear` 与 `poll` 关联, `addAll` 与 `add` 关联

#### PriorityQueue

- 非线程安全

- 底层是一个数组结构

- 插入时自动排序大小

- **不能有相同的节点,否则排序会失效**

- 类比 `PriorityBlockingQueue`

### Deque

- 双端队列

#### LinkedList

- 底层是链表集合,能通过下标获取值

- 不是线程安全的 

#### ArrayDeque

- `Deque` 接口的可调整大小的数组实现。

- 阵列deques没有容量限制;他们根据需要增长以支持使用。

- 不是线程安全的

- 禁止使用空元素。

- 当用作堆栈时，此类可能比 `Stack` 快，并且在用作队列时比 [`LinkedList`](#LinkedList) 更快。

### BlockingQueue

- 添加了一些超时接口

#### ArrayBlockingQueue

- 底层数组实现

- 支持用于排序等待生产者和消费者线程的可选公平策略。

- 阻塞队列

#### DelayQueue<E extends Delayed>

- 延迟队列

- 阻塞队列

- 基于 [`PriorityQueue`](#PriorityQueue) 实现

#### BlockingDeque

- 同 [`BlockingQueue`](#BlockingQueue)

##### LinkedBlockingDeque

- 见 [`ArrayBlockingQueue`](#ArrayBlockingQueue) 

- 底层链表结构

#### LinkedBlockingQueue

- 底层链表结构

- 相对于 [`LinkedBlockingDeque`](#LinkedBlockingDeque) 拥有 2 把锁,可以在新增的时候同时消费

#### TransferQueue

- `BlockingQueue` 的子集
- 生产者可以等待消费者接收元素
 
- `TransferQueue` 可能在例如消息传递应用程序中很有用，其中生产者有时（使用方法转移（`E`））等待消费者调用 `take` 或 `poll` 接收元素，而在其他时候将元素排队（通过方法 `put` ）而不等待接收。 还可以使用 `tryTransfer` 的非阻塞和超时版本。 也可以通过 `hasWaitingConsumer()` 查询 `TransferQueue`，是否有任何线程等待项目，这与窥视操作相反。

##### LinkedTransferQueue

#### PriorityBlockingQueue

#### SynchronousQueue

### ConcurrentLinkedQueue