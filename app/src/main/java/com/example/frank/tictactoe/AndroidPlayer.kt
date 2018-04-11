package com.example.frank.tictactoe

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_android_player.*
import java.util.*

class AndroidPlayer : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_android_player)

        multiplayer.setOnClickListener({

            var i = Intent(this, MainActivity::class.java)
            startActivity(i)
        })
    }

    var roundcount: Int = 0

    fun androidnewGame(view: View) {

        mbutton1.text = ""
        mbutton2.text = ""
        mbutton3.text = ""
        mbutton4.text = ""
        mbutton5.text = ""
        mbutton6.text = ""
        mbutton7.text = ""
        mbutton8.text = ""
        mbutton9.text = ""

        firstPlayer.clear()
        secondPlayer.clear()

        mplayer1score.text = "0"
        androidplayer2score.text = "0"

    }


    fun buttonClicked(view: View) {
        var field = 0
        var myButtonSelected = view as Button
        when (myButtonSelected.id) {
            R.id.mbutton1 -> field = 1
            R.id.mbutton2 -> field = 2
            R.id.mbutton3 -> field = 3
            R.id.mbutton4 -> field = 4
            R.id.mbutton5 -> field = 5
            R.id.mbutton6 -> field = 6
            R.id.mbutton7 -> field = 7
            R.id.mbutton8 -> field = 8
            R.id.mbutton9 -> field = 9
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

            AndroidPlayer()
        } else {
            myButtonSelected.text = "O"
//            myButtonSelected.isEnabled = false
            secondPlayer.add(field)
            onPlayer = 1
        }


//            if (onPlayer == 1) {
//                myButtonSelected.text = "O"
////            myButtonSelected.isEnabled = false
//                firstPlayer.add(field)
//                onPlayer = 2
//
//                AndroidPlayer()
//            } else {
//                myButtonSelected.text = "X"
////            myButtonSelected.isEnabled = false
//                secondPlayer.add(field)
//                onPlayer = 1
//            }


        roundcount++


        if (roundcount == 9) {
            Toast.makeText(this, "Draw", Toast.LENGTH_LONG).show()
            mbutton1.text = ""
            mbutton2.text = ""
            mbutton3.text = ""
            mbutton4.text = ""
            mbutton5.text = ""
            mbutton6.text = ""
            mbutton7.text = ""
            mbutton8.text = ""
            mbutton9.text = ""
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

                Toast.makeText(this, "YOU WON", Toast.LENGTH_LONG).show()
//                button1.isEnabled = false
//                button2.isEnabled = false
//                button3.isEnabled = false
//                button4.isEnabled = false
//                button5.isEnabled = false
//                button6.isEnabled = false
//                button7.isEnabled = false
//                button8.isEnabled = false
//                button1.isEnabled = false

                mbutton1.text = ""
                mbutton2.text = ""
                mbutton3.text = ""
                mbutton4.text = ""
                mbutton5.text = ""
                mbutton6.text = ""
                mbutton7.text = ""
                mbutton8.text = ""
                mbutton9.text = ""


                var playerInt = mplayer1score.text.toString().toInt()
                var player1answer = playerInt + 1
                mplayer1score.text = player1answer.toString()

                firstPlayer.clear()
                secondPlayer.clear()


                roundcount = 0


            } else if (win == 2) {
                Toast.makeText(this, "ANDROID WINS", Toast.LENGTH_LONG).show()


                var playerInt2 = androidplayer2score.text.toString().toInt()
                var player2answer = playerInt2 + 1
                androidplayer2score.text = player2answer.toString()

                mbutton1.text = ""
                mbutton2.text = ""
                mbutton3.text = ""
                mbutton4.text = ""
                mbutton5.text = ""
                mbutton6.text = ""
                mbutton7.text = ""
                mbutton8.text = ""
                mbutton9.text = ""


                firstPlayer.clear()
                secondPlayer.clear()

                roundcount = 0


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
            1 -> myButtonSelected = mbutton1
            2 -> myButtonSelected = mbutton2
            3 -> myButtonSelected = mbutton3
            4 -> myButtonSelected = mbutton4
            5 -> myButtonSelected = mbutton5
            6 -> myButtonSelected = mbutton6
            7 -> myButtonSelected = mbutton7
            8 -> myButtonSelected = mbutton8
            9 -> myButtonSelected = mbutton9
            else -> {
                myButtonSelected = mbutton1

            }
        }
        playTicTacToe(field, myButtonSelected)

    }
}
