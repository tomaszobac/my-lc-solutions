fun reorganizeString(s: String): String {
    if (s.length in 0..1) return s

    var letters = LinkedHashMap<Char,Int>()
    var organized = charArrayOf()
    var max = 'A'
    var premax = 'A'

    for (letter in s) {
        if (letter !in letters.keys) {
            var count = s.count {it == letter}
            letters[letter] = count
            if (count > (letters[max] ?: 0)) {
                premax = max
                max = letter
            }
            if (count <= (letters[max] ?: 0) && count > (letters[premax] ?: 0) && letter != max) premax = letter
        }
    }

    if (max == 'A' || premax == 'A') return ""

    while (letters.values.filter { it > 0 }.isNotEmpty()) {
        organized += max
        organized += premax
        letters[max] = letters[max]!! - 1
        letters[premax] = letters[premax]!! - 1
        for (letter in letters.keys) {
            if (letters.values.filter { it > 0 }.isEmpty()) return String(organized)
            if (letters[letter]!! > letters[max]!!) {
                premax = max
                max = letter
            }
            if (letters[letter]!! > letters[premax]!! && letter != max) {
                premax = letter
            }
        }
        if ((letters[max] == 0 && letters[premax] == 0) || (letters[max] == 1 && letters[premax] == 0)) {
            organized += max
            return String(organized)
        }
        if ((letters[max] == 0 && letters[premax]!! > 0) || (letters[max]!! > 1 && letters[premax] == 0)) return ""
    }

    return String(organized)
}


fun main() {

    val long = "gpneqthatplqrofqgwwfmhzxjddhyupnluzkkysofgqawjyrwhfgdpkhiqgkpupgdeonipvptkfqluytogoljiaexrnxckeofqojltdjuujcnjdjohqbrzzzznymyrbbcjjmacdqyhpwtcmmlpjbqictcvjgswqyqcjcribfmyajsodsqicwallszoqkxjsoskxxstdeavavnqnrjelsxxlermaxmlgqaaeuvneovumneazaegtlztlxhihpqbajjwjujyorhldxxbdocklrklgvnoubegjrfrscigsemporrjkiyncugkksedfpuiqzbmwdaagqlxivxawccavcrtelscbewrqaxvhknxpyzdzjuhvoizxkcxuxllbkyyygtqdngpffvdvtivnbnlsurzroxyxcevsojbhjhujqxenhlvlgzcsibcxwomfpyevumljanfpjpyhsqxxnaewknpnuhpeffdvtyjqvvyzjeoctivqwann"
    println("aab:" + reorganizeString("aab"))
    println("aaa:" + reorganizeString("aaa"))
    println("aaab:" + reorganizeString("aaab"))
    println("baaba:" + reorganizeString("baaba"))
    println("bfrbs:" + reorganizeString("bfrbs"))
    println(reorganizeString(long))
}