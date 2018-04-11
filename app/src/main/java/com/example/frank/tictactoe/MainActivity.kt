package com.example.frank.tictactoe

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_android_player.*
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import android.content.Intent


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        android.setOnClickListener({

           var ii = Intent(this,AndroidPlayer::class.java)
            startActivity(ii)
        })
    }





   var roundcount: Int = 0

    fun newGame(view: View){

        button1.text = ""
        button2.text = ""
        button3.text = ""
        button4.text = ""
        button5.text = ""
        button6.text = ""
        button7.text = ""
        button8.text = ""
        button9.text = ""

        firstPlayer.clear()
        secondPlayer.clear()

        player1score.text  = "0"
        player2score.text = "0"

    }


    fun buttonClicked(view: View) {
        var field = 0
        var myButtonSelected = view as Button
        when (myButtonSelected.id) {
            R.id.button1 -> field = 1
            R.id.button2 -> field = 2
            R.id.button3 -> field = 3
            R.id.button4 -> field = 4
            R.id.button5 -> field = 5
            R.id.button6 -> field = 6
            R.id.button7 -> field = 7
            R.id.button8 -> field = 8
            R.id.button9 -> field = 9
        }



        playTicTacToe(field, myButtonSelected)
    }

    var firstPlayer = ArrayList<Int>()
    var secondPlayer = ArrayList<Int>()
    var onPlayer = 1

    fun playTicTacToe(field: Int, myButtonSelected: Button) {


        if (onPlayer == 1) {
            myButtonSelected.text = "X"
//            myButtonSelected.isEnabled = false
            firstPlayer.add(field)
            onPlayer = 2

//            AndroidPlayer()
        } else {
            myButtonSelected.text = "O"
//            myButtonSelected.isEnabled = false
            secondPlayer.add(field)
            onPlayer = 1
        }

        roundcount++


        if(roundcount == 9){
            Toast.makeText(this,"Draw",Toast.LENGTH_LONG).show()
            button1.text = ""
            button2.text = ""
            button3.text = ""
            button4.text = ""
            button5.text = ""
            button6.text = ""
            button7.text = ""
            button8.text = ""
            button9.text = ""
            firstPlayer.clear()
            secondPlayer.clear()
        }
        Winner()

    }


    fun Winner() {
        var win = -1
        if (firstPlayer.contains(1) && firstPlayer.contains(2) && firstPlayer.contains(3)) {
            win = 1
        }
        if (secondPlayer.contains(1) && secondPlayer.contains(2) && secondPlayer.contains(3)) {
            win = 2
        }
        if (firstPlayer.contains(4) && firstPlayer.contains(5) && firstPlayer.contains(6)) {
            win = 1
        }
        if (secondPlayer.contains(4) && secondPlayer.contains(5) && secondPlayer.contains(6)) {
            win = 2
        }
        if (firstPlayer.contains(7) && firstPlayer.contains(8) && firstPlayer.contains(9)) {
            win = 1
        }
        if (secondPlayer.contains(7) && secondPlayer.contains(8) && secondPlayer.contains(9)) {
            win = 2
        }
        //column
        if (firstPlayer.contains(1) && firstPlayer.contains(4) && firstPlayer.contains(7)) {
            win = 1
        }
        if (secondPlayer.contains(1) && secondPlayer.contains(4) && secondPlayer.contains(7)) {
            win = 2
        }
        if (firstPlayer.contains(2) && firstPlayer.contains(5) && firstPlayer.contains(8)) {
            win = 1
        }
        if (secondPlayer.contains(2) && secondPlayer.contains(5) && secondPlayer.contains(8)) {
            win = 2
        }
        if (firstPlayer.contains(3) && firstPlayer.contains(6) && firstPlayer.contains(9)) {
            win = 1
        }
        if (secondPlayer.contains(3) && secondPlayer.contains(6) && secondPlayer.contains(9)) {
            win = 2
        }

        //diagonal

        if (firstPlayer.contains(1) && firstPlayer.contains(5) && firstPlayer.contains(9)) {
            win = 1
        }
        if (secondPlayer.contains(1) && secondPlayer.contains(5) && secondPlayer.contains(9)) {
            win = 2
        }
        if (firstPlayer.contains(3) && firstPlayer.contains(5) && firstPlayer.contains(7)) {
            win = 1
        }
        if (secondPlayer.contains(3) && secondPlayer.contains(5) && secondPlayer.contains(7)) {
            win = 2
        }


        if (win != -1) {
            if (win == 1) {

                Toast.makeText(this, "PLAYER 1 WON", Toast.LENGTH_LONG).show()
//                button1.isEnabled = false
//                button2.isEnabled = false
//                button3.isEnabled = false
//                button4.isEnabled = false
//                button5.isEnabled = false
//                button6.isEnabled = false
//                button7.isEnabled = false
//                button8.isEnabled = false
//                button1.isEnabled = false

                button1.text = ""
                button2.text = ""
                button3.text = ""
                button4.text = ""
                button5.text = ""
                button6.text = ""
                button7.text = ""
                button8.text = ""
                button9.text = ""



                var playerInt = player1score.text.toString().toInt()
                var player1answer = playerInt + 1
                player1score.text = player1answer.toString()

                firstPlayer.clear()
                secondPlayer.clear()


                roundcount = 0

                onPlayer = 2


            } else if (win == 2) {
                Toast.makeText(this, "PLAYER 2 WON", Toast.LENGTH_LONG).show()



                var playerInt2 = player2score.text.toString().toInt()
                var player2answer = playerInt2 + 1
                player2score.text = player2answer.toString()

                button1.text = ""
                button2.text = ""
                button3.text = ""
                button4.text = ""
                button5.text = ""
                button6.text = ""
                button7.text = ""
                button8.text = ""
                button9.text = ""


                firstPlayer.clear()
                secondPlayer.clear()

                roundcount = 0

                onPlayer = 1

            }



        }


    }

    fun AndroidPlayer() {

        var emptyField = ArrayList<Int>()
        for (field in 1..9) {
            if (!(firstPlayer.contains(field) || secondPlayer.contains(field))) {
                emptyField.add(field)
            }
        }
        var rand = Random()
        var randIndex = rand.nextInt(emptyField.size - 0) + 0
        var field = emptyField[randIndex]
        var myButtonSelected: Button
        when (field) {
            1 -> myButtonSelected = button1
            2 -> myButtonSelected = button2
            3 -> myButtonSelected = button3
            4 -> myButtonSelected = button4
            5 -> myButtonSelected = button5
            6 -> myButtonSelected = button6
            7 -> myButtonSelected = button7
            8 -> myButtonSelected = button8
            9 -> myButtonSelected = button9
            else -> {
                myButtonSelected = button1

            }
        }
        playTicTacToe(field, myButtonSelected)

    }
}
//Toast.makeText(this,"DRAW",Toast.LENGTH_LONG).show()
