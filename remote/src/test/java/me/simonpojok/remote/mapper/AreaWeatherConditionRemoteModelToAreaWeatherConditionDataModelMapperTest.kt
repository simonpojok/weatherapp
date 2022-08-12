package me.simonpojok.remote.mapper

import me.simonpojok.data.weather.model.AreaWeatherConditionDataModel
import me.simonpojok.data.weather.model.CloudsDataModel
import me.simonpojok.data.weather.model.CoordinateDataModel
import me.simonpojok.data.weather.model.SystemDataModel
import me.simonpojok.data.weather.model.WeatherBreakDownDataModel
import me.simonpojok.data.weather.model.WeatherDataModel
import me.simonpojok.data.weather.model.WindDataModel
import me.simonpojok.remote.weather.mapper.AreaWeatherConditionRemoteModelToAreaWeatherConditionDataModelMapper
import me.simonpojok.remote.weather.mapper.CloudsRemoteModelToCloudsDataModelMapper
import me.simonpojok.remote.weather.mapper.CoordinateRemoteModelToCoordinateDataMapper
import me.simonpojok.remote.weather.mapper.SystemRemoteModelToSystemDataModelMapper
import me.simonpojok.remote.weather.mapper.WeatherBreakDownRemoteModelToWeatherBreakDownDataMapper
import me.simonpojok.remote.weather.mapper.WeatherRemoteModelToWeatherDataModelMapper
import me.simonpojok.remote.weather.mapper.WindRemoteModelToWindDataModelMapper
import me.simonpojok.remote.weather.model.AreaWeatherConditionRemoteModel
import me.simonpojok.remote.weather.model.CloudsRemoteModel
import me.simonpojok.remote.weather.model.CoordinateRemoteModel
import me.simonpojok.remote.weather.model.SystemRemoteModel
import me.simonpojok.remote.weather.model.WeatherBreakDownRemoteModel
import me.simonpojok.remote.weather.model.WeatherRemoteModel
import me.simonpojok.remote.weather.model.WindRemoteModel
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
    cod = 56,
    coord = CoordinateRemoteModel(
        lon = 783,
        lat = 100
    ),
    weather = WeatherRemoteModel(
        id = 100,
        main = "Main",
        description = "Nice Weather",
        icon = "image"
    ),
    base = "Uganda",
    main = WeatherBreakDownRemoteModel(
        temp = 67.0,
        feels_like = 56.8,
        temp_min = 56.0,
        temp_max = 12.0,
        pressure = 34.9,
        humidity = 45.0
    ),
    visibility = 89,
    wind = WindRemoteModel(
        speed = 90.67,
        deg = 90,
        gust = 354.0
    ),
    clouds = CloudsRemoteModel(
        all = 600
    ),
    dt = 89,
    sys = SystemRemoteModel(
        type = 5,
        id = 56,
        country = "Uganda",
        sunset = 56,
        sunrise = 45
    ),
    timezone = 89,
    id = 405,
    name = "Good Day",
)

val AREA_DATA_1 = AreaWeatherConditionDataModel(
    cod = 56,
    coord = CoordinateDataModel(
        lon = 783,
        lat = 100
    ),
    weather = WeatherDataModel(
        id = 100,
        main = "Main",
        description = "Nice Weather",
        icon = "image"
    ),
    base = "Uganda",
    main = WeatherBreakDownDataModel(
        temp = 67.0,
        feels_like = 56.8,
        temp_min = 56.0,
        temp_max = 12.0,
        pressure = 34.9,
        humidity = 45.0
    ),
    visibility = 89,
    wind = WindDataModel(
        speed = 90.67,
        deg = 90,
        gust = 354.0
    ),
    clouds = CloudsDataModel(
        all = 600
    ),
    dt = 89,
    sys = SystemDataModel(
        type = 5,
        id = 56,
        country = "Uganda",
        sunset = 56,
        sunrise = 45
    ),
    timezone = 89,
    id = 405,
    name = "Good Day",
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
    lateinit var coordinateRemoteMapper: CoordinateRemoteModelToCoordinateDataMapper

    @Mock
    lateinit var weatherRemoteMapper: WeatherRemoteModelToWeatherDataModelMapper

    @Mock
    lateinit var weatherBreakDataMapper: WeatherBreakDownRemoteModelToWeatherBreakDownDataMapper

    @Mock
    lateinit var cloudsRemoteMapper: CloudsRemoteModelToCloudsDataModelMapper

    @Mock
    lateinit var systemRemoteMapper: SystemRemoteModelToSystemDataModelMapper

    @Mock
    lateinit var windRemoteMapper: WindRemoteModelToWindDataModelMapper

    @Before
    fun setUp() {
        classUnderTest = AreaWeatherConditionRemoteModelToAreaWeatherConditionDataModelMapper(
            coordinateRemoteMapper,
            weatherRemoteMapper,
            weatherBreakDataMapper,
            cloudsRemoteMapper,
            systemRemoteMapper,
            windRemoteMapper
        )
    }

    @Test
    fun `Given remote model When toData then returns expected data model`() {
        // Given
        given(coordinateRemoteMapper.toData(input.coord))
            .willReturn(expectedResult.coord)

        given(weatherRemoteMapper.toData(input.weather))
            .willReturn(expectedResult.weather)

        given(weatherBreakDataMapper.toData(input.main))
            .willReturn(expectedResult.main)

        given(cloudsRemoteMapper.toData(input.clouds))
            .willReturn(expectedResult.clouds)

        given(systemRemoteMapper.toData(input.sys))
            .willReturn(expectedResult.sys)

        given(windRemoteMapper.toData(input.wind))
            .willReturn(expectedResult.wind)

        // When
        val actualResult = classUnderTest.toData(input)

        // Then
        Assert.assertEquals(expectedResult, actualResult)
    }
}
