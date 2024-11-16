This project implements a custom DynamicArray<T> class in Java that mimics the behavior of ArrayList using a standard array under the hood. The class is generic, allowing it to hold elements of any type.

Features
Automatic Resizing:

The internal array automatically doubles in size when it reaches its capacity to accommodate new elements.

When elements are removed, the array resizes to half its current size if the number of elements is less than or equal to one-quarter of its capacity (to optimize memory usage).

Add Operation:

add(T element): Adds an element at the end of the list.

add(int index, T element): Adds an element at a specific index, shifting elements to the right if necessary.

Remove Operation:

remove(int index): Removes an element at a specified index. Elements to the right of the removed element shift left to fill the gap.

Get Operation:

get(int index): Returns the element at a specified index.

Size:

size(): Returns the current number of elements in the list (not the array capacity).

Display Method:

display(): Prints all elements in the list.

Error Handling:

Throws IndexOutOfBoundsException if an invalid index is provided for add, remove, or get operations.
