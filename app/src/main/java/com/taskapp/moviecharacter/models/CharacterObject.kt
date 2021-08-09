package com.taskapp.moviecharacter.models

import org.json.JSONArray

/*
  {
    "char_id": 1,
    "name": "Walter White",
    "birthday": "09-07-1958",
    "occupation": [
      "High School Chemistry Teacher",
      "Meth King Pin"
    ],
    "img": "https://images.amcnetworks.com/amc.com/wp-content/uploads/2015/04/cast_bb_700x1000_walter-white-lg.jpg",
    "status": "Presumed dead",
    "nickname": "Heisenberg",
    "appearance": [
      1,
      2,
      3,
      4,
      5
    ],
    "portrayed": "Bryan Cranston",
    "category": "Breaking Bad",
    "better_call_saul_appearance": []
  },
 */
//https://www.json2kotlin.com/
data class CharacterObject (

        val char_id : Int,
        val name : String,
        val birthday : String,
        val occupation : List<String>,
        val img : String,
        val status : String,
        val nickname : String,
        val appearance : List<Int>,
        val portrayed : String,
        val category : String,
        val better_call_saul_appearance : List<String>
)
/*
class CharacterObject {

    var char_id: Int = 0
    var name: String = ""
    var birthday: String = ""
    //lateinit var occupation: JSONArray
    var img: String = ""
    var status: String = ""
    var nickname: String = ""
    //lateinit var appearance: JSONArray
    var portrayed: String = ""
    var category: String = ""
    //lateinit var better_call_saul_appearance: JSONArray

    init {
        println(this.toString())
    }

    override fun toString() =


        "char_id: $char_id\n" +
        "name: $name\n" +
        "birthday: $birthday\n" +
        //"occupation: $occupation\n" +
        "img: $img\n" +
        "status: $status\n" +
        "nickname: $nickname\n" +
        //"appearance: $appearance\n" +
        "portrayed: $portrayed\n" +
        "category: $category\n"
       // "better_call_saul_appearance: $better_call_saul_appearance\n"

}

 */