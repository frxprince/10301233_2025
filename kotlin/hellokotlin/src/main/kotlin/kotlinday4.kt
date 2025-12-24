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
  open  fun printArea(){ println("The area of this Square is ${width*width}")      }
}
open class Rectangle(var width_rec:Int,var height_rec:Int):Square(width_rec){
    init { println("The Rectangle Class just created!")  }
    fun printHeight(){println("The height of this Rectangle is $height_rec")}
    override fun printArea(){ println("The area of this Rectangle is ${width*height_rec}")      }

}
interface findAreaAnyShape{
    fun CalArea(w:Int,h:Int):Int
}
class AnyShape(var width_any:Int,var height_any:Int):Rectangle(width_any,height_any){
    init { println("The Anyshape Class just created!")  }
    private  var area=0
    fun printAnyArea(){println("The area of AnyShape is $area")}
    fun CalArea(Area:findAreaAnyShape){
      area=  Area.CalArea(width,height_rec)
    }
}

class AnyShapeLambda(var width_any:Int,var height_any:Int):Rectangle(width_any,height_any){
    init { println("The Anyshape Class just created!")  }
    private  var area=0
    fun printAnyArea(){println("The area of AnyShape is $area")}
    fun CalArea(Area:(w:Int,h:Int)->Int){
        area=Area(width,height_rec)
    }
}
fun main(){
    var Diamondobj2=AnyShapeLambda(10,20)
    Diamondobj2.printwidth();Diamondobj2.printHeight()
    Diamondobj2.CalArea({w,h-> (w*h)/2})
    Diamondobj2.printAnyArea()
/*var Diamondobj=AnyShape(10,30)
 Diamondobj.printwidth();Diamondobj.printHeight()
 Diamondobj.CalArea(object:findAreaAnyShape{
     override fun CalArea(w: Int, h: Int): Int {
        return (w*h)/2
     } })
 Diamondobj.printAnyArea()

   */

//  var RecObj= Rectangle(10,20)
 //  RecObj.printwidth();RecObj.printHeight();RecObj.printArea()
 //val LineAobj= Line(5);LineAobj.printwidth();val LineBobj=Line(10)
 //LineBobj.printwidth();  LineAobj.printwidth()
//val SquareObj =Square(15)
//SquareObj.printwidth();SquareObj.printArea()


}