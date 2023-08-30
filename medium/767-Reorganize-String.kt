// Name: 767. Reorganize String
// Difficulty: Medium
// Acceptance rate: 54.3%
// Runtime: Beats 5.63%
// Memory usage: Beats 5.30%

fun reorganizeString(s: String): String {
    if (s.length in 0..1) return s

    var letters = LinkedHashMap<Char,Int>()
    var max = 'A'

    for (i in 0 until s.length) {
        letters[s[i]] = (letters[s[i]] ?: 0) + 1
        if (letters[s[i]]!! > (letters[max] ?: 0)) {
            max = s[i]
        }
    }

    if (letters.size == 1) return ""
    if (letters[max]!! - 1 > s.length - letters[max]!!) return ""

    var organized = charArrayOf()

    while (letters.values.filter { it > 0 }.isNotEmpty()) {
        if (organized.isNotEmpty() && organized.last() == max) return ""
        organized += max
        letters[max] = letters[max]!! - 1
        for (letter in letters.keys) {
            if (letters.values.filter { it > 0 }.isEmpty()) return String(organized)
            if (letter != max && letters[letter] != 0) {
                organized += letter
                letters[letter] = letters[letter]!! - 1
                break
            }
        }
        for (letter in letters.keys) {
            if (letter != max && letters[letter]!! > letters[max]!!) {
                max = letter
                break
            }
        }
        if ((letters[max] == 0)) return String(organized)
    }

    return String(organized)
}


fun main() {

    val long = "gpneqthatplqrofqgwwfmhzxjddhyupnluzkkysofgqawjyrwhfgdpkhiqgkpupgdeonipvptkfqluytogoljiaexrnxckeofqojltdjuujcnjdjohqbrzzzznymyrbbcjjmacdqyhpwtcmmlpjbqictcvjgswqyqcjcribfmyajsodsqicwallszoqkxjsoskxxstdeavavnqnrjelsxxlermaxmlgqaaeuvneovumneazaegtlztlxhihpqbajjwjujyorhldxxbdocklrklgvnoubegjrfrscigsemporrjkiyncugkksedfpuiqzbmwdaagqlxivxawccavcrtelscbewrqaxvhknxpyzdzjuhvoizxkcxuxllbkyyygtqdngpffvdvtivnbnlsurzroxyxcevsojbhjhujqxenhlvlgzcsibcxwomfpyevumljanfpjpyhsqxxnaewknpnuhpeffdvtyjqvvyzjeoctivqwann"
    println("aab:" + reorganizeString("aab"))
    println("aaa:" + reorganizeString("aaa"))
    println("aaab:" + reorganizeString("aaab"))
    println("vvvlo:" + reorganizeString("vvvlo"))
    println("aaaaayyyybbbc:" + reorganizeString("aaaaayyyybbbc"))
    println("baaba:" + reorganizeString("baaba"))
    println("bfrbs:" + reorganizeString("bfrbs"))
    println(reorganizeString(long))
}