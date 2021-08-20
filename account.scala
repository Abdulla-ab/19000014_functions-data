class Account ( x:String , y: Int , z : Double){

    val NIC : String = x
    val accNumber : Int = y
    var balance : Double = z

    def withdraw( amount : Double ) = this.balance -= amount
    def deposit ( amount : Double ) = this.balance += amount
    def transfer( amount : Double , r : Acc ): Unit = {
        this.balance =  this.balance - amount
        r.balance = r.balance + amount
    }

    @Override
    override def toString() : String = "NIC : " + this.NIC + "\n Account Number : " + this.accNumber + "\n Balance : " + this.balance
}