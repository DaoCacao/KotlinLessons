package lesson_4.homework

/**
 * Custom map.
 * Create a custom map implementation that supports the following operations:
 * - get: returns the value associated with the key
 * - set: adds a new key-value pair to the map
 * - remove: removes the key-value pair associated with the key
 * - size: returns the number of key-value pairs in the map
 * - isEmpty: returns true if the map is empty, false otherwise
 * - containsKey: returns true if the map contains the key, false otherwise
 *
 * The map should be generic, supporting both key and value types.
 * You can use any storage you want to implement the map, also other collections from the standard library, except the built-in Map.
 *
 * To test implementation you can use the following code:
 * ```
 * val map = CustomMap<String, Int>()
 * map.set("one") = 1
 * map.set("two") = 2
 * map.set("three") = 3
 *
 * // get
 * println(map.get("one")) // 1
 * println(map.get("two")) // 2
 * println(map.get("three")) // null
 *
 * // set
 * map.set("one") = 11
 * map.set("two") = 22
 * map.set("three") = 33
 * assertEquals(map["one"], 11)
 * assertEquals(map["two"], 22)
 * assertEquals(map["three"], 33)
 *
 * // remove
 * map.remove("one")
 * map.remove("two")
 * map.remove("three")
 * assertEquals(map["one"], null)
 * assertEquals(map["two"], null)
 * assertEquals(map["three"], null)
 *
 * // size
 * map["one"] = 1
 * map["two"] = 2
 * map["three"] = 3
 * assertEquals(map.size(), 3)
 * map.remove("one")
 * assertEquals(map.size(), 2)
 * map.remove("two")
 * assertEquals(map.size(), 1)
 * map.remove("three")
 * assertEquals(map.size(), 0)
 *
 * // isEmpty
 * map["one"] = 1
 * map["two"] = 2
 * map["three"] = 3
 * assertEquals(map.isEmpty(), false)
 * map.remove("one")
 * assertEquals(map.isEmpty(), false)
 * map.remove("two")
 * assertEquals(map.isEmpty(), false)
 * map.remove("three")
 * assertEquals(map.isEmpty(), true)
 *
 * // containsKey
 * map["one"] = 1
 * map["two"] = 2
 * map["three"] = 3
 * assertEquals(map.containsKey("one"), true)
 * assertEquals(map.containsKey("two"), true)
 * assertEquals(map.containsKey("three"), true)
 * assertEquals(map.containsKey("four"), false)
 * map.remove("one")
 * assertEquals(map.containsKey("one"), false)
 * assertEquals(map.containsKey("two"), true)
 * assertEquals(map.containsKey("three"), true)
 * assertEquals(map.containsKey("four"), false)
 * map.remove("two")
 * assertEquals(map.containsKey("one"), false)
 * assertEquals(map.containsKey("two"), false)
 * assertEquals(map.containsKey("three"), true)
 * assertEquals(map.containsKey("four"), false)
 * map.remove("three")
 * assertEquals(map.containsKey("one"), false)
 * assertEquals(map.containsKey("two"), false)
 * assertEquals(map.containsKey("three"), false)
 * assertEquals(map.containsKey("four"), false)
 *
 * ```
 *
 * Additional:
 * - Read about operators in Kotlin and make get() and set() as operator functions.
 * - Read about Pairs in Kotlin and make constructor of CustomMap to accept a list of pairs.
 */