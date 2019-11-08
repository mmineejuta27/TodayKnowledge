package buu.informatics.s59161073.todayknowledge.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface GameScoreDatabaseDao {
    @Insert
    fun insert(gameScore: GameScore)

    @Update
    fun update(gameScore: GameScore)

    @Query("SELECT * from game_score_table WHERE gameId = :key")
    fun get(key: Long): GameScore?

    @Query("DELETE FROM game_score_table")
    fun clear()

    @Query("SELECT * FROM game_score_table ORDER BY user_score DESC LIMIT 1")
    fun getGameScore(): GameScore?

    @Query("SELECT * FROM game_score_table ORDER BY gameId DESC")
    fun getAllGameScore(): LiveData<List<GameScore>>


}