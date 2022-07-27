import java.nio.file.{Files, Path}
import scala.io.Source
import scala.util.{Using,Success,Failure}

object Anagrams extends App{
  val usage =
    """
  Usage: anagram wordToFindAnagram
"""
  val fn="/words.txt"

  if (args.length==0){
    Console.err.println(usage);
    sys.exit(-1)
  }

  val foundAnagrams=findAnagrams(args(0),fn )
  Console.print(s"Anagrams of ${args(0)} are ")
  Console.println(foundAnagrams.mkString("\n"))
  sys.exit(0)


  def findAnagrams(word:String,fileName:String):List[String]={
    Using(Source.fromFile(getClass.getResource(fileName).getFile)) { source =>
      val anagrams=word.toLowerCase().permutations.map(_.mkString).toList
      source.getLines.filter(x=> x.length==word.length && anagrams.contains(x.toLowerCase())).toList}
  } match {
      case Success(lstWords) => lstWords
      case Failure(ex) => println(s"Failed loading $fileName - Reason: ${ex.getMessage}")
        List()
  }


}
