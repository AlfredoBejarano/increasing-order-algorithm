import Foundation 

/**
* Checks if an array of integers is already in ascending order.
**/
func getUnorderedElementIndex(array: [Int]) -> Int {
    // Iterate through all the elements of the array, except for the last one.
    for index in array.indices.dropLast() {
        // If the current element is equals or larger than the next element
        if(array[index] >= array[index + 1]) {
            // return the current element position
            return index
        }
    }
    // If said condition is not met, return a non-index value.
    return -1
}

/**
* Check if a given array becomes ordered by ascending if a single element
* gets removed.
**/
func almostIncreasingSequence(sequence: [Int]) -> Bool {
    // If the array is empty, there is nothing to check, so return false
    if(sequence.isEmpty) {
        return false
    } else {
        // If the array is not empty, ge tthe index of the element that disrupts the order in the array.
        let index = getUnorderedElementIndex(array: sequence)
        // If the index is -1 (no element disrupts the array), the array is already ordered,
        if(index == -1) {
            return true
        } else {
            // If the array is not yet ordered, remove the previous element from the index
            var arrayWithoutPreviousElement = sequence
            arrayWithoutPreviousElement.remove(at: index - 1)
            // And remove the next element from the index.
            var arrayWithoutNextElement = sequence
                arrayWithoutNextElement.remove(at: index + 1)
            // Check if the list orders after removing the previous or the next element from the index.
            return getUnorderedElementIndex(array: arrayWithoutPreviousElement) == -1
                || getUnorderedElementIndex(array: arrayWithoutNextElement) == -1
        }
    }
}

print(almostIncreasingSequence(sequence: [1, 4, 10, 4, 2])) // false
print(almostIncreasingSequence(sequence: [1, 2, 1, 2])) // false
print(almostIncreasingSequence(sequence: [1, 3, 2])) // true
print(almostIncreasingSequence(sequence: [1, 3, 2, 1])) // false
print(almostIncreasingSequence(sequence: [1, 3])) // true
print(almostIncreasingSequence(sequence: [1])) // true
print(almostIncreasingSequence(sequence: [])) // false