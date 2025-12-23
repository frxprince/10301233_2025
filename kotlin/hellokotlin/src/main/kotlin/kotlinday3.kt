fun Show(text:String="text1 nodata",text2:String="no data",text3:String="nodata"):Unit{
  println("I have the word $text and word $text2 and also $text3" )
}
fun Add(a:Int,b:Int):Int{
 return a+b
}
fun Sub(a:Int,b:Int)= a-b


fun main(){
    Show(text3="hello",text="abcd")
    println(Sub(1,5))
}


