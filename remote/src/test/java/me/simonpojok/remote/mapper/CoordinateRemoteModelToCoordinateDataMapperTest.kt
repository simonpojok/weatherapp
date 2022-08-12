package me.simonpojok.remote.mapper

import me.simonpojok.data.weather.model.CoordinateDataModel
import me.simonpojok.remote.weather.mapper.CoordinateRemoteModelToCoordinateDataMapper
import me.simonpojok.remote.weather.model.CoordinateRemoteModel
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class CoordinateRemoteModelToCoordinateDataMapperTest(
    private val input: CoordinateRemoteModel,
    private val expectedResult: CoordinateDataModel
) {

    companion object {
        @JvmStatic
        @Parameterized.Parameters(name = "Given {0} When toData Then returns {1}")
        fun params() = listOf(
            arrayOf(
                CoordinateRemoteModel(
                    lon = 783,
                    lat = 100
                ),
                CoordinateDataModel(
                    lon = 783,
                    lat = 100
                )
            ),
            arrayOf(
                CoordinateRemoteModel(
                    lon = 7831,
                    lat = 1001
                ),
                CoordinateDataModel(
                    lon = 7831,
                    lat = 1001
                )
            )
        )
    }

    lateinit var classUnderTest: CoordinateRemoteModelToCoordinateDataMapper

    @Before
    fun setUp() {
        classUnderTest = CoordinateRemoteModelToCoordinateDataMapper()
    }

    @Test
    fun `Given remote model When toData then returns expected data model`() {
        // When
        val actualResult = classUnderTest.toData(input)

        // Then
        Assert.assertEquals(expectedResult, actualResult)
    }
}
