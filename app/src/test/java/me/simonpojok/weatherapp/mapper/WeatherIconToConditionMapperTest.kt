package me.simonpojok.weatherapp.mapper

import me.simonpojok.remote.weather.model.CloudsRemoteModel
import me.simonpojok.weatherapp.weather.mapper.WeatherIconToConditionMapper
import me.simonpojok.weatherapp.weather.model.WeatherConditions
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class WeatherIconToConditionMapperTest(
    private val input: String,
    private val expectedResult: WeatherConditions
) {
    companion object {
        @JvmStatic
        @Parameterized.Parameters(name = "Given {0} When map Then returns {1}")
        fun params() = listOf(
            arrayOf(
                "01d",
                WeatherConditions.Sunny
            ),
            arrayOf(
                "01n",
                WeatherConditions.Sunny
            ),
            arrayOf(
                "02n",
                WeatherConditions.Cloudy
            ),
            arrayOf(
                "02d",
                WeatherConditions.Cloudy
            ),
            arrayOf(
                "03n",
                WeatherConditions.Cloudy
            ),
            arrayOf(
                "03d",
                WeatherConditions.Cloudy
            ),
            arrayOf(
                "04n",
                WeatherConditions.Cloudy
            ),
            arrayOf(
                "04d",
                WeatherConditions.Cloudy
            ),
            arrayOf(
                "09n",
                WeatherConditions.Rainy
            ),
            arrayOf(
                "09d",
                WeatherConditions.Rainy
            ),
            arrayOf(
                "10n",
                WeatherConditions.Rainy
            ),
            arrayOf(
                "10d",
                WeatherConditions.Rainy
            ),
            arrayOf(
                "11n",
                WeatherConditions.Rainy
            ),
            arrayOf(
                "11d",
                WeatherConditions.Rainy
            ),
            arrayOf(
                "13n",
                WeatherConditions.Sunny
            ),
            arrayOf(
                "13d",
                WeatherConditions.Sunny
            ),
            arrayOf(
                "50n",
                WeatherConditions.Sunny
            ),
            arrayOf(
                "50d",
                WeatherConditions.Sunny
            )
        )
    }

    lateinit var classUnderTest: WeatherIconToConditionMapper

    @Before
    fun setUp() {
        classUnderTest = WeatherIconToConditionMapper()
    }

    @Test
    fun `Given icon When map then returns expected ui model`() {
        // When
        val actualResult = classUnderTest.map(input)

        // Then
        Assert.assertEquals(expectedResult, actualResult)
    }
}
