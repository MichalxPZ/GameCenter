package com.android.gamecenter.tictactoe

import java.lang.Math.abs

object Board {
    var fields: CharArray = charArrayOf(' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ')

    fun setTurn(): Char {
        var move = 'X'
        var countX = 0
        var countO = 0
        for (i in fields) {
            if (i == 'X') {
                countX += 1
            } else if (i == 'O') {
                countO += 1
            }
        }
        if (countX > countO) {
            move = 'O'
        }
        return move
    }

    fun findResults(): String{
        var x_wins: Boolean = false
        var o_wins: Boolean = false
        var draw: Boolean = false
        var impossible: Boolean = false
        var gamenotfinished: Boolean = false

        //impossible
        var x = 0
        var o = 0
        for(i in fields){
            if(i == 'X'){
                x += 1
            }
            if(i == 'O'){
                o += 1
            }
        }
        if (abs(x - o) > 1){
            impossible = true
        }
        //horizontal check
        for (i in 0..6 step 3){
            if ("${fields[i]} ${fields[i+1]} ${fields[i+2]}" == "X X X"){
                x_wins = true
            }
            if ("${fields[i]} ${fields[i+1]} ${fields[i+2]}" == "O O O"){
                o_wins = true
            }
        }
        //diagonal check
        if ("${fields[0]} ${fields[4]} ${fields[8]}" == "X X X"){
            x_wins = true
        }
        if ("${fields[0]} ${fields[4]} ${fields[8]}" == "O O O"){
            o_wins = true
        }
        if ("${fields[2]} ${fields[4]} ${fields[6]}" == "X X X"){
            x_wins = true
        }
        if ("${fields[2]} ${fields[4]} ${fields[6]}" == "O O O"){
            o_wins = true
        }
        //vertical check
        for (i in 0..2) {
            if ("${fields[i]} ${fields[i + 3]} ${fields[i + 6]}" == "X X X") {
                x_wins = true
            }
            if ("${fields[i]} ${fields[i + 3]} ${fields[i + 6]}" == "O O O") {
                o_wins = true
            }
        }

        //draw or game not finished
        if (' ' in fields && (!x_wins && !o_wins)){
            gamenotfinished = true
        }else if (!o_wins && !x_wins){
            draw = true
        }

        if (impossible == true){
            return "Impossible"
        }else{
            if (x_wins && o_wins){
                return "Impossible"
            } else{
                if (gamenotfinished){
                    return "Game not finished"
                }
                if (draw){
                    return "Draw"
                }
                if (x_wins){
                    return "X wins"
                }
                if (o_wins){
                    return "O wins"
                }
            }
        }
        return "0"
    }
}