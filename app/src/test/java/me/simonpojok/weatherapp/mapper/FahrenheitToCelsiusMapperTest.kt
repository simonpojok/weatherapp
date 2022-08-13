package me.simonpojok.weatherapp.mapper

import me.simonpojok.weatherapp.weather.mapper.FahrenheitToCelsiusMapper
import org.junit.Assert
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class FahrenheitToCelsiusMapperTest(
    private val input: Double,
    private val expectedResult: Double
) {
    companion object {
        @JvmStatic
        @Parameterized.Parameters(name = "Given {0} When toUi Then returns {1}")
        fun params() = listOf(
            arrayOf(
                32.0,
                0
            ),
            arrayOf(
                100.0,
                37.7778
            ),
            arrayOf(
                10089.0,
                5587.2222
            )
        )
    }

    lateinit var classUnderTest: FahrenheitToCelsiusMapper

    @Before
    fun setUp() {
        classUnderTest = FahrenheitToCelsiusMapper()
    }

    @Test
    fun `Given Fahrenheit When toUi then returns Celsius`() {
        // When
        val actualResult = classUnderTest.toUi(input)

        // Then
        assertEquals(expectedResult, actualResult, 2.0)
    }
}
