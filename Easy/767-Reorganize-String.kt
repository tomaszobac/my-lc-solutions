fun reorganizeString(s: String): String {
    var letters = LinkedHashMap<Char,Int>()
    var organized = charArrayOf()
    var max = s[0]

    for (letter in s) {
        if (letter !in letters.keys) {
            var count = s.count {it == letter}
            letters[letter] = count
            if (count > letters[max]!!) max = letter
        }
    }

    while (letters.isNotEmpty()) {
        if (letters.count() == 1 && letters[letters.keys.first()]!! > 1) return ""
        organized += max
        letters[max] = letters[max]!! - 1
        var diff = false
        if (letters[max] == 0) {
            var temp = findMax(letters, max)
            if (letters[max] == 0) letters.remove(max)
            max = temp
        }
        for (letter in letters.keys) {
            if (letter != max) {
                diff = true
                organized += letter
                letters[letter] = letters[letter]!! - 1
                if (letters[letter] == 0) letters.remove(letter)
                break;
            }
        }
        //if (!diff) return ""
    }

    return String(organized)
}

fun findMax(map: LinkedHashMap<Char,Int>, max: Char): Char {
    var newmax = max
    for (letter in map.keys) {
        if (map[letter]!! > map[newmax]!!) newmax = letter
    }
    return newmax
}

fun main() {

    val long = "gpneqthatplqrofqgwwfmhzxjddhyupnluzkkysofgqawjyrwhfgdpkhiqgkpupgdeonipvptkfqluytogoljiaexrnxckeofqojltdjuujcnjdjohqbrzzzznymyrbbcjjmacdqyhpwtcmmlpjbqictcvjgswqyqcjcribfmyajsodsqicwallszoqkxjsoskxxstdeavavnqnrjelsxxlermaxmlgqaaeuvneovumneazaegtlztlxhihpqbajjwjujyorhldxxbdocklrklgvnoubegjrfrscigsemporrjkiyncugkksedfpuiqzbmwdaagqlxivxawccavcrtelscbewrqaxvhknxpyzdzjuhvoizxkcxuxllbkyyygtqdngpffvdvtivnbnlsurzroxyxcevsojbhjhujqxenhlvlgzcsibcxwomfpyevumljanfpjpyhsqxxnaewknpnuhpeffdvtyjqvvyzjeoctivqwann"
    println(reorganizeString("aab"))
    println(reorganizeString("aaa"))
    println(reorganizeString("aaab"))
    println(reorganizeString("baaba"))
    println(reorganizeString("bfrbs"))
    println(reorganizeString(long))
}