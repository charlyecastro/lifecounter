package edu.washington.castroc.lifecounter

import android.util.*
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import android.view.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val constraintLayout = findViewById(R.id.constraint) as ConstraintLayout
//        val button = Button(this)
//        button.layoutParams = ConstraintLayout.LayoutParams(ConstraintLayout.LayoutParams.WRAP_CONTENT, ConstraintLayout.LayoutParams.WRAP_CONTENT)
//        button.text = "Touch me"
//        constraintLayout.addView(button);

        //keeps count of amount of losers
        var losers = 0

        // stores the lives of the lives of each player, each index represents the player
        val playerArray = intArrayOf(10, 10, 10, 10)

        //initializing buttons per player
        val lives1 = findViewById<TextView>(R.id.lives1)
        val lives2 = findViewById<TextView>(R.id.lives2)
        val lives3 = findViewById<TextView>(R.id.lives3)
        val lives4 = findViewById<TextView>(R.id.lives4)


        //Player 1
        val btnPlus1 = findViewById<Button>(R.id.btnPlus1)
        val btnMin1 = findViewById<Button>(R.id.btnMin1)
        val btnPlus5_1 = findViewById<Button>(R.id.btnPlus5_1)
        val btnMin5_1 = findViewById<Button>(R.id.btnMin5_1)


        //player 2
        val btnPlus2 = findViewById<Button>(R.id.btnPlus2)
        val btnMin2 = findViewById<Button>(R.id.btnMin2)
        val btnPlus5_2 = findViewById<Button>(R.id.btnPlus5_2)
        val btnMin5_2 = findViewById<Button>(R.id.btnMin5_2)


        //player 3
        val btnPlus3 = findViewById<Button>(R.id.btnPlus3)
        val btnMin3 = findViewById<Button>(R.id.btnMin3)
        val btnPlus5_3 = findViewById<Button>(R.id.btnPlus5_3)
        val btnMin5_3 = findViewById<Button>(R.id.btnMin5_3)


        //player 4
        val btnPlus4 = findViewById<Button>(R.id.btnPlus4)
        val btnMin4 = findViewById<Button>(R.id.btnMin4)
        val btnPlus5_4 = findViewById<Button>(R.id.btnPlus5_4)
        val btnMin5_4 = findViewById<Button>(R.id.btnMin5_4)


        //resets the textview to whats inside the playerArray
        fun updateLives() {
            lives1.text = "lives: " + playerArray[0]//playerMap["Player 1"]
            lives2.text = "lives: " + playerArray[1]//playerMap["Player 2"]
            lives3.text = "lives: " + playerArray[2]//playerMap["Player 3"]
            lives4.text = "lives: " + playerArray[3]//playerMap["Player 4"]
        }

        updateLives()


        //checks each index until it finds the index with a value greater than 0
        fun findWinner():Int {
            var i = 0
            for (num: Int in playerArray) {
                if (num >= 1) {
                    return i
                }
                i++
            }
            return i
        }

        //desables the buttons of the player who lost
        fun gameover(playerNum: Int) {
            if(playerNum == 1){
                btnPlus1.isEnabled = false
                btnMin1.isEnabled = false
                btnPlus5_1.isEnabled = false
                btnMin5_1.isEnabled = false
            }else if(playerNum == 2){
                btnPlus2.isEnabled = false
                btnMin2.isEnabled = false
                btnPlus5_2.isEnabled = false
                btnMin5_2.isEnabled = false

            }else if(playerNum == 3){
                btnPlus3.isEnabled = false
                btnMin3.isEnabled = false
                btnPlus5_3.isEnabled = false
                btnMin5_3.isEnabled = false

            } else {
                btnPlus4.isEnabled = false
                btnMin4.isEnabled = false
                btnPlus5_4.isEnabled = false
                btnMin5_4.isEnabled = false
            }
        }


        //handles the event when the button is clicked
        fun handleButtonEvent(button: Button) {
            val text = button.text.toString()
            val tag = button.tag.toString()
            var number = 0
            when (text) {
                "+" -> number = 1
                "-" -> number = -1
                "+5" -> number = 5
                "-5" -> number = -5
            }
            var type = tag.substring(tag.length - 1)
            val playerNum= Integer.parseInt(type)
            playerArray[playerNum - 1] = playerArray[playerNum - 1] + number

            //what happens if player has less than 1 lives
            if(playerArray[playerNum - 1] < 1) {
                playerArray[playerNum - 1] = 0
                val toast = Toast.makeText(applicationContext, "Player " + playerNum + " LOSES!", Toast.LENGTH_LONG)
                toast.show()
                gameover(playerNum)
                losers++
            }
            updateLives()

            // reports who the winner is when the loser count is equal to 3
            if(losers == 3) {
                val winner = findWinner() + 1
                val congrats = Toast.makeText(applicationContext, "Player " + winner + " Wins!!", Toast.LENGTH_LONG)
                congrats.setGravity(Gravity.CENTER_VERTICAL, 0, 0) //100,100,100)
                congrats.show()
            }


        }

        //setting up button event listeners per player

        //Player 1
        btnPlus1.setOnClickListener { handleButtonEvent(btnPlus1) }
        btnMin1.setOnClickListener { handleButtonEvent(btnMin1) }
        btnPlus5_1.setOnClickListener { handleButtonEvent(btnPlus5_1) }
        btnMin5_1.setOnClickListener { handleButtonEvent(btnMin5_1) }


        //player 2
        btnPlus2.setOnClickListener { handleButtonEvent(btnPlus2) }
        btnMin2.setOnClickListener { handleButtonEvent(btnMin2) }
        btnPlus5_2.setOnClickListener { handleButtonEvent(btnPlus5_2) }
        btnMin5_2.setOnClickListener { handleButtonEvent(btnMin5_2) }

        //player 3
        btnPlus3.setOnClickListener { handleButtonEvent(btnPlus3) }
        btnMin3.setOnClickListener { handleButtonEvent(btnMin3) }
        btnPlus5_3.setOnClickListener { handleButtonEvent(btnPlus5_3) }
        btnMin5_3.setOnClickListener { handleButtonEvent(btnMin5_3) }


        //player 4
        btnPlus4.setOnClickListener { handleButtonEvent(btnPlus4) }
        btnMin4.setOnClickListener { handleButtonEvent(btnMin4) }
        btnPlus5_4.setOnClickListener { handleButtonEvent(btnPlus5_4) }
        btnMin5_4.setOnClickListener { handleButtonEvent(btnMin5_4) }
    }

}