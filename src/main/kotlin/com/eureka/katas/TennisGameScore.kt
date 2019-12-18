package com.eureka.katas

import arrow.optics.Lens
import arrow.optics.optics

@optics
data class Game(
    val scoreP1: Score = Score.LOVE,
    val scoreP2: Score = Score.LOVE
) {
    companion object

    fun pointToPlayer1(): Game = updateGame(Game.scoreP1, Game.scoreP2)

    fun pointToPlayer2(): Game = updateGame(Game.scoreP2, Game.scoreP1)

    private fun updateGame(
        playerScoringScoreLens: Lens<Game, Score>,
        otherPlayerScoreLens: Lens<Game, Score>
    ): Game =
        when (playerScoringScoreLens.get(this)) {
            Score.LOVE -> playerScoringScoreLens.set(this, Score.FIFTEEN)
            Score.FIFTEEN -> playerScoringScoreLens.set(this, Score.THIRTY)
            Score.THIRTY -> playerScoringScoreLens.set(this, Score.FORTY)
            Score.FORTY -> {
                when (otherPlayerScoreLens.get(this)) {
                    Score.FORTY -> playerScoringScoreLens.set(this, Score.ADVANTAGE)
                    Score.ADVANTAGE -> otherPlayerScoreLens.set(this, Score.FORTY)
                    else -> playerScoringScoreLens.set(this, Score.GAME)
                }
            }
            Score.ADVANTAGE -> playerScoringScoreLens.set(this, Score.GAME)
            Score.GAME -> throw UnsupportedOperationException()
        }

    fun score(): String =
        when {
            scoreP1 == Score.FORTY && scoreP2 == Score.FORTY -> "DEUCE"
            scoreP1 == Score.ADVANTAGE -> "ADVANTAGE PLAYER 1"
            scoreP1 == Score.GAME -> "GAME PLAYER 1"
            scoreP2 == Score.ADVANTAGE -> "ADVANTAGE PLAYER 2"
            scoreP2 == Score.GAME -> "GAME PLAYER 2"
            else -> "${scoreP1.value} - ${scoreP2.value}"
        }
}


enum class Score constructor(val value: String) {
    LOVE("0"),
    FIFTEEN("15"),
    THIRTY("30"),
    FORTY("40"),
    GAME("GAME"),
    ADVANTAGE("ADVANTAGE");
}

