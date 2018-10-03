fun main(args: Array<String>) {
    println(almostIncreasingSequence(arrayOf(1, 4, 10, 4, 2))) // false
    println(almostIncreasingSequence(arrayOf(1, 2, 1, 2))) // false
    println(almostIncreasingSequence(arrayOf(1, 3, 2))) // true
    println(almostIncreasingSequence(arrayOf(1, 3, 2, 1))) // false
    println(almostIncreasingSequence(arrayOf(1, 3))) // true
    println(almostIncreasingSequence(arrayOf(1))) // true
    println(almostIncreasingSequence(arrayOf())) // false
}

/**
 * Checks if an array of Integers obtains an ascending order if one single element is removed.
 * @param array The array to be checked if removing a single element, it becomes ordered by ascending.
 */
fun almostIncreasingSequence(array: Array<Int>) = if (array.isEmpty()) {
    // If the list is empty, return false, as an empty list can't have an order.
    false
} else {
    // Retrieve the index of an element that breaks the order
    val index = getUnorderedElementIndex(array)
    // If the index is -1 (no element breaks the order), the list is already in ascending order.
    if (index == -1) {
        true
    } else {
        val arrayWithoutPreviousElement = array.copyOfRange(0, index - 1)
                .plus(array.copyOfRange(index, array.size))
        val arrayWithoutNextElement = array.copyOfRange(0, index + 1)
                .plus(array.copyOfRange(index + 2, array.size))
        // If not, check if by removing the previous element at the retrieved index orders the list.
        getUnorderedElementIndex(arrayWithoutPreviousElement) == -1 ||
                // Or check if by removing the next element at the retrieved index orders the list.
                getUnorderedElementIndex(arrayWithoutNextElement) == -1
    }
}

/**
 * Checks if a given array of Integers is currently in an ascending order.
 * @param array array of integers being checked.
 */
fun getUnorderedElementIndex(array: Array<Int>): Int {
    // Iterate through all the elements in the array except for the last one.
    for (i in 0 until array.size - 1) {
        // If the current element is bigger or equals than the next one, return the element index.
        if (array[i] >= array[i + 1]) {
            return i
        }
    }
    // If said condition is never met, return a non index position, a -1 can work.
    return -1
}