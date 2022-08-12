package me.simonpojok.remote.mapper

import me.simonpojok.data.weather.model.CloudsDataModel
import me.simonpojok.remote.weather.mapper.CloudsRemoteModelToCloudsDataModelMapper
import me.simonpojok.remote.weather.model.CloudsRemoteModel
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class CloudsRemoteModelToCloudsDataModelMapperTest(
    private val input: CloudsRemoteModel,
    private val expectedResult: CloudsDataModel
) {

    companion object {
        @JvmStatic
        @Parameterized.Parameters(name = "Given {0} When toData Then returns {1}")
        fun params() = listOf(
            arrayOf(
                CloudsRemoteModel(
                    all = 600
                ),
                CloudsDataModel(
                    all = 600
                )
            ),
            arrayOf(
                CloudsRemoteModel(
                    all = 6001
                ),
                CloudsDataModel(
                    all = 6001
                )
            )
        )
    }

    lateinit var classUnderTest: CloudsRemoteModelToCloudsDataModelMapper

    @Before
    fun setUp() {
        classUnderTest = CloudsRemoteModelToCloudsDataModelMapper()
    }

    @Test
    fun `Given remote model When toData then returns expected data model`() {
        // When
        val actualResult = classUnderTest.toData(input)

        // Then
        Assert.assertEquals(expectedResult, actualResult)
    }
}
