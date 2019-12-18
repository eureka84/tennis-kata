package com.eureka.katas

import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.api.Test

class TennisGameScoreTest {

    @Test
    fun `0 - 0`() {
        val game = Game()

        assertThat(game.score(), equalTo("0 - 0"))
    }

    @Test
    fun `15 - 0`() {
        val game = Game()

        val updatedGame = game.pointToPlayer1()

        assertThat(updatedGame.score(), equalTo("15 - 0"))
    }

    @Test
    fun `30 - 0`() {
        val game = Game()

        val updatedGame =
            game
                .pointToPlayer1()
                .pointToPlayer1()

        assertThat(updatedGame.score(), equalTo("30 - 0"))
    }

    @Test
    fun `40 - 0`() {
        val game = Game()

        val updatedGame =
            game
                .pointToPlayer1()
                .pointToPlayer1()
                .pointToPlayer1()

        assertThat(updatedGame.score(), equalTo("40 - 0"))
    }

    @Test
    fun `40 - 0 and then GAME PLAYER 1`() {
        val game = Game()

        val updatedGame =
            game
                .pointToPlayer1()
                .pointToPlayer1()
                .pointToPlayer1()
                .pointToPlayer1()

        assertThat(updatedGame.score(), equalTo("GAME PLAYER 1"))
    }

    @Test
    fun `0 - 40 and then GAME PLAYER 2`() {
        val game = Game()

        val updatedGame =
            game
                .pointToPlayer2()
                .pointToPlayer2()
                .pointToPlayer2()
                .pointToPlayer2()

        assertThat(updatedGame.score(), equalTo("GAME PLAYER 2"))
    }

    @Test
    fun `0 - 15`() {
        val game = Game()

        val updatedGame = game.pointToPlayer2()

        assertThat(updatedGame.score(), equalTo("0 - 15"))
    }

    @Test
    fun `0 - 30`() {
        val game = Game()

        val updatedGame =
            game
                .pointToPlayer2()
                .pointToPlayer2()

        assertThat(updatedGame.score(), equalTo("0 - 30"))
    }

    @Test
    fun `0 - 40`() {
        val game = Game()

        val updatedGame =
            game
                .pointToPlayer2()
                .pointToPlayer2()
                .pointToPlayer2()

        assertThat(updatedGame.score(), equalTo("0 - 40"))
    }

    @Test
    fun `40 - 40 is  DEUCE`() {
        val game = Game()

        val updatedGame =
            game
                .pointToPlayer2()
                .pointToPlayer2()
                .pointToPlayer2()
                .pointToPlayer1()
                .pointToPlayer1()
                .pointToPlayer1()

        assertThat(updatedGame.score(), equalTo("DEUCE"))
    }

    @Test
    fun `ADVANTAGE PLAYER 1`() {
        val game = Game()

        val updatedGame =
            game
                .pointToPlayer2()
                .pointToPlayer2()
                .pointToPlayer2()
                .pointToPlayer1()
                .pointToPlayer1()
                .pointToPlayer1()
                .pointToPlayer1()

        assertThat(updatedGame.score(), equalTo("ADVANTAGE PLAYER 1"))
    }

    @Test
    fun `FROM ADVANTAGE PLAYER 1 TO DEUCE`() {
        val game = Game()

        val updatedGame =
            game
                .pointToPlayer2()
                .pointToPlayer2()
                .pointToPlayer2()
                .pointToPlayer1()
                .pointToPlayer1()
                .pointToPlayer1()
                .pointToPlayer1()
                .pointToPlayer2()

        assertThat(updatedGame.score(), equalTo("DEUCE"))
    }

    @Test
    fun `FROM ADVANTAGE TO GAME PLAYER 1`() {
        val game = Game()

        val updatedGame =
            game
                .pointToPlayer2()
                .pointToPlayer2()
                .pointToPlayer2()
                .pointToPlayer1()
                .pointToPlayer1()
                .pointToPlayer1()
                .pointToPlayer1()
                .pointToPlayer1()

        assertThat(updatedGame.score(), equalTo("GAME PLAYER 1"))
    }

    @Test
    fun `ADVANTAGE PLAYER 2`() {
        val game = Game()

        val updatedGame =
            game
                .pointToPlayer2()
                .pointToPlayer2()
                .pointToPlayer2()
                .pointToPlayer1()
                .pointToPlayer1()
                .pointToPlayer1()
                .pointToPlayer2()

        assertThat(updatedGame.score(), equalTo("ADVANTAGE PLAYER 2"))
    }
    @Test
    fun `FROM ADVANTAGE PLAYER 2 TO DEUCE`() {
        val game = Game()

        val updatedGame =
            game
                .pointToPlayer2()
                .pointToPlayer2()
                .pointToPlayer2()
                .pointToPlayer1()
                .pointToPlayer1()
                .pointToPlayer1()
                .pointToPlayer2()
                .pointToPlayer1()

        assertThat(updatedGame.score(), equalTo("DEUCE"))
    }

    @Test
    fun `FROM ADVANTAGE PLAYER 2 TO GAME`() {
        val game = Game()

        val updatedGame =
            game
                .pointToPlayer2()
                .pointToPlayer2()
                .pointToPlayer2()
                .pointToPlayer1()
                .pointToPlayer1()
                .pointToPlayer1()
                .pointToPlayer2()
                .pointToPlayer2()

        assertThat(updatedGame.score(), equalTo("GAME PLAYER 2"))
    }
}
