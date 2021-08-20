class Rational( x:Int , y:Int ) {

    require(y>0 , "denominator need to be positive always")

    private def gcd( ax:Int , bx:Int ):Int = {
        if ( bx == 0 ) ax
        else if ( bx > ax ) gcd( bx , ax)
        else gcd( bx, ax%bx )
    }

    private val gx = gcd( Math.abs(x) , y )

    val numer = x/gx
    val denom = y/gx
    def this( x : Int ) = this( x , 1 )
    def +( r : Rational ) :Rational = new Rational( this.numer * r.denom + r.numer * this.denom  , this.denom * r.denom )
    def neg : Rational = new Rational( -this.numer , this.denom )
    def -( r : Rational ) : Rational = this + r.neg
    def *( r : Rational ) : Rational = new Rational( this.numer * r.numer , this.deno * r.deno )
    def /( r : Rational ) : Rational = new Rational( this.numer * r.deno , this.deno * r.numer )

    @Override
    override def toString() : String = {
        denom match {
            case x if x==1 => numer.toString
            case _ => numer + "/" + denom
        }
    }
}