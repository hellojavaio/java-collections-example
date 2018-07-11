# java-collections-example
example for java collections


## Set

### EnumSet<E extends Enum<E>>

- RegularEnumSet
  
  - 内部存储结构为一个 `long` `Bit` 形式记载枚举的站位.`long` 的大小为 `-2^63 ~ 2^63-1`
  
- JumboEnumSet

  - 内部存储结构为一个 `long` 的数组,先查找出是哪一个数组然后再进行位运算
  
- complementOf 取反 EnumSet 没有被包含的枚举集合  

### HashSet

- `HashSet` 实际上就是 `HashMap` 的键集合

### LinkedHashSet

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

- `ConcurrentSkipListSet` 的子实现







