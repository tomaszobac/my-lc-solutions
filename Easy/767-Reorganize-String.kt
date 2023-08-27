fun reorganizeString(s: String): String {
    var letters = LinkedHashMap<Char,Int>()
    var organized = charArrayOf()
    for (letter in s) {
        if (letter !in letters.keys) {
            letters.put(letter, s.count(letter))
        }
    }
    return String(organized)
}