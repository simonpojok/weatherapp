package me.simonpojok.remote.mapper

import me.simonpojok.data.weather.model.WeatherDataModel
import me.simonpojok.remote.weather.mapper.WeatherRemoteModelToWeatherDataModelMapper
import me.simonpojok.remote.weather.model.WeatherRemoteModel
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class WeatherRemoteModelToWeatherDataModelMapperTest(
    private val input: WeatherRemoteModel,
    private val expectedResult: WeatherDataModel,
) {

    companion object {
        @JvmStatic
        @Parameterized.Parameters(name = "Given {0} When toData Then returns {1}")
        fun params() = listOf(
            arrayOf(
                WeatherRemoteModel(
                    id = 100,
                    main = "Main",
                    description = "Nice Weather",
                    icon = "image"
                ),
                WeatherDataModel(
                    id = 100,
                    main = "Main",
                    description = "Nice Weather",
                    icon = "image"
                )
            ),
            arrayOf(
                WeatherRemoteModel(
                    id = 10011,
                    main = "Main_Market",
                    description = "Nice Weather",
                    icon = "image2"
                ),
                WeatherDataModel(
                    id = 10011,
                    main = "Main_Market",
                    description = "Nice Weather",
                    icon = "image2"
                )
            )
        )
    }

    lateinit var classUnderTest: WeatherRemoteModelToWeatherDataModelMapper

    @Before
    fun setUp() {
        classUnderTest = WeatherRemoteModelToWeatherDataModelMapper()
    }

    @Test
    fun `Given remote model When toData then returns expected data model`() {
        // When
        val actualResult = classUnderTest.toData(input)

        // Then
        Assert.assertEquals(expectedResult, actualResult)
    }
}
