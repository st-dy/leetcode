package structure

/**
 * packageName    : st
 * fileName       : ListNode
 * author         : okdori
 * date           : 4/1/24
 * description    : leet
 */

class ListNode(`val`: Int) {
    var `val`: Int = `val`
    var next: ListNode? = null

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as ListNode

        if (`val` != other.`val`) return false
        if (next != other.next) return false

        return true
    }

    override fun hashCode(): Int {
        var result = `val`
        result = 31 * result + (next?.hashCode() ?: 0)
        return result
    }

    override fun toString(): String {
        return "ListNode(`val`=$`val`, next=$next)"
    }

    companion object {
        fun of(vararg integers: Int): ListNode? {
            require(integers.isNotEmpty())

            val head = ListNode(0)
            var last: ListNode? = head
            var p: ListNode
            for (integer in integers) {
                p = ListNode(integer)
                last!!.next = p
                last = last.next
            }

            return head.next
        }
    }
}
