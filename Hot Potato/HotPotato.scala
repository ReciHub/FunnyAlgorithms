object HotPotato extends App {
    
  val players: Seq[String] = Seq("Ada", "Alan", "Linus", "Paul", "Bjarne")
  val turns: Int = 7
  
  println(s"The loser is: ${hotPotato(players, turns)}")

  def hotPotato(nameList: Seq[String], repetitions: Int): String = {
    val numPlayers: Int = nameList.length
    val loserPosition = repetitions % numPlayers
    nameList(loserPosition)
  }
  
}
