package me.simonpojok.remote.mapper

import me.simonpojok.data.weather.model.AreaWeatherConditionDataModel
import me.simonpojok.data.weather.model.WeatherBreakDownDataModel
import me.simonpojok.data.weather.model.WeatherDataModel
import me.simonpojok.remote.weather.mapper.AreaWeatherConditionRemoteModelToAreaWeatherConditionDataModelMapper
import me.simonpojok.remote.weather.mapper.WeatherBreakDownRemoteModelToWeatherBreakDownDataMapper
import me.simonpojok.remote.weather.mapper.WeatherRemoteModelToWeatherDataModelMapper
import me.simonpojok.remote.weather.model.AreaWeatherConditionRemoteModel
import me.simonpojok.remote.weather.model.WeatherBreakDownRemoteModel
import me.simonpojok.remote.weather.model.WeatherRemoteModel
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.MethodRule
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import org.mockito.BDDMockito.given
import org.mockito.Mock
import org.mockito.junit.MockitoJUnit

val AREA_REMOTE_1 = AreaWeatherConditionRemoteModel(
    weather = listOf(
        WeatherRemoteModel(
            id = 100,
            main = "Main",
            description = "Nice Weather",
            icon = "image"
        )
    ),
    main = WeatherBreakDownRemoteModel(
        temp = 67.0,
        feels_like = 56.8,
        temp_min = 56.0,
        temp_max = 12.0,
        pressure = 34.9,
        humidity = 45.0
    ),
    dt_txt = "2022",
    dt = 100L
)

val AREA_DATA_1 = AreaWeatherConditionDataModel(
    weather = listOf(
        WeatherDataModel(
            id = 100,
            main = "Main",
            description = "Nice Weather",
            icon = "image"
        )
    ),
    main = WeatherBreakDownDataModel(
        temp = 67.0,
        feels_like = 56.8,
        temp_min = 56.0,
        temp_max = 12.0,
        pressure = 34.9,
        humidity = 45.0
    ),
    dateTime = "2022",
    timestamp = 100L
)

@RunWith(Parameterized::class)
class AreaWeatherConditionRemoteModelToAreaWeatherConditionDataModelMapperTest(
    private val input: AreaWeatherConditionRemoteModel,
    private val expectedResult: AreaWeatherConditionDataModel
) {
    @get:Rule
    val mockitoRules: MethodRule = MockitoJUnit.rule()

    companion object {
        @JvmStatic
        @Parameterized.Parameters(name = "Given {0} When toData Then returns {1}")
        fun params() = listOf(
            arrayOf(
                AREA_REMOTE_1,
                AREA_DATA_1
            )
        )
    }

    lateinit var classUnderTest: AreaWeatherConditionRemoteModelToAreaWeatherConditionDataModelMapper

    @Mock
    lateinit var weatherRemoteMapper: WeatherRemoteModelToWeatherDataModelMapper

    @Mock
    lateinit var weatherBreakDataMapper: WeatherBreakDownRemoteModelToWeatherBreakDownDataMapper

    @Before
    fun setUp() {
        classUnderTest = AreaWeatherConditionRemoteModelToAreaWeatherConditionDataModelMapper(
            weatherRemoteMapper,
            weatherBreakDataMapper,
        )
    }

    @Test
    fun `Given remote model When toData then returns expected data model`() {
        // Given

        given(weatherRemoteMapper.toData(input.weather.first()))
            .willReturn(expectedResult.weather.first())

        given(weatherBreakDataMapper.toData(input.main))
            .willReturn(expectedResult.main)

        // When
        val actualResult = classUnderTest.toData(input)

        // Then
        Assert.assertEquals(expectedResult, actualResult)
    }
}
