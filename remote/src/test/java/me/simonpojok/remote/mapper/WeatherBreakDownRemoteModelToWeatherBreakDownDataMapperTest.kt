package me.simonpojok.remote.mapper

import me.simonpojok.data.weather.model.WeatherBreakDownDataModel
import me.simonpojok.remote.weather.mapper.WeatherBreakDownRemoteModelToWeatherBreakDownDataMapper
import me.simonpojok.remote.weather.model.WeatherBreakDownRemoteModel
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class WeatherBreakDownRemoteModelToWeatherBreakDownDataMapperTest(
    private val input: WeatherBreakDownRemoteModel,
    private val expectedResult: WeatherBreakDownDataModel,
) {

    companion object {
        @JvmStatic
        @Parameterized.Parameters(name = "Given {0} When toData Then returns {1}")
        fun params() = listOf(
            arrayOf(
                WeatherBreakDownRemoteModel(
                    temp = 67.0,
                    feels_like = 56.8,
                    temp_min = 56.0,
                    temp_max = 12.0,
                    pressure = 34.9,
                    humidity = 45.0
                ),
                WeatherBreakDownDataModel(
                    temp = 67.0,
                    feels_like = 56.8,
                    temp_min = 56.0,
                    temp_max = 12.0,
                    pressure = 34.9,
                    humidity = 45.0
                )
            )
        )
    }

    lateinit var classUnderTest: WeatherBreakDownRemoteModelToWeatherBreakDownDataMapper

    @Before
    fun setUp() {
        classUnderTest = WeatherBreakDownRemoteModelToWeatherBreakDownDataMapper()
    }

    @Test
    fun `Given remote model When toData then returns expected data model`() {
        // When
        val actualResult = classUnderTest.toData(input)

        // Then
        Assert.assertEquals(expectedResult, actualResult)
    }
}
