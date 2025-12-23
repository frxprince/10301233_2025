fun main(){

  var t:String?

  t= null
// ?. object  ?:

    try {
        println(t!!.length)
    } catch (e: Exception) {
       println("no input data")
    }

    println(t?.length?:"no data")
  println(t)

}