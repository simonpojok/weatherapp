package me.simonpojok.remote.mapper

import me.simonpojok.data.weather.model.WindDataModel
import me.simonpojok.remote.weather.mapper.WindRemoteModelToWindDataModelMapper
import me.simonpojok.remote.weather.model.WindRemoteModel
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import org.junit.Assert.assertEquals

@RunWith(Parameterized::class)
class WindRemoteModelToWindDataModelMapperTest(
    private val input: WindRemoteModel,
    private val expectedResult: WindDataModel
) {
    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun parameters() = listOf(
            arrayOf(
                WindRemoteModel(
                    speed = 90.67,
                    deg = 90,
                    gust = 354.0
                ),
                WindDataModel(
                    speed = 90.67,
                    deg = 90,
                    gust = 354.0
                )
            ),
            arrayOf(
                WindRemoteModel(
                    speed = 900.67,
                    deg = 9088,
                    gust = 66354.0
                ),
                WindDataModel(
                    speed = 900.67,
                    deg = 9088,
                    gust = 66354.0
                )
            )
        )
    }

    private lateinit var classUnderTest: WindRemoteModelToWindDataModelMapper

    @Before
    fun setUp() {
        classUnderTest = WindRemoteModelToWindDataModelMapper()
    }

    @Test
    fun `Given remote model When toData then returns expected data model`(){
        // When
        val actualResult = classUnderTest.toData(input)

        // Then
        assertEquals(expectedResult, actualResult)
    }
}
