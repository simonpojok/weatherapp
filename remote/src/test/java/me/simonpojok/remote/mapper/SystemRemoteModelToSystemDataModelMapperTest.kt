package me.simonpojok.remote.mapper

import me.simonpojok.data.weather.model.SystemDataModel
import me.simonpojok.remote.weather.mapper.SystemRemoteModelToSystemDataModelMapper
import me.simonpojok.remote.weather.model.SystemRemoteModel
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class SystemRemoteModelToSystemDataModelMapperTest(
    private val input: SystemRemoteModel,
    private val expectedResult: SystemDataModel
) {

    companion object {
        @JvmStatic
        @Parameterized.Parameters(name = "Given {0} When toData Then returns {1}")
        fun params() = listOf(
            arrayOf(
                SystemRemoteModel(
                    type = 5,
                    id = 56,
                    country = "Uganda",
                    sunset = 56,
                    sunrise = 45
                ),
                SystemDataModel(
                    type = 5,
                    id = 56,
                    country = "Uganda",
                    sunset = 56,
                    sunrise = 45
                )
            )
        )
    }

    lateinit var classUnderTest: SystemRemoteModelToSystemDataModelMapper

    @Before
    fun setUp() {
        classUnderTest = SystemRemoteModelToSystemDataModelMapper()
    }

    @Test
    fun `Given remote model When toData then returns expected data model`() {
        // When
        val actualResult = classUnderTest.toData(input)

        // Then
        Assert.assertEquals(expectedResult, actualResult)
    }
}
