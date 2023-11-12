package com.example.busschedule.data

import androidx.room.Dao
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
@Dao
interface ItemDao {
    @Query(
        """
            Select * FROM Schedule
            ORDER BY arrival_time ASC 
        """
    )
    fun getAllStops(): Flow<List<BusSchedule>>

    @Query(
        """
            SELECT * FROM Schedule
            WHERE stop_name = :stopName
            ORDER BY arrival_time ASC
        """
    )
    fun getStopByName(stopName: String): Flow<List<BusSchedule>>
}