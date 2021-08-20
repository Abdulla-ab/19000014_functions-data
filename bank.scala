object Bank extends App {

    var bank : List[Acc] = List( new Acc("John" , 1 , -1000) , new Acc("Sam" , 2 , 2000) )
    val find = ( nx : Int , bx : List[Acc]) => bx.filter( x => x.accountNumber.equals( nx ))
    val overdraft = ( bx : List[Acc] ) => bx.filter( x => x.balance < 0)
    val balance = ( bx: List[Acc] ) => bx.map( x => (x,x.balance) ).reduce( (ax , cx) => ( cx._1 , ax._2 + cx._2) )
    val interest = ( bx : List[Acc] ) => bx.map( x => {
        x.balance match {
            case ax if ax >= 0 => x deposit x.balance * 0.05
            case _ => x withdraw Math.abs(x.balance) * 0.01
        }
        x
    })

    println("bank " + bank )
    println()
    println("find " + find( 2 , bank) )
    println()
    println("overdraft " + overdraft( bank ) )
    println()
    println("balance " + balance( bank )._2 )
    println()
    bank = interest( bank )
    println("bank " + bank )
    println()
    println("balance " + balance( bank )._2 )
    println()
}