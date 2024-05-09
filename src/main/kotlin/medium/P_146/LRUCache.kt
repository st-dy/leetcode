package medium.P_146

/**
 * author       : okdori
 * date         : 5/9/24
 * description  :
 */

//class LRUCache(capacity: Int) {
//    private val cacheSize = capacity
//    private val cacheKey = mutableListOf<Int>()
//    private val cache = mutableMapOf<Int, Int>()
//
//    fun get(key: Int): Int {
//        return cacheKey.firstOrNull { key == it }?.let {
//            cacheKey.remove(key)
//            cacheKey.add(key)
//            cache[it]
//        } ?: -1
//    }
//
//    fun put(key: Int, value: Int) {
//        if (cacheKey.contains(key)) {
//            cacheKey.remove(key)
//        } else {
//            if (cacheKey.size == cacheSize) cacheKey.removeFirstOrNull()
//        }
//        cacheKey.add(key)
//        cache[key] = value
//    }
//}

class LRUCache(
    private var capacity: Int
) : LinkedHashMap<Int, Int>(capacity, 0.75f, true) {

    override fun get(key: Int): Int {
        return super.getOrDefault(key, -1)
    }

    override fun put(key: Int, value: Int): Int? {
        return super.put(key, value)
    }

    override fun removeEldestEntry(eldest: Map.Entry<Int?, Int?>): Boolean {
        return size > capacity
    }
}
