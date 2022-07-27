import org.scalatest.funsuite.AnyFunSuite

class AnagramsTest extends AnyFunSuite {

  test("Not existing file return empty anagrams") {
    val res=Anagrams.findAnagrams("test","/wordsWrong.txt")
    assert(res.isEmpty)
  }

  test("words1.txt doesn't contain any test anagram") {
    val res = Anagrams.findAnagrams("test", "/words1.txt")
    assert(res.isEmpty)
  }

  test("words1.txt  contains one  backa anagram") {
    val res = Anagrams.findAnagrams("backa", "/words1.txt")
    assert(res.length==1)
  }

  test("words1.txt  contains one  Backa anagram because not case sensitive") {
    val res = Anagrams.findAnagrams("Backa", "/words1.txt")
    assert(res.length == 1)
  }
}
