open class Line(var width: Int=0){
 init{
    println("The Line Class just created!")
 }
    fun printwidth(){
        println("The width of Line is $width")
    }
}

open class Square(var width_square:Int):Line(width_square){
    init { println("The Square Class just created!")  }
    fun printArea(){ println("The area of this Square is ${width*width}")      }
}
class Rectangle()


fun main(){
 //val LineAobj= Line(5);LineAobj.printwidth();val LineBobj=Line(10)
 //LineBobj.printwidth();  LineAobj.printwidth()
val SquareObj =Square(15)
SquareObj.printwidth();SquareObj.printArea()

}